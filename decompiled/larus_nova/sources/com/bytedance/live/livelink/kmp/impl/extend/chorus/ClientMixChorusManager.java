package com.bytedance.live.livelink.kmp.impl.extend.chorus;

import com.bytedance.live.livelink.kmp.impl.base.thread.CustomWorkThreadImpl;
import com.bytedance.live.livelink.kmp.impl.extend.ExtendContext;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class ClientMixChorusManager implements com.bytedance.live.livelink.kmp.impl.extend.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f255564i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f255565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f255566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f255567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public oi6.b f255568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f255569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f255570f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ExtendContext f255571g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f255572h;

    public static final class a {
    }

    static {
    }

    public final boolean a() {
        if ((!Intrinsics.areEqual(this.f255572h.k(), zi6.a.d.f572255a)) == false) goto L9;
        fi6.a r100 = com.bytedance.live.livelink.kmp.impl.extend.c.b(this);
        if (r100 == null) goto L9;
        if (r100.f477379d0 == true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void b() {
        ej6.a.c("ClientMixChorusManager", "startChorus");
        if (this.f255565a == false) goto L6;
        ej6.a.c("ClientMixChorusManager", "chorus has call start");
        return;
    L6:
        ej6.a.c("ClientMixChorusManager", "call startChorus");
        if (this.f255566b == false) goto L9;
        return;
    L9:
        if (a() == false) goto L24;
        Intrinsics.checkNotNullParameter(this, "$this$newThread");
        Intrinsics.checkNotNullParameter("ClientMixChorusManager_Mix", "name");
        oi6.d r100 = c().f255514c;
        if (r100 == null) goto L14;
        CustomWorkThreadImpl r101 = r100.e("ClientMixChorusManager_Mix");
    L15:
        this.f255568d = r101;
        this.f255565a = true;
        this.f255566b = true;
        pj6.a r102 = com.bytedance.live.livelink.kmp.impl.extend.c.c(this);
        if (r102 != null) goto L18;
        return;
    L18:
        Intrinsics.checkNotNullParameter(new ClientMixChorusManager$startChorus$1(this), "getChorusSinkJsonObject");
        ji6.c r103 = r102.f529502a;
        if (r103 == null) goto L25;
        r103.H(8, 1, new Object[0]);
        r103.u();
        r103.h();
        r103.D();
        r103.u();
        return;
    L25:
        return;
    L14:
        r101 = null;
        goto L15
    }

    public final void d() {
        ej6.a.c("ClientMixChorusManager", "call stopChorus");
        pj6.a r100 = com.bytedance.live.livelink.kmp.impl.extend.c.c(this);
        boolean r101 = this.f255566b;
        r100.getClass();
        ji6.c r102 = r100.f529502a;
        if (r102 == null) goto L8;
        r102.H(8, 0, new Object[0]);
        r102.u();
        if (r101 == false) goto L8;
        r102.h();
        r102.h();
        r102.D();
        r102.u();
    L8:
        this.f255566b = false;
        com.bytedance.live.livelink.kmp.impl.extend.c.m(this, this.f255568d);
        this.f255568d = null;
    }

    @Override // com.bytedance.live.livelink.kmp.impl.extend.b
    public final ExtendContext c() {
        return this.f255571g;
    }

    public ClientMixChorusManager(ExtendContext r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "extendContext");
        Intrinsics.checkNotNullParameter(r101, "chorusScope");
        this.f255571g = r100;
        this.f255572h = r101;
        this.f255567c = new CompositeDisposable();
    }
}
