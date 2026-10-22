package com.bytedance.android.shopping.store.home.presenter.preview;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.model.ECLiveMode;
import com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient;
import com.bytedance.android.ec.adapter.api.player.IECPlayerViewService;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.utils.y0;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.store.common.const.LiveStyles;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.ec.store.setting.SettingKeys;
import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import com.bytedance.android.ec.store.utils.taskmanager.TaskPriority;
import com.bytedance.android.shopping.store.home.event.StoreUserActionEvent;
import com.bytedance.android.shopping.store.home.frame.container.ShopContainerType;
import com.bytedance.android.shopping.store.home.view.v;
import com.bytedance.android.shopping.store.lifecycle.ECStorePerfMonitor;
import com.bytedance.android.shopping.store.live.event.ShopLiveState;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.viewmodel.ShopStatus;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.bytedance.ies.uikit.base.AbsActivity;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import im.u;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0001\nJ\b\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\b\u001a\u00020\u0006H\u0007J\b\u0010\t\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/preview/ECShopLivePreviewPresenter;", "Lcom/bytedance/android/shopping/store/home/frame/presenter/a;", "Lcom/bytedance/android/ec/store/common/headlive/StoreV3LiveRoomVO;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/bytedance/android/shopping/store/home/presenter/preview/q;", "", "onResume", "onPause", "onDestroy", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopLivePreviewPresenter extends com.bytedance.android.shopping.store.home.frame.presenter.a<StoreV3LiveRoomVO> implements View.OnClickListener, LifecycleObserver, q {
    public static final /* synthetic */ int D = 0;
    public int A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy j;
    public Float k;
    public boolean l;
    public boolean m;
    public ViewGroup n;
    public ViewGroup o;
    public SimpleDraweeView p;
    public ViewGroup q;
    public View r;
    public View s;
    public View t;
    public View u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public final b z;

    public static final class a {
    }

    public static final class b implements u {
        public boolean a;
        public final /* synthetic */ ECShopLivePreviewPresenter b;

        public final void a() {
            ECShopLivePreviewPresenter.k0(this.b).setVisibility(0);
        }

        public final void onFirstFrame() {
            ECShopLivePreviewPresenter.k0(this.b).setVisibility(8);
            o r0 = this.b.n0();
            if (r0 == null) goto L6;
            r0.e();
            return;
        }

        public final void onPlayComplete() {
            ECShopLivePreviewPresenter.k0(this.b).setVisibility(0);
        }

        public final void onStopped() {
            ECShopLivePreviewPresenter.k0(this.b).setVisibility(0);
        }

        public b(ECShopLivePreviewPresenter r1) {
            this.b = r1;
        }

        public final void b(boolean r3) {
            if (this.a == true) goto L9;
            ECShopLivePreviewPresenter r0 = this.b;
            int r1 = ECShopLivePreviewPresenter.D;
            o r2 = r0.n0();
            if (r2 == null) goto L7;
            r2.d(r3);
        L7:
            this.a = true;
            return;
        }

        public final void c(String r6) {
            ECShopLivePreviewPresenter.k0(this.b).setVisibility(0);
            ECShopLivePreviewPresenter r0 = this.b;
            r0.getClass();
            Map r1 = com.bytedance.android.ec.core.monitor.c.a;
            MonitorScenes r2 = MonitorScenes.EC_STORE_LIVE_FAIL_MONITOR;
            LinkedHashMap r3 = new LinkedHashMap();
            r3.put("store_type", "shop");
            r3.put("error_msg", String.valueOf(r6));
            Unit r7 = Unit.INSTANCE;
            com.bytedance.android.ec.core.monitor.c.b(r2, null, r3);
            if (SettingKeys.getSHOP_LIVE_TRY_AGAIN_SWITCH() == false) goto L20;
            int r4 = r0.A;
            r0.A = r4 + 1;
            if (r4 >= 3) goto L21;
            im.b r5 = r0.p0();
            if (r5 == null) goto L12;
            IECLivePlayerClient r8 = r5.c;
            if (r8 == null) goto L11;
            r8.release();
        L11:
            r5.c = null;
        L12:
            p r9 = r0.o0();
            if (r9 == null) goto L22;
            StoreV3LiveRoomVO r10 = r9.h();
            if (r10 == null) goto L23;
            im.b r11 = r0.p0();
            if (r11 == null) goto L24;
            r11.f = new ECShopLivePreviewPresenter$initHeaderLive$1(r0, r10);
            return;
        L24:
            return;
        L23:
            return;
        L22:
            return;
        L21:
            return;
        }

        public final void d(boolean r3) {
            if (r3 == false) goto L4;
            ECShopLivePreviewPresenter r0 = this.b;
            int r1 = ECShopLivePreviewPresenter.D;
            r0.s0();
            ECShopLivePreviewPresenter.k0(this.b).setVisibility(0);
        L4:
            ECShopLivePreviewPresenter r2 = this.b;
            int r4 = ECShopLivePreviewPresenter.D;
            o r5 = r2.n0();
            if (r5 == null) goto L8;
            r5.d(!r3);
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ECShopLivePreviewPresenter a;

        public c(ECShopLivePreviewPresenter r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.w = false;     // Catch: Throwable -> L4
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

    public final o n0() {
        return (o) this.C.getValue();
    }

    public final p o0() {
        return (p) this.B.getValue();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        int r0 = ECSdk.a;
        IAdapterService r1 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r1 == null) goto L7;
        com.bytedance.android.ec.adapter.api.j r2 = r1.getLiveWindowService();
        if (r2 == null) goto L7;
        r2.stopShowFloat();
    L7:
        e0().removeObserver(this);
    }

    public final void c0() {
        s0();
        im.b r0 = p0();
        if (r0 == null) goto L6;
        int r1 = im.b.q;
        r0.a(false);
        return;
    }

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.a
    public final void j0() {
        p r0 = o0();
        if (r0 == null) goto L6;
        r0.k();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        s0();
        this.v = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        p r0 = o0();
        if (r0 == null) goto L5;
        final StoreV3LiveRoomVO r1 = r0.h();
    L6:
        int r2 = ECStorePerfMonitor.n;
        if (r1 == null) goto L9;
        Long r3 = r1.getPerfMonitorId();
    L10:
        ECStorePerfMonitor r4 = ECStorePerfMonitor.a.a(r3);
        if (r4 == null) goto L16;
        com.bytedance.android.shopping.store.lifecycle.g r5 = r4.k;
        if (r5 == null) goto L16;
        int r6 = com.bytedance.android.shopping.store.lifecycle.g.e;
        r5.c(13, null);
    L16:
        if (r1 == null) goto L381;
        ECUrlModel r7 = r1.getCover();
        if (r7 == null) goto L23;
        SimpleDraweeView r8 = this.p;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("liveCover");
    L22:
        y.a(r8, r7);
    L23:
        Integer r9 = d0().getStoreUIParam().getLiveStyle();
        int r10 = LiveStyles.FLOATWINDOW.getType();
        if (r9 != null) goto L27;
    L28:
        ECShopABSettings.k.getClass();
        Object r11 = 0;
        if (Intrinsics.areEqual("ec_enter_shop_live_style", "ec_shop_launch_opt_common_2") == false) goto L203;
        if (ECShopABSettings.b != null) goto L197;
        int r12 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r13 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L187
        Object r15 = com.bytedance.android.ec.base.settings.d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L83
        if (r15 != null) goto L38;
    L80:
        Object r16 = null;
    L81:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L83
    L85:
        Throwable r18 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L187
        if (r18 == null) goto L89;
        EnsureManager.ensureNotReachHere(r18);     // Catch: Throwable -> L187
    L89:
        if (Result.isFailure-impl(r17) == false) goto L92;
        r17 = null;
    L92:
        if ((r17 instanceof Integer) == true) goto L94;
        r17 = null;
    L94:
        Object r19 = (Integer) r17;     // Catch: Throwable -> L187
        if (r19 != null) goto L101;
        Object r20 = com.bytedance.android.ec.base.settings.d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L187
        if ((r20 instanceof Integer) == true) goto L100;
        r20 = null;
    L100:
        r19 = (Integer) r20;     // Catch: Throwable -> L187
    L101:
        if (r19 != null) goto L196;
        int r21 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L187
        Object r22 = com.bytedance.android.ec.base.settings.d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L153
        if (r22 != null) goto L108;
    L150:
        Object r23 = null;
    L151:
        Object r24 = Result.constructor-impl(r23);     // Catch: Throwable -> L153
    L155:
        Throwable r25 = Result.exceptionOrNull-impl(r24);     // Catch: Throwable -> L178
        if (r25 == null) goto L159;
        EnsureManager.ensureNotReachHere(r25);     // Catch: Throwable -> L178
    L159:
        if (Result.isFailure-impl(r24) == false) goto L162;
        r24 = null;
    L162:
        if ((r24 instanceof Integer) == true) goto L164;
        r24 = null;
    L164:
        r19 = (Integer) r24;     // Catch: Throwable -> L178
        if (r19 != null) goto L185;
        IHybridHostService r26 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L178
        if (r26 == null) goto L170;
        Object r27 = r26.getHostABValue("ec_shop_launch_opt_common_2", r11);     // Catch: Throwable -> L178
    L171:
        if (r27 != null) goto L173;
    L184:
        r19 = r11;
        goto L185
    L173:
        if ((r27 instanceof Integer) == true) goto L175;
        r27 = null;
    L175:
        r19 = (Integer) r27;     // Catch: Throwable -> L178
        if (r19 != null) goto L185;
    L178:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L187
        r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L187
        Throwable r29 = Result.exceptionOrNull-impl(r19);     // Catch: Throwable -> L187
        if (r29 == null) goto L183;
        EnsureManager.ensureNotReachHere(r29);     // Catch: Throwable -> L187
    L183:
        if (Result.isFailure-impl(r19) == false) goto L185;
    L170:
        r27 = null;
    L185:
        com.bytedance.android.ec.base.settings.d.d("ec_shop_launch_opt_common_2", r19);     // Catch: Throwable -> L187
        goto L196
    L108:
        if ((r22 instanceof Integer) == true) goto L110;
        Object r30 = null;
    L111:
        r23 = (Integer) r30;     // Catch: Throwable -> L153
        if (r23 != null) goto L151;
        if ((r22 instanceof Number) == false) goto L138;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L123;
        Float r31 = Float.valueOf(((Number) r22).floatValue());     // Catch: Throwable -> L153
        if ((r31 instanceof Integer) == true) goto L121;
        r31 = null;
    L121:
        r23 = (Integer) r31;     // Catch: Throwable -> L153
        goto L151
    L123:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L129;
        Double r32 = Double.valueOf(((Number) r22).doubleValue());     // Catch: Throwable -> L153
        if ((r32 instanceof Integer) == true) goto L127;
        r32 = null;
    L127:
        r23 = (Integer) r32;     // Catch: Throwable -> L153
        goto L151
    L129:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L132;
        r23 = Integer.valueOf(((Number) r22).intValue());     // Catch: Throwable -> L153
        goto L151
    L132:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L138;
        Long r33 = Long.valueOf(((Number) r22).longValue());     // Catch: Throwable -> L153
        if ((r33 instanceof Integer) == true) goto L136;
        r33 = null;
    L136:
        r23 = (Integer) r33;     // Catch: Throwable -> L153
    L138:
        if ((r22 instanceof JSONObject) == false) goto L140;
    L415:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L146
        Object r34 = SDKSettingsCacheManager.a().fromJson(r22.toString(), Integer.class);     // Catch: Throwable -> L146
        if ((r34 instanceof Integer) == true) goto L144;
        r34 = null;
    L144:
        Object r35 = Result.constructor-impl((Integer) r34);     // Catch: Throwable -> L146
    L148:
        r23 = r35;
        if (Result.isFailure-impl(r23) == false) goto L151;
    L146:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L153
        r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
        goto L148
    L140:
        if ((r22 instanceof JSONArray) == false) goto L150;
    L110:
        r30 = r22;
    L153:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L178
        r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L178
    L196:
        ECShopABSettings.b = (Integer) r19;
        goto L197
    L38:
        if ((r15 instanceof Integer) == true) goto L40;
        Object r38 = null;
    L41:
        r16 = (Integer) r38;     // Catch: Throwable -> L83
        if (r16 != null) goto L81;
        if ((r15 instanceof Number) == false) goto L68;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L53;
        Float r39 = Float.valueOf(((Number) r15).floatValue());     // Catch: Throwable -> L83
        if ((r39 instanceof Integer) == true) goto L51;
        r39 = null;
    L51:
        r16 = (Integer) r39;     // Catch: Throwable -> L83
        goto L81
    L53:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L59;
        Double r40 = Double.valueOf(((Number) r15).doubleValue());     // Catch: Throwable -> L83
        if ((r40 instanceof Integer) == true) goto L57;
        r40 = null;
    L57:
        r16 = (Integer) r40;     // Catch: Throwable -> L83
        goto L81
    L59:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L62;
        r16 = Integer.valueOf(((Number) r15).intValue());     // Catch: Throwable -> L83
        goto L81
    L62:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L68;
        Long r41 = Long.valueOf(((Number) r15).longValue());     // Catch: Throwable -> L83
        if ((r41 instanceof Integer) == true) goto L66;
        r41 = null;
    L66:
        r16 = (Integer) r41;     // Catch: Throwable -> L83
    L68:
        if ((r15 instanceof JSONObject) == false) goto L70;
    L413:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L76
        Object r42 = SDKSettingsCacheManager.a().fromJson(r15.toString(), Integer.class);     // Catch: Throwable -> L76
        if ((r42 instanceof Integer) == true) goto L74;
        r42 = null;
    L74:
        Object r43 = Result.constructor-impl((Integer) r42);     // Catch: Throwable -> L76
    L78:
        r16 = r43;
        if (Result.isFailure-impl(r16) == false) goto L81;
    L76:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L83
        r43 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L83
        goto L78
    L70:
        if ((r15 instanceof JSONArray) == false) goto L80;
    L40:
        r38 = r15;
    L83:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L187
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L187
    L187:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        Object r47 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r48 = Result.exceptionOrNull-impl(r47);
        if (r48 == null) goto L192;
        EnsureManager.ensureNotReachHere(r48);
    L192:
        if (Result.isFailure-impl(r47) == true) goto L195;
        r11 = r47;
    L195:
        r19 = r11;
    L197:
        r11 = ECShopABSettings.b;
        if (r11 == null) goto L201;
    L375:
        ECShopABSettings.a.put("ec_enter_shop_live_style", r11);
        if (((Number) r11).intValue() == 1) goto L379;
        l0(r1);
    L379:
        Lazy r49 = ECTaskManager.b;
        ECTaskManager.a.a().a(d0().getLifecycleMonitorId(), TaskPriority.AFTER_FIRST_SCREEN, new ECShopLivePreviewPresenter$initLiveAbout$2(this, r1));
        goto L381
    L201:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L203:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L214;
        int r50 = com.bytedance.android.ec.core.opt.ab.p.a;
        Result.Companion r51 = Result.Companion;     // Catch: Throwable -> L209
        jj4.b r52 = jj4.b.b;     // Catch: Throwable -> L209
        Object r53 = jj4.a.a("ec_enter_shop_live_style", Integer.class, r11, false);     // Catch: Throwable -> L209
        if (r53 != null) goto L213;
        Intrinsics.throwNpe();     // Catch: Throwable -> L209
    L213:
        r11 = r53;
    L209:
        th = move-exception;
        Result.Companion r54 = Result.Companion;
        r53 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r53) == false) goto L213;
    L214:
        int r55 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r56 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r57 = Result.Companion;     // Catch: Throwable -> L369
        Object r58 = com.bytedance.android.ec.base.settings.d.c.get("ec_enter_shop_live_style");     // Catch: Throwable -> L265
        if (r58 != null) goto L220;
    L262:
        Object r59 = null;
    L263:
        Object r60 = Result.constructor-impl(r59);     // Catch: Throwable -> L265
    L267:
        Throwable r61 = Result.exceptionOrNull-impl(r60);     // Catch: Throwable -> L369
        if (r61 == null) goto L271;
        EnsureManager.ensureNotReachHere(r61);     // Catch: Throwable -> L369
    L271:
        if (Result.isFailure-impl(r60) == false) goto L274;
        r60 = null;
    L274:
        if ((r60 instanceof Integer) == true) goto L276;
        r60 = null;
    L276:
        r53 = (Integer) r60;     // Catch: Throwable -> L369
        if (r53 != null) goto L283;
        Object r62 = com.bytedance.android.ec.base.settings.d.a.get("ec_enter_shop_live_style");     // Catch: Throwable -> L369
        if ((r62 instanceof Integer) == true) goto L282;
        r62 = null;
    L282:
        r53 = (Integer) r62;     // Catch: Throwable -> L369
    L283:
        if (r53 != null) goto L213;
        int r63 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L369
        Object r64 = com.bytedance.android.ec.base.settings.d.c.get("ec_enter_shop_live_style");     // Catch: Throwable -> L335
        if (r64 != null) goto L290;
    L332:
        Object r65 = null;
    L333:
        Object r66 = Result.constructor-impl(r65);     // Catch: Throwable -> L335
    L337:
        Throwable r67 = Result.exceptionOrNull-impl(r66);     // Catch: Throwable -> L360
        if (r67 == null) goto L341;
        EnsureManager.ensureNotReachHere(r67);     // Catch: Throwable -> L360
    L341:
        if (Result.isFailure-impl(r66) == false) goto L344;
        r66 = null;
    L344:
        if ((r66 instanceof Integer) == true) goto L346;
        r66 = null;
    L346:
        r53 = (Integer) r66;     // Catch: Throwable -> L360
        if (r53 != null) goto L367;
        IHybridHostService r68 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L360
        if (r68 == null) goto L352;
        Object r69 = r68.getHostABValue("ec_enter_shop_live_style", r11);     // Catch: Throwable -> L360
    L353:
        if (r69 != null) goto L355;
    L366:
        r53 = r11;
        goto L367
    L355:
        if ((r69 instanceof Integer) == true) goto L357;
        r69 = null;
    L357:
        r53 = (Integer) r69;     // Catch: Throwable -> L360
        if (r53 != null) goto L367;
    L352:
        r69 = null;
    L367:
        com.bytedance.android.ec.base.settings.d.d("ec_enter_shop_live_style", r53);     // Catch: Throwable -> L369
        goto L213
    L290:
        if ((r64 instanceof Integer) == true) goto L292;
        Object r70 = null;
    L293:
        r65 = (Integer) r70;     // Catch: Throwable -> L335
        if (r65 != null) goto L333;
        if ((r64 instanceof Number) == false) goto L320;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L305;
        Float r71 = Float.valueOf(((Number) r64).floatValue());     // Catch: Throwable -> L335
        if ((r71 instanceof Integer) == true) goto L303;
        r71 = null;
    L303:
        r65 = (Integer) r71;     // Catch: Throwable -> L335
        goto L333
    L305:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L311;
        Double r72 = Double.valueOf(((Number) r64).doubleValue());     // Catch: Throwable -> L335
        if ((r72 instanceof Integer) == true) goto L309;
        r72 = null;
    L309:
        r65 = (Integer) r72;     // Catch: Throwable -> L335
        goto L333
    L311:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L314;
        r65 = Integer.valueOf(((Number) r64).intValue());     // Catch: Throwable -> L335
        goto L333
    L314:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L320;
        Long r73 = Long.valueOf(((Number) r64).longValue());     // Catch: Throwable -> L335
        if ((r73 instanceof Integer) == true) goto L318;
        r73 = null;
    L318:
        r65 = (Integer) r73;     // Catch: Throwable -> L335
    L320:
        if ((r64 instanceof JSONObject) == false) goto L322;
    L422:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L328
        Object r74 = SDKSettingsCacheManager.a().fromJson(r64.toString(), Integer.class);     // Catch: Throwable -> L328
        if ((r74 instanceof Integer) == true) goto L326;
        r74 = null;
    L326:
        Object r75 = Result.constructor-impl((Integer) r74);     // Catch: Throwable -> L328
    L330:
        r65 = r75;
        if (Result.isFailure-impl(r65) == false) goto L333;
    L328:
        th = move-exception;
        Result.Companion r76 = Result.Companion;     // Catch: Throwable -> L335
        r75 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L335
        goto L330
    L322:
        if ((r64 instanceof JSONArray) == false) goto L332;
    L292:
        r70 = r64;
    L360:
        th = move-exception;
        Result.Companion r77 = Result.Companion;     // Catch: Throwable -> L369
        r53 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L369
        Throwable r78 = Result.exceptionOrNull-impl(r53);     // Catch: Throwable -> L369
        if (r78 == null) goto L365;
        EnsureManager.ensureNotReachHere(r78);     // Catch: Throwable -> L369
    L365:
        if (Result.isFailure-impl(r53) == false) goto L367;
    L335:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L360
        r66 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L360
        goto L337
    L220:
        if ((r58 instanceof Integer) == true) goto L222;
        Object r80 = null;
    L223:
        r59 = (Integer) r80;     // Catch: Throwable -> L265
        if (r59 != null) goto L263;
        if ((r58 instanceof Number) == false) goto L250;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L235;
        Float r81 = Float.valueOf(((Number) r58).floatValue());     // Catch: Throwable -> L265
        if ((r81 instanceof Integer) == true) goto L233;
        r81 = null;
    L233:
        r59 = (Integer) r81;     // Catch: Throwable -> L265
        goto L263
    L235:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L241;
        Double r82 = Double.valueOf(((Number) r58).doubleValue());     // Catch: Throwable -> L265
        if ((r82 instanceof Integer) == true) goto L239;
        r82 = null;
    L239:
        r59 = (Integer) r82;     // Catch: Throwable -> L265
        goto L263
    L241:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L244;
        r59 = Integer.valueOf(((Number) r58).intValue());     // Catch: Throwable -> L265
        goto L263
    L244:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L250;
        Long r83 = Long.valueOf(((Number) r58).longValue());     // Catch: Throwable -> L265
        if ((r83 instanceof Integer) == true) goto L248;
        r83 = null;
    L248:
        r59 = (Integer) r83;     // Catch: Throwable -> L265
    L250:
        if ((r58 instanceof JSONObject) == false) goto L252;
    L420:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L258
        Object r84 = SDKSettingsCacheManager.a().fromJson(r58.toString(), Integer.class);     // Catch: Throwable -> L258
        if ((r84 instanceof Integer) == true) goto L256;
        r84 = null;
    L256:
        Object r85 = Result.constructor-impl((Integer) r84);     // Catch: Throwable -> L258
    L260:
        r59 = r85;
        if (Result.isFailure-impl(r59) == false) goto L263;
    L258:
        th = move-exception;
        Result.Companion r86 = Result.Companion;     // Catch: Throwable -> L265
        r85 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L265
        goto L260
    L252:
        if ((r58 instanceof JSONArray) == false) goto L262;
    L222:
        r80 = r58;
    L265:
        th = move-exception;
        Result.Companion r87 = Result.Companion;     // Catch: Throwable -> L369
        r60 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L369
    L369:
        th = move-exception;
        Result.Companion r88 = Result.Companion;
        r53 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r89 = Result.exceptionOrNull-impl(r53);
        if (r89 == null) goto L374;
        EnsureManager.ensureNotReachHere(r89);
    L374:
        if (Result.isFailure-impl(r53) == false) goto L213;
    L27:
        if (r9.intValue() == r10) goto L379;
    L381:
        if (this.w == false) goto L385;
        dm.a.a("点击进直播间").a("STATE_COLLAPSED");
        o r90 = n0();
        if (r90 == null) goto L386;
        r90.b(ShopStatus.PREVIEW_EXPANDED);
    L386:
        a0().post(new c(this));
        this.m = false;
        p r91 = o0();
        if (r91 == null) goto L389;
        float r92 = r91.f();
    L391:
        if (r92 >= 0.95f) goto L393;
    L397:
        this.v = false;
        int r93 = ECStorePerfMonitor.n;
        if (r1 == null) goto L400;
        Long r94 = r1.getPerfMonitorId();
    L401:
        ECStorePerfMonitor r95 = ECStorePerfMonitor.a.a(r94);
        if (r95 == null) goto L432;
        com.bytedance.android.shopping.store.lifecycle.g r96 = r95.k;
        if (r96 == null) goto L433;
        int r97 = com.bytedance.android.shopping.store.lifecycle.g.e;
        r96.c(14, null);
        return;
    L433:
        return;
    L432:
        return;
    L400:
        r94 = null;
        goto L401
    L393:
        if (this.w == false) goto L397;
        im.b r98 = p0();
        if (r98 == null) goto L397;
        r98.g();
        goto L397
    L389:
        r92 = 0.0f;
        goto L391
    L385:
        t0(true);
        goto L386
    L9:
        r3 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final im.b p0() {
        p r0 = o0();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.g();
    }

    public final void s0() {
        im.b r0 = p0();
        Integer r1 = null;
        if (r0 == null) goto L8;
        IECLivePlayerClient r2 = r0.c;
        if (r2 == null) goto L7;
        r2.release();
    L7:
        r0.c = null;
    L8:
        int r3 = im.p.a;
        JSONObject r4 = new JSONObject();
        r4.put("author_id", d0().getStoreAccountParam().getUserId());
        p r5 = o0();
        if (r5 == null) goto L13;
        StoreV3LiveRoomVO r6 = r5.h();
        if (r6 == null) goto L13;
        String r7 = r6.getRoomId();
    L14:
        if (r7 != null) goto L16;
        r7 = "";
    L16:
        r4.put("room_id", r7);
        im.b r8 = p0();
        if (r8 == null) goto L21;
        IECLivePlayerClient r9 = r8.c;
        if (r9 == null) goto L21;
        r1 = Integer.valueOf(r9.hashCode());
    L21:
        r4.put("client_code", r1);
        r4.put("store_type", "shop");
        Unit r10 = Unit.INSTANCE;
        JSONObject r11 = new JSONObject();
        JSONObject r12 = new JSONObject();
        Intrinsics.checkNotNullParameter("store_header_live_stop", "name");
        int r13 = ECMonitorService.b;
        ECMonitorService.a.a("store_header_live_stop", r4, r11, r12);
        return;
    L13:
        r7 = null;
        goto L14
    }

    public ECShopLivePreviewPresenter(Fragment r1) {
        Intrinsics.checkNotNull(r1);
        super(r1);
        this.j = LazyKt.lazy(new ECShopLivePreviewPresenter$thresholds$2(this));
        this.z = new b(this);
        this.B = LazyKt.lazy(new ECShopLivePreviewPresenter$modelAdapter$2(this));
        this.C = LazyKt.lazy(new ECShopLivePreviewPresenter$behaviorAdapter$2(this));
    }

    public static final /* synthetic */ SimpleDraweeView k0(ECShopLivePreviewPresenter r1) {
        SimpleDraweeView r2 = r1.p;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("liveCover");
    L5:
        return r2;
    }

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.a
    public final void i0(StoreV3LiveRoomVO r8) {
        if (this.y == true) goto L121;
        ShoppingAsyncInflater.a r9 = ShoppingAsyncInflater.e;
        boolean r2 = true;
        Context r1 = th.a.e(Y().c(), true);
        r9.getClass();
        ShoppingAsyncInflater r10 = ShoppingAsyncInflater.a.a(r1);
        View r3 = a0();
        if (r3 == null) goto L120;
        View r11 = r10.aU(2131560939, (ViewGroup) r3, false);
        View r4 = a0();
        if (r4 == null) goto L118;
        ((ViewGroup) r4).addView(r11);
        this.y = true;
        com.bytedance.android.shopping.store.home.frame.presenter.e r12 = this.h;
        ShopContainerType r5 = ShopContainerType.LIVE_PREVIEW_CONTAINER;
        View r13 = r12.c(r5);
        FrameLayout.LayoutParams r6 = null;
        if ((r13 instanceof ViewGroup) == true) goto L11;
        r13 = null;
    L11:
        ViewGroup r14 = (ViewGroup) r13;
        if (r14 == null) goto L15;
        this.n = r14;
        this.o = (ViewGroup) a0().findViewById(2131372771);
        this.p = a0().findViewById(2131376367);
        this.q = (ViewGroup) a0().findViewById(2131371108);
        this.r = a0().findViewById(2131387442);
        this.s = a0().findViewById(2131370751);
        this.t = a0().findViewById(2131370748);
        this.u = a0().findViewById(2131370744);
        this.h.b(ShopContainerType.SHOP_TOPBAR_CONTAINER, new h(this));
    L15:
        vi3.c r15 = this.h.d(r5);
        if (r15 == null) goto L18;
        int r16 = r15.a();
    L19:
        ViewGroup r7 = this.n;
        if (r7 == null) goto L25;
        ViewGroup.LayoutParams r17 = r7.getLayoutParams();
        if (r17 == null) goto L24;
        r17.height = r16;
    L24:
        r7.requestLayout();
    L25:
        p r18 = o0();
        if (r18 == null) goto L28;
        r r19 = r18.i();
    L29:
        if (r19 == null) goto L31;
        Drawable r20 = r19.e;
    L32:
        if (r19 == null) goto L34;
        FrameLayout.LayoutParams r21 = r19.f;
    L36:
        if (r20 == null) goto L41;
        View r22 = this.s;
        if (r22 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("liveTopMask");
    L40:
        qc3.a.e(r22, r20);
    L41:
        if (r21 == null) goto L46;
        View r23 = this.s;
        if (r23 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("liveTopMask");
    L45:
        r23.setLayoutParams(r21);
    L46:
        if (r19 == null) goto L48;
        Drawable r24 = r19.c;
    L49:
        if (r19 == null) goto L51;
        FrameLayout.LayoutParams r25 = r19.d;
    L53:
        if (r24 == null) goto L58;
        View r26 = this.u;
        if (r26 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInfoAreaMask");
    L57:
        qc3.a.e(r26, r24);
    L58:
        if (r25 == null) goto L63;
        View r27 = this.u;
        if (r27 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInfoAreaMask");
    L62:
        r27.setLayoutParams(r25);
    L63:
        if (r19 == null) goto L65;
        Drawable r28 = r19.a;
    L66:
        if (r19 == null) goto L69;
        r6 = r19.b;
    L69:
        if (r28 == null) goto L74;
        View r29 = this.t;
        if (r29 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("bottomGradualMask");
    L73:
        r29.setBackground(r28);
    L74:
        if (r6 == null) goto L79;
        View r30 = this.t;
        if (r30 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("bottomGradualMask");
    L78:
        r30.setLayoutParams(r6);
    L79:
        int r31 = v.a;
        ViewGroup r32 = this.o;
        if (r32 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("liveSceneContainer");
    L82:
        Intrinsics.checkNotNullParameter(r32, "subViewOfFrameLayout");
        ViewParent r33 = r32.getParent();
        if ((r33 instanceof FrameLayout) == true) goto L86;
    L89:
        View r34 = this.r;
        if (r34 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("soundBtn");
    L92:
        r34.setOnClickListener(this);
        ViewGroup r35 = this.q;
        if (r35 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("liveInteractionLayer");
    L95:
        r35.setOnClickListener(this);
        im.b r36 = p0();
        if (r36 == null) goto L100;
        QLiveData r37 = r36.m;
        if (r37 == null) goto L100;
        r37.b(ECQuickUtilKt.a(Y()), new f(this));
    L100:
        p r38 = o0();
        if (r38 == null) goto L110;
        StoreV3LiveRoomVO r39 = r38.h();
        if (r39 == null) goto L110;
        o r40 = n0();
        if (r40 == null) goto L107;
        r40.a(r39);
    L107:
        im.b r41 = p0();
        if (r41 == null) goto L110;
        r41.f = new ECShopLivePreviewPresenter$initHeaderLive$1(this, r39);
    L110:
        e0().addObserver(this);
        p r42 = o0();
        if (r42 != null) goto L113;
    L115:
        r2 = false;
    L116:
        this.l = r2;
        goto L121
    L113:
        if (r42.b() != true) goto L115;
    L86:
        if (((FrameLayout) r33).findViewWithTag("shadowView") != null) goto L89;
        r32.post(new com.bytedance.android.shopping.store.home.view.u(r33, r32));
        goto L89
    L65:
        r28 = null;
        goto L66
    L51:
        r25 = null;
        goto L53
    L48:
        r24 = null;
        goto L49
    L34:
        r21 = null;
        goto L36
    L31:
        r20 = null;
        goto L32
    L28:
        r19 = null;
        goto L29
    L18:
        r16 = 0;
        goto L19
    L118:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L120:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L121:
        p r43 = o0();
        if (r43 == null) goto L127;
        jm.a<ShopLiveState> r44 = r43.e();
        if (r44 == null) goto L128;
        r44.a(h0(), new g(this), false);
        return;
    L128:
        return;
    }

    public final void l0(StoreV3LiveRoomVO r5) {
        if (y0.a() == true) goto L5;
        return;
    L5:
        SimpleDraweeView r0 = this.p;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("liveCover");
    L8:
        r0.setVisibility(0);
        com.bytedance.android.ec.adapter.impl.adapters.reverse.player.d r6 = m0(r5);
        if (r6 != null) goto L11;
        return;
    L11:
        com.bytedance.android.ec.adapter.impl.adapters.reverse.player.d r7 = r6;
        if (r7.a().isPlaying() == false) goto L22;
        r0(r7.a().getLifecycleOwner());
        SimpleDraweeView r8 = this.p;
        if (r8 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("liveCover");
    L16:
        r8.setVisibility(8);
        o r9 = n0();
        if (r9 == null) goto L19;
        r9.d(true);
    L19:
        o r10 = n0();
        if (r10 == null) goto L22;
        r10.e();
    L22:
        int r11 = im.p.a;
        JSONObject r12 = new JSONObject();
        r12.put("author_id", d0().getStoreAccountParam().getUserId());
        p r1 = o0();
        if (r1 == null) goto L27;
        StoreV3LiveRoomVO r2 = r1.h();
        if (r2 == null) goto L27;
        String r3 = r2.getRoomId();
    L28:
        if (r3 != null) goto L30;
        r3 = "";
    L30:
        r12.put("room_id", r3);
        im.b r4 = p0();
        if (r4 == null) goto L35;
        IECLivePlayerClient r13 = r4.c;
        if (r13 == null) goto L35;
        Integer r14 = Integer.valueOf(r13.hashCode());
    L36:
        r12.put("client_code", r14);
        r12.put("store_type", "shop");
        Unit r15 = Unit.INSTANCE;
        JSONObject r16 = new JSONObject();
        Intrinsics.checkNotNullParameter("store_header_live_start", "name");
        int r17 = ECMonitorService.b;
        ECMonitorService.a.a("store_header_live_start", r12, r16, null);
        return;
    L35:
        r14 = null;
    L27:
        r3 = null;
        goto L28
    }

    public final le.b m0(StoreV3LiveRoomVO r14) {
        IECLivePlayerClient r1 = null;
        if (im.k.b() == true) goto L74;
        p r0 = o0();
        if (r0 != null) goto L7;
    L9:
        ViewGroup r2 = this.o;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("liveSceneContainer");
    L12:
        String r15 = r14.getRoomId();
        if (r15 == null) goto L73;
        long r3 = CastLongProtector.parseLong(r15);
        int r16 = ECSdk.a;
        IAdapterService r17 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r17 == null) goto L19;
        IECPlayerViewService r5 = r17.getPlayerViewService();
        if (r5 == null) goto L19;
        com.bytedance.android.ec.adapter.impl.adapters.reverse.player.d r18 = r5.a(Y().c(), null, 0, String.valueOf(r3), "ec_feed_shop", IECPlayerViewService.RenderViewType.SURFACE_VIEW, 1L);
    L20:
        if (r18 == null) goto L73;
        r18.setScaleType(2);
        boolean r4 = false;
        r18.b.setVisibility(0);
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(-1, -1);
        r6.gravity = 17;
        Point r7 = l0.f(Y().c());
        if (r7 == null) goto L28;
        int r8 = r7.x;
        if (r8 <= 0) goto L28;
        r6.width = r8;
        r6.height = (int) ((r8 * 16.0f) / 9.0f);
    L28:
        if (r18.a().isPlaying() == false) goto L44;
        im.b r9 = p0();
        if (r9 != null) goto L81;
    L71:
        r2.removeAllViews();
        r2.addView(r18.b, r6);
        return r18;
    L81:
        r1 = r18.a();     // Catch: Exception -> L33
    L36:
        if (r9.d() == true) goto L71;
        r9.c = r1;
        if (r1 == null) goto L42;
        r1.resumePlay();
    L42:
        if (r9.e() == false) goto L71;
        r9.g();
    L33:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        goto L36
    L44:
        int r10 = im.l.a;
        IAdapterService r11 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r11 == null) goto L51;
        cf.l r12 = (cf.l) ECSdk.a(cf.l.class);
        if (r12 == null) goto L49;
        r4 = r12.za();
    L49:
        if (r4 == false) goto L51;
        r11.muteLiveRoom();
    L51:
        im.b r13 = p0();
        if (r13 == null) goto L71;
        r1 = r18.a();     // Catch: Exception -> L55
    L57:
        String r19 = (String) ECSettingKeys.C().get("ec_feed_shop");
        if (r19 != null) goto L60;
        r19 = (String) ECSettingKeys.B().get("ec_feed_shop");
    L60:
        Function1<LifecycleOwner, Unit> r20 = new ECShopLivePreviewPresenter$createPlayView$2(this);
        r13.c = r1;
        le.a.a r21 = new le.a.a();
        StoreV3LiveRoomVO r22 = r13.d;
        if (r22 == null) goto L64;
        String r23 = r22.getStreamData();
        if (r23 == null) goto L64;
    L65:
        Intrinsics.checkNotNullParameter(r23, "data");
        r21.a = r23;
        if (r19 == null) goto L68;
        Intrinsics.checkNotNullParameter(r19, "resolution");
        r21.b = r19;
    L68:
        ECLiveMode r24 = ECLiveMode.MEDIA;
        Intrinsics.checkNotNullParameter(r24, "streamType");
        r21.c = r24;
        r21.h = r13.e();
        r21.f = true;
        le.a r25 = r21.a();
        if (r1 == null) goto L71;
        r1.stream(r25, r20);
    L64:
        r23 = "";
    L55:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
    L19:
        r18 = null;
    L73:
        return null;
    L7:
        if (r0.c() != true) goto L9;
    L74:
        SimpleDraweeView r110 = this.p;
        if (r110 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("liveCover");
    L77:
        r110.setVisibility(8);
        return null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        p r0 = o0();
        if (r0 == null) goto L5;
        r0.k();
    L5:
        int r1 = kn.a.a;
        if (kn.a.a(r3.getId()) == true) goto L29;
        p r2 = o0();
        if (r2 != null) goto L10;
    L12:
        int r4 = r3.getId();
        if (r4 != 2131387442) goto L24;
        im.b r5 = p0();
        if (r5 != null) goto L17;
        return;
    L17:
        if (r5.e() == false) goto L22;
        IECLivePlayerClient r6 = r5.c;
        if (r6 == null) goto L21;
        r6.unmute();
    L21:
        r5.m.g(Boolean.FALSE);
        return;
    L22:
        r5.g();
        return;
    L24:
        if (r4 != 2131371108) goto L33;
        o r7 = n0();
        if (r7 == null) goto L34;
        r7.i();
        return;
    L34:
        return;
    L33:
        return;
    L10:
        if (r2.a() != true) goto L12;
        return;
    }

    public final void q0(int r7) {
        if (this.w == false) goto L5;
        return;
    L5:
        this.w = true;
        LinkedHashMap r1 = new LinkedHashMap();
        String r2 = d0().getShopId();
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r1.put("shop_id", r2);
        if (this.m == true) goto L17;
        int r3 = com.bytedance.android.ec.store.utils.h.a;
        QContext r4 = Y();
        FragmentActivity r5 = l0.c(r4.c());
        if ((r5 instanceof AbsActivity) == true) goto L13;
        r5 = null;
    L13:
        FragmentActivity r6 = (AbsActivity) r5;
        if (r6 != null) goto L16;
        r6 = r4.a();
    L16:
        com.bytedance.android.ec.store.utils.h.d(hm.c.d(r6), "live_play", null, r1, "shop_window_ad");
        this.m = true;
    L17:
        if (r7 == 0) goto L24;
        if (r7 != 1) goto L20;
        String r8 = "release";
    L25:
        o r0 = n0();
        if (r0 == null) goto L32;
        ViewGroup r9 = this.o;
        if (r9 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("liveSceneContainer");
    L30:
        r0.h(r9, r8);
        return;
    L32:
        return;
    L20:
        if (r7 != 2) goto L24;
        r8 = "draw";
    L24:
        r8 = PinchEnterMethod.CLICK;
        goto L25
    }

    public final void r0(LifecycleOwner r6) {
        im.b r0 = p0();
        if (r0 == null) goto L8;
        Context r1 = Y().c();
        b r2 = this.z;
        Intrinsics.checkNotNullParameter(r6, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "listener");
        IECLivePlayerClient r3 = r0.c;
        if (r3 == null) goto L9;
        td.e r4 = r3.getEventHub();
        r4.getPlayPrepared().observe(r6, new im.d(r6, r2));
        r4.getFirstFrame().observe(r6, new im.e(r6, r2));
        r4.getStopped().observe(r6, new im.f(r6, r2));
        r4.getReleased().observe(r6, new im.g(r6, r2));
        r4.getPlayComplete().observe(r6, new im.h(r6, r2));
        r4.getLiveEnd().observe(r6, new im.i(r0, r6, r2));
        r4.getPlayerMediaError().observe(r6, new im.j(r6, r2));
        return;
    L9:
        return;
    }

    public final void t0(boolean r3) {
        if (r3 == false) goto L4;
        int r4 = 0;
    L5:
        View r0 = this.r;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("soundBtn");
    L9:
        if (r0.getVisibility() == r4) goto L15;
        View r1 = this.r;
        if (r1 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("soundBtn");
    L13:
        r1.setVisibility(r4);
        return;
    L15:
        return;
    L4:
        r4 = 4;
        goto L5
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.preview.q
    public final void O(float r8, int r9, boolean r10, int r11, boolean r12) {
        float r1 = RangesKt.coerceAtLeast(r8, 0.0f);
        boolean r3 = true;
        if ((!Intrinsics.areEqual(r1, this.k)) == false) goto L26;
        if (r1 <= 0.75f) goto L21;
        if (im.k.b() == true) goto L24;
        p r2 = o0();
        if (r2 == null) goto L24;
        if (r2.c() == true) goto L24;
        if (r11 != (-1)) goto L24;
        o r13 = n0();
        if (r13 == null) goto L17;
        StoreUserActionEvent r4 = new StoreUserActionEvent();
        r4.setAction(1);
        Unit r6 = Unit.INSTANCE;
        r13.f(r4);
    L17:
        if (this.l == false) goto L19;
        this.l = false;
        goto L24
    L19:
        a0().post(new i(this));
    L24:
        this.k = Float.valueOf(r1);
        goto L26
    L21:
        if (im.k.b() == false) goto L24;
        if (r11 != 1) goto L24;
        a0().post(new j(this));
    L26:
        if (r1 < 1.0f) goto L28;
        int r5 = 4;
    L29:
        ViewGroup r7 = this.n;
        if (r7 != null) goto L32;
    L33:
        ViewGroup r14 = this.n;
        if (r14 == null) goto L37;
        r14.setVisibility(r5);
    L37:
        if (this.x == true) goto L78;
        Triple r15 = (Triple) this.j.getValue();
        if (r15 == null) goto L78;
        vi3.c r16 = this.h.d(ShopContainerType.LIVE_PREVIEW_CONTAINER);
        if (r16 == null) goto L45;
        int r17 = r16.a();
    L46:
        int r18 = r9 * (-1);
        if (r18 >= com.bytedance.android.shopping.extensions.b.b(2)) goto L49;
        this.w = false;
    L49:
        int r19 = RangesKt.coerceAtLeast(r18, 0);
        if (r19 <= ((Number) r15.getFirst()).intValue()) goto L55;
        if (r19 >= ((Number) r15.getSecond()).intValue()) goto L55;
        int r110 = 2131896859;
    L68:
        int r111 = r110;
        boolean r112 = true;
    L69:
        p r20 = o0();
        if (r20 == null) goto L74;
        jm.b<Pair<String, Boolean>> r21 = r20.d();
        if (r21 == null) goto L74;
        r21.c(new Pair(Y().c().getString(r111), Boolean.valueOf(r112)));
    L74:
        ViewGroup r113 = this.n;
        if (r113 == null) goto L78;
        wg.a.d(r113, r17 + r19);
    L55:
        if (r19 <= ((Number) r15.getSecond()).intValue()) goto L61;
        if (r19 >= ((Number) r15.getThird()).intValue()) goto L61;
        if (r12 == true) goto L65;
        q0(!r10 ? 1 : 0);
        this.x = true;
    L64:
        r112 = false;
    L66:
        r111 = 2131896858;
    L65:
        r112 = true;
    L61:
        if (r19 <= ((Number) r15.getThird()).intValue()) goto L67;
        if (r12 == true) goto L65;
        q0(2);
        this.x = true;
        goto L64
    L67:
        r110 = 2131896856;
        goto L68
    L45:
        r17 = 0;
    L78:
        if (r8 == 0.0f) goto L81;
        r3 = false;
    L81:
        t0(r3);
        if (r8 != 0.0f) goto L84;
    L85:
        this.x = false;
        return;
    L84:
        if (r8 == 1.0f) goto L85;
        return;
    L32:
        if (r7.getVisibility() == r5) goto L37;
    L28:
        r5 = 0;
        goto L29
    }
}
