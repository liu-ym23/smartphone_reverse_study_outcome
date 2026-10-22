package tj2;

import com.bytedance.android.ec.model.live.ECPromotionInterationData;
import com.bytedance.android.livesdk.livecommerce.base.paging.PageListLoadStatus;
import java.util.List;
import mj2.h;

/* JADX INFO: loaded from: classes10.dex */
public interface g {
    void C(List<ECPromotionInterationData> r100, boolean r101);

    void reportTabFirstPageLoadResult(String r100, int r101);

    void updateLoadInitialStatus(h<PageListLoadStatus> r100);

    void updateLoadMoreStatus(PageListLoadStatus r100, boolean r101);

    void x(com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r100, mj2.e r101, int r102, boolean r103, String r104);
}
