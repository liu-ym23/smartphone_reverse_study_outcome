package com.bytedance.awemeopen.apps.framework.profile;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment;
import com.bytedance.awemeopen.apps.framework.framework.AosSimpleBaseActivity;
import com.bytedance.awemeopen.apps.framework.utils.reporter.HostCommonParamProvider;
import com.bytedance.awemeopen.export.api.pageconfig.profile.ProfilePageConfig;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/profile/AosUserProfileActivity;", "Lcom/bytedance/awemeopen/apps/framework/framework/AosSimpleBaseActivity;", "<init>", "()V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosUserProfileActivity extends AosSimpleBaseActivity {
    public static final /* synthetic */ int c = 0;
    public c a;
    public HostCommonParamProvider b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosSimpleBaseActivity, com.bytedance.awemeopen.apps.framework.framework.AosBaseActivity
    public final int z1() {
        return 2131558584;
    }

    public AosUserProfileActivity() {
        new LinkedHashMap();
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0120 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.AosSimpleBaseActivity, com.bytedance.awemeopen.apps.framework.framework.AosBaseActivity
    public final void finish() {
        super.finish();
        d14.a r2 = b14.a.a;
        b14.a.a(t24.a.class).z0(this.a);
        b14.a.a(t24.a.class).z0(this.b);
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r3 = FLogger.a;
        r3.i("ActivityLancet", "finish ".concat(AosUserProfileActivity.class.getName()));
        long r4 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r4));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r3.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r3.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r3.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r3.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r3.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
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
        r3.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r4 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosSimpleBaseActivity, com.bytedance.awemeopen.apps.framework.framework.AosBaseActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(AosUserProfileActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.awemeopen.apps.framework.profile.c] */
    @Override // com.bytedance.awemeopen.apps.framework.framework.AosSimpleBaseActivity, com.bytedance.awemeopen.apps.framework.framework.AosBaseActivity
    public final void B1() {
        Bundle r0 = getIntent().getBundleExtra("PROFILE_PAGE_CONFIG_CONFIG_KEY_BUNDLE");
        Context r1 = BadParcelableCrashOptimizer.getContext();
        if (r0 == null) goto L6;
        if (r1 == null) goto L6;
        r0.setClassLoader(r1.getClassLoader());
    L6:
        String r2 = null;
        if (r0 == null) goto L9;
        final ProfilePageConfig r3 = r0.getParcelable("PROFILE_PAGE_CONFIG_CONFIG_KEY");
    L10:
        Bundle r4 = getIntent().getExtras();
        if (r3 == null) goto L14;
        r2 = r3.getOpenId();
    L14:
        if (r2 != null) goto L16;
    L19:
        boolean r5 = true;
    L20:
        if (r5 == false) goto L23;
        finish();
        return;
    L23:
        this.a = new c(r3);
        this.b = new HostCommonParamProvider(r3.getHostCommonParams());
        d14.a r6 = b14.a.a;
        b14.a.a(t24.a.class).H1(this.a);
        b14.a.a(t24.a.class).H1(this.b);
        int r7 = com.bytedance.awemeopen.apps.framework.utils.d.a;
        n44.a r8 = getSupportFragmentManager().findFragmentByTag("tag_AosProfileManagerFragment");
        if ((r8 instanceof AosProfileManagerFragment) == true) goto L30;
        Object r9 = AosProfileManagerFragment.class.newInstance();
        if (r9 == null) goto L29;
        r8 = (AosProfileManagerFragment) r9;
    L31:
        AosProfileManagerFragment r10 = (AosProfileManagerFragment) ((AosBaseFragment) r8);
        Bundle r11 = new Bundle();
        r11.putParcelable("PROFILE_PAGE_CONFIG_CONFIG_KEY", r3);
        if (r4 == null) goto L34;
        r11.putBundle("extra", r4);
        r11.putString("user_profile_feed_enter_method", r4.getString("user_profile_feed_enter_method"));
    L34:
        r11.putBoolean("is_from_profile_activity", true);
        r10.setArguments(r11);
        com.bytedance.awemeopen.apps.framework.utils.d.a.c(getSupportFragmentManager(), 2131372710, r10, "tag_AosProfileManagerFragment");
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.profile.AosProfileManagerFragment");
    L30:
        AosBaseFragment r12 = (AosBaseFragment) r8;
        goto L31
    L16:
        if (r2.length() == 0) goto L19;
        r5 = false;
        goto L20
    L9:
        r3 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
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
}
