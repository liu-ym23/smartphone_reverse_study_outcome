package rq2;

import com.bytedance.android.livesdk.gift.platform.core.scope.service.FastGiftRecommendService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftClientAIIntegratedService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftListPreLoadService;
import org.json.JSONObject;
import wp2.j;
import wp2.l;

/* JADX INFO: loaded from: classes11.dex */
public interface a extends dy0.a {
    boolean append(JSONObject r100);

    void bm(GiftListPreLoadService.b r100);

    void i9(JSONObject r100);

    void nf(FastGiftRecommendService.a r100);

    void pg(l r100);

    void r2(GiftClientAIIntegratedService.b r100);

    void removeFastGiftRecommendCallback();

    void removeGiftAssetDownloadCallback();

    void removeGiftAsyncSortCallback();

    void removeGiftListPreloadCallback();

    void tc(l r100);

    void triggerFastGiftAsyncSort(JSONObject r100);

    void triggerGiftAsyncSort(JSONObject r100);

    boolean yc(j r100);
}
