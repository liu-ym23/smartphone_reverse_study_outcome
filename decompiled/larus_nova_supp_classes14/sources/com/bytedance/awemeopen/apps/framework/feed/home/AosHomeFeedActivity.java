package com.bytedance.awemeopen.apps.framework.feed.home;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment;
import com.bytedance.awemeopen.apps.framework.framework.AosSimpleBaseActivity;
import com.bytedance.awemeopen.apps.framework.utils.AosPreloadHelper;
import com.bytedance.awemeopen.apps.framework.utils.d;
import com.bytedance.awemeopen.bizmodels.feed.preload.AosPreloadFeedListReason;
import com.bytedance.awemeopen.export.api.pageconfig.feedhome.FeedsHomePageConfig;
import com.bytedance.awemeopen.export.api.pageconfig.feedhome.FeedsHomePageConfigBuilder;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import j04.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/home/AosHomeFeedActivity;", "Lcom/bytedance/awemeopen/apps/framework/framework/AosSimpleBaseActivity;", "<init>", "()V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosHomeFeedActivity extends AosSimpleBaseActivity {
    public static final /* synthetic */ int b = 0;
    public AosFeedsHomeFragment a;

    public static final class a {
        public static void a(Context r3, FeedsHomePageConfig r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "pageConfig");
            Intent r0 = new Intent(r3, AosHomeFeedActivity.class);
            r0.addFlags(268435456);
            r0.putExtra("key_data_parcelable", r4);
            j04.a r1 = b.a;
            b.a("enter_play", Long.valueOf(r4.getClickFeedTimeStamp()));
            r3.startActivity(r0);
        }
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseActivity
    public final boolean y1() {
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosSimpleBaseActivity, com.bytedance.awemeopen.apps.framework.framework.AosBaseActivity
    public final int z1() {
        return 2131558577;
    }

    public AosHomeFeedActivity() {
        new LinkedHashMap();
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.AosSimpleBaseActivity, com.bytedance.awemeopen.apps.framework.framework.AosBaseActivity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(AosHomeFeedActivity.class.getName()));
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.AosSimpleBaseActivity, com.bytedance.awemeopen.apps.framework.framework.AosBaseActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L20;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(AosHomeFeedActivity.class.getName()));
    L20:
        super.onDestroy();     // Catch: Exception -> L7
    L8:
        FeedsHomePageConfig r0 = getIntent().getParcelableExtra("key_data_parcelable");
        String r1 = null;
        if (r0 == null) goto L11;
        String r2 = r0.getEnterAids();
    L13:
        if (TextUtils.isEmpty(r2) == false) goto L22;
        if (r0 == null) goto L17;
        r1 = r0.getEnterHostGids();
    L17:
        if (TextUtils.isEmpty(r1) == false) goto L23;
        AosPreloadHelper r3 = AosPreloadHelper.a;
        AosPreloadHelper.c(AosPreloadFeedListReason.SDK_ON_EXIT_RECOMMEND_PAGE);
        return;
    L23:
        return;
    L22:
        return;
    L11:
        r2 = null;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.AosSimpleBaseActivity, com.bytedance.awemeopen.apps.framework.framework.AosBaseActivity
    public final void B1() {
        FeedsHomePageConfig r0 = getIntent().getParcelableExtra("key_data_parcelable");
        AosFeedsHomeFragment r1 = null;
        if (r0 != null) goto L5;
        FeedsHomePageConfigBuilder.Companion.getClass();
        r0 = new FeedsHomePageConfigBuilder(null).build();
    L5:
        d14.a r2 = b14.a.a;
        b14.a.a(t24.a.class).p2(r0.getExtraEventParams());
        int r3 = d.a;
        n44.a r4 = getSupportFragmentManager().findFragmentByTag("tag_AosRecommendFeedFragment");
        if ((r4 instanceof AosFeedsHomeFragment) == true) goto L12;
        Object r5 = AosFeedsHomeFragment.class.newInstance();
        if (r5 == null) goto L11;
        r4 = (AosFeedsHomeFragment) r5;
    L13:
        AosFeedsHomeFragment r6 = (AosFeedsHomeFragment) ((AosBaseFragment) r4);
        Bundle r7 = new Bundle();
        r7.putParcelable("arguments_AosFeedsHomeFragment", (Parcelable) r0);
        r6.setArguments(r7);
        this.a = r6;
        FragmentManager r8 = getSupportFragmentManager();
        AosFeedsHomeFragment r9 = this.a;
        if (r9 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("homeFeedFragment");
    L17:
        r1.getClass();
        d.a.c(r8, 2131372710, r1, "tag_AosRecommendFeedFragment");
        return;
    L16:
        r1 = r9;
        goto L17
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.feed.home.AosFeedsHomeFragment");
    L12:
        AosBaseFragment r10 = (AosBaseFragment) r4;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == c.a) goto L9;
        c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }
}
