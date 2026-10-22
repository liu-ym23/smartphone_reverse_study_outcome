package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public final class i extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k[] f275953a = null;

    static {
        f275953a = new k[0];
    }

    public i(Map<DecodeHintType, ?> r100) {
        if (r100 != null) goto L5;
        Collection r101 = null;
    L7:
        if (r100 != null) goto L9;
    L11:
        boolean r102 = false;
    L12:
        ArrayList r103 = new ArrayList();
        if (r101 == null) goto L45;
        if (r101.contains(BarcodeFormat.EAN_13) == false) goto L17;
    L22:
        r103.add(new j(r100));
    L24:
        if (r101.contains(BarcodeFormat.CODE_39) == false) goto L27;
        r103.add(new c(r102));
    L27:
        if (r101.contains(BarcodeFormat.CODE_93) == false) goto L30;
        r103.add(new d());
    L30:
        if (r101.contains(BarcodeFormat.CODE_128) == false) goto L33;
        r103.add(new b());
    L33:
        if (r101.contains(BarcodeFormat.ITF) == false) goto L36;
        r103.add(new h());
    L36:
        if (r101.contains(BarcodeFormat.CODABAR) == false) goto L39;
        r103.add(new a());
    L39:
        if (r101.contains(BarcodeFormat.RSS_14) == false) goto L42;
        r103.add(new sv7.b());
    L42:
        if (r101.contains(BarcodeFormat.RSS_EXPANDED) == false) goto L45;
        r103.add(new tv7.a());
        goto L45
    L17:
        if (r101.contains(BarcodeFormat.UPC_A) == true) goto L22;
        if (r101.contains(BarcodeFormat.EAN_8) == true) goto L22;
        if (r101.contains(BarcodeFormat.UPC_E) == false) goto L24;
    L45:
        if (r103.isEmpty() == false) goto L47;
        r103.add(new j(r100));
        r103.add(new c(false));
        r103.add(new a());
        r103.add(new d());
        r103.add(new b());
        r103.add(new h());
        r103.add(new sv7.b());
        r103.add(new tv7.a());
    L47:
        k[] r104 = (k[]) r103.toArray(f275953a);
        return;
    L9:
        if (r100.get(DecodeHintType.ASSUME_CODE_39_CHECK_DIGIT) == null) goto L11;
        r102 = true;
        goto L12
    L5:
        r101 = (Collection) r100.get(DecodeHintType.POSSIBLE_FORMATS);
        goto L7
    }
}
