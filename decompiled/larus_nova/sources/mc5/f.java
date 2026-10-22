package mc5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;

/* JADX INFO: loaded from: classes18.dex */
public final class f extends EntityInsertionAdapter<FolderSortStrategy> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `FolderSortStrategy` (`obj_token`,`type`,`file_type`,`forbidden_file_type`,`strategy`,`is_asc`,`update_time`,`user_id`) VALUES (?,?,?,?,?,?,?,?)";
    }

    public f(BearDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, FolderSortStrategy r101) {
        FolderSortStrategy r102 = r101;
        String r103 = r102.f227680a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        r100.bindLong(2, r102.getType());
        String r104 = r102.f227682c;
        if (r104 != null) goto L9;
        r100.bindNull(3);
    L10:
        String r105 = r102.f227683d;
        if (r105 != null) goto L13;
        r100.bindNull(4);
    L14:
        r100.bindLong(5, r102.f227684e);
        r100.bindLong(6, r102.f227685f ? 1 : 0);
        String r106 = r102.f227686g;
        if (r106 != null) goto L17;
        r100.bindNull(7);
    L18:
        String r107 = r102.f227687h;
        if (r107 != null) goto L21;
        r100.bindNull(8);
        return;
    L21:
        r100.bindString(8, r107);
        return;
    L17:
        r100.bindString(7, r106);
        goto L18
    L13:
        r100.bindString(4, r105);
        goto L14
    L9:
        r100.bindString(3, r104);
        goto L10
    L5:
        r100.bindString(1, r103);
        goto L6
    }
}
