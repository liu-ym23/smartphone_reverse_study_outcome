package com.larus.doc.impl.crowdtest;

import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import hq9.n3;
import kotlin.jvm.internal.Intrinsics;
import q99.d;
import q99.e;
import q99.l;
import q99.m;
import q99.n;

/* JADX INFO: loaded from: classes27.dex */
public final class a implements o99.a {
    public a() {
    }

    @Override // o99.b
    public final void d() {
    }

    @Override // o99.c
    public final void e(d r100) {
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
    public final void a(m r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "error");
        FLogger.f375446a.i("DocCrowdTestHelper", "messageFeedback#onFailure error :" + r101 + ' ');
    }

    @Override // o99.b
    public final void c(e r100, q99.a r101) {
        o99.a.C7024a.a(r100, r101);
    }

    @Override // o99.a
    public final void g(m r100, n r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "result");
        FLogger.f375446a.i("DocCrowdTestHelper", "messageFeedback#onSuccess");
    }

    @Override // o99.b
    public final void j(e r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "delivery");
        Intrinsics.checkNotNullParameter(r100, "delivery");
    }
}
