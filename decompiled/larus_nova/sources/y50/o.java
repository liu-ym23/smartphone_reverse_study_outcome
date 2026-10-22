package y50;

import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.network.CustomApiServerException;
import java.io.IOException;

/* JADX INFO: loaded from: classes45.dex */
public final class o {
    public static l a(Throwable r100) {
        l r101 = new l();
        r101.f566218a = -1;
        if ((r100 instanceof CustomApiServerException) == false) goto L6;
        CustomApiServerException r102 = (CustomApiServerException) r100;
        r101.f566218a = r102.getErrorCode();
        r101.f566219b = r102.getXTtLogId();
        r101.f566220c = "CustomApiServerException(" + r102.getErrorMsg() + ")";
    L19:
        return r101;
    L6:
        if ((r100 instanceof ApiServerException) == false) goto L9;
        ApiServerException r103 = (ApiServerException) r100;
        r101.f566220c = "ApiServerException(" + r103.getErrorMsg() + ")";
        r101.f566218a = r103.getErrorCode();
        goto L19
    L9:
        if ((r100 instanceof ApiException) == false) goto L12;
        ApiException r104 = (ApiException) r100;
        r101.f566218a = r104.getErrorCode();
        r101.f566220c = "ApiException(" + r104.getMessage() + ")";
        goto L19
    L12:
        if ((r100 instanceof NetworkErrorException) == false) goto L15;
        NetworkErrorException r105 = (NetworkErrorException) r100;
        r101.f566218a = r105.getStatusCode();
        r101.f566220c = "NetworkErrorException(" + r105.getMessage() + ")";
        goto L19
    L15:
        if ((r100 instanceof IOException) == false) goto L17;
        r101.f566218a = 103;
        r101.f566220c = "IOException(" + r100.getMessage() + ")";
        goto L19
    L17:
        if (r100 == null) goto L19;
        r101.f566220c = r100.getMessage();
        goto L19
    }
}
