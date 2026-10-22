package com.larus.im.internal.delegate;

import android.app.Application;
import com.larus.im.FlowRuntime;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements gd9.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f348197a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FlowRuntime.a f348198b = null;

    public c() {
    }

    @Override // gd9.l
    public final void isOversea() {
    }

    @Override // gd9.l
    public final void isPlugin() {
    }

    static {
        f348197a = new c();
        f348198b = FlowRuntime.b();
    }

    @Override // gd9.l
    public final int appId() {
        return f348198b.a().appId();
    }

    @Override // gd9.l
    public final String appName() {
        return f348198b.a().appName();
    }

    @Override // gd9.l
    public final String channel() {
        return f348198b.a().channel();
    }

    @Override // gd9.l
    public final String e() {
        return f348198b.a().e();
    }

    @Override // gd9.l
    public final int f() {
        return f348198b.a().f();
    }

    @Override // gd9.l
    public final Application getApplication() {
        return f348198b.a().getApplication();
    }

    @Override // gd9.l
    public final boolean isDebug() {
        return f348198b.a().isDebug();
    }

    @Override // gd9.l
    public final boolean isTestChannel() {
        return f348198b.a().isTestChannel();
    }

    @Override // gd9.l
    public final String m() {
        return f348198b.a().m();
    }

    @Override // gd9.l
    public final boolean o() {
        return f348198b.a().o();
    }

    @Override // gd9.l
    public final boolean a() {
        if (FlowRuntime.d() == true) goto L7;
        return false;
    L7:
        return f348198b.a().a();
    }

    @Override // gd9.l
    public final boolean b() {
        if (FlowRuntime.d() == true) goto L7;
        return false;
    L7:
        return f348198b.a().b();
    }

    @Override // gd9.l
    public final long currentTimeMillis() {
        if (FlowRuntime.d() == true) goto L7;
        return fuc.a.a().a();
    L7:
        return f348198b.a().currentTimeMillis();
    }

    @Override // gd9.l
    public final long elapsedRealtime() {
        if (FlowRuntime.d() == true) goto L7;
        return fuc.a.a().a();
    L7:
        return f348198b.a().elapsedRealtime();
    }

    @Override // gd9.l
    public final boolean h() {
        if (FlowRuntime.d() == true) goto L7;
        return false;
    L7:
        return f348198b.a().h();
    }

    @Override // gd9.l
    public final String i() {
        if (FlowRuntime.d() == true) goto L7;
        return null;
    L7:
        return f348198b.a().i();
    }

    @Override // gd9.l
    public final boolean isDebugChannel() {
        return Intrinsics.areEqual(channel(), "debug");
    }

    @Override // gd9.l
    public final boolean j() {
        if (FlowRuntime.d() == true) goto L7;
        return false;
    L7:
        return f348198b.a().j();
    }

    @Override // gd9.l
    public final boolean k() {
        if (FlowRuntime.d() == true) goto L7;
        return false;
    L7:
        return f348198b.a().k();
    }

    @Override // gd9.l
    public final long l() {
        if (FlowRuntime.d() == true) goto L7;
        return -1;
    L7:
        return f348198b.a().l();
    }

    @Override // gd9.l
    public final boolean n() {
        if (FlowRuntime.d() == true) goto L7;
        return false;
    L7:
        return f348198b.a().n();
    }

    @Override // gd9.l
    public final long p() {
        if (FlowRuntime.d() == true) goto L7;
        return -1;
    L7:
        return f348198b.a().p();
    }

    @Override // gd9.l
    public final void d(long r100) {
        gd9.l.a.a(this, r100);
    }

    @Override // gd9.l
    public final long g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "dbName");
        if (FlowRuntime.d() == true) goto L7;
        return -1;
    L7:
        return f348198b.a().g(r100);
    }

    @Override // gd9.l
    public final void q(gd9.l.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        f348198b.a().q(r100);
    }

    @Override // gd9.l
    public final void r(gd9.l.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        f348198b.a().r(r100);
    }

    @Override // gd9.l
    public final String c(CharSequence r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "content");
        if (FlowRuntime.d() == true) goto L7;
        return r100.toString();
    L7:
        return f348198b.a().c(r100, r101, r102);
    }
}
