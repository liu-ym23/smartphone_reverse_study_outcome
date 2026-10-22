package p77;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile b f528042f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f528043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f528044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f528045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f528046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f528047e;

    public static b a() {
        if (f528042f != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f528042f != null) goto L9;
        f528042f = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f528042f;
    }

    public b() {
        this.f528046d = new a("bdpush_is_first_process.lock");
        this.f528047e = new a("bdpush_local_settings_sp.lock");
    }

    public final boolean b(Context r100) {
        int r101 = q77.a.f531973a;     // Catch: Throwable -> L11
        d87.a.b(r100);     // Catch: Throwable -> L11
        if (this.f528043a == true) goto L5;
        this.f528043a = true;     // Catch: Throwable -> L11
        this.f528044b = this.f528046d.a(r100);     // Catch: Throwable -> L11
        d87.a.b(r100);     // Catch: Throwable -> L11
        if (this.f528044b == false) goto L10;
        c(r100);     // Catch: Throwable -> L11
    L10:
        return this.f528044b;
    L5:
        return this.f528044b;
    L11:
        th = move-exception;
        th.printStackTrace();
        this.f528044b = false;
        return false;
    }

    public final void c(Context r100) {
        if (this.f528047e.a(r100) == false) goto L12;
        SharedPreferences.Editor r101 = r100.getSharedPreferences("local_settings_sp", 0).edit();
        r101.putString("first_process", d87.a.b(r100));
        r101.putInt("first_process_pid", Process.myPid());
        r101.apply();
        int r102 = q77.a.f531973a;
        d87.a.b(r100);
        a r103 = this.f528047e;
        r103.getClass();
        r103.f528041d.release();     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
