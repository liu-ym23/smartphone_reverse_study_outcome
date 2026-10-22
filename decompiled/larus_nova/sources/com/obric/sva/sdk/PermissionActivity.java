package com.obric.sva.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.crash.d;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.sva.sdk.utils.AppPermissionUtils;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import f06.b;
import g06.a;
import java.util.ArrayList;
import java.util.Map;
import v19.f;

/* JADX INFO: loaded from: classes34.dex */
public class PermissionActivity extends Activity {
    private static final String PACKAGE_URL_SCHEME = "package:";
    private static final int REQUEST_CODE_PERMISSION = 1000;
    private final String TAG;
    private AlertDialog mMissingPermissionDialog;

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context r100) {
        super.attachBaseContext(r100);
        NewMiraResourcesManager.getInstance().installActivity(this);
    }

    public void com_obric_sva_sdk_PermissionActivity__finish$___twin___() {
        super.finish();
    }

    public void com_obric_sva_sdk_PermissionActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    public void finish() {
        com_obric_sva_sdk_PermissionActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r100) {
        com_obric_sva_sdk_PermissionActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r100);
    }

    @Override // android.app.Activity
    public void onStop() {
        com_obric_sva_sdk_PermissionActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    private AlertDialog showMissingPermissionDialog() {
        AlertDialog.Builder r100 = new AlertDialog.Builder(this);
        r100.setTitle(R.string.sva_help);
        r100.setMessage(R.string.sva_missing_permission_msg);
        r100.setNegativeButton(R.string.sva_quit, new AnonymousClass1(this));
        r100.setPositiveButton(R.string.sva_settings, new AnonymousClass2(this));
        return r100.show();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        if (this.mMissingPermissionDialog == null) goto L5;
        LogUtils.d(this.TAG, "onDestroy: dismiss mMissingPermissionDialog", new Object[0]);
        INVOKEVIRTUAL_com_obric_sva_sdk_PermissionActivity_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this.mMissingPermissionDialog);
    L5:
        super.onDestroy();
    }

    public PermissionActivity() {
        this.TAG = "PermissionActivity";
    }

    public static View INVOKEVIRTUAL_com_obric_sva_sdk_PermissionActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void INVOKEVIRTUAL_com_obric_sva_sdk_PermissionActivity_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(AlertDialog r100) {
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

    public static void com_obric_sva_sdk_PermissionActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(PermissionActivity r100) {
        r100.com_obric_sva_sdk_PermissionActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_obric_sva_sdk_PermissionActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_obric_sva_sdk_PermissionActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(PermissionActivity r110) {
        r110.com_obric_sva_sdk_PermissionActivity__finish$___twin___();
        if ((r110 instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((r110 instanceof ChatWindowActivity) == false) goto L8;
        return;
    L8:
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(r110.getClass().getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(r110);     // Catch: Throwable -> L53
        if (r103 != null) goto L13;
    L16:
        r102.put(r110, Long.valueOf(r101));     // Catch: Throwable -> L53
        monitor-exit(r102);     // Catch: Throwable -> L53
    L50:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
        return;
    L19:
        if (((FragmentActivity) r110).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L23;
        r100.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) r110).getLifecycle().getCurrentState());     // Catch: Throwable -> L50
        return;
    L23:
        if (r110.isFinishing() == true) goto L27;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L50
        return;
    L27:
        if (ActivityStartBehavior.isInternalActivityConsumed(r110) == true) goto L31;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L50
        return;
    L31:
        if (ActivityLancet.isOnlyActivityInTask(r110) == true) goto L35;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L50
        return;
    L35:
        if (ActivityLancet.isExcludedActivity(r110) == false) goto L39;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L50
        return;
    L39:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L41;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L50
        return;
    L41:
        Intent r104 = r110.getPackageManager().getLaunchIntentForPackage(r110.getPackageName());     // Catch: Throwable -> L50
        if (r104 != null) goto L44;
        return;
    L44:
        r104.addFlags(268435456);     // Catch: Throwable -> L50
        r104.addFlags(2097152);     // Catch: Throwable -> L50
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + r110);     // Catch: Throwable -> L50
        r110.startActivity(r104);     // Catch: Throwable -> L47
        r110.overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L47
    L61:
        return;
    L47:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L50
        return;
    L13:
        if ((r101 - r103.longValue()) >= 800) goto L16;
        monitor-exit(r102);     // Catch: Throwable -> L53
        return;
    L53:
        th = move-exception;
        throw th;
    }

    public void com_obric_sva_sdk_PermissionActivity__onCreate$___twin___(Bundle r100) {
        super.onCreate(r100);
        String[] r101 = getIntent().getStringArrayExtra(AppPermissionUtils.EXTRA_KEY_REQUIRED_PERMISSIONS);
        if (r100 != null) goto L7;
        if (r101 == null) goto L8;
        requestPermissions(AppPermissionUtils.checkPermissions(this, r101), 1000);
        return;
    L8:
        return;
    }

    public static void com_obric_sva_sdk_PermissionActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(PermissionActivity r100, Bundle r101) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r100.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r100) == false) goto L8;
        f.c(r100.getTheme());     // Catch: Throwable -> L10
    L8:
        r100.com_obric_sva_sdk_PermissionActivity__onCreate$___twin___(r101);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int r100, String[] r101, int[] r102) {
        boolean r103 = true;
        if (r100 == 1000) goto L5;
        com_obric_sva_sdk_PermissionActivity_android_app_Activity_onRequestPermissionsResult_super(this, r100, r101, r102);
    L11:
        if (r103 == false) goto L13;
        finish();
        return;
    L13:
        this.mMissingPermissionDialog = showMissingPermissionDialog();
        return;
    L5:
        int r104 = r102.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L11;
        if (r102[r105] == 0) goto L10;
        r103 = false;
    L10:
        r105 = r105 + 1;
        goto L6
    }

    private static void com_obric_sva_sdk_PermissionActivity_android_app_Activity_onRequestPermissionsResult_super(Activity r110, int r111, String[] r210, int[] r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r111), r210, r211};
        b r112 = new b();
        a r102 = ApiHookConfig.f245611b.get(102611);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(102611, "android/app/Activity", "onRequestPermissionsResult", r110, r101, "void", r112);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == false) goto L19;
        return;
    L19:
        super.onRequestPermissionsResult(r111, r210, r211);
        return;
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
