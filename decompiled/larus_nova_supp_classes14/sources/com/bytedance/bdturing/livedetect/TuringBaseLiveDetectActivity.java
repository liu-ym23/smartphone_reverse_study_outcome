package com.bytedance.bdturing.livedetect;

import android.R;
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
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import java.util.Map;
import vb4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class TuringBaseLiveDetectActivity extends AppCompatActivity {
    public a a;
    public ImageView b;
    public AlertDialog c;

    public interface a {
        void G(int r1);

        void U0(int r1);

        void f1();
    }

    public final void A1() {
        AlertDialog r0 = this.c;     // Catch: Exception -> L8
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L14;
        this.c.findViewById(2131378977).clearAnimation();     // Catch: Exception -> L8
        y1(this.c);     // Catch: Exception -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
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

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        A1();
        runOnUiThread(new k(this));
    }

    public TuringBaseLiveDetectActivity() {
        this.c = null;
    }

    public static void y1(AlertDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1(String r9) {
        A1();     // Catch: Exception -> L15
        AlertDialog r0 = new AlertDialog.Builder(this).create();     // Catch: Exception -> L15
        this.c = r0;     // Catch: Exception -> L15
        r0.getWindow().setBackgroundDrawable(new ColorDrawable());     // Catch: Exception -> L15
        this.c.setCanceledOnTouchOutside(false);     // Catch: Exception -> L15
        AlertDialog r1 = this.c;     // Catch: Exception -> L15
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L21;
        DialogLancet.handleBlockedDialogShow(r1);     // Catch: Exception -> L15
    L8:
        View r2 = View.inflate(this, 2131568062, null);     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r9) == true) goto L13;
        TextView r3 = (TextView) r2.findViewById(2131390901);     // Catch: Exception -> L15
        if (r3 == null) goto L13;
        r3.setText(r9);     // Catch: Exception -> L15
    L13:
        this.c.setContentView(r2);     // Catch: Exception -> L15
        RotateAnimation r10 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);     // Catch: Exception -> L15
        r10.setDuration(1000);     // Catch: Exception -> L15
        r10.setRepeatCount(-1);     // Catch: Exception -> L15
        r10.setInterpolator(new LinearInterpolator());     // Catch: Exception -> L15
        this.c.findViewById(2131378977).startAnimation(r10);     // Catch: Exception -> L15
        return;
    L21:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
    L7:
        DialogLancet.beforeDialogShow(r1);     // Catch: Exception -> L15
        r1.show();     // Catch: Exception -> L15
        DialogLancet.afterDialogShow(r1);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z1(a r4) {
        this.a = r4;
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") != 0) goto L7;
        if (r4 == null) goto L15;
        r4.G(1);
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
        a r5 = this.a;
        if (r5 == null) goto L17;
        r5.f1();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onRequestPermissionsResult(int r2, String[] r3, int[] r4) {
        int r5 = 1;
        if (r2 != 1) goto L19;
        LiveDetectService.getInstance().updatePermissionState();
        if (r4.length <= 0) goto L12;
        if (r4[0] != 0) goto L12;
        a r6 = this.a;
        if (r6 == null) goto L20;
        r6.G(2);
        return;
    L20:
        return;
    L12:
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.CAMERA") == true) goto L15;
        r5 = 2;
    L15:
        a r7 = this.a;
        if (r7 == null) goto L22;
        r7.U0(r5);
        return;
    L22:
        return;
    }
}
