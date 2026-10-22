package xq5;

import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import java.util.ArrayList;
import java.util.List;
import yq5.q;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements a {
    public b() {
    }

    @Override // xq5.a
    public final List<String> a() {
        q r100 = (q) WikiDatabase.c().d();
        r100.getClass();
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT DISTINCT space_id FROM t_wiki_relation WHERE wiki_node_type = 2", 0);
        r100.f568835a.assertNotSuspendingTransaction();
        Cursor r102 = DBUtil.query(r100.f568835a, r101, false, null);
        ArrayList r103 = new ArrayList(r102.getCount());     // Catch: Throwable -> L10
    L5:
        if (r102.moveToNext() == false) goto L8;
        r103.add(r102.getString(0));     // Catch: Throwable -> L10
        goto L5
    L8:
        r102.close();
        r101.release();
        return r103;
    L10:
        th = move-exception;
        r102.close();
        r101.release();
        throw th;
    }
}
