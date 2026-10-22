package com.google.zxing;

import com.google.zxing.oned.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public final class a implements b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b[] f275937c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<DecodeHintType, ?> f275938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b[] f275939b;

    static {
        f275937c = new b[0];
    }

    public a() {
    }

    public final void a(Map<DecodeHintType, ?> r100) {
        this.f275938a = r100;
        boolean r101 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r100 != null) goto L10;
        Collection r103 = null;
    L11:
        ArrayList r104 = new ArrayList();
        if (r103 == null) goto L59;
        if (r103.contains(BarcodeFormat.UPC_A) == false) goto L16;
    L37:
        if (r101 == false) goto L41;
        if (r102 == true) goto L41;
        r104.add(new i(r100));
    L41:
        if (r103.contains(BarcodeFormat.QR_CODE) == false) goto L44;
        r104.add(new vv7.a());
    L44:
        if (r103.contains(BarcodeFormat.DATA_MATRIX) == false) goto L47;
        r104.add(new pv7.a());
    L47:
        if (r103.contains(BarcodeFormat.AZTEC) == false) goto L50;
        r104.add(new mv7.a());
    L50:
        if (r103.contains(BarcodeFormat.PDF_417) == false) goto L53;
        r104.add(new uv7.a());
    L53:
        if (r103.contains(BarcodeFormat.MAXICODE) == false) goto L55;
        r104.add(new qv7.a());
    L55:
        if (r101 == false) goto L59;
        if (r102 == false) goto L59;
        r104.add(new i(r100));
        goto L59
    L16:
        if (r103.contains(BarcodeFormat.UPC_E) == true) goto L37;
        if (r103.contains(BarcodeFormat.EAN_13) == true) goto L37;
        if (r103.contains(BarcodeFormat.EAN_8) == true) goto L37;
        if (r103.contains(BarcodeFormat.CODABAR) == true) goto L37;
        if (r103.contains(BarcodeFormat.CODE_39) == true) goto L37;
        if (r103.contains(BarcodeFormat.CODE_93) == true) goto L37;
        if (r103.contains(BarcodeFormat.CODE_128) == true) goto L37;
        if (r103.contains(BarcodeFormat.ITF) == true) goto L37;
        if (r103.contains(BarcodeFormat.RSS_14) == true) goto L37;
        if (r103.contains(BarcodeFormat.RSS_EXPANDED) == true) goto L37;
        r101 = false;
    L59:
        if (r104.isEmpty() == false) goto L65;
        if (r102 == true) goto L62;
        r104.add(new i(r100));
    L62:
        r104.add(new vv7.a());
        r104.add(new pv7.a());
        r104.add(new mv7.a());
        r104.add(new uv7.a());
        r104.add(new qv7.a());
        if (r102 == false) goto L65;
        r104.add(new i(r100));
    L65:
        this.f275939b = (b[]) r104.toArray(f275937c);
        return;
    L10:
        r103 = (Collection) r100.get(DecodeHintType.POSSIBLE_FORMATS);
        goto L11
    L5:
        if (r100.containsKey(DecodeHintType.TRY_HARDER) == false) goto L7;
        r102 = true;
        goto L8
    }
}
