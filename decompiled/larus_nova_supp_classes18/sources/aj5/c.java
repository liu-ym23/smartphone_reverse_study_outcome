package aj5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.middleground.unbundle.cache.db.BenefitDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends EntityInsertionAdapter<a> {
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `BenefitData` (`cache_key`,`owner_id`,`source_benefit`,`update_time`) VALUES (?,?,?,?)";
    }

    public c(BenefitDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r4, Object r5) {
        a r6 = (a) r5;
        String r0 = r6.a;
        if (r0 != null) goto L5;
        r4.bindNull(1);
    L6:
        String r1 = r6.b;
        if (r1 != null) goto L9;
        r4.bindNull(2);
    L10:
        String r2 = r6.c;
        if (r2 != null) goto L13;
        r4.bindNull(3);
    L14:
        Long r7 = r6.d;
        if (r7 != null) goto L17;
        r4.bindNull(4);
        return;
    L17:
        r4.bindLong(4, r7.longValue());
        return;
    L13:
        r4.bindString(3, r2);
        goto L14
    L9:
        r4.bindString(2, r1);
        goto L10
    L5:
        r4.bindString(1, r0);
        goto L6
    }
}
