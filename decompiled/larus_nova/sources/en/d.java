package en;

import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.search.recyclerview.vo.SearchResultItemType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d extends a {
    public d(StoreV2ProductItemVO r100) {
        Intrinsics.checkNotNullParameter(r100, "storeV2ProductItemVO");
        super(SearchResultItemType.RECOMMENDED_RESULT, r100);
    }
}
