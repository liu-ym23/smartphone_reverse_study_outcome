package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.Ipv6ConnectionManager;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.metadispatch.TTMetaDispatchLog;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchActionInfo;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher;
import com.bytedance.frameworks.baselib.network.http.util.i;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.ttnet.BuildConfig;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ttnet.org.chromium.net.NetError;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.TlsVersion;
import okhttp3.e;
import okio.ByteString;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ox5.a;
import sx5.b;

/* JADX INFO: loaded from: classes19.dex */
public class OkHttp3RequestLog {
    private static final int MAX_ABSDK_VERSION_LENGTH = 5;
    private Context context;
    private final AtomicBoolean mBizCanceled;
    private final AtomicLong mCallEnd;
    private long mCallStart;
    private e mCipherSuite;
    private final List<Pair<InetSocketAddress, Integer>> mConnectAttemptsList;
    private long mConnectEnd;
    private long mConnectStart;
    private long mConnectionAcquired;
    private String mContentType;
    private BaseRequestContext mCtx;
    private final List<DispatchActionInfo> mDispatchActionChain;
    private long mDispatchTiming;
    private boolean mDispatched;
    private long mDnsEnd;
    private String mDnsInfoJson;
    private long mDnsStart;
    private String mFinalScheme;
    private Socket mFinalSocket;
    private HandshakeType mHandShakeType;
    private int mHostReplaceMapSize;
    private boolean mHostReplaceMaped;
    private int mHttpCode;
    private boolean mIsFromCache;
    private boolean mIsFromNetwork;
    private LoadState mLoadState;
    private TTMetaDispatchLog mMetaDispatchLog;
    private String mMethod;
    private int mNetError;
    private String mOriginUrl;
    private Protocol mProtocol;
    private Proxy.Type mProxyType;
    private final List<RedirectInfo> mRedirectInfoList;
    private int mRedirectTimes;
    private String mRemoteIp;
    private long mRequestBodyBytes;
    private long mRequestBodyEnd;
    private long mRequestBodyStart;
    private Headers mRequestHeaders;
    private long mRequestHeadersEnd;
    private long mRequestHeadersStart;
    private long mResponseBodyBytes;
    private long mResponseBodyEnd;
    private long mResponseBodyStart;
    private Headers mResponseHeaders;
    private long mResponseHeadersEnd;
    private long mResponseHeadersStart;
    private long mSslEnd;
    private long mSslStart;
    private Status mStatus;
    private TlsVersion mTlsVersion;
    private BaseHttpRequestInfo requestInfo;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.ok3.impl.OkHttp3RequestLog$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$okhttp3$Protocol = null;

