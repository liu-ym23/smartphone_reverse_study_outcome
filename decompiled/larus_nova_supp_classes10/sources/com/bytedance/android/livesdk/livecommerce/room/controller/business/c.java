package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import android.content.Context;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController$roomResources$1;
import com.bytedance.android.livesdk.livecommerce.room.controller.c0;
import com.bytedance.android.livesdk.livecommerce.room.coupon.CouponGrowProvider;
import com.bytedance.android.livesdk.livecommerce.room.coupon.ReferralCoupon;
import com.bytedance.android.livesdk.livecommerce.room.coupon.ShortTouchLynxCoupon;
import com.bytedance.android.livesdk.livecommerce.room.coupon.ShortTouchLynxCouponV2;
import com.bytedance.android.livesdk.livecommerce.room.model.ShortTouchCouponMsgEvent;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContextContainer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONObject;
import vi2.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c extends c0 {
    public static final /* synthetic */ int i = 0;
    public final sg2.h c;
    public boolean d;
    public boolean e;
    public ih2.d f;
    public ih2.h g;
    public el2.n h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0
    public final void F() {
        sg2.h r0 = this.c;
        r0.a = 1;
        r0.d = null;
        WeakReference<v0<xi2.p>> r1 = r0.b;
        if (r1 == null) goto L5;
        r1.clear();
    L5:
        WeakReference<v0<xi2.r>> r2 = r0.c;
        if (r2 == null) goto L9;
        r2.clear();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0
    public final void n() {
        el2.n r0 = this.h;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        this.h = null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onDestroyView() {
        CouponGrowProvider.l.getClass();     // Catch: Throwable -> L4
        CouponGrowProvider.f.f(B(), true);     // Catch: Throwable -> L4
        return;
    }

    public final String H() {
        if (t() == false) goto L9;
        String r0 = p().get("preview_coupon_id");
        if (r0 != null) goto L8;
        return "";
    L8:
        return r0;
    L9:
        return "";
    }

    public final void I() {
        ECContext r3 = o();
        ShortTouchLynxCouponV2 r7 = null;
        if (r3 == null) goto L5;
        H();
        ShortTouchLynxCoupon r8 = new ShortTouchLynxCoupon(ShortTouchLynxCoupon.b.a.a, th.a.e(m(), true), r3, H(), A().m);
    L6:
        if (r8 == null) goto L8;
        E().H(r8);
    L8:
        ECContext r12 = o();
        if (r12 == null) goto L11;
        H();
        r7 = new ShortTouchLynxCouponV2(ShortTouchLynxCouponV2.b.a.a, th.a.e(m(), true), r12, H(), A().m);
    L11:
        if (r7 == null) goto L14;
        E().N(r7);
        return;
    L14:
        return;
    L5:
        r8 = null;
        goto L6
    }

    public final void J() {
        if (hh2.f.d() == false) goto L12;
        CouponGrowProvider.Companion r0 = CouponGrowProvider.l;
        Context r1 = m();
        Map<String, String> r2 = p();
        String r3 = B();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "ecomParams");
        Intrinsics.checkNotNullParameter(r3, "roomId");
        CouponGrowProvider.Companion.a("oacfgs");
        int r4 = RoomContextController.h;
        if (RoomContextController.a.a().M() == true) goto L7;
        CouponGrowProvider.Companion.a("noln");
        return;
    L7:
        HashMap r5 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        JSONObject r6 = com.bytedance.android.ec.core.hybrid.utils.j.i(r2.get("enter_request"));
        boolean r7 = CouponGrowProvider.Companion.e(r6);
        if (r7 == true) goto L10;
        CouponGrowProvider.Companion.g(r1, r6, r3, false, null);
    L10:
        CouponGrowProvider.Companion.a("hgc: " + r7);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onDestroy() {
        super.onDestroy();
        s0.e(this);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onExitRoom() {
        super.onExitRoom();
        s0.e(this);
        this.d = false;
        this.e = false;
        CouponGrowProvider.l.getClass();     // Catch: Throwable -> L5
        CouponGrowProvider.f.f(B(), true);     // Catch: Throwable -> L5
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onWidgetLoadFinished() {
        F();
        if (s() == false) goto L5;
    L7:
        Context r0 = m();
        com.bytedance.android.ec.adapter.api.state.a r1 = C();
        if (this.e == true) goto L21;
        this.e = true;
    L14:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L21
    L11:
        if (s() == true) goto L21;
        ReferralCoupon.b(r1, r0, false);     // Catch: Exception -> L14
    L21:
        CouponGrowProvider.l.getClass();     // Catch: Exception -> L18
        CouponGrowProvider r2 = CouponGrowProvider.f;     // Catch: Exception -> L18
        Context r3 = m();     // Catch: Exception -> L18
        String r4 = B();     // Catch: Exception -> L18
        HashMap r5 = com.bytedance.android.ec.core.hybrid.utils.j.a;     // Catch: Exception -> L18
        r2.e(r3, r4, com.bytedance.android.ec.core.hybrid.utils.j.i(p().get("enter_request")), true, A().r);     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L5:
        if (t() == false) goto L7;
        new com.bytedance.android.livesdk.livecommerce.room.coupon.a(C(), m(), this.b.d()).b();
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onCreate() {
        s0.c(this);
    }

    public c(RealRoomController$roomResources$1 r2) {
        Intrinsics.checkNotNullParameter(r2, "roomResources");
        super(r2);
        this.c = sg2.h.a.a;
    }

    @Subscribe
    public final void updateShortTouchCouponMsg(ShortTouchCouponMsgEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if (w() == true) goto L6;
        return;
    L6:
        if (ECLiveABUtils.INSTANCE.getECOM_DISABLE_LEGACY_LOAD_COUPON_LOGIC() == true) goto L8;
    L10:
        boolean r0 = false;
    L11:
        if (r0 == true) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(r3.getRoomId(), (String) o().getRoomId().getValue()) == false) goto L21;
        int r1 = ECContextContainer.b;
        ECContext r2 = ECContextContainer.a.b();
        if (r2 == null) goto L22;
        com.bytedance.live.datacontext.n<ShortTouchCouponMsgEvent> r4 = r2.getShortTouchCouponInfo();
        if (r4 == null) goto L23;
        r4.setValue(r3);
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L8:
        if (ECAppInfoService.h() == false) goto L10;
        r0 = true;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void c(Context r3, com.bytedance.android.ec.adapter.api.state.a r4) {
        super.c(r3, r4);
        s0.e(this);
        boolean r0 = true;
        if (r4 == null) goto L35;
        if (r3 == null) goto L35;
        if (this.e == true) goto L35;
        this.e = true;
    L12:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L35
    L9:
        if (s() == true) goto L35;
        ReferralCoupon.b(r4, r3, true);     // Catch: Exception -> L12
    L35:
        CouponGrowProvider.l.getClass();     // Catch: Throwable -> L34
        CouponGrowProvider r5 = CouponGrowProvider.f;     // Catch: Throwable -> L34
        String r6 = B();     // Catch: Throwable -> L34
        r5.getClass();     // Catch: Throwable -> L34
        Intrinsics.checkNotNullParameter(r6, "roomId");     // Catch: Throwable -> L34
        CouponGrowProvider.k.remove(r6);     // Catch: Throwable -> L34
        r5.b.remove(r6);     // Catch: Throwable -> L34
        if (r5.c.length() > 0) goto L18;
        r0 = false;
    L18:
        if (r0 == true) goto L20;
    L22:
        ih2.d r7 = this.f;     // Catch: Throwable -> L34
        if (r7 != null) goto L39;
    L25:
        ih2.h r8 = this.g;     // Catch: Throwable -> L34
        if (r8 == null) goto L28;
        ih2.h.a(r8);     // Catch: Throwable -> L34
        goto L28
    L39:
        ih2.d.a(r7);     // Catch: Throwable -> L33
        goto L25
    L20:
        if (Intrinsics.areEqual(r5.c, r6) == false) goto L22;
        r5.b();     // Catch: Throwable -> L34
    L28:
        el2.n r9 = this.h;
        if (r9 == null) goto L31;
        r9.destroy();
    L31:
        this.h = null;
    }
}
