package sm;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.store.product.presenter.baseinf.EventTags;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements e {
    public b() {
    }

    @Override // sm.e
    public final void a(StoreV2ProductItemVO r100, List<ECRitTag> r101, Map<String, ? extends Object> r102, List<String> r103, List<? extends Map<String, String>> r104, EventTags r105) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "ritTagList");
        Intrinsics.checkNotNullParameter(r102, "eventParams");
        Intrinsics.checkNotNullParameter(r103, "tagCodeList");
        Intrinsics.checkNotNullParameter(r104, "highlightTagCode");
        Intrinsics.checkNotNullParameter(r105, "tag");
    }
}