        static {
            int[] r100 = new int[Protocol.values().length];
            $SwitchMap$okhttp3$Protocol = r100;
            r100[Protocol.HTTP_1_0.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$okhttp3$Protocol[Protocol.HTTP_1_1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$okhttp3$Protocol[Protocol.HTTP_2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$okhttp3$Protocol[Protocol.SPDY_3.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$okhttp3$Protocol[Protocol.QUIC.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    private static long validateAndSetDuration(long r100, long r101) {
        if (r101 != (-1)) goto L5;
    L8:
        return -1;
    L5:
        if (r100 == (-1)) goto L8;
        return r100 - r101;
    }

    private void onRequestFinished() {
        BaseHttpRequestInfo r100 = this.requestInfo;
        r100.nativeRequestStartTime = -1;
        r100.metrics.setKernelDns(validateAndSetDuration(this.mDnsEnd, this.mDnsStart));
        this.requestInfo.metrics.setKernelTCPConnect(validateAndSetDuration(this.mSslStart, this.mConnectStart));
        this.requestInfo.metrics.setKernelTls(validateAndSetDuration(this.mSslEnd, this.mSslStart));
        this.requestInfo.metrics.setKernelSend(validateAndSetDuration(this.mRequestHeadersEnd, this.mRequestHeadersStart) + validateAndSetDuration(this.mRequestBodyEnd, this.mRequestBodyStart));
        this.requestInfo.metrics.setKernelPush(-1);
        this.requestInfo.metrics.setKernelTTFB(-1);
        this.requestInfo.metrics.setKernelReceiveBody(validateAndSetDuration(this.mResponseBodyEnd, this.mResponseBodyStart));
        this.requestInfo.metrics.setKernelTotal(validateAndSetDuration(this.mCallEnd.get(), this.mCallStart));
        this.requestInfo.metrics.setNetworkKernelRawRequestLog(constructRequestLog(this.context));
        BaseHttpRequestInfo r101 = this.requestInfo;
        r101.remoteIp = this.mRemoteIp;
        if (this.mConnectStart == (-1)) goto L5;
    L7:
        boolean r102 = false;
    L8:
        r101.isSocketReused = r102;
        r101.sentByteCount = this.mRequestBodyBytes;
        long r103 = this.mResponseBodyBytes;
        r101.receivedByteCount = r103;
        r101.responseBodyByteCount = r103;
        r101.retryAttempts = -1;
        Headers r104 = this.mRequestHeaders;
        if (r104 == null) goto L11;
        r101.requestHeaders = formatJsonHeaders(r104);
        this.requestInfo.sentByteCount += this.mRequestHeaders.byteCount();
    L11:
        Headers r105 = this.mResponseHeaders;
        if (r105 == null) goto L14;
        this.requestInfo.responseHeaders = formatJsonHeaders(r105);
        this.requestInfo.receivedByteCount += this.mResponseHeaders.byteCount();
    L14:
        BaseHttpRequestInfo r106 = this.requestInfo;
        r106.contentType = this.mContentType;
        r106.metrics.markNetworkKernelLogCollected();
        return;
    L5:
        if (this.mConnectionAcquired == (-1)) goto L7;
        r102 = true;
        goto L8
    }

    public void bizCancel() {
        this.mBizCanceled.set(true);
    }

    public void callEnd() {
        if (this.mCallEnd.compareAndSet(-1, System.currentTimeMillis()) == true) goto L5;
        return;
    L5:
        this.mLoadState = LoadState.IDLE;
        this.mStatus = Status.SUCCESS;
        onRequestFinished();
    }

    public void requestHeadersStart() {
        this.mLoadState = LoadState.SENDING_REQUEST;
        this.mRequestHeadersStart = System.currentTimeMillis();
    }

    public void responseBodyStart() {
        this.mLoadState = LoadState.READING_RESPONSE;
        this.mResponseBodyStart = System.currentTimeMillis();
    }

    public void callStart() {
        this.mCallStart = System.currentTimeMillis();
        this.mStatus = Status.IO_PENDING;
    }

    public void connectStart() {
        this.mConnectStart = System.currentTimeMillis();
        this.mLoadState = LoadState.CONNECTING;
    }

    public void dnsEnd() {
        this.mDnsEnd = System.currentTimeMillis();
    }

    public void dnsStart() {
        this.mDnsStart = System.currentTimeMillis();
        this.mLoadState = LoadState.RESOLVING_HOST;
    }

    public void requestBodyStart() {
        this.mRequestBodyStart = System.currentTimeMillis();
    }

    public void responseHeadersStart() {
        this.mResponseHeadersStart = System.currentTimeMillis();
    }

    public void secureConnectEnd() {
        this.mSslEnd = System.currentTimeMillis();
    }

    public void secureConnectStart() {
        this.mSslStart = System.currentTimeMillis();
        this.mLoadState = LoadState.SSL_HANDSHAKE;
    }

    private String constructRequestLog(Context r210) {
        String r100 = "Cookie";
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L294
        String r110 = URLDispatcher.inst().getTncAbTest();     // Catch: JSONException -> L294
        ArrayList r111 = new ArrayList();     // Catch: JSONException -> L294
        if (TextUtils.isEmpty(r110) == true) goto L8;
        String[] r112 = r110.split(",");     // Catch: JSONException -> L294
        if (r112 == null) goto L8;
        r111.addAll(Arrays.asList(r112));     // Catch: JSONException -> L294
    L8:
        a r113 = SsOkHttp3Client.getOkHttpAppInfoProvider();     // Catch: JSONException -> L294
        if (r113 == null) goto L24;
        List<String> r114 = r113.getAbSdkVersion();     // Catch: JSONException -> L294
        if (r114 == null) goto L24;
        if (r114.size() > 5) goto L15;
    L17:
        Iterator<String> r115 = r114.iterator();     // Catch: JSONException -> L294
        int r116 = 0;
    L19:
        if (r115.hasNext() == false) goto L24;
        String r117 = r115.next();     // Catch: JSONException -> L294
        r116 = r116 + 1;     // Catch: JSONException -> L294
        if (r116 > 5) goto L24;
        r111.add(r117);     // Catch: JSONException -> L294
        goto L19
    L15:
        if (Logger.debug() == false) goto L17;
        Logger.d("ok3log", "ab sdk version count must less than 5");     // Catch: JSONException -> L294
    L24:
        JSONArray r118 = new JSONArray();     // Catch: JSONException -> L294
        Iterator r119 = r111.iterator();     // Catch: JSONException -> L294
    L26:
        if (r119.hasNext() == false) goto L30;
        String r120 = (String) r119.next();     // Catch: JSONException -> L294
        if (TextUtils.isEmpty(r120) == true) goto L26;
        r118.put(r120);     // Catch: JSONException -> L294
        goto L26
    L30:
        r102.put(BaseHttpRequestInfo.KEY_HIT, r118);     // Catch: JSONException -> L294
        r101.put(BaseHttpRequestInfo.KEY_ABTEST, r102);     // Catch: JSONException -> L294
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L294
        r103.put("load_state", this.mLoadState.ordinal());     // Catch: JSONException -> L294
        r103.put(com.alipay.sdk.m.p.e.f25671s, this.mMethod);     // Catch: JSONException -> L294
        if (this.mStatus != Status.IO_PENDING) goto L33;
        boolean r121 = true;
    L34:
        r103.put("is_pending", r121);     // Catch: JSONException -> L294
        r103.put("status", this.mStatus);     // Catch: JSONException -> L294
        if (this.mStatus == Status.SUCCESS) goto L39;
        r103.put("net_error", this.mNetError);     // Catch: JSONException -> L294
    L39:
        if (TextUtils.isEmpty(this.mOriginUrl) == true) goto L49;
        Uri r122 = UriProtector.parse(this.mOriginUrl);     // Catch: JSONException -> L294
        if (r122 == null) goto L49;
        if (TextUtils.isEmpty(r122.getScheme()) == true) goto L49;
        if (TextUtils.isEmpty(r122.getHost()) == true) goto L49;
        if (r122.getPath() == null) goto L49;
        r103.put("origin_url", r122.getScheme() + "://" + r122.getHost() + r122.getPath());     // Catch: JSONException -> L294
    L49:
        r103.put("redirect_times", this.mRedirectTimes);     // Catch: JSONException -> L294
        JSONArray r123 = new JSONArray();     // Catch: JSONException -> L294
        JSONArray r124 = new JSONArray();     // Catch: JSONException -> L294
        Iterator<RedirectInfo> r125 = this.mRedirectInfoList.iterator();     // Catch: JSONException -> L294
    L52:
        if (r125.hasNext() == false) goto L66;
        RedirectInfo r126 = r125.next();     // Catch: JSONException -> L294
        Iterator<RedirectInfo> r127 = r125;
        JSONObject r128 = new JSONObject();     // Catch: JSONException -> L294
        String r129 = r100;
        r128.put("code", r126.mCode);     // Catch: JSONException -> L294
        r128.put(com.alipay.sdk.m.p.e.f25671s, r126.mMethod);     // Catch: JSONException -> L294
        r128.put("internal", r126.mInternal);     // Catch: JSONException -> L294
        String r104 = r126.mUrl;     // Catch: JSONException -> L294
        if (r104 == null) goto L65;
        Uri r105 = UriProtector.parse(r104);     // Catch: JSONException -> L294
        if (r105 == null) goto L65;
        if (TextUtils.isEmpty(r105.getScheme()) == true) goto L65;
        if (TextUtils.isEmpty(r105.getHost()) == true) goto L65;
        String r130 = r105.getScheme() + "://" + r105.getHost();     // Catch: JSONException -> L294
        r124.put(r130);     // Catch: JSONException -> L294
        if (r105.getPath() == null) goto L64;
        r130 = r130 + r105.getPath();     // Catch: JSONException -> L294
    L64:
        r128.put("url", r130);     // Catch: JSONException -> L294
    L65:
        r123.put(r128);     // Catch: JSONException -> L294
        r125 = r127;
        r100 = r129;
        goto L52
    L66:
        String r131 = r100;
        r103.put("redirect_info", r123);     // Catch: JSONException -> L294
        r103.put("redirecting_list", r124);     // Catch: JSONException -> L294
        r103.put("dispatched", this.mDispatched);     // Catch: JSONException -> L294
        r101.put("base", r103);     // Catch: JSONException -> L294
        JSONObject r106 = new JSONObject();     // Catch: JSONException -> L294
        r106.put("code", this.mHttpCode);     // Catch: JSONException -> L294
        r106.put("connection_info", transProtocolToEnum(this.mProtocol).mValue);     // Catch: JSONException -> L294
        Headers r107 = this.mRequestHeaders;     // Catch: JSONException -> L294
        if (r107 == null) goto L69;
        long r132 = r107.byteCount();     // Catch: JSONException -> L294
    L70:
        r106.put(StreamTrafficObservable.STREAM_SENTBYTES, this.mRequestBodyBytes + r132);     // Catch: JSONException -> L294
        Headers r108 = this.mResponseHeaders;     // Catch: JSONException -> L294
        if (r108 == null) goto L73;
        long r133 = r108.byteCount();     // Catch: JSONException -> L294
    L74:
        r106.put(StreamTrafficObservable.STREAM_RECEIVEDBYTES, this.mResponseBodyBytes + r133);     // Catch: JSONException -> L294
        r106.put("cached", this.mIsFromCache);     // Catch: JSONException -> L294
        r106.put("network_accessed", this.mIsFromNetwork);     // Catch: JSONException -> L294
        if (this.mProxyType == Proxy.Type.DIRECT) goto L77;
        boolean r134 = true;
    L78:
        r106.put("via_proxy", r134);     // Catch: JSONException -> L294
        Headers r109 = this.mResponseHeaders;     // Catch: JSONException -> L294
        if (r109 == null) goto L93;
        List<String> r135 = r109.values("Set-Cookie");     // Catch: JSONException -> L294
        if (CollectionUtils.isEmpty(r135) == true) goto L83;
        boolean r136 = true;
    L84:
        r106.put("set_cookie", r136);     // Catch: JSONException -> L294
        if (r136 == false) goto L93;
        r106.put("set_cookie_lines", r135.size());     // Catch: JSONException -> L294
        Iterator<String> r137 = r135.iterator();     // Catch: JSONException -> L294
        long r138 = 0;
    L88:
        if (r137.hasNext() == false) goto L92;
        String r139 = r137.next();     // Catch: JSONException -> L294
        if (r139 == null) goto L88;
        r138 = r138 + ((long) r139.length());     // Catch: JSONException -> L294
        goto L88
    L92:
        r106.put("set_cookie_bytes", r138);     // Catch: JSONException -> L294
        goto L93
    L83:
        r136 = false;
    L93:
        r101.put("response", r106);     // Catch: JSONException -> L294
        JSONObject r140 = new JSONObject();     // Catch: JSONException -> L294
        if (this.mResponseHeaders == null) goto L136;
        int r141 = 0;
    L98:
        if (r141 >= this.mResponseHeaders.size()) goto L120;
        String r142 = this.mResponseHeaders.name(r141);     // Catch: JSONException -> L294
        String r143 = this.mResponseHeaders.value(r141);     // Catch: JSONException -> L294
        if (TextUtils.isEmpty(r142) == true) goto L119;
        if (TextUtils.isEmpty(r143) == true) goto L119;
        String r144 = r142.toLowerCase();     // Catch: JSONException -> L294
        if (r144.startsWith("x-tt-") == false) goto L119;
        if (r144.contains("sids") == true) goto L119;
        if (r144.contains(AppbrandHostConstants.SCHEMA_INSPECT.SESSION) == true) goto L119;
        if (r144.contains("token") == true) goto L119;
        if (r144.contains("uid") == true) goto L119;
        if (r144.contains("sign") == true) goto L119;
        r140.put(r142, r143);     // Catch: JSONException -> L294
    L119:
        r141 = r141 + 1;     // Catch: JSONException -> L294
        goto L98
    L120:
        String r145 = this.mResponseHeaders.get("tt-idc-switch");     // Catch: JSONException -> L294
        if (TextUtils.isEmpty(r145) == true) goto L123;
        r140.put("tt-idc-switch", r145);     // Catch: JSONException -> L294
    L123:
        String r146 = this.mResponseHeaders.get("server-timing");     // Catch: JSONException -> L294
        if (TextUtils.isEmpty(r146) == true) goto L126;
        r140.put("server-timing", r146);     // Catch: JSONException -> L294
    L126:
        List<String> r147 = MiscConfigManager.inst().getRequestLogHeaderRmList();     // Catch: JSONException -> L294
        if (CollectionUtils.isEmpty(r147) == true) goto L135;
        Iterator<String> r148 = r147.iterator();     // Catch: JSONException -> L294
    L130:
        if (r148.hasNext() == false) goto L135;
        String r149 = r148.next();     // Catch: JSONException -> L294
        if (TextUtils.isEmpty(r149) == true) goto L130;
        r140.remove(r149);     // Catch: JSONException -> L294
    L135:
        r101.put("header", r140);     // Catch: JSONException -> L294
    L137:
        JSONObject r150 = new JSONObject();     // Catch: JSONException -> L294
        r150.put("libcore", "okhttp");     // Catch: JSONException -> L294
        r150.put("core_ver", SsOkHttp3Client.getOkVersion());     // Catch: JSONException -> L294
        r150.put(LocationMonitorConst.IS_MAIN_PROCESS, i.d(r210));     // Catch: JSONException -> L294
        r150.put("ttnet_version", BuildConfig.VERSION_NAME);     // Catch: JSONException -> L294
        r150.put("retry_attempts", -1);     // Catch: JSONException -> L294
        BaseRequestContext r151 = this.mCtx;     // Catch: JSONException -> L294
        if (r151 == null) goto L140;
        r151.getClass();     // Catch: JSONException -> L294
    L140:
        r101.put("other", r150);     // Catch: JSONException -> L294
        JSONObject r152 = new JSONObject();     // Catch: JSONException -> L294
        JSONObject r153 = new JSONObject();     // Catch: JSONException -> L294
        r153.put(MultiProcessFileUtils.KEY_DNS, validateAndSetDuration(this.mDnsEnd, this.mDnsStart));     // Catch: JSONException -> L294
        r153.put("tcp", validateAndSetDuration(this.mSslStart, this.mConnectStart));     // Catch: JSONException -> L294
        r153.put(TTVideoEngineInterface.PLAY_API_KEY_SSL, validateAndSetDuration(this.mSslEnd, this.mSslStart));     // Catch: JSONException -> L294
        Object r154 = "";
        r153.put("send", validateAndSetDuration(this.mRequestHeadersEnd, this.mRequestHeadersStart) + validateAndSetDuration(this.mRequestBodyEnd, this.mRequestBodyStart));     // Catch: JSONException -> L294
        long r155 = validateAndSetDuration(this.mResponseHeadersEnd, this.mRequestHeadersEnd);     // Catch: JSONException -> L294
        r153.put(MonitorConstants.TTFB, r155);     // Catch: JSONException -> L294
        r153.put("header_recv", validateAndSetDuration(this.mResponseHeadersEnd, this.mResponseHeadersStart));     // Catch: JSONException -> L294
        r153.put("body_recv", validateAndSetDuration(this.mResponseBodyEnd, this.mResponseBodyStart));     // Catch: JSONException -> L294
        r153.put("dispatch", this.mDispatchTiming);     // Catch: JSONException -> L294
        getServerTimingInfo(r146, r153, r155);     // Catch: JSONException -> L294
        TTMetaDispatchLog r156 = this.mMetaDispatchLog;     // Catch: JSONException -> L294
        if (r156 == null) goto L146;
        long r157 = r156.dispatchCostMs;     // Catch: JSONException -> L294
        if (r157 < 0) goto L146;
        r153.put("meta_dp", r157);     // Catch: JSONException -> L294
    L146:
        r152.put("detailed_duration", r153);     // Catch: JSONException -> L294
        JSONObject r158 = new JSONObject();     // Catch: JSONException -> L294
        r158.put(ILoadStallMonitor.START_TIME, this.mCallStart);     // Catch: JSONException -> L294
        r158.put("duration", validateAndSetDuration(this.mCallEnd.get(), this.mCallStart));     // Catch: JSONException -> L294
        r158.put("request_sent_time", this.mRequestHeadersStart);     // Catch: JSONException -> L294
        r158.put("response_recv_time", this.mResponseHeadersStart);     // Catch: JSONException -> L294
        r152.put("request", r158);     // Catch: JSONException -> L294
        r101.put("timing", r152);     // Catch: JSONException -> L294
        JSONObject r159 = new JSONObject();     // Catch: JSONException -> L294
        Socket r160 = this.mFinalSocket;     // Catch: JSONException -> L294
        if (r160 == null) goto L165;
        InetAddress r161 = r160.getInetAddress();     // Catch: JSONException -> L294
        if (r161 == null) goto L165;
        AddressFamily r162 = AddressFamily.ADDRESS_FAMILY_UNSPECIFIED;     // Catch: JSONException -> L294
        if ((r161 instanceof Inet4Address) == false) goto L154;
        r162 = AddressFamily.ADDRESS_FAMILY_IPV4;     // Catch: JSONException -> L294
    L156:
        r159.put("address_family", r162.ordinal());     // Catch: JSONException -> L294
        if (this.mConnectStart == (-1)) goto L159;
    L161:
        boolean r163 = false;
    L162:
        r159.put("socket_reused", r163);     // Catch: JSONException -> L294
        if (r161.getHostAddress() == null) goto L165;
        r159.put("remote", r161.getHostAddress());     // Catch: JSONException -> L294
        goto L165
    L159:
        if (this.mConnectionAcquired == (-1)) goto L161;
        r163 = true;
        goto L162
    L154:
        if ((r161 instanceof Inet6Address) == false) goto L156;
        r162 = AddressFamily.ADDRESS_FAMILY_IPV6;     // Catch: JSONException -> L294
    L165:
        JSONArray r164 = new JSONArray();     // Catch: JSONException -> L294
        Iterator<Pair<InetSocketAddress, Integer>> r165 = this.mConnectAttemptsList.iterator();     // Catch: JSONException -> L294
    L167:
        if (r165.hasNext() == false) goto L169;
        Pair<InetSocketAddress, Integer> r166 = r165.next();     // Catch: JSONException -> L294
        JSONObject r167 = new JSONObject();     // Catch: JSONException -> L294
        r167.put("address", ((InetSocketAddress) r166.first).toString().substring(1));     // Catch: JSONException -> L294
        r167.put("result", r166.second);     // Catch: JSONException -> L294
        r164.put(r167);     // Catch: JSONException -> L294
        goto L167
    L169:
        r159.put("connection_attempts", r164);     // Catch: JSONException -> L294
        r101.put("socket", r159);     // Catch: JSONException -> L294
        JSONObject r168 = new JSONObject();     // Catch: JSONException -> L294
        r168.put("handshake_type", this.mHandShakeType.ordinal());     // Catch: JSONException -> L294
        r168.put("cipher_suite", this.mCipherSuite);     // Catch: JSONException -> L294
        r168.put("ssl_version", this.mTlsVersion);     // Catch: JSONException -> L294
        r101.put(TTVideoEngineInterface.PLAY_API_KEY_SSL, r168);     // Catch: JSONException -> L294
        JSONObject r169 = new JSONObject();     // Catch: JSONException -> L294
        JSONArray r170 = new JSONArray();     // Catch: JSONException -> L294
        if (this.mHostReplaceMaped == true) goto L173;
        List<DispatchActionInfo> r171 = this.mDispatchActionChain;     // Catch: JSONException -> L294
        if (r171 == null) goto L198;
        Iterator<DispatchActionInfo> r172 = r171.iterator();     // Catch: JSONException -> L294
    L178:
        if (r172.hasNext() == false) goto L198;
        DispatchActionInfo r173 = r172.next();     // Catch: JSONException -> L294
        JSONObject r174 = new JSONObject();     // Catch: JSONException -> L294
        if (r173.mActionHit == false) goto L196;
        r174.put("priority", r173.mPriority);     // Catch: JSONException -> L294
        r174.put("type", r173.mStrategyType);     // Catch: JSONException -> L294
        r174.put("action_hit", r173.mActionHit);     // Catch: JSONException -> L294
        if (TextUtils.isEmpty(r173.mDispatchedUrl) == true) goto L188;
        Uri r175 = UriProtector.parse(r173.mDispatchedUrl);     // Catch: JSONException -> L294
        if (r175.getHost() == null) goto L187;
        r174.put("replace_host", r175.getHost());     // Catch: JSONException -> L294
    L187:
        Object r176 = r154;
    L189:
        r174.put("feedback", r173.mNeedFeedBack);     // Catch: JSONException -> L294
        long r177 = r173.mRuleid;     // Catch: JSONException -> L294
        if (r177 <= 0) goto L193;
        r174.put("rule_id", r177);     // Catch: JSONException -> L294
    L193:
        if (TextUtils.isEmpty(r173.mServiceName) == true) goto L195;
        r174.put("service_name", r173.mServiceName);     // Catch: JSONException -> L294
    L195:
        r170.put(r174);     // Catch: JSONException -> L294
    L197:
        r154 = r176;
        goto L178
    L188:
        r176 = r154;
        r174.put("replace_host", r176);     // Catch: JSONException -> L294
        goto L189
    L196:
        r176 = r154;
    L198:
        r169.put("action_info", r170);     // Catch: JSONException -> L294
        r169.put("empty_action", URLDispatcher.inst().isDispatchActionsEmpty());     // Catch: JSONException -> L294
        r169.put("host_replace_map", 0);     // Catch: JSONException -> L294
    L199:
        r169.put("source", URLDispatcher.inst().getTncUpdateSource());     // Catch: JSONException -> L294
        r169.put("update_time", URLDispatcher.inst().getTncUpdateTime());     // Catch: JSONException -> L294
        r169.put(URLDispatch.KEY_EPOCH, URLDispatcher.inst().getEpoch());     // Catch: JSONException -> L294
        r101.put("url_dispatch", r169);     // Catch: JSONException -> L294
        if (TextUtils.isEmpty(URLDispatcher.inst().getTncEtag()) == true) goto L203;
        r101.put("tt_tnc_etag", URLDispatcher.inst().getTncEtag());     // Catch: JSONException -> L294
    L203:
        if (this.mMetaDispatchLog == null) goto L228;
        JSONObject r178 = new JSONObject();     // Catch: JSONException -> L294
        Set<String> r179 = this.mMetaDispatchLog.headerAdd;     // Catch: JSONException -> L294
        if (r179 != null) goto L207;
    L209:
        Set<String> r180 = this.mMetaDispatchLog.headerRm;     // Catch: JSONException -> L294
        if (r180 != null) goto L212;
    L214:
        Set<String> r181 = this.mMetaDispatchLog.queryAdd;     // Catch: JSONException -> L294
        if (r181 != null) goto L217;
    L219:
        Set<String> r182 = this.mMetaDispatchLog.queryRm;     // Catch: JSONException -> L294
        if (r182 == null) goto L225;
        if (r182.isEmpty() == true) goto L225;
        r178.put("query_rm", this.mMetaDispatchLog.queryRm);     // Catch: JSONException -> L294
    L225:
        if (r178.length() <= 0) goto L228;
        r101.put("meta_dp", r178);     // Catch: JSONException -> L294
        goto L228
    L217:
        if (r181.isEmpty() == true) goto L219;
        r178.put("query_add", this.mMetaDispatchLog.queryAdd);     // Catch: JSONException -> L294
        goto L219
    L212:
        if (r180.isEmpty() == true) goto L214;
        r178.put("header_rm", this.mMetaDispatchLog.headerRm);     // Catch: JSONException -> L294
        goto L214
    L207:
        if (r179.isEmpty() == true) goto L209;
        r178.put("header_add", this.mMetaDispatchLog.headerAdd);     // Catch: JSONException -> L294
    L228:
        if (TextUtils.isEmpty(this.mDnsInfoJson) == false) goto L299;
    L230:
        JSONObject r183 = new JSONObject();     // Catch: JSONException -> L294
        BaseRequestContext r184 = this.mCtx;     // Catch: JSONException -> L294
        if (r184 == null) goto L244;
        long r185 = r184.protect_timeout;     // Catch: JSONException -> L294
        if (r185 <= 0) goto L235;
        r183.put("protect", r185);     // Catch: JSONException -> L294
    L235:
        long r186 = this.mCtx.socket_connect_timeout;     // Catch: JSONException -> L294
        if (r186 <= 0) goto L238;
        r183.put("connect", r186);     // Catch: JSONException -> L294
    L238:
        long r187 = this.mCtx.timeout_read;     // Catch: JSONException -> L294
        if (r187 <= 0) goto L241;
        r183.put("read", r187);     // Catch: JSONException -> L294
    L241:
        long r188 = this.mCtx.timeout_write;     // Catch: JSONException -> L294
        long r189 = 0;
        if (r188 <= 0) goto L245;
        r183.put("write", r188);     // Catch: JSONException -> L294
    L245:
        r101.put("socket_timeout_param", r183);     // Catch: JSONException -> L294
        JSONObject r190 = new JSONObject();     // Catch: JSONException -> L294
        r190.put("ipv4_reachable", NetworkUtils.isNetworkAvailable(r210));     // Catch: JSONException -> L294
        r190.put("ipv6_reachable", Ipv6ConnectionManager.getIpv6GloballyReachable().get());     // Catch: JSONException -> L294
        r101.put("ifconfig", r190);     // Catch: JSONException -> L294
        if (SsOkHttp3Client.getOk3TncBridge() == null) goto L251;
        Object r191 = SsOkHttp3Client.getOk3TncBridge().getTNCInfo();     // Catch: JSONException -> L294
        if (r191 == null) goto L251;
        r101.put("tnc", r191);     // Catch: JSONException -> L294
    L251:
        if (b.g().f() == null) goto L254;
        r101.put(CronetDataStorageAccess.STORE_IDC, b.g().f());     // Catch: JSONException -> L294
    L254:
        if (this.mRequestHeaders == null) goto L297;
        JSONObject r192 = new JSONObject();     // Catch: JSONException -> L294
        List<String> r193 = this.mRequestHeaders.values(r131);     // Catch: JSONException -> L294
        if (CollectionUtils.isEmpty(r193) == true) goto L258;
        boolean r194 = true;
    L259:
        r192.put(r131, r194);     // Catch: JSONException -> L294
        if (r194 == false) goto L268;
        Iterator<String> r195 = r193.iterator();     // Catch: JSONException -> L294
        long r196 = r189;
    L263:
        if (r195.hasNext() == false) goto L267;
        String r197 = r195.next();     // Catch: JSONException -> L294
        if (r197 == null) goto L263;
        r196 = r196 + ((long) r197.length());     // Catch: JSONException -> L294
        goto L263
    L267:
        r192.put("add_cookie_bytes", r196);     // Catch: JSONException -> L294
    L268:
        String r198 = this.mRequestHeaders.get("x-tt-token");     // Catch: JSONException -> L294
        if (r198 == null) goto L274;
        if (r198.isEmpty() == true) goto L274;
        r192.put("token_md5", ByteString.encodeUtf8(r198).md5().hex());     // Catch: JSONException -> L294
    L274:
        if ("http".equalsIgnoreCase(this.mFinalScheme) == false) goto L292;
        if (r193 != null) goto L277;
    L285:
        Set<String> r199 = ix5.a.b(this.mRequestHeaders);     // Catch: JSONException -> L294
        if (r199 == null) goto L292;
        JSONArray r200 = new JSONArray();     // Catch: JSONException -> L294
        Iterator<String> r201 = r199.iterator();     // Catch: JSONException -> L294
    L289:
        if (r201.hasNext() == false) goto L291;
        r200.put(r201.next());     // Catch: JSONException -> L294
        goto L289
    L291:
        r192.put("insecure_headers", r200);     // Catch: JSONException -> L294
        goto L292
    L277:
        if (r193.isEmpty() == true) goto L285;
        Set<String> r202 = ix5.a.a(r193);     // Catch: JSONException -> L294
        if (r202 == null) goto L285;
        JSONArray r203 = new JSONArray();     // Catch: JSONException -> L294
        Iterator<String> r204 = r202.iterator();     // Catch: JSONException -> L294
    L282:
        if (r204.hasNext() == false) goto L284;
        r203.put(r204.next());     // Catch: JSONException -> L294
        goto L282
    L284:
        r192.put("insecure_cookies", r203);     // Catch: JSONException -> L294
    L292:
        r101.put(AppbrandHostConstants.SCHEMA_INSPECT.SESSION, r192);     // Catch: JSONException -> L294
        goto L297
    L258:
        r194 = false;
    L297:
        return r101.toString();
    L244:
        r189 = 0;
        goto L245
    L299:
        r101.put(MultiProcessFileUtils.KEY_DNS, new JSONObject(this.mDnsInfoJson));     // Catch: JSONException -> L298
        goto L230
    L173:
        r169.put("host_replace_map", 1);     // Catch: JSONException -> L294
        r169.put("host_replace_map_size", this.mHostReplaceMapSize);     // Catch: JSONException -> L294
        goto L199
    L136:
        r146 = "";
        goto L137
    L77:
        r134 = false;
        goto L78
    L73:
        r133 = 0;
        goto L74
    L69:
        r132 = 0;
        goto L70
    L33:
        r121 = false;
    L294:
        e = move-exception;
        e.printStackTrace();
        goto L297
    }

    public static int convertExceptionToErrorCode(IOException r100) {
        if ((r100 instanceof SSLHandshakeException) == false) goto L6;
        return NetError.ERR_SSL_HANDSHAKE_NOT_COMPLETED;
    L6:
        if ((r100 instanceof SSLKeyException) == false) goto L9;
        return NetError.ERR_SSL_BAD_PEER_PUBLIC_KEY;
    L9:
        if ((r100 instanceof SSLProtocolException) == false) goto L12;
        return -107;
    L12:
        if ((r100 instanceof SSLPeerUnverifiedException) == false) goto L15;
        return NetError.ERR_SSL_DECRYPT_ERROR_ALERT;
    L15:
        if ((r100 instanceof UnknownHostException) == false) goto L18;
        return -105;
    L18:
        if ((r100 instanceof ConnectException) == false) goto L21;
        return convertConnectException(r100, -104);
    L21:
        if ((r100 instanceof PortUnreachableException) == false) goto L24;
        return -108;
    L24:
        if ((r100 instanceof NoRouteToHostException) == false) goto L27;
        return -109;
    L27:
        if ((r100 instanceof BindException) == false) goto L30;
        return NetError.ERR_ADDRESS_IN_USE;
    L30:
        if ((r100 instanceof SocketException) == false) goto L33;
        return convertConnectException(r100, -15);
    L33:
        if ((r100 instanceof MalformedURLException) == false) goto L36;
        return -300;
    L36:
        if ((r100 instanceof SocketTimeoutException) == false) goto L39;
        return NetError.ERR_CONNECTION_TIMED_OUT;
    L39:
        if ((r100 instanceof ProtocolException) == false) goto L42;
        return -901;
    L42:
        if ((r100 instanceof HttpRetryException) == false) goto L50;
        String r101 = r100.getMessage();
        if (TextUtils.isEmpty(r101) == false) goto L46;
    L48:
        return NetError.ERR_TTNET_UNSUPPORTED_REDIRECT;
    L46:
        if (r101.contains("Too many follow-up requests") == false) goto L48;
        return NetError.ERR_TOO_MANY_REDIRECTS;
    L50:
        if ((r100 instanceof UnknownServiceException) == false) goto L52;
        return -902;
    L52:
        return -1;
    }

    private static String formatJsonHeaders(Headers r100) {
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L17
        Iterator<Map.Entry<String, List<String>>> r102 = r100.toMultimap().entrySet().iterator();     // Catch: Exception -> L17
    L4:
        if (r102.hasNext() == false) goto L15;
        Map.Entry<String, List<String>> r103 = r102.next();     // Catch: Exception -> L17
        String r104 = r103.getKey();     // Catch: Exception -> L17
        List<String> r105 = r103.getValue();     // Catch: Exception -> L17
        if (TextUtils.isEmpty(r104) == true) goto L4;
        if (r105 == null) goto L4;
        if (r105.size() <= 0) goto L4;
        Iterator<String> r106 = r105.iterator();     // Catch: Exception -> L17
    L13:
        if (r106.hasNext() == false) goto L4;
        r101.put(r104, r106.next());     // Catch: Exception -> L17
        goto L13
    L15:
        return r101.toString();
    L17:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static boolean isRequestTimeout(IOException r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ("Canceled#Reason=-192".equals(r100.getMessage()) == false) goto L9;
        return true;
    L9:
        if ((r100 instanceof InterruptedIOException) == false) goto L17;
        Throwable r101 = r100.getCause();
        if (r101 == null) goto L17;
        if (TextUtils.isEmpty(r101.getMessage()) == true) goto L17;
        if ("Canceled#Reason=-192".equals(r101.getMessage()) == false) goto L17;
        return true;
    L17:
        return false;
    }

    private static ConnectionInfo transProtocolToEnum(Protocol r100) {
        if (r100 == null) goto L4;
        int r101 = AnonymousClass1.$SwitchMap$okhttp3$Protocol[r100.ordinal()];
        if (r101 == 1) goto L26;
        if (r101 == 2) goto L24;
        if (r101 == 3) goto L22;
        if (r101 == 4) goto L20;
        if (r101 == 5) goto L18;
        return ConnectionInfo.CONNECTION_INFO_UNKNOWN;
    L18:
        return ConnectionInfo.CONNECTION_INFO_QUIC_UNKNOWN_VERSION;
    L20:
        return ConnectionInfo.CONNECTION_INFO_DEPRECATED_SPDY3;
    L22:
        return ConnectionInfo.CONNECTION_INFO_HTTP2;
    L24:
        return ConnectionInfo.CONNECTION_INFO_HTTP1_1;
    L26:
        return ConnectionInfo.CONNECTION_INFO_HTTP1_0;
    L4:
        return ConnectionInfo.CONNECTION_INFO_UNKNOWN;
    }

    private static long validateAndGetServerTiming(String r100) {
        String[] r101 = r100.split(ContainerUtils.KEY_VALUE_DELIMITER);
        if (r101.length == 2) goto L12;
        return -1;
    L12:
        long r102 = CastLongProtector.parseLong(r101[1]);     // Catch: NumberFormatException -> L11
        if (r102 >= 0) goto L10;
        return -1;
    L10:
        return r102;
    L16:
        return -1;
    }

    public void callFailed(IOException r100) {
        if (this.mCallEnd.compareAndSet(-1, System.currentTimeMillis()) == true) goto L6;
        return;
    L6:
        if (this.mBizCanceled.get() == false) goto L8;
        r100 = new IOException("Biz Canceled");
    L8:
        this.mLoadState = LoadState.IDLE;
        if (r100 != null) goto L11;
    L15:
        this.mStatus = Status.FAILED;
    L16:
        this.mNetError = convertExceptionToErrorCode(r100);
        onRequestFinished();
        return;
    L11:
        if (TextUtils.isEmpty(r100.getMessage()) == true) goto L15;
        if (r100.getMessage().contains("Canceled") == false) goto L15;
        this.mStatus = Status.CANCELED;
        goto L16
    }

    public void connectEnd(Proxy r100) {
        this.mConnectEnd = System.currentTimeMillis();
        if (r100 == null) goto L6;
        this.mProxyType = r100.type();
        return;
    }

    public void connectionAcquired(Connection r100) {
        if (r100 != null) goto L4;
    L13:
        this.mConnectionAcquired = System.currentTimeMillis();
        return;
    L4:
        if (this.mCallEnd.get() != (-1)) goto L13;
        if (r100.socket() != null) goto L8;
    L12:
        this.mFinalSocket = r100.socket();
        goto L13
    L8:
        if (r100.socket().getInetAddress() == null) goto L12;
        if (r100.socket().getInetAddress().getHostAddress() == null) goto L12;
        this.mRemoteIp = r100.socket().getInetAddress().getHostAddress();
        goto L12
    }

    public void dnsEnd(String r100) {
        this.mDnsEnd = System.currentTimeMillis();
        this.mDnsInfoJson = r100;
    }

    public void recordMetaDispatchLog(TTMetaDispatchLog r100) {
        this.mMetaDispatchLog = r100;
    }

    public void requestBodyEnd(long r100) {
        this.mRequestBodyEnd = System.currentTimeMillis();
        this.mRequestBodyBytes = r100;
    }

    public void requestHeadersEnd(Request r100) {
        this.mRequestHeadersEnd = System.currentTimeMillis();
        if (r100 != null) goto L5;
    L9:
        this.mLoadState = LoadState.WAITING_FOR_RESPONSE;
        return;
    L5:
        if (this.mCallEnd.get() != (-1)) goto L9;
        this.mRequestHeaders = r100.headers();
        if (r100.url() == null) goto L9;
        this.mFinalScheme = r100.url().scheme();
        goto L9
    }

    public void responseBodyEnd(long r100) {
        this.mResponseBodyEnd = System.currentTimeMillis();
        this.mResponseBodyBytes = r100;
    }

    public void responseHeadersEnd(Response r100) {
        this.mResponseHeadersEnd = System.currentTimeMillis();
        if (this.mSslEnd == (-1)) goto L5;
        this.mHandShakeType = HandshakeType.HANDSHAKE_FULL;
    L6:
        if (r100 != null) goto L8;
        return;
    L8:
        if (this.mCallEnd.get() != (-1)) goto L38;
        this.mHttpCode = r100.code();
        this.mProtocol = r100.protocol();
        if (r100.handshake() == null) goto L14;
        this.mTlsVersion = r100.handshake().f523919a;
        this.mCipherSuite = r100.handshake().f523920b;
    L14:
        if (r100.isRedirect() == false) goto L29;
        this.mRedirectTimes++;
        RedirectInfo r101 = new RedirectInfo();
        r101.mCode = r100.code();
        r101.mMethod = r100.request().method();
        String r102 = r100.header("location");
        if (TextUtils.isEmpty(r102) == false) goto L35;
    L27:
        this.mRedirectInfoList.add(r101);
        goto L29
    L35:
        HttpUrl r103 = r100.request().url().resolve(r102);     // Catch: Throwable -> L23
        if (r103 == null) goto L25;
        if (TextUtils.isEmpty(r103.host()) == true) goto L25;
        r101.mUrl = r103.toString();     // Catch: Throwable -> L23
    L25:
        if (TextUtils.isEmpty(r101.mUrl) == false) goto L27;
        r101.mUrl = r102;
    L29:
        if (r100.isSuccessful() == false) goto L33;
        String r104 = r100.header(com.alipay.sdk.m.p.e.f25658f);
        if (TextUtils.isEmpty(r104) == true) goto L33;
        this.mContentType = r104;
    L33:
        this.mResponseHeaders = r100.headers();
        return;
    L38:
        return;
    L5:
        this.mHandShakeType = HandshakeType.HANDSHAKE_RESUME;
        goto L6
    }

    public void setNetError(int r100) {
        this.mNetError = r100;
    }

    public void setRequestTimeout(BaseRequestContext r100) {
        this.mCtx = r100;
    }

    public void setResponseSource(Response r100) {
        boolean r101 = true;
        if (r100.cacheResponse() == null) goto L5;
        boolean r102 = true;
    L6:
        this.mIsFromCache = r102;
        if (r100.networkResponse() != null) goto L10;
        r101 = false;
    L10:
        this.mIsFromNetwork = r101;
        return;
    L5:
        r102 = false;
        goto L6
    }

    public OkHttp3RequestLog(BaseHttpRequestInfo r100, Context r101) {
        this.mCallStart = -1;
        this.mDnsStart = -1;
        this.mDnsEnd = -1;
        this.mConnectStart = -1;
        this.mConnectEnd = -1;
        this.mSslStart = -1;
        this.mSslEnd = -1;
        this.mRequestHeadersStart = -1;
        this.mRequestHeadersEnd = -1;
        this.mRequestBodyStart = -1;
        this.mRequestBodyEnd = -1;
        this.mResponseHeadersStart = -1;
        this.mResponseHeadersEnd = -1;
        this.mResponseBodyStart = -1;
        this.mResponseBodyEnd = -1;
        this.mCallEnd = new AtomicLong(-1);
        this.mConnectionAcquired = -1;
        this.mDispatchTiming = -1;
        this.mConnectAttemptsList = new ArrayList();
        this.mProxyType = Proxy.Type.DIRECT;
        this.mHandShakeType = HandshakeType.HANDSHAKE_UNKNOWN;
        this.mRequestBodyBytes = 0;
        this.mHttpCode = -1;
        this.mResponseBodyBytes = 0;
        this.mProtocol = null;
        this.mFinalScheme = "";
        this.mIsFromCache = false;
        this.mIsFromNetwork = false;
        this.mRemoteIp = "";
        this.mContentType = "";
        this.mRedirectTimes = 0;
        this.mRedirectInfoList = new ArrayList();
        this.mLoadState = LoadState.IDLE;
        this.mMethod = "";
        this.mNetError = -1;
        this.mStatus = Status.UNKNOWN;
        this.mOriginUrl = "";
        this.mDispatched = false;
        this.mHostReplaceMaped = false;
        this.mDispatchActionChain = new ArrayList();
        this.mHostReplaceMapSize = 0;
        this.mDnsInfoJson = "";
        this.mBizCanceled = new AtomicBoolean(false);
        this.requestInfo = r100;
        this.context = r101;
    }

    private static int convertConnectException(IOException r100, int r101) {
        if (r100 != null) goto L21;
        return r101;
    L21:
        int r102 = convertConnectionExceptionInternal(r100.getMessage(), r101);     // Catch: Throwable -> L18
        if (r102 == r101) goto L19;
        return r102;
    L19:
        Throwable r103 = r100.getCause();     // Catch: Throwable -> L15
        if (r103 != null) goto L10;
        return r102;
    L10:
        String r104 = r103.getMessage();     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r104) == false) goto L13;
        return r102;
    L13:
        return convertConnectionExceptionInternal(r104, r101);
    L15:
        r101 = r102;
    L17:
        return r101;
    }

    private static int convertConnectionExceptionInternal(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return r101;
    L6:
        if (r100.contains("ECONNRESET") == false) goto L8;
    L39:
        return -101;
    L8:
        if (r100.contains("Connection reset") == true) goto L39;
        if (r100.contains("reset by peer") == true) goto L39;
        if (r100.contains("ECONNREFUSED") == false) goto L16;
        return -102;
    L16:
        if (r100.contains("CONNECTION_ABORTED") == false) goto L18;
    L38:
        return -103;
    L18:
        if (r100.contains("connection abort") == true) goto L38;
        if (r100.contains("ENETDOWN") == false) goto L23;
    L37:
        return -106;
    L23:
        if (r100.contains("Network is unreachable") == true) goto L37;
        if (r100.contains("EHOSTUNREACH") == false) goto L28;
    L36:
        return -109;
    L28:
        if (r100.contains("ENETUNREACH") == true) goto L36;
        if (r100.contains("EADDRNOTAVAIL") == false) goto L34;
        return -108;
    L34:
        if (r100.contains("EADDRINUSE") == false) goto L43;
        return NetError.ERR_ADDRESS_IN_USE;
    L43:
        return r101;
    }

    public void setOriginUrl(String r100, String r101) {
        this.mOriginUrl = r100;
        this.mMethod = r101;
    }

    private void getServerTimingInfo(String r110, JSONObject r111, long r112) throws JSONException {
        HashMap r100 = new HashMap();
        ServerTimingInfo r101 = new ServerTimingInfo();
        if (TextUtils.isEmpty(r110) == true) goto L18;
        String[] r102 = r110.split(",");
        if (r102 == null) goto L18;
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L18;
        String[] r105 = r102[r104].split(com.alipay.sdk.m.u.i.f25853b);
        if (r105 == null) goto L17;
        if (r105.length != 2) goto L17;
        if (TextUtils.isEmpty(r105[0]) == true) goto L17;
        if (TextUtils.isEmpty(r105[1]) == true) goto L17;
        r100.put(r105[0], r105[1]);
    L17:
        r104 = r104 + 1;
    L18:
        Iterator r106 = r100.entrySet().iterator();
    L20:
        if (r106.hasNext() == false) goto L41;
        Map.Entry r107 = (Map.Entry) r106.next();
        String r113 = ((String) r107.getKey()).trim();
        String r108 = ((String) r107.getValue()).trim();
        if (r113.equalsIgnoreCase("cdn-cache") == true) goto L23;
        if (r113.equalsIgnoreCase("edge") == true) goto L31;
        if (r113.equalsIgnoreCase(PlayerResolution.SDKKEY.ORIGIN) == true) goto L34;
        if (r113.equalsIgnoreCase(RNParamRegisterEventHandler.SRC_INNER) == true) goto L37;
        if (TextUtils.isEmpty(r113) == true) goto L20;
        r111.put(r113, validateAndGetServerTiming(r108));
        goto L20
    L37:
        r101.mInner = validateAndGetServerTiming(r108);
        goto L20
    L34:
        r101.mOrigin = validateAndGetServerTiming(r108);
        goto L20
    L31:
        r101.mEdge = validateAndGetServerTiming(r108);
        goto L20
    L23:
        r101.mPassedCdn = true;
        String[] r109 = r108.split(ContainerUtils.KEY_VALUE_DELIMITER);
        if (r109.length != 2) goto L28;
        if (r109[1].equalsIgnoreCase(BaseHttpRequestInfo.KEY_HIT) == false) goto L28;
        r101.mCdnHitCache = true;
    L28:
        r101.mCdnHitCache = false;
        goto L20
    L41:
        boolean r114 = r101.mPassedCdn;
        if (r114 == true) goto L44;
    L51:
        if (r114 == false) goto L62;
        r111.put("edge", r101.mEdge);
        r111.put("cdn-cache", "miss");
        long r115 = r101.mOrigin;
        long r116 = r101.mInner;
        if (r115 <= r116) goto L55;
        r111.put(PlayerResolution.SDKKEY.ORIGIN, r115 - r116);
    L56:
        r111.put(RNParamRegisterEventHandler.SRC_INNER, r101.mInner);
        if (r112 == (-1)) goto L61;
        long r117 = r101.mOrigin;
        long r118 = r101.mEdge;
        if (r112 <= (r117 + r118)) goto L61;
        r101.mRtt = (r112 - r117) - r118;
    L61:
        r111.put("rtt", r101.mRtt);
        return;
    L55:
        r111.put(PlayerResolution.SDKKEY.ORIGIN, -1);
        goto L56
    L62:
        r111.put(RNParamRegisterEventHandler.SRC_INNER, r101.mInner);
        if (r112 == (-1)) goto L67;
        long r119 = r101.mInner;
        if (r112 <= r119) goto L67;
        r101.mRtt = r112 - r119;
    L67:
        r111.put("rtt", r101.mRtt);
        return;
    L44:
        if (r101.mCdnHitCache == false) goto L51;
        r111.put("edge", r101.mEdge);
        r111.put("cdn-cache", BaseHttpRequestInfo.KEY_HIT);
        if (r112 == (-1)) goto L50;
        long r120 = r101.mEdge;
        if (r112 <= r120) goto L50;
        r101.mRtt = r112 - r120;
    L50:
        r111.put("rtt", r101.mRtt);
    }

    public void connectFailed(InetSocketAddress r100, IOException r101, String r102) {
        this.mConnectEnd = System.currentTimeMillis();
        if (r100 == null) goto L8;
        if (this.mCallEnd.get() != (-1)) goto L8;
        this.mConnectAttemptsList.add(new Pair(r100, Integer.valueOf(convertExceptionToErrorCode(r101))));
    L8:
        if (TextUtils.isEmpty(this.mDnsInfoJson) == true) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r102) == true) goto L14;
        this.mDnsInfoJson = r102;
        return;
    }

    public void recordDispatchActionInfo(String r100, DispatchActionInfo r101, boolean r102) {
        if (r102 == false) goto L4;
        RedirectInfo r103 = new RedirectInfo();
        r103.mCode = 307;
        r103.mInternal = true;
        r103.mMethod = r100;
        r103.mUrl = r101.mDispatchedUrl;
        this.mRedirectInfoList.add(r103);
        this.mRedirectTimes++;
    L4:
        this.mDispatchActionChain.add(r101);
    }

    public void recordDispatchLog(String r100, String r101, long r102, boolean r103, List<DispatchActionInfo> r104) {
        RedirectInfo r105 = new RedirectInfo();
        r105.mCode = 307;
        r105.mInternal = true;
        r105.mMethod = r100;
        r105.mUrl = r101;
        this.mRedirectInfoList.add(r105);
        this.mRedirectTimes++;
        this.mDispatchTiming = r102;
        this.mDispatched = true;
        if (r103 == false) goto L5;
        this.mHostReplaceMaped = true;
        this.mHostReplaceMapSize = URLDispatcher.inst().getHostReplaceMap().size();
        return;
    L5:
        this.mDispatchActionChain.addAll(r104);
        this.mHostReplaceMaped = false;
    }
}
