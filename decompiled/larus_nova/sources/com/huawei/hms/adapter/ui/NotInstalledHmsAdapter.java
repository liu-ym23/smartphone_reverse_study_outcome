package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.ui.NotInstalledHmsDialogHelper;
import com.huawei.hms.utils.UIUtil;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes23.dex */
public class NotInstalledHmsAdapter implements IBridgeActivityDelegate {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f276922c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f276923d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f276924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Dialog f276925b;

    public static class a implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Activity f276926a;

        public a(Activity r100) {
            this.f276926a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface r100) {
            HMSLog.i("NotInstalledHmsAdapter", "<Dialog onCancel>");
            SystemManager.getInstance().notifyUpdateResult(13);
            this.f276926a.finish();
        }
    }

    public static class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Activity f276927a;

        public b(Activity r100) {
            this.f276927a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r100, int r101) {
            HMSLog.i("NotInstalledHmsAdapter", "<Dialog onClick>");
            SystemManager.getInstance().notifyUpdateResult(30);
            this.f276927a.finish();
        }
    }

    public NotInstalledHmsAdapter() {
    }

    static {
        f276922c = new Object();
    }

    public static boolean getShowLock() {
        Object r100 = f276922c;
        monitor-enter(r100);
        HMSLog.i("NotInstalledHmsAdapter", "<canShowDialog> sIsShowingDialog: " + f276923d);     // Catch: Throwable -> L12
        if (f276923d == false) goto L9;
        monitor-exit(r100);     // Catch: Throwable -> L12
        return false;
    L9:
        f276923d = true;     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        return true;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        HMSLog.i("NotInstalledHmsAdapter", "<getRequestCode>");
        return 0;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.i("NotInstalledHmsAdapter", "<onBridgeActivityDestroy>");
        Object r100 = f276922c;
        monitor-enter(r100);
        f276923d = false;     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.i("NotInstalledHmsAdapter", "<onBridgeConfigurationChanged>");
        Activity r100 = this.f276924a;
        if (r100 != null) goto L5;
    L9:
        HMSLog.e("NotInstalledHmsAdapter", "<onBridgeConfigurationChanged> mActivity is null or finishing");
        return;
    L5:
        if (r100.isFinishing() == true) goto L9;
        a(this.f276924a);
    }

    public static void INVOKEVIRTUAL_com_huawei_hms_adapter_ui_NotInstalledHmsAdapter_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(Dialog r100) {
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

    private void a(Activity r100) {
        Dialog r101 = this.f276925b;
        if (r101 != null) goto L5;
    L7:
        int r102 = NotInstalledHmsDialogHelper.getConfirmResId(r100);
        AlertDialog r103 = NotInstalledHmsDialogHelper.getDialogBuilder(r100).setPositiveButton(r102, new b(r100)).setOnCancelListener(new a(r100)).create();
        this.f276925b = r103;
        UIUtil.enableFocusedForButtonsInTV(r103);
        INVOKEVIRTUAL_com_huawei_hms_adapter_ui_NotInstalledHmsAdapter_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this.f276925b);
        return;
    L5:
        if (r101.isShowing() == false) goto L7;
        this.f276925b.setOnCancelListener(null);
        this.f276925b.cancel();
        goto L7
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity r100) {
        HMSLog.i("NotInstalledHmsAdapter", "<onBridgeActivityCreate>");
        if (r100 != null) goto L5;
    L9:
        HMSLog.e("NotInstalledHmsAdapter", "<onBridgeActivityCreate> activity is null or finishing");
        return;
    L5:
        if (r100.isFinishing() == true) goto L9;
        this.f276924a = r100;
        a(r100);
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int r100, KeyEvent r101) {
        HMSLog.i("NotInstalledHmsAdapter", "<onKeyUp>");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int r100, int r101, Intent r102) {
        HMSLog.i("NotInstalledHmsAdapter", "<onBridgeActivityResult>");
        return false;
    }
}
