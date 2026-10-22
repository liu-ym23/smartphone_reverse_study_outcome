package com.bytedance.ee.bear.middleground.comment.uitls;

import com.bytedance.ee.bear.middleground.comment.export.bean.TranslateConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i implements com.bytedance.ee.bear.middleground.comment.export.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f232210a;

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void f() {
        this.f232210a.A = true;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void j() {
        this.f232210a.B = true;
    }

    public i(p r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f232210a = r100;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void a(TranslateConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "translate");
        p r101 = this.f232210a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r101.f232248x = r100;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void b(float r100) {
        this.f232210a.f232221b0 = r100;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void c(float r100) {
        this.f232210a.f232219a0 = r100;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void d(boolean r100) {
        this.f232210a.C = r100;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void e(long r100) {
        this.f232210a.f232240p = r100;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void g(float r100) {
        this.f232210a.f232223c0 = r100;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void h(boolean r100) {
        this.f232210a.f232243s = r100;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void i(float r100) {
        this.f232210a.Z = r100;
    }
}
