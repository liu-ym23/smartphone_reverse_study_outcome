package x4c;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ss.android.lark.security.compliance.infra.storage.lru.CacheDatabase;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends EntityInsertionAdapter<f> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR ABORT INTO `lru_cache` (`id`,`key`,`value`,`lastAccessTime`) VALUES (nullif(?, 0),?,?,?)";
    }

    public b(CacheDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, f r101) {
        f r102 = r101;
        r100.bindLong(1, r102.f562492a);
        String r103 = r102.f562493b;
        if (r103 != null) goto L5;
        r100.bindNull(2);
    L6:
        String r104 = r102.f562494c;
        if (r104 != null) goto L9;
        r100.bindNull(3);
    L10:
        r100.bindLong(4, r102.f562495d);
        return;
    L9:
        r100.bindString(3, r104);
        goto L10
    L5:
        r100.bindString(2, r103);
        goto L6
    }
}
