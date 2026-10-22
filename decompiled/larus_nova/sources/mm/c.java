package mm;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.android.ec.store.db.StoreDatabase;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends EntityDeletionOrUpdateAdapter<nm.a> {
    @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE OR ABORT `shop_marquee_close` SET `id` = ?,`user_id` = ?,`sec_shop_id` = ?,`date` = ?,`close_times` = ? WHERE `id` = ?";
    }

    public c(StoreDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter
    public final void bind(SupportSQLiteStatement r100, nm.a r101) {
        nm.a r102 = r101;
        r100.bindLong(1, r102.f519585a);
        String r103 = r102.f519586b;
        if (r103 != null) goto L5;
        r100.bindNull(2);
    L6:
        String r104 = r102.f519587c;
        if (r104 != null) goto L9;
        r100.bindNull(3);
    L10:
        String r105 = r102.f519588d;
        if (r105 != null) goto L13;
        r100.bindNull(4);
    L14:
        Integer r106 = r102.f519589e;
        if (r106 != null) goto L17;
        r100.bindNull(5);
    L18:
        r100.bindLong(6, r102.f519585a);
        return;
    L17:
        r100.bindLong(5, r106.intValue());
        goto L18
    L13:
        r100.bindString(4, r105);
        goto L14
    L9:
        r100.bindString(3, r104);
        goto L10
    L5:
        r100.bindString(2, r103);
        goto L6
    }
}
