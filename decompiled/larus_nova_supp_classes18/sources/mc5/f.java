package mc5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f extends EntityInsertionAdapter<FolderSortStrategy> {
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `FolderSortStrategy` (`obj_token`,`type`,`file_type`,`forbidden_file_type`,`strategy`,`is_asc`,`update_time`,`user_id`) VALUES (?,?,?,?,?,?,?,?)";
    }

    public f(BearDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r5, Object r6) {
        FolderSortStrategy r7 = (FolderSortStrategy) r6;
        String r0 = r7.a;
        if (r0 != null) goto L5;
        r5.bindNull(1);
    L6:
        r5.bindLong(2, r7.getType());
        String r1 = r7.c;
        if (r1 != null) goto L9;
        r5.bindNull(3);
    L10:
        String r2 = r7.d;
        if (r2 != null) goto L13;
        r5.bindNull(4);
    L14:
        r5.bindLong(5, r7.e);
        r5.bindLong(6, r7.f ? 1 : 0);
        String r3 = r7.g;
        if (r3 != null) goto L17;
        r5.bindNull(7);
    L18:
        String r8 = r7.h;
        if (r8 != null) goto L21;
        r5.bindNull(8);
        return;
    L21:
        r5.bindString(8, r8);
        return;
    L17:
        r5.bindString(7, r3);
        goto L18
    L13:
        r5.bindString(4, r2);
        goto L14
    L9:
        r5.bindString(3, r1);
        goto L10
    L5:
        r5.bindString(1, r0);
        goto L6
    }
}
