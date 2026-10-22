package com.huawei.hms.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IntentUtil;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes23.dex */
public class ResolutionDelegate implements IBridgeActivityDelegate {
    public static final String CALLBACK_METHOD = "CALLBACK_METHOD";
    private static final int REQUEST_CODE = 1002;
    private static final String TAG = "ResolutionDelegate";
    private WeakReference<Activity> mThisWeakRef;

    public ResolutionDelegate() {
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 1002;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        this.mThisWeakRef = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int r100, KeyEvent r101) {
    }

    private Activity getActivity() {
        WeakReference<Activity> r100 = this.mThisWeakRef;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    private void finishBridgeActivity() {
        Activity r100 = getActivity();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isFinishing() == true) goto L10;
        r100.finish();
        return;
    }

    private BusResponseCallback getResponseCallback(String r100) {
        return ForegroundBusResponseMgr.getInstance().get(r100);
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity r100) {
        if (r100 != null) goto L5;
    L15:
        HMSLog.e(TAG, "activity is null or finishing");
        return;
    L5:
        if (r100.isFinishing() == true) goto L15;
        this.mThisWeakRef = new WeakReference(r100);
        Bundle r101 = r100.getIntent().getExtras();     // Catch: Exception -> L10
    L12:
        if (r101 == null) goto L19;
        r100.startActivityForResult(IntentUtil.modifyIntentBehaviorsSafe((Intent) r101.getParcelable("resolution")), 1002);
        return;
    L19:
        return;
    L10:
        e = move-exception;
        HMSLog.e(TAG, "getExtras exception:" + e.getMessage());
        r101 = null;
        goto L12
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int r100, int r101, Intent r102) {
        if (r100 == getRequestCode()) goto L6;
        return false;
    L6:
        BusResponseCallback r103 = getResponseCallback(CALLBACK_METHOD);
        Activity r104 = this.mThisWeakRef.get();
        int r105 = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(r104, 30000000);
        if (r101 != (-1)) goto L10;
        if (r105 != 0) goto L10;
        HMSLog.i(TAG, "Make service available success.");
    L11:
        finishBridgeActivity();
        return true;
    L10:
        r103.innerError(this.mThisWeakRef.get(), r101, "Make service available failed.");
        goto L11
    }
}
