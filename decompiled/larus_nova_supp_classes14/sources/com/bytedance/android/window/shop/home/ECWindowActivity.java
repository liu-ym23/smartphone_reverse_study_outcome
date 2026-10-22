package com.bytedance.android.window.shop.home;

import android.R;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.BtmSDKWrapper;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.common.api.IECPendantStateService;
import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.core.imagex.t;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.ec.window.base.common.activity.ECWindowBaseActivity;
import com.bytedance.android.ec.window.base.dynamicview.common.WindowDynamicViewCache;
import com.bytedance.android.ec.window.base.shop.PrefetchScene;
import com.bytedance.android.ec.window.base.shop.l;
import com.bytedance.android.ec.window.base.view.ECWindowCouponView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.window.shop.WindowLaunchTask;
import com.bytedance.android.window.shop.home.tab.WindowTabFragmentBase;
import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.gyf.barlibrary.ImmersionBar;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/window/shop/home/ECWindowActivity;", "Lcom/bytedance/android/ec/window/base/common/activity/ECWindowBaseActivity;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowActivity extends ECWindowBaseActivity implements QViewModelOwner {
    public static final /* synthetic */ int s = 0;
    public final s83.g l;
    public final Lazy m;
    public long n;
    public final com.bytedance.commerce.base.viewmodel.a o;
    public ImmersionBar p;
    public long q;
    public Object r;

    public static final class a {
    }

    public ECWindowActivity() {
        super(0);
        boolean r0 = ECServiceManager.a;
        this.l = (s83.g) ECServiceManager.c(s83.g.class);
        this.m = LazyKt.lazy(ECWindowActivity$uiManager$2.INSTANCE);
        Function0<ViewModelProvider.Factory> r1 = new ECWindowActivity$viewModel$2(this);
        this.o = new com.bytedance.commerce.base.viewmodel.a(Reflection.getOrCreateKotlinClass(ECWindowViewModel.class), new ECWindowActivity$$special$$inlined$viewModels$1(this), r1);
    }

    public final QUIManager A1() {
        return (QUIManager) this.m.getValue();
    }

    public final ECWindowViewModel B1() {
        return (ECWindowViewModel) this.o.getValue();
    }

    static {
        Lazy r0 = BtmSDKWrapper.a;
        BtmSDKWrapper.c(ECWindowActivity.class, "a1.b7635");
    }

    /* JADX INFO: Removed unreachable split cross block B:57:0x0153 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        overridePendingTransition(0, 2130772248);
        if (TextUtils.isEmpty(B1().getShopParam().getBackUrl()) == true) goto L5;
        p.a.b(this);
    L8:
        int r2 = com.bytedance.android.ec.window.base.utils.i.a;
        com.bytedance.android.ec.window.base.utils.i.c(B1().getEntranceInfoJsonObject(), "stay_page", null, MapsKt.mapOf(TuplesKt.to("duration", String.valueOf(this.n / ECDraweeView.SQUARE))));
        if ((this instanceof ChatWindowActivity) == true) goto L50;
        FLogger r3 = FLogger.a;
        r3.i("ActivityLancet", "finish ".concat(ECWindowActivity.class.getName()));
        long r4 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L51
        if (r6 != null) goto L16;
    L19:
        r5.put(this, Long.valueOf(r4));     // Catch: Throwable -> L51
        monitor-exit(r5);     // Catch: Throwable -> L51
    L48:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L54:
        return;
    L22:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L25;
        r3.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L48
        goto L54
    L25:
        if (isFinishing() == true) goto L28;
        r3.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L48
        goto L54
    L28:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L31;
        r3.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L48
        goto L54
    L31:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L34;
        r3.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L48
        goto L54
    L34:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L37;
        r3.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L48
        goto L54
    L37:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L39;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L48
        goto L54
    L39:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L48
        if (r1 == null) goto L54;
        r1.addFlags(268435456);     // Catch: Throwable -> L48
        r1.addFlags(2097152);     // Catch: Throwable -> L48
        r3.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L48
        startActivity(r1);     // Catch: Throwable -> L45
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L48
        goto L54
    L16:
        if ((r4 - r6.longValue()) >= 800) goto L19;
        monitor-exit(r5);     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        throw th;
    L50:
        return;
    L5:
        if (isTaskRoot() == false) goto L8;
        p.a.c(this);
        goto L8
    }

    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ECWindowActivity.class.getName()));
    L5:
        super.onDestroy();
        boolean r0 = com.bytedance.android.ec.window.base.shop.j.a;
        Intrinsics.checkNotNullParameter(this, "context");
        Intrinsics.checkNotNullParameter("window", "pageId");
        int r1 = ECSdk.a;
        IECUserTrackerService r2 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r2 == null) goto L8;
        r2.leavePage(new of.b(this, "window", false, null, 28));
    L8:
        int r3 = com.bytedance.android.ec.window.base.utils.i.a;
        com.bytedance.android.ec.window.base.utils.i.d(B1().getEntranceInfoJsonObject(), "landing_page", "button", 8);
        A1().r(com.bytedance.android.window.shop.home.module.h.class);
        ImmersionBar r4 = this.p;
        if (r4 == null) goto L11;
        r4.destroy();
    L11:
        s83.c r5 = this.l.D();
        if (r5 == null) goto L14;
        r5.e(this);
    L14:
        this.r = null;
        ConcurrentHashMap<Long, com.bytedance.android.window.shop.lifecycle.f> r6 = com.bytedance.android.window.shop.lifecycle.c.a;
        com.bytedance.android.window.shop.lifecycle.c.c(B1().getShopParam().getLifecycleMonitorId());
        if (com.bytedance.android.ec.window.base.utils.g.b.size() <= 0) goto L17;
        ((ArrayList) com.bytedance.android.ec.window.base.utils.g.a).add(com.bytedance.android.ec.window.base.utils.g.b);
    L17:
        List r7 = com.bytedance.android.ec.window.base.utils.g.a;
        ArrayList r8 = (ArrayList) r7;
        if (r8.size() <= 0) goto L23;
        if (com.bytedance.android.ec.window.base.utils.g.b.size() <= 0) goto L23;
        ListProtector.remove(r7, r8.size() - 1);
    L23:
        if (r8.size() <= 0) goto L27;
        List r9 = (List) CollectionsKt.getOrNull(r7, r8.size() - 1);
        if (r9 == null) goto L27;
        com.bytedance.android.ec.window.base.utils.g.b = r9;
    L27:
        t.c(this);
        ConcurrentHashMap r10 = l.a;
        PrefetchScene r11 = PrefetchScene.WINDOW;
        Intrinsics.checkNotNullParameter(r11, "scene");
        ConcurrentHashMap r12 = (ConcurrentHashMap) l.a.get(r11);
        if (r12 == null) goto L30;
        r12.clear();
    L30:
        com.bytedance.android.window.shop.home.tab.h.a.clear();
        com.bytedance.android.ec.sdk.helper.c r13 = com.bytedance.android.ec.sdk.helper.c.a;
        r13.b("WINDOW", "[onDestroy]entranceInfo:" + B1().getEntranceInfo());
        r13.b("WINDOW", "[onDestroy]secAuthorId:" + B1().getShopParam().getSecAuthorId());
        IECPendantStateService r14 = (IECPendantStateService) ECSdk.a(IECPendantStateService.class);
        if (r14 == null) goto L36;
        cf.f r15 = r14.getPendantStateListener("XiguaPendant");
        if (r15 == null) goto L37;
        B1().getShopParam().getAuthorId();
        r15.onDestroy();
        return;
    L37:
        return;
    }

    public final void onBackPressed() {
        Function1<hp3.b, Boolean> r0 = B1().getEventDeliverer();
        if (r0 == null) goto L8;
        if (((Boolean) r0.invoke(lp3.a.b)).booleanValue() == false) goto L10;
        return;
    L10:
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        return;
    L8:
        if (B1().getPendingTaskViewModel().a() == false) goto L10;
    }

    public final void onPause() {
        super/*com.bytedance.ies.uikit.base.AbsActivity*/.onPause();
        B1().doAnyEventActionWithBtm("a1.b7635.c0.d0", PageFinder.via(A1().p()), "stay_store_page", MapsKt.mapOf(TuplesKt.to("duration", String.valueOf(SystemClock.elapsedRealtime() - this.q))), new Pair[0]);
        int r0 = ECSdk.a;
        IECPendantStateService r1 = (IECPendantStateService) ECSdk.a(IECPendantStateService.class);
        if (r1 == null) goto L7;
        cf.f r2 = r1.getPendantStateListener("XiguaPendant");
        if (r2 == null) goto L7;
        B1().getShopParam().getAuthorId();
        r2.onHide();
    L7:
        this.n += SystemClock.elapsedRealtime() - this.q;
        this.q = SystemClock.elapsedRealtime();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onResume() {
        super/*com.bytedance.ies.uikit.base.AbsActivity*/.onResume();
        boolean r0 = com.bytedance.android.ec.window.base.shop.j.a;
        Intrinsics.checkNotNullParameter(this, "context");
        Intrinsics.checkNotNullParameter("window", "pageId");
        if (com.bytedance.android.ec.window.base.shop.j.a == false) goto L5;
        com.bytedance.android.ec.window.base.shop.j.a(this, true, null);
    L5:
        this.q = SystemClock.elapsedRealtime();
        B1().getLiveManager().getClass();
        int r1 = ECSdk.a;
        IECPendantStateService r2 = (IECPendantStateService) ECSdk.a(IECPendantStateService.class);
        if (r2 == null) goto L11;
        cf.f r3 = r2.getPendantStateListener("XiguaPendant");
        if (r3 == null) goto L12;
        B1().getShopParam().getAuthorId();
        r3.onShow();
        return;
    L12:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*com.bytedance.ies.uikit.base.AbsActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y1() {
        super/*com.bytedance.ies.uikit.base.AbsActivity*/.y1();
        if (this.p != null) goto L5;
        this.p = ImmersionBar.with(this);
    L5:
        ImmersionBar r0 = this.p;
        if (r0 == null) goto L11;
        ImmersionBar r1 = r0.statusBarDarkFont(true);
        if (r1 == null) goto L12;
        r1.init();
        return;
    L12:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        s83.c r0 = this.l.D();
        if (r0 == null) goto L6;
        r0.f();
    L6:
        return super/*android.app.Activity*/.dispatchTouchEvent(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r10) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L233
    L6:
        if (v19.f.f(this) == false) goto L8;
        v19.f.c(getTheme());     // Catch: Throwable -> L233
    L8:
        overridePendingTransition(2130772245, 2130772253);
        ph.a.a(this);
        fo.a<WindowLayoutType> r0 = WindowConstDef.a;
        if (((Boolean) WindowConstDef.g.getValue()).booleanValue() == false) goto L11;
        z1().a().c(2131561032, ((Number) WindowConstDef.l.getValue()).intValue(), "ec_window_layout_hybrid_list").commit();
    L11:
        int r1 = 1;
    L13:
        if (r1 >= 3) goto L15;
        com.bytedance.android.ec.opt.asyncInflate.d r3 = z1().a();
        r3.c(2131561030, 2, "ec_window_layout_holder_product_single");
        r3.c(2131561025, 3, "ec_shop_layout_holder_shopwindow_product");
        r3.commit();
        r1 = r1 + 1;
        goto L13
    L15:
        getLifecycle().addObserver(WindowDynamicViewCache.g);
        B1().runLowPriorityTask(new ECWindowActivity$asyncInflateItemCard$2(this));
        super/*com.bytedance.ies.uikit.base.AbsActivity*/.onCreate(r10);
        Lazy r11 = BtmSDKWrapper.a;
        Intent r12 = getIntent();
        String r2 = null;
        if (r12 == null) goto L20;
        Uri r13 = r12.getData();
        if (r13 == null) goto L20;
        String r14 = UriProtector.getQueryParameter(r13, "source_btm_token");
    L21:
        BtmSDKWrapper.a(this, "a1.b7635", r14);
        t.b(this, B1().getImageCallerContext());
        Intent r15 = getIntent();
        if (r15 == null) goto L24;
        Serializable r16 = r15.getSerializableExtra("shop_param");
    L26:
        if ((r16 instanceof ECWindowParam) == true) goto L28;
        r16 = null;
    L28:
        ECWindowParam r17 = (ECWindowParam) r16;
        if (r17 == null) goto L217;
        ConcurrentHashMap<Long, com.bytedance.android.window.shop.lifecycle.f> r4 = com.bytedance.android.window.shop.lifecycle.c.a;
        com.bytedance.android.window.shop.lifecycle.f r5 = com.bytedance.android.window.shop.lifecycle.c.a(r17.getLifecycleMonitorId());
        if (r5 == null) goto L33;
        r5.o(this, r17);
    L33:
        B1().init(r17, getIntent().getData(), xn.c.d(this));
        com.bytedance.android.ec.window.base.common.taskgraph.b<?> r18 = B1().getPipeline();
        if (r18 == null) goto L36;
        r18.b(WindowLaunchTask.b, Unit.INSTANCE);
    L36:
        B1().appendEventParams(new Pair[]{TuplesKt.to("icon_page", CommentServiceId.HOT_SPOT)});
        B1().loadHeaderInfo();
        if (((Boolean) WindowConstDef.k.getValue()).booleanValue() == false) goto L39;
        View r19 = th.a.d(this, 2131560376, null, 6);
    L40:
        ViewGroup r6 = (ViewGroup) r19.findViewById(2131370968);
        if (r6.getChildCount() <= 0) goto L44;
        r6.removeAllViews();
    L44:
        if (zq3.l.b() == false) goto L46;
        th.a.c(r6.getContext(), 2131561046, r6, true);
    L47:
        com.bytedance.android.ec.window.base.utils.quick.d.a(A1(), new com.bytedance.android.window.shop.home.module.h(r19, false, false, new ECWindowActivity$onCreate$$inlined$let$lambda$1(this)), this, null);
        setContentView(A1().p());
        if (((Boolean) WindowConstDef.j.getValue()).booleanValue() == true) goto L216;
        Single.fromCallable(new d(this)).subscribeOn(Schedulers.io()).subscribe();
        ECWindowViewModel r110 = B1();
        r110.addAllDisposable(r110.getTagPools().b(TextView.class, new ECWindowActivity$preloadTagView$textDisposableList$1(this)));
        r110.addAllDisposable(r110.getTagPools().b(ECWindowCouponView.class, new ECWindowActivity$preloadTagView$couponDisposableList$1(this)));
        int r111 = yq3.a.a;
        int r112 = n.a;
        Object r7 = 0;
        int r8 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L204
        Object r20 = com.bytedance.android.ec.base.settings.d.c.get("window_opt_fragment_pre_create");     // Catch: Throwable -> L100
        if (r20 != null) goto L55;
    L97:
        Object r21 = null;
    L98:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L100
    L102:
        Throwable r23 = Result.exceptionOrNull-impl(r22);     // Catch: Throwable -> L204
        if (r23 == null) goto L106;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L204
    L106:
        if (Result.isFailure-impl(r22) == false) goto L109;
        r22 = null;
    L109:
        if ((r22 instanceof Integer) == true) goto L111;
        r22 = null;
    L111:
        Object r24 = (Integer) r22;     // Catch: Throwable -> L204
        if (r24 != null) goto L118;
        Object r25 = com.bytedance.android.ec.base.settings.d.a.get("window_opt_fragment_pre_create");     // Catch: Throwable -> L204
        if ((r25 instanceof Integer) == true) goto L117;
        r25 = null;
    L117:
        r24 = (Integer) r25;     // Catch: Throwable -> L204
    L118:
        if (r24 != null) goto L214;
        int r26 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L204
        Object r27 = com.bytedance.android.ec.base.settings.d.c.get("window_opt_fragment_pre_create");     // Catch: Throwable -> L170
        if (r27 != null) goto L125;
    L167:
        Object r28 = null;
    L168:
        Object r29 = Result.constructor-impl(r28);     // Catch: Throwable -> L170
    L172:
        Throwable r30 = Result.exceptionOrNull-impl(r29);     // Catch: Throwable -> L195
        if (r30 == null) goto L176;
        EnsureManager.ensureNotReachHere(r30);     // Catch: Throwable -> L195
    L176:
        if (Result.isFailure-impl(r29) == false) goto L179;
        r29 = null;
    L179:
        if ((r29 instanceof Integer) == true) goto L181;
        r29 = null;
    L181:
        r24 = (Integer) r29;     // Catch: Throwable -> L195
        if (r24 != null) goto L202;
        IHybridHostService r31 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L195
        if (r31 == null) goto L187;
        Object r32 = r31.getHostABValue("window_opt_fragment_pre_create", r7);     // Catch: Throwable -> L195
    L188:
        if (r32 != null) goto L190;
    L201:
        r24 = r7;
        goto L202
    L190:
        if ((r32 instanceof Integer) == true) goto L192;
        r32 = null;
    L192:
        r24 = (Integer) r32;     // Catch: Throwable -> L195
        if (r24 != null) goto L202;
    L195:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L204
        r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L204
        Throwable r34 = Result.exceptionOrNull-impl(r24);     // Catch: Throwable -> L204
        if (r34 == null) goto L200;
        EnsureManager.ensureNotReachHere(r34);     // Catch: Throwable -> L204
    L200:
        if (Result.isFailure-impl(r24) == false) goto L202;
    L187:
        r32 = null;
    L202:
        com.bytedance.android.ec.base.settings.d.d("window_opt_fragment_pre_create", r24);     // Catch: Throwable -> L204
        goto L214
    L125:
        if ((r27 instanceof Integer) == true) goto L127;
        Object r35 = null;
    L128:
        r28 = (Integer) r35;     // Catch: Throwable -> L170
        if (r28 != null) goto L168;
        if ((r27 instanceof Number) == false) goto L155;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L140;
        Float r36 = Float.valueOf(((Number) r27).floatValue());     // Catch: Throwable -> L170
        if ((r36 instanceof Integer) == true) goto L138;
        r36 = null;
    L138:
        r28 = (Integer) r36;     // Catch: Throwable -> L170
        goto L168
    L140:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L146;
        Double r37 = Double.valueOf(((Number) r27).doubleValue());     // Catch: Throwable -> L170
        if ((r37 instanceof Integer) == true) goto L144;
        r37 = null;
    L144:
        r28 = (Integer) r37;     // Catch: Throwable -> L170
        goto L168
    L146:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L149;
        r28 = Integer.valueOf(((Number) r27).intValue());     // Catch: Throwable -> L170
        goto L168
    L149:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L155;
        Long r38 = Long.valueOf(((Number) r27).longValue());     // Catch: Throwable -> L170
        if ((r38 instanceof Integer) == true) goto L153;
        r38 = null;
    L153:
        r28 = (Integer) r38;     // Catch: Throwable -> L170
    L155:
        if ((r27 instanceof JSONObject) == false) goto L157;
    L236:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L163
        Object r39 = SDKSettingsCacheManager.a().fromJson(r27.toString(), Integer.class);     // Catch: Throwable -> L163
        if ((r39 instanceof Integer) == true) goto L161;
        r39 = null;
    L161:
        Object r40 = Result.constructor-impl((Integer) r39);     // Catch: Throwable -> L163
    L165:
        r28 = r40;
        if (Result.isFailure-impl(r28) == false) goto L168;
    L163:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L170
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L170
        goto L165
    L157:
        if ((r27 instanceof JSONArray) == false) goto L167;
    L127:
        r35 = r27;
    L170:
        th = move-exception;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L195
        r29 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L195
    L214:
        if (((Number) r24).intValue() != 1) goto L216;
        ECWindowViewModel r113 = B1();
        CopyOnWriteArrayList<WindowTabFragmentBase> r43 = com.bytedance.android.window.shop.home.tab.h.a;
        long r44 = r113.getShopParam().getLifecycleMonitorId();
        CopyOnWriteArrayList<WindowTabFragmentBase> r114 = com.bytedance.android.window.shop.home.tab.h.a;
        int r45 = WindowTabFragmentBase.g;
        r114.add(WindowTabFragmentBase.a.a("0", "", r44, true, 100));
        goto L216
    L55:
        if ((r20 instanceof Integer) == true) goto L57;
        Object r46 = null;
    L58:
        r21 = (Integer) r46;     // Catch: Throwable -> L100
        if (r21 != null) goto L98;
        if ((r20 instanceof Number) == false) goto L85;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L70;
        Float r47 = Float.valueOf(((Number) r20).floatValue());     // Catch: Throwable -> L100
        if ((r47 instanceof Integer) == true) goto L68;
        r47 = null;
    L68:
        r21 = (Integer) r47;     // Catch: Throwable -> L100
        goto L98
    L70:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L76;
        Double r48 = Double.valueOf(((Number) r20).doubleValue());     // Catch: Throwable -> L100
        if ((r48 instanceof Integer) == true) goto L74;
        r48 = null;
    L74:
        r21 = (Integer) r48;     // Catch: Throwable -> L100
        goto L98
    L76:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L79;
        r21 = Integer.valueOf(((Number) r20).intValue());     // Catch: Throwable -> L100
        goto L98
    L79:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L85;
        Long r49 = Long.valueOf(((Number) r20).longValue());     // Catch: Throwable -> L100
        if ((r49 instanceof Integer) == true) goto L83;
        r49 = null;
    L83:
        r21 = (Integer) r49;     // Catch: Throwable -> L100
    L85:
        if ((r20 instanceof JSONObject) == false) goto L87;
    L234:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L93
        Object r50 = SDKSettingsCacheManager.a().fromJson(r20.toString(), Integer.class);     // Catch: Throwable -> L93
        if ((r50 instanceof Integer) == true) goto L91;
        r50 = null;
    L91:
        Object r51 = Result.constructor-impl((Integer) r50);     // Catch: Throwable -> L93
    L95:
        r21 = r51;
        if (Result.isFailure-impl(r21) == false) goto L98;
    L93:
        th = move-exception;
        Result.Companion r52 = Result.Companion;     // Catch: Throwable -> L100
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L100
        goto L95
    L87:
        if ((r20 instanceof JSONArray) == false) goto L97;
    L57:
        r46 = r20;
    L100:
        th = move-exception;
        Result.Companion r53 = Result.Companion;     // Catch: Throwable -> L204
        r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L204
    L204:
        th = move-exception;
        Result.Companion r54 = Result.Companion;
        Object r115 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r55 = Result.exceptionOrNull-impl(r115);
        if (r55 == null) goto L209;
        EnsureManager.ensureNotReachHere(r55);
    L209:
        if (Result.isFailure-impl(r115) == true) goto L212;
        r7 = r115;
    L212:
        r24 = r7;
    L216:
        A1().c(com.bytedance.android.window.shop.home.module.h.class, null);
        goto L217
    L46:
        th.a.c(r6.getContext(), 2131561045, r6, true);
        goto L47
    L39:
        r19 = com.bytedance.android.ec.opt.asyncInflate.c.a(z1(), 2131560376, null, 6);
    L217:
        B1().getShopParam().setBtmPageId(BtmSDK.INSTANCE.getPageId(PageFinder.via(this)));
        s83.c r116 = this.l.D();
        if (r116 == null) goto L220;
        r116.b(this);
    L220:
        this.r = null;
        com.bytedance.android.ec.sdk.helper.c r117 = com.bytedance.android.ec.sdk.helper.c.a;
        r117.b("WINDOW", "[onCreate]entranceInfo:" + B1().getEntranceInfo());
        r117.b("WINDOW", "[onCreate]secAuthorId:" + B1().getShopParam().getSecAuthorId());
        Map r118 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("author_id", B1().getShopParam().getAuthorId())});
        String r56 = B1().getShopParam().getBcm();
        if (r56 == null) goto L225;
        JSONObject r57 = com.bytedance.android.ec.hybrid.list.util.k.c(r56);
        if (r57 == null) goto L225;
        r2 = r57.optString("bcm_share_id");
    L225:
        if (r2 == null) goto L227;
        r118.put("bcm_share_id", r2);
    L227:
        View r58 = A1().p();
        Intrinsics.checkNotNullParameter(r58, "view");
        Intrinsics.checkNotNullParameter("page_show", "bcmEventName");
        Intrinsics.checkNotNullParameter(r118, "params");
        BcmParams r59 = new BcmParams();
        Iterator r119 = r118.entrySet().iterator();
    L229:
        if (r119.hasNext() == false) goto L231;
        Map.Entry r60 = (Map.Entry) r119.next();
        r59.put((String) r60.getKey(), r60.getValue());
        goto L229
    L231:
        com.bytedance.android.bcm.api.b.e(PageFinder.via(r58), "page_show", r59);
        return;
    L24:
        r16 = null;
    L20:
        r14 = null;
        goto L21
    }
}
