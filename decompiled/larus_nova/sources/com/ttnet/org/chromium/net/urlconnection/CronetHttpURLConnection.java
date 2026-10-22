package com.ttnet.org.chromium.net.urlconnection;

import android.net.TrafficStats;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
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
import java.net.MalformedURLException;
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

/* JADX INFO: loaded from: classes.dex */
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

    /* JADX INFO: loaded from: classes5.dex */
    public class CronetUrlRequestCallback extends UrlRequest.Callback {
        final /* synthetic */ CronetHttpURLConnection this$0;

        public CronetUrlRequestCallback(CronetHttpURLConnection r100) {
            this.this$0 = r100;
        }

        private void setResponseDataCompleted(IOException r100) {
            CronetHttpURLConnection.access$1202(this.this$0, r100);
            if (CronetHttpURLConnection.access$1400(this.this$0) == null) goto L6;
            CronetHttpURLConnection.access$1400(this.this$0).setResponseDataCompleted(r100);
        L6:
            if (CronetHttpURLConnection.access$1500(this.this$0) == null) goto L8;
            CronetHttpURLConnection.access$1500(this.this$0).setRequestCompleted(r100);
        L8:
            CronetHttpURLConnection.access$102(this.this$0, true);
            CronetHttpURLConnection.access$1600(this.this$0).set(true);
            CronetHttpURLConnection.access$400(this.this$0).quit();
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onCanceled(UrlRequest r100, UrlResponseInfo r101) {
            CronetHttpURLConnection.access$002(this.this$0, r101);
            if (Logger.debug() == false) goto L6;
            Logger.d("CronetHttpURLConnection", "onCanceled loop quit url = " + this.this$0.getURL().toString());
        L6:
            if (CronetHttpURLConnection.access$1200(this.this$0) == null) goto L8;
        L10:
            setResponseDataCompleted(CronetHttpURLConnection.access$1200(this.this$0));
            return;
        L8:
            if (CronetHttpURLConnection.access$500(this.this$0) == true) goto L10;
            CronetHttpURLConnection.access$1202(this.this$0, new TTRequestCanceledException("request canceled, ErrorCode=11, InternalErrorCode=-999"));
            goto L10
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onSucceeded(UrlRequest r100, UrlResponseInfo r101) {
            CronetHttpURLConnection.access$002(this.this$0, r101);
            setResponseDataCompleted(null);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onFailed(UrlRequest r100, UrlResponseInfo r101, CronetException r102) {
            if (r102 == null) goto L6;
            CronetHttpURLConnection r103 = this.this$0;
            CronetHttpURLConnection.access$1202(r103, CronetHttpURLConnection.access$1300(r103, r102));
            CronetHttpURLConnection.access$002(this.this$0, r101);
            setResponseDataCompleted(r102);
            return;
        L6:
            throw new IllegalStateException("Exception cannot be null in onFailed.");
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onReadCompleted(UrlRequest r100, UrlResponseInfo r101, ByteBuffer r102) {
            CronetHttpURLConnection.access$002(this.this$0, r101);
            CronetHttpURLConnection.access$400(this.this$0).quit();
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onResponseStarted(UrlRequest r100, UrlResponseInfo r101, String r102) {
            CronetHttpURLConnection.access$002(this.this$0, r101);
            CronetHttpURLConnection.access$102(this.this$0, true);
            if (CronetHttpURLConnection.access$000(this.this$0) == null) goto L8;
            long r103 = System.nanoTime();
            CronetHttpURLConnection r104 = this.this$0;
            CronetHttpURLConnection.access$300(r104, r102, CronetHttpURLConnection.access$200(r104));
            long r105 = (System.nanoTime() - r103) / 1000;
            if (r100 == null) goto L8;
            r100.setSaveCookieCostUs(r105);
        L8:
            if (Logger.debug() == false) goto L10;
            Logger.d("CronetHttpURLConnection", "onResponseStarted loop quit url = " + this.this$0.getURL().toString());
        L10:
            CronetHttpURLConnection.access$400(this.this$0).quit();
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onRedirectReceived(UrlRequest r100, UrlResponseInfo r101, String r102, String r103) {
            boolean r104 = true;
            CronetHttpURLConnection.access$502(this.this$0, true);
            if (r101 == null) goto L5;
            CronetHttpURLConnection.access$300(this.this$0, r103, r101.getAllHeaders());
        L5:
            URL r105 = CronetHttpURLConnection.access$600(this.this$0);
            if (TextUtils.isEmpty(r103) == true) goto L43;
            r105 = new URL(r103);     // Catch: Throwable -> L40
        L43:
            URL r106 = new URL(r102);     // Catch: MalformedURLException -> L35
            if (CronetHttpURLConnection.access$700(this.this$0) == false) goto L13;
            CronetHttpURLConnection.access$802(this.this$0, r106);     // Catch: MalformedURLException -> L35
        L13:
            if (CronetHttpURLConnection.access$900(this.this$0) == false) goto L36;
            if (CronetHttpURLConnection.access$1000(this.this$0) != null) goto L17;
            return;
        L17:
            if ("http".equals(r106.getProtocol()) == true) goto L19;
        L21:
            r104 = false;
        L23:
            if (r106.getHost().equals(r105.getHost()) == false) goto L25;
            if (r104 == true) goto L25;
        L33:
            CronetHttpURLConnection.access$1000(this.this$0).followRedirect();     // Catch: MalformedURLException -> L35
            return;
        L25:
            CronetHttpURLConnection.access$1000(this.this$0).RemoveRequestCookieHeader();     // Catch: MalformedURLException -> L35
            URL r107 = new URL(r102);     // Catch: MalformedURLException -> L35
            CronetHttpURLConnection r108 = this.this$0;     // Catch: MalformedURLException -> L35
            Map r109 = CronetHttpURLConnection.access$1100(r108, r108.uri(r107));     // Catch: MalformedURLException -> L35
            if (r109 == null) goto L33;
            if (r109.isEmpty() == true) goto L33;
            Iterator r110 = r109.entrySet().iterator();     // Catch: MalformedURLException -> L35
        L31:
            if (r110.hasNext() == false) goto L33;
            Map.Entry r111 = (Map.Entry) r110.next();     // Catch: MalformedURLException -> L35
            CronetHttpURLConnection.access$1000(this.this$0).AddRequestCookieHeader((String) r111.getKey(), (String) r111.getValue());     // Catch: MalformedURLException -> L35
            goto L31
        L19:
            if ("https".equals(r105.getProtocol()) == false) goto L21;
        L36:
            CronetHttpURLConnection.access$002(this.this$0, r101);
            if (CronetHttpURLConnection.access$1000(this.this$0) == null) goto L47;
            CronetHttpURLConnection.access$1000(this.this$0).cancel();
            return;
        }
    }

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
        IOException r100 = this.mException;
        if (r100 == null) goto L7;
        throw r100;
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
        int r100 = TrafficStats.getThreadStatsTag();
        if (r100 == (-1)) goto L9;
        this.mTrafficStatsTag = r100;
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
        int r100 = TrafficStats.getThreadStatsUid();
        if (r100 == (-1)) goto L13;
        this.mTrafficStatsUid = r100;
        this.mTrafficStatsUidSet = true;
    L13:
        return this.mTrafficStatsUidSet;
    }

    private Map<String, List<String>> getAllHeaders() {
        Map<String, List<String>> r100 = this.mResponseHeadersMap;
        if (r100 == null) goto L5;
        return r100;
    L5:
        TreeMap r101 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator<Map.Entry<String, String>> r102 = getAllHeadersAsList().iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        Map.Entry<String, String> r103 = r102.next();
        ArrayList r104 = new ArrayList();
        if (r101.containsKey(r103.getKey()) == false) goto L11;
        r104.addAll((Collection) r101.get(r103.getKey()));
    L11:
        r104.add(r103.getValue());
        r101.put(r103.getKey(), Collections.unmodifiableList(r104));
        goto L7
    L12:
        Map<String, List<String>> r105 = Collections.unmodifiableMap(r101);
        this.mResponseHeadersMap = r105;
        return r105;
    }

    private List<Map.Entry<String, String>> getAllHeadersAsList() {
        List<Map.Entry<String, String>> r100 = this.mResponseHeadersList;
        if (r100 == null) goto L5;
        return r100;
    L5:
        this.mResponseHeadersList = new ArrayList();
        Iterator<Map.Entry<String, String>> r101 = this.mResponseInfo.getAllHeadersAsList().iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        Map.Entry<String, String> r102 = r101.next();
        this.mResponseHeadersList.add(new AbstractMap.SimpleImmutableEntry(r102));
        goto L7
    L9:
        List<Map.Entry<String, String>> r103 = Collections.unmodifiableList(this.mResponseHeadersList);
        this.mResponseHeadersList = r103;
        return r103;
    }

    private void getResponse() throws IOException {
        CronetOutputStream r100 = this.mOutputStream;
        if (r100 == null) goto L8;
        r100.checkReceivedEnoughContent();
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
        long r100 = ((HttpURLConnection) this).fixedContentLength;
        long r101 = ((HttpURLConnection) this).fixedContentLengthLong;
        if (r101 != (-1)) goto L5;
        return r100;
    L5:
        return r101;
    }

    private boolean isAllowCredentials() {
        String r100 = getRequestProperty("x-ttnet-bypass-cookie");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return true;
    L5:
        if ("0".equals(r100) == false) goto L10;
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
        ExperimentalUrlRequest.Builder r100 = (ExperimentalUrlRequest.Builder) this.mCronetEngine.newUrlRequestBuilder(getURL().toString(), new CronetUrlRequestCallback(this), this.mMessageLoop);
        if (((HttpURLConnection) this).doOutput == true) goto L11;
    L27:
        long r101 = System.nanoTime();
        Map<String, String> r102 = GetCookieMap(uri(getURL()));
        if (r102 != null) goto L30;
    L35:
        long r103 = (System.nanoTime() - r101) / 1000;
        Iterator<Pair<String, String>> r104 = this.mRequestHeaders.iterator();
    L37:
        if (r104.hasNext() == false) goto L40;
        Pair<String, String> r105 = r104.next();
        r100.addHeader((String) r105.first, (String) r105.second);
        goto L37
    L40:
        if (getUseCaches() == true) goto L42;
        r100.disableCache();
    L42:
        r100.setHttpMethod(((HttpURLConnection) this).method);
        if (checkTrafficStatsTag() == false) goto L46;
        r100.setTrafficStatsTag(this.mTrafficStatsTag);
    L46:
        if (checkTrafficStatsUid() == false) goto L48;
        r100.setTrafficStatsUid(this.mTrafficStatsUid);
    L48:
        r100.setPriority(this.mRequestPriority);
        r100.setSocketConnectTimeout(this.mSocketConnectTimeout);
        r100.setSocketReadTimeout(this.mSocketReadTimeout);
        r100.setSocketWriteTimeout(this.mSocketWriteTimeout);
        r100.setRequestTimeout(this.mRequestTimeout);
        r100.setRequestFinishedListener(this.mRequestFinishedListener);
        ExperimentalUrlRequest r106 = r100.build();
        this.mRequest = r106;
        int r107 = this.mRequestFlag;
        if (r107 == 0) goto L51;
        r106.setRequestFlag(r107);
    L51:
        int r108 = this.mRequestTypeFlags;
        if (r108 <= 0) goto L54;
        this.mRequest.setRequestTypeFlags(r108);
    L54:
        String r109 = this.mAuthCertUsername;
        if (r109 == null) goto L59;
        String r110 = this.mAuthCertPassword;
        if (r110 == null) goto L59;
        this.mRequest.setAuthCredentials(r109, r110);
    L59:
        this.mRequest.setAddCookieCostUs(r103);
        this.mRequest.setRequestCookieSource(this.mRequestCookieSource);
        this.mRequest.setCookieRelMetric(this.mCookieRelMetric);
        this.mRequest.start();
        long r111 = this.mThrottleNetSpeed;
        if (r111 <= 0) goto L62;
        this.mRequest.setThrottleNetSpeed(r111);
    L62:
        ((HttpURLConnection) this).connected = true;
        return;
    L30:
        if (r102.isEmpty() == true) goto L35;
        Iterator<Map.Entry<String, String>> r112 = r102.entrySet().iterator();
    L33:
        if (r112.hasNext() == false) goto L35;
        Map.Entry<String, String> r113 = r112.next();
        r100.addHeader(r113.getKey(), r113.getValue());
        goto L33
    L11:
        if (((HttpURLConnection) this).method.equals("GET") == false) goto L13;
        ((HttpURLConnection) this).method = "POST";
    L13:
        CronetOutputStream r114 = this.mOutputStream;
        if (r114 == null) goto L22;
        r100.setUploadDataProvider(r114.getUploadDataProvider(), this.mMessageLoop);
        if (getRequestProperty("Content-Length") == null) goto L18;
    L20:
        this.mOutputStream.setConnected();
    L25:
        if (getRequestProperty("Content-Type") != null) goto L27;
        addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        goto L27
    L18:
        if (isChunkedUpload() == true) goto L20;
        addRequestProperty("Content-Length", Long.toString(this.mOutputStream.getUploadDataProvider().getLength()));
        goto L20
    L22:
        if (getRequestProperty("Content-Length") != null) goto L25;
        addRequestProperty("Content-Length", "0");
        goto L25
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (((HttpURLConnection) this).connected == false) goto L27;
        UrlRequest r100 = this.mRequest;
        if (r100 == null) goto L28;
        r100.cancel();
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
        IOException r100 = this.mException;
        if ((r100 instanceof NetworkException) == false) goto L7;
        return ((NetworkException) r100).getCronetInternalErrorCode();
    L7:
        if ((r100 instanceof TTRequestCanceledException) == true) goto L9;
        return 0;
    L9:
        return ((TTRequestCanceledException) r100).getCronetInternalErrorCode();
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
        long r100 = getStreamingModeContentLength();
        if (r100 == (-1)) goto L20;
        CronetFixedModeOutputStream r101 = new CronetFixedModeOutputStream(this, r100, this.mOutputStreamBufferSize, this.mMessageLoop);
        this.mOutputStream = r101;
        if (r100 != 0) goto L19;
        setFixedLengthStreamingMode((int) r101.getUploadDataProvider().getLength());
        if (getRequestProperty("Content-Length") != null) goto L18;
        addRequestProperty("Content-Length", Long.toString(this.mOutputStream.getUploadDataProvider().getLength()));
        goto L19
    L18:
        setRequestProperty("Content-Length", Long.toString(this.mOutputStream.getUploadDataProvider().getLength()));
    L19:
        startRequest();
        goto L27
    L20:
        Log.d(TAG, "Outputstream is being buffered in memory.", new Object[0]);
        String r102 = getRequestProperty("Content-Length");
        if (r102 != null) goto L23;
        this.mOutputStream = new CronetBufferedOutputStream(this);
        goto L27
    L23:
        this.mOutputStream = new CronetBufferedOutputStream(this, CastLongProtector.parseLong(r102));
        goto L27
    L25:
        throw new ProtocolException("Cannot write to OutputStream after receiving response.");
    L27:
        return this.mOutputStream;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        if (((HttpURLConnection) this).connected == true) goto L15;
        TreeMap r100 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator<Pair<String, String>> r101 = this.mRequestHeaders.iterator();
    L6:
        if (r101.hasNext() == false) goto L13;
        Pair<String, String> r102 = r101.next();
        if (r100.containsKey(r102.first) == true) goto L11;
        ArrayList r103 = new ArrayList();
        r103.add((String) r102.second);
        r100.put((String) r102.first, Collections.unmodifiableList(r103));
        goto L6
    L11:
        throw new IllegalStateException("Should not have multiple values.");
    L13:
        return Collections.unmodifiableMap(r100);
    L15:
        throw new IllegalStateException("Cannot access request headers after connection is set.");
    }

    public void onUploadTimeout() {
        UrlRequest r100 = this.mRequest;
        if (r100 == null) goto L6;
        r100.appTimeout();
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

    private Map<String, String> GetCookieMap(URI r110) {
        HashMap r100 = new HashMap();
        if ((this.mRequestTypeFlags & 2) > 0) goto L67;
        if (isAllowCredentials() == false) goto L67;
        HashMap r101 = new HashMap();
        List<Pair<String, String>> r102 = this.mRequestHeaders;
        if (r102 == null) goto L16;
        Iterator<Pair<String, String>> r103 = r102.iterator();
    L11:
        if (r103.hasNext() == false) goto L16;
        Pair<String, String> r104 = r103.next();
        String r105 = (String) r104.first;
        String r106 = (String) r104.second;
        List r107 = (List) r101.get(r105);
        if (r107 != null) goto L15;
        r107 = new LinkedList();
    L15:
        r107.add(r106);
        r101.put(r105, r107);
    L16:
        r101.put(GET_REQUEST_COOKIE_SOURCE_FLAG, new LinkedList());
        r101.put(TT_COOKIE_REL_METRIC_FLAG, new LinkedList());
        if ((this.mRequestTypeFlags & 1) == 0) goto L19;
        r101.put(WEBVIEW_REQUEST_FLAG, new LinkedList());
    L19:
        Map<String, List<String>> r108 = null;
    L27:
        e = move-exception;
        if (Logger.debug() == false) goto L31;
        Logger.d(TAG, "Loading cookies failed for " + getURL().toString() + " e = " + e.getMessage());
    L31:
        if (r108 != null) goto L33;
    L65:
        return r100;
    L33:
        if (r108.size() <= 0) goto L65;
        Iterator<Map.Entry<String, List<String>>> r111 = r108.entrySet().iterator();
    L36:
        if (r111.hasNext() == false) goto L65;
        Map.Entry<String, List<String>> r109 = r111.next();
        String r112 = r109.getKey();
        int r113 = 0;
        if (GET_REQUEST_COOKIE_SOURCE_FLAG.equals(r112) == false) goto L45;
        if (r109.getValue().isEmpty() == true) goto L45;
        this.mRequestCookieSource = CastIntegerProtector.parseInt((String) ListProtector.get(r109.getValue(), 0));     // Catch: Throwable -> L43
    L49:
        StringBuilder r114 = new StringBuilder();
        if (SS_COOKIE.equalsIgnoreCase(r112) == true) goto L56;
        if ("Cookie".equalsIgnoreCase(r112) == true) goto L56;
        if ("Cookie2".equalsIgnoreCase(r112) == false) goto L36;
    L56:
        if (r109.getValue().isEmpty() == true) goto L36;
        Iterator<String> r115 = r109.getValue().iterator();
    L59:
        if (r115.hasNext() == false) goto L64;
        String r116 = r115.next();
        if (r113 <= 0) goto L63;
        r114.append("; ");
    L63:
        r114.append(r116);
        r113 = r113 + 1;
        goto L59
    L64:
        r100.put(r112, r114.toString());
    L43:
        this.mRequestCookieSource = -1;
    L45:
        if (TT_COOKIE_REL_METRIC_FLAG.equals(r112) == false) goto L49;
        if (r109.getValue().isEmpty() == true) goto L49;
        this.mCookieRelMetric = (String) ListProtector.get(r109.getValue(), 0);
        goto L49
    L21:
        if (this.mCookieHandler != null) goto L23;
        this.mCookieHandler = CookieHandler.getDefault();     // Catch: Exception -> L27
    L23:
        CookieHandler r117 = this.mCookieHandler;     // Catch: Exception -> L27
        if (r117 == null) goto L31;
        r108 = r117.get(r110, r101);     // Catch: Exception -> L27
    L67:
        if (Logger.debug() == false) goto L69;
        Logger.d(TAG, "Do not read cookie from TTNet, url:" + r110);
    L69:
        return r100;
    }

    public static /* synthetic */ UrlResponseInfo access$000(CronetHttpURLConnection r100) {
        return r100.mResponseInfo;
    }

    public static /* synthetic */ UrlRequest access$1000(CronetHttpURLConnection r100) {
        return r100.mRequest;
    }

    public static /* synthetic */ IOException access$1200(CronetHttpURLConnection r100) {
        return r100.mException;
    }

    public static /* synthetic */ CronetInputStream access$1400(CronetHttpURLConnection r100) {
        return r100.mInputStream;
    }

    public static /* synthetic */ CronetOutputStream access$1500(CronetHttpURLConnection r100) {
        return r100.mOutputStream;
    }

    public static /* synthetic */ AtomicBoolean access$1600(CronetHttpURLConnection r100) {
        return r100.mRequestCompleted;
    }

    public static /* synthetic */ Map access$200(CronetHttpURLConnection r100) {
        return r100.getAllHeaders();
    }

    public static /* synthetic */ MessageLoop access$400(CronetHttpURLConnection r100) {
        return r100.mMessageLoop;
    }

    public static /* synthetic */ boolean access$500(CronetHttpURLConnection r100) {
        return r100.mOnRedirectCalled;
    }

    public static /* synthetic */ URL access$600(CronetHttpURLConnection r100) {
        return ((HttpURLConnection) r100).url;
    }

    public static /* synthetic */ boolean access$700(CronetHttpURLConnection r100) {
        return ((HttpURLConnection) r100).instanceFollowRedirects;
    }

    public static /* synthetic */ boolean access$900(CronetHttpURLConnection r100) {
        return ((HttpURLConnection) r100).instanceFollowRedirects;
    }

    private void executeMessageLoop(int r100) throws IOException {
        this.mMessageLoop.loop(r100);     // Catch: Exception -> L4 SocketTimeoutException -> L6
    L14:
        return;
    L6:
        UrlRequest r101 = this.mRequest;
        if (r101 == null) goto L13;
        r101.appTimeout();
        this.mMessageLoop.reset();
        this.mMessageLoop.loop(r100 / 2);
        return;
    L13:
        return;
    L4:
        e = move-exception;
        cancelWithException("Unexpected request usage, caught in CronetHttpURLConnection.", e);
        this.mMessageLoop.reset();
        this.mMessageLoop.loop(r100 / 2);
    }

    private int findRequestProperty(String r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.mRequestHeaders.size()) goto L9;
        if (((String) ((Pair) ListProtector.get(this.mRequestHeaders, r101)).first).equalsIgnoreCase(r100) == true) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return r101;
    L9:
        return -1;
    }

    private Map.Entry<String, String> getHeaderFieldEntry(int r100) {
        getResponse();     // Catch: IOException -> L9
        List<Map.Entry<String, String>> r101 = getAllHeadersAsList();
        if (r100 < r101.size()) goto L8;
        return null;
    L8:
        return (Map.Entry) ListProtector.get(r101, r100);
    L9:
        return null;
    }

    private IOException tryConvertCronetException(CronetException r100) {
        if ((r100 instanceof NetworkException) == true) goto L6;
        return r100;
    L6:
        switch(((NetworkException) r100).getErrorCode()) {
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
        IOException r101 = new NoRouteToHostException(r100.getMessage());
    L16:
        return r101;
    L9:
        r101 = new SocketException("reset by peer " + r100.getMessage());
        goto L16
    L10:
        r101 = new ConnectTimeoutException(r100.getMessage());
        goto L16
    L11:
        r101 = new ConnectException(r100.getMessage());
        goto L16
    L12:
        r101 = new SocketTimeoutException(r100.getMessage());
        goto L16
    L13:
        r101 = new ConnectException(r100.getMessage());
        goto L16
    L14:
        r101 = new UnknownHostException(r100.getMessage());
        goto L16
    L17:
        return r100;
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String r100) {
        getResponse();     // Catch: IOException -> L9
        Map<String, List<String>> r101 = getAllHeaders();
        if (r101.containsKey(r100) == true) goto L7;
        return null;
    L7:
        List<String> r102 = r101.get(r100);
        return (String) ListProtector.get(r102, r102.size() - 1);
    L9:
        return null;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int r100) {
        Map.Entry<String, String> r101 = getHeaderFieldEntry(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getKey();
    }

    public void getMoreData(ByteBuffer r100) throws IOException {
        UrlRequest r101 = this.mRequest;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.read(r100);
        executeMessageLoop(getReadTimeout());
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String r100) {
        int r101 = findRequestProperty(r100);
        if (r101 >= 0) goto L5;
        return null;
    L5:
        return (String) ((Pair) ListProtector.get(this.mRequestHeaders, r101)).second;
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int r100) {
        super.setConnectTimeout(r100);
    }

    public void setInputStreamBufferSize(int r100) {
        this.mInputStreamBufferSize = r100;
    }

    public void setOutputStreamBufferSize(int r100) {
        this.mOutputStreamBufferSize = r100;
    }

    public void setRequestFinishedListener(RequestFinishedInfo.Listener r100) {
        this.mRequestFinishedListener = r100;
    }

    public void setRequestFlag(int r100) {
        this.mRequestFlag = r100;
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String r100) throws ProtocolException {
        if ("PATCH".equals(r100) == true) goto L5;
        super.setRequestMethod(r100);
        return;
    L5:
        if (((HttpURLConnection) this).connected == true) goto L8;
        ((HttpURLConnection) this).method = r100;
        return;
    L8:
        throw new ProtocolException("Can't reset method: already connected");
    }

    public void setRequestPriority(int r100) {
        this.mRequestPriority = r100;
    }

    public void setRequestTimeout(int r100) {
        this.mRequestTimeout = r100;
    }

    public void setRequestTypeFlags(int r100) {
        this.mRequestTypeFlags = r100 | this.mRequestTypeFlags;
    }

    public void setSocketConnectTimeout(int r100) {
        this.mSocketConnectTimeout = r100;
    }

    public void setSocketReadTimeout(int r100) {
        this.mSocketReadTimeout = r100;
    }

    public void setSocketWriteTimeout(int r100) {
        this.mSocketWriteTimeout = r100;
    }

    public void setThrottleNetSpeed(long r100) {
        this.mThrottleNetSpeed = r100;
        UrlRequest r101 = this.mRequest;
        if (r101 == null) goto L6;
        r101.setThrottleNetSpeed(r100);
        return;
    }

    public void setTrafficStatsTag(int r100) {
        if (((HttpURLConnection) this).connected == true) goto L7;
        this.mTrafficStatsTagSet = true;
        this.mTrafficStatsTag = r100;
        return;
    L7:
        throw new IllegalStateException("Cannot modify traffic stats tag after connection is made.");
    }

    public void setTrafficStatsUid(int r100) {
        if (((HttpURLConnection) this).connected == true) goto L7;
        this.mTrafficStatsUidSet = true;
        this.mTrafficStatsUid = r100;
        return;
    L7:
        throw new IllegalStateException("Cannot modify traffic stats UID after connection is made.");
    }

    public URI uri(URL r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = r100.toString();
        return new URI(r101);
    L8:
        e = move-exception;
        return URI.create(r101.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L11:
        return URI.create(r101.substring(0, r101.indexOf("?")));
    L14:
        throw new RuntimeException(e);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int r100) {
        Map.Entry<String, String> r101 = getHeaderFieldEntry(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getValue();
    }

    public static /* synthetic */ UrlResponseInfo access$002(CronetHttpURLConnection r100, UrlResponseInfo r101) {
        r100.mResponseInfo = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$102(CronetHttpURLConnection r100, boolean r101) {
        r100.mHasResponseHeadersOrCompleted = r101;
        return r101;
    }

    public static /* synthetic */ Map access$1100(CronetHttpURLConnection r100, URI r101) {
        return r100.GetCookieMap(r101);
    }

    public static /* synthetic */ IOException access$1202(CronetHttpURLConnection r100, IOException r101) {
        r100.mException = r101;
        return r101;
    }

    public static /* synthetic */ IOException access$1300(CronetHttpURLConnection r100, CronetException r101) {
        return r100.tryConvertCronetException(r101);
    }

    public static /* synthetic */ boolean access$502(CronetHttpURLConnection r100, boolean r101) {
        r100.mOnRedirectCalled = r101;
        return r101;
    }

    public static /* synthetic */ URL access$802(CronetHttpURLConnection r100, URL r101) {
        ((HttpURLConnection) r100).url = r101;
        return r101;
    }

    private void saveResponseCookie(String r100, Map<String, List<String>> r101) {
        if (isAllowCredentials() == true) goto L9;
        if (Logger.debug() == false) goto L37;
        Logger.d(TAG, "Do not write cookie from TTNet, url:" + r100);
        return;
    L37:
        return;
    L9:
        if (Logger.debug() == false) goto L36;
        String r102 = TAG;
        StringBuilder r103 = new StringBuilder("Saving cookies for url: ");
        if (TextUtils.isEmpty(r100) == false) goto L13;
        String r104 = getURL().toString();
    L14:
        r103.append(r104);
        Logger.d(r102, r103.toString());
        goto L36
    L13:
        r104 = r100;
    L36:
    L28:
        e = move-exception;
        if (Logger.debug() == false) goto L41;
        String r105 = TAG;
        StringBuilder r106 = new StringBuilder("Saving cookies failed for ");
        if (TextUtils.isEmpty(r100) == false) goto L34;
        r100 = getURL().toString();
    L34:
        r106.append(r100);
        r106.append(" e = ");
        r106.append(e.getMessage());
        Logger.d(r105, r106.toString());
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
        if (TextUtils.isEmpty(r100) == false) goto L23;
        this.mCookieHandler.put(uri(getURL()), r101);     // Catch: Exception -> L28
        return;
    L23:
        URI r107 = uri(new URL(r100));     // Catch: Exception -> L28
        if ((this.mRequestTypeFlags & 1) == 0) goto L26;
        TreeMap r108 = new TreeMap(r101);     // Catch: Exception -> L28
        r108.put(WEBVIEW_COOKIE, Collections.singletonList(getURL().getHost()));     // Catch: Exception -> L28
        this.mCookieHandler.put(r107, r108);     // Catch: Exception -> L28
        return;
    L26:
        this.mCookieHandler.put(r107, r101);     // Catch: Exception -> L28
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String r100, String r101) {
        setRequestPropertyInternal(r100, r101, false);
    }

    public void cancelWithException(String r100, Throwable r101) {
        UrlRequest r102 = this.mRequest;
        if (r102 == null) goto L6;
        r102.cancelWithException(r100, r101);
        return;
    }

    public void configureConnection(String r100, Object... r101) {
        r100.getClass();
        byte r102 = -1;
        switch(r100.hashCode()) {
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
        switch(r102) {
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
        ParamChecker.check(new Class[0], r101);
        this.mFixCancelRequestReport = true;
        return;
    L57:
        ParamChecker.check(new Class[]{Integer.TYPE}, r101);
        this.mRequestPriority = ((Integer) r101[0]).intValue();
        return;
    L58:
        ParamChecker.check(new Class[]{Integer.TYPE}, r101);
        this.mSocketWriteTimeout = ((Integer) r101[0]).intValue();
        return;
    L59:
        ParamChecker.check(new Class[]{Integer.TYPE}, r101);
        this.mRequestTypeFlags = ((Integer) r101[0]).intValue();
        return;
    L60:
        ParamChecker.check(new Class[]{String.class, String.class}, r101);
        this.mAuthCertUsername = (String) r101[0];
        this.mAuthCertPassword = (String) r101[1];
        return;
    L61:
        ParamChecker.check(new Class[]{Integer.TYPE}, r101);
        this.mRequestTimeout = ((Integer) r101[0]).intValue();
        return;
    L62:
        ParamChecker.check(new Class[]{Integer.TYPE}, r101);
        this.mSocketReadTimeout = ((Integer) r101[0]).intValue();
        return;
    L63:
        ParamChecker.check(new Class[]{Long.TYPE}, r101);
        long r103 = ((Long) r101[0]).longValue();
        this.mThrottleNetSpeed = r103;
        UrlRequest r104 = this.mRequest;
        if (r104 == null) goto L78;
        r104.setThrottleNetSpeed(r103);
        return;
    L78:
        return;
    L66:
        ParamChecker.check(new Class[]{Integer.TYPE}, r101);
        this.mOutputStreamBufferSize = ((Integer) r101[0]).intValue();
        return;
    L67:
        ParamChecker.check(new Class[]{Integer.TYPE}, r101);
        this.mRequestFlag = ((Integer) r101[0]).intValue();
        return;
    L68:
        ParamChecker.check(new Class[]{Integer.TYPE}, r101);
        this.mInputStreamBufferSize = ((Integer) r101[0]).intValue();
        return;
    L69:
        ParamChecker.check(new Class[]{Integer.TYPE}, r101);
        this.mSocketConnectTimeout = ((Integer) r101[0]).intValue();
        return;
    L55:
        throw new IllegalArgumentException("Unknown method name: ".concat(r100));
    L6:
        if (r100.equals("enableFixCancelRequestReport") == false) goto L53;
        r102 = 11;
        goto L53
    L10:
        if (r100.equals("setRequestPriority") == false) goto L53;
        r102 = 10;
        goto L53
    L14:
        if (r100.equals("setSocketWriteTimeout") == false) goto L53;
        r102 = 9;
        goto L53
    L18:
        if (r100.equals("setRequestTypeFlags") == false) goto L53;
        r102 = 8;
        goto L53
    L22:
        if (r100.equals("setAuthCredentials") == false) goto L53;
        r102 = 7;
        goto L53
    L26:
        if (r100.equals("setRequestTimeout") == false) goto L53;
        r102 = 6;
        goto L53
    L30:
        if (r100.equals("setSocketReadTimeout") == false) goto L53;
        r102 = 5;
        goto L53
    L34:
        if (r100.equals("setThrottleNetSpeed") == false) goto L53;
        r102 = 4;
        goto L53
    L38:
        if (r100.equals("setOutputStreamBufferSize") == false) goto L53;
        r102 = 3;
        goto L53
    L42:
        if (r100.equals("setRequestFlag") == false) goto L53;
        r102 = 2;
        goto L53
    L46:
        if (r100.equals("setInputStreamBufferSize") == false) goto L53;
        r102 = 1;
        goto L53
    L50:
        if (r100.equals("setSocketConnectTimeout") == false) goto L53;
        r102 = 0;
        goto L53
    }

    public void setAuthCredentials(String r100, String r101) {
        this.mAuthCertUsername = r100;
        this.mAuthCertPassword = r101;
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String r100, String r101) {
        setRequestPropertyInternal(r100, r101, true);
    }

    public CronetHttpURLConnection(URL r100, CronetEngine r101, boolean r102) {
        super(r100);
        this.mDisconnected = new AtomicBoolean(false);
        this.mRequestCompleted = new AtomicBoolean(false);
        this.mFixCancelRequestReport = false;
        this.mCronetEngine = r101;
        this.mMessageLoop = new MessageLoop();
        if (r102 == false) goto L5;
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

    public static /* synthetic */ void access$300(CronetHttpURLConnection r100, String r101, Map r102) {
        r100.saveResponseCookie(r101, r102);
    }

    private final void setRequestPropertyInternal(String r100, String r101, boolean r102) {
        if (((HttpURLConnection) this).connected == true) goto L13;
        int r103 = findRequestProperty(r100);
        if (r103 < 0) goto L10;
        if (r102 == false) goto L9;
        ListProtector.remove(this.mRequestHeaders, r103);
        goto L10
    L9:
        throw new UnsupportedOperationException("Cannot add multiple headers of the same key, " + r100 + ". crbug.com/432719.");
    L10:
        this.mRequestHeaders.add(Pair.create(r100, r101));
        return;
    L13:
        throw new IllegalStateException("Cannot modify request property after connection is made.");
    }
}
