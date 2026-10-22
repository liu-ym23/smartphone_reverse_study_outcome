package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class x0 extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE ListTypes SET is_need_wifi_download = ? WHERE obj_token =?";
    }

    public x0(BearDatabase r100) {
        super(r100);
    }
}
