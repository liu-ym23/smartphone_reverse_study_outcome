package yo;

import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.window.base.product.presenter.baseinf.EventTags;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes44.dex */
public interface f {
    Set<EventTags> a();

    void b(WindowV2ProductItemVO r100, List<ECRitTag> r101, Map<String, ? extends Object> r102);
}
