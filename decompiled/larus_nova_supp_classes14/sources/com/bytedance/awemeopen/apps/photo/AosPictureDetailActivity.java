package com.bytedance.awemeopen.apps.photo;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment;
import com.bytedance.awemeopen.apps.framework.framework.AosSimpleBaseActivity;
import com.bytedance.awemeopen.export.api.picturedetail.AosPictureDetailConfig;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/photo/AosPictureDetailActivity;", "Lcom/bytedance/awemeopen/apps/framework/framework/AosSimpleBaseActivity;", "<init>", "()V", "a", "ao_apps_photo_release"}, k = 1, mv = {1, 7, 1})
public final class AosPictureDetailActivity extends AosSimpleBaseActivity {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    public static final class b implements n54.b {
        public final /* synthetic */ AosPictureDetailActivity a;

        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "aid");
        }

        public final void b() {
        }

        public final void c() {
            this.a.finish();
        }

        public b(AosPictureDetailActivity r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosSimpleBaseActivity, com.bytedance.awemeopen.apps.framework.framework.AosBaseActivity
    public final int z1() {
        return 2131558580;
    }

    public AosPictureDetailActivity() {
        new LinkedHashMap();
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.AosSimpleBaseActivity, com.bytedance.awemeopen.apps.framework.framework.AosBaseActivity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(AosPictureDetailActivity.class.getName()));
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
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(AosPictureDetailActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.AosSimpleBaseActivity, com.bytedance.awemeopen.apps.framework.framework.AosBaseActivity
    public final void B1() {
        Parcelable r0 = (AosPictureDetailConfig) getIntent().getParcelableExtra("PICTURE_DETAIL_CONFIG_KEY");
        if (r0 == null) goto L6;
        r0.setShouldPaddingStatusBarHeight(true);
    L6:
        int r2 = com.bytedance.awemeopen.apps.framework.utils.d.a;
        n54.a r3 = getSupportFragmentManager().findFragmentByTag("tag_AosPicturePageFragment");
        if ((r3 instanceof AosPictureDetailFragment) == true) goto L13;
        Object r4 = AosPictureDetailFragment.class.newInstance();
        if (r4 == null) goto L12;
        r3 = (AosPictureDetailFragment) r4;
    L14:
        AosPictureDetailFragment r5 = (AosPictureDetailFragment) ((AosBaseFragment) r3);
        Bundle r6 = new Bundle();
        r6.putParcelable("PICTURE_DETAIL_CONFIG_KEY", r0);
        r5.setArguments(r6);
        r5.i = new b(this);
        com.bytedance.awemeopen.apps.framework.utils.d.a.c(getSupportFragmentManager(), 2131372710, r5, "tag_AosPicturePageFragment");
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.awemeopen.apps.photo.AosPictureDetailFragment");
    L13:
        AosBaseFragment r7 = (AosBaseFragment) r3;
        goto L14
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

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseActivity
    public final void onBackPressed() {
        super.onBackPressed();
    }
}
