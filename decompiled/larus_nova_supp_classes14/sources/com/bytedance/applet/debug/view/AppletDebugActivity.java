package com.bytedance.applet.debug.view;

import android.R;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ai.api.DebuggerMode;
import com.bytedance.ai.api.IAppletDebuggerService;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.applet.databinding.LarusAppletDebugActivityBinding;
import com.bytedance.applet.debug.AppletDebugManager;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001DB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0014J\u0012\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\"\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018H\u0014J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\tH\u0016J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\tH\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\b\u0010\"\u001a\u00020\u000eH\u0016J\b\u0010#\u001a\u00020\u0011H\u0002J\b\u0010$\u001a\u00020\u0011H\u0002J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\u0011H\u0002J\u0010\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020'H\u0002J\u0012\u0010+\u001a\u00020\u00112\b\b\u0001\u0010,\u001a\u00020\u001bH\u0002J\u0010\u0010+\u001a\u00020\u00112\u0006\u0010-\u001a\u00020'H\u0002J\u0010\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020'H\u0002J\"\u00100\u001a\u00020\u00112\u0006\u00101\u001a\u00020'2\u0006\u00102\u001a\u00020'2\b\b\u0002\u00103\u001a\u00020\u000eH\u0002J\u0012\u00104\u001a\u00020\u00112\b\b\u0002\u00105\u001a\u00020\u000eH\u0002J\u0012\u00106\u001a\u00020\u00112\b\b\u0002\u00107\u001a\u00020\u000eH\u0002J\u0010\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u00020\u0011H\u0002J\u0010\u0010<\u001a\u00020\u00112\u0006\u0010=\u001a\u00020>H\u0002J\b\u0010?\u001a\u00020\u0011H\u0002J \u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020'2\b\u0010B\u001a\u0004\u0018\u00010'H\u0082@¢\u0006\u0002\u0010CR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\t0\bj\n\u0012\u0006\u0012\u0004\u0018\u00010\t`\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/bytedance/applet/debug/view/AppletDebugActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "Lcom/larus/ivykit/xbridge/choosemedia/IActivityResult;", "<init>", "()V", "binding", "Lcom/bytedance/applet/databinding/LarusAppletDebugActivityBinding;", "mActivityResultListeners", "Ljava/util/ArrayList;", "Lcom/larus/ivykit/xbridge/choosemedia/ActivityResultListener;", "Lkotlin/collections/ArrayList;", "installDebugPackageJob", "Lkotlinx/coroutines/Job;", "callerIsMainBotChatPage", "", "getDebugSchemaJob", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initViews", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onActivityResult", "requestCode", "", "resultCode", "data", "setActivityResultListener", "listener", "unsetActivityResultListener", "needAdaptStatusBarPadding", "needAdaptNavigationBarPadding", "handleIntent", "navigateToDebugTarget", "openUgcBotChatPage", "botId", "", "openMainBotPage", "finishWithErrorMessage", "errorMessage", "finishWithToast", "textResId", "text", "startGetDebugSchemaAsync", "shortToken", "startDebugModeAsync", "debugInfo", "debugToken", "isLegacy", "showLoadingState", "hideDebugView", "hideLoadingState", "showDebugView", "displayDebugConfig", "debugConfigObj", "Lorg/json/JSONObject;", "showDebugConfig", "showJustExitDialog", "activity", "Landroid/app/Activity;", "restartApp", "navigateToDebuggerActivity", "packageName", "versionTag", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletDebugActivity extends FlowCommonAppCompatActivity implements ug9.b {
    public static final /* synthetic */ int l = 0;
    public LarusAppletDebugActivityBinding g;
    public final ArrayList<ug9.a> h;
    public Job i;
    public boolean j;
    public Job k;

    public static final class a {
    }

    static {
    }

    public final boolean H1() {
        return true;
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(AppletDebugActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L48;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(AppletDebugActivity.class.getName()));
    L5:
        Job r0 = this.k;
        boolean r1 = false;
        if (r0 != null) goto L8;
    L15:
        Job r2 = this.i;
        if (r2 != null) goto L18;
    L25:
        com.bytedance.ai.utils.g.a.e("AppletDebugActivity", "onDestroy");
        super.onDestroy();
        return;
    L18:
        if (r2.isCompleted() != true) goto L20;
        r1 = true;
    L20:
        if (r1 == true) goto L25;
        com.bytedance.ai.utils.g.a.w("AppletDebugActivity", "AppletDebugActivity finish when installDebugPackageJob is NOT Completed");
        Job r3 = this.i;
        if (r3 == null) goto L24;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L24:
        AppletDebugManager.c(null, "");
        IAISDKDebugService.Companion r4 = IAISDKDebugService.a;
        r4.l(null, null);
        r4.c(null);
        goto L25
    L8:
        if (r0.isCompleted() != true) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == true) goto L15;
        com.bytedance.ai.utils.g.a.w("AppletDebugActivity", "AppletDebugActivity finish when getDebugSchemaJob is NOT Completed");
        Job r6 = this.k;
        if (r6 == null) goto L15;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
        goto L15
    L10:
        r5 = false;
        goto L11
    }

    public AppletDebugActivity() {
        this.h = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void handleIntent() {
        this.j = getIntent().getBooleanExtra("callerIsMainBotChatPage", false);
        String r0 = getIntent().getStringExtra("actionName");
        if (r0 != null) goto L5;
        P1("invalid action");
        return;
    L5:
        if (Intrinsics.areEqual(r0, "showDebugInfo") == false) goto L14;
        S1(false);
        boolean r1 = AppletDebugManager.a;
        String r2 = IAISDKDebugService.a.o();
        if (r2 != null) goto L29;
        P1("DebugInfo is empty");
        return;
    L29:
        O1(new JSONObject(r2));     // Catch: JSONException -> L10
        return;
    L10:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("AppletDebugActivity", "Failed to parse debugInfo: " + e.getMessage() + ", debugInfo: " + r2);
        Q1(2131894337);
        return;
    L14:
        if (Intrinsics.areEqual(r0, "startDebug") == false) goto L26;
        LarusAppletDebugActivityBinding r3 = this.g;
        if (r3 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L18:
        r3.a.post(new g());
        String r4 = getIntent().getStringExtra("shortToken");
        String r6 = getIntent().getStringExtra("debugInfo");
        String r8 = getIntent().getStringExtra("debugToken");
        if (r4 == null) goto L21;
        this.k = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AppletDebugActivity$startGetDebugSchemaAsync$1(this, r4, null), 3, null);
        return;
    L21:
        if (r6 == null) goto L25;
        if (r8 == null) goto L24;
        this.i = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AppletDebugActivity$startDebugModeAsync$1(this, r6, true, r8, null), 3, null);
        return;
    L24:
        P1("debugToken is empty");
        return;
    L25:
        P1("debugInfo is empty");
        return;
    L26:
        P1("invalid action");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
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

    public final void I0(ug9.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.h.add(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void O1(JSONObject r7) {
        R1(true);
        ArrayList r1 = new ArrayList();
        Iterator<String> r2 = r7.keys();
    L4:
        if (r2.hasNext() == false) goto L6;
        String r3 = r2.next();
        r1.add(new Pair(r3, r7.optString(r3)));
        goto L4
    L6:
        DebugInfoAdapter r8 = new DebugInfoAdapter(r1);
        LarusAppletDebugActivityBinding r4 = this.g;
        LarusAppletDebugActivityBinding r5 = null;
        if (r4 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L9:
        r4.d.setAdapter(r8);
        LarusAppletDebugActivityBinding r9 = this.g;
        if (r9 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L13:
        r5.c.setVisibility(0);
        AppletDebugManager.a = true;
        Context r10 = v.a;
        Intrinsics.checkNotNullParameter(this, "context");
        if (v.c.compareAndSet(false, true) == true) goto L16;
        com.bytedance.ai.utils.g.a.i("AppletDebugWindowHelper", "AppletDebugWindowHelper is already initialized. skip it");
    L21:
        v.b(true);
        return;
    L16:
        com.bytedance.ai.utils.g.a.i("AppletDebugWindowHelper", "AppletDebugWindowHelper init");
        if ((this instanceof Application) == false) goto L19;
        Application r11 = (Application) this;
    L20:
        v.a = r11;
        AppHost.Companion r12 = AppHost.a;
        r12.getApplication().registerActivityLifecycleCallbacks(new t());
        v.a(!r12.a().isAppBackground(), r12.a().getCurrentActivity());
        goto L21
    L19:
        Context r13 = getApplicationContext();
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.app.Application");
        r11 = (Application) r13;
        goto L20
    L12:
        r5 = r9;
        goto L13
    }

    public final void P1(String r3) {
        com.bytedance.ai.utils.g.a.e("AppletDebugActivity", r3);
        finish();
    }

    public final void Q1(int r7) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AppletDebugActivity$finishWithToast$1(this, r7, null), 3, null);
    }

    public final void R1(boolean r6) {
        LarusAppletDebugActivityBinding r0 = this.g;
        LarusAppletDebugActivityBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.f.setVisibility(8);
        LarusAppletDebugActivityBinding r2 = this.g;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L8:
        r2.g.setEnabled(true);
        LarusAppletDebugActivityBinding r3 = this.g;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L11:
        r3.g.setAlpha(1.0f);
        LarusAppletDebugActivityBinding r4 = this.g;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L14:
        r4.h.setEnabled(true);
        LarusAppletDebugActivityBinding r5 = this.g;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L17:
        r5.h.setAlpha(1.0f);
        LarusAppletDebugActivityBinding r7 = this.g;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L20:
        r7.b.setEnabled(true);
        LarusAppletDebugActivityBinding r8 = this.g;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L23:
        r8.b.setAlpha(1.0f);
        if (r6 == false) goto L40;
        LarusAppletDebugActivityBinding r9 = this.g;
        if (r9 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L28:
        r9.c.setVisibility(0);
        LarusAppletDebugActivityBinding r10 = this.g;
        if (r10 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L31:
        r10.h.setVisibility(0);
        LarusAppletDebugActivityBinding r11 = this.g;
        if (r11 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L34:
        r11.b.setVisibility(0);
        LarusAppletDebugActivityBinding r12 = this.g;
        if (r12 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L38:
        r1.g.setVisibility(0);
        return;
    L37:
        r1 = r12;
        goto L38
    }

    public final void S(com.larus.bmhome.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.h.remove(r2);
    }

    public final void S1(boolean r6) {
        LarusAppletDebugActivityBinding r0 = this.g;
        LarusAppletDebugActivityBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.f.setVisibility(0);
        LarusAppletDebugActivityBinding r2 = this.g;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L8:
        r2.g.setEnabled(false);
        LarusAppletDebugActivityBinding r3 = this.g;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L11:
        r3.g.setAlpha(0.6f);
        LarusAppletDebugActivityBinding r4 = this.g;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L14:
        r4.h.setEnabled(false);
        LarusAppletDebugActivityBinding r5 = this.g;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L17:
        r5.h.setAlpha(0.6f);
        LarusAppletDebugActivityBinding r7 = this.g;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L20:
        r7.b.setEnabled(false);
        LarusAppletDebugActivityBinding r8 = this.g;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L23:
        r8.b.setAlpha(0.6f);
        if (r6 == false) goto L40;
        LarusAppletDebugActivityBinding r9 = this.g;
        if (r9 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L28:
        r9.c.setVisibility(8);
        LarusAppletDebugActivityBinding r10 = this.g;
        if (r10 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L31:
        r10.h.setVisibility(8);
        LarusAppletDebugActivityBinding r11 = this.g;
        if (r11 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L34:
        r11.b.setVisibility(8);
        LarusAppletDebugActivityBinding r12 = this.g;
        if (r12 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L38:
        r1.g.setVisibility(8);
        return;
    L37:
        r1 = r12;
        goto L38
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r13) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r13);
        LarusAppletDebugActivityBinding r1 = null;
        ConstraintLayout r14 = getLayoutInflater().inflate(2131561807, null, false);
        int r0 = 2131366992;
        Button r5 = (Button) ViewBindings.findChildViewById(r14, 2131366992);
        if (r5 == null) goto L54;
        r0 = 2131368595;
        ScrollView r6 = (ScrollView) ViewBindings.findChildViewById(r14, 2131368595);
        if (r6 == null) goto L54;
        r0 = 2131368596;
        RecyclerView r7 = ViewBindings.findChildViewById(r14, 2131368596);
        if (r7 == null) goto L54;
        r0 = 2131368614;
        SwitchCompat r8 = ViewBindings.findChildViewById(r14, 2131368614);
        if (r8 == null) goto L54;
        r0 = 2131379050;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(r14, 2131379050);
        if (r9 == null) goto L54;
        r0 = 2131379091;
        if (((ProgressBar) ViewBindings.findChildViewById(r14, 2131379091)) == null) goto L54;
        ConstraintLayout r2 = r14;
        Button r10 = (Button) ViewBindings.findChildViewById(r14, 2131380634);
        if (r10 == null) goto L52;
        Button r11 = (Button) ViewBindings.findChildViewById(r14, 2131392213);
        if (r11 == null) goto L51;
        this.g = new LarusAppletDebugActivityBinding(r2, r5, r6, r7, r8, r9, r10, r11);
        setContentView(r2);
        getOnBackPressedDispatcher().addCallback(this, new AppletDebugActivity$initViews$callback$1(this));
        LarusAppletDebugActivityBinding r15 = this.g;
        if (r15 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L29:
        r15.d.setLayoutManager(new LinearLayoutManager(this));
        LarusAppletDebugActivityBinding r16 = this.g;
        if (r16 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L32:
        e1.d(r16.b, new c(this));
        LarusAppletDebugActivityBinding r17 = this.g;
        if (r17 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L35:
        e1.d(r17.g, new d(this));
        LarusAppletDebugActivityBinding r18 = this.g;
        if (r18 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L38:
        e1.d(r18.h, new e(this));
        LarusAppletDebugActivityBinding r19 = this.g;
        if (r19 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L41:
        SwitchCompat r110 = r19.e;
        IAISDKDebugService.a.getClass();
        IAISDKDebugService r3 = IAISDKDebugService.Companion.c;
        if (r3 == null) goto L44;
        boolean r4 = r3.n();
    L45:
        r110.setChecked(r4);
        LarusAppletDebugActivityBinding r111 = this.g;
        if (r111 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L49:
        r1.e.setOnCheckedChangeListener(new f());
        handleIntent();
        return;
    L48:
        r1 = r111;
        goto L49
    L44:
        r4 = true;
        goto L45
    L51:
        r0 = 2131392213;
        goto L54
    L52:
        r0 = 2131380634;
    L54:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r0)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNewIntent(Intent r1) {
        super/*androidx.fragment.app.FragmentActivity*/.onNewIntent(r1);
        if (r1 == null) goto L5;
        setIntent(r1);
    L5:
        handleIntent();
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        super.onActivityResult(r3, r4, r5);
        Iterator<ug9.a> r0 = this.h.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ug9.a r1 = r0.next();
        if (r1 == null) goto L4;
        r1.onActivityResult(r3, r4, r5);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object N1(final AppletDebugActivity r8, String r9, String r10, Continuation r11) {
        r8.getClass();
        if ((r11 instanceof AppletDebugActivity$navigateToDebuggerActivity$1) == false) goto L7;
        AppletDebugActivity$navigateToDebuggerActivity$1 r0 = (AppletDebugActivity$navigateToDebuggerActivity$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        AppletDebugActivity$navigateToDebuggerActivity$1 r5 = r0;
        Object r12 = r5.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r5.label;
        boolean r7 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r9 = (String) r5.L$0;
        ResultKt.throwOnFailure(r12);
    L20:
        if (((Boolean) r12).booleanValue() == true) goto L23;
    L22:
        r7 = false;
    L23:
        if (r7 == true) goto L25;
        IAISDKDebugService.Companion r13 = IAISDKDebugService.a;
        r13.l(r9, null);
        r8.Q1(2131894379);
        r13.c(new b(r8));
    L27:
        return Unit.INSTANCE;
    L25:
        r8.finish();
        goto L27
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        IAISDKDebugService.a.l(r9, r10);
        IAppletDebuggerService r4 = (IAppletDebuggerService) ServiceManager.get().getService(IAppletDebuggerService.class);
        if (r4 == null) goto L22;
        DebuggerMode r6 = DebuggerMode.ONLINE_PREVIEW;
        r5.L$0 = r9;
        r5.label = 1;
        r12 = IAppletDebuggerService.a.a(r4, r8, "scan", r6, r5, 8);
        if (r12 != r2) goto L20;
        return r2;
    L7:
        r0 = new AppletDebugActivity$navigateToDebuggerActivity$1(r8, r11);
        goto L8
    }
}
