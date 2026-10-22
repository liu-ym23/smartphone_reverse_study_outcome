package l79;

import androidx.room.SharedSQLiteStatement;
import com.larus.drive.biz.impl.database.DriveDatabase;

/* JADX INFO: loaded from: classes27.dex */
public final class j extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM drive_list_recent";
    }

    public j(DriveDatabase r100) {
        super(r100);
    }
}
