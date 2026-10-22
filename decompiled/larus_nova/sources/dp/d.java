package dp;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.android.ec.window.base.repository.searchhistorydb.WindowSearchHistoryDatabase;

/* JADX INFO: loaded from: classes44.dex */
public final class d extends EntityDeletionOrUpdateAdapter<cp.a> {
    @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM `store_search_history` WHERE `id` = ?";
    }

    public d(WindowSearchHistoryDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter
    public final void bind(SupportSQLiteStatement r100, cp.a r101) {
        r100.bindLong(1, r101.f464591a);
    }
}
