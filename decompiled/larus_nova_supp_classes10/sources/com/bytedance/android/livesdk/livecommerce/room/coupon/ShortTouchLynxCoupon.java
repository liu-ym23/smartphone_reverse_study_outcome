package com.bytedance.android.livesdk.livecommerce.room.coupon;

import ah.i;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.adapter.api.handler.viewinterface.sti.IECExternalEntryEvent;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.ECLiveEntranceMonitor;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.livecommerce.event.e1;
import com.bytedance.android.livesdk.livecommerce.event.j;
import com.bytedance.android.livesdk.livecommerce.model.ECV2CouponInfo;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.controller.y;
import com.bytedance.android.livesdk.livecommerce.room.model.ShortTouchCouponMsgEvent;
import com.bytedance.android.livesdk.livecommerce.room.quick.LiveRoomLifecycleOwner;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContextContainer;
import com.bytedance.android.livesdk.livecommerce.room.utils.json.JSONDslUtilKt;
import com.bytedance.android.livesdk.livecommerce.room.widgets.coupon.CustomIconTemplate;
import com.bytedance.android.livesdk.livecommerce.room.widgets.coupon.SquircleIconContent;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.m0;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONObject;
import si2.z;
import ti.k;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0002\u0015\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\rH\u0007J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u000fH\u0007J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0011H\u0007J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0013H\u0007¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/coupon/ShortTouchLynxCoupon;", "Lyd/b;", "Lcom/bytedance/android/livesdk/livecommerce/room/coupon/ShortTouchLynxCoupon$b;", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/y;", "Landroidx/lifecycle/LifecycleObserver;", "", "onLifeCycleDestroy", "Lah/f;", BaseCoreViewModel.CORE_TAG_STATE, "moveToState", "Lcom/bytedance/android/livesdk/livecommerce/room/model/ShortTouchCouponMsgEvent;", "event", "updateShortTouchCouponMsg", "Lcom/bytedance/android/livesdk/livecommerce/event/j;", "afterAutoApplyCoupon", "Lah/g;", "registerTempShortTouchEvent", "Lah/a;", "changeTempWidthEvent", "Lah/i;", "showNormalStateEvent", "a", "b", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShortTouchLynxCoupon extends yd.b<b> implements y, LifecycleObserver {
    public CustomIconTemplate f;
    public l g;
    public l h;
    public FrameLayout i;
    public int j;
    public boolean k;
    public String l;
    public boolean m;
    public JSONObject n;
    public boolean o;
    public final Handler p;
    public final b q;
    public final int r;
    public final Context s;
    public final ECContext t;
    public final String u;
    public final RoomContextController v;

    public static final class a {
    }

    public static abstract class b {

        public static final class a extends b {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.coupon.ShortTouchLynxCoupon$b$b, reason: collision with other inner class name */
        public static final class C0101b extends b {
            public static final C0101b a = null;

            static {
                a = new C0101b();
            }

            public C0101b() {
            }
        }

        public b() {
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ShortTouchLynxCoupon a;
        public final /* synthetic */ ah.a b;

        public c(ShortTouchLynxCoupon r1, ah.a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.changeTempWidthEvent(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements k {
        public d() {
        }

        public final void b() {
            Intrinsics.checkNotNullParameter("", "errorMessage");
            Intrinsics.checkNotNullParameter("", "errorMessage");
        }

        public final void onFirstScreen(View r2) {
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            Intrinsics.checkNotNullParameter(r2, "lynxView");
        }

        public final void onLoadSuccess(View r2) {
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            CouponEventDispatcher.a("lynx entry load success");
            new e1().k();
        }

        public final void onRuntimeReady(View r2) {
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            Intrinsics.checkNotNullParameter(r2, "lynxView");
        }

        public final void g(View r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "view");
            Intrinsics.checkNotNullParameter(r1, "view");
        }

        public final void onLoadFailed(View r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            boolean r4 = CouponEventDispatcher.a;
            CouponEventDispatcher.a("lynx entry load fail: " + r3);
            new e1(1, r3).k();
        }

        public final void onPageStart(View r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "lynxView");
            Intrinsics.checkNotNullParameter(r1, "lynxView");
        }

        public final void s(View r1, String r2, String r3) {
            Intrinsics.checkNotNullParameter(r1, "view");
            Intrinsics.checkNotNullParameter(r1, "view");
            boolean r4 = CouponEventDispatcher.a;
            CouponEventDispatcher.a("lynx entry load error: " + r3);
            new e1(2, r3).k();
        }
    }

    public static final class e implements k {
        public e() {
        }

        public final void b() {
            Intrinsics.checkNotNullParameter("", "errorMessage");
            Intrinsics.checkNotNullParameter("", "errorMessage");
        }

        public final void onFirstScreen(View r2) {
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            Intrinsics.checkNotNullParameter(r2, "lynxView");
        }

        public final void onLoadSuccess(View r2) {
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            CouponEventDispatcher.a("lynx entry load success");
            new e1().k();
        }

        public final void onRuntimeReady(View r2) {
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            Intrinsics.checkNotNullParameter(r2, "lynxView");
        }

        public final void g(View r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "view");
            Intrinsics.checkNotNullParameter(r1, "view");
        }

        public final void onLoadFailed(View r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            boolean r4 = CouponEventDispatcher.a;
            CouponEventDispatcher.a("lynx entry load fail: " + r3);
            new e1(1, r3).k();
        }

        public final void onPageStart(View r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "lynxView");
            Intrinsics.checkNotNullParameter(r1, "lynxView");
        }

        public final void s(View r1, String r2, String r3) {
            Intrinsics.checkNotNullParameter(r1, "view");
            Intrinsics.checkNotNullParameter(r1, "view");
            boolean r4 = CouponEventDispatcher.a;
            CouponEventDispatcher.a("lynx entry load error: " + r3);
            new e1(2, r3).k();
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ ShortTouchLynxCoupon a;
        public final /* synthetic */ ah.g b;

        public f(ShortTouchLynxCoupon r1, ah.g r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.registerTempShortTouchEvent(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ ShortTouchLynxCoupon a;
        public final /* synthetic */ i b;

        public g(ShortTouchLynxCoupon r1, i r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.showNormalStateEvent(this.b);     // Catch: Throwable -> L4
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

    public final void dispose() {
    }

    public final boolean isDisposed() {
        return false;
    }

    public final void m() {
        l r0 = this.g;
        if (r0 == null) goto L6;
        r0.sendJsEvent("onClick", new JSONObject());
        return;
    }

    public final void onCreate() {
        ECLiveEntranceMonitor.trace$default("onCreate", "ShortTouchLynxCoupon", false, 4, null);
        EventBus.getDefault().register(this);
        ControllerExtensionsKt.c(this.v, (String) this.t.getRoomId().getValue()).A().p("LiveMarketingMessage", this);
        ((LiveRoomLifecycleOwner) this.t.getLifecycleOwner().getValue()).a.addObserver(this);
        HashMap r1 = new HashMap();
        r1.put("app_name", "douyin");
        r1.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r1.put("enter_from", "live");
        r1.put("_param_live_platform", "live");
        r1.put("num", Integer.valueOf(this.j));
        r1.put("isD3", Boolean.valueOf(((Bundle) this.t.getExtras().getValue()).getBoolean("EXTRA_IS_D_ROOM")));
        r1.put("roomID", this.t.getRoomId().getValue());
        r1.put("UID", this.t.getAnchorId().getValue());
        r1.put("secUID", this.t.getAnchorSecId().getValue());
        r1.put("ecLiveVersion", this.t.getLiveSDKVersion().getValue());
        r1.put("preViewCouponID", this.u);
        FrameLayout r2 = new FrameLayout(this.s);
        r2.setLayoutParams(new ViewGroup.LayoutParams(UtilityKotlinExtentionsKt.d(88), UtilityKotlinExtentionsKt.d(96)));
        Unit r4 = Unit.INSTANCE;
        this.i = r2;
        Context r6 = this.s;
        String r3 = EComABUtils.getShortTouchCouponLynxConfig().b();
        if (r3 != null) goto L5;
        r3 = com.bytedance.android.livesdk.livecommerce.room.coupon.f.c;
    L5:
        this.h = ECLiveHybridUtil.b(r6, r3, r1, this.i, new d(), null, ((LiveRoomLifecycleOwner) this.t.getLifecycleOwner().getValue()).a, false, null, null, false, 4000);
        FrameLayout r5 = new FrameLayout(this.s);
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Context r7 = this.s;
        String r8 = EComABUtils.getShortTouchCouponLynxConfig().c();
        if (r8 != null) goto L8;
        r8 = com.bytedance.android.livesdk.livecommerce.room.coupon.f.b;
    L8:
        this.g = ECLiveHybridUtil.b(r7, r8, r1, r5, new e(), null, ((LiveRoomLifecycleOwner) this.t.getLifecycleOwner().getValue()).a, false, null, null, false, 4000);
        CustomIconTemplate r9 = new CustomIconTemplate(this.s, null, 6, 0);
        r9.setContentView(r5);
        this.f = r9;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onLifeCycleDestroy() {
        int r0 = ECSdk.a;
        pi.b r1 = (pi.b) ECSdk.a(pi.b.class);
        if (r1 == null) goto L5;
        r1.monitorEvent("livecommerce_lynx_coupon_on_destroy", null, null, null);
    L5:
        onDestroy();
    }

    public final void q() {
        String r1 = null;
        if (this.o == false) goto L7;
        CustomIconTemplate r0 = this.f;
        if (r0 == null) goto L17;
        r0.setSuperscript(null);
        return;
    L17:
        return;
    L7:
        CustomIconTemplate r2 = this.f;
        if (r2 == null) goto L19;
        int r3 = this.j;
        if (r3 <= 10) goto L13;
        r1 = "10+";
    L15:
        r2.setSuperscript(r1);
        return;
    L13:
        if (r3 <= 1) goto L15;
        r1 = String.valueOf(r3);
        goto L15
    }

    public final void onDestroy() {
        EventBus.getDefault().unregister(this);
        ((LiveRoomLifecycleOwner) this.t.getLifecycleOwner().getValue()).rK().removeObserver(this);
        l r0 = this.g;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        l r1 = this.h;
        if (r1 == null) goto L8;
        r1.release();
    L8:
        this.h = null;
        this.g = null;
        this.f = null;
        this.i = null;
    }

    public final Object e() {
        return this.q;
    }

    public final int j() {
        return this.r;
    }

    @Subscribe
    public final void afterAutoApplyCoupon(j r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        CouponEventDispatcher.a("afterAutoApplyCoupon");
        ECLiveHybridUtil.f("ecom.coupon.setApplyCouponResp", JSONDslUtilKt.a(new com.bytedance.android.livesdk.livecommerce.room.utils.json.a[]{JSONDslUtilKt.c("roomID", (String) this.t.getRoomId().getValue()), JSONDslUtilKt.d("couponInfo", r4.a)}));
    }

    @Subscribe
    public final void changeTempWidthEvent(ah.a r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        CouponEventDispatcher.a("changeTempWidthEvent");
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L6;
        this.p.post(new c(this, r3));
        return;
    L6:
        CustomIconTemplate r4 = this.f;
        if (r4 == null) goto L11;
        SquircleIconContent r5 = r4.getContentContainer();
        if (r5 == null) goto L11;
        r5.setTempShortTouch(true);
    L11:
        this.o = true;
        q();
        Function0 r6 = ((yd.b) this).d;
        if (r6 == null) goto L15;
        Unit r7 = (Unit) r6.invoke();
        return;
    }

    public final CustomIconTemplate k(Object r4) {
        b r5 = (b) r4;
        Intrinsics.checkNotNullParameter(r5, BaseCoreViewModel.CORE_TAG_STATE);
        String r1 = null;
        if (((Boolean) this.t.isPortrait().getValue()).booleanValue() == true) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r5, b.a.a) == false) goto L9;
        return null;
    L9:
        if (Intrinsics.areEqual(r5, b.C0101b.a) == false) goto L27;
        CustomIconTemplate r6 = this.f;
        if (r6 == null) goto L28;
        Boolean r0 = Boolean.valueOf(this.m);
        if (r0.booleanValue() == true) goto L16;
        r0 = null;
    L16:
        if (r0 == null) goto L25;
        r0.booleanValue();
        int r2 = this.j;
        if (r2 <= 10) goto L21;
        r1 = "10+";
    L23:
        r6.setSuperscript(r1);
        goto L25
    L21:
        if (r2 <= 1) goto L23;
        r1 = String.valueOf(r2);
    L25:
        return r6;
    L28:
        return null;
    L27:
        throw new NoWhenBranchMatchedException();
    }

    @Subscribe
    public final void moveToState(ah.f r4) {
        Intrinsics.checkNotNullParameter(r4, BaseCoreViewModel.CORE_TAG_STATE);
        this.n = r4.g;
        String r0 = r4.a;
        int r1 = r0.hashCode();
        if (r1 == 2217282) goto L25;
        if (r1 == 2544381) goto L8;
        return;
    L8:
        if (r0.equals("SHOW") == false) goto L32;
        this.j = r4.b;
        this.m = r4.f;
        this.k = r4.c;
        this.l = r4.d;
        int r2 = ECContextContainer.b;
        ECContext r3 = ECContextContainer.a.b();
        if (r3 == null) goto L15;
        m<Boolean> r5 = r3.getHasCouponEntryShown();
        if (r5 == null) goto L15;
        r5.setValue(Boolean.TRUE);
    L15:
        if (r4.e == false) goto L18;
        l(b.a.a);
        l(b.C0101b.a);
        return;
    L18:
        if (this.m == false) goto L23;
        q();
        Function0 r6 = ((yd.b) this).a;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("activateIcon");
    L22:
        r6.invoke();
        return;
    L23:
        p(false);
        return;
    L32:
        return;
    L25:
        if (r0.equals("HIDE") == false) goto L36;
        this.j = r4.b;
        l(b.a.a);
        int r7 = ECContextContainer.b;
        ECContext r8 = ECContextContainer.a.b();
        if (r8 == null) goto L37;
        m<Boolean> r9 = r8.getHasCouponEntryShown();
        if (r9 == null) goto L38;
        r9.setValue(Boolean.FALSE);
        return;
    L38:
        return;
    L37:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.y
    public final void onReceive(sg2.a r5) {
        if ((r5 instanceof z) == true) goto L5;
        sg2.a r0 = null;
    L6:
        z r1 = (z) r0;
        if (r1 == null) goto L25;
        ECV2CouponInfo r2 = r1.couponInfo;
        if (r2 == null) goto L26;
        JSONObject r3 = new JSONObject();
        r3.put("msg_type", ((z) r5).msgType);
        r3.put("meta_id", r2.metaId);
        r3.put("server_time", r2.serverTime);
        r3.put("countdown", r2.countDown);
        r3.put("activity_json_str", r2.activity);
        r3.put("coupon_type", r2.couponType);
        r3.put("meta_id_str", r2.metaIdString);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L13
        int r4 = m0.a;     // Catch: Throwable -> L13
        Result.constructor-impl(r3.put("activity_info", tv5.a.a(m0.a.b, r2.activityData)));     // Catch: Throwable -> L13
    L21:
        int r7 = m0.a;     // Catch: Throwable -> L17
        Result.constructor-impl(r3.put("coupon_meta", tv5.a.a(m0.a.b, r2.couponMeta)));     // Catch: Throwable -> L17
    L19:
        Unit r8 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ecom.coupon.setMessage", r3);
        return;
    L17:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L13:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L26:
        return;
    L25:
        return;
    L5:
        r0 = r5;
        goto L6
    }

    public final void p(boolean r4) {
        com.bytedance.android.livesdk.livecommerce.room.utils.json.a[] r0 = new com.bytedance.android.livesdk.livecommerce.room.utils.json.a[6];
        r0[0] = JSONDslUtilKt.b("num", this.j);
        r0[1] = JSONDslUtilKt.e("animate", r4);
        r0[2] = JSONDslUtilKt.e("isD3", this.k);
        r0[3] = JSONDslUtilKt.c("couponShowType", this.l);
        r0[4] = JSONDslUtilKt.e("useNative", this.m);
        JSONObject r5 = this.n;
        if (r5 != null) goto L5;
        r5 = new JSONObject();
    L5:
        r0[5] = JSONDslUtilKt.d("logData", r5);
        ECLiveHybridUtil.f("ecom.coupon.refresh", JSONDslUtilKt.a(r0));
    }

    @Subscribe
    public final void registerTempShortTouchEvent(ah.g r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        CouponEventDispatcher.a("registerTempShortTouchEvent start");
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L6;
        this.p.post(new f(this, r6));
        return;
    L6:
        int r0 = r6.a.optInt("strategy");
        long r2 = r6.a.optLong("showTime");
        CouponEventDispatcher.a("registerTempShortTouchEvent strategy = " + r0 + " showTime = " + r2);
        Function2 r7 = ((yd.b) this).c;
        if (r7 == null) goto L11;
        Integer r8 = (Integer) r7.invoke(Integer.valueOf(r0), Long.valueOf(r2));
        if (r8 == null) goto L11;
        int r9 = r8.intValue();
    L12:
        ECLiveHybridUtil.f("ecom.coupon.registerTempShortTouch.result", JSONDslUtilKt.a(new com.bytedance.android.livesdk.livecommerce.room.utils.json.a[]{JSONDslUtilKt.b("result", r9)}));
        return;
    L11:
        r9 = -1;
        goto L12
    }

    @Subscribe
    public final void showNormalStateEvent(i r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        CouponEventDispatcher.a("showNormalStateEvent");
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L6;
        this.p.post(new g(this, r3));
        return;
    L6:
        CustomIconTemplate r4 = this.f;
        if (r4 == null) goto L11;
        SquircleIconContent r5 = r4.getContentContainer();
        if (r5 == null) goto L11;
        r5.setTempShortTouch(false);
    L11:
        this.o = false;
        q();
        Function0 r6 = ((yd.b) this).e;
        if (r6 == null) goto L15;
        Unit r7 = (Unit) r6.invoke();
        return;
    }

    @Subscribe
    public final void updateShortTouchCouponMsg(ShortTouchCouponMsgEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if (Intrinsics.areEqual(r3.getRoomId(), (String) this.t.getRoomId().getValue()) == false) goto L10;
        int r0 = ECContextContainer.b;
        ECContext r1 = ECContextContainer.a.b();
        if (r1 == null) goto L11;
        n<ShortTouchCouponMsgEvent> r2 = r1.getShortTouchCouponInfo();
        if (r2 == null) goto L12;
        r2.setValue(r3);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void b(Object r1, Object r2) {
        b r3 = (b) r1;
        Intrinsics.checkNotNullParameter((b) r2, "curState");
    }

    public final yd.a d(Object r1, Object r2) {
        b r3 = (b) r1;
        b r4 = (b) r2;
        Intrinsics.checkNotNullParameter(r3, BaseCoreViewModel.CORE_TAG_STATE);
        if (Intrinsics.areEqual(r3, b.a.a) == false) goto L6;
    L10:
        return null;
    L6:
        if (Intrinsics.areEqual(r3, b.C0101b.a) == false) goto L13;
        FrameLayout r5 = this.i;
        if (r5 == null) goto L10;
        return new yd.a(r5);
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final void n(View r2, IECExternalEntryEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "entryView");
        Intrinsics.checkNotNullParameter(r3, "event");
        int r4 = com.bytedance.android.livesdk.livecommerce.room.coupon.g.a[r3.ordinal()];
        if (r4 != 1) goto L5;
    L10:
        p(true);
        return;
    L5:
        if (r4 == 2) goto L10;
        if (r4 != 3) goto L13;
        ECLiveHybridUtil.f("ecom.coupon.prepareAnimation", JSONDslUtilKt.a(new com.bytedance.android.livesdk.livecommerce.room.utils.json.a[0]));
        return;
    }

    public ShortTouchLynxCoupon(b.a r2, Context r3, ECContext r4, String r5, RoomContextController r6) {
        Intrinsics.checkNotNullParameter(r2, "initialState");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "ecContext");
        Intrinsics.checkNotNullParameter(r5, "previewCouponId");
        Intrinsics.checkNotNullParameter(r6, "roomContextController");
        this.q = r2;
        this.r = 8;
        this.s = r3;
        this.t = r4;
        this.u = r5;
        this.v = r6;
        this.l = "auto";
        this.p = new Handler(Looper.getMainLooper());
        CouponEventDispatcher.c();
    }
}
