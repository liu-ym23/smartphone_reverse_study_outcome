package com.ttnet.org.chromium.net.urlconnection;

import android.net.TrafficStats;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.mira.log.MiraMonitor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.Logger;
import com.ttnet.org.chromium.base.ParamChecker;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.ExperimentalUrlRequest;
import com.ttnet.org.chromium.net.NetworkException;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.UrlRequest;
import com.ttnet.org.chromium.net.UrlResponseInfo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.CookieHandler;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.conn.ConnectTimeoutException;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class CronetHttpURLConnection extends HttpURLConnection {
    private static final String BYPASS_COOKIE_HEADER = "x-ttnet-bypass-cookie";
    private static final String CONTENT_LENGTH = "Content-Length";
    private static final int DO_NOT_SEND_COOKIE = 2;
    private static final String GET_REQUEST_COOKIE_SOURCE_FLAG = "x-tt-get-cookie-source";
    public static final String SS_COOKIE = "X-SS-Cookie";
    private static final String TAG = null;
    private static final String TT_COOKIE_REL_METRIC_FLAG = "x-tt-cookie-rel-metric";
    private static final String WEBVIEW_COOKIE = "webview-origin-url";
    private static final int WEBVIEW_REQUEST = 1;
    private static final String WEBVIEW_REQUEST_FLAG = "x-tt-webview-request";
    private String mAuthCertPassword;
    private String mAuthCertUsername;
    private CookieHandler mCookieHandler;
    private String mCookieRelMetric;
    private final CronetEngine mCronetEngine;
    private final AtomicBoolean mDisconnected;
    private IOException mException;
    private boolean mFixCancelRequestReport;
    private boolean mHasResponseHeadersOrCompleted;
    private CronetInputStream mInputStream;
    private int mInputStreamBufferSize;
    private final MessageLoop mMessageLoop;
    private boolean mOnRedirectCalled;
    private CronetOutputStream mOutputStream;
    private int mOutputStreamBufferSize;
    private UrlRequest mRequest;
    private final AtomicBoolean mRequestCompleted;
    private int mRequestCookieSource;
    private RequestFinishedInfo.Listener mRequestFinishedListener;
    private int mRequestFlag;
    private final List<Pair<String, String>> mRequestHeaders;
    private int mRequestPriority;
    private int mRequestTimeout;
    private int mRequestTypeFlags;
    private List<Map.Entry<String, String>> mResponseHeadersList;
    private Map<String, List<String>> mResponseHeadersMap;
    private UrlResponseInfo mResponseInfo;
    private int mSocketConnectTimeout;
    private int mSocketReadTimeout;
    private int mSocketWriteTimeout;
    private long mThrottleNetSpeed;
    private int mTrafficStatsTag;
    private boolean mTrafficStatsTagSet;
    private int mTrafficStatsUid;
    private boolean mTrafficStatsUidSet;

    public void enableFixCancelRequestReport() {
        this.mFixCancelRequestReport = true;
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        getResponse();     // Catch: IOException -> L8
        if (this.mResponseInfo.getHttpStatusCode() >= 400) goto L7;
        return null;
    L7:
        return this.mInputStream;
    L12:
        return null;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    static {
        TAG = "CronetHttpURLConnection";
    }

    private void checkHasResponseHeaders() throws IOException {
        if (this.mHasResponseHeadersOrCompleted == false) goto L13;
        IOException r0 = this.mException;
        if (r0 == null) goto L7;
        throw r0;
    L7:
        if (this.mResponseInfo == null) goto L10;
        return;
    L10:
        throw new NullPointerException("Response info is null when there is no exception.");
    L13:
        throw new IllegalStateException("No response.");
    }

    private boolean checkTrafficStatsTag() {
        if (this.mTrafficStatsTagSet == false) goto L5;
        return true;
    L5:
        int r0 = TrafficStats.getThreadStatsTag();
        if (r0 == (-1)) goto L9;
        this.mTrafficStatsTag = r0;
        this.mTrafficStatsTagSet = true;
    L9:
        return this.mTrafficStatsTagSet;
    }

    private boolean checkTrafficStatsUid() {
        if (this.mTrafficStatsUidSet == false) goto L6;
        return true;
    L6:
        if (Build.VERSION.SDK_INT >= 28) goto L9;
        return false;
    L9:
        int r0 = TrafficStats.getThreadStatsUid();
        if (r0 == (-1)) goto L13;
        this.mTrafficStatsUid = r0;
        this.mTrafficStatsUidSet = true;
    L13:
        return this.mTrafficStatsUidSet;
    }

    private Map<String, List<String>> getAllHeaders() {
        Map<String, List<String>> r0 = this.mResponseHeadersMap;
        if (r0 == null) goto L5;
        return r0;
    L5:
        TreeMap r1 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator<Map.Entry<String, String>> r2 = getAllHeadersAsList().iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        Map.Entry<String, String> r3 = r2.next();
        ArrayList r4 = new ArrayList();
        if (r1.containsKey(r3.getKey()) == false) goto L11;
        r4.addAll((Collection) r1.get(r3.getKey()));
    L11:
        r4.add(r3.getValue());
        r1.put(r3.getKey(), Collections.unmodifiableList(r4));
        goto L7
    L12:
        Map<String, List<String>> r5 = Collections.unmodifiableMap(r1);
        this.mResponseHeadersMap = r5;
        return r5;
    }

    private List<Map.Entry<String, String>> getAllHeadersAsList() {
        List<Map.Entry<String, String>> r0 = this.mResponseHeadersList;
        if (r0 == null) goto L5;
        return r0;
    L5:
        this.mResponseHeadersList = new ArrayList();
        Iterator r1 = this.mResponseInfo.getAllHeadersAsList().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Map.Entry r2 = (Map.Entry) r1.next();
        this.mResponseHeadersList.add(new AbstractMap.SimpleImmutableEntry(r2));
        goto L7
    L9:
        List<Map.Entry<String, String>> r3 = Collections.unmodifiableList(this.mResponseHeadersList);
        this.mResponseHeadersList = r3;
        return r3;
    }

    private void getResponse() throws IOException {
        CronetOutputStream r0 = this.mOutputStream;
        if (r0 == null) goto L8;
        r0.checkReceivedEnoughContent();
        if (isChunkedUpload() == false) goto L8;
        this.mOutputStream.close();
    L8:
        if (this.mHasResponseHeadersOrCompleted == true) goto L13;
        startRequest();
        if (Logger.debug() == false) goto L12;
        Logger.d("CronetHttpURLConnection", "getResponse loop url = " + getURL().toString());
    L12:
        executeMessageLoop(getConnectTimeout() + getReadTimeout());
        this.mHasResponseHeadersOrCompleted = true;
    L13:
        checkHasResponseHeaders();
    }

    private long getStreamingModeContentLength() {
        long r0 = ((HttpURLConnection) this).fixedContentLength;
        long r2 = ((HttpURLConnection) this).fixedContentLengthLong;
        if (r2 != (-1)) goto L5;
        return r0;
    L5:
        return r2;
    }

    private boolean isAllowCredentials() {
        String r0 = getRequestProperty(BYPASS_COOKIE_HEADER);
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return true;
    L5:
        if (MiraMonitor.VALUE_DEFAULT.equals(r0) == false) goto L10;
        return false;
    L10:
        return true;
    }

    private boolean isChunkedUpload() {
        if (((HttpURLConnection) this).chunkLength <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void startRequest() throws IOException {
        if (((HttpURLConnection) this).connected == false) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("CronetHttpURLConnection", "start request url = " + getURL().toString());
    L8:
        ExperimentalUrlRequest.Builder r0 = this.mCronetEngine.newUrlRequestBuilder(getURL().toString(), new CronetUrlRequestCallback(this), this.mMessageLoop);
        if (((HttpURLConnection) this).doOutput == true) goto L11;
    L27:
        long r1 = System.nanoTime();
        Map<String, String> r3 = GetCookieMap(uri(getURL()));
        if (r3 != null) goto L30;
    L35:
        long r4 = (System.nanoTime() - r1) / 1000;
        Iterator<Pair<String, String>> r2 = this.mRequestHeaders.iterator();
    L37:
        if (r2.hasNext() == false) goto L40;
        Pair<String, String> r5 = r2.next();
        r0.addHeader((String) r5.first, (String) r5.second);
        goto L37
    L40:
        if (getUseCaches() == true) goto L42;
        r0.disableCache();
    L42:
        r0.setHttpMethod(((HttpURLConnection) this).method);
        if (checkTrafficStatsTag() == false) goto L46;
        r0.setTrafficStatsTag(this.mTrafficStatsTag);
    L46:
        if (checkTrafficStatsUid() == false) goto L48;
        r0.setTrafficStatsUid(this.mTrafficStatsUid);
    L48:
        r0.setPriority(this.mRequestPriority);
        r0.setSocketConnectTimeout(this.mSocketConnectTimeout);
        r0.setSocketReadTimeout(this.mSocketReadTimeout);
        r0.setSocketWriteTimeout(this.mSocketWriteTimeout);
        r0.setRequestTimeout(this.mRequestTimeout);
        r0.setRequestFinishedListener(this.mRequestFinishedListener);
        ExperimentalUrlRequest r6 = r0.build();
        this.mRequest = r6;
        int r7 = this.mRequestFlag;
        if (r7 == 0) goto L51;
        r6.setRequestFlag(r7);
    L51:
        int r8 = this.mRequestTypeFlags;
        if (r8 <= 0) goto L54;
        this.mRequest.setRequestTypeFlags(r8);
    L54:
        String r9 = this.mAuthCertUsername;
        if (r9 == null) goto L59;
        String r10 = this.mAuthCertPassword;
        if (r10 == null) goto L59;
        this.mRequest.setAuthCredentials(r9, r10);
    L59:
        this.mRequest.setAddCookieCostUs(r4);
        this.mRequest.setRequestCookieSource(this.mRequestCookieSource);
        this.mRequest.setCookieRelMetric(this.mCookieRelMetric);
        this.mRequest.start();
        long r11 = this.mThrottleNetSpeed;
        if (r11 <= 0) goto L62;
        this.mRequest.setThrottleNetSpeed(r11);
    L62:
        ((HttpURLConnection) this).connected = true;
        return;
    L30:
        if (r3.isEmpty() == true) goto L35;
        Iterator<Map.Entry<String, String>> r12 = r3.entrySet().iterator();
    L33:
        if (r12.hasNext() == false) goto L35;
        Map.Entry<String, String> r13 = r12.next();
        r0.addHeader(r13.getKey(), r13.getValue());
        goto L33
    L11:
        if (((HttpURLConnection) this).method.equals("GET") == false) goto L13;
        ((HttpURLConnection) this).method = "POST";
    L13:
        CronetOutputStream r14 = this.mOutputStream;
        if (r14 == null) goto L22;
        r0.setUploadDataProvider(r14.getUploadDataProvider(), this.mMessageLoop);
        if (getRequestProperty(CONTENT_LENGTH) == null) goto L18;
    L20:
        this.mOutputStream.setConnected();
    L25:
        if (getRequestProperty("Content-Type") != null) goto L27;
        addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        goto L27
    L18:
        if (isChunkedUpload() == true) goto L20;
        addRequestProperty(CONTENT_LENGTH, Long.toString(this.mOutputStream.getUploadDataProvider().getLength()));
        goto L20
    L22:
        if (getRequestProperty(CONTENT_LENGTH) != null) goto L25;
        addRequestProperty(CONTENT_LENGTH, MiraMonitor.VALUE_DEFAULT);
        goto L25
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (((HttpURLConnection) this).connected == false) goto L27;
        UrlRequest r0 = this.mRequest;
        if (r0 == null) goto L28;
        r0.cancel();
    L22:
        e = move-exception;
        e.printStackTrace();
        return;
    L8:
        if (this.mDisconnected.compareAndSet(false, true) == true) goto L11;
        return;
    L11:
        if (this.mFixCancelRequestReport == true) goto L14;
        return;
    L14:
        if (this.mRequestCompleted.get() == false) goto L17;
        return;
    L17:
        if (this.mMessageLoop.onValidThread() == true) goto L19;
        return;
    L19:
        if (this.mMessageLoop.isRunning() == true) goto L30;
        this.mMessageLoop.loop(50);     // Catch: Exception -> L22
        return;
    L30:
        return;
    L28:
        return;
    }

    public int getCronetInternalErrorCode() {
        NetworkException r0 = this.mException;
        if ((r0 instanceof NetworkException) == false) goto L7;
        return r0.getCronetInternalErrorCode();
    L7:
        if ((r0 instanceof TTRequestCanceledException) == true) goto L9;
        return 0;
    L9:
        return ((TTRequestCanceledException) r0).getCronetInternalErrorCode();
    }

    public String getFinalUrl() {
        return this.mRequest.getFinalUrl();
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.mOutputStream != null) goto L27;
        if (((HttpURLConnection) this).doOutput == false) goto L27;
        if (((HttpURLConnection) this).connected == true) goto L25;
        if (isChunkedUpload() == false) goto L11;
        this.mOutputStream = new CronetChunkedOutputStream(this, ((HttpURLConnection) this).chunkLength, this.mMessageLoop);
        startRequest();
        goto L27
    L11:
        long r0 = getStreamingModeContentLength();
        if (r0 == (-1)) goto L20;
        CronetFixedModeOutputStream r2 = new CronetFixedModeOutputStream(this, r0, this.mOutputStreamBufferSize, this.mMessageLoop);
        this.mOutputStream = r2;
        if (r0 != 0) goto L19;
        setFixedLengthStreamingMode((int) r2.getUploadDataProvider().getLength());
        if (getRequestProperty(CONTENT_LENGTH) != null) goto L18;
        addRequestProperty(CONTENT_LENGTH, Long.toString(this.mOutputStream.getUploadDataProvider().getLength()));
        goto L19
    L18:
        setRequestProperty(CONTENT_LENGTH, Long.toString(this.mOutputStream.getUploadDataProvider().getLength()));
    L19:
        startRequest();
        goto L27
    L20:
        Log.d(TAG, "Outputstream is being buffered in memory.", new Object[0]);
        String r1 = getRequestProperty(CONTENT_LENGTH);
        if (r1 != null) goto L23;
        this.mOutputStream = new CronetBufferedOutputStream(this);
        goto L27
    L23:
        this.mOutputStream = new CronetBufferedOutputStream(this, CastLongProtector.parseLong(r1));
        goto L27
    L25:
        throw new ProtocolException("Cannot write to OutputStream after receiving response.");
    L27:
        return this.mOutputStream;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        if (((HttpURLConnection) this).connected == true) goto L15;
        TreeMap r0 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator<Pair<String, String>> r1 = this.mRequestHeaders.iterator();
    L6:
        if (r1.hasNext() == false) goto L13;
        Pair<String, String> r2 = r1.next();
        if (r0.containsKey(r2.first) == true) goto L11;
        ArrayList r3 = new ArrayList();
        r3.add((String) r2.second);
        r0.put((String) r2.first, Collections.unmodifiableList(r3));
        goto L6
    L11:
        throw new IllegalStateException("Should not have multiple values.");
    L13:
        return Collections.unmodifiableMap(r0);
    L15:
        throw new IllegalStateException("Cannot access request headers after connection is set.");
    }

    public void onUploadTimeout() {
        UrlRequest r0 = this.mRequest;
        if (r0 == null) goto L6;
        r0.appTimeout();
        return;
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        startRequest();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        getResponse();     // Catch: IOException -> L5
        return getAllHeaders();
    L6:
        return Collections.emptyMap();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        getResponse();
        if (((HttpURLConnection) this).instanceFollowRedirects == true) goto L10;
        if (this.mOnRedirectCalled == false) goto L10;
        throw new IOException("Cannot read response body of a redirect.");
    L10:
        if (this.mResponseInfo.getHttpStatusCode() >= 400) goto L14;
        return this.mInputStream;
    L14:
        throw new FileNotFoundException(((HttpURLConnection) this).url.toString());
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        getResponse();
        return this.mResponseInfo.getHttpStatusCode();
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        getResponse();
        return this.mResponseInfo.getHttpStatusText();
    }

    public int getInputStreamBufferSize() {
        return this.mInputStreamBufferSize;
    }

    private Map<String, String> GetCookieMap(URI r10) {
        HashMap r0 = new HashMap();
        if ((this.mRequestTypeFlags & 2) > 0) goto L67;
        if (isAllowCredentials() == false) goto L67;
        HashMap r1 = new HashMap();
        List<Pair<String, String>> r2 = this.mRequestHeaders;
        if (r2 == null) goto L16;
        Iterator<Pair<String, String>> r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L16;
        Pair<String, String> r4 = r3.next();
        String r5 = (String) r4.first;
        String r6 = (String) r4.second;
        List r7 = (List) r1.get(r5);
        if (r7 != null) goto L15;
        r7 = new LinkedList();
    L15:
        r7.add(r6);
        r1.put(r5, r7);
    L16:
        r1.put(GET_REQUEST_COOKIE_SOURCE_FLAG, new LinkedList());
        r1.put(TT_COOKIE_REL_METRIC_FLAG, new LinkedList());
        if ((this.mRequestTypeFlags & 1) == 0) goto L19;
        r1.put(WEBVIEW_REQUEST_FLAG, new LinkedList());
    L19:
        Map<String, List<String>> r8 = null;
    L27:
        e = move-exception;
        if (Logger.debug() == false) goto L31;
        Logger.d(TAG, "Loading cookies failed for " + getURL().toString() + " e = " + e.getMessage());
    L31:
        if (r8 != null) goto L33;
    L65:
        return r0;
    L33:
        if (r8.size() <= 0) goto L65;
        Iterator<Map.Entry<String, List<String>>> r11 = r8.entrySet().iterator();
    L36:
        if (r11.hasNext() == false) goto L65;
        Map.Entry<String, List<String>> r9 = r11.next();
        String r12 = r9.getKey();
        int r13 = 0;
        if (GET_REQUEST_COOKIE_SOURCE_FLAG.equals(r12) == false) goto L45;
        if (r9.getValue().isEmpty() == true) goto L45;
        this.mRequestCookieSource = CastIntegerProtector.parseInt((String) ListProtector.get(r9.getValue(), 0));     // Catch: Throwable -> L43
    L49:
        StringBuilder r14 = new StringBuilder();
        if (SS_COOKIE.equalsIgnoreCase(r12) == true) goto L56;
        if ("Cookie".equalsIgnoreCase(r12) == true) goto L56;
        if ("Cookie2".equalsIgnoreCase(r12) == false) goto L36;
    L56:
        if (r9.getValue().isEmpty() == true) goto L36;
        Iterator<String> r15 = r9.getValue().iterator();
    L59:
        if (r15.hasNext() == false) goto L64;
        String r16 = r15.next();
        if (r13 <= 0) goto L63;
        r14.append("; ");
    L63:
        r14.append(r16);
        r13 = r13 + 1;
        goto L59
    L64:
        r0.put(r12, r14.toString());
    L43:
        this.mRequestCookieSource = -1;
    L45:
        if (TT_COOKIE_REL_METRIC_FLAG.equals(r12) == false) goto L49;
        if (r9.getValue().isEmpty() == true) goto L49;
        this.mCookieRelMetric = (String) ListProtector.get(r9.getValue(), 0);
        goto L49
    L21:
        if (this.mCookieHandler != null) goto L23;
        this.mCookieHandler = CookieHandler.getDefault();     // Catch: Exception -> L27
    L23:
        CookieHandler r17 = this.mCookieHandler;     // Catch: Exception -> L27
        if (r17 == null) goto L31;
        r8 = r17.get(r10, r1);     // Catch: Exception -> L27
    L67:
        if (Logger.debug() == false) goto L69;
        Logger.d(TAG, "Do not read cookie from TTNet, url:" + r10);
    L69:
        return r0;
    }

    public static /* synthetic */ UrlResponseInfo access$000(CronetHttpURLConnection r0) {
        return r0.mResponseInfo;
    }

    public static /* synthetic */ UrlRequest access$1000(CronetHttpURLConnection r0) {
        return r0.mRequest;
    }

    public static /* synthetic */ IOException access$1200(CronetHttpURLConnection r0) {
        return r0.mException;
    }

    public static /* synthetic */ CronetInputStream access$1400(CronetHttpURLConnection r0) {
        return r0.mInputStream;
    }

    public static /* synthetic */ CronetOutputStream access$1500(CronetHttpURLConnection r0) {
        return r0.mOutputStream;
    }

    public static /* synthetic */ AtomicBoolean access$1600(CronetHttpURLConnection r0) {
        return r0.mRequestCompleted;
    }

    public static /* synthetic */ Map access$200(CronetHttpURLConnection r0) {
        return r0.getAllHeaders();
    }

    public static /* synthetic */ MessageLoop access$400(CronetHttpURLConnection r0) {
        return r0.mMessageLoop;
    }

    public static /* synthetic */ boolean access$500(CronetHttpURLConnection r0) {
        return r0.mOnRedirectCalled;
    }

    public static /* synthetic */ URL access$600(CronetHttpURLConnection r0) {
        return ((HttpURLConnection) r0).url;
    }

    public static /* synthetic */ boolean access$700(CronetHttpURLConnection r0) {
        return ((HttpURLConnection) r0).instanceFollowRedirects;
    }

    public static /* synthetic */ boolean access$900(CronetHttpURLConnection r0) {
        return ((HttpURLConnection) r0).instanceFollowRedirects;
    }

    private void executeMessageLoop(int r3) throws IOException {
        this.mMessageLoop.loop(r3);     // Catch: Exception -> L4 SocketTimeoutException -> L6
    L14:
        return;
    L6:
        UrlRequest r0 = this.mRequest;
        if (r0 == null) goto L13;
        r0.appTimeout();
        this.mMessageLoop.reset();
        this.mMessageLoop.loop(r3 / 2);
        return;
    L13:
        return;
    L4:
        e = move-exception;
        cancelWithException("Unexpected request usage, caught in CronetHttpURLConnection.", e);
        this.mMessageLoop.reset();
        this.mMessageLoop.loop(r3 / 2);
    }

    private int findRequestProperty(String r3) {
        int r0 = 0;
    L4:
        if (r0 >= this.mRequestHeaders.size()) goto L9;
        if (((String) ((Pair) ListProtector.get(this.mRequestHeaders, r0)).first).equalsIgnoreCase(r3) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    private Map.Entry<String, String> getHeaderFieldEntry(int r4) {
        getResponse();     // Catch: IOException -> L9
        List<Map.Entry<String, String>> r1 = getAllHeadersAsList();
        if (r4 < r1.size()) goto L8;
        return null;
    L8:
        return (Map.Entry) ListProtector.get(r1, r4);
    L9:
        return null;
    }

    private IOException tryConvertCronetException(CronetException r4) {
        if ((r4 instanceof NetworkException) == true) goto L6;
        return r4;
    L6:
        switch(((NetworkException) r4).getErrorCode()) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L17;
        };
    L8:
        IOException r0 = new NoRouteToHostException(r4.getMessage());
    L16:
        return r0;
    L9:
        r0 = new SocketException("reset by peer " + r4.getMessage());
        goto L16
    L10:
        r0 = new ConnectTimeoutException(r4.getMessage());
        goto L16
    L11:
        r0 = new ConnectException(r4.getMessage());
        goto L16
    L12:
        r0 = new SocketTimeoutException(r4.getMessage());
        goto L16
    L13:
        r0 = new ConnectException(r4.getMessage());
        goto L16
    L14:
        r0 = new UnknownHostException(r4.getMessage());
        goto L16
    L17:
        return r4;
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String r4) {
        getResponse();     // Catch: IOException -> L9
        Map<String, List<String>> r1 = getAllHeaders();
        if (r1.containsKey(r4) == true) goto L7;
        return null;
    L7:
        List<String> r5 = r1.get(r4);
        return (String) ListProtector.get(r5, r5.size() - 1);
    L9:
        return null;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int r1) {
        Map.Entry<String, String> r2 = getHeaderFieldEntry(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getKey();
    }

    public void getMoreData(ByteBuffer r2) throws IOException {
        UrlRequest r0 = this.mRequest;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.read(r2);
        executeMessageLoop(getReadTimeout());
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String r2) {
        int r3 = findRequestProperty(r2);
        if (r3 >= 0) goto L5;
        return null;
    L5:
        return (String) ((Pair) ListProtector.get(this.mRequestHeaders, r3)).second;
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int r1) {
        super.setConnectTimeout(r1);
    }

    public void setInputStreamBufferSize(int r1) {
        this.mInputStreamBufferSize = r1;
    }

    public void setOutputStreamBufferSize(int r1) {
        this.mOutputStreamBufferSize = r1;
    }

    public void setRequestFinishedListener(RequestFinishedInfo.Listener r1) {
        this.mRequestFinishedListener = r1;
    }

    public void setRequestFlag(int r1) {
        this.mRequestFlag = r1;
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String r2) throws ProtocolException {
        if ("PATCH".equals(r2) == true) goto L5;
        super.setRequestMethod(r2);
        return;
    L5:
        if (((HttpURLConnection) this).connected == true) goto L8;
        ((HttpURLConnection) this).method = r2;
        return;
    L8:
        throw new ProtocolException("Can't reset method: already connected");
    }

    public void setRequestPriority(int r1) {
        this.mRequestPriority = r1;
    }

    public void setRequestTimeout(int r1) {
        this.mRequestTimeout = r1;
    }

    public void setRequestTypeFlags(int r2) {
        this.mRequestTypeFlags = r2 | this.mRequestTypeFlags;
    }

    public void setSocketConnectTimeout(int r1) {
        this.mSocketConnectTimeout = r1;
    }

    public void setSocketReadTimeout(int r1) {
        this.mSocketReadTimeout = r1;
    }

    public void setSocketWriteTimeout(int r1) {
        this.mSocketWriteTimeout = r1;
    }

    public void setThrottleNetSpeed(long r2) {
        this.mThrottleNetSpeed = r2;
        UrlRequest r0 = this.mRequest;
        if (r0 == null) goto L6;
        r0.setThrottleNetSpeed(r2);
        return;
    }

    public void setTrafficStatsTag(int r2) {
        if (((HttpURLConnection) this).connected == true) goto L7;
        this.mTrafficStatsTagSet = true;
        this.mTrafficStatsTag = r2;
        return;
    L7:
        throw new IllegalStateException("Cannot modify traffic stats tag after connection is made.");
    }

    public void setTrafficStatsUid(int r2) {
        if (((HttpURLConnection) this).connected == true) goto L7;
        this.mTrafficStatsUidSet = true;
        this.mTrafficStatsUid = r2;
        return;
    L7:
        throw new IllegalStateException("Cannot modify traffic stats UID after connection is made.");
    }

    public URI uri(URL r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        String r5 = r4.toString();
        return new URI(r5);
    L8:
        e = move-exception;
        return URI.create(r5.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", XmlPullParser.NO_NAMESPACE));
    L11:
        return URI.create(r5.substring(0, r5.indexOf("?")));
    L14:
        throw new RuntimeException(e);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int r1) {
        Map.Entry<String, String> r2 = getHeaderFieldEntry(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getValue();
    }

    public static /* synthetic */ UrlResponseInfo access$002(CronetHttpURLConnection r0, UrlResponseInfo r1) {
        r0.mResponseInfo = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$102(CronetHttpURLConnection r0, boolean r1) {
        r0.mHasResponseHeadersOrCompleted = r1;
        return r1;
    }

    public static /* synthetic */ Map access$1100(CronetHttpURLConnection r0, URI r1) {
        return r0.GetCookieMap(r1);
    }

    public static /* synthetic */ IOException access$1202(CronetHttpURLConnection r0, IOException r1) {
        r0.mException = r1;
        return r1;
    }

    public static /* synthetic */ IOException access$1300(CronetHttpURLConnection r0, CronetException r1) {
        return r0.tryConvertCronetException(r1);
    }

    public static /* synthetic */ boolean access$502(CronetHttpURLConnection r0, boolean r1) {
        r0.mOnRedirectCalled = r1;
        return r1;
    }

    public static /* synthetic */ URL access$802(CronetHttpURLConnection r0, URL r1) {
        ((HttpURLConnection) r0).url = r1;
        return r1;
    }

    private void saveResponseCookie(String r4, Map<String, List<String>> r5) {
        if (isAllowCredentials() == true) goto L9;
        if (Logger.debug() == false) goto L37;
        Logger.d(TAG, "Do not write cookie from TTNet, url:" + r4);
        return;
    L37:
        return;
    L9:
        if (Logger.debug() == false) goto L36;
        String r0 = TAG;
        StringBuilder r1 = new StringBuilder("Saving cookies for url: ");
        if (TextUtils.isEmpty(r4) == false) goto L13;
        String r2 = getURL().toString();
    L14:
        r1.append(r2);
        Logger.d(r0, r1.toString());
        goto L36
    L13:
        r2 = r4;
    L36:
    L28:
        e = move-exception;
        if (Logger.debug() == false) goto L41;
        String r3 = TAG;
        StringBuilder r6 = new StringBuilder("Saving cookies failed for ");
        if (TextUtils.isEmpty(r4) == false) goto L34;
        r4 = getURL().toString();
    L34:
        r6.append(r4);
        r6.append(" e = ");
        r6.append(e.getMessage());
        Logger.d(r3, r6.toString());
        return;
    L41:
        return;
    L16:
        if (this.mCookieHandler != null) goto L19;
        this.mCookieHandler = CookieHandler.getDefault();     // Catch: Exception -> L28
    L19:
        if (this.mCookieHandler != null) goto L21;
        return;
    L21:
        if (TextUtils.isEmpty(r4) == false) goto L23;
        this.mCookieHandler.put(uri(getURL()), r5);     // Catch: Exception -> L28
        return;
    L23:
        URI r7 = uri(new URL(r4));     // Catch: Exception -> L28
        if ((this.mRequestTypeFlags & 1) == 0) goto L26;
        TreeMap r8 = new TreeMap(r5);     // Catch: Exception -> L28
        r8.put(WEBVIEW_COOKIE, Collections.singletonList(getURL().getHost()));     // Catch: Exception -> L28
        this.mCookieHandler.put(r7, r8);     // Catch: Exception -> L28
        return;
    L26:
        this.mCookieHandler.put(r7, r5);     // Catch: Exception -> L28
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String r2, String r3) {
        setRequestPropertyInternal(r2, r3, false);
    }

    public void cancelWithException(String r2, Throwable r3) {
        UrlRequest r0 = this.mRequest;
        if (r0 == null) goto L6;
        r0.cancelWithException(r2, r3);
        return;
    }

    public void configureConnection(String r6, Object... r7) {
        r6.getClass();
        byte r4 = -1;
        switch(r6.hashCode()) {
            case -2098478356: goto L50;
            case -1400774487: goto L46;
            case -1262337831: goto L42;
            case -976756188: goto L38;
            case -722926986: goto L34;
            case -534987466: goto L30;
            case -107284268: goto L26;
            case 166051698: goto L22;
            case 423591456: goto L18;
            case 1221363607: goto L14;
            case 1880243345: goto L10;
            case 2141877079: goto L6;
            default: goto L53;
        };
    L53:
        switch(r4) {
            case 0: goto L69;
            case 1: goto L68;
            case 2: goto L67;
            case 3: goto L66;
            case 4: goto L63;
            case 5: goto L62;
            case 6: goto L61;
            case 7: goto L60;
            case 8: goto L59;
            case 9: goto L58;
            case 10: goto L57;
            case 11: goto L56;
            default: goto L55;
        };
    L56:
        ParamChecker.check(new Class[0], r7);
        this.mFixCancelRequestReport = true;
        return;
    L57:
        ParamChecker.check(new Class[]{Integer.TYPE}, r7);
        this.mRequestPriority = ((Integer) r7[0]).intValue();
        return;
    L58:
        ParamChecker.check(new Class[]{Integer.TYPE}, r7);
        this.mSocketWriteTimeout = ((Integer) r7[0]).intValue();
        return;
    L59:
        ParamChecker.check(new Class[]{Integer.TYPE}, r7);
        this.mRequestTypeFlags = ((Integer) r7[0]).intValue();
        return;
    L60:
        ParamChecker.check(new Class[]{String.class, String.class}, r7);
        this.mAuthCertUsername = (String) r7[0];
        this.mAuthCertPassword = (String) r7[1];
        return;
    L61:
        ParamChecker.check(new Class[]{Integer.TYPE}, r7);
        this.mRequestTimeout = ((Integer) r7[0]).intValue();
        return;
    L62:
        ParamChecker.check(new Class[]{Integer.TYPE}, r7);
        this.mSocketReadTimeout = ((Integer) r7[0]).intValue();
        return;
    L63:
        ParamChecker.check(new Class[]{Long.TYPE}, r7);
        long r8 = ((Long) r7[0]).longValue();
        this.mThrottleNetSpeed = r8;
        UrlRequest r0 = this.mRequest;
        if (r0 == null) goto L78;
        r0.setThrottleNetSpeed(r8);
        return;
    L78:
        return;
    L66:
        ParamChecker.check(new Class[]{Integer.TYPE}, r7);
        this.mOutputStreamBufferSize = ((Integer) r7[0]).intValue();
        return;
    L67:
        ParamChecker.check(new Class[]{Integer.TYPE}, r7);
        this.mRequestFlag = ((Integer) r7[0]).intValue();
        return;
    L68:
        ParamChecker.check(new Class[]{Integer.TYPE}, r7);
        this.mInputStreamBufferSize = ((Integer) r7[0]).intValue();
        return;
    L69:
        ParamChecker.check(new Class[]{Integer.TYPE}, r7);
        this.mSocketConnectTimeout = ((Integer) r7[0]).intValue();
        return;
    L55:
        throw new IllegalArgumentException("Unknown method name: ".concat(r6));
    L6:
        if (r6.equals("enableFixCancelRequestReport") == false) goto L53;
        r4 = 11;
        goto L53
    L10:
        if (r6.equals("setRequestPriority") == false) goto L53;
        r4 = 10;
        goto L53
    L14:
        if (r6.equals("setSocketWriteTimeout") == false) goto L53;
        r4 = 9;
        goto L53
    L18:
        if (r6.equals("setRequestTypeFlags") == false) goto L53;
        r4 = 8;
        goto L53
    L22:
        if (r6.equals("setAuthCredentials") == false) goto L53;
        r4 = 7;
        goto L53
    L26:
        if (r6.equals("setRequestTimeout") == false) goto L53;
        r4 = 6;
        goto L53
    L30:
        if (r6.equals("setSocketReadTimeout") == false) goto L53;
        r4 = 5;
        goto L53
    L34:
        if (r6.equals("setThrottleNetSpeed") == false) goto L53;
        r4 = 4;
        goto L53
    L38:
        if (r6.equals("setOutputStreamBufferSize") == false) goto L53;
        r4 = 3;
        goto L53
    L42:
        if (r6.equals("setRequestFlag") == false) goto L53;
        r4 = 2;
        goto L53
    L46:
        if (r6.equals("setInputStreamBufferSize") == false) goto L53;
        r4 = 1;
        goto L53
    L50:
        if (r6.equals("setSocketConnectTimeout") == false) goto L53;
        r4 = 0;
        goto L53
    }

    public void setAuthCredentials(String r1, String r2) {
        this.mAuthCertUsername = r1;
        this.mAuthCertPassword = r2;
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String r2, String r3) {
        setRequestPropertyInternal(r2, r3, true);
    }

    public CronetHttpURLConnection(URL r2, CronetEngine r3, boolean r4) {
        super(r2);
        this.mDisconnected = new AtomicBoolean(false);
        this.mRequestCompleted = new AtomicBoolean(false);
        this.mFixCancelRequestReport = false;
        this.mCronetEngine = r3;
        this.mMessageLoop = new MessageLoop();
        if (r4 == false) goto L5;
        this.mInputStream = new CronetInputStreamWithTTBuffer(this);
    L6:
        this.mRequestHeaders = new ArrayList();
        this.mCookieHandler = CookieHandler.getDefault();
        this.mRequestCookieSource = -1;
        return;
    L5:
        this.mInputStream = new CronetInputStream(this);
        goto L6
    }

    public static /* synthetic */ void access$300(CronetHttpURLConnection r0, String r1, Map r2) {
        r0.saveResponseCookie(r1, r2);
    }

    private final void setRequestPropertyInternal(String r2, String r3, boolean r4) {
        if (((HttpURLConnection) this).connected == true) goto L13;
        int r0 = findRequestProperty(r2);
        if (r0 < 0) goto L10;
        if (r4 == false) goto L9;
        ListProtector.remove(this.mRequestHeaders, r0);
        goto L10
    L9:
        throw new UnsupportedOperationException("Cannot add multiple headers of the same key, " + r2 + ". crbug.com/432719.");
    L10:
        this.mRequestHeaders.add(Pair.create(r2, r3));
        return;
    L13:
        throw new IllegalStateException("Cannot modify request property after connection is made.");
    }
}
