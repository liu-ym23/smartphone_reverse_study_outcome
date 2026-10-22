package com.bytedance.helios.sdk.appops;

import android.app.AppOpsManager;
import android.content.Context;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes19.dex */
public final class AppOpsMonitor {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f245488e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static AppOpsMonitor f245489f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppOpsManager f245490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f245491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppOpsMonitor$mOpActiveListener$1 f245492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppOpsMonitor$mOnOpNotedCallback$1 f245493d;

    public static final class a {
    }

    static {
        f245488e = new String[]{"android:camera", "android:record_audio"};
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.helios.sdk.appops.AppOpsMonitor$mOpActiveListener$1] */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.helios.sdk.appops.AppOpsMonitor$mOnOpNotedCallback$1] */
    public AppOpsMonitor(Context r100) {
        this.f245492c = new AppOpsMonitor$mOpActiveListener$1();
        this.f245493d = new AppOpsMonitor$mOnOpNotedCallback$1();
        this.f245491b = r100.getApplicationContext();
        Object r101 = r100.getSystemService("appops");
        if (r101 == null) goto L7;
        this.f245490a = (AppOpsManager) r101;
        return;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type android.app.AppOpsManager");
    }
}
