package com.larus.login.impl.loginfragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.LoginPlatform;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.login.api.BdauthService;
import com.larus.login.api.TouristManager;
import com.larus.login.impl.databinding.LarusAccountLoginPageBinding;
import com.larus.login.impl.view.TouristTipLayout;
import com.larus.nova.R;
import com.larus.platform.service.e2;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.LynxError;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.spi.login.ObricLoginDelegate;
import com.optimize.statistics.FrescoTraceListener;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import v19.i5;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000§\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001(\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0001`B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u0011H\u0002J&\u0010*\u001a\u0004\u0018\u00010\u00112\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020$H\u0002J\u001a\u00102\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00112\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0010\u00103\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0011H\u0002J\b\u0010?\u001a\u00020$H\u0002JB\u0010@\u001a\u00020$2\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020\u00152\b\u0010D\u001a\u0004\u0018\u0001052\b\u0010E\u001a\u0004\u0018\u0001052\b\u0010F\u001a\u0004\u0018\u00010G2\b\u0010H\u001a\u0004\u0018\u000105H\u0016J\u0010\u0010I\u001a\u00020$2\u0006\u0010J\u001a\u00020KH\u0002J\b\u0010L\u001a\u00020$H\u0002J\u0010\u0010M\u001a\u00020$2\u0006\u0010N\u001a\u00020KH\u0016J\b\u0010O\u001a\u00020$H\u0016J\b\u0010P\u001a\u00020$H\u0016J\b\u0010Q\u001a\u00020$H\u0016J\b\u0010R\u001a\u00020$H\u0016J\b\u0010S\u001a\u00020$H\u0016J\u001c\u0010T\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010\u00112\b\u0010U\u001a\u0004\u0018\u00010VH\u0002J\b\u0010W\u001a\u00020$H\u0002J\b\u0010X\u001a\u00020\u0006H\u0016J\b\u0010Y\u001a\u000205H\u0016J\b\u0010Z\u001a\u00020$H\u0002J\b\u0010[\u001a\u00020$H\u0002J\u0012\u0010\\\u001a\u0004\u0018\u00010]2\u0006\u0010^\u001a\u000205H\u0002J\n\u0010_\u001a\u0004\u0018\u00010]H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b \u0010!R\u0010\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)R\u001d\u00104\u001a\u0004\u0018\u0001058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u001d\u001a\u0004\b6\u00107R\u001d\u00109\u001a\u0004\u0018\u0001058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u001d\u001a\u0004\b:\u00107R\u001d\u0010<\u001a\u0004\u0018\u0001058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u001d\u001a\u0004\b=\u00107¨\u0006a"}, d2 = {"Lcom/larus/login/impl/loginfragment/AccountLoginFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/login/impl/loginfragment/INoLoginCallback;", "<init>", "()V", "mAlreadyReportFirstFrame", "", "binding", "Lcom/larus/login/impl/databinding/LarusAccountLoginPageBinding;", "mAnimator", "Landroid/animation/AnimatorSet;", "animatorInputIcon", "animatorTitleDrawable", "Lcom/facebook/fresco/animation/drawable/AnimatedDrawable2;", "animatorTitleRestartRunnable", "Ljava/lang/Runnable;", "animatorTitleView", "Landroid/view/View;", "animatorTitleGapMs", "", "animatorTitleLastDrawFrame", "", "animatorTitleSawLastFrameInCycle", "animatorTitleCycleStopPosted", "triggerSceneData", "Lcom/larus/login/impl/loginfragment/TriggerLoginSceneData;", "getTriggerSceneData", "()Lcom/larus/login/impl/loginfragment/TriggerLoginSceneData;", "triggerSceneData$delegate", "Lkotlin/Lazy;", "loginController", "Lcom/larus/login/impl/loginfragment/AccountLoginController;", "getLoginController", "()Lcom/larus/login/impl/loginfragment/AccountLoginController;", "loginController$delegate", "stopAndScheduleAnimatorTitleNextRound", "", "drawable", "view", "loginStatusCallback", "com/larus/login/impl/loginfragment/AccountLoginFragment$loginStatusCallback$1", "Lcom/larus/login/impl/loginfragment/AccountLoginFragment$loginStatusCallback$1;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initDebugTool", "onViewCreated", "bindFirstFeedShowView", "tvNoLoginFeedbackStrDefault", "", "getTvNoLoginFeedbackStrDefault", "()Ljava/lang/String;", "tvNoLoginFeedbackStrDefault$delegate", "tvNoLoginFeedbackStrNew", "getTvNoLoginFeedbackStrNew", "tvNoLoginFeedbackStrNew$delegate", "tvNoLoginUseDirectlyStr", "getTvNoLoginUseDirectlyStr", "tvNoLoginUseDirectlyStr$delegate", "updateNoLoginUseDirectlyEntry", "onLoginFailed", "platform", "Lcom/larus/account/base/model/LoginPlatform;", "errorCode", "errorMessage", "businessScene", LynxError.LYNX_THROWABLE, "", "profileKey", "adaptViewWidthForPad", "configuration", "Landroid/content/res/Configuration;", "setupDraweeViewRatio", "onConfigurationChanged", "newConfig", "onResume", "onPause", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "onDestroyView", "setupAnimatorTitleAnimation", "animatable", "Landroid/graphics/drawable/Animatable;", "clearAnimatorTitleAnimation", "autoLogEnterPage", "getCurrentPageName", "showTitle", "showInputIcon", "getAnimator", "Landroid/animation/ValueAnimator;", "accountTitle", "getDelayAnimator", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AccountLoginFragment extends TraceFragment implements l1 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f357894v = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f357895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LarusAccountLoginPageBinding f357896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AnimatorSet f357897g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AnimatorSet f357898h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AnimatedDrawable2 f357899i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public q0 f357900j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f357901k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f357902l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f357903m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f357904n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f357905o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f357906p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f357907q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final b f357908r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f357909s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f357910t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f357911u;

    public static final class a {
    }

    public static final class b implements n38.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccountLoginFragment f357912a;

        @Override // n38.j
        public final void a(n38.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        public b(AccountLoginFragment r100) {
            this.f357912a = r100;
        }

        @Override // n38.j
        public final void b(n38.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            if (Intrinsics.areEqual(r100.f516981d, "authorized") == true) goto L5;
            return;
        L5:
            List<Activity> r101 = AppHost.f326268a.a().g();
            FragmentActivity r102 = this.f357912a.getActivity();
            if (r102 == null) goto L8;
            r102.setResult(200, new Intent().putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("login_result", 1)})));
        L8:
            FragmentActivity r103 = this.f357912a.getActivity();
            if (r103 == null) goto L11;
            r103.finish();
        L11:
            Iterator<T> r104 = r101.iterator();
        L13:
            if (r104.hasNext() == false) goto L17;
            Activity r105 = (Activity) r104.next();
            if (BdauthService.f356936a.a(r105) == true) goto L13;
            r105.finish();
            goto L13
        }
    }

    public static final class c extends BaseControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccountLoginFragment f357913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SimpleDraweeView f357914b;

        public c(AccountLoginFragment r100, SimpleDraweeView r101) {
            this.f357913a = r100;
            this.f357914b = r101;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            Intrinsics.checkNotNullParameter(r100, "id");
            super.onFinalImageSet(r100, (ImageInfo) r101, r102);
            if (this.f357913a.isAdded() == true) goto L6;
            return;
        L6:
            if (this.f357913a.getViewLifecycleOwner().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L19;
            SimpleDraweeView r103 = this.f357914b;
            if (r103 == null) goto L13;
            boolean r104 = true;
            if (r103.isAttachedToWindow() != true) goto L13;
        L14:
            if (r104 == false) goto L20;
            AccountLoginFragment r105 = this.f357913a;
            SimpleDraweeView r106 = this.f357914b;
            int r107 = AccountLoginFragment.f357894v;
            r105.X90(r106, r102);
            return;
        L20:
            return;
        L13:
            r104 = false;
            goto L14
        }
    }

    public static final class d implements k1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccountLoginFragment f357915a;

        @Override // com.larus.login.impl.loginfragment.k1
        public final ViewGroup a() {
            LarusAccountLoginPageBinding r100 = this.f357915a.f357896f;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.f357436m;
        }

        @Override // com.larus.login.impl.loginfragment.k1
        public final LinearLayout b() {
            LarusAccountLoginPageBinding r100 = this.f357915a.f357896f;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.f357434k;
        }

        @Override // com.larus.login.impl.loginfragment.k1
        public final ConstraintLayout c() {
            LarusAccountLoginPageBinding r100 = this.f357915a.f357896f;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.f357429f;
        }

        @Override // com.larus.login.impl.loginfragment.k1
        public final TouristTipLayout d() {
            LarusAccountLoginPageBinding r100 = this.f357915a.f357896f;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.f357443t;
        }

        @Override // com.larus.login.impl.loginfragment.k1
        public final CheckBox e() {
            LarusAccountLoginPageBinding r100 = this.f357915a.f357896f;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.f357441r;
        }

        @Override // com.larus.login.impl.loginfragment.k1
        public final ConstraintLayout f() {
            LarusAccountLoginPageBinding r100 = this.f357915a.f357896f;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.f357431h;
        }

        @Override // com.larus.login.impl.loginfragment.k1
        public final ImageView g() {
            LarusAccountLoginPageBinding r100 = this.f357915a.f357896f;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.f357435l;
        }

        @Override // com.larus.login.impl.loginfragment.k1
        public final TextView h() {
            LarusAccountLoginPageBinding r100 = this.f357915a.f357896f;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.f357445v;
        }

        @Override // com.larus.login.impl.loginfragment.k1
        public final View i() {
            LarusAccountLoginPageBinding r100 = this.f357915a.f357896f;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.f357430g;
        }

        @Override // com.larus.login.impl.loginfragment.k1
        public final View j() {
            LarusAccountLoginPageBinding r100 = this.f357915a.f357896f;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.f357433j;
        }

        @Override // com.larus.login.impl.loginfragment.k1
        public final LinearLayout k() {
            LarusAccountLoginPageBinding r100 = this.f357915a.f357896f;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.f357442s;
        }

        @Override // com.larus.login.impl.loginfragment.k1
        public final TextView l() {
            LarusAccountLoginPageBinding r100 = this.f357915a.f357896f;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.f357444u;
        }

        @Override // com.larus.login.impl.loginfragment.k1
        public final UrlSpanTextView m() {
            LarusAccountLoginPageBinding r100 = this.f357915a.f357896f;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.f357439p;
        }

        public d(AccountLoginFragment r100) {
            this.f357915a = r100;
        }
    }

    public static final class e implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f357916a;

        public e(t0 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f357916a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f357916a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f357916a.invoke(r100);
        }
    }

    static {
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public final boolean S90() {
        return false;
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "login_home";
    }

    public final void V90() {
        View r100 = this.f357901k;
        q0 r101 = this.f357900j;
        if (r101 == null) goto L6;
        if (r100 == null) goto L6;
        r100.removeCallbacks(r101);
    L6:
        this.f357900j = null;
        AnimatedDrawable2 r102 = this.f357899i;
        if (r102 == null) goto L9;
        r102.setDrawListener(null);
    L9:
        AnimatedDrawable2 r103 = this.f357899i;
        if (r103 == null) goto L12;
        r103.setAnimationListener(null);
    L12:
        AnimatedDrawable2 r104 = this.f357899i;
        if (r104 == null) goto L15;
        r104.stop();
    L15:
        this.f357899i = null;
        this.f357901k = null;
    }

    public final void Y90() {
        Lazy r100 = uj9.d.f550448a;
        if (uj9.d.f550449b != 2) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
    L12:
        LarusAccountLoginPageBinding r102 = this.f357896f;
        if (r102 == null) goto L25;
        SimpleDraweeView r103 = r102.f357428e;
        if (r103 == null) goto L26;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r105 = (ConstraintLayout.LayoutParams) r104;
        int r106 = getResources().getConfiguration().orientation;
        if (r106 == 1) goto L21;
        if (r106 == 2) goto L20;
        r105.dimensionRatio = "H,830:500";
    L22:
        r103.setLayoutParams(r105);
        return;
    L20:
        Resources r107 = getResources();
        ((ViewGroup.MarginLayoutParams) r105).height = (int) (WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()).heightPixels * 0.4f);
        r105.dimensionRatio = null;
        goto L22
    L21:
        r105.dimensionRatio = "H,830:500";
        r105.matchConstraintMaxWidth = 0;
        goto L22
    L26:
        return;
    L25:
        return;
    L11:
        if (uj9.d.d() == true) goto L12;
        return;
    L5:
        if (uj9.d.b() == 2) goto L8;
        r101 = false;
        goto L9
    }

    public AccountLoginFragment() {
        this.f357902l = 1000;
        this.f357903m = -1;
        this.f357906p = LazyKt.lazy(new w0(this));
        this.f357907q = LazyKt.lazy(new x0(this));
        this.f357908r = new b(this);
        this.f357909s = LazyKt.lazy(new y0(this));
        this.f357910t = LazyKt.lazy(new z0(this));
        this.f357911u = LazyKt.lazy(new a1(this));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        V90();
        AnimatorSet r100 = this.f357897g;
        if (r100 == null) goto L5;
        r100.removeAllListeners();
    L5:
        AnimatorSet r101 = this.f357897g;
        if (r101 == null) goto L8;
        r101.end();
    L8:
        AnimatorSet r102 = this.f357898h;
        if (r102 == null) goto L11;
        r102.removeAllListeners();
    L11:
        AnimatorSet r103 = this.f357898h;
        if (r103 == null) goto L14;
        r103.end();
    L14:
        Bundle r104 = getArguments();
        if (r104 == null) goto L17;
        String r105 = r104.getString("key_trigger_app_id");
    L19:
        if (com.larus.utils.o0.d(r105) == false) goto L22;
        ILoginService.f286097a.Q(this.f357908r);
        return;
    L22:
        return;
    L17:
        r105 = null;
        goto L19
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        V90();
        this.f357896f = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        V90();
        super.onPause();
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        com.larus.login.impl.utils.f.b("full_screen", "login_home");
        LarusAccountLoginPageBinding r100 = this.f357896f;
        Animatable r101 = null;
        if (r100 == null) goto L5;
        SimpleDraweeView r102 = r100.f357428e;
    L6:
        if (r102 == null) goto L10;
        DraweeController r103 = r102.getController();
        if (r103 == null) goto L10;
        r101 = r103.getAnimatable();
    L10:
        if (r102 != null) goto L12;
        return;
    L12:
        if (r102.isAttachedToWindow() == false) goto L17;
        if (r101 == null) goto L18;
        X90(r102, r101);
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        V90();
        super.onStop();
    }

    public final void U90(Configuration r100) {
        e2 r101 = e2.f365734a;
        if (r101.isPad() == false) goto L12;
        LarusAccountLoginPageBinding r102 = this.f357896f;
        if (r102 != null) goto L7;
        return;
    L7:
        if (r100.orientation != 2) goto L9;
        int r103 = (r101.f() / 3) - i5.Q();
    L10:
        LinearLayout r104 = r102.f357436m;
        r104.setPadding(r103, r104.getPaddingTop(), r103, r102.f357436m.getPaddingBottom());
        return;
    L9:
        r103 = 0;
        goto L10
    }

    public final ValueAnimator W90(final String r100) {
        final int r101 = r100.getBytes(Charset.forName("UTF-8")).length;
        ValueAnimator r102 = ValueAnimator.ofInt(new int[]{0, r101 + 30, 0});
        r102.setDuration(r101 * 100);
        r102.addUpdateListener(new n0(r101, r100, this));
        return r102;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        if (e2.f365734a.a(getActivity(), r100) == false) goto L5;
        U90(r100);
    L5:
        Y90();
    }

    public final void X90(SimpleDraweeView r100, Animatable r101) {
        V90();
        if (r100 != null) goto L5;
        return;
    L5:
        this.f357903m = -1;
        this.f357904n = false;
        this.f357905o = false;
        if ((r101 instanceof AnimatedDrawable2) == false) goto L8;
        AnimatedDrawable2 r102 = (AnimatedDrawable2) r101;
    L9:
        if (r102 != null) goto L13;
        if (r101 == null) goto L19;
        r101.start();
        return;
    L19:
        return;
    L13:
        this.f357901k = r100;
        this.f357899i = r102;
        if (AppHost.f326268a.isOversea() == false) goto L17;
        r102.setDrawListener(null);
        r102.setAnimationListener(null);
        r102.setLoopCount(0);
        r102.start();
        return;
    L17:
        r102.setLoopCount(0);
        r102.setAnimationListener(null);
        r102.setDrawListener(new e1(this, r100));
        r102.start();
        return;
    L8:
        r102 = null;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.login.impl.loginfragment.t0] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LarusAccountLoginPageBinding r102 = this.f357896f;
        if (r102 != null) goto L5;
    L9:
        U90(getResources().getConfiguration());
        ((AccountLoginController) this.f357907q.getValue()).O();
        if (ObricLoginDelegate.f392890b.b() == false) goto L12;
        ((AccountLoginController) this.f357907q.getValue()).F(new d(this));
        if (this.f357895e == true) goto L21;
        c1 r103 = new c1(r100, this);
        r100.getViewTreeObserver().addOnPreDrawListener(r103);
    L21:
        System.currentTimeMillis();
        TouristManager.f357001a.w().observe(getViewLifecycleOwner(), new e(new t0(this)));
        return;
    L12:
        if (this.f357895e == true) goto L15;
        c1 r104 = new c1(r100, this);
        r100.getViewTreeObserver().addOnPreDrawListener(r104);
    L15:
        System.currentTimeMillis();
        return;
    L5:
        if (AppHost.f326268a.isTestChannel() == false) goto L7;
    L8:
        r102.f357426c.setOnLongClickListener(new m0(this));
        goto L9
    L7:
        if (AuthModelDelegate.f297134b.d() == false) goto L9;
        goto L8
    }

    @Override // com.larus.login.impl.loginfragment.l1
    public final void Mq(LoginPlatform r100, int r101, String r102) {
        FLogger.f375446a.i("AccountLoginFragment", "onLoginFailed platform=" + r100 + " errorCode=" + r101 + " errorMessage=" + r102);
        if (r100 != LoginPlatform.PHONE) goto L5;
        return;
    L5:
        com.larus.login.impl.utils.k.f358324a = new com.larus.login.impl.utils.c(r100, r101, r102);
        com.larus.utils.t0.e(new r0(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.larus.login.impl.loginfragment.u0] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r210) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        System.currentTimeMillis();
        o37.c.f521918e.getClass();
        if (o37.c.f("login_fragment_nita") == true) goto L5;
    L7:
        LarusAccountLoginPageBinding r100 = LarusAccountLoginPageBinding.a(r110.inflate(R.layout.larus_account_login_page, r111, false));
    L8:
        this.f357896f = r100;
        final SimpleDraweeView r101 = r100.f357428e;
        AnimatorSet r102 = new AnimatorSet();
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{1.0f, 0.1f});
        r103.setDuration(400);
        r103.addUpdateListener(new o0(this));
        ValueAnimator r112 = ValueAnimator.ofFloat(new float[]{0.1f, 1.0f});
        r112.setDuration(400);
        r112.addUpdateListener(new p0(this));
        r112.setStartDelay(300);
        r102.playSequentially(new Animator[]{r103, r112});
        r102.addListener(new f1(r102));
        this.f357898h = r102;
        r102.start();
        Y90();
        ObricLoginDelegate r104 = ObricLoginDelegate.f392890b;
        if (r104.b() == true) goto L38;
        LarusAccountLoginPageBinding r105 = this.f357896f;
        if (r105 == null) goto L38;
        r104.a(r105.f357438o, CollectionsKt.listOf(new View[]{r105.f357437n, r105.f357434k, r105.f357442s, r105.f357429f, r105.f357432i, r105.f357440q, r105.f357433j, r105.f357435l}), r105.f357428e, r105.f357425b, new u0(this));
    L38:
        ImageLoaderKt.y(r101, "res://" + AppHost.f326268a.getApplication().getPackageName() + "/2131238469", null, new v0(r101, this), 6);     // Catch: NullPointerException -> L16
    L18:
        AnimatorSet r106 = new AnimatorSet();
        StringCompanionObject r107 = StringCompanionObject.INSTANCE;
        String r108 = getString(R.string.larus_log_in_page_cici_greeting_1);
        Object[] r109 = {getString(R.string.app_name_replace)};
        ValueAnimator r113 = ValueAnimator.ofInt(new int[]{0, 1});
        r113.setDuration(800);
        ValueAnimator r114 = ValueAnimator.ofInt(new int[]{0, 1});
        r114.setDuration(800);
        r106.playSequentially(new Animator[]{W90(String.format(r108, Arrays.copyOf(r109, 1))), r113, W90(getString(R.string.larus_log_in_page_cici_greeting_2)), r114});
        this.f357897g = r106;
        r106.addListener(new g1(r106));
        r106.start();
        LarusAccountLoginPageBinding r115 = this.f357896f;
        if (r115 != null) goto L21;
    L25:
        Bundle r116 = getArguments();
        if (r116 == null) goto L28;
        String r117 = r116.getString("key_trigger_app_id");
    L30:
        if (com.larus.utils.o0.d(r117) == false) goto L32;
        ILoginService.a.c(ILoginService.f286097a, this.f357908r);
    L32:
        LarusAccountLoginPageBinding r118 = this.f357896f;
        if (r118 == null) goto L40;
        ConstraintLayout r119 = r118.f357424a;
        if (r119 == null) goto L41;
        r119.setTag(R.id.lib_track_tag_parent_track_node, this);
        return r119;
    L41:
        return null;
    L40:
        return null;
    L28:
        r117 = null;
        goto L30
    L21:
        if (AppHost.f326268a.isTestChannel() == false) goto L23;
    L24:
        r115.f357426c.setOnLongClickListener(new b1(this));
        goto L25
    L23:
        if (AuthModelDelegate.f297134b.d() == false) goto L25;
    L16:
        e = move-exception;
        FLogger.f375446a.e(FrescoTraceListener.ALOGTAG, "null point Exception");
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e, "fresco npe exception");
        goto L18
    L5:
        if (getActivity() == null) goto L7;
        r100 = LarusAccountLoginPageBinding.a(((m1) o37.c.e("login_fragment_nita")).i(R.layout.larus_account_login_page, requireActivity(), true));
        goto L8
    }
}
