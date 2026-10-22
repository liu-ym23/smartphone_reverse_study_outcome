package com.obric.assistant.onelogin;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.guide.IObricUserGuide;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.login.f0;
import com.obric.assistant.onelogin.impl.databinding.ActivityObricOneLoginBinding;
import com.obric.oui.status.OPageStatus;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\"\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\b\u0010\u001f\u001a\u00020\u0016H\u0016J\b\u0010 \u001a\u00020\u0016H\u0002J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u0016H\u0014J\b\u0010$\u001a\u00020\u0016H\u0002J\u000e\u0010%\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010&R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/assistant/onelogin/ObricOneLoginActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "binding", "Lcom/obric/assistant/onelogin/impl/databinding/ActivityObricOneLoginBinding;", "lastRetryClick", "", "emptyFragment", "Lcom/obric/assistant/onelogin/ObricEmptyOneLoginFragment;", "uiStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/assistant/onelogin/ObricOneLoginActivity$LoginViewState;", "settingsDisableRetryTime", "", "launchDouBaoMainBot", "", "loginForResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "hasRegisteredLoginTask", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "initUiStateObserver", "addFragmentIfNotExist", "onBackPressed", "checkOLoginOrRoute", "launchOAccountLogin", "invokeOneLogin", LiveCommonConstants.REASON_ON_DEDTROY, "invokeReLogin", "awaitForSettingsReady", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "LoginViewState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricOneLoginActivity extends FlowCommonAppCompatActivity {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f390869o = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ActivityObricOneLoginBinding f390870g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f390871h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ObricEmptyOneLoginFragment f390872i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final StateFlowImpl f390873j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f390874k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f390875l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ActivityResultLauncher<Intent> f390876m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f390877n;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/onelogin/ObricOneLoginActivity$LoginViewState;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "RETRY", "RELOGIN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LoginViewState extends Enum<LoginViewState> {
        public static final LoginViewState LOADING = null;
        public static final LoginViewState RELOGIN = null;
        public static final LoginViewState RETRY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LoginViewState[] f390878a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f390879b = null;

        public static EnumEntries<LoginViewState> getEntries() {
            return f390879b;
        }

        static {
            LoginViewState r100 = new LoginViewState("LOADING", 0);
            LOADING = r100;
            LoginViewState r101 = new LoginViewState("RETRY", 1);
            RETRY = r101;
            LoginViewState r102 = new LoginViewState("RELOGIN", 2);
            RELOGIN = r102;
            LoginViewState[] r103 = {r100, r101, r102};
            f390878a = r103;
            f390879b = EnumEntriesKt.enumEntries(r103);
        }

        public static LoginViewState[] values() {
            return (LoginViewState[]) f390878a.clone();
        }

        public static LoginViewState valueOf(String r100) {
            return (LoginViewState) r27.a.a(LoginViewState.class, r100);
        }

        public LoginViewState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        setResult(0);
        finish();
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.obric.assistant.onelogin.d] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.obric.assistant.onelogin.e] */
    public final void P1() {
        final WeakReference r100 = new WeakReference(this);
        f0.d(f0.f390252a, "login_activity", this, new d(r100), new e(r100), 48);
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ObricOneLoginActivity.class.getName()));
    L5:
        super.onDestroy();
        IObricUserGuide r100 = (IObricUserGuide) ServiceManager.get().getService(IObricUserGuide.class);
        if (r100 == null) goto L8;
        r100.c();
    L8:
        if (r100 == null) goto L12;
        MutableLiveData r101 = r100.f();
        if (r101 == null) goto L12;
        r101.removeObservers(this);
    L12:
        FLogger r102 = FLogger.f375446a;
        r102.d("ObricOneLoginActivity", this + " onDestroy()");
        if (this.f390877n == false) goto L16;
        r102.i("ObricOneLoginActivity", "onDestroy, setLoggingIn false");
        ConcurrentHashMap<String, Boolean> r103 = b.f390917a;
        b.a(getTaskId(), ObricOneLoginActivity.class.getName(), false);
        return;
    }

    public ObricOneLoginActivity() {
        this.f390871h = System.currentTimeMillis();
        this.f390872i = new ObricEmptyOneLoginFragment();
        this.f390873j = j1.a(LoginViewState.LOADING);
        this.f390875l = true;
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(ObricOneLoginActivity.class.getName()));
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

    public static final void O1(ObricOneLoginActivity r100) {
        ActivityObricOneLoginBinding r101 = r100.f390870g;
        ActivityResultLauncher<Intent> r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r101 = null;
    L5:
        r101.f390934c.setVisibility(4);
        ActivityResultLauncher<Intent> r103 = r100.f390876m;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("loginForResult");
    L9:
        Intent r104 = new Intent("com.obric.account.action.OBRIC_ACCOUNT_LOGIN");
        r104.setPackage("com.obric.account");
        r104.putExtra("enter_from", r100.getPackageName());
        r102.launch(r104);
        r100.overridePendingTransition(com.larus.nova.R.anim.obric_one_login_fade_in, 0);
        return;
    L8:
        r102 = r103;
        goto L9
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L32
    L6:
        if (v19.f.f(this) == false) goto L8;
        v19.f.c(getTheme());     // Catch: Throwable -> L32
    L8:
        super.onCreate(r110);
        FLogger r111 = FLogger.f375446a;
        r111.d("ObricOneLoginActivity", this + "  onCreate() ");
        ConcurrentHashMap<String, Boolean> r100 = b.f390917a;
        int r101 = getTaskId();
        String r102 = ObricOneLoginActivity.class.getName();
        Intrinsics.checkNotNullParameter(r102, "tag");
        if (Intrinsics.areEqual(b.f390917a.get(r101 + ':' + r102), Boolean.TRUE) == false) goto L11;
        r111.i("ObricOneLoginActivity", "Task " + getTaskId() + " is already logging in. Finishing duplicate ObricOneLoginActivity.");
        finish();
        return;
    L11:
        b.a(getTaskId(), ObricOneLoginActivity.class.getName(), true);
        this.f390877n = true;
        boolean r103 = false;
        View r112 = getLayoutInflater().inflate(com.larus.nova.R.layout.activity_obric_one_login, null, false);
        int r104 = com.larus.nova.R.id.fragment_container;
        FrameLayout r105 = (FrameLayout) ViewBindings.findChildViewById(r112, com.larus.nova.R.id.fragment_container);
        if (r105 == null) goto L31;
        OPageStatus r106 = (OPageStatus) ViewBindings.findChildViewById(r112, com.larus.nova.R.id.one_login_page_status);
        if (r106 == null) goto L29;
        FrameLayout r113 = (FrameLayout) r112;
        this.f390870g = new ActivityObricOneLoginBinding(r113, r105, r106);
        setContentView(r113);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, com.larus.nova.R.color.oui_bg_base_1));
        Intent r114 = getIntent();
        if (r114 != null) goto L18;
    L20:
        this.f390875l = !r103;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricOneLoginActivity$initUiStateObserver$1(this, null), 3, null);
        if (getSupportFragmentManager().findFragmentById(com.larus.nova.R.id.fragment_container) != null) goto L27;
        FragmentTransaction r115 = getSupportFragmentManager().beginTransaction();
        Fragment r107 = this.f390872i;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r115, r107, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, com.larus.nova.R.id.fragment_container) == true) goto L26;
        r115 = r115.add(com.larus.nova.R.id.fragment_container, r107);
    L26:
        r115.commitAllowingStateLoss();
    L27:
        this.f390876m = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new c(this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricOneLoginActivity$checkOLoginOrRoute$1(this, null), 3, null);
        return;
    L18:
        if (r114.getBooleanExtra("launch_dou_bao_main_bot", true) == true) goto L20;
        r103 = true;
        goto L20
    L29:
        r104 = com.larus.nova.R.id.one_login_page_status;
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r112.getResources().getResourceName(r104)));
    }

    public static final Object N1(ObricOneLoginActivity r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof ObricOneLoginActivity$awaitForSettingsReady$1) == false) goto L7;
        ObricOneLoginActivity$awaitForSettingsReady$1 r102 = (ObricOneLoginActivity$awaitForSettingsReady$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 == 2) goto L15;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
    L19:
        StateFlowImpl r107 = c0.f390924a;
        com.bytedance.sdk.account.ticketguard.f.a();
        if (com.bytedance.sdk.account.ticketguard.f.f269461i == true) goto L25;
        r102.label = 2;
        if (DelayKt.delay(300, r102) != r105) goto L19;
        return r105;
    L25:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r104);
        r102.label = 1;
        if (DelayKt.delay(1000, r102) != r105) goto L19;
        return r105;
    L7:
        r102 = new ObricOneLoginActivity$awaitForSettingsReady$1(r100, r101);
        goto L8
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        FLogger.f375446a.i("ObricOneLoginActivity", this + " onActivityResult resultCode=" + r101);
        int r103 = com.ss.android.account.group_onekey.c.f406291a;
        tb7.a.d("AccountGroupAuthService", "onActivityResult, requestCode=" + r100 + ", resultCode=" + r101);
        if (r102 == null) goto L7;
        String r104 = r102.getStringExtra("challenge");
        if (r104 == null) goto L7;
    L9:
        if (TextUtils.isEmpty(r104) == false) goto L17;
        Iterator<Map.Entry<String, Integer>> r105 = com.ss.android.account.group_onekey.c.f406292b.entrySet().iterator();
    L12:
        if (r105.hasNext() == false) goto L17;
        Map.Entry<String, Integer> r106 = r105.next();
        if (r100 != r106.getValue().intValue()) goto L12;
        r104 = r106.getKey();
    L17:
        if (TextUtils.isEmpty(r104) == true) goto L31;
        if (r102 != null) goto L23;
        r102 = new Intent();
    L23:
        if (r101 == (-1)) goto L25;
        boolean r107 = true;
    L26:
        com.ss.android.account.group_onekey.c.a(r104, r102, r107);
        return;
    L25:
        r107 = false;
        goto L26
    L31:
        return;
    L7:
        r104 = "";
        goto L9
    }
}
