package ck5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.notification.db.NotificationDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM Notification ";
    }

    public d(NotificationDatabase r1) {
        super(r1);
    }
}
