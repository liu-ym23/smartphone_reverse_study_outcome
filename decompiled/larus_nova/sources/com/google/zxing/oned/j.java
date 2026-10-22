package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public final class j extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p[] f275954a = null;

    static {
        f275954a = new p[0];
    }

    public j(Map<DecodeHintType, ?> r100) {
        if (r100 != null) goto L5;
        Collection r101 = null;
    L6:
        ArrayList r102 = new ArrayList();
        if (r101 == null) goto L21;
        if (r101.contains(BarcodeFormat.EAN_13) == false) goto L12;
        r102.add(new e());
    L15:
        if (r101.contains(BarcodeFormat.EAN_8) == false) goto L18;
        r102.add(new f());
    L18:
        if (r101.contains(BarcodeFormat.UPC_E) == false) goto L21;
        r102.add(new q());
        goto L21
    L12:
        if (r101.contains(BarcodeFormat.UPC_A) == false) goto L15;
        r102.add(new l());
    L21:
        if (r102.isEmpty() == false) goto L23;
        r102.add(new e());
        r102.add(new f());
        r102.add(new q());
    L23:
        p[] r103 = (p[]) r102.toArray(f275954a);
        return;
    L5:
        r101 = (Collection) r100.get(DecodeHintType.POSSIBLE_FORMATS);
        goto L6
    }
}
