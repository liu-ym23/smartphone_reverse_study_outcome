package com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.view.UploadListFragment;
import com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsMvpActivity;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.drive.report.c;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.Map;
import m75.d;
import y65.a;
import y65.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class UploadListActivity extends DriveAbsMvpActivity<a> implements b {
    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity
    public final int D1() {
        return 2131560241;
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity
    public final void initData() {
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsMvpActivity, com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity, com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveRootActivity, com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
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

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity
    public final void initViews() {
        a r0 = (a) this.d;
        if (r0.i() == false) goto L6;
        ((b) r0.a).hk(r0.e);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsMvpActivity, com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity, com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveRootActivity, com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        org.koin.java.a.a(h0.class);     // Catch: Throwable -> L8
        o75.b.a().Ke().I("", "", "hide_upload_layer");
        return;
    L8:
        th = move-exception;
        tt5.a.e("UploadListActivity", "koin not available", th, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void H1() {
        String r0 = getIntent().getStringExtra(DrivePreviewOpenItem.EXTRA_MOUNT_NODE_TOKEN);
        String r1 = getIntent().getStringExtra(DrivePreviewOpenItem.EXTRA_MOUNT_POINT);
        String r2 = getIntent().getStringExtra(DocViewModel.EXTRA_SPACE_ID);
        UploadListFragment r3 = new UploadListFragment();
        Bundle r4 = new Bundle();
        r4.putString("mountNodeToken", r0);
        r4.putString("mountPoint", r1);
        r4.putString("spaceId", r2);
        r3.setArguments(r4);
        FragmentTransaction r5 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r5, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "UploadListFragment", 2131370339) == true) goto L6;
        r5 = r5.replace(2131370339, r3, "UploadListFragment");
    L6:
        r5.commitAllowingStateLoss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity
    public final void initActions() {
        o75.b.a().Ke().I("", "", "show_upload_layer");
        c r0 = o75.b.a().Ke();
        String r1 = getIntent().getStringExtra(DocViewModel.EXTRA_SPACE_ID);
        HashMap<String, Object> r2 = r0.i(null);
        if (TextUtils.isEmpty(r1) == true) goto L5;
        r2.put("container_id", du5.b.g(r1));
        r2.put("container_type", FileInfoPuller.CALLER_WIKI);
    L5:
        r0.A("ccm_drive_file_upload_process_view", r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsMvpActivity
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

    public UploadListActivity() {
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsMvpActivity
    public final d G1(Context r2) {
        return new a(r2);
    }

    @Override // y65.b
    public final void hk(Bundle r3) {
        if (r3 != null) goto L5;
        tt5.a.h("UploadListActivity", "setUpUploadList: default");
        H1();
        return;
    L5:
        Fragment r4 = getSupportFragmentManager().findFragmentByTag("UploadListFragment");
        if (r4 != null) goto L9;
        tt5.a.h("UploadListActivity", "setUpUploadList: restore no found Any fragment");
        H1();
        return;
    L9:
        if ((r4 instanceof UploadListFragment) == true) goto L11;
        tt5.a.h("UploadListActivity", "setUpUploadList: restore no found UploadListFragment");
        H1();
        return;
    L11:
        tt5.a.h("UploadListActivity", "setUpUploadList: restore UploadListFragment");
    }
}
