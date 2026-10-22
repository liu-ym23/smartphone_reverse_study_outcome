package com.bytedance.ee.bear.document.render.init;

import com.bytedance.ee.bear.document.x2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends x2.c {
    public final /* synthetic */ yv4.e a;

    @Override // com.bytedance.ee.bear.document.x2.c, com.bytedance.ee.bear.document.x2.b
    public final void onLoadSuccess() {
    }

    public b(yv4.e r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.document.x2.c, com.bytedance.ee.bear.document.x2.b
    public final void onLoadFail(int r1, Throwable r2) {
        this.a.i();
    }
}
