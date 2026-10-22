package mc5;

import androidx.lifecycle.LiveData;
import androidx.room.RoomSQLiteQuery;
import com.bytedance.ee.util.livedata.WorkerLiveData;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z2 extends WorkerLiveData<List<String>> {
    public final /* synthetic */ int b;
    public final /* synthetic */ x2 c;

    public final LiveData<List<String>> a() {
        n r0 = this.c.a().c();
        int r1 = this.b;
        d1 r2 = (d1) r0;
        r2.getClass();
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT obj_token FROM CacheStatus WHERE doc_cache_status =?", 1);
        r3.bindLong(1, r1);
        return r2.a.getInvalidationTracker().createLiveData(new String[]{"CacheStatus"}, false, new o1(r2, r3));
    }

    public z2(x2 r1) {
        this.c = r1;
        this.b = 2;
    }
}
