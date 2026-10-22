package tj3;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.android.shopping.store.repository.searchhistorydb.StoreSearchHistoryDatabase;
import sj3.h;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends EntityDeletionOrUpdateAdapter<h> {
    @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM `store_search_history` WHERE `id` = ?";
    }

    public d(StoreSearchHistoryDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter
    public final void bind(SupportSQLiteStatement r100, h r101) {
        r100.bindLong(1, r101.f542279a);
    }
}
