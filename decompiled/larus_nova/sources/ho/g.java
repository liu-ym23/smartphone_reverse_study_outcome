package ho;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.android.ec.window.base.db.WindowDatabase;

/* JADX INFO: loaded from: classes44.dex */
public final class g extends EntityDeletionOrUpdateAdapter<io.c> {
    @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE OR ABORT `window_exit_interceptor` SET `user_id` = ?,`sec_author_id` = ?,`component_name` = ?,`show_time` = ? WHERE `user_id` = ? AND `sec_author_id` = ? AND `component_name` = ?";
    }

    public g(WindowDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter
    public final void bind(SupportSQLiteStatement r100, io.c r101) {
        io.c r102 = r101;
        String r103 = r102.f490652a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        String r104 = r102.f490653b;
        if (r104 != null) goto L9;
        r100.bindNull(2);
    L10:
        String r105 = r102.f490654c;
        if (r105 != null) goto L13;
        r100.bindNull(3);
    L14:
        r100.bindLong(4, r102.f490655d);
        String r106 = r102.f490652a;
        if (r106 != null) goto L17;
        r100.bindNull(5);
    L18:
        String r107 = r102.f490653b;
        if (r107 != null) goto L21;
        r100.bindNull(6);
    L22:
        String r108 = r102.f490654c;
        if (r108 != null) goto L25;
        r100.bindNull(7);
        return;
    L25:
        r100.bindString(7, r108);
        return;
    L21:
        r100.bindString(6, r107);
        goto L22
    L17:
        r100.bindString(5, r106);
        goto L18
    L13:
        r100.bindString(3, r105);
        goto L14
    L9:
        r100.bindString(2, r104);
        goto L10
    L5:
        r100.bindString(1, r103);
        goto L6
    }
}
