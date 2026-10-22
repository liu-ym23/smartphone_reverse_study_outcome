package com.huawei.hms.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.adapter.ui.NotInstalledHmsAdapter;
import com.huawei.hms.adapter.ui.UpdateAdapter;
import com.huawei.hms.availableupdate.c;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.note.AppSpoofResolution;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.UIUtil;

/* JADX INFO: loaded from: classes23.dex */
public class AvailableAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f276867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AvailableCallBack f276868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f276869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SystemObserver f276870d;

    public interface AvailableCallBack {
        void onComplete(int r100);
    }

    public class a implements SystemObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AvailableAdapter f276871a;

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onSolutionResult(Intent r100, String r101) {
            return false;
        }

        public a(AvailableAdapter r100) {
            this.f276871a = r100;
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onNoticeResult(int r100) {
            AvailableCallBack r101 = AvailableAdapter.a(this.f276871a);
            if (r101 != null) goto L6;
            HMSLog.e("AvailableAdapter", "onNoticeResult baseCallBack null");
            return true;
        L6:
            r101.onComplete(r100);
            return true;
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onUpdateResult(int r100) {
            AvailableCallBack r101 = AvailableAdapter.a(this.f276871a);
            if (r101 != null) goto L6;
            HMSLog.e("AvailableAdapter", "onUpdateResult baseCallBack null");
            return true;
        L6:
            r101.onComplete(r100);
            return true;
        }
    }

    public boolean isUserNoticeError(int r100) {
        if (r100 == 29) goto L6;
        return false;
    L6:
        return true;
    }

    public boolean isUserResolvableError(int r100) {
        if (r100 != 1) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 2) goto L8;
        return false;
    }

    private AvailableCallBack a() {
        return this.f276868b;
    }

    public AvailableAdapter(int r100) {
        this.f276870d = new a(this);
        this.f276867a = r100;
        this.f276869c = false;
    }

    private int a(Context r100) {
        if (HMSPackageManager.getInstance(r100).isUseOldCertificate() == false) goto L6;
        HMSLog.e("AvailableAdapter", "The CP uses the old certificate to terminate the connection.");
        return 13;
    L6:
        PackageManagerHelper.PackageStates r101 = HMSPackageManager.getInstance(r100).getHMSPackageStatesForMultiService();
        if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(r101) == false) goto L11;
        HMSLog.i("AvailableAdapter", "HMS is not installed");
        return 1;
    L11:
        if (PackageManagerHelper.PackageStates.SPOOF.equals(r101) == false) goto L15;
        HMSLog.i("AvailableAdapter", "HMS is spoofed");
        return 29;
    L15:
        if (PackageManagerHelper.PackageStates.DISABLED.equals(r101) == false) goto L18;
        HMSLog.i("AvailableAdapter", "HMS is disabled");
        return 3;
    L18:
        return 0;
    }

    private void b(Context r100) {
        HMSBIInitializer.getInstance(r100).initBI();
    }

    public int checkHuaweiMobileServicesForUpdate(Context r100) {
        Checker.checkNonNull(r100, "context must not be null.");
        int r101 = a(r100);
        if (r101 == 0) goto L6;
        return r101;
    L6:
        if (HMSPackageManager.getInstance(r100).isApkNeedUpdate(this.f276867a) == false) goto L9;
        HMSLog.i("AvailableAdapter", "The current version does not meet the target version requirements");
        return 2;
    L9:
        return r101;
    }

    public int isHuaweiMobileServicesAvailable(Context r100) {
        Checker.checkNonNull(r100, "context must not be null.");
        int r101 = a(r100);
        if (r101 == 0) goto L6;
        return r101;
    L6:
        if (HMSPackageManager.getInstance(r100).isApkUpdateNecessary(this.f276867a) == false) goto L9;
        HMSLog.i("AvailableAdapter", "The current version does not meet the minimum version requirements");
        return 2;
    L9:
        return r101;
    }

    public void setCalledBySolutionInstallHms(boolean r100) {
        this.f276869c = r100;
    }

    private boolean a(Activity r100) {
        if (HMSPackageManager.getInstance(r100).isUpdateHmsForThirdPartyDevice() == false) goto L6;
        return false;
    L6:
        if (HMSPackageManager.getInstance(r100).getHmsVersionCode() < 40000000) goto L9;
        HMSLog.i("AvailableAdapter", "enter 4.0 HmsCore upgrade process");
        return true;
    L9:
        return false;
    }

    public static /* synthetic */ AvailableCallBack a(AvailableAdapter r100) {
        return r100.a();
    }

    private void a(Activity r100, AvailableCallBack r101) {
        HMSLog.i("AvailableAdapter", "<showHmsApkNotInstalledDialog> startResolution");
        if (NotInstalledHmsAdapter.getShowLock() == false) goto L5;
        this.f276868b = r101;
        SystemManager.getSystemNotifier().registerObserver(this.f276870d);
        r100.startActivity(BridgeActivity.getIntentStartBridgeActivity(r100, NotInstalledHmsAdapter.class.getName()));
        return;
    L5:
        r101.onComplete(31);
    }

    public void startNotice(Activity r100, AvailableCallBack r101) {
        if (r100 == null) goto L11;
        if (r101 != null) goto L6;
        return;
    L6:
        if (UIUtil.isBackground(r100) == false) goto L9;
        HMSLog.i("AvailableAdapter", "current app is in Background");
        r101.onComplete(28);
        return;
    L9:
        HMSLog.i("AvailableAdapter", "startNotice");
        this.f276868b = r101;
        SystemManager.getSystemNotifier().registerObserver(this.f276870d);
        r100.startActivity(BridgeActivity.getIntentStartBridgeActivity(r100, AppSpoofResolution.class.getName()));
        return;
    }

    public void startResolution(Activity r100, AvailableCallBack r101) {
        if (r100 == null) goto L22;
        if (r101 == null) goto L23;
        b(r100);
        if (UIUtil.isBackground(r100) == false) goto L9;
        HMSLog.i("AvailableAdapter", "current app is in Background");
        r101.onComplete(28);
        return;
    L9:
        boolean r102 = a(r100);
        if (AvailableUtil.isInstallerLibExist(r100) == true) goto L15;
        if (r102 == true) goto L15;
        a(r100, r101);
        return;
    L15:
        if (c.f276994b.b() == true) goto L17;
        return;
    L17:
        HMSLog.i("AvailableAdapter", "startResolution");
        this.f276868b = r101;
        SystemManager.getSystemNotifier().registerObserver(this.f276870d);
        Intent r103 = BridgeActivity.getIntentStartBridgeActivity(r100, UpdateAdapter.class.getName());
        r103.putExtra("update_version", this.f276867a);
        if (this.f276869c == false) goto L20;
        r103.putExtra("installHMS", "installHMS");
    L20:
        r103.putExtra(CommonCode.MapKey.NEW_UPDATE, r102);
        r100.startActivity(r103);
        return;
    L23:
        return;
    }
}
