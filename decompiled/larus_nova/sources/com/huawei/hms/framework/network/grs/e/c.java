package com.huawei.hms.framework.network.grs.e;

import android.content.Context;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes23.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f277182b = "c";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, PLSharedPreferences> f277183c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PLSharedPreferences f277184a;

    static {
        f277183c = new ConcurrentHashMap(16);
    }

    public c(Context r100, String r101) {
        String r102 = r100.getPackageName();
        Logger.d(f277182b, "get pkgname from context is{%s}", new Object[]{r102});
        Map<String, PLSharedPreferences> r103 = f277183c;
        if (r103.containsKey(r101 + r102) == false) goto L5;
        this.f277184a = r103.get(r101 + r102);
    L6:
        a(r100);
        return;
    L5:
        PLSharedPreferences r104 = new PLSharedPreferences(r100, r101 + r102);
        this.f277184a = r104;
        r103.put(r101 + r102, r104);
        goto L6
    }

    private void a(Context r100) {
        String r101 = f277182b;
        Logger.i(r101, "ContextHolder.getAppContext() from GRS is:" + ContextHolder.getAppContext());
        if (ContextHolder.getAppContext() == null) goto L13;
        r100 = ContextHolder.getAppContext();
    L13:
        String r102 = Long.toString(r100.getPackageManager().getPackageInfo(r100.getPackageName(), 16384).versionCode);     // Catch: Throwable -> L11
        String r103 = a("version", "");
        if (r102.equals(r103) == true) goto L15;
        Logger.i(r101, "app version changed! old version{%s} and new version{%s}", new Object[]{r103, r102});
        b();
        b("version", r102);
        return;
    L15:
        return;
    L11:
        Logger.w(f277182b, "get app version failed and catch NameNotFoundException");
    }

    public String a(String r100, String r101) {
        PLSharedPreferences r102 = this.f277184a;
        if (r102 != null) goto L5;
        return r101;
    L5:
        monitor-enter(r102);
        String r103 = this.f277184a.getString(r100, r101);     // Catch: Throwable -> L9
        monitor-exit(r102);     // Catch: Throwable -> L9
        return r103;
    L9:
        th = move-exception;
        throw th;
    }

    public Map<String, ?> a() {
        PLSharedPreferences r100 = this.f277184a;
        if (r100 == null) goto L5;
        monitor-enter(r100);
        Map<String, ?> r101 = this.f277184a.getAll();     // Catch: Throwable -> L10
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    L10:
        th = move-exception;
        throw th;
    L5:
        return new HashMap();
    }

    public void a(String r100) {
        PLSharedPreferences r101 = this.f277184a;
        if (r101 != null) goto L5;
        return;
    L5:
        monitor-enter(r101);
        this.f277184a.remove(r100);     // Catch: Throwable -> L9
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void b() {
        PLSharedPreferences r100 = this.f277184a;
        if (r100 != null) goto L5;
        return;
    L5:
        monitor-enter(r100);
        this.f277184a.clear();     // Catch: Throwable -> L9
        monitor-exit(r100);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void b(String r100, String r101) {
        PLSharedPreferences r102 = this.f277184a;
        if (r102 != null) goto L5;
        return;
    L5:
        monitor-enter(r102);
        this.f277184a.putString(r100, r101);     // Catch: Throwable -> L9
        monitor-exit(r102);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
