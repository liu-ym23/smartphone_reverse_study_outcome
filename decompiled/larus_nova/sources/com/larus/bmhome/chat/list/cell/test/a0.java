package com.larus.bmhome.chat.list.cell.test;

import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import hq9.n3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a0 implements o99.a {
    public a0() {
    }

    @Override // o99.b
    public final void d() {
    }

    @Override // o99.c
    public final void e(q99.d r100) {
    }

    @Override // o99.b
    public final void h() {
    }

    @Override // o99.b
    public final void i() {
    }

    @Override // o99.b
    public final Bundle b(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        Intrinsics.checkNotNullParameter(r100, "bundle");
        return r100;
    }

    @Override // o99.b
    public final n3 f(n3 r100) {
        Intrinsics.checkNotNullParameter(r100, "originalRequest");
        Intrinsics.checkNotNullParameter(r100, "originalRequest");
        return r100;
    }

    @Override // o99.a
    public final void a(q99.m r100, q99.l r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "error");
        FLogger.f375446a.i("EvaluationTask", "CrowdTestTask #onFailure error :" + r101 + ' ');
    }

    @Override // o99.b
    public final void c(q99.e r100, q99.a r101) {
        o99.a.C7024a.a(r100, r101);
    }

    @Override // o99.a
    public final void g(q99.m r100, q99.n r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "result");
        FLogger.f375446a.i("EvaluationTask", "CrowdTestTask #onSuccess message");
    }

    @Override // o99.b
    public final void j(q99.e r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "delivery");
        Intrinsics.checkNotNullParameter(r100, "delivery");
    }
}
