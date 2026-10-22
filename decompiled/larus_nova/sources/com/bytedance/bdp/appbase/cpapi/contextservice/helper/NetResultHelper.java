package com.bytedance.bdp.appbase.cpapi.contextservice.helper;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdp.appbase.context.service.operate.sync.ResultType;
import com.bytedance.bdp.appbase.netapi.base.DefLocalErrorCode;
import com.bytedance.bdp.appbase.netapi.base.ErrorInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import p94.a;
import p94.b;
import p94.c;
import p94.d;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J&\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u000e\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J2\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0000\u0010\n\"\u000e\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/bdp/appbase/cpapi/contextservice/helper/NetResultHelper;", "", "Lcom/bytedance/bdp/appbase/netapi/base/ErrorInfo;", "errorInfo", "Lp94/a;", "convertBaseServerError", "", ExifInterface.LONGITUDE_EAST, "Lp94/d;", "convertExtendServerError", ExifInterface.GPS_DIRECTION_TRUE, "Lp94/b;", "convertDataServerError", "Lp94/c;", "convertExtendDataServerError", "<init>", "()V", "bdp-appbase-cpapi_release"}, k = 1, mv = {1, 4, 0})
public final class NetResultHelper {
    public static final NetResultHelper INSTANCE = null;

    private NetResultHelper() {
    }

    static {
        INSTANCE = new NetResultHelper();
    }

    @JvmStatic
    public static final a convertBaseServerError(ErrorInfo r100) {
        int r101 = r100.errCode;
        if (r101 != DefLocalErrorCode.netNotAvailableError.code) goto L6;
        int r102 = a.f528295d;
        a r103 = new a(ResultType.ERROR_NETWORK_DISABLED, null, null);
        r103.b();
        return r103;
    L6:
        if (r101 != DefLocalErrorCode.netError.code) goto L15;
        int r104 = a.f528295d;
        Integer r105 = r100.netCode;
        String r106 = r100.netMsg;
        ResultType r107 = ResultType.ERROR_REQUEST_FAIL;
        if (r105 == null) goto L10;
        r105.intValue();
    L10:
        if (r106 != null) goto L13;
        r106 = null;
    L13:
        a r108 = new a(r107, r106, null);
        r108.b();
        return r108;
    L15:
        if (r101 != DefLocalErrorCode.resultParseError.code) goto L18;
        int r109 = a.f528295d;
        return a.C7168a.a(null, r100.msg);
    L18:
        if (r101 != DefLocalErrorCode.fatalError.code) goto L20;
    L25:
        int r110 = a.f528295d;
        Throwable r111 = r100.f200851tr;
        if (r111 == null) goto L29;
        String r112 = r111.getMessage();
        if (r112 == null) goto L29;
    L30:
        a r113 = new a(ResultType.ERROR_INTERNAL_ERROR, r112, null);
        r113.b();
        return r113;
    L29:
        r112 = r100.msg;
        goto L30
    L20:
        if (r101 == DefLocalErrorCode.interruptError.code) goto L25;
        if (r101 == DefLocalErrorCode.reqParamError.code) goto L25;
        int r114 = a.f528295d;
        return a.C7168a.a(Integer.valueOf(r101), r100.msg);
    }

    @JvmStatic
    public static final <T> b<T> convertDataServerError(ErrorInfo r100) {
        int r101 = b.f528299f;
        a r102 = convertBaseServerError(r100);
        ResultType r103 = r102.f528296a;
        Throwable r104 = r102.f528298c;
        b<T> r105 = new b(r103, r102.f528297b, r104, null);
        r105.b();
        return r105;
    }

    @JvmStatic
    public static final <T, E extends Enum<E>> c<T, E> convertExtendDataServerError(ErrorInfo r100) {
        int r101 = c.f528301e;
        a r102 = convertBaseServerError(r100);
        ResultType r103 = r102.f528296a;
        String r104 = r102.f528297b;
        Throwable r105 = null;
        if (r104 != null) goto L6;
        r104 = null;
    L6:
        Throwable r106 = r102.f528298c;
        if (r106 == null) goto L9;
        r105 = r106;
    L9:
        c<T, E> r107 = new c(r103, r104, r105);
        r107.b();
        return r107;
    }

    @JvmStatic
    public static final <E extends Enum<E>> d<E> convertExtendServerError(ErrorInfo r100) {
        int r101 = d.f528302e;
        a r102 = convertBaseServerError(r100);
        ResultType r103 = r102.f528296a;
        String r104 = r102.f528297b;
        Throwable r105 = null;
        if (r104 != null) goto L6;
        r104 = null;
    L6:
        Throwable r106 = r102.f528298c;
        if (r106 == null) goto L9;
        r105 = r106;
    L9:
        d<E> r107 = new d(r103, r104, r105);
        r107.b();
        return r107;
    }
}
