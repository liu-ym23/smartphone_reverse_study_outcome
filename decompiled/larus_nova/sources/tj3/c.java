package tj3;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.android.shopping.store.repository.searchhistorydb.StoreSearchHistoryDatabase;
import java.util.Date;
import sj3.h;

/* JADX INFO: loaded from: classes14.dex */
public final class c extends EntityInsertionAdapter<h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f546402a;

    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR ABORT INTO `store_search_history`(`id`,`user_id`,`store_id`,`key_word`,`time_stamp`) VALUES (nullif(?, 0),?,?,?,?)";
    }

    public c(f r100, StoreSearchHistoryDatabase r101) {
        this.f546402a = r100;
        super(r101);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, h r101) {
        h r102 = r101;
        r100.bindLong(1, r102.f542279a);
        String r103 = r102.f542280b;
        if (r103 != null) goto L5;
        r100.bindNull(2);
    L6:
        String r104 = r102.f542281c;
        if (r104 != null) goto L9;
        r100.bindNull(3);
    L10:
        String r105 = r102.f542282d;
        if (r105 != null) goto L13;
        r100.bindNull(4);
    L14:
        a r106 = this.f546402a.f546406c;
        Date r107 = r102.f542283e;
        r106.getClass();
        if (r107 == null) goto L17;
        Long r108 = Long.valueOf(r107.getTime());
    L19:
        if (r108 != null) goto L21;
        r100.bindNull(5);
        return;
    L21:
        r100.bindLong(5, r108.longValue());
        return;
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
