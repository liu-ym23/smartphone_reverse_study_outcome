package ti3;

import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.ECShopHeadInfoBlock;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeActivityResponse;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements d {
    public final a a;

    @Override // ti3.d
    public final Observable<ECStoreHomeActivityResponse> b(ECStoreParam r1, String r2) {
        throw null;
    }

    public c() {
        this.a = new a();
    }

    @Override // ti3.d
    public final Observable<ECShopHeadInfoBlock> a(ECStoreParam r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "storeParam");
        Intrinsics.checkNotNullParameter(r4, "path");
        this.a.getClass();
        return a.g(r2, r3, r4);
    }

    public final Observable<ECStoreHomeTabResponseTabkit> c(ECStoreParam r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "storeParam");
        Intrinsics.checkNotNullParameter(r4, "path");
        this.a.getClass();
        return a.h(r2, r3, r4);
    }

    public final Observable<com.bytedance.android.chunkstreamprediction.network.b<ECStoreHomeTabResponseTabkit>> d(ECStoreParam r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "storeParam");
        Intrinsics.checkNotNullParameter(r4, "path");
        this.a.getClass();
        return a.i(r2, r3, r4);
    }
}
