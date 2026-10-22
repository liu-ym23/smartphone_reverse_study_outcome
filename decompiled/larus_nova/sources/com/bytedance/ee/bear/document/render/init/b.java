package com.bytedance.ee.bear.document.render.init;

import com.bytedance.ee.bear.document.x2;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends x2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yv4.e f221290a;

    @Override // com.bytedance.ee.bear.document.x2.c, com.bytedance.ee.bear.document.x2.b
    public final void onLoadSuccess() {
    }

    public b(yv4.e r100) {
        this.f221290a = r100;
    }

    @Override // com.bytedance.ee.bear.document.x2.c, com.bytedance.ee.bear.document.x2.b
    public final void onLoadFail(int r100, Throwable r101) {
        this.f221290a.i();
    }
}
