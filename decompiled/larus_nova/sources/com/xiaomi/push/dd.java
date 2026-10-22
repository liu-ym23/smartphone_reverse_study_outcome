package com.xiaomi.push;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* JADX INFO: loaded from: classes41.dex */
public class dd implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f463333a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f463334b;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r100) {
    }

    private void a(String r100) {
        gm r101 = new gm();
        r101.a(r100);
        r101.a(System.currentTimeMillis());
        r101.a(gg.f463692s);
        dk.a(this.f463333a, r101);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r100) {
        String r101 = r100.getLocalClassName();
        if (TextUtils.isEmpty(this.f378a) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L16;
        this.f463334b = "";
        if (TextUtils.isEmpty("") == false) goto L10;
    L13:
        a(this.f463333a.getPackageName() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r101 + ":" + this.f378a + "," + String.valueOf(System.currentTimeMillis() / 1000));
        this.f378a = "";
        this.f463334b = "";
        return;
    L10:
        if (TextUtils.equals(this.f463334b, r101) == true) goto L13;
        this.f378a = "";
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r100) {
        if (TextUtils.isEmpty(this.f463334b) == false) goto L5;
        this.f463334b = r100.getLocalClassName();
    L5:
        this.f378a = String.valueOf(System.currentTimeMillis() / 1000);
    }

    public dd(Context r100, String r101) {
        this.f463333a = r100;
        this.f378a = r101;
    }
}
