package tj3;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.android.shopping.store.repository.searchhistorydb.StoreSearchHistoryDatabase;
import java.util.Date;
import sj3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends EntityDeletionOrUpdateAdapter<h> {
    public final /* synthetic */ f a;

    public final String createQuery() {
        return "UPDATE OR ABORT `store_search_history` SET `id` = ?,`user_id` = ?,`store_id` = ?,`key_word` = ?,`time_stamp` = ? WHERE `id` = ?";
    }

    public e(f r1, StoreSearchHistoryDatabase r2) {
        this.a = r1;
        super(r2);
    }

    public final void bind(SupportSQLiteStatement r5, Object r6) {
        h r7 = (h) r6;
        r5.bindLong(1, r7.a);
        String r0 = r7.b;
        if (r0 != null) goto L5;
        r5.bindNull(2);
    L6:
        String r1 = r7.c;
        if (r1 != null) goto L9;
        r5.bindNull(3);
    L10:
        String r2 = r7.d;
        if (r2 != null) goto L13;
        r5.bindNull(4);
    L14:
        a r3 = this.a.c;
        Date r4 = r7.e;
        r3.getClass();
        if (r4 == null) goto L17;
        Long r8 = Long.valueOf(r4.getTime());
    L19:
        if (r8 != null) goto L21;
        r5.bindNull(5);
    L22:
        r5.bindLong(6, r7.a);
        return;
    L21:
        r5.bindLong(5, r8.longValue());
        goto L22
    L17:
        r8 = null;
        goto L19
    L13:
        r5.bindString(4, r2);
        goto L14
    L9:
        r5.bindString(3, r1);
        goto L10
    L5:
        r5.bindString(2, r0);
        goto L6
    }
}
