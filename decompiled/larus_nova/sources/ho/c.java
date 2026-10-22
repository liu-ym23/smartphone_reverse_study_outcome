package ho;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.android.ec.window.base.db.WindowDatabase;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends EntityDeletionOrUpdateAdapter<io.b> {
    @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE OR ABORT `window_dynamic_layout` SET `layout_name` = ?,`version` = ?,`layout` = ? WHERE `layout_name` = ?";
    }

    public c(WindowDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter
    public final void bind(SupportSQLiteStatement r100, io.b r101) {
        io.b r102 = r101;
        String r103 = r102.f490649a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        String r104 = r102.f490650b;
        if (r104 != null) goto L9;
        r100.bindNull(2);
    L10:
        String r105 = r102.f490651c;
        if (r105 != null) goto L13;
        r100.bindNull(3);
    L14:
        String r106 = r102.f490649a;
        if (r106 != null) goto L17;
        r100.bindNull(4);
        return;
    L17:
        r100.bindString(4, r106);
        return;
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
