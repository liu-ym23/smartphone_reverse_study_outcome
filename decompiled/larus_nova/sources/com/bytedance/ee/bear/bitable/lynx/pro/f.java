package com.bytedance.ee.bear.bitable.lynx.pro;

import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements ku4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableProLynxPlugin.e f214645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f214646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f214647c;

    @Override // ku4.b
    public final e a() {
        if (this.f214646b == true) goto L7;
        return null;
    L7:
        return new e(this.f214647c);
    }

    @Override // ku4.b
    public final void onClose() {
        this.f214645a.f214638a = null;
    }

    public f(BitableProLynxPlugin.e r100, boolean r101, m r102) {
        this.f214645a = r100;
        this.f214646b = r101;
        this.f214647c = r102;
    }
}
