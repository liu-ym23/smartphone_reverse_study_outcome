package j25;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.document.offline.offlinestorage.OfflineDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends SharedSQLiteStatement {
    public final String createQuery() {
        return "UPDATE bitable_file_model SET upload_task_key= ? WHERE _id= ?";
    }

    public d(OfflineDatabase r1) {
        super(r1);
    }
}
