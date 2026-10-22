package g22;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.android.livesdk.i18n.db.I18nDatabase;

/* JADX INFO: loaded from: classes9.dex */
public final class f extends EntityInsertionAdapter<d> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `translation` (`key`,`value`) VALUES (?,?)";
    }

    public f(I18nDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, d r101) {
        d r102 = r101;
        String r103 = r102.f479683a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        String r104 = r102.f479684b;
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
