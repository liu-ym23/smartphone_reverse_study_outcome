package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter;

import android.os.SystemClock;
import android.view.View;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.domain.base.repo.GsonHolder;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.bmhome.share.panel.ShareChannel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class k0 extends g04.a<jz3.a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a f195523e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.i f195524f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i0 f195525g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g0 f195526h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public jz3.a f195527i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.s f195528j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final j0 f195529k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final h0 f195530l;

    public final void m() {
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.i r100 = this.f195524f;
        jz3.a r101 = this.f195527i;
        jz3.a r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r101 = null;
    L5:
        r14.c r103 = r101.f501173a;
        jz3.a r104 = this.f195527i;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L9:
        r14.a0 r105 = r102.f501173a.f535622d;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, ShareChannel.DOUYIN);
        return;
    L8:
        r102 = r104;
        goto L9
    }

    public final void n() {
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.i r100 = this.f195524f;
        jz3.a r101 = this.f195527i;
        jz3.a r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r101 = null;
    L5:
        r14.c r103 = r101.f501173a;
        jz3.a r104 = this.f195527i;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L9:
        r14.a0 r105 = r102.f501173a.f535622d;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, ShareChannel.DOUYIN);
        long r106 = SystemClock.elapsedRealtime() - r100.f195072a;
        if (r106 <= 0) goto L12;
        r100.f195073b += r106;
    L12:
        r100.f195072a = SystemClock.elapsedRealtime();
        if (r100.f195073b <= 0) goto L17;
        r100.f195073b = 0;
        return;
    L17:
        return;
    L8:
        r102 = r104;
        goto L9
    }

    @Override // g04.a
    public final void g() {
        m();
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.i r100 = this.f195524f;
        r100.f195073b = 0;
        r100.f195072a = SystemClock.elapsedRealtime();
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.s r101 = this.f195528j;
        j0 r102 = this.f195529k;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "listener");
        r101.f195102e = r102;
        this.f195528j.b();
        throw null;
    }

    @Override // g04.a
    public final void i() {
        n();
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.s r100 = this.f195528j;
        r100.f195100c = 0;
        r100.f195101d = 0;
        r100.f195099b.removeCallbacks(r100.f195103f);
        throw null;
    }

    @Override // g04.a
    public final void h() {
        throw null;
    }

    @Override // g04.a
    public final void f(jz3.a r210) {
        jz3.a r100 = r210;
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f195527i = r100;
        String r101 = r100.f501173a.c();
        String r102 = r100.f501173a.p();
        User r103 = r100.f501173a.f();
        String r110 = null;
        if (r103 == null) goto L5;
        String r104 = r103.t();
    L6:
        String r105 = r100.f501173a.H();
        v14.a r106 = r100.f501173a.j();
        if (r106 == null) goto L9;
        String r107 = r106.a();
    L10:
        r14.a0 r108 = r100.f501173a.f535622d;
        if (r108 == null) goto L13;
        String r109 = r108.a();
    L14:
        new l14.a(r101, r102, r104, r105, r107, r109, this.f195523e.f195168h.invoke().intValue());
        d14.a r111 = b14.a.f16924a;
        t24.a r112 = (t24.a) b14.a.a(t24.a.class);
        String r113 = this.f195523e.f195163c.sceneId();
        User r114 = r100.f501173a.f();
        if (r114 == null) goto L20;
        String r115 = r114.u();
        if (r115 == null) goto L20;
        String r116 = r115;
    L21:
        String r117 = r100.f501173a.c();
        String r118 = r100.f501173a.r().f535651c;
        if (r118 != null) goto L24;
        String r119 = "";
    L25:
        r14.a0 r120 = r100.f501173a.f535622d;
        if (r120 == null) goto L28;
        r110 = r120.a();
    L28:
        if (r110 != null) goto L30;
        String r121 = "";
    L31:
        String r122 = GsonProtectorUtils.toJson(GsonHolder.a(), r100.f501173a.f535622d);
        User r123 = r100.f501173a.f();
        if (r123 == null) goto L34;
        boolean r124 = r123.O();
    L35:
        AosEventReporter r125 = AosEventReporter.f194596a;
        String r126 = this.f195523e.f195163c.sceneId();
        r125.getClass();
        t24.a.C7679a.a(r112, r113, r116, r117, r119, r121, r122, r124, AosEventReporter.a(r126, r100));
        View r127 = this.f195523e.f195161a;
        throw null;
    L34:
        r124 = false;
        goto L35
    L30:
        r121 = r110;
        goto L31
    L24:
        r119 = r118;
    L20:
        r116 = "";
        goto L21
    L13:
        r109 = null;
        goto L14
    L9:
        r107 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.g0] */
    public k0(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r100, l14.b r101, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.i r102) {
        Intrinsics.checkNotNullParameter(r100, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r101, "fitContainerAd");
        Intrinsics.checkNotNullParameter(r102, "adEventRecorder");
        super(r100.f195161a);
        this.f195523e = r100;
        this.f195524f = r102;
        this.f195525g = new i0(this);
        this.f195526h = new g0(this);
        this.f195528j = new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.s(100000);
        this.f195529k = new j0(this);
        this.f195530l = new h0();
    }
}
