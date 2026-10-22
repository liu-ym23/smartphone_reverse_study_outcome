package tj2;

import com.bytedance.android.ec.model.live.ECPromotionInterationData;
import com.bytedance.android.livesdk.livecommerce.base.paging.PageListLoadStatus;
import java.util.List;
import mj2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface g {
    void C(List<ECPromotionInterationData> r1, boolean r2);

    void reportTabFirstPageLoadResult(String r1, int r2);

    void updateLoadInitialStatus(h<PageListLoadStatus> r1);

    void updateLoadMoreStatus(PageListLoadStatus r1, boolean r2);

    void x(com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r1, mj2.e r2, int r3, boolean r4, String r5);
}
