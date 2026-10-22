package j25;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.document.offline.offlinestorage.OfflineDatabase;

/* JADX INFO: loaded from: classes16.dex */
public final class d extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE bitable_file_model SET upload_task_key= ? WHERE _id= ?";
    }

    public d(OfflineDatabase r100) {
        super(r100);
    }
}
