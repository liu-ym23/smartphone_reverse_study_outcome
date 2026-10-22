package mc5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q1 extends EntityInsertionAdapter<so5.a> {
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `TtsPlaybackBean` (`obj_token`,`obj_type`,`title`,`owner_name`,`icon_info`,`create_time_ms`,`update_time_ms`,`last_play_time_ms`,`duration_ms`,`progress_ms`,`speed`,`tone_id`,`tone_name`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public q1(BearDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r4, Object r5) {
        so5.a r6 = (so5.a) r5;
        String r0 = r6.a;
        if (r0 != null) goto L5;
        r4.bindNull(1);
    L6:
        r4.bindLong(2, r6.b);
        String r1 = r6.c;
        if (r1 != null) goto L9;
        r4.bindNull(3);
    L10:
        String r2 = r6.d;
        if (r2 != null) goto L13;
        r4.bindNull(4);
    L14:
        String r3 = r6.e;
        if (r3 != null) goto L17;
        r4.bindNull(5);
    L18:
        r4.bindLong(6, r6.f);
        r4.bindLong(7, r6.g);
        r4.bindLong(8, r6.h);
        r4.bindLong(9, r6.i);
        r4.bindLong(10, r6.j);
        r4.bindDouble(11, r6.k);
        String r7 = r6.l;
        if (r7 != null) goto L21;
        r4.bindNull(12);
    L22:
        String r8 = r6.m;
        if (r8 != null) goto L25;
        r4.bindNull(13);
        return;
    L25:
        r4.bindString(13, r8);
        return;
    L21:
        r4.bindString(12, r7);
        goto L22
    L17:
        r4.bindString(5, r3);
        goto L18
    L13:
        r4.bindString(4, r2);
        goto L14
    L9:
        r4.bindString(3, r1);
        goto L10
    L5:
        r4.bindString(1, r0);
        goto L6
    }
}
