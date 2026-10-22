package com.obric.assistant.onelogin;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.api.main.HomeServiceV2;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\fH\u0014J\b\u0010\u0016\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/onelogin/ObricOneLoginTransparentActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "hasRegisteredLoginTask", "", "launchOAccountLoginForResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "launchOneLoginForResult", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "startOAccountLoginActivity", "startOneLoginActivity", "shouldReturnLoginResult", "onOAccountLoginFinish", "resultCode", "", LiveCommonConstants.REASON_ON_DEDTROY, "requestPortraitSafely", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricOneLoginTransparentActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f390893d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f390894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ActivityResultLauncher<Intent> f390895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ActivityResultLauncher<Intent> f390896c;

    public static final class a {
    }

    static {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ObricOneLoginTransparentActivity.class.getName()));
    L5:
        super.onDestroy();
        if (this.f390894a == false) goto L9;
        FLogger.f375446a.i("ObricOneLoginTransparentActivity", "onDestroy, setLoggingIn false");
        ConcurrentHashMap<String, Boolean> r100 = b.f390917a;
        b.a(getTaskId(), ObricOneLoginTransparentActivity.class.getName(), false);
        return;
    }

    public final void y1() {
        Intent r100 = new Intent(this, ObricOneLoginActivity.class);
        Intent r101 = getIntent();
        if (r101 == null) goto L8;
        Bundle r102 = r101.getExtras();
        if (r102 == null) goto L8;
        r100.putExtras(r102);
    L8:
        if (getIntent().getBooleanExtra("return_login_result", false) == false) goto L10;
    L13:
        this.f390896c.launch(r100);
        return;
    L10:
        if (getCallingActivity() != null) goto L13;
        startActivity(r100);
        finish();
    }

    public ObricOneLoginTransparentActivity() {
        this.f390895b = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new q(this));
        this.f390896c = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new r(this));
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(ObricOneLoginTransparentActivity.class.getName()));
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        v19.f.a(getTheme());
        super.onCreate(r100);
        if (Build.VERSION.SDK_INT != 26) goto L13;
        FLogger.f375446a.i("ObricOneLoginTransparentActivity", "skip request portrait for translucent activity on Android O");
    L14:
        FLogger r101 = FLogger.f375446a;
        r101.i("ObricOneLoginTransparentActivity", "onCreate taskId:" + getTaskId() + ", " + this + ' ');
        if (t9a.b.a().b() == true) goto L17;
        r101.i("ObricOneLoginTransparentActivity", "not ObricOS, jump to MainActivity");
        Intent r102 = new Intent();
        r102.setComponent(new ComponentName(this, HomeServiceV2.f344096a.a()));
        r102.setFlags(335544320);
        startActivity(r102);
        finish();
        return;
    L17:
        ConcurrentHashMap<String, Boolean> r103 = b.f390917a;
        int r104 = getTaskId();
        String r105 = ObricOneLoginTransparentActivity.class.getName();
        Intrinsics.checkNotNullParameter(r105, "tag");
        if (Intrinsics.areEqual(b.f390917a.get(r104 + ':' + r105), Boolean.TRUE) == false) goto L20;
        r101.i("ObricOneLoginTransparentActivity", "Task " + getTaskId() + " is already logging in. Finishing duplicate ObricOneLoginTransparentActivity.");
        finish();
        return;
    L20:
        b.a(getTaskId(), ObricOneLoginTransparentActivity.class.getName(), true);
        this.f390894a = true;
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L23;
        boolean r106 = true;
    L24:
        com.larus.utils.u.f(this, !r106);
        IObricOneLogin r107 = (IObricOneLogin) ServiceManager.get().getService(IObricOneLogin.class);
        if (r107 == null) goto L32;
        r107.a(new p(this));
        return;
    L32:
        return;
    L23:
        r106 = false;
        goto L24
    L13:
        setRequestedOrientation(1);
        goto L14
    }
}
