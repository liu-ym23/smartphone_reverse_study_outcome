package r63;

import com.bytedance.android.shopping.anchorv3.matchpurchase.model.MatchPurchasePageComponentDTO;
import com.bytedance.android.shopping.anchorv3.matchpurchase.model.MatchPurchaseParams;
import com.bytedance.android.shopping.anchorv3.matchpurchase.model.SkuSelectStruct;
import com.bytedance.android.shopping.anchorv3.matchpurchase.repository.dto.MatchPurchaseDynamicResponseDTO;
import io.reactivex.Observable;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public interface a {
    void a();

    Observable<MatchPurchasePageComponentDTO> b(MatchPurchaseParams r100, int r101);

    Observable<MatchPurchaseDynamicResponseDTO> c(MatchPurchaseParams r100, List<SkuSelectStruct> r101);

    int getPageCount();
}
