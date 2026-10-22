package fm9;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.retrofit2.HttpException;
import com.bytedance.retrofit2.SsResponse;
import com.google.gson.JsonSyntaxException;
import com.larus.utils.logger.FLogger;
import java.io.EOFException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static final dm9.a.C5690a a(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = "Unknown";
        if ((r100 instanceof HttpException) == false) goto L22;
        HttpException r102 = (HttpException) r100;
        SsResponse<?> r103 = r102.response();
        if (r103 == null) goto L7;
        int r104 = r103.code();
    L8:
        SsResponse<?> r105 = r102.response();
        if (r105 == null) goto L12;
        String r106 = r105.message();
        if (r106 == null) goto L12;
    L15:
        r101 = r106;
    L16:
        SsResponse<?> r107 = r102.response();
        if (r107 == null) goto L19;
        boolean r108 = r107.isSuccessful();
    L20:
        FLogger.f375446a.e("HttpErrorExt", "code=" + r104 + ", msg=" + r101 + ", success=" + r108);
        return new dm9.a.C5690a(r104, r101, r100);
    L19:
        r108 = false;
    L12:
        r106 = Reflection.getOrCreateKotlinClass(r100.getClass()).getSimpleName();
        if (r106 != null) goto L15;
    L7:
        r104 = -1000;
        goto L8
    L22:
        if ((r100 instanceof CronetIOException) == false) goto L28;
        FLogger.f375446a.e("HttpErrorExt", "CronetIOException: code=" + ((CronetIOException) r100).getCronetInternalErrorCode() + ", msg=" + r100.getMessage());
        int r109 = ((CronetIOException) r100).getCronetInternalErrorCode();
        String r110 = r100.getMessage();
        if (r110 != null) goto L40;
        r110 = "CronetIOException";
    L40:
        return new dm9.a.C5690a(r109, r110, r100);
    L28:
        if ((r100 instanceof NetworkNotAvailabeException) == false) goto L33;
        FLogger.f375446a.e("HttpErrorExt", "NetworkNotAvailabeException: code=" + ((NetworkNotAvailabeException) r100).getCronetInternalErrorCode() + ", msg=" + r100.getMessage());
        int r111 = ((NetworkNotAvailabeException) r100).getCronetInternalErrorCode();
        String r112 = r100.getMessage();
        if (r112 != null) goto L41;
        r112 = "NetworkNotAvailabeException";
    L41:
        return new dm9.a.C5690a(r111, r112, r100);
    L33:
        int r113 = b(r100);
        String r114 = Reflection.getOrCreateKotlinClass(r100.getClass()).getSimpleName();
        if (r114 == null) goto L37;
        r101 = r114;
    L37:
        FLogger.f375446a.e("HttpErrorExt", "code=" + r113 + ", msg=" + r101);
        return new dm9.a.C5690a(r113, r101, r100);
    }

    public static final int b(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof UnknownHostException) == false) goto L6;
        return -1002;
    L6:
        if ((r100 instanceof EOFException) == false) goto L9;
        return -1003;
    L9:
        if ((r100 instanceof JsonSyntaxException) == false) goto L12;
        return -1004;
    L12:
        if ((r100 instanceof NullPointerException) == false) goto L15;
        return -1005;
    L15:
        if ((r100 instanceof ConnectException) == false) goto L18;
        return -1006;
    L18:
        if ((r100 instanceof SocketTimeoutException) == false) goto L21;
        return -1007;
    L21:
        if ((r100 instanceof IllegalArgumentException) == false) goto L23;
        return -1008;
    L23:
        return -1000;
    }
}
