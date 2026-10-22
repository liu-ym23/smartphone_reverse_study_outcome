package n4a;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static byte[] f517195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f517196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f517197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, String> f517198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Integer f517199e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Integer f517200f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Integer f517201g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Integer f517202h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Integer f517203i = null;

    static {
        f517198d = new ConcurrentHashMap(8);
        f517199e = 1;
        f517200f = 2;
        f517201g = 3;
        f517202h = 4;
        f517203i = 5;
    }

    public static String a(String r100) {
        String r101 = "";
        ConcurrentHashMap<String, String> r102 = f517198d;     // Catch: Throwable -> L16
        monitor-enter(r102);     // Catch: Throwable -> L16
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L6:
        if (f517198d != null) goto L8;
    L10:
        monitor-exit(r102);     // Catch: Throwable -> L12
        goto L15
    L8:
        if (f517198d.containsKey(r100) == false) goto L10;
        r101 = f517198d.get(r100);     // Catch: Throwable -> L12
    L15:
        return r101;
    }

    public static void b(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L26;
        ConcurrentHashMap<String, String> r102 = f517198d;     // Catch: Throwable -> L21
        monitor-enter(r102);     // Catch: Throwable -> L21
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
        goto L27
    L10:
        if (f517198d != null) goto L13;
        f517198d = new ConcurrentHashMap(8);     // Catch: Throwable -> L17
    L13:
        if (f517198d.containsKey(r100) == true) goto L15;
        f517198d.put(r100, r101);     // Catch: Throwable -> L17
    L15:
        monitor-exit(r102);     // Catch: Throwable -> L17
        return;
        goto L27
    L26:
        return;
    }
}
