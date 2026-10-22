package com.ss.android.lark.passport.flow.auth_type;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.flow.passport.mfa.databinding.SigninSdkActivityAuthTypeBinding;
import com.ss.android.lark.flow.passport.ui.widget.common.FlowBaseActivity;
import com.ss.android.lark.flow.passport.ui.widget.layout.BaseContainerLayout;
import com.ss.android.lark.flow.passport.ui.widget.utils.FlowUtilKt;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.auth_type.viewmodel.AuthTypeViewModel;
import com.ss.android.lark.passport.flow.core.router.FlowStep;
import com.ss.android.lark.passport.flow.core.widget.CommonTitleBar;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import uzb.f;
import uzb.l;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\"\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020#H\u0002J\u0012\u0010(\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010\u001cH\u0002J\u001a\u0010*\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020\u000fH\u0016J\b\u0010/\u001a\u00020\u000fH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u00061"}, d2 = {"Lcom/ss/android/lark/passport/flow/auth_type/AuthTypeActivity;", "Lcom/ss/android/lark/flow/passport/ui/widget/common/FlowBaseActivity;", "<init>", "()V", "uiContainer", "Lcom/ss/android/lark/flow/passport/ui/widget/common/BaseUiContainer;", "binding", "Lcom/ss/android/lark/flow/passport/mfa/databinding/SigninSdkActivityAuthTypeBinding;", "viewModel", "Lcom/ss/android/lark/passport/flow/auth_type/viewmodel/AuthTypeViewModel;", "getViewModel", "()Lcom/ss/android/lark/passport/flow/auth_type/viewmodel/AuthTypeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "pageRootView", "Landroid/view/View;", "initView", "observeViewModel", "readStepInfo", "Lcom/ss/android/lark/passport/flow/auth_type/AuthTypeStepInfo;", "showChooseView", "stepInfo", "getLoginVerifyItem", "data", "Lcom/ss/android/lark/passport/flow/core/model/ButtonInfo;", "targetTenantIcon", "", "setVerifyIcon", "itemBinding", "Lcom/ss/android/lark/flow/passport/mfa/databinding/SigninSdkItemLoginVerifyTypeBinding;", ReportConstant.COMMON_ACTION_TYPE, "", "tintedDrawable", "Landroid/graphics/drawable/Drawable;", "drawableRes", "colorRes", "showBottomButton", "bottomButton", "setBIdpImageResource", "routeNextStep", "event", "Lcom/ss/android/lark/passport/flow/auth_type/viewmodel/AuthTypeViewModel$UIEvent$RouteToNext;", VideoEventOneOutSync.END_TYPE_FINISH, LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthTypeActivity extends FlowBaseActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f437725f = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SigninSdkActivityAuthTypeBinding f437726d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewModelLazy f437727e;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.flow.passport.ui.widget.common.FlowBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        if (f.c(this) == false) goto L5;
        f.b(this);
    L5:
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L59;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(AuthTypeActivity.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L48
        if (r103 != null) goto L13;
    L16:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L48
        monitor-exit(r102);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L56:
        return;
    L19:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L45
    L51:
        goto L56
    L22:
        if (isFinishing() == true) goto L25;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L51
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L51
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L51
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
        goto L51
    L34:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L36;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L45
        goto L51
    L36:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L45
        if (r104 == null) goto L51;
        r104.addFlags(268435456);     // Catch: Throwable -> L45
        r104.addFlags(2097152);     // Catch: Throwable -> L45
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r104);     // Catch: Throwable -> L42
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L51
    L13:
        if ((r101 - r103.longValue()) >= 800) goto L16;
        monitor-exit(r102);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final AuthTypeViewModel z1() {
        return (AuthTypeViewModel) this.f437727e.getValue();
    }

    public AuthTypeActivity() {
        Function0<ViewModelProvider.Factory> r100 = new AuthTypeActivity$special$$inlined$viewModels$default$1(this);
        final Function0 r101 = null;
        this.f437727e = new ViewModelLazy(Reflection.getOrCreateKotlinClass(AuthTypeViewModel.class), new AuthTypeActivity$special$$inlined$viewModels$default$2(this), r100, new AuthTypeActivity$special$$inlined$viewModels$default$3(r101, this));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        y1();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r110);
        int r111 = com.ss.android.lark.flow.passport.ui.widget.common.a.f423834c;
        Intrinsics.checkNotNullParameter(this, "activity");
        int r100 = com.ss.android.lark.flow.passport.ui.widget.layout.f.f423884a;
        Intrinsics.checkNotNullParameter(this, "activity");
        AuthTypeStepInfo r101 = null;
        BaseContainerLayout r112 = new BaseContainerLayout(this, null, 6, 0);
        setContentView(r112, new ViewGroup.LayoutParams(-1, -1));
        r112.a(com.larus.nova.R.layout.signin_sdk_activity_auth_type);
        View r113 = new com.ss.android.lark.flow.passport.ui.widget.common.a(this, r112).f423836b.getChildAt(0);
        int r102 = com.larus.nova.R.id.ll_verify_type;
        LinearLayout r103 = (LinearLayout) ViewBindings.findChildViewById(r113, com.larus.nova.R.id.ll_verify_type);
        if (r103 == null) goto L35;
        r102 = com.larus.nova.R.id.title_bar;
        CommonTitleBar r104 = (CommonTitleBar) ViewBindings.findChildViewById(r113, com.larus.nova.R.id.title_bar);
        if (r104 == null) goto L35;
        r102 = com.larus.nova.R.id.tv_bottom_button;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r113, com.larus.nova.R.id.tv_bottom_button);
        if (r105 == null) goto L35;
        r102 = com.larus.nova.R.id.tv_bottom_layout;
        if (((LinearLayout) ViewBindings.findChildViewById(r113, com.larus.nova.R.id.tv_bottom_layout)) == null) goto L35;
        r102 = com.larus.nova.R.id.tv_subtitle;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r113, com.larus.nova.R.id.tv_subtitle);
        if (r106 == null) goto L35;
        r102 = com.larus.nova.R.id.tv_title;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r113, com.larus.nova.R.id.tv_title);
        if (r107 == null) goto L35;
        this.f437726d = new SigninSdkActivityAuthTypeBinding((LinearLayout) r113, r103, r104, r105, r106, r107);
        r104.R5();
        SigninSdkActivityAuthTypeBinding r114 = this.f437726d;
        if (r114 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r114 = null;
    L25:
        r114.f423798c.setTitleClickListener(new b(this));
        FlowUtilKt.b(this, z1().getViewState(), new AuthTypeActivity$observeViewModel$1(this, null));
        FlowUtilKt.b(this, z1().getEventState(), new AuthTypeActivity$observeViewModel$2(this, null));
        AuthTypeViewModel r115 = z1();
        Serializable r108 = getIntent().getSerializableExtra("auth_type_step");
        if ((r108 instanceof FlowStep) == false) goto L28;
        FlowStep r109 = (FlowStep) r108;
    L29:
        if (r109 != null) goto L31;
        PassportLog.b("AuthTypeActivity", "init auth type but step is null");
    L32:
        r115.init(r101);
        return;
    L31:
        r101 = (AuthTypeStepInfo) uzb.c.a(r109.getStepInfo(), AuthTypeStepInfo.class);
        goto L32
    L28:
        r109 = null;
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r102)));
    }

    public final Drawable A1(int r100, int r101) {
        Drawable r102 = l.getResources(this).getDrawable(r100).mutate();
        r102.setTint(l.b(this, r101));
        return r102;
    }
}
