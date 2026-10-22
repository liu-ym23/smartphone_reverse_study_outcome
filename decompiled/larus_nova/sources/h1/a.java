package h1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.apm.lite.k.p;

/* JADX INFO: loaded from: classes39.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f483510c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j1.b f483511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SQLiteDatabase f483512b;

    public a() {
    }

    public static a a() {
        if (f483510c != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f483510c != null) goto L9;
        f483510c = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f483510c;
    }

    public final synchronized void b(Context r100) {
        monitor-enter(this);
        this.f483512b = new b(r100).getWritableDatabase();     // Catch: Throwable -> L5
    L6:
        this.f483511a = new j1.b();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    L5:
        p.c();     // Catch: Throwable -> L9
        goto L6
    }
}
