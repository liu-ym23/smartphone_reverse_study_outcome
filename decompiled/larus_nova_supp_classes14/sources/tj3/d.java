package tj3;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.android.shopping.store.repository.searchhistorydb.StoreSearchHistoryDatabase;
import sj3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends EntityDeletionOrUpdateAdapter<h> {
    public final String createQuery() {
        return "DELETE FROM `store_search_history` WHERE `id` = ?";
    }

    public d(StoreSearchHistoryDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r3, Object r4) {
        r3.bindLong(1, ((h) r4).a);
    }
}
