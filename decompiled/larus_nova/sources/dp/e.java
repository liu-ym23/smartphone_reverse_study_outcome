package dp;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.android.ec.window.base.repository.searchhistorydb.WindowSearchHistoryDatabase;
import java.util.Date;

/* JADX INFO: loaded from: classes44.dex */
public final class e extends EntityDeletionOrUpdateAdapter<cp.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f469551a;

    @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE OR ABORT `store_search_history` SET `id` = ?,`user_id` = ?,`store_id` = ?,`key_word` = ?,`time_stamp` = ? WHERE `id` = ?";
    }

    public e(f r100, WindowSearchHistoryDatabase r101) {
        this.f469551a = r100;
        super(r101);
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter
    public final void bind(SupportSQLiteStatement r100, cp.a r101) {
        cp.a r102 = r101;
        r100.bindLong(1, r102.f464591a);
        String r103 = r102.f464592b;
        if (r103 != null) goto L5;
        r100.bindNull(2);
    L6:
        String r104 = r102.f464593c;
        if (r104 != null) goto L9;
        r100.bindNull(3);
    L10:
        String r105 = r102.f464594d;
        if (r105 != null) goto L13;
        r100.bindNull(4);
    L14:
        a r106 = this.f469551a.f469554c;
        Date r107 = r102.f464595e;
        r106.getClass();
        if (r107 == null) goto L17;
        Long r108 = Long.valueOf(r107.getTime());
    L19:
        if (r108 != null) goto L21;
        r100.bindNull(5);
    L22:
        r100.bindLong(6, r102.f464591a);
        return;
    L21:
        r100.bindLong(5, r108.longValue());
        goto L22
    L17:
        r108 = null;
        goto L19
    L13:
        r100.bindString(4, r105);
        goto L14
    L9:
        r100.bindString(3, r104);
        goto L10
    L5:
        r100.bindString(2, r103);
        goto L6
    }
}
