package com.larus.audio.call.arch;

import com.larus.audio.call.arch.c;
import com.larus.audio.call.mgr.MajorState;
import com.larus.im.service.audio.z0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes24.dex */
public abstract class a<C extends c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C f289055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z0 f289056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.larus.im.service.audio.x f289057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.larus.im.service.audio.v f289058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.larus.audio.call.mgr.f.a f289059e;

    public com.larus.audio.call.mgr.f.a P2() {
        return null;
    }

    public com.larus.im.service.audio.x Q2() {
        return null;
    }

    public com.larus.im.service.audio.v R2() {
        return null;
    }

    public z0 S2() {
        return null;
    }

    public abstract String T2();

    public void V2() {
    }

    public void W2() {
    }

    public void X2() {
    }

    public void Y2() {
    }

    public void Z2() {
    }

    public void a3() {
    }

    public void b3() {
    }

    public void c3() {
    }

    public void d3() {
    }

    public void f3() {
    }

    public void h3() {
    }

    public void g3() {
        z0 r100 = this.f289056b;
        if (r100 == null) goto L7;
        id9.d r101 = this.f289055a.j();
        if (r101 == null) goto L7;
        r101.n(r100);
    L7:
        com.larus.im.service.audio.v r102 = this.f289058d;
        if (r102 == null) goto L12;
        id9.d r103 = this.f289055a.j();
        if (r103 == null) goto L12;
        r103.b(r102);
    L12:
        com.larus.im.service.audio.x r104 = this.f289057c;
        if (r104 == null) goto L17;
        id9.d r105 = this.f289055a.j();
        if (r105 == null) goto L17;
        r105.d(r104);
    L17:
        com.larus.audio.call.mgr.f.a r106 = this.f289059e;
        if (r106 == null) goto L20;
        this.f289055a.a().V(r106);
    L20:
        this.f289056b = null;
        this.f289058d = null;
        this.f289059e = null;
        this.f289057c = null;
    }

    public final boolean i3() {
        MajorState r100 = this.f289055a.a().s1();
        if ((r100 instanceof MajorState.c) == false) goto L5;
    L9:
        return false;
    L5:
        if ((r100 instanceof MajorState.a) == true) goto L9;
        if ((r100 instanceof MajorState.f) == true) goto L9;
        return true;
    }

    public void e3() {
        z0 r100 = S2();
        if (r100 == null) goto L8;
        id9.d r101 = this.f289055a.j();
        if (r101 == null) goto L7;
        r101.q(r100);
    L7:
        this.f289056b = r100;
    L8:
        com.larus.im.service.audio.x r102 = Q2();
        if (r102 == null) goto L14;
        id9.d r103 = this.f289055a.j();
        if (r103 == null) goto L13;
        r103.x(r102);
    L13:
        this.f289057c = r102;
    L14:
        com.larus.im.service.audio.v r104 = R2();
        if (r104 == null) goto L20;
        id9.d r105 = this.f289055a.j();
        if (r105 == null) goto L19;
        r105.w(r104);
    L19:
        this.f289058d = r104;
    L20:
        com.larus.audio.call.mgr.f.a r106 = P2();
        if (r106 == null) goto L24;
        this.f289055a.a().M0(r106);
        this.f289059e = r106;
        return;
    }

    public final C getContext() {
        return this.f289055a;
    }

    public a(C r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f289055a = r100;
    }

    public final Job U2(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        CoroutineScope r101 = this.f289055a.r();
        if (r101 == null) goto L5;
        Job r102 = BuildersKt.launch$default(r101, null, null, r100, 3, null);
    L6:
        if (r102 != null) goto L8;
        com.larus.audio.call.util.e.f289645a.e(T2(), "launchDuplexCollect: lifecycleScope is null, duplex collect unavailable, duplexConsumerEnabled=" + com.larus.audio.call.f.f());
    L8:
        return r102;
    L5:
        r102 = null;
        goto L6
    }
}
