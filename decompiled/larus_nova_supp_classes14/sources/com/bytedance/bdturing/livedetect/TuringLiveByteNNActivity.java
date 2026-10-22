package com.bytedance.bdturing.livedetect;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.live.TuringLive;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import vb4.d;
import vb4.e;
import vb4.l;
import vb4.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class TuringLiveByteNNActivity extends TuringLiveDetectActivity implements a$c {
    public static final /* synthetic */ int D = 0;
    public final AtomicBoolean A;
    public boolean B;
    public final a C;
    public final AtomicBoolean z;

    public class a implements d {
        public final /* synthetic */ TuringLiveByteNNActivity a;

        public a(TuringLiveByteNNActivity r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [android.app.Activity, com.bytedance.bdturing.livedetect.TuringLiveByteNNActivity, java.lang.Object] */
        @Override // vb4.d
        public final void onSuccess(String r2) {
            this.a.A.set(true);
            ?? r3 = this.a;
            r3.getClass();
            r3.runOnUiThread(new o(r3));
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [android.app.Activity, com.bytedance.bdturing.livedetect.TuringLiveByteNNActivity, java.lang.Object] */
        @Override // vb4.d
        public final void a(String r1, int r2) {
            ?? r3 = this.a;
            int r4 = TuringLiveByteNNActivity.D;
            r3.getClass();
            r3.runOnUiThread(new o(r3));
        }
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.bdturing.livedetect.TuringLiveDetectActivity, com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(getClass().getName()));
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
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L50;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bdturing.livedetect.TuringLiveDetectActivity, com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L6;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L6:
        if (this.B == false) goto L8;
        TuringLive.getInstance().release();
    L8:
        com.bytedance.bdturing.livedetect.a r0 = com.bytedance.bdturing.livedetect.a.f();
        if (((ArrayList) r0.d).isEmpty() == true) goto L11;
        ((ArrayList) r0.d).remove(this);
    L11:
        LiveDetectService.getInstance().removeByteNNCallBack(this.C);
        super.onDestroy();
    }

    public TuringLiveByteNNActivity() {
        this.z = new AtomicBoolean(false);
        this.A = new AtomicBoolean(false);
        this.B = false;
        this.C = new a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.bdturing.livedetect.TuringLiveDetectActivity
    public final void K1() {
        boolean r0 = com.bytedance.bdturing.livedetect.a.f().g();
        boolean r1 = LiveDetectService.getInstance().isByteNNLoad();
        this.z.set(r0);
        this.A.set(r1);
        if (r0 == false) goto L6;
        if (r1 == false) goto L6;
        boolean r3 = true;
    L7:
        EventReport.y(TuringLiveDetectActivity.class.getName(), r3, this.v);
        if (r3 == true) goto L10;
        EventReport.p(30008, "modelFileReady=" + r0 + ":pluginReady=" + r1 + ":appFirstLaunch=" + e.d(), this.v);
        if (this.z.get() == true) goto L17;
        B1(getString(2131923576));
        com.bytedance.bdturing.livedetect.a.f().e(getClass().getName(), this);
    L17:
        if (this.A.get() == true) goto L21;
        LiveDetectService.getInstance().loadByteNNInNeed(getClass().getName(), this.C);
        return;
    L21:
        return;
    L10:
        if (this.B == true) goto L22;
        this.B = true;
        ThreadMethodProxy.start(new PthreadThreadV2(new l(this), "TuringLiveByteNNActivity"));
        return;
    L22:
        return;
    L6:
        r3 = false;
        goto L7
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

    public static void startActivity(Activity r2, String r3) {
        Intent r0 = new Intent(r2, TuringLiveByteNNActivity.class);
        r0.putExtra("detail", r3);
        r2.startActivity(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.bdturing.livedetect.a$c
    public final void G0(boolean r1, String r2) {
        this.z.set(r1);
        runOnUiThread(new o(this));
    }
}
