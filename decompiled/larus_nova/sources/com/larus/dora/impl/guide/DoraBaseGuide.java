package com.larus.dora.impl.guide;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.dora.api.IDoraGuideService;
import com.larus.dora.impl.guide.common.DoraGuideMeta;
import com.larus.dora.impl.guide.service.GuideSession$setStateListener$1;
import com.larus.platform.service.AccountService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public abstract class DoraBaseGuide implements t39.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f335863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f335864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t39.m f335865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i59.a f335866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j59.a f335867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f335868f;

    @Override // t39.l
    public final Object c(Continuation<? super Boolean> r100) {
        return n(this, r100);
    }

    public abstract void h();

    public abstract DoraGuideMeta i();

    public abstract String j();

    public void r(j59.a r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    public void s(j59.a r100, Fragment r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    public void u(j59.a r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    public Object v() {
        return null;
    }

    public abstract void x(j59.a r100, Fragment r101, View r102);

    public final j59.b g() {
        i59.a r100 = this.f335866d;
        if (r100 == null) goto L5;
        String r101 = r100.f488343a;
    L6:
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L15;
        g49.d.d(k(), "buildStateManager() skipped: wDid is null or empty");
        return null;
    L15:
        com.larus.dora.impl.util.b0.f338123a.getClass();
        return new j59.b(new j59.c(com.larus.dora.impl.util.b0.j()), j(), r101);
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    public final boolean o() {
        IDoraGuideService r100 = (IDoraGuideService) ServiceManager.get().getService(IDoraGuideService.class);
        if (r100 == null) goto L5;
        boolean r101 = r100.b();
    L6:
        if (r101 == false) goto L8;
        g49.d.d(k(), "guide suppressed: dora guide is degraded");
    L8:
        return r101;
    L5:
        r101 = true;
        goto L6
    }

    public final void q() {
        if (this.f335868f.compareAndSet(false, true) == false) goto L8;
        g49.d.d(k(), "notifyGuideFinishedOnce() for guide=" + i());
        t39.m r100 = this.f335865c;
        if (r100 == null) goto L9;
        r100.a(this);
        return;
    L9:
        return;
    }

    public final String toString() {
        return Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + "(meta=" + i() + ", state=" + this.f335864b + ')';
    }

    @Override // t39.l
    public final Unit a() {
        g49.d.d(k(), "startGuide()");
        if (o() == true) goto L7;
        y(1);
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    }

    @Override // t39.l
    public final int f() {
        return i().getGuideId();
    }

    public String k() {
        String r100 = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        if (r100 != null) goto L6;
        return "DoraBaseGuide";
    L6:
        return r100;
    }

    public final void l() {
        j59.b r100 = g();
        if (r100 == null) goto L8;
        j59.a r101 = this.f335867e;
        if (r101 != null) goto L7;
        r101 = r100.b();
    L7:
        j59.a r102 = r101;
        j59.a r103 = j59.a.a(r102, 0, 0, r102.f497471c + 1, 0, 11);
        r100.f497473a.putInt(r100.a("close_times"), r103.f497471c);
    L9:
        this.f335867e = r103;
        r(r103);
        return;
    L8:
        j59.a r104 = this.f335867e;
        r103 = j59.a.a(r104, 0, 0, r104.f497471c + 1, 0, 11);
        goto L9
    }

    public final void t() {
        g49.d.d(k(), "Guide dismissed for guide=" + i());
        y(3);
        q();
    }

    public DoraBaseGuide(String r100) {
        Intrinsics.checkNotNullParameter(r100, "page");
        this.f335863a = r100;
        this.f335867e = new j59.a(0);
        this.f335868f = new AtomicBoolean(false);
    }

    @Override // t39.l
    public final void b(GuideSession$setStateListener$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        g49.d.d(k(), "setStateListener() called with " + r100);
        this.f335865c = r100;
    }

    public final void m(Fragment r110) {
        j59.b r100 = g();
        if (r100 == null) goto L8;
        j59.a r101 = this.f335867e;
        if (r101 != null) goto L7;
        r101 = r100.b();
    L7:
        j59.a r102 = r101;
        j59.a r103 = j59.a.a(r102, 0, 0, 0, r102.f497472d + 1, 7);
        r100.f497473a.putInt(r100.a("click_times"), r103.f497472d);
    L9:
        this.f335867e = r103;
        s(r103, r110);
        return;
    L8:
        j59.a r104 = this.f335867e;
        r103 = j59.a.a(r104, 0, 0, 0, r104.f497472d + 1, 7);
        goto L9
    }

    public Object p(Continuation<? super Boolean> r100) {
        return Boxing.boxBoolean(false);
    }

    public final void y(int r100) {
        if (this.f335864b != r100) goto L5;
        return;
    L5:
        int r101 = this.f335864b;
        this.f335864b = r100;
        g49.d.d(k(), "Guide state changed: prev=" + r101 + ", new=" + r100 + ", guide=" + i());
        t39.m r102 = this.f335865c;
        if (r102 == null) goto L9;
        r102.b(this, r100, r101);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.larus.dora.impl.guide.DoraBaseGuide] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.larus.dora.impl.guide.DoraBaseGuide] */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.larus.dora.impl.guide.DoraBaseGuide, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v30, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v34 */
    /* JADX WARN: Type inference failed for: r10v35 */
    /* JADX WARN: Type inference failed for: r10v36 */
    /* JADX WARN: Type inference failed for: r10v37 */
    /* JADX WARN: Type inference failed for: r10v38 */
    /* JADX WARN: Type inference failed for: r10v39 */
    /* JADX WARN: Type inference failed for: r10v40 */
    /* JADX WARN: Type inference failed for: r10v41 */
    /* JADX WARN: Type inference failed for: r10v42 */
    /* JADX WARN: Type inference failed for: r10v43 */
    /* JADX WARN: Type inference failed for: r10v44 */
    /* JADX WARN: Type inference failed for: r10v9, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.dora.impl.guide.DoraBaseGuide, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.dora.impl.guide.DoraBaseGuide, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    public static Object n(DoraBaseGuide r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof DoraBaseGuide$isGuideConditionMet$1) == false) goto L7;
        DoraBaseGuide$isGuideConditionMet$1 r100 = (DoraBaseGuide$isGuideConditionMet$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r103 = r100.label;
        if (r103 == 0) goto L28;
        if (r103 == 1) goto L25;
        if (r103 == 2) goto L20;
        if (r103 != 3) goto L19;
        ?? r113 = r100.Z$0;
        j59.a r104 = (j59.a) r100.L$2;
        i59.a r105 = (i59.a) r100.L$1;
        ?? r106 = (DoraBaseGuide) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L16
        r106 = r106;
        r113 = r113;
    L79:
        Object r114 = Result.m9449constructorimpl(Boxing.boxBoolean(((Boolean) r112).booleanValue()));     // Catch: Throwable -> L16
        ?? r107 = r106;
        ?? r115 = r113;
    L85:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r114);
        if (r108 == null) goto L88;
        g49.d.c(r107.k(), "serverConditionCheck() error: " + r108.getMessage(), r108);
    L88:
        Boolean r109 = Boxing.boxBoolean(false);
        if (Result.m9455isFailureimpl(r114) == false) goto L91;
        r114 = r109;
    L91:
        boolean r116 = ((Boolean) r114).booleanValue();
        g49.d.d(r107.k(), "isGuideConditionMet() end, localOk=" + r115 + ", serverOk=" + r116 + ", params=" + r105 + ", state=" + r104);
        return Boxing.boxBoolean(r116);
    L16:
        Throwable th10 = th;
        j59.a r117 = r104;
        ?? r118 = r106;
        ?? r119 = r113;
    L84:
        Result.Companion r120 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th10));
        r104 = r117;
        r107 = r118;
        r115 = r119;
        goto L85
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        boolean r121 = r100.Z$0;
        DoraBaseGuide r122 = (DoraBaseGuide) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L23
        r103 = r122;
        r110 = r121;
    L56:
        Object r123 = Result.m9449constructorimpl((i59.a) r112);     // Catch: Throwable -> L23
        ?? r124 = r103;
        ?? r125 = r110;
    L59:
        Throwable r126 = Result.m9452exceptionOrNullimpl(r123);
        if (r126 == null) goto L63;
        g49.d.c(r124.k(), "resolveDeviceParams() error: " + r126.getMessage(), r126);
    L63:
        if (Result.m9455isFailureimpl(r123) == false) goto L65;
        r123 = null;
    L65:
        i59.a r127 = (i59.a) r123;
        if (r127 != null) goto L68;
    L93:
        g49.d.d(r124.k(), "resolveDeviceParams() returns null/empty wDid, skip guide");
        return Boxing.boxBoolean(false);
    L68:
        if (StringsKt.isBlank(r127.f488343a) == true) goto L93;
        r124.f335866d = r127;
        j59.b r128 = r124.g();
        if (r128 == null) goto L73;
        r117 = r128.b();
    L74:
        r124.f335867e = r117;
        r100.L$0 = r124;     // Catch: Throwable -> L82
        r100.L$1 = r127;     // Catch: Throwable -> L82
        r100.L$2 = r117;     // Catch: Throwable -> L82
        r100.Z$0 = r125;     // Catch: Throwable -> L82
        r100.label = 3;     // Catch: Throwable -> L82
        Object r129 = r124.w(r127, r117, r100);     // Catch: Throwable -> L82
        if (r129 != r102) goto L78;
        return r102;
    L78:
        r104 = r117;
        ?? r130 = r124;
        r105 = r127;
        r112 = r129;
        r106 = r130;
        r113 = r125;
    L82:
        th = move-exception;
        ?? r131 = r124;
        r105 = r127;
        th10 = th;
        r118 = r131;
        r119 = r125;
        goto L84
    L73:
        r117 = new j59.a(0);
        goto L74
    L25:
        DoraBaseGuide r132 = (DoraBaseGuide) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L41
        r110 = r132;
    L39:
        Object r133 = Result.m9449constructorimpl(Boxing.boxBoolean(((Boolean) r112).booleanValue()));     // Catch: Throwable -> L41
        ?? r134 = r110;
    L43:
        ?? r135 = r134;
        Throwable r136 = Result.m9452exceptionOrNullimpl(r133);
        if (r136 == null) goto L46;
        g49.d.c(r135.k(), "localConditionCheck() error: " + r136.getMessage(), r136);
    L46:
        Boolean r137 = Boxing.boxBoolean(false);
        if (Result.m9455isFailureimpl(r133) == false) goto L49;
        r133 = r137;
    L49:
        boolean r138 = ((Boolean) r133).booleanValue();
        if (r138 == true) goto L53;
        g49.d.d(r135.k(), "localConditionCheck() not met, skip guide");
        return Boxing.boxBoolean(false);
    L53:
        r100.L$0 = r135;     // Catch: Throwable -> L23
        r100.Z$0 = r138;     // Catch: Throwable -> L23
        r100.label = 2;     // Catch: Throwable -> L23
        r112 = r135.v();     // Catch: Throwable -> L23
        r103 = r135;
        r110 = r138;
        if (r112 != r102) goto L56;
        return r102;
    L28:
        ResultKt.throwOnFailure(r112);
        if (AccountService.f365697a.isLogin().booleanValue() == true) goto L33;
        g49.d.d(r110.k(), "guide condition not met: user not login");
        return Boxing.boxBoolean(false);
    L33:
        if (r110.o() == true) goto L35;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L41
        r100.L$0 = r110;     // Catch: Throwable -> L41
        r100.label = 1;     // Catch: Throwable -> L41
        r112 = r110.p(r100);     // Catch: Throwable -> L41
        r110 = r110;
        if (r112 != r102) goto L39;
        return r102;
    L35:
        return Boxing.boxBoolean(false);
    L41:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        r133 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        r134 = r110;
    L23:
        th = move-exception;
        Result.Companion r141 = Result.Companion;
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        r124 = r103;
        r125 = r110;
    L7:
        r100 = new DoraBaseGuide$isGuideConditionMet$1(r110, r111);
        goto L8
    }

    @Override // t39.l
    public final Object d(Fragment r100, View r101, Continuation<? super Unit> r102) {
        g49.d.d(k(), "dismissGuide() called");
        h();     // Catch: Exception -> L5
    L8:
        return Unit.INSTANCE;
    L5:
        e = move-exception;
        g49.d.c(k(), "dismissGuide() exception: " + e.getMessage(), e);
        y(404);
        q();
        goto L8
    }

    @Override // t39.l
    public final Object e(Fragment r100, View r101, Continuation<? super Unit> r110) {
        g49.d.d(k(), "showGuide() called, fragment=" + r100 + ", anchorView=" + r101);
        if (o() == true) goto L21;
        y(2);
        j59.b r111 = g();     // Catch: Exception -> L15
        long r102 = System.currentTimeMillis();     // Catch: Exception -> L15
        if (r111 == null) goto L12;
        j59.a r103 = this.f335867e;     // Catch: Exception -> L15
        if (r103 != null) goto L11;
        r103 = r111.b();     // Catch: Exception -> L15
    L11:
        j59.a r104 = j59.a.a(r103, r102, r103.f497470b + 1, 0, 0, 12);     // Catch: Exception -> L15
        r111.f497473a.putLong(r111.a("last_show_time"), r104.f497469a);     // Catch: Exception -> L15
        r111.f497473a.putInt(r111.a("show_times"), r104.f497470b);     // Catch: Exception -> L15
    L13:
        this.f335867e = r104;     // Catch: Exception -> L15
        u(r104);     // Catch: Exception -> L15
        x(r104, r100, r101);     // Catch: Exception -> L15
    L18:
        return Unit.INSTANCE;
    L12:
        j59.a r105 = this.f335867e;     // Catch: Exception -> L15
        r104 = j59.a.a(r105, r102, r105.f497470b + 1, 0, 0, 12);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        g49.d.c(k(), "showGuide() exception: " + e.getMessage(), e);
        y(404);
        q();
        goto L18
    L21:
        return Unit.INSTANCE;
    }

    public Object w(i59.a r100, j59.a r101, Continuation<? super Boolean> r102) {
        return Boxing.boxBoolean(false);
    }
}
