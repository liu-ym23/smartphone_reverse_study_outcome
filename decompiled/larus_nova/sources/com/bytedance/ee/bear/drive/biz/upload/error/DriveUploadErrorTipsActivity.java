package com.bytedance.ee.bear.drive.biz.upload.error;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsMvpActivity;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import m75.a;
import t65.b;
import t65.c;
import t65.e;
import t65.h;
import t65.i;

/* JADX INFO: loaded from: classes16.dex */
public class DriveUploadErrorTipsActivity extends DriveAbsMvpActivity<a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f223876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public UDDialog f223877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f223878g;

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity
    public final int D1() {
        return R.layout.drive_activity_main;
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity
    public final void initActions() {
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsMvpActivity, com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity, com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveRootActivity, com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        overridePendingTransition(0, 0);
        if ((this instanceof ChatWindowActivity) == true) goto L56;
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
    L53:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
    L48:
        goto L53
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L48;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsMvpActivity, com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity, com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveRootActivity, com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        UDDialog r100 = this.f223877f;
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.isShowing() == false) goto L30;
        UDDialog r101 = this.f223877f;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L12;
    L14:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(r101);
        return;
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L19:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r103 == null) goto L23;
        d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L23
    L12:
        if (Looper.myLooper() == r102.getLooper()) goto L14;
        r102.post(DialogLancet.createDismissRunnable(r101));
        return;
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity
    public final void initData() {
        int r100 = getIntent().getIntExtra("drive_upload_error", 0);
        getIntent();
        if (r100 != 13001) goto L5;
        e r101 = new h();
    L6:
        this.f223876e = r101;
        return;
    L5:
        r101 = new i();
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity
    public final void initViews() {
        this.f223878g = findViewById(R.id.drive_activity_container);
        this.f223876e.c();
        this.f223878g.setBackgroundColor(getResources().getColor(R.color.bg_body));
        this.f223876e.g();
        Context r100 = getContext();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDDialogBuilder r101 = new UDDialogBuilder(r100);
        r101.autoDismiss(true);
        r101.title(this.f223876e.e());
        r101.titleColor(R.color.text_title);
        r101.message(this.f223876e.a());
        r101.messageTextColor(R.color.text_caption);
        BearUDDialogBuilder.ActionBottomOrientation r102 = BearUDDialogBuilder.ActionBottomOrientation.VERTICAL;
        Intrinsics.checkNotNullParameter(r102, "value");
        if (r102 != BearUDDialogBuilder.ActionBottomOrientation.HORIZONTAL) goto L5;
        UDBaseDialogBuilder.ActionBottomOrientation r103 = UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL;
    L6:
        r101.actionButtonOrientation(r103);
        r101.addActionButton(R.id.ud_dialog_btn_primary, this.f223876e.h(), new t65.a(this));
        DialogInterface.OnCancelListener r104 = new b(this);
        Intrinsics.checkNotNullParameter(r104, "value");
        r101.onCancelListener(r104);
        if (this.f223876e.b() == false) goto L9;
        r101.addActionButton(R.id.ud_dialog_btn_secondary, R.string.Doc_Facade_Cancel, new c(this));
    L9:
        UDDialog r105 = r101.build();
        this.f223877f = r105;
        if (DialogLancet.shouldBlockDialogShow(r105) == false) goto L16;
        DialogLancet.handleBlockedDialogShow(r105);
        return;
    L16:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L13:
        DialogLancet.beforeDialogShow(r105);
        r105.show();
        DialogLancet.afterDialogShow(r105);
        return;
    L5:
        r103 = UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsMvpActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
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

    public DriveUploadErrorTipsActivity() {
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsMvpActivity
    public final m75.d G1(Context r100) {
        return new t65.d(r100);
    }
}
