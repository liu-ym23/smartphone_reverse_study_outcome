package com.bytedance.ee.bear.middleground.comment.uitls;

import com.bytedance.ee.bear.middleground.comment.export.bean.TranslateConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements com.bytedance.ee.bear.middleground.comment.export.j {
    public final p a;

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void f() {
        this.a.A = true;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void j() {
        this.a.B = true;
    }

    public i(p r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.a = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void a(TranslateConfig r3) {
        Intrinsics.checkNotNullParameter(r3, "translate");
        p r0 = this.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.x = r3;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void b(float r2) {
        this.a.b0 = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void c(float r2) {
        this.a.a0 = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void d(boolean r2) {
        this.a.C = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void e(long r2) {
        this.a.p = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void g(float r2) {
        this.a.c0 = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void h(boolean r2) {
        this.a.s = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void i(float r2) {
        this.a.Z = r2;
    }
}
