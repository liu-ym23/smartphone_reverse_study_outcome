package sm;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.store.product.presenter.baseinf.EventTags;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements f {
    public c() {
    }

    @Override // sm.f
    public final void b(StoreV2ProductItemVO r100, List<ECRitTag> r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "ritTagList");
        Intrinsics.checkNotNullParameter(r102, "eventParams");
    }

    @Override // sm.f
    public final Set<EventTags> a() {
        return new LinkedHashSet();
    }
}
