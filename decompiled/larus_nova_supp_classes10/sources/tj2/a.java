package tj2;

import com.bytedance.android.ec.common.api.UpdateLocalViewType;
import com.bytedance.android.ec.model.live.ECPromotionInterationData;
import com.bytedance.android.livesdk.livecommerce.base.paging.PageListLoadStatus;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import java.util.List;
import mj2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface a {

    /* JADX INFO: renamed from: tj2.a$a, reason: collision with other inner class name */
    public static final class C0175a {
        public static /* synthetic */ void a(a r2, List r3, boolean r4, boolean r5, int r6) {
            boolean r1 = false;
            if ((r6 & 4) == 0) goto L6;
            r5 = false;
        L6:
            if ((r6 & 8) == 0) goto L8;
            r1 = true;
        L8:
            r2.updateInteractionData(r3, r4, r5, r1);
        }
    }

    void notifyAuthorDisconnect(boolean r1, String r2);

    void notifyListUpdateToast(String r1);

    void notifyTotalChanged(int r1);

    void onProductRefreshMsgReceived(we3.d r1);

    void optUpdateCategories(List<PromotionCategory> r1, String r2);

    void reportTabFirstPageLoadResult(String r1, int r2);

    void updateDataChangeByIds(List<String> r1, boolean r2, UpdateLocalViewType r3);

    void updateExplainPromotion(String r1, List<String> r2);

    void updateInteractionData(List<ECPromotionInterationData> r1, boolean r2, boolean r3, boolean r4);

    void updateLoadInitialStatus(h<PageListLoadStatus> r1);

    void updateLoadMoreStatus(PageListLoadStatus r1, boolean r2);

    void updatePageResponse(mj2.e r1, List<PromotionCategory> r2, int r3);

    void updatePromotionListTopData(mj2.e r1);
}
