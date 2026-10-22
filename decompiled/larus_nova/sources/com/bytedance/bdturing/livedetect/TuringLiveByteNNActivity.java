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

/* JADX INFO: loaded from: classes14.dex */
public class TuringLiveByteNNActivity extends TuringLiveDetectActivity implements com.bytedance.bdturing.livedetect.a.c {
    public static final /* synthetic */ int D = 0;
    public final AtomicBoolean A;
    public boolean B;
    public final a C;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final AtomicBoolean f201826z;

    public class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TuringLiveByteNNActivity f201827a;

        public a(TuringLiveByteNNActivity r100) {
            this.f201827a = r100;
        }

        @Override // vb4.d
        public final void onSuccess(String r100) {
            this.f201827a.A.set(true);
            TuringLiveByteNNActivity r101 = this.f201827a;
            r101.getClass();
            r101.runOnUiThread(new o(r101));
        }

        @Override // vb4.d
        public final void a(String r100, int r101) {
            TuringLiveByteNNActivity r102 = this.f201827a;
            int r103 = TuringLiveByteNNActivity.D;
            r102.getClass();
            r102.runOnUiThread(new o(r102));
        }
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // com.bytedance.bdturing.livedetect.TuringLiveDetectActivity, com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
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

    @Override // com.bytedance.bdturing.livedetect.TuringLiveDetectActivity, com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L6;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L6:
        if (this.B == false) goto L8;
        TuringLive.getInstance().release();
    L8:
        com.bytedance.bdturing.livedetect.a r100 = com.bytedance.bdturing.livedetect.a.f();
        if (((ArrayList) r100.f201895d).isEmpty() == true) goto L11;
        ((ArrayList) r100.f201895d).remove(this);
    L11:
        LiveDetectService.getInstance().removeByteNNCallBack(this.C);
        super.onDestroy();
    }

    public TuringLiveByteNNActivity() {
        this.f201826z = new AtomicBoolean(false);
        this.A = new AtomicBoolean(false);
        this.B = false;
        this.C = new a(this);
    }

    @Override // com.bytedance.bdturing.livedetect.TuringLiveDetectActivity
    public final void K1() {
        boolean r100 = com.bytedance.bdturing.livedetect.a.f().g();
        boolean r101 = LiveDetectService.getInstance().isByteNNLoad();
        this.f201826z.set(r100);
        this.A.set(r101);
        if (r100 == false) goto L6;
        if (r101 == false) goto L6;
        boolean r102 = true;
    L7:
        EventReport.y(TuringLiveDetectActivity.class.getName(), r102, this.f201847v);
        if (r102 == true) goto L10;
        EventReport.p(30008, "modelFileReady=" + r100 + ":pluginReady=" + r101 + ":appFirstLaunch=" + e.d(), this.f201847v);
        if (this.f201826z.get() == true) goto L17;
        B1(getString(com.larus.nova.R.string.turing_bytenn_model_loading));
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
        r102 = false;
        goto L7
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

    public static void startActivity(Activity r100, String r101) {
        Intent r102 = new Intent(r100, TuringLiveByteNNActivity.class);
        r102.putExtra("detail", r101);
        r100.startActivity(r102);
    }

    @Override // com.bytedance.bdturing.livedetect.a.c
    public final void G0(boolean r100, String r101) {
        this.f201826z.set(r100);
        runOnUiThread(new o(this));
    }
}
