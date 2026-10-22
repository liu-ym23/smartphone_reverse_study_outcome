package ck5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.notification.bean.Notification;
import com.bytedance.ee.bear.notification.db.NotificationDatabase;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends EntityInsertionAdapter<Notification> {
    public final /* synthetic */ h a;

    public final String createQuery() {
        return "INSERT OR REPLACE INTO `Notification` (`id`,`start_time`,`end_time`,`content`,`product`,`close`) VALUES (?,?,?,?,?,?)";
    }

    public c(h r1, NotificationDatabase r2) {
        this.a = r1;
        super(r2);
    }

    public final void bind(SupportSQLiteStatement r4, Object r5) {
        Notification r6 = (Notification) r5;
        if (r6.getId() != null) goto L5;
        r4.bindNull(1);
    L6:
        r4.bindLong(2, r6.getStart_time());
        r4.bindLong(3, r6.getEnd_time());
        a r0 = this.a.c;
        Notification.ContentBean r1 = r6.getContent();
        r0.getClass();
        String r2 = JSON.toJSONString(r1);
        if (r2 != null) goto L9;
        r4.bindNull(4);
    L10:
        a r3 = this.a.c;
        List<String> r7 = r6.getProducts();
        r3.getClass();
        String r8 = JSON.toJSONString(r7);
        if (r8 != null) goto L13;
        r4.bindNull(5);
    L14:
        r4.bindLong(6, r6.isClose() ? 1 : 0);
        return;
    L13:
        r4.bindString(5, r8);
        goto L14
    L9:
        r4.bindString(4, r2);
        goto L10
    L5:
        r4.bindString(1, r6.getId());
        goto L6
    }
}
