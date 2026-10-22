package xq5;

import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import java.util.ArrayList;
import java.util.List;
import yq5.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements a {
    public b() {
    }

    @Override // xq5.a
    public final List<String> a() {
        q r0 = (q) WikiDatabase.c().d();
        r0.getClass();
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT DISTINCT space_id FROM t_wiki_relation WHERE wiki_node_type = 2", 0);
        r0.a.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(r0.a, r1, false, null);
        ArrayList r3 = new ArrayList(r2.getCount());     // Catch: Throwable -> L10
    L5:
        if (r2.moveToNext() == false) goto L8;
        r3.add(r2.getString(0));     // Catch: Throwable -> L10
        goto L5
    L8:
        r2.close();
        r1.release();
        return r3;
    L10:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }
}
