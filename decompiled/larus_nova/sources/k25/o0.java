package k25;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.document.offline.offlinestorage.OfflineDatabase;

/* JADX INFO: loaded from: classes16.dex */
public final class o0 extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM ResourceData";
    }

    public o0(OfflineDatabase r100) {
        super(r100);
    }
}
