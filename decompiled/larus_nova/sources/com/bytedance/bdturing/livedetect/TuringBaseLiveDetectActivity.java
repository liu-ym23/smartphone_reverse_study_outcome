package com.bytedance.bdturing.livedetect;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import com.bytedance.crash.d;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import java.util.Map;
import vb4.k;

/* JADX INFO: loaded from: classes14.dex */
public class TuringBaseLiveDetectActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f201823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f201824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AlertDialog f201825c;

    public interface a {
        void G(int r100);

        void U0(int r100);

        void f1();
    }

    public final void A1() {
        AlertDialog r100 = this.f201825c;     // Catch: Exception -> L8
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isShowing() == false) goto L14;
        this.f201825c.findViewById(R.id.loading).clearAnimation();     // Catch: Exception -> L8
        y1(this.f201825c);     // Catch: Exception -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
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
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L39
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
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        A1();
        runOnUiThread(new k(this));
    }

    public TuringBaseLiveDetectActivity() {
        this.f201825c = null;
    }

    public static void y1(AlertDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public final void B1(String r100) {
        A1();     // Catch: Exception -> L15
        AlertDialog r101 = new AlertDialog.Builder(this).create();     // Catch: Exception -> L15
        this.f201825c = r101;     // Catch: Exception -> L15
        r101.getWindow().setBackgroundDrawable(new ColorDrawable());     // Catch: Exception -> L15
        this.f201825c.setCanceledOnTouchOutside(false);     // Catch: Exception -> L15
        AlertDialog r102 = this.f201825c;     // Catch: Exception -> L15
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L21;
        DialogLancet.handleBlockedDialogShow(r102);     // Catch: Exception -> L15
    L8:
        View r103 = View.inflate(this, R.layout.turing_layout_loading_alert, null);     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r100) == true) goto L13;
        TextView r104 = (TextView) r103.findViewById(R.id.tv_loading);     // Catch: Exception -> L15
        if (r104 == null) goto L13;
        r104.setText(r100);     // Catch: Exception -> L15
    L13:
        this.f201825c.setContentView(r103);     // Catch: Exception -> L15
        RotateAnimation r105 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);     // Catch: Exception -> L15
        r105.setDuration(1000);     // Catch: Exception -> L15
        r105.setRepeatCount(-1);     // Catch: Exception -> L15
        r105.setInterpolator(new LinearInterpolator());     // Catch: Exception -> L15
        this.f201825c.findViewById(R.id.loading).startAnimation(r105);     // Catch: Exception -> L15
        return;
    L21:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
    L7:
        DialogLancet.beforeDialogShow(r102);     // Catch: Exception -> L15
        r102.show();     // Catch: Exception -> L15
        DialogLancet.afterDialogShow(r102);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
    }

    public final void z1(a r100) {
        this.f201823a = r100;
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") != 0) goto L7;
        if (r100 == null) goto L15;
        r100.G(1);
        return;
    L15:
        return;
    L7:
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.CAMERA") == false) goto L9;
    L13:
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 1);
        return;
    L9:
        if (LiveDetectService.getInstance().isRequestCameraPermissionFirstTime() == true) goto L13;
        a r101 = this.f201823a;
        if (r101 == null) goto L17;
        r101.f1();
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int r100, String[] r101, int[] r102) {
        int r103 = 1;
        if (r100 != 1) goto L19;
        LiveDetectService.getInstance().updatePermissionState();
        if (r102.length <= 0) goto L12;
        if (r102[0] != 0) goto L12;
        a r104 = this.f201823a;
        if (r104 == null) goto L20;
        r104.G(2);
        return;
    L20:
        return;
    L12:
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.CAMERA") == true) goto L15;
        r103 = 2;
    L15:
        a r105 = this.f201823a;
        if (r105 == null) goto L22;
        r105.U0(r103);
        return;
    L22:
        return;
    }
}
