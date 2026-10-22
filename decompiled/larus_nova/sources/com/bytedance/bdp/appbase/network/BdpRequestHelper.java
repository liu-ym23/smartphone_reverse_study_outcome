package com.bytedance.bdp.appbase.network;

import android.content.Context;
import android.os.Build;
import com.alipay.sdk.m.p.e;
import com.bytedance.bdp.appbase.context.BdpAppContext;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.hostimpl.account.BdpAccountService;
import com.bytedance.bdp.serviceapi.hostimpl.account.model.BdpUserInfo;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpInfoService;
import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import g94.b;
import gb4.c;
import gb4.d;
import java.io.File;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bM\u0010NJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0007J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0007JP\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0007J\u0006\u0010\u0016\u001a\u00020\bJ\u001c\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u001c\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u0002J\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u0002J\u000e\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u0002J&\u0010)\u001a\u00020(2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&J\u000e\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u0012J\u000e\u0010-\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\bJ\u001f\u00100\u001a\u00020\u001e*\u00020\u00122\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00020.¢\u0006\u0004\b0\u00101J\u0016\u00104\u001a\u00020\u001e*\u00020\u00122\n\u00103\u001a\u0006\u0012\u0002\b\u000302J\n\u00105\u001a\u00020\u0012*\u00020\u0012J\u0016\u0010:\u001a\u0002092\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020\u0002R\u0014\u0010;\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010=\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b=\u0010<R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010BR\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010BR\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010BR\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010BR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010BR\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010BR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010BR\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010BR\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010BR\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010B¨\u0006O"}, d2 = {"Lcom/bytedance/bdp/appbase/network/BdpRequestHelper;", "", "", "getTimezoneOffset", "Lorg/json/JSONObject;", "key", "", "optListString", "", "protocolNum", "getTTNetProtocol", "url", "netLib", "from", "code", "requestLog", "contentEncoding", "netMessage", "", LynxError.LYNX_THROWABLE, "", "reportNetworkEvent", "generateRequestId", "Lcom/bytedance/bdp/appbase/core/a;", "appInfo", "", "getBdpCommonParams", "Lcom/bytedance/bdp/appbase/context/BdpAppContext;", "appContext", e.f25671s, "", "requiresRequestBody", "permitsRequestBody", "content", "", "convertToBytes", "errorCode", "errorMsg", "Lcom/bytedance/bdp/appbase/network/BdpRequestType;", "libType", "Lcom/bytedance/bdp/appbase/network/BdpNetResponse;", "buildNativeErrorResponse", "e", "buildNativeErrorCode", "nativeErrorCode", "buildNativeErrorMsg", "", "errorDic", "isError", "(Ljava/lang/Throwable;[Ljava/lang/String;)Z", "Ljava/lang/Class;", "cls", "isException", "realCause", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "cacheId", "Ljava/io/File;", "getHttpCacheDir", "TAG", "Ljava/lang/String;", "CACHE_DIR_PREFIX", "Ljava/util/concurrent/atomic/AtomicInteger;", "ID_CREATOR", "Ljava/util/concurrent/atomic/AtomicInteger;", "mNetworkDisableDic", "[Ljava/lang/String;", "mDNSErrorDic", "mConnectTimeoutDic", "mConnectionErrorDic", "mErrorNetworkChangedDic", "mSSLErrorDic", "mCertErrorDic", "mAbortedErrorDic", "mCancelErrorDic", "mUrlErrorDic", "mIOErrorDic", "<init>", "()V", "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public final class BdpRequestHelper {
    private static final String CACHE_DIR_PREFIX = "TT/http_cache";
    private static final AtomicInteger ID_CREATOR = null;
    public static final BdpRequestHelper INSTANCE = null;
    private static final String TAG = "BdpRequestHelper";
    private static final String[] mAbortedErrorDic = null;
    private static final String[] mCancelErrorDic = null;
    private static final String[] mCertErrorDic = null;
    private static final String[] mConnectTimeoutDic = null;
    private static final String[] mConnectionErrorDic = null;
    private static final String[] mDNSErrorDic = null;
    private static final String[] mErrorNetworkChangedDic = null;
    private static final String[] mIOErrorDic = null;
    private static final String[] mNetworkDisableDic = null;
    private static final String[] mSSLErrorDic = null;
    private static final String[] mUrlErrorDic = null;

    private BdpRequestHelper() {
    }

    @JvmStatic
    public static final String getTTNetProtocol(int r100) {
        switch(r100) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L4;
            case 6: goto L10;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L4;
        };
    L8:
        return "http/1.0";
    L9:
        return "http/0.9";
    L10:
        return "h2";
    L11:
        return "spdy";
    L12:
        return "http/1.1";
    L4:
        if (r100 != 5) goto L6;
    L17:
        return "quic";
    L6:
        if (10 <= r100) goto L14;
    L16:
        return "unknown";
    L14:
        if (27 < r100) goto L16;
        goto L16
    }

    public final String buildNativeErrorMsg(int r100) {
        if (r100 != (-200)) goto L5;
        return "native buffer exceed size limit";
    L5:
        if (r100 != (-111)) goto L7;
        return "url error";
    L7:
        if (r100 == (-95)) goto L19;
        switch(r100) {
            case -109: goto L18;
            case -108: goto L17;
            case -107: goto L16;
            case -106: goto L15;
            default: goto L9;
        };
    L9:
        switch(r100) {
            case -104: goto L14;
            case -103: goto L13;
            case -102: goto L12;
            case -101: goto L11;
            default: goto L10;
        };
    L10:
        return "other";
    L11:
        return "network not available";
    L12:
        return "dns error";
    L13:
        return "ssl error";
    L14:
        return "request time out";
    L15:
        return "connection error";
    L16:
        return "network changed";
    L17:
        return "interrupted";
    L18:
        return "certificate error";
    L19:
        return "Unexpected request usage, caught in CronetHttpURLConnection, caused by java.io.InterruptedIOException";
    }

    static {
        INSTANCE = new BdpRequestHelper();
        ID_CREATOR = new AtomicInteger(0);
        mNetworkDisableDic = new String[]{"network not available", "network_not_available", "network_access_denied"};
        mDNSErrorDic = new String[]{"unknownhost", "no address associated with hostname", "unknownhostexception", "name_not_resolved"};
        mConnectTimeoutDic = new String[]{"timed_out", "timeout", "timedout", "timed out"};
        mConnectionErrorDic = new String[]{"exception in connect", "connect failed", "connection_failed", "connection_closed", "connection_reset", "connection_refused", "connection reset", "socket closed", "socket is closed"};
        mErrorNetworkChangedDic = new String[]{"network_changed", "network changed"};
        mSSLErrorDic = new String[]{"ssl_protocol_error"};
        mCertErrorDic = new String[]{"cert_authority_invalid", "cert_common_name_invalid", "ssl_client_auth_cert_needed", "cert_date_invalid"};
        mAbortedErrorDic = new String[]{"connection_aborted"};
        mCancelErrorDic = new String[]{"cancel"};
        mUrlErrorDic = new String[]{"unknown_url_scheme", "invalid_url", "address_unreachable"};
        mIOErrorDic = new String[]{"caused by java.io.interruptedioexception"};
    }

    public final int generateRequestId() {
        return ID_CREATOR.incrementAndGet();
    }

    private final String getTimezoneOffset() {
        return String.valueOf(TimeZone.getDefault().getRawOffset() / 1000);
    L4:
        e = move-exception;
        b.b(TAG, new Object[]{"getTimezoneOffsetError", e});
        return "";
    }

    public final int buildNativeErrorCode(Throwable r100) {
        if (isError(r100, mNetworkDisableDic) == false) goto L7;
        return -101;
    L7:
        if (isError(r100, mCancelErrorDic) == false) goto L11;
        return -110;
    L11:
        if (isError(r100, mErrorNetworkChangedDic) == false) goto L15;
        return -107;
    L15:
        if (isException(r100, OutOfMemoryError.class) == false) goto L19;
        return -200;
    L19:
        if (isException(r100, SocketTimeoutException.class) == false) goto L21;
        return -104;
    L21:
        if (isError(r100, mConnectTimeoutDic) == false) goto L24;
        return -104;
    L24:
        if (isException(r100, UnknownHostException.class) == false) goto L26;
        return -102;
    L26:
        if (isError(r100, mDNSErrorDic) == false) goto L29;
        return -102;
    L29:
        if (isException(r100, SSLException.class) == false) goto L31;
        return -103;
    L31:
        if (isError(r100, mSSLErrorDic) == false) goto L34;
        return -103;
    L34:
        if (isError(r100, mCertErrorDic) == false) goto L38;
        return -109;
    L38:
        if (isError(r100, mConnectionErrorDic) == false) goto L40;
        return -106;
    L40:
        if (isException(r100, ConnectException.class) == false) goto L43;
        return -106;
    L43:
        if (isException(r100, InterruptedException.class) == false) goto L45;
        return -108;
    L45:
        if (isError(r100, mAbortedErrorDic) == false) goto L48;
        return -108;
    L48:
        if (isError(r100, mUrlErrorDic) == false) goto L52;
        return -111;
    L52:
        if (isError(r100, mIOErrorDic) == false) goto L55;
        return -95;
    L55:
        return -1;
    }

    public final byte[] convertToBytes(String r100) {
        return r100.getBytes(Charset.forName("UTF-8"));
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public final Map<String, String> getBdpCommonParams(com.bytedance.bdp.appbase.core.a r100) {
        HashMap r101 = new HashMap();
        lb4.a r102 = ((BdpInfoService) BdpManager.getInst().getService(BdpInfoService.class)).getHostInfo();
        BdpAccountService r103 = (BdpAccountService) BdpManager.getInst().getService(BdpAccountService.class);
        if (r100 == null) goto L5;
        r100.getAppId();
    L5:
        BdpUserInfo r104 = r103.getUserInfo(null);
        if (r100 == null) goto L8;
        r100.getAppId();
    L8:
        String r105 = "";
        r101.put("bdp-app-id", "");
        String r106 = r104.userId;
        if (r106 != null) goto L11;
    L14:
        boolean r107 = true;
    L15:
        if (r107 == false) goto L17;
        r106 = "0";
    L17:
        r101.put("bdp-uid", r106);
        String r108 = r104.secUID;
        if (r108 == null) goto L21;
        r105 = r108;
    L21:
        r101.put("bdp-sec-uid", r105);
        r101.put("bdp-os-name", "Android");
        r101.put("bdp-device-manufacturer", Build.MANUFACTURER);
        r101.put("bdp-device-timezone-offset", getTimezoneOffset());
        r101.put("bdp-aid", r102.getAppId());
        r101.put("bdp-version-code", r102.getVersionCode());
        f94.a r109 = f94.a.c();
        if (r100 == null) goto L24;
        r100.getAppId();
    L24:
        r109.getClass();
        r101.put("bdp-did", f94.a.b(null));
        r101.put("bdp-device-platform", r102.getDevicePlatform());
        r101.put("bdp-device-model", Build.MODEL);
        r101.put("bdp-channel", r102.getChannel());
        r101.put("bdp-os-version", r102.getOsVersion());
        return r101;
    L11:
        if (r106.length() == 0) goto L14;
        r107 = false;
        goto L15
    }

    public final boolean permitsRequestBody(String r100) {
        if (requiresRequestBody(r100) == false) goto L5;
    L16:
        return true;
    L5:
        if (Intrinsics.areEqual(r100, "OPTIONS") == true) goto L16;
        if (Intrinsics.areEqual(r100, "DELETE") == true) goto L16;
        if (Intrinsics.areEqual(r100, OpenNetMethod.PROPFIND) == true) goto L16;
        if (Intrinsics.areEqual(r100, OpenNetMethod.MKCOL) == true) goto L16;
        if (Intrinsics.areEqual(r100, OpenNetMethod.LOCK) == true) goto L16;
        return false;
    }

    public final Throwable realCause(Throwable r100) {
        int r101 = 0;
        Throwable r102 = r100;
    L4:
        if (r101 >= 4) goto L12;
        if (r102.getCause() == null) goto L7;
        r102 = r102.getCause();
        if (r102 != null) goto L11;
        Intrinsics.throwNpe();
    L11:
        r101 = r101 + 1;
        goto L4
    L7:
        return r102;
    L12:
        return r100;
    }

    public final boolean requiresRequestBody(String r100) {
        if (Intrinsics.areEqual(r100, "POST") == false) goto L5;
    L14:
        return true;
    L5:
        if (Intrinsics.areEqual(r100, "PUT") == true) goto L14;
        if (Intrinsics.areEqual(r100, "PATCH") == true) goto L14;
        if (Intrinsics.areEqual(r100, OpenNetMethod.PROPPATCH) == true) goto L14;
        if (Intrinsics.areEqual(r100, OpenNetMethod.REPORT) == true) goto L14;
        return false;
    }

    public final Map<String, String> getBdpCommonParams(BdpAppContext r100) {
        if (r100 == null) goto L4;
        com.bytedance.bdp.appbase.core.a r101 = r100.b();
    L6:
        return getBdpCommonParams(r101);
    L4:
        r101 = null;
        goto L6
    }

    @JvmStatic
    public static final List<String> optListString(JSONObject r100, String r101) {
        JSONArray r102 = r100.optJSONArray(r101);
        if (r102 != null) goto L6;
        return null;
    L6:
        ArrayList r103 = new ArrayList();
        int r104 = r102.length();
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L9;
        r103.add(r102.optString(r105));
        r105 = r105 + 1;
        goto L7
    L9:
        return r103;
    }

    public final File getHttpCacheDir(Context r100, String r101) {
        return new PolarisFileWrapper(r100.getExternalCacheDir(), "TT/http_cache/" + r101);
    }

    public final boolean isError(Throwable r110, String[] r111) {
        String r100 = r110.getMessage();
        if (r100 == null) goto L14;
        String r101 = r100.toLowerCase(Locale.getDefault());
        if (r101 == null) goto L14;
        Pair r102 = StringsKt.findAnyOf$default(r101, CollectionsKt.listOf(">> ["), 0, false, 6, null);
        if (r102 == null) goto L11;
        Integer r103 = (Integer) r102.getFirst();
        if (r103 == null) goto L11;
        int r104 = r103.intValue();
    L12:
        CharSequence r105 = r101.subSequence(0, r104);
        if (r105 == null) goto L14;
    L18:
        if (r105 != null) goto L20;
        return false;
    L20:
        int r112 = r111.length;
        int r106 = 0;
    L21:
        if (r106 >= r112) goto L27;
        if (StringsKt.contains$default(r105, r111[r106], false, 2, null) == true) goto L24;
        r106 = r106 + 1;
        goto L21
    L24:
        return true;
    L27:
        return false;
    L11:
        r104 = r101.length();
    L14:
        String r113 = r110.getMessage();
        if (r113 == null) goto L17;
        r105 = r113.toLowerCase();
        goto L18
    L17:
        r105 = null;
        goto L18
    }

    public final boolean isException(Throwable r100, Class<?> r101) {
        int r102 = 0;
    L4:
        if (r102 >= 4) goto L12;
        if (r100 == null) goto L6;
        if (r101.isInstance(r100) == true) goto L9;
        r100 = r100.getCause();
        r102 = r102 + 1;
        goto L4
    L9:
        return true;
    L6:
        return false;
    L12:
        return false;
    }

    public final BdpNetResponse buildNativeErrorResponse(String r110, int r111, String r112, BdpRequestType r113) {
        c r100 = c.f480683b;
        return new BdpNetResponse(r111, r112, r110, c.f480683b, null, new Exception(r112), r113, new d(), MapsKt.emptyMap());
    }

    @JvmStatic
    public static final void reportNetworkEvent(String r210, String r211, String r310, int r311, String r312, String r313, String r314, Throwable r315) {
        if (r312 == null) goto L5;
        JSONObject r100 = new JSONObject(r312);     // Catch: JSONException -> L83
    L6:
        JSONObject r101 = r100.optJSONObject("timing");     // Catch: JSONException -> L83
        int r102 = -1;
        if (r101 == null) goto L11;
        JSONObject r103 = r101.optJSONObject("request");     // Catch: JSONException -> L83
        if (r103 == null) goto L11;
        int r104 = r103.optInt("duration");     // Catch: JSONException -> L83
    L12:
        JSONObject r105 = r100.optJSONObject("timing");     // Catch: JSONException -> L83
        if (r105 == null) goto L15;
        JSONObject r106 = r105.optJSONObject("detailed_duration");     // Catch: JSONException -> L83
    L16:
        if (r106 == null) goto L18;
        int r107 = r106.optInt(MultiProcessFileUtils.KEY_DNS);     // Catch: JSONException -> L83
    L19:
        if (r106 == null) goto L21;
        int r110 = r106.optInt("tcp");     // Catch: JSONException -> L83
    L22:
        if (r106 == null) goto L24;
        int r111 = r106.optInt(TTVideoEngineInterface.PLAY_API_KEY_SSL);     // Catch: JSONException -> L83
    L25:
        int r112 = r110 + r111;     // Catch: JSONException -> L83
        if (r106 == null) goto L28;
        int r113 = r106.optInt("send");     // Catch: JSONException -> L83
    L29:
        if (r106 == null) goto L31;
        int r114 = r106.optInt(MonitorConstants.TTFB);     // Catch: JSONException -> L83
    L32:
        if (r106 == null) goto L34;
        int r115 = r106.optInt("header_recv");     // Catch: JSONException -> L83
    L35:
        if (r106 == null) goto L37;
        r102 = r106.optInt("body_recv");     // Catch: JSONException -> L83
    L37:
        int r108 = r115 + r102;     // Catch: JSONException -> L83
        JSONObject r116 = r100.optJSONObject("other");     // Catch: JSONException -> L83
        if (r116 == null) goto L40;
        String r117 = r116.optString("libcore");     // Catch: JSONException -> L83
    L42:
        if (Intrinsics.areEqual("cronet", r117) == false) goto L44;
        int r118 = 0;
    L45:
        JSONObject r109 = r100.optJSONObject("base");     // Catch: JSONException -> L83
        if (r109 == null) goto L51;
        String r119 = r109.optString("origin_url");     // Catch: JSONException -> L83
        if (r119 == null) goto L51;
        String r120 = r119;
    L52:
        JSONObject r121 = r100.optJSONObject("base");     // Catch: JSONException -> L83
        if (r121 == null) goto L56;
        String r122 = r121.optString(e.f25671s);     // Catch: JSONException -> L83
        if (r122 == null) goto L56;
    L57:
        String r123 = r122;
        JSONObject r124 = r100.optJSONObject("response");     // Catch: JSONException -> L83
        if (r124 == null) goto L60;
        int r212 = r124.optInt("code");     // Catch: JSONException -> L83
    L61:
        JSONObject r125 = r100.optJSONObject("header");     // Catch: JSONException -> L83
        if (r125 == null) goto L64;
        String r213 = r125.optString(NetResponse.HEADER_KEY_LOG_ID);     // Catch: JSONException -> L83
    L65:
        JSONObject r126 = r100.optJSONObject("socket");     // Catch: JSONException -> L83
        if (r126 == null) goto L68;
        Boolean r214 = Boolean.valueOf(r126.optBoolean("socket_reused"));     // Catch: JSONException -> L83
    L69:
        JSONObject r127 = r100.optJSONObject("response");     // Catch: JSONException -> L83
        if (r127 == null) goto L72;
        int r128 = r127.optInt("connection_info");     // Catch: JSONException -> L83
    L73:
        String r215 = getTTNetProtocol(r128);     // Catch: JSONException -> L83
        JSONObject r129 = r100.optJSONObject("base");     // Catch: JSONException -> L83
        if (r129 == null) goto L80;
        JSONArray r130 = r129.optJSONArray("redirect_info");     // Catch: JSONException -> L83
        if (r130 == null) goto L80;
        JSONObject r131 = r130.optJSONObject(0);     // Catch: JSONException -> L83
        if (r131 == null) goto L80;
        String r216 = r131.optString("url");     // Catch: JSONException -> L83
    L81:
        com.bytedance.bdp.appbase.base.network.BdpNetworkEventHelper.a(r104, r107, r111, r112, r113, r114, r108, r118, r120, r123, r310, r211, r212, r314, r315, r213, r214, r215, r313, r216);     // Catch: JSONException -> L83
        return;
    L80:
        r216 = null;
        goto L81
    L72:
        r128 = 0;
        goto L73
    L68:
        r214 = null;
        goto L69
    L64:
        r213 = null;
        goto L65
    L60:
        r212 = r311;
    L56:
        r122 = "GET";
    L51:
        r120 = r210;
        goto L52
    L44:
        r118 = 1;
        goto L45
    L40:
        r117 = null;
        goto L42
    L34:
        r115 = -1;
        goto L35
    L31:
        r114 = -1;
        goto L32
    L28:
        r113 = -1;
        goto L29
    L24:
        r111 = -1;
        goto L25
    L21:
        r110 = -1;
        goto L22
    L18:
        r107 = -1;
        goto L19
    L15:
        r106 = null;
    L11:
        r104 = -1;
        goto L12
    L5:
        r100 = new JSONObject();     // Catch: JSONException -> L83
    L83:
        e = move-exception;
        b.b(TAG, new Object[]{e});
    }
}
