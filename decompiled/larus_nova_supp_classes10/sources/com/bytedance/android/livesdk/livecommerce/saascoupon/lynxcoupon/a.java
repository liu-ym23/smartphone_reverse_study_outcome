package com.bytedance.android.livesdk.livecommerce.saascoupon.lynxcoupon;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import bl2.g;
import com.bytedance.android.ec.common.api.card.CardType;
import com.bytedance.android.ec.common.api.card.ExternalCardPriority;
import com.bytedance.android.ec.common.api.card.ExternalCardStatus;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.livesdk.livecommerce.room.widgets.anim.BottomRightAnimController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.BottomRightCardManager;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import el2.k;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.Job;
import org.json.JSONArray;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements ef.b {
    public static final /* synthetic */ int s = 0;
    public Job a;
    public Long b;
    public l c;
    public final FrameLayout d;
    public ExternalCardStatus e;
    public boolean f;
    public boolean g;
    public final Context h;
    public final g i;
    public final el.b j;
    public final String k;
    public final ff.a l;
    public final ef.c m;
    public final k n;
    public final gf.a o;
    public final LiveRoomParams p;
    public final boolean q;
    public final ef.a r;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.saascoupon.lynxcoupon.a$a, reason: collision with other inner class name */
    public static final class C0124a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void a() {
            dm.a.a("LynxCardController").i("[scheduled][ExternalCard] card on scheduled, create card now.");
            this.a.m.getRootView().removeView(this.a.d);
            if (this.a.e.compareTo(ExternalCardStatus.PENDING) <= 0) goto L5;
            dm.a.a("LynxCardController").w("[scheduled][ExternalCard] create card but card status is displaying, error status.", null);
            return;
        L5:
            a r1 = this.a;
            BottomRightCardManager.b r2 = r1.m.getRootView();
            dm.a.a("LynxCardController").a("[create][ExternalCard] createLynxCouponPopup");
            r1.e = ExternalCardStatus.SCHEDULED;
            String r4 = r1.j.b();
            if (r4 == null) goto L13;
            r1.e = ExternalCardStatus.LOADING;
            Context r3 = r1.h;
            String r0 = r1.j.a();
            LinkedHashMap r5 = new LinkedHashMap();
            Map r6 = com.bytedance.android.shopping.extensions.k.z(r0);
            if (r6 == null) goto L10;
            r5.put("render_info", r6);
        L10:
            r5.put("request_id", r1.k);
            r5.put("enter_from", r1.i.a);
            r5.put("room_id", r1.i.d);
            r5.put("anchor_open_id", r1.i.e);
            r5.put("ad_info", MapsKt.mapOf(new Pair[]{TuplesKt.to("reqid", r1.i.f), TuplesKt.to("token", r1.i.g), TuplesKt.to("cid", String.valueOf(r1.i.h))}));
            r5.put("enter_timestamp", r1.n.b(r1.i.d));
            r1.c = ECLiveHybridUtil.b(r3, r4, r5, r1.d, new com.bytedance.android.livesdk.livecommerce.saascoupon.lynxcoupon.c(r4, r1, r2), null, null, false, null, null, false, 4064);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void b() {
        this.r.c(CardType.COUPON_CARD, new LynxCardController$cancelExternalCard$1(this));
    }

    public final void c() {
        ef.a r0 = this.r;
        Integer r2 = this.j.d();
        int r3 = 1;
        if (r2 != null) goto L6;
    L8:
        if (r2 != null) goto L11;
    L13:
        ExternalCardPriority r4 = ExternalCardPriority.EXPLAIN_CARD_HIGH_PRIORITY;
    L14:
        int r5 = com.bytedance.android.livesdk.livecommerce.saascoupon.lynxcoupon.b.a[r4.ordinal()];
        if (r5 != 1) goto L17;
        dm.a.a("LynxCardController").i("Init lynx card, explain card showing, explain > external");
    L22:
        r0.l(new ef.d(r3, CardType.COUPON_CARD, new b(this), new c(this)));
        return;
    L17:
        if (r5 != 2) goto L20;
        dm.a.a("LynxCardController").i("Init lynx card, explain card showing, external > explain");
        r3 = 20;
        goto L22
    L20:
        throw new NoWhenBranchMatchedException();
    L11:
        if (r2.intValue() != 1) goto L13;
        r4 = ExternalCardPriority.EXTERNAL_CARD_HIGH_PRIORITY;
        goto L14
    L6:
        if (r2.intValue() != 0) goto L8;
        r4 = ExternalCardPriority.EXPLAIN_CARD_HIGH_PRIORITY;
        goto L14
    }

    public final void a(boolean r20) {
        dm.a.a("LynxCardController").i("[destroy][ExternalCard] card destroyed");
        if (this.g == true) goto L41;
        if (r20 == true) goto L10;
        if (this.e.getStatusCode() < ExternalCardStatus.ANIM_SHOWING.getStatusCode()) goto L41;
        if (this.e.getStatusCode() >= ExternalCardStatus.FINISHED.getStatusCode()) goto L41;
    L10:
        if (this.q == false) goto L41;
        this.g = true;
        if (this.p == null) goto L41;
        JSONObject r0 = com.bytedance.android.shopping.extensions.k.w(this.j.a());     // Catch: Exception -> L39
        if (r0 == null) goto L19;
        JSONArray r1 = JSONObjectProtectorUtils.getJSONArray(r0, "coupon_card");     // Catch: Exception -> L39
        if (r1 == null) goto L19;
        JSONObject r2 = JSONArrayProtectorUtils.getJSONObject(r1, 0);     // Catch: Exception -> L39
    L20:
        if (r0 == null) goto L22;
        JSONObject r4 = JSONObjectProtectorUtils.getJSONObject(r0, "log_data");     // Catch: Exception -> L39
    L23:
        r r3 = r.a;     // Catch: Exception -> L39
        long r11 = 0;
        if (r3.a() != 0) goto L26;
        String r5 = "nologin";
    L30:
        String r6 = r5;
        long r7 = System.currentTimeMillis();     // Catch: Exception -> L39
        Long r8 = this.b;     // Catch: Exception -> L39
        if (r8 == null) goto L33;
        r11 = r8.longValue();     // Catch: Exception -> L39
    L33:
        long r13 = r7 - r11;     // Catch: Exception -> L39
        Long r9 = this.j.c();     // Catch: Exception -> L39
        if (r9 == null) goto L36;
        long r10 = r9.longValue();     // Catch: Exception -> L39
    L37:
        oh.a.a(new d(r2, r6, r4, RangesKt.coerceIn(r13, 0, r10), this));     // Catch: Exception -> L39
        goto L41
    L36:
        r10 = 10000;
        goto L37
    L26:
        if (r3.isLogin() == false) goto L28;
        r5 = "login_auth";
        goto L30
    L28:
        r5 = "login_no_auth";
        goto L30
    L22:
        r4 = null;
    L19:
        r2 = null;
    L39:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L41:
        this.e = ExternalCardStatus.FINISHED;
        this.m.getRootView().removeView(this.d);
        this.m.a();
        Job r12 = this.a;
        if (r12 == null) goto L44;
        Job.DefaultImpls.cancel$default(r12, null, 1, null);
    L44:
        l r14 = this.c;
        if (r14 == null) goto L50;
        r14.release();
        return;
    }

    public static void d(final a r8, View r9, final Function0 r10) {
        r8.getClass();
        dm.a.a("LynxCardController").a("[anim][ExternalCard] hideCardAnim");
        final Function0 r0 = null;
        r8.l.b(r9, LynxCardController$hideCardAnim$1.INSTANCE, new LynxCardController$hideCardAnim$2(r8, r0), new LynxCardController$hideCardAnim$3(r8, r10), null);
    }

    public a(Context r2, g r3, el.b r4, String r5, BottomRightAnimController r6, com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.b r7, k r8, gf.a r9, LiveRoomParams r10, boolean r11, ef.a r12) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "requestParams");
        Intrinsics.checkNotNullParameter(r4, "lynxCouponPopupModel");
        Intrinsics.checkNotNullParameter(r6, "animController");
        Intrinsics.checkNotNullParameter(r7, "cardViewProvider");
        Intrinsics.checkNotNullParameter(r8, "liveService");
        Intrinsics.checkNotNullParameter(r9, "fromType");
        Intrinsics.checkNotNullParameter(r12, "cardManager");
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.l = r6;
        this.m = r7;
        this.n = r8;
        this.o = r9;
        this.p = r10;
        this.q = r11;
        this.r = r12;
        FrameLayout r13 = new FrameLayout(r2);
        FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(-2, -2);
        r14.gravity = 80;
        Unit r15 = Unit.INSTANCE;
        r13.setLayoutParams(r14);
        this.d = r13;
        this.e = ExternalCardStatus.UNINITIALIZED;
    }
}
