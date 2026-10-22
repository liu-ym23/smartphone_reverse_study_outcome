package sm;

import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.store.product.presenter.baseinf.EventTags;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes44.dex */
public interface f {
    Set<EventTags> a();

    void b(StoreV2ProductItemVO r100, List<ECRitTag> r101, Map<String, ? extends Object> r102);
}
