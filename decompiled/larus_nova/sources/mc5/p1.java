package mc5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class p1 extends EntityInsertionAdapter<a> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `CacheStatus` (`obj_token`,`doc_cache_status`,`status_manualoffline`,`obj_type`,`download_type`) VALUES (?,?,?,?,?)";
    }

    public p1(BearDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, a r101) {
        a r102 = r101;
        String r103 = r102.f512880a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        r100.bindLong(2, r102.f512881b);
        r100.bindLong(3, r102.f512882c);
        r100.bindLong(4, r102.f512883d);
        r100.bindLong(5, r102.f512884e);
        return;
    L5:
        r100.bindString(1, r103);
        goto L6
    }
}
