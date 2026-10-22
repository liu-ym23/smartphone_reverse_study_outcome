package ti3;

import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.ECShopHeadInfoBlock;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeActivityResponse;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface d {

    public static final class a {
        public static /* synthetic */ Observable a(d r2, ECStoreParam r3) {
            return r2.a(r3, 0, "/sws/home/info/");
        }
    }

    Observable<ECShopHeadInfoBlock> a(ECStoreParam r1, int r2, String r3);

    Observable<ECStoreHomeActivityResponse> b(ECStoreParam r1, String r2);
}
