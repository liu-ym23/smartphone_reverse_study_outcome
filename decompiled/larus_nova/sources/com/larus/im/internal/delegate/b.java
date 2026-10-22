package com.larus.im.internal.delegate;

import com.larus.im.FlowRuntime;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements gd9.p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f348193b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gd9.p f348194a;

    static {
        f348193b = new b();
    }

    @Override // gd9.p
    public final boolean a() {
        return this.f348194a.a();
    }

    @Override // gd9.p
    public final boolean b() {
        return this.f348194a.b();
    }

    @Override // gd9.p
    public final void c(gd9.c0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f348194a.c(r100);
    }

    @Override // gd9.p
    public final void d(NativeMessageServiceImpl.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f348194a.d(r100);
    }

    @Override // gd9.p
    public final boolean e() {
        return this.f348194a.e();
    }

    @Override // gd9.p
    public final void f(gd9.c0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f348194a.f(r100);
    }

    @Override // gd9.p
    public final boolean g() {
        return this.f348194a.g();
    }

    @Override // gd9.p
    public final String getUserId() {
        return this.f348194a.getUserId();
    }

    @Override // gd9.p
    public final String h() {
        return this.f348194a.h();
    }

    @Override // gd9.p
    public final void i(gd9.b0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f348194a.i(r100);
    }

    @Override // gd9.p
    public final boolean isLogin() {
        return this.f348194a.isLogin();
    }

    @Override // gd9.p
    public final String j() {
        return this.f348194a.j();
    }

    public b() {
        this.f348194a = FlowRuntime.b().h();
    }
}
