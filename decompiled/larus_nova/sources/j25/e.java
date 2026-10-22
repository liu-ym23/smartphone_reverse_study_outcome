package j25;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.document.offline.offlinestorage.OfflineDatabase;

/* JADX INFO: loaded from: classes16.dex */
public final class e extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE bitable_file_model SET attachment_token= ? WHERE _id= ?";
    }

    public e(OfflineDatabase r100) {
        super(r100);
    }
}
