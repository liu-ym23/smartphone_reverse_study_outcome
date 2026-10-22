package com.huawei.hms.update.note;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.availableupdate.b;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.ui.NotInstalledHmsDialogHelper;
import com.huawei.hms.utils.UIUtil;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes23.dex */
public class NotInstalledHmsResolution implements IBridgeActivityDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Dialog f277832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Activity f277833b;

    public static class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Activity f277834a;

        public a(Activity r100) {
            this.f277834a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r100, int r101) {
            HMSLog.i("NotInstalledHmsResolution", "<Dialog onClick>");
            this.f277834a.finish();
        }
    }

    public NotInstalledHmsResolution() {
    }

    private void a() {
        Dialog r100 = this.f277832a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isShowing() == false) goto L9;
        this.f277832a.cancel();
        return;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        HMSLog.i("NotInstalledHmsResolution", "<Resolution getRequestCode>");
        return 0;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.i("NotInstalledHmsResolution", "<Resolution onBridgeActivityDestroy>");
        a();
        b.f276991b.b(this.f277833b);
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.i("NotInstalledHmsResolution", "<Resolution onBridgeConfigurationChanged>");
        Activity r100 = this.f277833b;
        if (r100 != null) goto L5;
    L9:
        HMSLog.e("NotInstalledHmsResolution", "<Resolution onBridgeActivityCreate> mActivity is null or finishing");
        return;
    L5:
        if (r100.isFinishing() == true) goto L9;
        a(this.f277833b);
    }

    public static void INVOKEVIRTUAL_com_huawei_hms_update_note_NotInstalledHmsResolution_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(Dialog r100) {
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
        a();
        int r101 = NotInstalledHmsDialogHelper.getConfirmResId(r100);
        AlertDialog r102 = NotInstalledHmsDialogHelper.getDialogBuilder(r100).setPositiveButton(r101, new a(r100)).create();
        this.f277832a = r102;
        UIUtil.enableFocusedForButtonsInTV(r102);
        INVOKEVIRTUAL_com_huawei_hms_update_note_NotInstalledHmsResolution_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this.f277832a);
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity r100) {
        HMSLog.i("NotInstalledHmsResolution", "<Resolution onBridgeActivityCreate>");
        if (r100 != null) goto L5;
    L9:
        HMSLog.e("NotInstalledHmsResolution", "<Resolution onBridgeActivityCreate> activity is null or finishing");
        return;
    L5:
        if (r100.isFinishing() == true) goto L9;
        this.f277833b = r100;
        b.f276991b.a(r100);
        a(r100);
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int r100, KeyEvent r101) {
        HMSLog.i("NotInstalledHmsResolution", "<Resolution onKeyUp>");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int r100, int r101, Intent r102) {
        HMSLog.i("NotInstalledHmsResolution", "<Resolution onBridgeActivityResult>");
        return false;
    }
}
