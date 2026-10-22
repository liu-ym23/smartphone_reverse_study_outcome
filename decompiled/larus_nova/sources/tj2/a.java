package tj2;

import com.bytedance.android.ec.common.api.UpdateLocalViewType;
import com.bytedance.android.ec.model.live.ECPromotionInterationData;
import com.bytedance.android.livesdk.livecommerce.base.paging.PageListLoadStatus;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import java.util.List;
import mj2.h;

/* JADX INFO: loaded from: classes10.dex */
public interface a {

    /* JADX INFO: renamed from: tj2.a$a, reason: collision with other inner class name */
    public static final class C7735a {
        public static /* synthetic */ void a(a r100, List r101, boolean r102, boolean r103, int r104) {
            boolean r105 = false;
            if ((r104 & 4) == 0) goto L6;
            r103 = false;
        L6:
            if ((r104 & 8) == 0) goto L8;
            r105 = true;
        L8:
            r100.updateInteractionData(r101, r102, r103, r105);
        }
    }

    void notifyAuthorDisconnect(boolean r100, String r101);

    void notifyListUpdateToast(String r100);

    void notifyTotalChanged(int r100);

    void onProductRefreshMsgReceived(we3.d r100);

    void optUpdateCategories(List<PromotionCategory> r100, String r101);

    void reportTabFirstPageLoadResult(String r100, int r101);

    void updateDataChangeByIds(List<String> r100, boolean r101, UpdateLocalViewType r102);

    void updateExplainPromotion(String r100, List<String> r101);

    void updateInteractionData(List<ECPromotionInterationData> r100, boolean r101, boolean r102, boolean r103);

    void updateLoadInitialStatus(h<PageListLoadStatus> r100);

    void updateLoadMoreStatus(PageListLoadStatus r100, boolean r101);

    void updatePageResponse(mj2.e r100, List<PromotionCategory> r101, int r102);

    void updatePromotionListTopData(mj2.e r100);
}
