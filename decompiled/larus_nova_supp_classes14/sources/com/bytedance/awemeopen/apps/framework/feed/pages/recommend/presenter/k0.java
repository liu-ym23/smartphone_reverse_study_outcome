package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter;

import android.os.SystemClock;
import android.view.View;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.domain.base.repo.GsonHolder;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k0 extends g04.a<jz3.a> {
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a e;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.i f;
    public final i0 g;
    public final g0 h;
    public jz3.a i;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.s j;
    public final j0 k;
    public final h0 l;

    public final void m() {
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.i r0 = this.f;
        jz3.a r1 = this.i;
        jz3.a r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r1 = null;
    L5:
        r14.c r3 = r1.a;
        jz3.a r4 = this.i;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L9:
        r14.a0 r5 = r2.a.d;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "aweme");
        return;
    L8:
        r2 = r4;
        goto L9
    }

    public final void n() {
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.i r0 = this.f;
        jz3.a r1 = this.i;
        jz3.a r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r1 = null;
    L5:
        r14.c r3 = r1.a;
        jz3.a r4 = this.i;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L9:
        r14.a0 r5 = r2.a.d;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "aweme");
        long r6 = SystemClock.elapsedRealtime() - r0.a;
        if (r6 <= 0) goto L12;
        r0.b += r6;
    L12:
        r0.a = SystemClock.elapsedRealtime();
        if (r0.b <= 0) goto L17;
        r0.b = 0;
        return;
    L17:
        return;
    L8:
        r2 = r4;
        goto L9
    }

    @Override // g04.a
    public final void g() {
        m();
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.i r0 = this.f;
        r0.b = 0;
        r0.a = SystemClock.elapsedRealtime();
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.s r1 = this.j;
        j0 r2 = this.k;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "listener");
        r1.e = r2;
        this.j.b();
        throw null;
    }

    @Override // g04.a
    public final void i() {
        n();
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.s r0 = this.j;
        r0.c = 0;
        r0.d = 0;
        r0.b.removeCallbacks(r0.f);
        throw null;
    }

    @Override // g04.a
    public final void h() {
        throw null;
    }

    @Override // g04.a
    public final void f(jz3.a r22) {
        jz3.a r1 = r22;
        Intrinsics.checkNotNullParameter(r1, "data");
        this.i = r1;
        String r4 = r1.a.c();
        String r5 = r1.a.p();
        User r2 = r1.a.f();
        String r11 = null;
        if (r2 == null) goto L5;
        String r6 = r2.t();
    L6:
        String r7 = r1.a.H();
        v14.a r3 = r1.a.j();
        if (r3 == null) goto L9;
        String r8 = r3.a();
    L10:
        r14.a0 r9 = r1.a.d;
        if (r9 == null) goto L13;
        String r10 = r9.a();
    L14:
        new l14.a(r4, r5, r6, r7, r8, r10, ((Number) this.e.h.invoke()).intValue());
        d14.a r12 = b14.a.a;
        t24.a r13 = b14.a.a(t24.a.class);
        String r14 = this.e.c.sceneId();
        User r15 = r1.a.f();
        if (r15 == null) goto L20;
        String r16 = r15.u();
        if (r16 == null) goto L20;
        String r17 = r16;
    L21:
        String r18 = r1.a.c();
        String r19 = r1.a.r().c;
        if (r19 != null) goto L24;
        String r110 = "";
    L25:
        r14.a0 r20 = r1.a.d;
        if (r20 == null) goto L28;
        r11 = r20.a();
    L28:
        if (r11 != null) goto L30;
        String r111 = "";
    L31:
        String r112 = GsonProtectorUtils.toJson(GsonHolder.a(), r1.a.d);
        User r21 = r1.a.f();
        if (r21 == null) goto L34;
        boolean r113 = r21.O();
    L35:
        AosEventReporter r23 = AosEventReporter.a;
        String r24 = this.e.c.sceneId();
        r23.getClass();
        t24.a.a.a(r13, r14, r17, r18, r110, r111, r112, r113, AosEventReporter.a(r24, r1));
        View r25 = this.e.a;
        throw null;
    L34:
        r113 = false;
        goto L35
    L30:
        r111 = r11;
        goto L31
    L24:
        r110 = r19;
    L20:
        r17 = "";
        goto L21
    L13:
        r10 = null;
        goto L14
    L9:
        r8 = null;
        goto L10
    L5:
        r6 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.g0] */
    public k0(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r2, l14.b r3, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.i r4) {
        Intrinsics.checkNotNullParameter(r2, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r3, "fitContainerAd");
        Intrinsics.checkNotNullParameter(r4, "adEventRecorder");
        super(r2.a);
        this.e = r2;
        this.f = r4;
        this.g = new i0(this);
        this.h = new g0(this);
        this.j = new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.s(100000);
        this.k = new j0(this);
        this.l = new h0();
    }
}
