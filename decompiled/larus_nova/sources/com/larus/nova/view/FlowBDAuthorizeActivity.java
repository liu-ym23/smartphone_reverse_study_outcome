package com.larus.nova.view;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.router.SmartRouter;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.account.bdauth.impl.databinding.LarusPageFlowAuthorizeV2Binding;
import com.larus.common.account.bdauth.repository.BDAuthorizeAccountIssueType;
import com.larus.common.account.bdauth.repository.BDAuthorizeBlockingErrorType;
import com.larus.common.account.bdauth.ui.BDAuthorizeAccountAdapter;
import com.larus.common.account.bdauth.ui.BDAuthorizeHeaderAdapter;
import com.larus.common.account.bdauth.viewmodel.BDAuthorizeAddAccountStage;
import com.larus.common.account.bdauth.viewmodel.BDAuthorizePageMode;
import com.larus.common.account.bdauth.viewmodel.BDAuthorizeViewModel;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.l0;
import com.larus.common_ui.widget.concat_adapter.ConcatAdapter;
import com.larus.platform.model.TriggerLoginScene;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Arrays;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import tx9.a1;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000µ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001'\b\u0007\u0018\u0000 d2\u00020\u0001:\u0001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\b\u0010-\u001a\u00020*H\u0014J\b\u0010.\u001a\u00020*H\u0014J\b\u0010/\u001a\u00020*H\u0016J\"\u00100\u001a\u00020*2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002022\b\u00104\u001a\u0004\u0018\u000105H\u0014J\u0010\u00106\u001a\u00020*2\u0006\u00107\u001a\u00020,H\u0014J\b\u00108\u001a\u00020*H\u0002J\b\u00109\u001a\u00020*H\u0002J\u0010\u0010:\u001a\u00020*2\u0006\u0010;\u001a\u00020\u0014H\u0002J\u0010\u0010<\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u0012H\u0002J\u0010\u0010>\u001a\u00020*2\u0006\u0010?\u001a\u00020@H\u0002J\b\u0010A\u001a\u00020*H\u0002J\b\u0010B\u001a\u00020*H\u0002J\b\u0010C\u001a\u00020*H\u0002J\u0010\u0010D\u001a\u00020*2\u0006\u0010=\u001a\u00020\u0012H\u0002J\u0014\u0010E\u001a\u00020*2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010GH\u0002J\b\u0010H\u001a\u00020*H\u0002J\u001c\u0010I\u001a\u00020*2\b\u0010J\u001a\u0004\u0018\u00010K2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010L\u001a\u00020*2\u0006\u0010M\u001a\u00020NH\u0002J\u0010\u0010O\u001a\u00020G2\u0006\u0010P\u001a\u00020QH\u0002J\u0010\u0010R\u001a\u00020G2\u0006\u0010P\u001a\u00020QH\u0002J\u0010\u0010S\u001a\u00020*2\u0006\u0010T\u001a\u00020UH\u0002J\b\u0010V\u001a\u00020\rH\u0002J\b\u0010W\u001a\u00020\rH\u0002J\b\u0010X\u001a\u00020*H\u0002J\u0010\u0010Y\u001a\u00020G2\u0006\u0010Z\u001a\u00020\u0010H\u0002J\b\u0010[\u001a\u00020GH\u0002J\u0012\u0010\\\u001a\u00020*2\b\u0010]\u001a\u0004\u0018\u00010^H\u0002J\u0012\u0010_\u001a\u00020*2\b\u0010]\u001a\u0004\u0018\u00010^H\u0002J\u0012\u0010`\u001a\u00020*2\b\u0010]\u001a\u0004\u0018\u00010^H\u0002J\u0012\u0010a\u001a\u00020*2\b\u0010]\u001a\u0004\u0018\u00010^H\u0002J\u0010\u0010b\u001a\u0004\u0018\u00010\u0010H\u0082@¢\u0006\u0002\u0010cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b#\u0010$R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(¨\u0006e"}, d2 = {"Lcom/larus/nova/view/FlowBDAuthorizeActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "binding", "Lcom/larus/account/bdauth/impl/databinding/LarusPageFlowAuthorizeV2Binding;", "bdPlatformApi", "Lcom/larus/common/account/bdauth/api/BDPlatformApi;", "lastRequest", "Lcom/bytedance/sdk/account/common/model/SendAuth$Request;", "commonLoadDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "errorDialog", "Lcom/larus/common_ui/dialog/CommonDialog;", "accountIssueDialog", "hasReportedContentPage", "", "lastRenderedAuthInfoResponse", "Lcom/bytedance/sdk/account/bdplatform/model/AuthInfoResponseV2;", "lastRenderedState", "Lcom/larus/common/account/bdauth/viewmodel/BDAuthorizeUiState;", "waitingLoginFromNoAccount", "accountAdapter", "Lcom/larus/common/account/bdauth/ui/BDAuthorizeAccountAdapter;", "getAccountAdapter", "()Lcom/larus/common/account/bdauth/ui/BDAuthorizeAccountAdapter;", "accountAdapter$delegate", "Lkotlin/Lazy;", "headerAdapter", "Lcom/larus/common/account/bdauth/ui/BDAuthorizeHeaderAdapter;", "getHeaderAdapter", "()Lcom/larus/common/account/bdauth/ui/BDAuthorizeHeaderAdapter;", "headerAdapter$delegate", "authorizeViewModel", "Lcom/larus/common/account/bdauth/viewmodel/BDAuthorizeViewModel;", "getAuthorizeViewModel", "()Lcom/larus/common/account/bdauth/viewmodel/BDAuthorizeViewModel;", "authorizeViewModel$delegate", "accountStatusCallback", "com/larus/nova/view/FlowBDAuthorizeActivity$accountStatusCallback$1", "Lcom/larus/nova/view/FlowBDAuthorizeActivity$accountStatusCallback$1;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", LiveCommonConstants.REASON_ON_DEDTROY, "onResume", "onBackPressed", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onSaveInstanceState", "outState", "initView", "observeViewModel", "renderState", "state", "hasAuthInfoChanged", "authInfoResponse", "handleEffect", "effect", "Lcom/larus/common/account/bdauth/viewmodel/BDAuthorizeEffect;", "openLoginWithPrivacy", "openLoginPage", "openAddAccountPage", "renderAuthorizeInfo", "updateHeader", "clientName", "", "showLoadingDialog", "safeDismissDialog", "activity", "Landroid/app/Activity;", "showBlockingErrorDialog", "error", "Lcom/larus/common/account/bdauth/repository/BDAuthorizeBlockingError;", "resolveBlockingErrorTitle", "type", "Lcom/larus/common/account/bdauth/repository/BDAuthorizeBlockingErrorType;", "resolveBlockingErrorCancelText", "showAccountIssueDialog", "issue", "Lcom/larus/common/account/bdauth/repository/BDAuthorizeAccountIssue;", "buildSessionExpiredDialog", "buildAccountDeactivatedDialog", "openReloginPage", "resolveAccountType", "isEnterprise", "getTriggerAppId", "onAuthorizeSuccess", "response", "Lcom/bytedance/sdk/account/common/model/SendAuth$Response;", "onAuthorizeError", "onAuthorizeCancel", "sendResponse", "prepareMainTaskSilentlyIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowBDAuthorizeActivity extends FlowCommonAppCompatActivity {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f360372u = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LarusPageFlowAuthorizeV2Binding f360373g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.larus.common.account.bdauth.impl.a f360374h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public fb7.c f360375i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public l0 f360376j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CommonDialog f360377k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CommonDialog f360378l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f360379m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public za7.c f360380n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.larus.common.account.bdauth.viewmodel.d f360381o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f360382p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f360383q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f360384r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ViewModelLazy f360385s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final c f360386t;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f360389a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f360390b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f360391c = null;

        static {
            int[] r100 = new int[BDAuthorizePageMode.values().length];
            r100[BDAuthorizePageMode.Loading.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L24:
            r100[BDAuthorizePageMode.Content.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L6:
            f360389a = r100;
            int[] r101 = new int[BDAuthorizeAccountIssueType.values().length];
            r101[BDAuthorizeAccountIssueType.SessionExpired.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L34:
            r101[BDAuthorizeAccountIssueType.AccountDeactivated.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r101[BDAuthorizeAccountIssueType.EnterpriseUnsupported.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L10:
            f360390b = r101;
            int[] r102 = new int[BDAuthorizeBlockingErrorType.values().length];
            r102[BDAuthorizeBlockingErrorType.MinorMode.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L30:
            r102[BDAuthorizeBlockingErrorType.EnterpriseAccount.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L13:
            f360391c = r102;
        }
    }

    public static final class c implements com.larus.platform.api.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowBDAuthorizeActivity f360392a;

        @Override // com.larus.platform.api.b
        public final void a(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        public c(FlowBDAuthorizeActivity r100) {
            this.f360392a = r100;
        }

        @Override // com.larus.platform.api.b
        public final void b(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            FlowBDAuthorizeActivity r101 = this.f360392a;
            int r102 = FlowBDAuthorizeActivity.f360372u;
            BDAuthorizeAddAccountStage r103 = r101.P1().getAddAccountStage().getValue();
            if (r103 == null) goto L7;
            boolean r104 = true;
            if (r103.isInProgress() != true) goto L7;
        L8:
            if (r104 == true) goto L10;
            this.f360392a.P1().getAddAccountStage().getValue();
            BDAuthorizeAddAccountStage r105 = BDAuthorizeAddAccountStage.Idle;
        L10:
            boolean r106 = this.f360392a.f360381o.f325993b;
            return;
        L7:
            r104 = false;
            goto L8
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowBDAuthorizeActivity f360393a;

        public d(FlowBDAuthorizeActivity r100) {
            this.f360393a = r100;
        }

        public final void a(Intent r100) {
            FLogger.f375446a.i("XBDAuthorizeActivity", "handleIntent#onErrorIntent = " + r100);
            fb7.d r101 = new fb7.d();
            r101.f476267a = -1;
            FlowBDAuthorizeActivity r102 = this.f360393a;
            int r103 = FlowBDAuthorizeActivity.f360372u;
            r102.R1(r101);
        }

        public final void b(fb7.c r100) {
            FLogger.f375446a.i("XBDAuthorizeActivity", "handleIntent#onReq = " + r100);
            this.f360393a.f360375i = r100;
        }

        public final void c(fb7.d r100) {
            FLogger.f375446a.i("XBDAuthorizeActivity", "handleIntent#onResp = " + r100);
            this.f360393a.finish();
        }
    }

    public static final class e implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f360394a;

        public e(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f360394a = r100;
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
            return this.f360394a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f360394a.invoke(r100);
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final BDAuthorizeViewModel P1() {
        return (BDAuthorizeViewModel) this.f360385s.getValue();
    }

    public final void S1() {
        com.bytedance.router.i r100 = SmartRouter.buildRoute(this, "//flow/half_account_login");
        Bundle r101 = new Bundle();
        Intent r102 = getIntent();
        if (r102 == null) goto L6;
        String r103 = r102.getStringExtra(ParamKeyConstants.BaseParams.EXTRA);
        if (r103 == null) goto L6;
    L7:
        r101.putString("key_trigger_app_id", r103);
        r101.putInt("trigger_login_scene_tag", TriggerLoginScene.TRIGGER_LOGIN_ADD_ACCOUNT.getValue());
        r101.putString("account_previous_page", "login_with_doubao");
        r100.f267554c.putExtras(r101);
        r100.e(1001);
        P1().getAddAccountStage().setValue(BDAuthorizeAddAccountStage.WaitingAddAccountResult);
        return;
    L6:
        r103 = "";
        goto L7
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(FlowBDAuthorizeActivity.class.getName()));
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
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L48;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(FlowBDAuthorizeActivity.class.getName()));
    L5:
        super.onDestroy();
        AccountService.f365697a.D(this.f360386t);
    }

    public FlowBDAuthorizeActivity() {
        this.f360381o = new com.larus.common.account.bdauth.viewmodel.d(0);
        this.f360383q = LazyKt.lazy(new com.larus.nova.view.a(this));
        this.f360384r = LazyKt.lazy(new g());
        Function0 r100 = new h(this);
        final Function0 r101 = null;
        this.f360385s = new ViewModelLazy(Reflection.getOrCreateKotlinClass(BDAuthorizeViewModel.class), new FlowBDAuthorizeActivity$special$$inlined$viewModels$default$2(this), r100, new FlowBDAuthorizeActivity$special$$inlined$viewModels$default$3(r101, this));
        this.f360386t = new c(this);
    }

    public final String Q1() {
        Intent r100 = getIntent();
        if (r100 == null) goto L6;
        String r101 = r100.getStringExtra(ParamKeyConstants.BaseParams.EXTRA);
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        P1().cancel(-33, "back pressed");
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        com.larus.common.account.bdauth.viewmodel.d r100 = this.f360381o;
        if (r100.f325992a != BDAuthorizePageMode.Loading) goto L5;
        return;
    L5:
        if (r100.f325993b == true) goto L9;
        P1().refreshAccounts(true, true);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
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

    public static void O1(l0 r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public final void R1(fb7.d r100) {
        Boolean r101 = Boolean.FALSE;
        String r102 = Q1();
        if (r100 == null) goto L6;
        String r103 = Integer.valueOf(r100.f476267a).toString();
        if (r103 == null) goto L6;
    L7:
        if (r100 == null) goto L9;
        String r104 = r100.f476268b;
    L10:
        xz8.a.a(r101, r102, "-1", r103, r104, 192);
        U1(r100);
        return;
    L9:
        r104 = null;
    L6:
        r103 = "";
        goto L7
    }

    public final void U1(fb7.d r100) {
        T1(this, this.f360376j);
        com.larus.common.account.bdauth.impl.a r101 = this.f360374h;
        if (r101 == null) goto L5;
        r101.c(this.f360375i, r100);
    L5:
        finish();
    }

    public final void W1(String r110) {
        BDAuthorizeHeaderAdapter r100 = (BDAuthorizeHeaderAdapter) this.f360384r.getValue();
        StringCompanionObject r101 = StringCompanionObject.INSTANCE;
        String r102 = String.format(getString(com.larus.nova.R.string.larus_auth_login_account_title), Arrays.copyOf(new Object[]{getResources().getString(com.larus.nova.R.string.app_name_replace)}, 1));
        String r103 = getString(com.larus.nova.R.string.larus_auth_login_desc);
        Object[] r104 = new Object[2];
        r104[0] = getResources().getString(com.larus.nova.R.string.app_name_replace);
        if (r110 != null) goto L5;
        r110 = "";
    L5:
        r104[1] = r110;
        r100.update(r102, String.format(r103, Arrays.copyOf(r104, 2)));
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r510) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L7;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L7:
        if (v19.f.f(this) == false) goto L11;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L11:
        super.onCreate(r510);
        a1.c(null, null, null, null, null, "login_with_doubao_rd", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -129, -1, 7);
        if (r510 != null) goto L14;
    L16:
        FLogger r100 = FLogger.f375446a;
        r100.i("XBDAuthorizeActivity", "start enter BDAuth Activity");
        int r101 = com.larus.common.account.bdauth.impl.b.f325906a;
        Intrinsics.checkNotNullParameter(this, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f360374h = new com.larus.common.account.bdauth.impl.a(this);
        r100.i("XBDAuthorizeActivity", "start handleIntent");
        com.larus.common.account.bdauth.impl.a r102 = this.f360374h;
        if (r102 == null) goto L19;
        r102.b(getIntent(), new d(this));
    L19:
        View r103 = getLayoutInflater().inflate(com.larus.nova.R.layout.larus_page_flow_authorize_v2, null, false);
        int r104 = com.larus.nova.R.id.auth_account_close;
        ImageView r110 = (ImageView) ViewBindings.findChildViewById(r103, com.larus.nova.R.id.auth_account_close);
        if (r110 == null) goto L41;
        r104 = com.larus.nova.R.id.auth_account_confirm;
        Button r111 = (Button) ViewBindings.findChildViewById(r103, com.larus.nova.R.id.auth_account_confirm);
        if (r111 == null) goto L41;
        r104 = com.larus.nova.R.id.auth_account_loading;
        if (((ProgressBar) ViewBindings.findChildViewById(r103, com.larus.nova.R.id.auth_account_loading)) == null) goto L41;
        r104 = com.larus.nova.R.id.auth_account_loading_container;
        FrameLayout r112 = (FrameLayout) ViewBindings.findChildViewById(r103, com.larus.nova.R.id.auth_account_loading_container);
        if (r112 == null) goto L41;
        r104 = com.larus.nova.R.id.auth_account_recycler_view;
        RecyclerView r113 = (RecyclerView) ViewBindings.findChildViewById(r103, com.larus.nova.R.id.auth_account_recycler_view);
        if (r113 == null) goto L41;
        ConstraintLayout r105 = (ConstraintLayout) r103;
        this.f360373g = new LarusPageFlowAuthorizeV2Binding(r105, r110, r111, r112, r113);
        setContentView(r105);
        LarusPageFlowAuthorizeV2Binding r106 = this.f360373g;
        if (r106 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r106 = null;
    L32:
        RecyclerView r107 = r106.f286232e;
        r107.setLayoutManager(new LinearLayoutManager(this));
        r107.setAdapter(new ConcatAdapter(new RecyclerView.Adapter[]{(BDAuthorizeHeaderAdapter) this.f360384r.getValue(), (BDAuthorizeAccountAdapter) this.f360383q.getValue()}));
        r107.setItemAnimator(null);
        W1(null);
        LarusPageFlowAuthorizeV2Binding r108 = this.f360373g;
        if (r108 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r108 = null;
    L35:
        e1.d(r108.f286229b, new i(this));
        LarusPageFlowAuthorizeV2Binding r109 = this.f360373g;
        if (r109 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r109 = null;
    L38:
        e1.d(r109.f286230c, new j(this));
        P1().getUiState().observe(this, new e(new k(this)));
        P1().getEffect().observe(this, new e(new l(this)));
        AccountService.f365697a.E(this.f360386t);
        r100.i("XBDAuthorizeActivity", "start prepareAuthorize");
        BDAuthorizeViewModel.start$default(P1(), this.f360375i, false, 2, null);
        return;
    L41:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    L14:
        if (z2.f365865a.optDialogDismiss() == false) goto L16;
        FLogger.f375446a.i("XBDAuthorizeActivity", "UI mode changed during recreation, dismissing dialog");
        finish();
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        super.onSaveInstanceState(r100);
        r100.putBoolean("key_is_start_login", false);
    }

    public final void T1(Activity r100, l0 r101) {
        boolean r102 = false;
        if (r100 != null) goto L17;
    L9:
        if (r102 == false) goto L19;
        if (r101 != null) goto L12;
        return;
    L12:
        if (r101.isShowing() == false) goto L21;
        O1(r101);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        FLogger.f375446a.e("XBDAuthorizeActivity", "commonLoadDialog dismiss crash because: " + e.getMessage(), e);
        return;
    L21:
        return;
    L19:
        return;
    L17:
        if (r100.isFinishing() == true) goto L9;
        r102 = true;
        goto L9
    }

    public static void N1(CommonDialog r100, FragmentManager r101, String r102) {
        LandscapeRestrictionOperation r103 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, r102, r103);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r103) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r100.show(r101, r102);
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        if (r100 != 1001) goto L31;
        boolean r103 = true;
        boolean r104 = false;
        if (r102 == null) goto L11;
        Bundle r105 = r102.getExtras();
        if (r105 == null) goto L11;
        if (r105.getInt("login_result") != 1) goto L11;
        boolean r106 = true;
    L12:
        if (r106 == false) goto L22;
        BDAuthorizeAddAccountStage r107 = P1().getAddAccountStage().getValue();
        if (r107 != null) goto L16;
    L18:
        r103 = false;
    L19:
        if (r103 == false) goto L21;
        P1().addAccountSuccess();
        return;
    L21:
        P1().start(this.f360375i, this.f360382p);
        this.f360382p = false;
        return;
    L16:
        if (r107.isInProgress() != true) goto L18;
    L22:
        BDAuthorizeAddAccountStage r108 = P1().getAddAccountStage().getValue();
        if (r108 != null) goto L25;
    L27:
        if (r104 == false) goto L29;
        P1().addAccountFailed();
        return;
    L29:
        P1().onLoginFailed(true);
        return;
    L25:
        if (r108.isInProgress() != true) goto L27;
        r104 = true;
    L11:
        r106 = false;
        goto L12
    }
}
