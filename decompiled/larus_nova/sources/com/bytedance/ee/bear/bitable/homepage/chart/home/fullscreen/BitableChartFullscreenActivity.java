package com.bytedance.ee.bear.bitable.homepage.chart.home.fullscreen;

import android.R;
import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.bitable.homepage.chart.container.JSContextTag;
import com.bytedance.ee.bear.bitable.homepage.chart.entity.ChartEntity;
import com.bytedance.ee.bear.bitable.homepage.chart.widget.chart.ChartItemView;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.StatusBarUtil;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes15.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u0000 x2\u00020\u00012\u00020\u0002:\u0001xB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010]\u001a\u00020^H\u0017J\u0012\u0010_\u001a\u00020`2\b\u0010a\u001a\u0004\u0018\u00010bH\u0014J\b\u0010c\u001a\u00020`H\u0002J\b\u0010d\u001a\u00020`H\u0002J\b\u0010e\u001a\u00020`H\u0002J\b\u0010f\u001a\u00020`H\u0002J\b\u0010g\u001a\u00020`H\u0002J\u0010\u0010h\u001a\u00020`2\u0006\u0010i\u001a\u00020OH\u0016J\b\u0010j\u001a\u00020`H\u0014J\b\u0010k\u001a\u00020`H\u0014J\b\u0010l\u001a\u00020`H\u0014J\u0010\u0010m\u001a\u00020`2\u0006\u0010n\u001a\u00020oH\u0016J\b\u0010p\u001a\u00020`H\u0002J\b\u0010q\u001a\u00020`H\u0002J\b\u0010=\u001a\u00020 H\u0002J\b\u0010r\u001a\u00020`H\u0002J\b\u0010s\u001a\u00020 H\u0002J\b\u0010t\u001a\u00020 H\u0002J\u0010\u0010u\u001a\u00020`2\u0006\u0010v\u001a\u00020oH\u0002J\b\u0010w\u001a\u00020`H\u0002R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u0019\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0013\u001a\u0004\b!\u0010\"R\u001d\u0010$\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0013\u001a\u0004\b%\u0010\"R#\u0010'\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0013\u001a\u0004\b(\u0010\u001dR#\u0010*\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0013\u001a\u0004\b+\u0010\u001dR#\u0010-\u001a\n \u001b*\u0004\u0018\u00010.0.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0013\u001a\u0004\b/\u00100R#\u00102\u001a\n \u001b*\u0004\u0018\u000103038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u0013\u001a\u0004\b4\u00105R#\u00107\u001a\n \u001b*\u0004\u0018\u000108088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u0013\u001a\u0004\b9\u0010:R#\u0010<\u001a\n \u001b*\u0004\u0018\u000108088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u0013\u001a\u0004\b=\u0010:R#\u0010?\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u0013\u001a\u0004\b@\u0010\u001dR#\u0010B\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\u0013\u001a\u0004\bC\u0010\u001dR#\u0010E\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u0013\u001a\u0004\bF\u0010\u001dR#\u0010H\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u0013\u001a\u0004\bI\u0010\u001dR#\u0010K\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u0013\u001a\u0004\bL\u0010\u001dR\u000e\u0010N\u001a\u00020OX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020OX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010Q\u001a\u00020R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010\u0013\u001a\u0004\bS\u0010TR\u001b\u0010V\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\u0013\u001a\u0004\bW\u0010XR\u000e\u0010Z\u001a\u00020OX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020OX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020OX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006y"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/home/fullscreen/BitableChartFullscreenActivity;", "Lcom/bytedance/ee/bear/bitable/homepage/BitableHomepageBaseActivity;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "chartDataFetcher", "Lcom/bytedance/ee/bear/bitable/homepage/chart/datasource/IChartDataFetcher;", "getChartDataFetcher", "()Lcom/bytedance/ee/bear/bitable/homepage/chart/datasource/IChartDataFetcher;", "setChartDataFetcher", "(Lcom/bytedance/ee/bear/bitable/homepage/chart/datasource/IChartDataFetcher;)V", "totalShowDuration", "", "timestampOfLastResume", "chartItemView", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/ChartItemView;", "getChartItemView", "()Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/ChartItemView;", "chartItemView$delegate", "Lkotlin/Lazy;", "chartEntity", "Lcom/bytedance/ee/bear/bitable/homepage/chart/entity/ChartEntity;", "getChartEntity", "()Lcom/bytedance/ee/bear/bitable/homepage/chart/entity/ChartEntity;", "chartEntity$delegate", "rootContainer", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getRootContainer", "()Landroid/view/View;", "rootContainer$delegate", "containerEnv", "", "getContainerEnv", "()Ljava/lang/String;", "containerEnv$delegate", "hpFrom", "getHpFrom", "hpFrom$delegate", "baseInfoLayout", "getBaseInfoLayout", "baseInfoLayout$delegate", "backIv", "getBackIv", "backIv$delegate", "logoIv", "Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;", "getLogoIv", "()Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;", "logoIv$delegate", "chartContainer", "Landroid/widget/FrameLayout;", "getChartContainer", "()Landroid/widget/FrameLayout;", "chartContainer$delegate", "chartTitle", "Landroidx/appcompat/widget/AppCompatTextView;", "getChartTitle", "()Landroidx/appcompat/widget/AppCompatTextView;", "chartTitle$delegate", "baseName", "getBaseName", "baseName$delegate", "templateTag", "getTemplateTag", "templateTag$delegate", "fromText", "getFromText", "fromText$delegate", "moreIcon", "getMoreIcon", "moreIcon$delegate", "orientationTip", "getOrientationTip", "orientationTip$delegate", "orientationTipIcon", "getOrientationTipIcon", "orientationTipIcon$delegate", "contentOrientation", "", "deviceOrientation", "orientationHelper", "Lcom/bytedance/ee/bear/bitable/homepage/chart/home/fullscreen/ChartScreenOrientationHelper;", "getOrientationHelper", "()Lcom/bytedance/ee/bear/bitable/homepage/chart/home/fullscreen/ChartScreenOrientationHelper;", "orientationHelper$delegate", "gapOfBaseInfoElements", "getGapOfBaseInfoElements", "()I", "gapOfBaseInfoElements$delegate", "safePadding", "statusBarHeight", "navigationBarHeight", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "onDoCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setFitSystemWindow", "initChart", "initTitle", "initBaseInfo", "initOrientation", "setRequestedOrientation", "requestedOrientation", "onResume", "onPause", LiveCommonConstants.REASON_ON_DEDTROY, "onLandscapeChanged", "isLandscape", "", "updateViewWhenSizeChanged", "observe", "adjustBaseNameTvWidth", "getSource", "getOpenType", "showOrientationTip", "isNegativeDirection", "hideOrientationTip", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableChartFullscreenActivity extends Hilt_BitableChartFullscreenActivity implements d0c.c {
    public static final /* synthetic */ int I = 0;
    public final Lazy A;
    public int B;
    public int C;
    public final Lazy D;
    public final Lazy E;
    public int F;
    public int G;
    public int H;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Inject
    public com.bytedance.ee.bear.bitable.homepage.chart.datasource.e f212539i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f212540j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f212541k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f212542l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f212543m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f212544n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f212545o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f212546p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f212547q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f212548r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f212549s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f212550t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f212551u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f212552v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f212553w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f212554x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f212555y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f212556z;

    public static final class a {
    }

    public static final class b extends com.bytedance.ee.util.ui.g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableChartFullscreenActivity f212557a;

        public b(BitableChartFullscreenActivity r100) {
            this.f212557a = r100;
        }

        @Override // com.bytedance.ee.util.ui.g.a, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            BitableChartFullscreenActivity r101 = this.f212557a;
            int r102 = BitableChartFullscreenActivity.I;
            r101.M1().setVisibility(8);
        }
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    public final View H1() {
        return (View) this.f212547q.getValue();
    }

    public final ChartEntity I1() {
        return (ChartEntity) this.f212543m.getValue();
    }

    public final ChartItemView K1() {
        return (ChartItemView) this.f212542l.getValue();
    }

    public final String L1() {
        return (String) this.f212545o.getValue();
    }

    public final View M1() {
        return (View) this.f212556z.getValue();
    }

    public final void O1() {
        boolean r100 = this.f212198c;
        int r101 = F1(getWindow()).getWidth();
        int r102 = F1(getWindow()).getHeight();
        if (r102 <= 0) goto L9;
        if (r101 <= 0) goto L9;
        if (r101 <= r102) goto L7;
        r100 = true;
        goto L9
    L7:
        r100 = false;
    L9:
        if (this.f212199d == true) goto L12;
        if (r100 == false) goto L12;
        StatusBarUtil.hideStatusBar(this);
        H1().setVisibility(8);
        ((View) this.f212544n.getValue()).setPadding(RangesKt.coerceAtLeast(this.F, 0), 0, RangesKt.coerceAtLeast(this.F, 0), RangesKt.coerceAtLeast(this.H, 0));
        return;
    L12:
        StatusBarUtil.showStatusBar(this);
        H1().setVisibility(0);
        View r103 = (View) this.f212544n.getValue();
        if (this.B != 9) goto L15;
        int r104 = this.G;
    L17:
        if (this.B != 9) goto L19;
        int r105 = RangesKt.coerceAtLeast(this.F, 0) + RangesKt.coerceAtLeast(this.H, 0);
    L20:
        r103.setPadding(0, r104, 0, r105);
        return;
    L19:
        r105 = RangesKt.coerceAtLeast(this.H, 0);
        goto L20
    L15:
        r104 = RangesKt.coerceAtLeast(this.F, 0);
        goto L17
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.chart.home.fullscreen.Hilt_BitableChartFullscreenActivity, com.bytedance.ee.bear.bitable.homepage.BitableHomepageBaseActivity, com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(BitableChartFullscreenActivity.class.getName()));
    L5:
        super.onDestroy();
        int r100 = com.bytedance.ee.bear.bitable.homepage.chart.c.f212424a;
        ChartEntity r101 = I1();
        long r102 = this.f212540j;
        String r103 = L1();
        String r104 = (String) this.f212546p.getValue();
        Intrinsics.checkNotNullParameter(r101, "entity");
        CoreThreadPool.getBackgroundHandler().post(new com.bytedance.ee.bear.bitable.homepage.chart.d(r101, r103, r104, null, r102));
    }

    public BitableChartFullscreenActivity() {
        this.f212542l = LazyKt.lazy(new BitableChartFullscreenActivity$chartItemView$2(this));
        this.f212543m = LazyKt.lazy(new BitableChartFullscreenActivity$chartEntity$2(this));
        this.f212544n = LazyKt.lazy(new BitableChartFullscreenActivity$rootContainer$2(this));
        this.f212545o = LazyKt.lazy(new BitableChartFullscreenActivity$containerEnv$2(this));
        this.f212546p = LazyKt.lazy(new BitableChartFullscreenActivity$hpFrom$2(this));
        this.f212547q = LazyKt.lazy(new BitableChartFullscreenActivity$baseInfoLayout$2(this));
        this.f212548r = LazyKt.lazy(new BitableChartFullscreenActivity$backIv$2(this));
        this.f212549s = LazyKt.lazy(new BitableChartFullscreenActivity$logoIv$2(this));
        this.f212550t = LazyKt.lazy(new BitableChartFullscreenActivity$chartContainer$2(this));
        this.f212551u = LazyKt.lazy(new BitableChartFullscreenActivity$chartTitle$2(this));
        this.f212552v = LazyKt.lazy(new BitableChartFullscreenActivity$baseName$2(this));
        this.f212553w = LazyKt.lazy(new BitableChartFullscreenActivity$templateTag$2(this));
        this.f212554x = LazyKt.lazy(new BitableChartFullscreenActivity$fromText$2(this));
        this.f212555y = LazyKt.lazy(new BitableChartFullscreenActivity$moreIcon$2(this));
        this.f212556z = LazyKt.lazy(new BitableChartFullscreenActivity$orientationTip$2(this));
        this.A = LazyKt.lazy(new BitableChartFullscreenActivity$orientationTipIcon$2(this));
        this.B = -1;
        this.C = -1;
        this.D = LazyKt.lazy(new BitableChartFullscreenActivity$orientationHelper$2(this));
        this.E = LazyKt.lazy(BitableChartFullscreenActivity$gapOfBaseInfoElements$2.INSTANCE);
        this.F = -1;
        this.G = -1;
        this.H = -1;
    }

    public final void N1() {
        M1().animate().alpha(0.0f).setDuration(200).setListener(new b(this));
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.c(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // com.bytedance.ee.bear.bitable.homepage.chart.home.fullscreen.Hilt_BitableChartFullscreenActivity, com.bytedance.ee.bear.bitable.homepage.BitableHomepageBaseActivity, com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(BitableChartFullscreenActivity.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L45
        if (r103 != null) goto L10;
    L13:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L50;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        ((j) this.D.getValue()).f212575d.disable();
        if (this.f212541k <= 0) goto L6;
        this.f212540j += System.currentTimeMillis() - this.f212541k;
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.BitableHomepageBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        ((j) this.D.getValue()).f212575d.enable();
        this.f212541k = System.currentTimeMillis();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        F1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.BitableHomepageBaseActivity
    public final void D1() {
        O1();
    }

    public static View F1(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity
    public final void B1(Bundle r110) {
        setContentView(com.larus.nova.R.layout.activity_bitable_chart_fullscreen);
        F1(getWindow()).setBackgroundColor(getResources().getColor(com.larus.nova.R.color.bg_body));
        int r100 = 0;
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        Window r111 = getWindow();
        if (r111 == null) goto L5;
        r111.setStatusBarColor(0);
    L5:
        ViewCompat.setOnApplyWindowInsetsListener((ViewGroup) findViewById(R.id.content), new g(this));
        ((FrameLayout) this.f212550t.getValue()).addView(K1(), new FrameLayout.LayoutParams(-1, -1));
        K1().setBackground(null);
        K1().setTagForJsContext(JSContextTag.TAG_FOR_JS_CONTEXT_FULLSCREEN);
        K1().f(this);
        K1().j(I1().getChartTypeEnum());
        ChartItemView r112 = K1();
        ChartItemView.MeasureHeightStrategy r101 = ChartItemView.MeasureHeightStrategy.BY_SYSTEM;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        if (r112.f212659i == r101) goto L9;
        r112.f212659i = r101;
        r112.requestLayout();
    L9:
        ChartItemView r113 = K1();
        Function1<View, Boolean> r102 = new BitableChartFullscreenActivity$initChart$1(this);
        UDButton r103 = r113.f212662l;
        if (r103 == null) goto L12;
        r103.setOnClickListener(new com.bytedance.ee.bear.bitable.homepage.chart.widget.chart.a(r102, r113));
    L12:
        K1().e(ChartItemView.ChartStyle.PAGE);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new BitableChartFullscreenActivity$observe$1(this, null), 3, null);
        String r114 = I1().getChartToken();
        if (r114 == null) goto L23;
        com.bytedance.ee.bear.bitable.homepage.chart.datasource.e r104 = this.f212539i;
        if (r104 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("chartDataFetcher");
        r104 = null;
    L18:
        r104.c(this);
        com.bytedance.ee.bear.bitable.homepage.chart.datasource.e r105 = this.f212539i;
        if (r105 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("chartDataFetcher");
        r105 = null;
    L22:
        r105.d(r114, false, "fullscreen");
    L24:
        ((View) this.f212548r.getValue()).setOnClickListener(new f(this));
        AppCompatTextView r115 = (AppCompatTextView) this.f212551u.getValue();
        String r106 = I1().getChartName();
        String r107 = "";
        if (r106 != null) goto L28;
        r106 = "";
    L28:
        r115.setText(r106);
        H1().addOnLayoutChangeListener(new com.bytedance.ee.bear.bitable.homepage.chart.home.fullscreen.b(this));
        AppCompatTextView r116 = (AppCompatTextView) this.f212552v.getValue();
        String r108 = I1().getBaseName();
        if (r108 != null) goto L31;
    L34:
        boolean r109 = true;
    L35:
        if (r109 == false) goto L37;
        r107 = getResources().getString(com.larus.nova.R.string.Doc_List_UntitledBitable);
        Intrinsics.checkNotNull(r107);
    L41:
        r116.setText(r107);
        View r117 = (View) this.f212553w.getValue();
        if (I1().isTemplate() == false) goto L44;
        int r118 = 0;
    L45:
        r117.setVisibility(r118);
        String r119 = I1().getBaseUrl();
        if (r119 == null) goto L48;
        ((LarkAvatarView) this.f212549s.getValue()).setVisibility(0);
        com.bytedance.ee.bear.bitable.homepage.chart.utils.a.a((LarkAvatarView) this.f212549s.getValue(), r119, null);
    L49:
        H1().setOnClickListener(new c(this));
        int r120 = getResources().getConfiguration().orientation;
        if (r120 != 1) goto L52;
        r100 = 1;
    L55:
        this.B = r100;
        ((View) this.A.getValue()).setOnClickListener(new d(this));
        F1(getWindow()).addOnLayoutChangeListener(new e(this));
        int r121 = com.bytedance.ee.bear.bitable.homepage.chart.c.f212424a;
        ChartEntity r122 = I1();
        String r123 = L1();
        String r124 = (String) this.f212546p.getValue();
        Intrinsics.checkNotNullParameter(r122, "entity");
        CoreThreadPool.getBackgroundHandler().post(new com.bytedance.ee.bear.bitable.homepage.chart.e(r122, r123, r124, null));
        return;
    L52:
        if (r120 == 2) goto L55;
        r100 = -1;
        goto L55
    L48:
        ((LarkAvatarView) this.f212549s.getValue()).setVisibility(8);
        goto L49
    L44:
        r118 = 8;
        goto L45
    L37:
        String r125 = I1().getBaseName();
        if (r125 == null) goto L41;
        r107 = r125;
        goto L41
    L31:
        if (r108.length() == 0) goto L34;
        r109 = false;
        goto L35
    L23:
        K1().h(I1(), null, "fullscreen");
        goto L24
    }

    @Override // android.app.Activity
    public final void setRequestedOrientation(int r100) {
        super.setRequestedOrientation(r100);
        this.B = this.C;
        N1();
    }

    public static final void G1(BitableChartFullscreenActivity r100, boolean r101) {
        View r102 = (View) r100.A.getValue();
        if (r101 == false) goto L5;
        int r103 = 90;
    L6:
        r102.setRotation(r103);
        ViewGroup.LayoutParams r104 = r100.M1().getLayoutParams();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r105 = (ConstraintLayout.LayoutParams) r104;
        int r106 = 0;
        r105.topToTop = 0;
        if (r101 == false) goto L9;
        r105.startToStart = -1;
        r105.endToEnd = 0;
    L11:
        if (r100.f212198c == true) goto L14;
        r106 = UIHelper.dp2px(46.0f);
    L14:
        ((ViewGroup.MarginLayoutParams) r105).topMargin = r106;
        r100.M1().setLayoutParams(r105);
        r100.M1().animate().alpha(1.0f).setDuration(200).setListener(new h(r100));
        return;
    L9:
        r105.startToStart = 0;
        r105.endToEnd = -1;
        goto L11
    L5:
        r103 = -90;
        goto L6
    }
}
