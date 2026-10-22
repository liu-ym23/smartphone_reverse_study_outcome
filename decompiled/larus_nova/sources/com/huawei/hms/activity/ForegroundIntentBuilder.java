package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.api.entity.core.CoreNaming;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.utils.Util;

/* JADX INFO: loaded from: classes23.dex */
public class ForegroundIntentBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f276854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RequestHeader f276855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f276856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ForegroundInnerHeader f276857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f276858e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f276859f;

    public Intent build() {
        Intent r100 = BridgeActivity.getIntentStartBridgeActivity(this.f276854a, ForegroundBusDelegate.class.getName());
        Context r101 = this.f276859f;
        if (r101 == null) goto L5;
        String r102 = r101.getPackageName();
        String r103 = Util.getAppId(this.f276859f);
    L7:
        if (this.f276855b.getAppID() != null) goto L9;
        this.f276855b.setAppID(r103 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
    L11:
        if (TextUtils.isEmpty(this.f276855b.getTransactionId()) == false) goto L13;
        RequestHeader r104 = this.f276855b;
        r104.setTransactionId(TransactionIdCreater.getId(r104.getAppID(), CoreNaming.HUBREQUEST));
    L13:
        this.f276855b.setPkgName(r102);
        r100.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_HEADER, this.f276855b.toJson());
        r100.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_BODY, this.f276856c);
        r100.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_INNER, this.f276857d.toJson());
        if (TextUtils.isEmpty(this.f276858e) == true) goto L16;
        r100.putExtra(ForegroundBusDelegate.INNER_PKG_NAME, this.f276858e);
    L16:
        return r100;
    L9:
        this.f276855b.setAppID(r103 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.f276855b.getAppID());
        goto L11
    L5:
        r102 = this.f276854a.getPackageName();
        r103 = Util.getAppId(this.f276854a);
        goto L7
    }

    public ForegroundIntentBuilder setInnerHms() {
        this.f276858e = this.f276854a.getPackageName();
        return this;
    }

    public ForegroundIntentBuilder(Activity r100) throws IllegalArgumentException {
        if (r100 == null) goto L7;
        this.f276854a = r100;
        RequestHeader r101 = new RequestHeader();
        this.f276855b = r101;
        r101.setSdkVersion(61300301);
        this.f276856c = "";
        ForegroundInnerHeader r102 = new ForegroundInnerHeader();
        this.f276857d = r102;
        r102.setApkVersion(30000000);
        return;
    L7:
        throw new IllegalArgumentException("listener must not be null.");
    }

    public static void unregisterResponseCallback(String r100) {
        ForegroundBusResponseMgr.getInstance().unRegisterObserver(r100);
    }

    public ForegroundIntentBuilder setAction(String r100) {
        this.f276855b.setApiName(r100);
        return this;
    }

    public ForegroundIntentBuilder setApiLevel(int r100) {
        this.f276855b.setApiLevel(r100);
        return this;
    }

    public ForegroundIntentBuilder setApplicationContext(Context r100) {
        this.f276859f = r100;
        return this;
    }

    public ForegroundIntentBuilder setKitSdkVersion(int r100) {
        this.f276855b.setKitSdkVersion(r100);
        return this;
    }

    public ForegroundIntentBuilder setMinApkVersion(int r100) {
        this.f276857d.setApkVersion(r100);
        return this;
    }

    public ForegroundIntentBuilder setRequestBody(String r100) {
        this.f276856c = r100;
        return this;
    }

    public ForegroundIntentBuilder setResponseCallback(String r100) {
        this.f276857d.setResponseCallbackKey(r100);
        return this;
    }

    public ForegroundIntentBuilder setServiceName(String r100) {
        this.f276855b.setSrvName(r100);
        return this;
    }

    public ForegroundIntentBuilder setSubAppId(String r100) {
        this.f276855b.setAppID(r100);
        return this;
    }

    public ForegroundIntentBuilder setTransactionId(String r100) {
        this.f276855b.setTransactionId(r100);
        return this;
    }

    public static void registerResponseCallback(String r100, BusResponseCallback r101) {
        ForegroundBusResponseMgr.getInstance().registerObserver(r100, r101);
    }

    public ForegroundIntentBuilder setResponseCallback(String r100, BusResponseCallback r101) {
        this.f276857d.setResponseCallbackKey(r100);
        ForegroundBusResponseMgr.getInstance().registerObserver(r100, r101);
        return this;
    }
}
