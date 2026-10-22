package com.ss.android.lark.officesdk.minutes.ui.record.recording;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route.MmRecordingEntity;
import com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseActivity;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingFragment;
import com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationSlotsProvider;
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import uvb.c;
import v19.f;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/MmBaseRecordingActivity;", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/mvi/MmBaseActivity;", "<init>", "()V", "keepScreenOn", "", "getKeepScreenOn", "()Z", "recordingIdForUiControl", "", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class MmBaseRecordingActivity extends MmBaseActivity {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f435923d = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f435924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f435925c;

    public static final class a {
        @JvmStatic
        public static void a(Context r100, String r101, MmRecordingEntity r102, UserSession r103) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "activityClassName");
            Intrinsics.checkNotNullParameter(r102, "entity");
            Intrinsics.checkNotNullParameter(r103, "userSession");
            if (LarkContext.getApplication() != null) goto L6;
            int r104 = bwb.b.f21271a;
            bwb.b.d(MmUiLogScene.RECORDING, "start", "start failed: Application not initialized", null);
            return;
        L6:
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "activityClassName");
            Intrinsics.checkNotNullParameter(r102, "entity");
            Intrinsics.checkNotNullParameter(r103, "userSession");
            Intent r105 = new Intent().setClassName(r100, r101);
            if ((r100 instanceof Activity) == true) goto L9;
            r105.addFlags(268435456);
        L9:
            r105.putExtra("MM_RECORDING_ENTITY_EXTRA", r102);
            r105.putExtra("MM_USER_SESSION_EXTRA", r103);
            r100.startActivity(r105);
        }
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(getClass().getName()));
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

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        final String r100 = this.f435925c;
        if (r100 == null) goto L8;
        Handler r101 = b.f436138a;
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        Intrinsics.checkNotNullParameter(this, "activity");
        b.a(new MmRecordingUiController$unregisterRecordingPage$1(r100, this));
    L8:
        this.f435925c = null;
        super.onDestroy();
    }

    public MmBaseRecordingActivity() {
        this.f435924b = true;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseActivity
    public final boolean A1() {
        return this.f435924b;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r100);
        setContentView(com.larus.nova.R.layout.office_sdk_mm_activity_recording);
        View r101 = findViewById(com.larus.nova.R.id.container);
        int r102 = uvb.b.f551863a;
        uvb.a.b(r101, c.f551865a);
        Serializable r103 = getIntent().getSerializableExtra("MM_RECORDING_ENTITY_EXTRA");
        if ((r103 instanceof MmRecordingEntity) == false) goto L13;
        MmRecordingEntity r104 = (MmRecordingEntity) r103;
    L14:
        UserSession r105 = (UserSession) getIntent().getParcelableExtra("MM_USER_SESSION_EXTRA");
        if (r104 != null) goto L18;
        int r106 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.RECORDING, WidgetCostModule.TYPE_ON_CREATE, "entity is null", null);
        finish();
        return;
    L18:
        if (r104.getUiLaunchMode().shouldHandleUI() == true) goto L20;
        int r107 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.RECORDING, WidgetCostModule.TYPE_ON_CREATE, "uiLaunchMode is invalid, ui=" + r104.getUiLaunchMode(), null);
        finish();
        return;
    L20:
        e r108 = e.f436896a;
        MmRecordingUILaunchMode r109 = r104.getUiLaunchMode();
        r108.getClass();
        if (e.c(r109) != null) goto L23;
        int r110 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.RECORDING, WidgetCostModule.TYPE_ON_CREATE, "ui provider is missing, ui=" + r104.getUiLaunchMode(), null);
        finish();
        return;
    L23:
        if (r105 != null) goto L26;
        int r111 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.RECORDING, WidgetCostModule.TYPE_ON_CREATE, "userSession is null", null);
        finish();
        return;
    L26:
        if (isFinishing() == false) goto L28;
    L43:
        int r112 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.RECORDING, WidgetCostModule.TYPE_ON_CREATE, "Activity is finishing or destroyed, skip fragment transaction", null);
        return;
    L28:
        if (isDestroyed() == true) goto L43;
        this.f435925c = r104.getRecordingId();
        Handler r113 = b.f436138a;
        final String r114 = r104.getRecordingId();
        Intrinsics.checkNotNullParameter(r114, "recordingId");
        Intrinsics.checkNotNullParameter(this, "activity");
        b.a(new MmRecordingUiController$registerRecordingPage$1(r114, this));
        int r115 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.RECORDING, WidgetCostModule.TYPE_ON_CREATE, "start fragment transaction uiLaunchMode=" + r104.getUiLaunchMode(), null, 8);
        int r116 = MmRecordingFragment.f436147J;
        MmRecordingFragment r117 = MmRecordingFragment.a.a(r104, r105);
        MmRecordingSource r118 = r104.getSource();
        if (r118 == null) goto L35;
        boolean r119 = true;
        if (r118.isStandaloneAIInterpretationSource() != true) goto L35;
    L36:
        if (r119 == false) goto L38;
        int r120 = MmStandaloneAIInterpretationSlotsProvider.f436730a;
        r117.la0(MmStandaloneAIInterpretationSlotsProvider.b(r104.getUiLaunchMode()));
    L38:
        FragmentTransaction r121 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r121, r117, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, com.larus.nova.R.id.container) == true) goto L42;
        r121 = r121.replace(com.larus.nova.R.id.container, r117);
    L42:
        r121.commitAllowingStateLoss();
        return;
    L35:
        r119 = false;
        goto L36
    L13:
        r104 = null;
        goto L14
    }
}
