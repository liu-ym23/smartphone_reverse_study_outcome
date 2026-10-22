package com.huawei.hms.update.note;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.ui.AbstractDialog;
import com.huawei.hms.ui.AbstractPromptDialog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* JADX INFO: loaded from: classes23.dex */
public class AppSpoofResolution implements IBridgeActivityDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f277829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f277830b;

    public class a implements AbstractDialog.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppSpoofResolution f277831a;

        public a(AppSpoofResolution r100) {
            this.f277831a = r100;
        }

        @Override // com.huawei.hms.ui.AbstractDialog.Callback
        public void onCancel(AbstractDialog r100) {
            com.huawei.hms.availableupdate.a.f276987c.a(true);
            AppSpoofResolution.a(this.f277831a, null);
            AppSpoofResolution.a(this.f277831a);
        }

        @Override // com.huawei.hms.ui.AbstractDialog.Callback
        public void onDoWork(AbstractDialog r100) {
            com.huawei.hms.availableupdate.a.f276987c.a(true);
            AppSpoofResolution.a(this.f277831a, null);
            AppSpoofResolution.a(this.f277831a);
        }
    }

    public static class b extends AbstractPromptDialog {
        private b() {
        }

        public /* synthetic */ b(a r100) {
            this();
        }

        @Override // com.huawei.hms.ui.AbstractDialog
        public String onGetMessageString(Context r100) {
            String r101 = "com.huawei.hwid";
            String r102 = new PackageManagerHelper(r100).getApplicationName("com.huawei.hwid");
            if (TextUtils.isEmpty(r102) == true) goto L7;
            r101 = r102;
        L7:
            if (ResourceLoaderUtil.getmContext() != null) goto L10;
            ResourceLoaderUtil.setmContext(r100);
        L10:
            return ResourceLoaderUtil.getString("hms_is_spoof", new Object[]{r101});
        }

        @Override // com.huawei.hms.ui.AbstractDialog
        public String onGetPositiveButtonString(Context r100) {
            if (ResourceLoaderUtil.getmContext() != null) goto L6;
            ResourceLoaderUtil.setmContext(r100);
        L6:
            return ResourceLoaderUtil.getString("hms_confirm");
        }

        @Override // com.huawei.hms.ui.AbstractPromptDialog, com.huawei.hms.ui.AbstractDialog
        public String onGetTitleString(Context r100) {
            if (ResourceLoaderUtil.getmContext() != null) goto L6;
            ResourceLoaderUtil.setmContext(r100);
        L6:
            return ResourceLoaderUtil.getString("hms_spoof_hints");
        }
    }

    public AppSpoofResolution() {
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 0;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution onBridgeActivityDestroy");
        com.huawei.hms.availableupdate.a r100 = com.huawei.hms.availableupdate.a.f276987c;
        if (r100.a().compareAndSet(true, false) == false) goto L5;
        SystemManager.getInstance().notifyNoticeResult(29);
    L5:
        r100.b(this.f277829a);
        this.f277829a = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        if (this.f277830b != null) goto L5;
        return;
    L5:
        HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution re show prompt dialog");
        b();
    }

    private void a() {
        Activity r100 = getActivity();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isFinishing() == true) goto L13;
        HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution finishBridgeActivity：");
        if (com.huawei.hms.availableupdate.a.f276987c.a().compareAndSet(true, false) == false) goto L10;
        SystemManager.getInstance().notifyNoticeResult(29);
    L10:
        r100.finish();
        return;
    }

    private void b() {
        Activity r100 = getActivity();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isFinishing() == true) goto L14;
        b r101 = this.f277830b;
        if (r101 != null) goto L10;
        this.f277830b = new b(null);
    L11:
        HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution showPromptdlg to resolve conn error");
        this.f277830b.show(r100, new a(this));
        return;
    L10:
        r101.dismiss();
        goto L11
    }

    public Activity getActivity() {
        return this.f277829a;
    }

    public static /* synthetic */ void a(AppSpoofResolution r100) {
        r100.a();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity r100) {
        HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution onBridgeActivityCreate");
        if (r100 != null) goto L5;
    L9:
        HMSLog.e("AppSpoofResolution", "activity is null or finishing");
        return;
    L5:
        if (r100.isFinishing() == true) goto L9;
        this.f277829a = r100;
        com.huawei.hms.availableupdate.a r101 = com.huawei.hms.availableupdate.a.f276987c;
        r101.a(r100);
        r101.a(false);
        b();
    }

    public static /* synthetic */ b a(AppSpoofResolution r100, b r101) {
        r100.f277830b = r101;
        return r101;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int r100, KeyEvent r101) {
        HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution On key up when resolve spoof error");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int r100, int r101, Intent r102) {
        if (r100 == getRequestCode()) goto L6;
        return false;
    L6:
        HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution onBridgeActivityResult");
        return true;
    }
}
