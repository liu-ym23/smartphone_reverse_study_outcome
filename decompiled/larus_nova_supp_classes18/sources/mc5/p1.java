package mc5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p1 extends EntityInsertionAdapter<a> {
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `CacheStatus` (`obj_token`,`doc_cache_status`,`status_manualoffline`,`obj_type`,`download_type`) VALUES (?,?,?,?,?)";
    }

    public p1(BearDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r4, Object r5) {
        a r6 = (a) r5;
        String r0 = r6.a;
        if (r0 != null) goto L5;
        r4.bindNull(1);
    L6:
        r4.bindLong(2, r6.b);
        r4.bindLong(3, r6.c);
        r4.bindLong(4, r6.d);
        r4.bindLong(5, r6.e);
        return;
    L5:
        r4.bindString(1, r0);
        goto L6
    }
}
