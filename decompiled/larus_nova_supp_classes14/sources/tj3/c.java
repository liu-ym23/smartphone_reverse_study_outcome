package tj3;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.android.shopping.store.repository.searchhistorydb.StoreSearchHistoryDatabase;
import java.util.Date;
import sj3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends EntityInsertionAdapter<h> {
    public final /* synthetic */ f a;

    public final String createQuery() {
        return "INSERT OR ABORT INTO `store_search_history`(`id`,`user_id`,`store_id`,`key_word`,`time_stamp`) VALUES (nullif(?, 0),?,?,?,?)";
    }

    public c(f r1, StoreSearchHistoryDatabase r2) {
        this.a = r1;
        super(r2);
    }

    public final void bind(SupportSQLiteStatement r4, Object r5) {
        h r6 = (h) r5;
        r4.bindLong(1, r6.a);
        String r0 = r6.b;
        if (r0 != null) goto L5;
        r4.bindNull(2);
    L6:
        String r1 = r6.c;
        if (r1 != null) goto L9;
        r4.bindNull(3);
    L10:
        String r2 = r6.d;
        if (r2 != null) goto L13;
        r4.bindNull(4);
    L14:
        a r3 = this.a.c;
        Date r7 = r6.e;
        r3.getClass();
        if (r7 == null) goto L17;
        Long r8 = Long.valueOf(r7.getTime());
    L19:
        if (r8 != null) goto L21;
        r4.bindNull(5);
        return;
    L21:
        r4.bindLong(5, r8.longValue());
        return;
    L17:
        r8 = null;
        goto L19
    L13:
        r4.bindString(4, r2);
        goto L14
    L9:
        r4.bindString(3, r1);
        goto L10
    L5:
        r4.bindString(2, r0);
        goto L6
    }
}
