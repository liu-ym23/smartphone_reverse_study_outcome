package sa7;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f541194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SharedPreferences f541195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f541196c;

    public i() {
    }

    public static void b() {
        if (f541194a == false) goto L5;
        return;
    L5:
        monitor-enter(i.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (f541194a == true) goto L13;
        Context r100 = com.ss.android.account.k.c();     // Catch: Throwable -> L15
        if (r100 != null) goto L12;
        monitor-exit(i.class);     // Catch: Throwable -> L15
        return;
    L12:
        SharedPreferences r101 = r100.getSharedPreferences("CsrfTokenManager_sp", 0);     // Catch: Throwable -> L15
        f541195b = r101;     // Catch: Throwable -> L15
        f541196c = r101.getString("csrf_token", null);     // Catch: Throwable -> L15
        f541194a = true;     // Catch: Throwable -> L15
    L13:
        monitor-exit(i.class);     // Catch: Throwable -> L15
    }

    public static void a(String r100) {
        b();
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.equals(r100, f541196c) == true) goto L10;
        f541196c = r100;
        f541195b.edit().putString("csrf_token", r100).apply();
        return;
    }
}
