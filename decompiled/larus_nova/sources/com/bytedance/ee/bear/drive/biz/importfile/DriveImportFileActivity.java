package com.bytedance.ee.bear.drive.biz.importfile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsMvpActivity;
import com.bytedance.ee.bear.drive.importfile.ImportFileEntity;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import k55.a;
import m75.d;
import o75.b;

/* JADX INFO: loaded from: classes16.dex */
public class DriveImportFileActivity extends DriveAbsMvpActivity<a> implements o55.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImportFileEntity f223025e;

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity
    public final int D1() {
        return R.layout.drive_activity_main;
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity
    public final void initActions() {
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsMvpActivity, com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity, com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveRootActivity, com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
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

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity
    public final void initViews() {
        a r100 = (a) this.f224079d;
        ImportFileEntity r101 = this.f223025e;
        if (r100.i() == false) goto L6;
        ((o55.a) r100.f512352a).Xz(r101, r100.f501837e);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsMvpActivity, com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity, com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveRootActivity, com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    public final void init() {
        ImportFileEntity r100 = (ImportFileEntity) getIntent().getParcelableExtra("extra_drive_file_open_entity");
        if (r100 != null) goto L5;
        r100 = new ImportFileEntity("", "");
    L5:
        this.f223025e = r100;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseCommonActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        super.onBackPressed();
        if (this.f223025e == null) goto L6;
        b.a().Tb().i("success", "DEC1", this.f223025e.f224401a);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsMvpActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == c.f346341a) goto L9;
        c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public DriveImportFileActivity() {
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity
    public final void initData() {
        init();
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsMvpActivity
    public final d G1(Context r100) {
        return new a(r100);
    }

    public final void H1(ImportFileEntity r100) {
        DriveImportFileFragment r101 = new DriveImportFileFragment();
        Bundle r102 = new Bundle();
        r102.putParcelable("extra_drive_file_open_entity", r100);
        r101.setArguments(r102);
        FragmentTransaction r103 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r103, r101, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "DriveImportFileFragment", R.id.drive_activity_container) == true) goto L6;
        r103 = r103.replace(R.id.drive_activity_container, r101, "DriveImportFileFragment");
    L6:
        r103.commitAllowingStateLoss();
    }

    @Override // o55.a
    public final void Xz(ImportFileEntity r100, Bundle r101) {
        if (r101 != null) goto L5;
        tt5.a.h("DriveImportFileActivity", "setUpPreview: default");
        H1(r100);
        return;
    L5:
        Fragment r102 = getSupportFragmentManager().findFragmentByTag("DriveImportFileFragment");
        if (r102 != null) goto L9;
        tt5.a.h("DriveImportFileActivity", "setUpPreview: restore no found Any fragment");
        H1(r100);
        return;
    L9:
        if ((r102 instanceof DriveImportFileFragment) == true) goto L11;
        tt5.a.h("DriveImportFileActivity", "setUpPreview: restore no found DriveImportFileFragment");
        H1(r100);
        return;
    L11:
        tt5.a.h("DriveImportFileActivity", "setUpPreview: restore DriveImportFileFragment");
    }
}
