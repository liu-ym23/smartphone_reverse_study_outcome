package com.larus.im.internal.delegate;

import com.larus.im.FlowRuntime;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c0 implements gd9.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c0 f348199b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gd9.h f348200c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gd9.h f348201a;

    static {
        f348199b = new c0();
        f348200c = FlowRuntime.b().e();
    }

    public c0() {
        this.f348201a = FlowRuntime.b().e();
    }

    @Override // gd9.h
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f348200c.d(r100, r101);
    }

    @Override // gd9.h
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f348200c.e(r100, r101);
    }

    @Override // gd9.h
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f348200c.i(r100, r101);
    }

    @Override // gd9.h
    public final void v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f348200c.v(r100, r101);
    }

    @Override // gd9.h
    public final void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f348200c.w(r100, r101);
    }

    @Override // gd9.h
    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f348200c.e(r100, r101, r102);
    }

    @Override // gd9.h
    public final void w(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f348200c.w(r100, r101, r102);
    }
}
