package g22;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.android.livesdk.i18n.db.I18nDatabase;

/* JADX INFO: loaded from: classes9.dex */
public final class g extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM translation";
    }

    public g(I18nDatabase r100) {
        super(r100);
    }
}
