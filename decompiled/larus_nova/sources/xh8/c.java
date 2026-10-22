package xh8;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile c f563888b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f563889a;

    public class a implements SQLiteDatabase.CursorFactory {
        public a() {
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public final Cursor newCursor(SQLiteDatabase r100, SQLiteCursorDriver r101, String r102, SQLiteQuery r103) {
            return new SQLiteCursor(r101, r102, r103);
        }
    }

    public static c a() {
        if (f563888b != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f563888b != null) goto L9;
        f563888b = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f563888b;
    }

    public c() {
        this.f563889a = SQLiteDatabase.create(new a());
    }
}
