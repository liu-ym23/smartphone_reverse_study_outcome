package com.bytedance.android.window.shop.home.presenter;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.model.ECLiveMode;
import com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient;
import com.bytedance.android.ec.adapter.api.player.IECPlayerViewService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.window.base.common.headlive.WindowV3LiveRoomVO;
import com.bytedance.android.ec.window.base.shopping.floatlive.FloatScene;
import com.bytedance.android.window.shop.home.WindowMonitor;
import com.bytedance.android.window.shop.home.presenter.plugin.ECWindowMuteCtrlPlugin;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\bJ\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/window/shop/home/presenter/ECWindowLinkageHeaderLivePresenter;", "Lcom/bytedance/android/window/shop/home/presenter/j;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "onPause", "onDestroy", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowLinkageHeaderLivePresenter extends j implements View.OnClickListener, LifecycleObserver {
    public static final /* synthetic */ int t = 0;
    public ViewGroup m;
    public SimpleDraweeView n;
    public Float o;
    public boolean p;
    public final Lazy q;
    public final b r;
    public final Function0<Integer> s;

    public static final class a {
    }

    public static final class b implements yn.t {
        public boolean a;
        public final /* synthetic */ ECWindowLinkageHeaderLivePresenter b;

        public final void a() {
            ECWindowLinkageHeaderLivePresenter.a0(this.b).setVisibility(0);
        }

        public final void c() {
            ECWindowLinkageHeaderLivePresenter.a0(this.b).setVisibility(0);
            Map r0 = com.bytedance.android.ec.core.monitor.c.a;
            MonitorScenes r1 = MonitorScenes.EC_STORE_LIVE_FAIL_MONITOR;
            LinkedHashMap r2 = new LinkedHashMap();
            r2.put("store_type", "window");
            Unit r3 = Unit.INSTANCE;
            com.bytedance.android.ec.core.monitor.c.b(r1, null, r2);
        }

        public final void onFirstFrame() {
            ECWindowLinkageHeaderLivePresenter.a0(this.b).setVisibility(8);
            if (this.b.O().getShopParam().isFirstFrameReported() == true) goto L11;
            this.b.O().getShopParam().setFirstFrameReported(true);
            WindowMonitor r0 = this.b.O().getShopParam().getMonitor();
            if (r0 == null) goto L7;
            r0.stopFirstFrameTimeMonitor();
        L7:
            ConcurrentHashMap<Long, com.bytedance.android.window.shop.lifecycle.f> r1 = com.bytedance.android.window.shop.lifecycle.c.a;
            com.bytedance.android.window.shop.lifecycle.f r2 = com.bytedance.android.window.shop.lifecycle.c.a(this.b.O().getShopParam().getLifecycleMonitorId());
            if (r2 == null) goto L12;
            r2.g(this.b.O().getShopParam());
            return;
        L12:
            return;
        }

        public final void onPlayComplete() {
            ECWindowLinkageHeaderLivePresenter.a0(this.b).setVisibility(0);
        }

        public final void onStopped() {
            ECWindowLinkageHeaderLivePresenter.a0(this.b).setVisibility(0);
        }

        public b(ECWindowLinkageHeaderLivePresenter r1) {
            this.b = r1;
        }

        public final void b(boolean r3) {
            if (this.a == false) goto L5;
            return;
        L5:
            if ((!Intrinsics.areEqual((Boolean) this.b.O().isLiveOn().getValue(), Boolean.valueOf(r3))) == false) goto L7;
            this.b.O().isLiveOn().setValue(Boolean.valueOf(r3));
        L7:
            this.a = true;
        }

        public final void d(boolean r3) {
            if (r3 == false) goto L5;
            ECWindowLinkageHeaderLivePresenter r0 = this.b;
            int r1 = ECWindowLinkageHeaderLivePresenter.t;
            r0.f0();
            ECWindowLinkageHeaderLivePresenter.a0(this.b).setVisibility(0);
        L5:
            if (Intrinsics.areEqual((Boolean) this.b.O().isLiveOn().getValue(), Boolean.valueOf(r3)) == false) goto L8;
            this.b.O().isLiveOn().setValue(Boolean.valueOf(!r3));
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECWindowLinkageHeaderLivePresenter a;

        public c(ECWindowLinkageHeaderLivePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r20) {
            final WindowV3LiveRoomVO r11 = (WindowV3LiveRoomVO) r20;
            if (this.a.O().couldLive() == false) goto L29;
            if (r11 == null) goto L30;
            final ECWindowLinkageHeaderLivePresenter r12 = this.a;
            uq3.a r1 = (uq3.a) r12.O().getHeaderResponse().getValue();
            if (r1 == null) goto L16;
            uq3.o r2 = r1.c;
            if (r2 == null) goto L16;
            if (r2.a() != true) goto L16;
            boolean r3 = ECServiceManager.a;
            Boolean r4 = ((s83.g) ECServiceManager.c(s83.g.class)).hasLivePlayingMute();
            if (r4 == null) goto L16;
            boolean r14 = r4.booleanValue();
        L17:
            yn.d r15 = r12.O().getLiveManager();
            FloatScene r16 = FloatScene.WINDOW;
            Context r5 = r12.u().c();
            Fragment r6 = r12.u().a;
            View r7 = null;
            if ((r6 instanceof DialogFragment) == true) goto L20;
            r6 = null;
        L20:
            DialogFragment r8 = (DialogFragment) r6;
            View r9 = r12.X();
            if ((r9 instanceof FrameLayout) == false) goto L24;
            r7 = r9;
        L24:
            yn.d.d(r15, r16, false, r11, r14, new yn.m(r5, r8, (FrameLayout) r7, r11, r12.O().getPassThroughLogData(), "1003", r12.O().getShopParam().getSearchParams(), th.a.e(r12.u().c(), true).getResources().getDimensionPixelSize(2131166413), r12.O().getShopParam().getAuthorId()), true, new ECWindowLinkageHeaderLivePresenter$initHeaderLive$1(r12, r11), 64);
            ECWindowLinkageHeaderLivePresenter r10 = this.a;
            r10.getClass();
            String r13 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b7635.c4706.d3124", Boolean.FALSE).withView(r10.y()).build());
            ECWindowViewModel r17 = r10.O();
            Pair[] r18 = new Pair[5];
            r18[0] = TuplesKt.to("enter_from_merge", "store_page");
            r18[1] = TuplesKt.to("enter_method", "live_cell");
            String r19 = r11.getRoomId();
            if (r19 != null) goto L27;
            r19 = "";
        L27:
            r18[2] = TuplesKt.to("room_id", r19);
            r18[3] = TuplesKt.to("pass_through_log_data", r10.O().getPassThroughLogData());
            r18[4] = TuplesKt.to("btm_id", r13);
            r17.doEventAction("livesdk_live_show", r18);
            this.a.c0(r11);
            ECWindowLinkageHeaderLivePresenter r21 = this.a;
            r21.O().getOffsetState().a(r21.U(), new q1(r21), false);
            return;
        L16:
            r14 = true;
            goto L17
        L30:
            return;
        }
    }

    static {
    }

    public ECWindowLinkageHeaderLivePresenter() {
        this(null);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
    }

    public final void C() {
        ((ECWindowMuteCtrlPlugin) this.q.getValue()).b();
        yn.d r0 = O().getLiveManager();
        int r1 = yn.d.q;
        r0.b(false);
        U().getLifecycle().removeObserver(this);
    }

    public final boolean d0() {
        if ((!Intrinsics.areEqual((Boolean) O().isLiveOn().getValue(), Boolean.FALSE)) == true) goto L5;
    L7:
        return false;
    L5:
        if (com.bytedance.android.ec.core.utils.y0.a() == false) goto L7;
        return true;
    }

    public final void f0() {
        yn.d r0 = O().getLiveManager();
        IECLivePlayerClient r1 = r0.c;
        if (r1 == null) goto L5;
        r1.release();
    L5:
        Integer r2 = null;
        r0.c = null;
        int r3 = yn.n.a;
        JSONObject r4 = new JSONObject();
        r4.put("author_id", O().getShopParam().getAuthorId());
        WindowV3LiveRoomVO r5 = (WindowV3LiveRoomVO) O().getLiveInfo().getValue();
        if (r5 == null) goto L8;
        String r6 = r5.getRoomId();
    L9:
        if (r6 != null) goto L11;
        r6 = "";
    L11:
        r4.put("room_id", r6);
        IECLivePlayerClient r7 = O().getLiveManager().c;
        if (r7 == null) goto L14;
        r2 = Integer.valueOf(r7.hashCode());
    L14:
        r4.put("client_code", r2);
        r4.put("store_type", "window");
        Unit r8 = Unit.INSTANCE;
        JSONObject r9 = new JSONObject();
        JSONObject r10 = new JSONObject();
        Intrinsics.checkNotNullParameter("store_header_live_stop", "name");
        int r11 = ECMonitorService.b;
        ECMonitorService.a.a("store_header_live_stop", r4, r9, r10);
        return;
    L8:
        r6 = null;
        goto L9
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        O().getLiveManager().l.clear();
        int r0 = ECSdk.a;
        IAdapterService r1 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r1 == null) goto L7;
        com.bytedance.android.ec.adapter.api.j r2 = r1.getLiveWindowService();
        if (r2 == null) goto L7;
        r2.stopShowFloat();
    L7:
        U().getLifecycle().removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        f0();
        this.p = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        WindowV3LiveRoomVO r0 = (WindowV3LiveRoomVO) O().getLiveInfo().getValue();
        if (r0 == null) goto L5;
        c0(r0);
    L5:
        this.p = false;
    }

    public ECWindowLinkageHeaderLivePresenter(Function0<Integer> r1) {
        this.s = r1;
        this.q = LazyKt.lazy(new ECWindowLinkageHeaderLivePresenter$muteCtrlPlugin$2(this));
        this.r = new b(this);
    }

    public static final /* synthetic */ SimpleDraweeView a0(ECWindowLinkageHeaderLivePresenter r1) {
        SimpleDraweeView r2 = r1.n;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("liveCover");
    L5:
        return r2;
    }

    public final void A(QModel r3) {
        if (d0() == true) goto L5;
        return;
    L5:
        this.m = (ViewGroup) w().b(2131372771).f();
        this.n = w().b(2131376367).f();
        ((ECWindowMuteCtrlPlugin) this.q.getValue()).a();
        O().getLiveInfo().e(ECQuickUtilKt.a(u()), new c(this));
        U().getLifecycle().addObserver(this);
    }

    public final le.b b0(WindowV3LiveRoomVO r18) {
        int r0 = yn.a.a;
        int r1 = ECSdk.a;
        IAdapterService r2 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r2 == null) goto L9;
        com.bytedance.android.ec.adapter.api.j r3 = r2.getLiveWindowService();
        if (r3 == null) goto L9;
        if (r3.isFloatWindowShowing() != true) goto L9;
        boolean r4 = true;
    L10:
        IECLivePlayerClient r5 = null;
        if (r4 == false) goto L17;
        SimpleDraweeView r6 = this.n;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("liveCover");
    L15:
        r6.setVisibility(8);
        return null;
    L17:
        yn.d r7 = O().getLiveManager();
        String r8 = r18.getRoomId();
        if (r8 == null) goto L91;
        long r9 = CastLongProtector.parseLong(r8);
        IAdapterService r10 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r10 == null) goto L24;
        IECPlayerViewService r11 = r10.getPlayerViewService();
        if (r11 == null) goto L24;
        le.b r12 = IECPlayerViewService.a.a(r11, u().c(), null, 0, String.valueOf(r9), "ec_feed_window", true, true, 384);
    L25:
        if (r12 == null) goto L91;
        com.bytedance.android.ec.adapter.impl.adapters.reverse.player.d r13 = (com.bytedance.android.ec.adapter.impl.adapters.reverse.player.d) r12;
        r13.setScaleType(2);
        r13.b.setVisibility(0);
        FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(-1, -1);
        r14.gravity = 17;
        r14.setMargins(0, 0, 0, com.bytedance.android.shopping.extensions.b.b(80));
        Object r15 = u().c().getSystemService("window");
        if ((r15 instanceof WindowManager) == true) goto L30;
        r15 = null;
    L30:
        WindowManager r16 = (WindowManager) r15;
        if (r16 == null) goto L39;
        Display r17 = r16.getDefaultDisplay();
        if (r17 == null) goto L39;
        Point r19 = new Point();
        r17.getRealSize(r19);
        if (r19.x <= 0) goto L39;
        if (r19.y <= 0) goto L39;
    L40:
        if (r19 == null) goto L45;
        int r20 = r19.x;
        if (r20 <= 0) goto L45;
        r14.width = r20;
        r14.height = (int) ((r20 * 16.0f) / 9.0f);
    L45:
        if (r13.a().isPlaying() == true) goto L94;
        r5 = r13.a();     // Catch: Exception -> L61
    L63:
        String r21 = (String) ECSettingKeys.C().get("ec_feed_window");
        if (r21 != null) goto L66;
        r21 = (String) ECSettingKeys.B().get("ec_feed_window");
    L66:
        Function1<LifecycleOwner, Unit> r22 = new ECWindowLinkageHeaderLivePresenter$createPlayView$2(this);
        r7.c = r5;
        le.a.a r23 = new le.a.a();
        WindowV3LiveRoomVO r110 = r7.d;
        if (r110 == null) goto L70;
        String r111 = r110.getStreamData();
        if (r111 == null) goto L70;
    L71:
        Intrinsics.checkNotNullParameter(r111, "data");
        r23.a = r111;
        if (r21 == null) goto L74;
        Intrinsics.checkNotNullParameter(r21, "resolution");
        r23.b = r21;
    L74:
        ECLiveMode r24 = ECLiveMode.MEDIA;
        Intrinsics.checkNotNullParameter(r24, "streamType");
        r23.c = r24;
        r23.h = r7.f();
        r23.f = true;
        le.a r25 = r23.a();
        if (r5 == null) goto L77;
        r5.stream(r25, r22);
    L77:
        ViewGroup r26 = this.m;
        if (r26 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("liveSceneContainer");
    L81:
        if (r26.getChildCount() <= 1) goto L86;
        ViewGroup r27 = this.m;
        if (r27 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("liveSceneContainer");
    L85:
        r27.removeAllViews();
    L86:
        ViewGroup r28 = this.m;
        if (r28 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("liveSceneContainer");
    L89:
        r28.addView(r13.b, r14);
        return r12;
    L70:
        r111 = "";
    L61:
        e = move-exception;
        e.toString();
        goto L63
    L94:
        r5 = r13.a();     // Catch: Exception -> L48
    L51:
        if (r7.e() == true) goto L77;
        r7.c = r5;
        if (r5 == null) goto L57;
        r5.resumePlay();
    L57:
        if (r7.f() == false) goto L77;
        r7.h(true);
    L48:
        e = move-exception;
        e.toString();
    L39:
        r19 = null;
    L24:
        r12 = null;
    L91:
        return null;
    L9:
        r4 = false;
        goto L10
    }

    public final void c0(WindowV3LiveRoomVO r7) {
        if (d0() == true) goto L6;
        return;
    L6:
        if (com.bytedance.android.ec.core.utils.y0.a() == false) goto L34;
        SimpleDraweeView r0 = this.n;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("liveCover");
    L11:
        r0.setVisibility(0);
        com.bytedance.android.ec.adapter.impl.adapters.reverse.player.d r1 = b0(r7);
        if (r1 == null) goto L34;
        com.bytedance.android.ec.adapter.impl.adapters.reverse.player.d r2 = r1;
        if (r2.a().isPlaying() == false) goto L23;
        e0(r2.a().getLifecycleOwner());
        this.r.a = true;
        Boolean r3 = (Boolean) O().isLiveOn().getValue();
        Boolean r4 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r3, r4)) == false) goto L19;
        O().isLiveOn().setValue(r4);
    L19:
        SimpleDraweeView r5 = this.n;
        if (r5 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("liveCover");
    L22:
        r5.setVisibility(8);
    L23:
        int r6 = yn.n.a;
        JSONObject r8 = new JSONObject();
        r8.put("author_id", O().getShopParam().getAuthorId());
        WindowV3LiveRoomVO r9 = (WindowV3LiveRoomVO) O().getLiveInfo().getValue();
        if (r9 == null) goto L26;
        String r10 = r9.getRoomId();
    L27:
        if (r10 != null) goto L29;
        r10 = "";
    L29:
        r8.put("room_id", r10);
        IECLivePlayerClient r11 = O().getLiveManager().c;
        if (r11 == null) goto L32;
        Integer r12 = Integer.valueOf(r11.hashCode());
    L33:
        r8.put("client_code", r12);
        r8.put("store_type", "window");
        Unit r13 = Unit.INSTANCE;
        JSONObject r14 = new JSONObject();
        Intrinsics.checkNotNullParameter("store_header_live_start", "name");
        int r15 = ECMonitorService.b;
        ECMonitorService.a.a("store_header_live_start", r8, r14, null);
        goto L34
    L32:
        r12 = null;
        goto L33
    L26:
        r10 = null;
    L34:
        ECUrlModel r16 = r7.getCover();
        if (r16 == null) goto L40;
        SimpleDraweeView r17 = this.n;
        if (r17 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("liveCover");
    L39:
        com.bytedance.android.ec.core.utils.y.a(r17, r16);
    L40:
        O().setJump2Live(new ECWindowLinkageHeaderLivePresenter$initLiveAbout$2(this));
        ViewGroup r18 = this.m;
        if (r18 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("liveSceneContainer");
    L43:
        r18.setOnClickListener(this);
    }

    public final void e0(LifecycleOwner r6) {
        yn.d r0 = O().getLiveManager();
        Context r1 = u().c();
        b r2 = this.r;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "listener");
        IECLivePlayerClient r3 = r0.c;
        if (r3 == null) goto L6;
        td.e r4 = r3.getEventHub();
        r4.getPlayPrepared().observe(r6, new yn.f(r6, r2));
        r4.getFirstFrame().observe(r6, new yn.g(r6, r2));
        r4.getStopped().observe(r6, new yn.h(r6, r2));
        r4.getReleased().observe(r6, new yn.i(r6, r2));
        r4.getPlayComplete().observe(r6, new yn.j(r6, r2));
        r4.getLiveEnd().observe(r6, new yn.k(r0, r6, r2));
        r4.getPlayerMediaError().observe(r6, new yn.l(r6, r2));
        return;
    }
}
