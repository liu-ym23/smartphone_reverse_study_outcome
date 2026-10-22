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
import com.bytedance.android.livesdkapi.room.handler.viewinterface.sti.IExternalEntryEvent;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.sti.IExternalEntryView;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.sti.IExternalIconModel;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.sti.IExternalIconTemplate;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONObject;
import si2.z;
import ti.k;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0002\u0015\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\rH\u0007J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u000fH\u0007J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0011H\u0007J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0013H\u0007¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/coupon/ShortTouchLynxCouponV2;", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/sti/IExternalIconModel;", "Lcom/bytedance/android/livesdk/livecommerce/room/coupon/ShortTouchLynxCouponV2$b;", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/y;", "Landroidx/lifecycle/LifecycleObserver;", "", "onLifeCycleDestroy", "Lah/f;", BaseCoreViewModel.CORE_TAG_STATE, "moveToState", "Lcom/bytedance/android/livesdk/livecommerce/room/model/ShortTouchCouponMsgEvent;", "event", "updateShortTouchCouponMsg", "Lcom/bytedance/android/livesdk/livecommerce/event/j;", "afterAutoApplyCoupon", "Lah/g;", "registerTempShortTouchEvent", "Lah/a;", "changeTempWidthEvent", "Lah/i;", "showNormalStateEvent", "a", "b", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShortTouchLynxCouponV2 extends IExternalIconModel<b> implements y, LifecycleObserver {
    public CustomIconTemplate a;
    public l b;
    public l c;
    public FrameLayout d;
    public int e;
    public boolean f;
    public String g;
    public boolean h;
    public JSONObject i;
    public boolean j;
    public final Handler k;
    public final b l;
    public final int m;
    public final Context n;
    public final ECContext o;
    public final String p;
    public final RoomContextController q;

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

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.coupon.ShortTouchLynxCouponV2$b$b, reason: collision with other inner class name */
        public static final class C0102b extends b {
            public static final C0102b a = null;

            static {
                a = new C0102b();
            }

            public C0102b() {
            }
        }

        public b() {
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ShortTouchLynxCouponV2 a;
        public final /* synthetic */ ah.a b;

        public c(ShortTouchLynxCouponV2 r1, ah.a r2) {
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
        public final /* synthetic */ ShortTouchLynxCouponV2 a;
        public final /* synthetic */ ah.g b;

        public f(ShortTouchLynxCouponV2 r1, ah.g r2) {
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
        public final /* synthetic */ ShortTouchLynxCouponV2 a;
        public final /* synthetic */ i b;

        public g(ShortTouchLynxCouponV2 r1, i r2) {
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

    public final void d() {
        String r1 = null;
        if (this.j == false) goto L7;
        CustomIconTemplate r0 = this.a;
        if (r0 == null) goto L17;
        r0.setSuperscript(null);
        return;
    L17:
        return;
    L7:
        CustomIconTemplate r2 = this.a;
        if (r2 == null) goto L19;
        int r3 = this.e;
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

    public final void onClick() {
        l r0 = this.b;
        if (r0 == null) goto L6;
        r0.sendJsEvent("onClick", new JSONObject());
        return;
    }

    public final void onCreate() {
        super.onCreate();
        ECLiveEntranceMonitor.trace$default("onCreate", "ShortTouchLynxCoupon", false, 4, null);
        EventBus.getDefault().register(this);
        ControllerExtensionsKt.c(this.q, (String) this.o.getRoomId().getValue()).A().p("LiveMarketingMessage", this);
        ((LiveRoomLifecycleOwner) this.o.getLifecycleOwner().getValue()).a.addObserver(this);
        HashMap r1 = new HashMap();
        r1.put("app_name", "douyin");
        r1.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r1.put("enter_from", "live");
        r1.put("_param_live_platform", "live");
        r1.put("num", Integer.valueOf(this.e));
        r1.put("isD3", Boolean.valueOf(((Bundle) this.o.getExtras().getValue()).getBoolean("EXTRA_IS_D_ROOM")));
        r1.put("roomID", this.o.getRoomId().getValue());
        r1.put("UID", this.o.getAnchorId().getValue());
        r1.put("secUID", this.o.getAnchorSecId().getValue());
        r1.put("ecLiveVersion", this.o.getLiveSDKVersion().getValue());
        r1.put("preViewCouponID", this.p);
        FrameLayout r2 = new FrameLayout(this.n);
        r2.setLayoutParams(new ViewGroup.LayoutParams(UtilityKotlinExtentionsKt.d(88), UtilityKotlinExtentionsKt.d(96)));
        Unit r4 = Unit.INSTANCE;
        this.d = r2;
        Context r6 = this.n;
        String r3 = EComABUtils.getShortTouchCouponLynxConfig().b();
        if (r3 != null) goto L5;
        r3 = com.bytedance.android.livesdk.livecommerce.room.coupon.f.c;
    L5:
        this.c = ECLiveHybridUtil.b(r6, r3, r1, this.d, new d(), null, ((LiveRoomLifecycleOwner) this.o.getLifecycleOwner().getValue()).a, false, null, null, false, 4000);
        FrameLayout r5 = new FrameLayout(this.n);
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Context r7 = this.n;
        String r8 = EComABUtils.getShortTouchCouponLynxConfig().c();
        if (r8 != null) goto L8;
        r8 = com.bytedance.android.livesdk.livecommerce.room.coupon.f.b;
    L8:
        this.b = ECLiveHybridUtil.b(r7, r8, r1, r5, new e(), null, ((LiveRoomLifecycleOwner) this.o.getLifecycleOwner().getValue()).a, false, null, null, false, 4000);
        CustomIconTemplate r9 = new CustomIconTemplate(this.n, null, 6, 0);
        r9.setContentView(r5);
        this.a = r9;
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

    public final void onDestroy() {
        EventBus.getDefault().unregister(this);
        ((LiveRoomLifecycleOwner) this.o.getLifecycleOwner().getValue()).rK().removeObserver(this);
        l r0 = this.b;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        l r1 = this.c;
        if (r1 == null) goto L8;
        r1.release();
    L8:
        this.c = null;
        this.b = null;
        this.a = null;
        this.d = null;
    }

    public final void onHideTempState() {
        super.onHideTempState();
        CouponEventDispatcher.a("onHideTempState");
        CustomIconTemplate r0 = this.a;
        if (r0 == null) goto L7;
        SquircleIconContent r1 = r0.getContentContainer();
        if (r1 == null) goto L7;
        r1.setTempShortTouch(false);
    L7:
        this.j = false;
        d();
        ECLiveHybridUtil.f("ecom.coupon.tempShortTouch.hide", JSONDslUtilKt.a(new com.bytedance.android.livesdk.livecommerce.room.utils.json.a[0]));
    }

    public final Object getInitialState() {
        return this.l;
    }

    public final int getTypeId() {
        return this.m;
    }

    @Subscribe
    public final void afterAutoApplyCoupon(j r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        CouponEventDispatcher.a("afterAutoApplyCoupon");
        ECLiveHybridUtil.f("ecom.coupon.setApplyCouponResp", JSONDslUtilKt.a(new com.bytedance.android.livesdk.livecommerce.room.utils.json.a[]{JSONDslUtilKt.c("roomID", (String) this.o.getRoomId().getValue()), JSONDslUtilKt.d("couponInfo", r4.a)}));
    }

    public final void b(boolean r4) {
        com.bytedance.android.livesdk.livecommerce.room.utils.json.a[] r0 = new com.bytedance.android.livesdk.livecommerce.room.utils.json.a[6];
        r0[0] = JSONDslUtilKt.b("num", this.e);
        r0[1] = JSONDslUtilKt.e("animate", r4);
        r0[2] = JSONDslUtilKt.e("isD3", this.f);
        r0[3] = JSONDslUtilKt.c("couponShowType", this.g);
        r0[4] = JSONDslUtilKt.e("useNative", this.h);
        JSONObject r5 = this.i;
        if (r5 != null) goto L5;
        r5 = new JSONObject();
    L5:
        r0[5] = JSONDslUtilKt.d("logData", r5);
        ECLiveHybridUtil.f("ecom.coupon.refresh", JSONDslUtilKt.a(r0));
    }

    @Subscribe
    public final void changeTempWidthEvent(ah.a r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        CouponEventDispatcher.a("changeTempWidthEvent");
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L6;
        this.k.post(new c(this, r3));
        return;
    L6:
        CustomIconTemplate r4 = this.a;
        if (r4 == null) goto L11;
        SquircleIconContent r5 = r4.getContentContainer();
        if (r5 == null) goto L11;
        r5.setTempShortTouch(true);
    L11:
        this.j = true;
        d();
        changeTempWidth();
    }

    public final IExternalIconTemplate getViewForState(Object r4) {
        b r5 = (b) r4;
        Intrinsics.checkNotNullParameter(r5, BaseCoreViewModel.CORE_TAG_STATE);
        String r1 = null;
        if (((Boolean) this.o.isPortrait().getValue()).booleanValue() == true) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r5, b.a.a) == false) goto L9;
        return null;
    L9:
        if (Intrinsics.areEqual(r5, b.C0102b.a) == false) goto L27;
        CustomIconTemplate r6 = this.a;
        if (r6 == null) goto L28;
        Boolean r0 = Boolean.valueOf(this.h);
        if (r0.booleanValue() == true) goto L16;
        r0 = null;
    L16:
        if (r0 == null) goto L25;
        r0.booleanValue();
        int r2 = this.e;
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
        this.i = r4.g;
        String r0 = r4.a;
        int r1 = r0.hashCode();
        if (r1 == 2217282) goto L22;
        if (r1 == 2544381) goto L8;
        return;
    L8:
        if (r0.equals("SHOW") == false) goto L29;
        this.e = r4.b;
        this.h = r4.f;
        this.f = r4.c;
        this.g = r4.d;
        int r2 = ECContextContainer.b;
        ECContext r3 = ECContextContainer.a.b();
        if (r3 == null) goto L15;
        m<Boolean> r5 = r3.getHasCouponEntryShown();
        if (r5 == null) goto L15;
        r5.setValue(Boolean.TRUE);
    L15:
        if (r4.e == false) goto L18;
        moveToState(b.a.a);
        moveToState(b.C0102b.a);
        return;
    L18:
        if (this.h == false) goto L20;
        d();
        activateIcon();
        return;
    L20:
        b(false);
        return;
    L29:
        return;
    L22:
        if (r0.equals("HIDE") == false) goto L33;
        this.e = r4.b;
        moveToState(b.a.a);
        int r6 = ECContextContainer.b;
        ECContext r7 = ECContextContainer.a.b();
        if (r7 == null) goto L34;
        m<Boolean> r8 = r7.getHasCouponEntryShown();
        if (r8 == null) goto L35;
        r8.setValue(Boolean.FALSE);
        return;
    L35:
        return;
    L34:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.y
    public final void onReceive(sg2.a r6) {
        if ((r6 instanceof z) == true) goto L5;
        sg2.a r0 = null;
    L6:
        z r1 = (z) r0;
        if (r1 == null) goto L25;
        ECV2CouponInfo r2 = r1.couponInfo;
        if (r2 == null) goto L26;
        JSONObject r3 = new JSONObject();
        r3.put("msg_type", ((z) r6).msgType);
        r3.put("meta_id", r2.metaId);
        r3.put("server_time", r2.serverTime);
        r3.put("countdown", r2.countDown);
        r3.put("activity_json_str", r2.activity);
        r3.put("coupon_type", r2.couponType);
        r3.put("meta_id_str", r2.metaIdString);
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L13
        int r4 = m0.a;     // Catch: Throwable -> L13
        Result.constructor-impl(r3.put("activity_info", new JSONObject(m0.a.b.toJson(r2.activityData))));     // Catch: Throwable -> L13
    L23:
        int r5 = m0.a;     // Catch: Throwable -> L17
        Result.constructor-impl(r3.put("coupon_meta", new JSONObject(m0.a.b.toJson(r2.couponMeta))));     // Catch: Throwable -> L17
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
        goto L23
    L26:
        return;
    L25:
        return;
    L5:
        r0 = r6;
        goto L6
    }

    public final void onShowTempState(int r3) {
        super.onShowTempState(r3);
        boolean r0 = CouponEventDispatcher.a;
        CouponEventDispatcher.a("onShowTempState strategy = " + r3);
        ECLiveHybridUtil.f("ecom.coupon.tempShortTouch.show", JSONDslUtilKt.a(new com.bytedance.android.livesdk.livecommerce.room.utils.json.a[]{JSONDslUtilKt.b("strategy", r3)}));
    }

    @Subscribe
    public final void registerTempShortTouchEvent(ah.g r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        CouponEventDispatcher.a("registerTempShortTouchEvent start");
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L6;
        this.k.post(new f(this, r6));
        return;
    L6:
        int r0 = r6.a.optInt("strategy");
        long r2 = r6.a.optLong("showTime");
        CouponEventDispatcher.a("registerTempShortTouchEvent strategy = " + r0 + " showTime = " + r2);
        ECLiveHybridUtil.f("ecom.coupon.registerTempShortTouch.result", JSONDslUtilKt.a(new com.bytedance.android.livesdk.livecommerce.room.utils.json.a[]{JSONDslUtilKt.b("result", registerShowTempState(r0, r2))}));
    }

    @Subscribe
    public final void showNormalStateEvent(i r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        CouponEventDispatcher.a("showNormalStateEvent");
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L6;
        this.k.post(new g(this, r3));
        return;
    L6:
        CustomIconTemplate r4 = this.a;
        if (r4 == null) goto L11;
        SquircleIconContent r5 = r4.getContentContainer();
        if (r5 == null) goto L11;
        r5.setTempShortTouch(false);
    L11:
        this.j = false;
        d();
        showNormalState();
    }

    @Subscribe
    public final void updateShortTouchCouponMsg(ShortTouchCouponMsgEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if (Intrinsics.areEqual(r3.getRoomId(), (String) this.o.getRoomId().getValue()) == false) goto L10;
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

    public final IExternalEntryView getEntryViewForState(Object r7, Object r8) {
        b r9 = (b) r7;
        b r10 = (b) r8;
        Intrinsics.checkNotNullParameter(r9, BaseCoreViewModel.CORE_TAG_STATE);
        if (Intrinsics.areEqual(r9, b.a.a) == false) goto L6;
    L10:
        return null;
    L6:
        if (Intrinsics.areEqual(r9, b.C0102b.a) == false) goto L13;
        FrameLayout r1 = this.d;
        if (r1 == null) goto L10;
        return new IExternalEntryView(r1, 0, 2, null);
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final void onEntryEvent(View r2, IExternalEntryEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "entryView");
        Intrinsics.checkNotNullParameter(r3, "event");
        int r4 = h.a[r3.ordinal()];
        if (r4 != 1) goto L5;
    L10:
        b(true);
        return;
    L5:
        if (r4 == 2) goto L10;
        if (r4 != 3) goto L13;
        ECLiveHybridUtil.f("ecom.coupon.prepareAnimation", JSONDslUtilKt.a(new com.bytedance.android.livesdk.livecommerce.room.utils.json.a[0]));
        return;
    }

    public final void applyState(Object r1, Object r2, IExternalIconTemplate r3) {
        b r4 = (b) r1;
        Intrinsics.checkNotNullParameter((b) r2, "curState");
    }

    public ShortTouchLynxCouponV2(b.a r2, Context r3, ECContext r4, String r5, RoomContextController r6) {
        Intrinsics.checkNotNullParameter(r2, "initialState");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "ecContext");
        Intrinsics.checkNotNullParameter(r5, "previewCouponId");
        Intrinsics.checkNotNullParameter(r6, "roomContextController");
        this.l = r2;
        this.m = 8;
        this.n = r3;
        this.o = r4;
        this.p = r5;
        this.q = r6;
        this.g = "auto";
        this.k = new Handler(Looper.getMainLooper());
        CouponEventDispatcher.c();
    }
}
