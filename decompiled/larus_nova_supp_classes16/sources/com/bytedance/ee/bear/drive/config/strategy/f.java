package com.bytedance.ee.bear.drive.config.strategy;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements com.bytedance.ee.drive.render.k {
    public final com.bytedance.ee.drive.render.k.a a;
    public final com.bytedance.ee.drive.render.k.b b;
    public final com.bytedance.ee.drive.render.k.e c;
    public final com.bytedance.ee.drive.render.k.h d;
    public final com.bytedance.ee.drive.render.k.f e;
    public final com.bytedance.ee.drive.render.k.c f;
    public final com.bytedance.ee.drive.render.k.d g;
    public final com.bytedance.ee.drive.render.k.g h;

    @Override // com.bytedance.ee.drive.render.k
    public final com.bytedance.ee.drive.render.k.b a() {
        return this.b;
    }

    @Override // com.bytedance.ee.drive.render.k
    public final com.bytedance.ee.drive.render.k.d b() {
        return this.g;
    }

    @Override // com.bytedance.ee.drive.render.k
    public final com.bytedance.ee.drive.render.k.e c() {
        return this.c;
    }

    @Override // com.bytedance.ee.drive.render.k
    public final com.bytedance.ee.drive.render.k.c d() {
        return this.f;
    }

    @Override // com.bytedance.ee.drive.render.k
    public final com.bytedance.ee.drive.render.k.a getContainer() {
        return this.a;
    }

    @Override // com.bytedance.ee.drive.render.k
    public final com.bytedance.ee.drive.render.k.f getText() {
        return this.e;
    }

    @Override // com.bytedance.ee.drive.render.k
    public final com.bytedance.ee.drive.render.k.g getTitleBar() {
        return this.h;
    }

    @Override // com.bytedance.ee.drive.render.k
    public final com.bytedance.ee.drive.render.k.h getVideo() {
        return this.d;
    }

    public f(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        this.a = new com.bytedance.ee.drive.render.k.a(true);
        int r0 = xo5.a.a(14.0f);
        int r2 = r6.getResources().getColor(2131106607);
        int r3 = r6.getResources().getColor(2131101111);
        this.b = new com.bytedance.ee.drive.render.k.b(r0, r2, r6.getResources().getColor(2131108718), r3);
        this.c = new com.bytedance.ee.drive.render.k.e(Boolean.FALSE);
        this.d = new com.bytedance.ee.drive.render.k.h(true, true, 4);
        this.e = new com.bytedance.ee.drive.render.k.f(true);
        this.f = new com.bytedance.ee.drive.render.k.c(false, false, 65);
        this.g = new com.bytedance.ee.drive.render.k.d(true);
        this.h = new com.bytedance.ee.drive.render.k.g(true, true);
    }
}
