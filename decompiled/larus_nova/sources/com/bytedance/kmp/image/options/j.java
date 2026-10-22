package com.bytedance.kmp.image.options;

import androidx.compose.ui.layout.ContentScale;

/* JADX INFO: loaded from: classes19.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f252159b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f252160c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ContentScale f252161a;

    public static final class a {
    }

    static {
        ContentScale.Companion r100 = ContentScale.Companion;
        r100.getCrop();
        f252159b = new j(r100.getFit());
        f252160c = new j(r100.getInside());
        r100.getFillBounds();
        r100.getNone();
        r100.getFillHeight();
        r100.getFillWidth();
    }

    public j(ContentScale r100) {
        this.f252161a = r100;
    }
}
