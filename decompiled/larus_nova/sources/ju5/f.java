package ju5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.util.db.KeyValueDatabase;

/* JADX INFO: loaded from: classes19.dex */
public final class f extends EntityInsertionAdapter<j> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR ABORT INTO `key_value_model` (`key`,`value`) VALUES (?,?)";
    }

    public f(KeyValueDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, j r101) {
        j r102 = r101;
        String r103 = r102.f500499a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        String r104 = r102.f500500b;
        if (r104 != null) goto L9;
        r100.bindNull(2);
        return;
    L9:
        r100.bindString(2, r104);
        return;
    L5:
        r100.bindString(1, r103);
        goto L6
    }
}
