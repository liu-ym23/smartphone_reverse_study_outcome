package com.ss.android.lark.widget.photo.preview.ocr;

import kotlin.Triple;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements TextGraphicOverlay.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f447074a = null;

    static {
        f447074a = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.widget.photo.preview.ocr.TextGraphicOverlay.c
    public final Triple<Float, Float, Float> a(int r100, int r101, int r102, int r103) {
        float r104 = r100;
        float r105 = r102;
        float r106 = (r104 * 1.0f) / r105;
        float r107 = r101;
        float r108 = r103;
        float r109 = (1.0f * r107) / r108;
        if ((r103 / r102) <= 3) goto L5;
        double r110 = Math.max(r106, r109);
    L6:
        float r111 = (float) r110;
        return new Triple(Float.valueOf(r111), Float.valueOf((r104 - (r105 * r111)) / 2.0f), Float.valueOf(Math.max((r107 - (r108 * r111)) / 2.0f, 0.0f)));
    L5:
        r110 = Math.min(r106, r109);
        goto L6
    }
}
