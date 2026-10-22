package lg7;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.sync.v2.presistence.AppDatabase;

/* JADX INFO: loaded from: classes22.dex */
public final class j extends EntityDeletionOrUpdateAdapter<mg7.d> {
    @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM `t_history_synclog` WHERE `sync_id` = ? AND `sync_cursor` = ?";
    }

    public j(AppDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter
    public final void bind(SupportSQLiteStatement r100, mg7.d r101) {
        mg7.d r102 = r101;
        String r103 = r102.f513764a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        r100.bindLong(2, r102.f513767d);
        return;
    L5:
        r100.bindString(1, r103);
        goto L6
    }
}
