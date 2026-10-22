package com.bytedance.applet.view;

import android.R;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u0004\u0018\u00010\fJ\b\u0010\u0016\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0014J\b\u0010\u001a\u001a\u00020\u0012H\u0014J\b\u0010\u001b\u001a\u00020\u0012H\u0014J\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\"\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0007H\u0016J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0007H\u0016R\"\u0010\u0005\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/applet/view/AppletActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "Lcom/larus/ivykit/xbridge/choosemedia/IActivityResult;", "<init>", "()V", "mActivityResultListeners", "Ljava/util/ArrayList;", "Lcom/larus/ivykit/xbridge/choosemedia/ActivityResultListener;", "Lkotlin/collections/ArrayList;", "fg", "Lcom/bytedance/applet/view/AppletFragment;", "url", "", "transStatusBar", "", "transNavigationBar", "fullScreen", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getAppId", "parseArguments", "needAdaptStatusBarPadding", "needAdaptNavigationBarPadding", "onResume", "onPause", "onDestroy", "onSaveInstanceState", "outState", "outPersistentState", "Landroid/os/PersistableBundle;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "setActivityResultListener", "listener", "unsetActivityResultListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletActivity extends FlowCommonAppCompatActivity implements ug9.b {
    public final ArrayList<ug9.a> g;
    public AppletFragment h;
    public String i;
    public boolean j;
    public boolean k;
    public boolean l;

    public final boolean H1() {
        return !this.k;
    }

    public final boolean K1() {
        if (this.j == true) goto L5;
    L8:
        return true;
    L5:
        if (this.l == false) goto L8;
        return false;
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(AppletActivity.class.getName()));
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

    public final String getAppId() {
        AppletFragment r0 = this.h;
        if (r0 == null) goto L7;
        com.bytedance.ai.model.widgets.c r1 = r0.k;
        if (r1 == null) goto L7;
        return r1.getAppletId();
    L7:
        return null;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(AppletActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public AppletActivity() {
        this.g = new ArrayList();
        this.l = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        N1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public final void onPause() {
        super/*androidx.fragment.app.FragmentActivity*/.onPause();
    }

    public final void onResume() {
        super.onResume();
    }

    public static View N1(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void I0(ug9.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.g.add(r2);
    }

    public final void S(com.larus.bmhome.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.g.remove(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r5) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r5);
        setContentView(2131561787);
        Window r6 = getWindow();
        if (r6 == null) goto L13;
        View r7 = N1(r6);
    L14:
        setRootView(r7);
        L1();
        Bundle r8 = getIntent().getExtras();
        if (r8 == null) goto L18;
        String r9 = r8.getString("url");
        if (r9 == null) goto L18;
    L24:
        this.i = r9;
        Bundle r10 = getIntent().getExtras();
        boolean r2 = true;
        if (r10 == null) goto L27;
        boolean r11 = r10.getBoolean("fullScreen", true);
    L28:
        this.l = r11;
        String r12 = this.i;
        if (r12 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("url");
        r12 = null;
    L31:
        Uri r13 = UriProtector.parse(r12);
        boolean r3 = false;
        this.j = r13.getBooleanQueryParameter("transStatusBar", false);
        this.k = r13.getBooleanQueryParameter("transNavigationBar", false);
        Bundle r14 = getIntent().getExtras();
        if (r14 == null) goto L40;
        String r15 = r14.getString("pageId");
        if (r15 == null) goto L40;
        AppletRuntimeManager.INSTANCE.getClass();
        if (AppletRuntimeManager.e(r15) != null) goto L39;
        r2 = false;
    L39:
        r3 = r2;
    L40:
        if (r3 == true) goto L42;
        finish();
        return;
    L42:
        AppletFragment r16 = new AppletFragment();
        this.h = r16;
        r16.setArguments(getIntent().getExtras());
        FragmentTransaction r17 = getSupportFragmentManager().beginTransaction();
        AppletFragment r1 = this.h;
        Intrinsics.checkNotNull(r1);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r17, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L46;
        r17 = r17.replace(2131373275, r1);
    L46:
        r17.commitAllowingStateLoss();
        return;
    L27:
        r11 = true;
    L18:
        Bundle r18 = getIntent().getExtras();
        if (r18 == null) goto L21;
        r9 = r18.getString("link_url");
    L22:
        if (r9 != null) goto L24;
        r9 = "";
        goto L24
    L21:
        r9 = null;
        goto L22
    L13:
        r7 = null;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSaveInstanceState(Bundle r2, PersistableBundle r3) {
        Intrinsics.checkNotNullParameter(r2, "outState");
        Intrinsics.checkNotNullParameter(r3, "outPersistentState");
        super/*android.app.Activity*/.onSaveInstanceState(r2, r3);
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        super.onActivityResult(r3, r4, r5);
        Iterator<ug9.a> r0 = this.g.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ug9.a r1 = r0.next();
        if (r1 == null) goto L4;
        r1.onActivityResult(r3, r4, r5);
        goto L4
    }
}
