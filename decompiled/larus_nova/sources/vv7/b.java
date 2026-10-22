package vv7;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.c;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public final class b {
    public static nv7.b a(String r100, BarcodeFormat r101, int r110, int r111, Map r112) throws WriterException {
        if (r100.isEmpty() == true) goto L34;
        if (r101 != BarcodeFormat.QR_CODE) goto L32;
        if (r110 < 0) goto L30;
        if (r111 < 0) goto L30;
        ErrorCorrectionLevel r102 = ErrorCorrectionLevel.L;
        EncodeHintType r103 = EncodeHintType.ERROR_CORRECTION;
        if (r112.containsKey(r103) == false) goto L11;
        r102 = ErrorCorrectionLevel.valueOf(((LinkedHashMap) r112).get(r103).toString());
    L11:
        EncodeHintType r104 = EncodeHintType.MARGIN;
        if (r112.containsKey(r104) == false) goto L14;
        int r105 = CastIntegerProtector.parseInt(((LinkedHashMap) r112).get(r104).toString());
    L15:
        com.google.zxing.qrcode.encoder.b r106 = c.b(r100, r102, r112).f276010e;
        if (r106 == null) goto L28;
        int r107 = r106.f275997b;
        int r113 = r106.f275998c;
        int r108 = r105 * 2;
        int r109 = r107 + r108;
        int r114 = r108 + r113;
        int r115 = Math.max(r110, r109);
        int r116 = Math.max(r111, r114);
        int r117 = Math.min(r115 / r109, r116 / r114);
        int r118 = (r115 - (r107 * r117)) / 2;
        int r119 = (r116 - (r113 * r117)) / 2;
        nv7.b r120 = new nv7.b(r115, r116);
        int r121 = 0;
    L18:
        if (r121 >= r113) goto L26;
        int r122 = r118;
        int r123 = 0;
    L20:
        if (r123 >= r107) goto L25;
        if (r106.a(r123, r121) != 1) goto L24;
        r120.e(r122, r119, r117, r117);
    L24:
        r123 = r123 + 1;
        r122 = r122 + r117;
        goto L20
    L25:
        r121 = r121 + 1;
        r119 = r119 + r117;
        goto L18
    L26:
        return r120;
    L28:
        throw new IllegalStateException();
    L14:
        r105 = 4;
    L30:
        throw new IllegalArgumentException("Requested dimensions are too small: " + r110 + Permission.EXECUTE + r111);
    L32:
        throw new IllegalArgumentException("Can only encode QR_CODE, but got " + r101);
    L34:
        throw new IllegalArgumentException("Found empty contents");
    }
}
