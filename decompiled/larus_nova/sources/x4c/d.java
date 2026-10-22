package x4c;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ss.android.lark.security.compliance.infra.storage.lru.CacheDatabase;

/* JADX INFO: loaded from: classes38.dex */
public final class d extends EntityDeletionOrUpdateAdapter<f> {
    @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE OR ABORT `lru_cache` SET `id` = ?,`key` = ?,`value` = ?,`lastAccessTime` = ? WHERE `id` = ?";
    }

    public d(CacheDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter
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
        r100.bindLong(5, r102.f562492a);
        return;
    L9:
        r100.bindString(3, r104);
        goto L10
    L5:
        r100.bindString(2, r103);
        goto L6
    }
}
