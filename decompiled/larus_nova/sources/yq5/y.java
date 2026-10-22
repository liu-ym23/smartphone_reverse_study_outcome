package yq5;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class y extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f568846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f568847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f568848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f568849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final x f568850e;

    public y(WikiDatabase r100) {
        this.f568846a = r100;
        this.f568847b = new u(r100);
        this.f568848c = new v(r100);
        this.f568849d = new w(r100);
        this.f568850e = new x(r100);
    }

    public final void b(String r100) {
        this.f568846a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r101 = this.f568850e.acquire();
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.f568846a.beginTransaction();
        r101.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f568846a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.f568846a.endTransaction();
        this.f568850e.release(r101);
        return;
    L10:
        th = move-exception;
        this.f568846a.endTransaction();
        this.f568850e.release(r101);
        throw th;
    L5:
        r101.bindString(1, r100);
        goto L6
    }

    public final void c(String r100) {
        this.f568846a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r101 = this.f568849d.acquire();
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.f568846a.beginTransaction();
        r101.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f568846a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.f568846a.endTransaction();
        this.f568849d.release(r101);
        return;
    L10:
        th = move-exception;
        this.f568846a.endTransaction();
        this.f568849d.release(r101);
        throw th;
    L5:
        r101.bindString(1, r100);
        goto L6
    }

    public static void a(y r100, z r101) {
        if (r101.f568855e == false) goto L5;
        r100.c(r101.f568852b);
    L6:
        r100.f568846a.assertNotSuspendingTransaction();
        r100.f568846a.beginTransaction();
        r100.f568847b.insert(r101);     // Catch: Throwable -> L10
        r100.f568846a.setTransactionSuccessful();     // Catch: Throwable -> L10
        r100.f568846a.endTransaction();
        return;
    L10:
        th = move-exception;
        r100.f568846a.endTransaction();
        throw th;
    L5:
        r100.b(r101.f568853c);
        goto L6
    }
}
