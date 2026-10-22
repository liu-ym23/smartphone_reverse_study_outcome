package i37;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f488112b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f488113a;

    public a(Context r100) {
        this.f488113a = r100.getSharedPreferences("__ctx_info.sp", 0);
    }

    public static a a(Context r100) {
        if (f488112b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f488112b != null) goto L9;
        f488112b = new a(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f488112b;
    }

    public final synchronized void c(long r100) {
        monitor-enter(this);
        this.f488113a.edit().putLong("key_settings_time", r100).apply();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(String r100, long r101) {
        monitor-enter(this);
        this.f488113a.edit().putLong("key_settings_time_" + r100, r101).apply();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
