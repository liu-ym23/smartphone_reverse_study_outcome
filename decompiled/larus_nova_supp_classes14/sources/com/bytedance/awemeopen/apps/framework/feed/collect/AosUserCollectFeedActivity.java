package com.bytedance.awemeopen.apps.framework.feed.collect;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment;
import com.bytedance.awemeopen.apps.framework.framework.AosSimpleBaseActivity;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfigBuilder;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/collect/AosUserCollectFeedActivity;", "Lcom/bytedance/awemeopen/apps/framework/framework/AosSimpleBaseActivity;", "<init>", "()V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosUserCollectFeedActivity extends AosSimpleBaseActivity {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseActivity
    public final boolean y1() {
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosSimpleBaseActivity, com.bytedance.awemeopen.apps.framework.framework.AosBaseActivity
    public final int z1() {
        return 2131558576;
    }

    public AosUserCollectFeedActivity() {
        new LinkedHashMap();
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.AosSimpleBaseActivity, com.bytedance.awemeopen.apps.framework.framework.AosBaseActivity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(AosUserCollectFeedActivity.class.getName()));
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

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosSimpleBaseActivity, com.bytedance.awemeopen.apps.framework.framework.AosBaseActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(AosUserCollectFeedActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.AosSimpleBaseActivity, com.bytedance.awemeopen.apps.framework.framework.AosBaseActivity
    public final void B1() {
        Bundle r0 = getIntent().getExtras();
        boolean r1 = false;
        if (r0 == null) goto L7;
        Byte r2 = r0.getByte("hide_long_press_tab", (byte) 0);
        if (r2 == null) goto L7;
        byte r3 = r2.byteValue();
    L9:
        if (r3 != 1) goto L11;
        boolean r4 = true;
    L12:
        Bundle r5 = getIntent().getExtras();
        if (r5 == null) goto L15;
        String r6 = r5.getString("host_enter_from");
    L16:
        if (r6 != null) goto L18;
        r6 = "";
    L18:
        JSONObject r7 = new JSONObject();
        if (r6.length() <= 0) goto L21;
        r1 = true;
    L21:
        if (r1 == false) goto L23;
        r7.put("host_enter_from", r6);
    L23:
        int r8 = com.bytedance.awemeopen.apps.framework.utils.d.a;
        n44.a r9 = getSupportFragmentManager().findFragmentByTag("tag_AosUserCollectFeedFragment");
        if ((r9 instanceof AosUserCollectFeedFragment) == true) goto L30;
        Object r10 = AosUserCollectFeedFragment.class.newInstance();
        if (r10 == null) goto L29;
        r9 = (AosUserCollectFeedFragment) r10;
    L31:
        AosUserCollectFeedFragment r11 = (AosUserCollectFeedFragment) ((AosBaseFragment) r9);
        Bundle r12 = new Bundle();
        r12.putParcelable("FEED_PAGE_CONFIG_CONFIG_KEY", new FeedPageConfigBuilder().withHideLongPressTab(r4).withShowBackButton(true).withHostCommonParams(r7).build());
        r11.setArguments(r12);
        com.bytedance.awemeopen.apps.framework.utils.d.a.c(getSupportFragmentManager(), 2131372710, r11, "tag_AosUserCollectFeedFragment");
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.feed.collect.AosUserCollectFeedFragment");
    L30:
        AosBaseFragment r13 = (AosBaseFragment) r9;
        goto L31
    L15:
        r6 = null;
        goto L16
    L11:
        r4 = false;
    L7:
        r3 = 0;
        goto L9
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
