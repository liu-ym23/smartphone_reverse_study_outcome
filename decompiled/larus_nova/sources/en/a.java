package en;

import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.search.recyclerview.vo.SearchResultItemType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public class a extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StoreV2ProductItemVO f473138b;

    public a(SearchResultItemType r100, StoreV2ProductItemVO r101) {
        Intrinsics.checkNotNullParameter(r100, "itemType");
        Intrinsics.checkNotNullParameter(r101, "storeV2ProductItemVO");
        super(r100);
        this.f473138b = r101;
    }
}
