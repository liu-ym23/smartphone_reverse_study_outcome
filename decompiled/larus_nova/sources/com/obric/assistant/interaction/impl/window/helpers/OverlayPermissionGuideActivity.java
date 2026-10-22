package com.obric.assistant.interaction.impl.window.helpers;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.state.api.v2.core.ObricDeviceStateDelegate;
import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u000e\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0015J\b\u0010\u0014\u001a\u00020\u0011H\u0014J\b\u0010\u0015\u001a\u00020\u0011H\u0015J\u001a\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0002J\b\u0010\u001c\u001a\u00020\u0011H\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0003J\b\u0010\u001e\u001a\u00020\tH\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\b\u0010 \u001a\u00020\u0011H\u0002R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\""}, d2 = {"Lcom/obric/assistant/interaction/impl/window/helpers/OverlayPermissionGuideActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "goSettingLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "shouldFinishOnDialogDismiss", "", "permissionDialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "isNightMode", "screenStateListener", "com/obric/assistant/interaction/impl/window/helpers/OverlayPermissionGuideActivity$screenStateListener$1", "Lcom/obric/assistant/interaction/impl/window/helpers/OverlayPermissionGuideActivity$screenStateListener$1;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", LiveCommonConstants.REASON_ON_DEDTROY, "onKeyDown", "keyCode", "", "event", "Landroid/view/KeyEvent;", "showPermissionDialogIfNeeded", "openOverlayPermissionSetting", "buildOverlayPermissionIntent", "hasSystemAlertWindowPermission", "launchAssistantAfterPermissionGranted", "finishDirectly", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OverlayPermissionGuideActivity extends AppCompatActivity {
    public static final Companion Companion = null;
    private static final String REQUEST_FROM = "system_alert_window_permission";
    private static final String TAG = "WindowPermissionHelperActivity";
    private final ActivityResultLauncher<Intent> goSettingLauncher;
    private boolean isNightMode;
    private com.obric.oui.dialog.v2.alert.c permissionDialog;
    private final OverlayPermissionGuideActivity$screenStateListener$1 screenStateListener;
    private boolean shouldFinishOnDialogDismiss;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/helpers/OverlayPermissionGuideActivity$Companion;", "", "<init>", "()V", "TAG", "", InteractConst.WAKEUP_REQUEST_FROM, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void A1(ActivityResult r100) {
        goSettingLauncher$lambda$0(r100);
    }

    public static /* synthetic */ Unit B1(OverlayPermissionGuideActivity r100, DialogInterface r101, int r102) {
        return showPermissionDialogIfNeeded$lambda$2(r100, r101, r102);
    }

    private static final void goSettingLauncher$lambda$0(ActivityResult r100) {
    }

    public static /* synthetic */ Unit y1(OverlayPermissionGuideActivity r100, DialogInterface r101, int r102) {
        return showPermissionDialogIfNeeded$lambda$1(r100, r101, r102);
    }

    public static /* synthetic */ void z1(OverlayPermissionGuideActivity r100, DialogInterface r101) {
        showPermissionDialogIfNeeded$lambda$3(r100, r101);
    }

    public void com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity__finish$___twin___() {
        super.finish();
    }

    public void com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r100) {
        com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r100);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    private final boolean hasSystemAlertWindowPermission() {
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        return true;
    L7:
        return Settings.canDrawOverlays(this);
    }

    private final void launchAssistantAfterPermissionGranted() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
        IAssistantChatWindow r101 = IAssistantChatWindowKt.getAssistantChatWindow();     // Catch: Throwable -> L8
        if (r101 == null) goto L5;
        IAssistantChatWindow.DefaultImpls.openChatWindow$default(r101, REQUEST_FROM, false, null, null, false, true, null, null, false, false, TTVideoEngineInterface.PLAYER_OPTION_GSKEY_CPU_NATIVE_REFRESH, null);     // Catch: Throwable -> L8
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Object r103 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L8
    L10:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L16;
        FLogger.f375446a.e(TAG, "launchAssistantAfterPermissionGranted failed", r104);
        return;
    L16:
        return;
    L5:
        r102 = null;
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private final void showPermissionDialogIfNeeded() {
        if (this.permissionDialog == null) goto L5;
        return;
    L5:
        com.obric.oui.dialog.v2.alert.g r100 = new com.obric.oui.dialog.v2.alert.g(this);
        r100.f400759w = false;
        String r101 = getString(R.string.obric_window_permission_title);
        r100.f400746j = false;
        r100.f400744h = r101;
        r100.f400745i = getString(R.string.obric_window_permission_message);
        com.obric.oui.dialog.v2.alert.g.c(r100);
        r100.e(getString(R.string.obric_window_permission_cancel), new a(this));
        r100.h(getString(R.string.obric_window_permission_go_setting), new b(this));
        com.obric.oui.dialog.v2.alert.c r102 = r100.a();
        r102.setOnDismissListener(new c(this));
        this.permissionDialog = r102;
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r102);
    }

    public void com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity__onDestroy$___twin___() {
        ObricDeviceStateDelegate.f392965b.a(this.screenStateListener);
        com.obric.oui.dialog.v2.alert.c r100 = this.permissionDialog;
        if (r100 == null) goto L5;
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r100);
    L5:
        this.permissionDialog = null;
        super.onDestroy();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.obric.assistant.interaction.impl.window.helpers.OverlayPermissionGuideActivity$screenStateListener$1] */
    public OverlayPermissionGuideActivity() {
        this.goSettingLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new d());
        this.shouldFinishOnDialogDismiss = true;
        this.screenStateListener = new OverlayPermissionGuideActivity$screenStateListener$1(this);
    }

    private final Intent buildOverlayPermissionIntent() {
        String r100 = getPackageName();
        Intent r101 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", UriProtector.parse("package:" + r100));
        r101.addFlags(1073741824);
        if (r101.resolveActivity(getPackageManager()) == null) goto L6;
        return r101;
    L6:
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", UriProtector.parse("package:" + r100)).addFlags(1073741824);
    }

    private final void finishDirectly() {
        finish();
        overridePendingTransition(0, 0);
    }

    private final void openOverlayPermissionSetting() {
        Intent r100 = buildOverlayPermissionIntent();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        this.goSettingLauncher.launch(r100);     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L13;
        FLogger.f375446a.e(TAG, "open overlay permission setting failed", r103);
        finishDirectly();
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (hasSystemAlertWindowPermission() == false) goto L5;
        launchAssistantAfterPermissionGranted();
        finishDirectly();
        return;
    L5:
        showPermissionDialogIfNeeded();
    }

    public static View INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(com.obric.oui.dialog.v2.alert.c r100) {
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
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(com.obric.oui.dialog.v2.alert.c r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public static void com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(OverlayPermissionGuideActivity r100) {
        r100.com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(OverlayPermissionGuideActivity r110) {
        r110.com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity__finish$___twin___();
        if ((r110 instanceof ChatWindowActivity) == false) goto L5;
        return;
    L5:
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(OverlayPermissionGuideActivity.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(r110);     // Catch: Throwable -> L50
        if (r103 != null) goto L10;
    L13:
        r102.put(r110, Long.valueOf(r101));     // Catch: Throwable -> L50
        monitor-exit(r102);     // Catch: Throwable -> L50
    L47:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
        return;
    L16:
        if (r110.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L20;
        r100.i("ActivityLancet", "quit !resume, current state = " + r110.getLifecycle().getCurrentState());     // Catch: Throwable -> L47
        return;
    L20:
        if (r110.isFinishing() == true) goto L24;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L47
        return;
    L24:
        if (ActivityStartBehavior.isInternalActivityConsumed(r110) == true) goto L28;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L47
        return;
    L28:
        if (ActivityLancet.isOnlyActivityInTask(r110) == true) goto L32;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L47
        return;
    L32:
        if (ActivityLancet.isExcludedActivity(r110) == false) goto L36;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L47
        return;
    L36:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L38;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L47
        return;
    L38:
        Intent r104 = r110.getPackageManager().getLaunchIntentForPackage(r110.getPackageName());     // Catch: Throwable -> L47
        if (r104 != null) goto L41;
        return;
    L41:
        r104.addFlags(268435456);     // Catch: Throwable -> L47
        r104.addFlags(2097152);     // Catch: Throwable -> L47
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + r110);     // Catch: Throwable -> L47
        r110.startActivity(r104);     // Catch: Throwable -> L44
        r110.overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L44
    L58:
        return;
    L44:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L47
        return;
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L50
        return;
    L50:
        th = move-exception;
        throw th;
    }

    public static void com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(OverlayPermissionGuideActivity r100) {
        if ((r100 instanceof FragmentActivity) == true) goto L5;
    L7:
        r100.com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r100) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r100);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r100.getClass().getName()));
        goto L7
    }

    public void com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity__onCreate$___twin___(Bundle r100) {
        v19.f.a(getTheme());
        super.onCreate(r100);
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == true) goto L5;
        setShowWhenLocked(false);
    L5:
        boolean r101 = true;
        supportRequestWindowFeature(1);
        ActionBar r102 = getSupportActionBar();
        if (r102 == null) goto L9;
        r102.hide();
    L9:
        if ((getResources().getConfiguration().uiMode & 48) == 32) goto L12;
        r101 = false;
    L12:
        this.isNightMode = r101;
        boolean r103 = v19.h.f552477a;
        v19.h.f552477a = r101;
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()).setBackgroundColor(0);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setContentView(R.layout.layout_helper);
        overridePendingTransition(0, 0);
        if (hasSystemAlertWindowPermission() == false) goto L16;
        finishDirectly();
        return;
    L16:
        showPermissionDialogIfNeeded();
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        if (Build.VERSION.SDK_INT < 29) goto L19;
        getWindow().setStatusBarContrastEnforced(false);
        getWindow().setNavigationBarContrastEnforced(false);
    L19:
        ObricDeviceStateDelegate.f392965b.b(this.screenStateListener);
    }

    public static void com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(OverlayPermissionGuideActivity r100, Bundle r101) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(r100.getTheme());     // Catch: Throwable -> L10
    L6:
        if (v19.f.f(r100) == false) goto L8;
        v19.f.c(r100.getTheme());     // Catch: Throwable -> L10
    L8:
        r100.com_obric_assistant_interaction_impl_window_helpers_OverlayPermissionGuideActivity__onCreate$___twin___(r101);
    }

    private static final void showPermissionDialogIfNeeded$lambda$3(OverlayPermissionGuideActivity r100, DialogInterface r101) {
        r100.permissionDialog = null;
        if (r100.shouldFinishOnDialogDismiss == true) goto L5;
        return;
    L5:
        if (r100.isFinishing() == true) goto L9;
        r100.finishDirectly();
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r100, KeyEvent r101) {
        if (r100 != 4) goto L7;
        finishDirectly();
        return true;
    L7:
        return super.onKeyDown(r100, r101);
    }

    private static final Unit showPermissionDialogIfNeeded$lambda$1(OverlayPermissionGuideActivity r100, DialogInterface r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "dialog");
        r100.shouldFinishOnDialogDismiss = true;
        r101.dismiss();
        return Unit.INSTANCE;
    }

    private static final Unit showPermissionDialogIfNeeded$lambda$2(OverlayPermissionGuideActivity r100, DialogInterface r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "dialog");
        r100.shouldFinishOnDialogDismiss = false;
        r101.dismiss();
        r100.openOverlayPermissionSetting();
        return Unit.INSTANCE;
    }
}
