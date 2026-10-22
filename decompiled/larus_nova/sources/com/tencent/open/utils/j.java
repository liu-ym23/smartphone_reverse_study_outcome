package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.open.log.SLog;
import java.lang.ref.WeakReference;
import java.net.URL;

/* JADX INFO: loaded from: classes35.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static j f461858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile WeakReference<SharedPreferences> f461859b;

    public static synchronized j a() {
        monitor-enter(j.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f461858a != null) goto L7;
        f461858a = new j();     // Catch: Throwable -> L10
    L7:
        j r100 = f461858a;     // Catch: Throwable -> L10
        monitor-exit(j.class);
        return r100;
    }

    public j() {
        this.f461859b = null;
    }

    public String a(Context r100, String r101) {
        if (this.f461859b != null) goto L5;
    L6:
        this.f461859b = new WeakReference(r100.getSharedPreferences("ServerPrefs", 0));
    L23:
        String r102 = new URL(r101).getHost();     // Catch: Exception -> L20
        if (r102 != null) goto L11;
        SLog.e("openSDK_LOG.ServerSetting", "Get host error. url=" + r101);     // Catch: Exception -> L20
        return r101;
    L11:
        String r103 = this.f461859b.get().getString(r102, null);     // Catch: Exception -> L20
        if (r103 != null) goto L14;
    L18:
        SLog.v("openSDK_LOG.ServerSetting", "host=" + r102 + ", envHost=" + r103);     // Catch: Exception -> L20
        return r101;
    L14:
        if (r102.equals(r103) == true) goto L18;
        String r104 = r101.replace(r102, r103);     // Catch: Exception -> L20
        SLog.v("openSDK_LOG.ServerSetting", "return environment url : " + r104);     // Catch: Exception -> L20
        return r104;
    L20:
        e = move-exception;
        SLog.e("openSDK_LOG.ServerSetting", "getEnvUrl url=" + r101 + "error.: " + e.getMessage());
        return r101;
    L5:
        if (this.f461859b.get() != null) goto L23;
        goto L6
    }
}
