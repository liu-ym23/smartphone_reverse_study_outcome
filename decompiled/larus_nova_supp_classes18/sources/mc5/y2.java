package mc5;

import androidx.lifecycle.LiveData;
import androidx.room.RoomSQLiteQuery;
import com.bytedance.ee.util.livedata.WorkerLiveData;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y2 extends WorkerLiveData<List<u1>> {
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ x2 d;

    public final LiveData<List<u1>> a() {
        n r0 = this.d.a().c();
        int r1 = this.b;
        String r2 = this.c;
        d1 r3 = (d1) r0;
        r3.getClass();
        RoomSQLiteQuery r4 = RoomSQLiteQuery.acquire("SELECT * FROM ListTypes AS LT LEFT OUTER JOIN DocMetaInfo AS DMI ON LT.obj_token = DMI.obj_token WHERE LT.list_type = ? AND subordinate_id = ?", 2);
        r4.bindLong(1, r1);
        if (r2 != null) goto L5;
        r4.bindNull(2);
    L7:
        return r3.a.getInvalidationTracker().createLiveData(new String[]{"ListTypes", "DocMetaInfo"}, false, new e1(r3, r4));
    L5:
        r4.bindString(2, r2);
        goto L7
    }

    public y2(x2 r1, String r2) {
        this.d = r1;
        this.b = 18;
        this.c = r2;
    }
}
