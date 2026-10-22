package lg7;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import com.bytedance.sync.v2.presistence.AppDatabase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public final class g implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f509175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f509176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f509177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f509178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f509179e;

    public g(AppDatabase r100) {
        this.f509175a = r100;
        this.f509176b = new b(r100);
        this.f509177c = new c(r100);
        new d(r100);
        this.f509178d = new e(r100);
        this.f509179e = new f(r100);
    }

    public final List<mg7.c> a(String r110) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM t_sync_cursor WHERE did = ?", 1);
        if (r110 != null) goto L5;
        r100.bindNull(1);
    L6:
        Cursor r111 = this.f509175a.query(r100);
        int r101 = r111.getColumnIndexOrThrow("sync_id");     // Catch: Throwable -> L14
        int r102 = r111.getColumnIndexOrThrow(com.bytedance.android.ec.core.event.a.KEY_DID);     // Catch: Throwable -> L14
        int r103 = r111.getColumnIndexOrThrow("uid");     // Catch: Throwable -> L14
        int r104 = r111.getColumnIndexOrThrow("topic_type");     // Catch: Throwable -> L14
        int r105 = r111.getColumnIndexOrThrow("bucket");     // Catch: Throwable -> L14
        int r106 = r111.getColumnIndexOrThrow("recv_cursor");     // Catch: Throwable -> L14
        int r107 = r111.getColumnIndexOrThrow("report_cursor");     // Catch: Throwable -> L14
        ArrayList r108 = new ArrayList(r111.getCount());     // Catch: Throwable -> L14
    L9:
        if (r111.moveToNext() == false) goto L12;
        mg7.c r109 = new mg7.c();     // Catch: Throwable -> L14
        r109.f513757a = r111.getString(r101);     // Catch: Throwable -> L14
        r109.f513758b = r111.getString(r102);     // Catch: Throwable -> L14
        r109.f513759c = r111.getString(r103);     // Catch: Throwable -> L14
        r109.f513760d = kg7.g.b(r111.getInt(r104));     // Catch: Throwable -> L14
        r109.f513761e = kg7.a.b(r111.getInt(r105));     // Catch: Throwable -> L14
        r109.f513762f = r111.getLong(r106);     // Catch: Throwable -> L14
        r109.f513763g = r111.getLong(r107);     // Catch: Throwable -> L14
        r108.add(r109);     // Catch: Throwable -> L14
        goto L9
    L12:
        r111.close();
        r100.release();
        return r108;
    L14:
        th = move-exception;
        r111.close();
        r100.release();
        throw th;
    L5:
        r100.bindString(1, r110);
        goto L6
    }
}
