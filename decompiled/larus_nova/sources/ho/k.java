package ho;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.android.ec.window.base.db.WindowDatabase;

/* JADX INFO: loaded from: classes44.dex */
public final class k extends EntityDeletionOrUpdateAdapter<io.d> {
    @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE OR ABORT `window_layout_type` SET `user_id` = ?,`sec_author_id` = ?,`layout` = ? WHERE `user_id` = ? AND `sec_author_id` = ?";
    }

    public k(WindowDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter
    public final void bind(SupportSQLiteStatement r100, io.d r101) {
        io.d r102 = r101;
        String r103 = r102.f490656a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        String r104 = r102.f490657b;
        if (r104 != null) goto L9;
        r100.bindNull(2);
    L10:
        Integer r105 = r102.f490658c;
        if (r105 != null) goto L13;
        r100.bindNull(3);
    L14:
        String r106 = r102.f490656a;
        if (r106 != null) goto L17;
        r100.bindNull(4);
    L18:
        String r107 = r102.f490657b;
        if (r107 != null) goto L21;
        r100.bindNull(5);
        return;
    L21:
        r100.bindString(5, r107);
        return;
    L17:
        r100.bindString(4, r106);
        goto L18
    L13:
        r100.bindLong(3, r105.intValue());
        goto L14
    L9:
        r100.bindString(2, r104);
        goto L10
    L5:
        r100.bindString(1, r103);
        goto L6
    }
}
