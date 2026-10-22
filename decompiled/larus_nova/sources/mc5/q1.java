package mc5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class q1 extends EntityInsertionAdapter<so5.a> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `TtsPlaybackBean` (`obj_token`,`obj_type`,`title`,`owner_name`,`icon_info`,`create_time_ms`,`update_time_ms`,`last_play_time_ms`,`duration_ms`,`progress_ms`,`speed`,`tone_id`,`tone_name`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public q1(BearDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, so5.a r101) {
        so5.a r102 = r101;
        String r103 = r102.f542715a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        r100.bindLong(2, r102.f542716b);
        String r104 = r102.f542717c;
        if (r104 != null) goto L9;
        r100.bindNull(3);
    L10:
        String r105 = r102.f542718d;
        if (r105 != null) goto L13;
        r100.bindNull(4);
    L14:
        String r106 = r102.f542719e;
        if (r106 != null) goto L17;
        r100.bindNull(5);
    L18:
        r100.bindLong(6, r102.f542720f);
        r100.bindLong(7, r102.f542721g);
        r100.bindLong(8, r102.f542722h);
        r100.bindLong(9, r102.f542723i);
        r100.bindLong(10, r102.f542724j);
        r100.bindDouble(11, r102.f542725k);
        String r107 = r102.f542726l;
        if (r107 != null) goto L21;
        r100.bindNull(12);
    L22:
        String r108 = r102.f542727m;
        if (r108 != null) goto L25;
        r100.bindNull(13);
        return;
    L25:
        r100.bindString(13, r108);
        return;
    L21:
        r100.bindString(12, r107);
        goto L22
    L17:
        r100.bindString(5, r106);
        goto L18
    L13:
        r100.bindString(4, r105);
        goto L14
    L9:
        r100.bindString(3, r104);
        goto L10
    L5:
        r100.bindString(1, r103);
        goto L6
    }
}
