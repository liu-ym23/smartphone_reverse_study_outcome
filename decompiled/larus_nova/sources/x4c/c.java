package x4c;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ss.android.lark.security.compliance.infra.storage.lru.CacheDatabase;

/* JADX INFO: loaded from: classes38.dex */
public final class c extends EntityDeletionOrUpdateAdapter<f> {
    @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM `lru_cache` WHERE `id` = ?";
    }

    public c(CacheDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter
    public final void bind(SupportSQLiteStatement r100, f r101) {
        r100.bindLong(1, r101.f562492a);
    }
}
