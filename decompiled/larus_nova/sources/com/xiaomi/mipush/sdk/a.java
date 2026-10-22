package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.push.dr;
import com.xiaomi.push.ds;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes41.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Set<String> f463045a;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r100) {
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

    public a() {
        this.f463045a = new HashSet();
    }

    public static void a(Context r100) {
        a((Application) r100.getApplicationContext());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r100) {
        Intent r101 = r100.getIntent();     // Catch: Throwable -> L17
        if (r101 != null) goto L5;
        return;
    L5:
        String r102 = r101.getStringExtra("messageId");     // Catch: Throwable -> L17
        int r103 = r101.getIntExtra("eventMessageType", -1);     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r102) == true) goto L20;
        if (r103 <= 0) goto L20;
        if (this.f463045a.contains(r102) == true) goto L20;
        this.f463045a.add(r102);     // Catch: Throwable -> L17
        if (r103 != 3000) goto L14;
        ds.a(r100.getApplicationContext()).a(r100.getPackageName(), dr.m9025a(r103), r102, 3008, null);     // Catch: Throwable -> L17
        goto L20
    L14:
        if (r103 != 1000) goto L20;
        ds.a(r100.getApplicationContext()).a(r100.getPackageName(), dr.m9025a(r103), r102, 1008, null);     // Catch: Throwable -> L17
    L20:
        return;
    L17:
        th = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("An error occurred in onActivityResumed method: " + th);
    }

    private static void a(Application r100) {
        r100.registerActivityLifecycleCallbacks(new a());
    }
}
