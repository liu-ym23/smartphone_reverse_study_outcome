package com.huawei.hms.adapter.sysobs;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.log.HMSLog;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class ApkResolutionFailedManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ApkResolutionFailedManager f276912c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f276913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Runnable> f276914b;

    static {
        f276912c = new ApkResolutionFailedManager();
    }

    private ApkResolutionFailedManager() {
        this.f276913a = new Handler(Looper.getMainLooper());
        this.f276914b = new HashMap(2);
    }

    public static ApkResolutionFailedManager getInstance() {
        return f276912c;
    }

    public void removeTask(String r100) {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
        HMSLog.e("ApkResolutionFailedManager", "removeTask is not in main thread");
        return;
    L6:
        Runnable r101 = this.f276914b.remove(r100);
        if (r101 != null) goto L10;
        HMSLog.e("ApkResolutionFailedManager", "cancel runnable is null");
        return;
    L10:
        this.f276913a.removeCallbacks(r101);
    }

    public void removeValueOnly(String r100) {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
        HMSLog.e("ApkResolutionFailedManager", "removeValueOnly is not in main thread");
        return;
    L6:
        this.f276914b.remove(r100);
    }

    public void postTask(String r100, Runnable r101) {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
        HMSLog.e("ApkResolutionFailedManager", "postTask is not in main thread");
        return;
    L6:
        this.f276914b.put(r100, r101);
        this.f276913a.postDelayed(r101, 2000);
    }
}
