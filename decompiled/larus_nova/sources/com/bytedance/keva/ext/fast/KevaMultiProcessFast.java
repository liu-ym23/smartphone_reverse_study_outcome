package com.bytedance.keva.ext.fast;

import android.content.Context;
import android.net.Uri;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes19.dex */
public class KevaMultiProcessFast {
    static Uri CALL_URI;
    private static final Map<String, Keva> KEVA_MAP = null;
    private static Context sContext;
    private static KevaMultiProcessFastMonitor sMonitor;

    public KevaMultiProcessFast() {
    }

    public static /* synthetic */ void a(String r100, String r101, Throwable r102) {
        lambda$init$0(r100, r101, r102);
    }

    private static /* synthetic */ void lambda$init$0(String r100, String r101, Throwable r102) {
    }

    static {
        KEVA_MAP = new ConcurrentHashMap();
    }

    public static boolean enable() {
        if (sContext != null) goto L5;
    L7:
        return false;
    L5:
        if (sMonitor == null) goto L7;
        return true;
    }

    public static void forceInit() {
        Keva.forceInit();
    }

    public static Context getContext() {
        return sContext;
    }

    public static KevaMultiProcessFastMonitor getMonitor() {
        return sMonitor;
    }

    public static Keva getRepo(String r100) {
        return getKeva(r100, false, false);
    }

    public static Keva getRepoSync(String r100) {
        return getKeva(r100, false, true);
    }

    public static boolean isRepoPorted(String r100) {
        return Keva.isRepoPorted(r100);
    }

    public static Keva getRepoFromSp(Context r100, String r101) {
        return getKeva(r101, true, false);
    }

    public static Keva getRepoFromSpSync(Context r100, String r101) {
        return getKeva(r101, true, true);
    }

    public static synchronized void init(Context r100, KevaMultiProcessFastMonitor r101) {
        monitor-enter(KevaMultiProcessFast.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (sContext != null) goto L10;
        sContext = r100;     // Catch: Throwable -> L12
        CALL_URI = UriProtector.parse("content://" + r100.getApplicationInfo().packageName + ".fast.KevaMultiProcessContentProvider");     // Catch: Throwable -> L12
        if (r101 == null) goto L9;
        sMonitor = r101;     // Catch: Throwable -> L12
        goto L10
    L9:
        sMonitor = new a();     // Catch: Throwable -> L12
    L10:
        monitor-exit(KevaMultiProcessFast.class);
    }

    private static Keva getKeva(String r100, boolean r101, boolean r102) {
        Map<String, Keva> r103 = KEVA_MAP;
        Keva r104 = r103.get(r100);
        if (r104 == null) goto L5;
    L13:
        return r104;
    L5:
        monitor-enter(KevaMultiProcessFast.class);
        if (r104 == null) goto L14;
    L8:
        monitor-exit(KevaMultiProcessFast.class);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L14:
        r104 = new KevaMultiProcessFastImpl(r100, r101, r102);     // Catch: Throwable -> L10
        r103.put(r100, r104);     // Catch: Throwable -> L10
        goto L8
    }
}
