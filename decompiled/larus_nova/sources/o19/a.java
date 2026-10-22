package o19;

import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import p19.b;

/* JADX INFO: loaded from: classes27.dex */
public final class a {
    public static final Bitmap a(String r100, int r101, int r102, int r103, Map r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "url");
        FLogger.f375446a.i("PicShareUtils", "generateQRCodeBitmap useCustomQrcode " + r105);
        if (r105 == false) goto L6;
        return b.a(r100, r101, r102, r103);
    L6:
        if (r100 != null) goto L33;
    L13:
        boolean r106 = true;
    L14:
        if (r106 == true) goto L31;
        if (r101 <= 0) goto L31;
        if (r102 <= 0) goto L31;
        nv7.b r107 = vv7.b.a(r100, BarcodeFormat.QR_CODE, r101, r102, r104);     // Catch: Exception -> L11
        Bitmap r108 = Bitmap.createBitmap(r101, r102, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L11
        int r109 = 0;
    L19:
        if (r109 >= r101) goto L38;
        int r110 = 0;
    L21:
        if (r110 >= r102) goto L28;
        if (r107.b(r109, r110) == false) goto L25;
        int r111 = r103;
    L26:
        r108.setPixel(r109, r110, r111);     // Catch: Exception -> L11
        r110 = r110 + 1;
        goto L21
    L25:
        r111 = 0;
    L11:
        e = move-exception;
        FLogger.f375446a.e("generateQRCodeBitmap", "generateQRCodeBitmap: error ", e);
        goto L31
    L28:
        r109 = r109 + 1;
        goto L19
    L38:
        return r108;
    L31:
        return null;
    L33:
        if (r100.length() == 0) goto L13;
        r106 = false;
        goto L14
    }
}
