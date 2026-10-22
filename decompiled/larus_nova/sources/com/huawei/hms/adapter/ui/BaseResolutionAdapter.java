package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.ApkResolutionFailedManager;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.utils.IntentUtil;
import com.huawei.hms.utils.RegionUtils;
import com.huawei.hms.utils.ResolutionFlagUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes23.dex */
public class BaseResolutionAdapter implements IBridgeActivityDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f276919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f276920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f276921c;

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 1001;
    }

    private Activity c() {
        WeakReference<Activity> r100 = this.f276919a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.i("BaseResolutionAdapter", "onBridgeActivityDestroy");
        this.f276919a = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.i("BaseResolutionAdapter", "onBridgeConfigurationChanged");
    }

    public BaseResolutionAdapter() {
        this.f276920b = "";
        this.f276921c = 0;
    }

    private boolean a() {
        long r100 = ResolutionFlagUtil.getInstance().getResolutionFlag(this.f276920b);
        ResolutionFlagUtil.getInstance().removeResolutionFlag(this.f276920b);
        if (r100 != 0) goto L5;
    L8:
        a(r100);
        return false;
    L5:
        if (r100 != this.f276921c) goto L8;
        return true;
    }

    private void b() {
        Activity r100 = c();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isFinishing() == true) goto L10;
        r100.finish();
        return;
    }

    private void d() {
        SystemManager.getInstance().notifyResolutionResult(null, this.f276920b);
        b();
    }

    private void a(long r100) {
        if (RegionUtils.isChinaROM(c()) == true) goto L6;
        HMSLog.i("BaseResolutionAdapter", "not ChinaROM");
        return;
    L6:
        Activity r101 = c();
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.isFinishing() == true) goto L14;
        HashMap r102 = new HashMap();
        r102.put("package", r101.getPackageName());
        r102.put(CommonCode.MapKey.RESOLUTION_FLAG, this.f276921c + "-" + r100);
        HiAnalyticsUtils.getInstance().onEvent(r101, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, r102);
        HMSLog.e("BaseResolutionAdapter", "check resolution flag failed, transactionId: " + this.f276920b + ", carriedTimeStamp: " + this.f276921c + ", savedTimeStamp: " + r100);
        return;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity r110) {
        if (r110 != null) goto L7;
        HMSLog.e("BaseResolutionAdapter", "activity is null");
        d();
        return;
    L7:
        if (r110.isFinishing() == false) goto L10;
        HMSLog.e("BaseResolutionAdapter", "activity is finishing");
        return;
    L10:
        this.f276919a = new WeakReference(r110);
        Intent r100 = r110.getIntent();
        if (r100 != null) goto L51;
        d();
        return;
    L51:
        Bundle r101 = r100.getExtras();     // Catch: Throwable -> L19
        this.f276920b = r100.getStringExtra(CommonCode.MapKey.TRANSACTION_ID);     // Catch: Throwable -> L17
        this.f276921c = r100.getLongExtra(CommonCode.MapKey.RESOLUTION_FLAG, 0);     // Catch: Throwable -> L17
    L23:
        if (a() == true) goto L27;
        d();
        return;
    L27:
        if (this.f276920b != null) goto L29;
    L31:
        if (r101 != null) goto L34;
        d();
        return;
    L34:
        Parcelable r102 = r101.getParcelable("resolution");
        if (r102 != null) goto L39;
        d();
        return;
    L39:
        if ((r102 instanceof Intent) == false) goto L44;
        r110.startActivityForResult(IntentUtil.modifyIntentBehaviorsSafe((Intent) r102), 1001);     // Catch: Throwable -> L42
        return;
    L42:
        d();
        HMSLog.e("BaseResolutionAdapter", "ActivityNotFoundException:exception");
        return;
    L44:
        if ((r102 instanceof PendingIntent) == false) goto L58;
        r110.startIntentSenderForResult(((PendingIntent) r102).getIntentSender(), 1001, null, 0, 0, 0);     // Catch: IntentSender.SendIntentException -> L47
        return;
    L47:
        d();
        HMSLog.e("BaseResolutionAdapter", "SendIntentException:exception");
        return;
    L58:
        return;
    L29:
        if (Build.VERSION.SDK_INT < 29) goto L31;
        HMSLog.i("BaseResolutionAdapter", "remove apk resolution failed task.");
        ApkResolutionFailedManager.getInstance().removeTask(this.f276920b);
    L17:
        th = th;
    L21:
        HMSLog.e("BaseResolutionAdapter", "get transaction_id or resolution_flag exception:".concat(th.getClass().getSimpleName()));
    L19:
        th = th;
        r101 = null;
        goto L21
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int r100, KeyEvent r101) {
        HMSLog.i("BaseResolutionAdapter", "On key up when resolve conn error");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int r100, int r101, Intent r102) {
        if (r100 == getRequestCode()) goto L6;
        return false;
    L6:
        HMSLog.i("BaseResolutionAdapter", "onBridgeActivityResult, resultCode: " + r101);
        if (r101 != 1001) goto L9;
    L10:
        if (r102 != null) goto L12;
        r102 = new Intent();
    L12:
        r102.putExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT, r101);
    L14:
        if (r101 != (-1)) goto L16;
    L21:
        SystemManager.getInstance().notifyResolutionResult(r102, this.f276920b);
    L22:
        b();
        return true;
    L16:
        if (r102.hasExtra(KpmsConstant.KIT_UPDATE_RESULT) == true) goto L21;
        if (r102.hasExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT) == true) goto L21;
        SystemManager.getInstance().notifyResolutionResult(null, this.f276920b);
        goto L22
    L9:
        if (r101 != 1002) goto L14;
        goto L10
    }
}
