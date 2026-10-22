package com.bytedance.live.bizlink.impl.platform;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.livelink.guestlink.GuestLinkService;
import com.bytedance.android.live.livelink.multilink.MultiLinkService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.scope.o;
import com.bytedance.live.bizlink.impl.platform.manager.MultiLinkGuestManager;
import com.bytedance.live.bizlink.impl.platform.rtc.MultiLinkRtcManager;
import com.bytedance.live.bizlink.impl.platform.status.StatusCenter;
import com.bytedance.revenue.platform.api.core.rx.c;
import com.ss.android.lark.utils.statistics.PerfLog;
import gd0.j;
import hg6.h;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import je0.d;
import kotlin.jvm.internal.Intrinsics;
import qg6.f;
import vb6.g;
import vm2.e;
import vm2.i;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements o, cg6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f254868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public lb6.g f254869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public StatusCenter f254870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MultiLinkRtcManager f254871d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.live.bizlink.impl.platform.manager.a f254872e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MultiLinkGuestManager f254873f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public bh6.a f254874g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f254875h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BehaviorSubject<Boolean> f254876i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final bn0.b f254877j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final yz0.g f254878k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final hd0.b f254879l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final j f254880m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final fc6.a f254881n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final jb6.a f254882o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final f f254883p;

    /* JADX INFO: renamed from: com.bytedance.live.bizlink.impl.platform.a$a, reason: collision with other inner class name */
    public static final class C3625a {
    }

    static {
    }

    @Override // cg6.a
    public final g O5() {
        g r100 = this.f254868a;
        if (r100 == null) goto L7;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mLinkService");
    L6:
        return r100;
    L7:
        return null;
    }

    @Override // cg6.a
    public final lb6.g W8() {
        lb6.g r100 = this.f254869b;
        if (r100 == null) goto L7;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mGuestLinkService");
    L6:
        return r100;
    L7:
        return null;
    }

    @Override // cg6.a
    public final hg6.g getRtcManager() {
        MultiLinkRtcManager r100 = this.f254871d;
        if (r100 == null) goto L7;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mRtcManager");
    L6:
        return r100;
    L7:
        return null;
    }

    @Override // cg6.a
    public final void onResume() {
        if (((Boolean) e.C.getValue(null, e.f556037a[27])).booleanValue() == true) goto L5;
        return;
    L5:
        if (i.a().getLinkServiceEnable() == true) goto L7;
        return;
    L7:
        if (this.f254874g != null) goto L14;
        this.f254883p.Y().getClass();
        if (mh6.b.b(d.h()) == false) goto L15;
        bh6.a r100 = new bh6.a(this, this.f254878k, this.f254883p, this.f254877j);
        this.f254874g = r100;
        r100.d();
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        jy0.b.c("MultiLinkComponentV2", "onStart: call in room[" + IRoomKtKt.getId(this.f254878k.getRoom()) + ']', null, 4);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        jy0.b.c("MultiLinkComponentV2", "onStop: call in room[" + IRoomKtKt.getId(this.f254878k.getRoom()) + ']', null, 4);
    }

    @Override // cg6.a
    public final void release() {
        jy0.b.c("MultiLinkComponentV2", "release: call in room[" + IRoomKtKt.getId(this.f254878k.getRoom()) + ']', null, 4);
        bh6.a r100 = this.f254874g;
        if (r100 == null) goto L5;
        r100.c();
    L5:
        this.f254874g = null;
        com.bytedance.live.bizlink.impl.platform.manager.a r101 = this.f254872e;
        if (r101 == null) goto L8;
        r101.f254965o.clear();
        r101.f254967q.clear();
    L8:
        this.f254872e = null;
        MultiLinkGuestManager r102 = this.f254873f;
        if (r102 == null) goto L11;
        ((ArrayList) r102.f254912m).clear();
        ((ArrayList) r102.f254910k).clear();
        r102.f254915p.clear();
    L11:
        this.f254873f = null;
        MultiLinkRtcManager r103 = this.f254871d;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mRtcManager");
    L14:
        r103.f255009i.clear();
        MultiLinkRtcManager r104 = this.f254871d;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mRtcManager");
    L17:
        xi0.b r105 = r104.f255007g;
        if (r105 == null) goto L21;
        r105.h();
    L21:
        if (this.f254878k.isAnchor() == false) goto L26;
        g r106 = this.f254868a;
        if (r106 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mLinkService");
    L25:
        r106.h(new b(this));
    L26:
        lb6.g r107 = this.f254869b;
        if (r107 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mGuestLinkService");
    L29:
        r107.detach();
        this.f254875h = false;
        this.f254876i.onNext(Boolean.FALSE);
    }

    @Override // cg6.a
    public final com.bytedance.live.bizlink.impl.platform.manager.a A0() {
        return this.f254872e;
    }

    @Override // cg6.a
    public final h Fn() {
        return this.f254874g;
    }

    @Override // cg6.a
    public final MultiLinkGuestManager W4() {
        return this.f254873f;
    }

    @Override // cg6.a
    public final BehaviorSubject dj() {
        return this.f254876i;
    }

    @Override // cg6.a
    public final jg6.a e5() {
        return this.f254870c;
    }

    @Override // cg6.a
    public final void init(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f254875h == false) goto L5;
        return;
    L5:
        jy0.b.c("MultiLinkComponentV2", "init: call in room[" + IRoomKtKt.getId(this.f254878k.getRoom()) + ']', null, 4);
        MultiLinkService r100 = this.f254882o.wi(r110, this.f254878k.isAnchor());
        this.f254868a = r100;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mLinkService");
    L8:
        r100.attach();
        g r101 = this.f254868a;
        if (r101 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mLinkService");
    L11:
        long r102 = IRoomKtKt.getId(this.f254878k.getRoom());
        IBaseUser r103 = this.f254878k.getRoom().getOwnerKt();
        String r104 = "";
        if (r103 == null) goto L15;
        String r105 = r103.getIdString();
        if (r105 == null) goto L15;
    L16:
        r101.b(r102, r105, null);
        GuestLinkService r106 = this.f254882o.Bo(r110, this.f254878k.isAnchor());
        this.f254869b = r106;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mGuestLinkService");
    L19:
        r106.o();
        lb6.g r107 = this.f254869b;
        if (r107 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mGuestLinkService");
    L22:
        long r108 = IRoomKtKt.getId(this.f254878k.getRoom());
        IBaseUser r109 = this.f254878k.getRoom().getOwnerKt();
        if (r109 == null) goto L28;
        String r111 = r109.getIdString();
        if (r111 == null) goto L28;
        r104 = r111;
    L28:
        r107.m(r108, r104);
        boolean r112 = this.f254878k.isAnchor();
        g r113 = this.f254868a;
        if (r113 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mLinkService");
    L31:
        this.f254870c = new StatusCenter(r112, r113.j());
        g r114 = this.f254868a;
        if (r114 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mLinkService");
    L34:
        StatusCenter r115 = this.f254870c;
        Intrinsics.checkNotNull(r115);
        this.f254871d = new MultiLinkRtcManager(r114, r115, this.f254878k, this.f254883p, this.f254881n, this.f254877j, this);
        MultiLinkRtcManager r116 = this.f254871d;
        if (r116 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mRtcManager");
    L37:
        this.f254872e = new com.bytedance.live.bizlink.impl.platform.manager.a(r116, this.f254878k, this.f254883p, this.f254880m, this.f254877j);
        StatusCenter r117 = this.f254870c;
        Intrinsics.checkNotNull(r117);
        MultiLinkRtcManager r118 = this.f254871d;
        if (r118 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mRtcManager");
    L40:
        this.f254873f = new MultiLinkGuestManager(r117, r118, this.f254878k, this.f254883p, this.f254877j);
        if (hg6.i.b(this.f254878k.getRoom()) == false) goto L43;
        this.f254874g = new bh6.a(this, this.f254878k, this.f254883p, this.f254877j);
    L43:
        MultiLinkRtcManager r119 = this.f254871d;
        if (r119 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("mRtcManager");
    L46:
        r119.f255007g = r119.K.Y().d(r119.f255000J.getRoom(), r119, r119.f255003c);
        MultiLinkRtcManager r120 = this.f254871d;
        if (r120 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mRtcManager");
    L49:
        r120.getClass();
        og6.a.a("RtcListener", "MultiLinkRtcManager#initRtcCallback");
        r120.H.X0(r120.F, true);
        r120.H.e1(r120.E, true);
        bh6.a r121 = this.f254874g;
        if (r121 == null) goto L52;
        r121.d();
    L52:
        this.f254875h = true;
        this.f254876i.onNext(Boolean.TRUE);
        return;
    L15:
        r105 = "";
        goto L16
    }

    public a(bn0.b r100, yz0.g r101, hd0.b r102, j r103, fc6.a r104, jb6.a r105, f r106) {
        Intrinsics.checkNotNullParameter(r100, "multiLinkRoomScope");
        Intrinsics.checkNotNullParameter(r101, "roomDataService");
        Intrinsics.checkNotNullParameter(r102, "linkPlayerStateKt");
        Intrinsics.checkNotNullParameter(r103, "interactServiceKt");
        Intrinsics.checkNotNullParameter(r104, "linkServiceHostService");
        Intrinsics.checkNotNullParameter(r105, "linkServiceScopeService");
        Intrinsics.checkNotNullParameter(r106, "hostService");
        this.f254877j = r100;
        this.f254878k = r101;
        this.f254879l = r102;
        this.f254880m = r103;
        this.f254881n = r104;
        this.f254882o = r105;
        this.f254883p = r106;
        int r107 = c.f267509a;
        this.f254876i = BehaviorSubject.create();
    }
}
