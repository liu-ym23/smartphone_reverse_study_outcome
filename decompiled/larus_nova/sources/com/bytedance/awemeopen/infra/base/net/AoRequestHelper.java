package com.bytedance.awemeopen.infra.base.net;

import com.alipay.sdk.m.p.e;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.servicesapi.network.AoNetworkMetric;
import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLException;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import q64.c;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0006J\u0006\u0010\u001b\u001a\u00020\u000eJ\b\u0010\u001c\u001a\u00020\u0006H\u0002J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006J\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006J\u001d\u0010!\u001a\u00020\u001e*\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\u0010#J\u0016\u0010$\u001a\u00020\u001e*\u00020\u00102\n\u0010%\u001a\u0006\u0012\u0002\b\u00030&J\n\u0010'\u001a\u00020\u0010*\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006("}, d2 = {"Lcom/bytedance/awemeopen/infra/base/net/AoRequestHelper;", "", "()V", "ID_CREATOR", "Ljava/util/concurrent/atomic/AtomicInteger;", "TAG", "", "mConnectTimeoutDic", "", "[Ljava/lang/String;", "mConnectionErrorDic", "mDNSErrorDic", "mNetworkDisableDic", "buildNativeErrorCode", "", "e", "", "buildNativeErrorResponse", "Lcom/bytedance/awemeopen/infra/base/net/AoNetResponse;", "url", "errorCode", "errorMsg", "libType", "Lcom/bytedance/awemeopen/infra/base/net/AoRequestType;", "convertToBytes", "", "content", "generateRequestId", "getTimezoneOffset", "permitsRequestBody", "", e.f25671s, "requiresRequestBody", "isError", "errorDic", "(Ljava/lang/Throwable;[Ljava/lang/String;)Z", "isException", "cls", "Ljava/lang/Class;", "realCause", "ao_base_core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AoRequestHelper {
    private static final AtomicInteger ID_CREATOR = null;
    public static final AoRequestHelper INSTANCE = null;
    private static final String TAG = "BdpRequestHelper";
    private static final String[] mConnectTimeoutDic = null;
    private static final String[] mConnectionErrorDic = null;
    private static final String[] mDNSErrorDic = null;
    private static final String[] mNetworkDisableDic = null;

    private AoRequestHelper() {
    }

    static {
        INSTANCE = new AoRequestHelper();
        ID_CREATOR = new AtomicInteger(0);
        mNetworkDisableDic = new String[]{"network not available", "network_not_available", "err_network_access_denied"};
        mDNSErrorDic = new String[]{"unknownhost", "no address associated with hostname", "unknownhostexception", "err_name_not_resolved"};
        mConnectTimeoutDic = new String[]{"timed_out"};
        mConnectionErrorDic = new String[]{"Exception in connect"};
    }

    public final int generateRequestId() {
        return ID_CREATOR.incrementAndGet();
    }

    private final String getTimezoneOffset() {
        return String.valueOf(TimeZone.getDefault().getRawOffset() / 1000);
    L4:
        e = move-exception;
        AoLogger.c(TAG, new Object[]{"getTimezoneOffsetError", e});
        return "";
    }

    public final int buildNativeErrorCode(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        if (isError(r100, mNetworkDisableDic) == false) goto L7;
        return -101;
    L7:
        if (isException(r100, OutOfMemoryError.class) == false) goto L11;
        return -200;
    L11:
        if (isException(r100, SocketTimeoutException.class) == false) goto L13;
        return -104;
    L13:
        if (isError(r100, mConnectTimeoutDic) == false) goto L16;
        return -104;
    L16:
        if (isException(r100, UnknownHostException.class) == false) goto L18;
        return -102;
    L18:
        if (isError(r100, mDNSErrorDic) == false) goto L21;
        return -102;
    L21:
        if (isException(r100, SSLException.class) == false) goto L25;
        return -103;
    L25:
        if (isError(r100, mConnectionErrorDic) == false) goto L28;
        return -106;
    L28:
        return -1;
    }

    public final byte[] convertToBytes(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        return r100.getBytes(Charset.forName("UTF-8"));
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public final boolean permitsRequestBody(String r100) {
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
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
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = 0;
        Throwable r102 = r100;
    L4:
        if (r101 >= 4) goto L9;
        if (r102.getCause() == null) goto L7;
        r102 = r102.getCause();
        Intrinsics.checkNotNull(r102);
        r101 = r101 + 1;
        goto L4
    L7:
        return r102;
    L9:
        return r100;
    }

    public final boolean requiresRequestBody(String r100) {
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
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

    public final boolean isError(Throwable r100, String[] r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "errorDic");
        String r102 = r100.getMessage();
        if (r102 == null) goto L14;
        String r103 = r102.toLowerCase(Locale.getDefault());
        if (r103 == null) goto L14;
        int r104 = r101.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L14;
        if (StringsKt.contains$default(r103, r101[r105], false, 2, null) == true) goto L11;
        r105 = r105 + 1;
        goto L8
    L11:
        return true;
    L14:
        return false;
    }

    public final boolean isException(Throwable r100, Class<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "cls");
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

    public final AoNetResponse buildNativeErrorResponse(String r110, int r111, String r112, AoRequestType r113) {
        Intrinsics.checkNotNullParameter(r110, "url");
        Intrinsics.checkNotNullParameter(r112, "errorMsg");
        Intrinsics.checkNotNullParameter(r113, "libType");
        c r100 = c.f531789b;
        return new AoNetResponse(r111, r112, r110, c.f531789b, null, new Exception(r112), r113, new AoNetworkMetric(), MapsKt.emptyMap());
    }
}
