package com.larus.im.internal.delegate;

import com.larus.im.FlowRuntime;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c1 implements gd9.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c1 f348202a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gd9.z f348203b = null;

    public c1() {
    }

    static {
        f348202a = new c1();
        f348203b = FlowRuntime.b().i();
    }

    public static String m() {
        if (FlowRuntime.b().h().a() == false) goto L5;
        return "FlowIMSDK_minor";
    L5:
        return "FlowIMSDK";
    }

    @Override // gd9.z
    public final boolean c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "repo");
        return f348203b.c(r100, m() + r101);
    }

    @Override // gd9.z
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "repo");
        f348203b.d(r100, m() + r101);
    }

    @Override // gd9.z
    public final double g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "repo");
        return f348203b.g(r100, m() + r101);
    }

    @Override // gd9.z
    public final boolean h(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "repo");
        return f348203b.h(r100, m() + r101);
    }

    @Override // gd9.z
    public final long l(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "repo");
        return f348203b.l(r100, m() + r101);
    }

    @Override // gd9.z
    public final String a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defValue");
        Intrinsics.checkNotNullParameter(r102, "repo");
        return f348203b.a(r100, r101, m() + r102);
    }

    @Override // gd9.z
    public final void b(String r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "repo");
        f348203b.b(r100, r101, m() + r102);
    }

    @Override // gd9.z
    public final void e(String r100, double r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "repo");
        f348203b.e(r100, r101, m() + r102);
    }

    @Override // gd9.z
    public final int f(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "repo");
        return f348203b.f(r100, r101, m() + r102);
    }

    @Override // gd9.z
    public final void i(String r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "repo");
        f348203b.i(r100, r101, m() + r102);
    }

    @Override // gd9.z
    public final void j(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "repo");
        f348203b.j(r100, r101, m() + r102);
    }

    @Override // gd9.z
    public final void k(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter(r102, "repo");
        f348203b.k(r100, r101, m() + r102);
    }
}
