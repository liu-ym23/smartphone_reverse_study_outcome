package com.bytedance.locallife.dito.data;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f258193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f258194b;

    public a() {
        this(false, 3);
    }

    public a(boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        float r102 = 1.0f;
    L7:
        if ((r101 & 2) == 0) goto L9;
        r100 = true;
    L9:
        this.f258193a = r102;
        this.f258194b = r100;
        return;
    L5:
        r102 = 0.0f;
        goto L7
    }
}
