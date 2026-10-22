package bk3;

import androidx.paging.PositionalDataSource;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductListResponseVO;
import com.bytedance.android.ec.store.search.datasource.SearchProductListDataSource;
import com.bytedance.android.ec.store.search.repository.vo.SearchProductListResponseVO;
import com.bytedance.android.ec.store.shopping.paging.ListStatusPositionalLoadRangeCallback;
import com.bytedance.android.shopping.store.repository.dto.StoreV3SearchResponseExpDTO;
import com.bytedance.android.shopping.store.search.datasource.ShopSearchProductListDataSource;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ ShopSearchProductListDataSource a;
    public final /* synthetic */ ListStatusPositionalLoadRangeCallback b;

    public a(ShopSearchProductListDataSource r1, ListStatusPositionalLoadRangeCallback r2, PositionalDataSource.LoadRangeParams r3) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        StoreV3SearchResponseExpDTO r9 = (StoreV3SearchResponseExpDTO) r8;
        if (r9.getStatusCode() == 0) goto L5;
        this.b.a();
        return;
    L5:
        SearchProductListResponseVO.Companion.getClass();
        StoreV2ProductListResponseVO r0 = SearchProductListResponseVO.a.b(r9);
        ShopSearchProductListDataSource r1 = this.a;
        int r2 = ShopSearchProductListDataSource.p;
        r1.o(r9);
        ShopSearchProductListDataSource r10 = this.a;
        ListStatusPositionalLoadRangeCallback r3 = this.b;
        Function1 r4 = ((SearchProductListDataSource) r10).l;
        if (r4 == null) goto L9;
        Unit r5 = (Unit) r4.invoke(r0);
    L9:
        if (((SearchProductListDataSource) r10).e == false) goto L11;
        r3.onResult(r10.n(r0.getRecommendProducts(), true));
    L18:
        r10.o.setHasMore(r0.getHasMore());
        r10.o.setCursor(Long.valueOf(r0.getCursor()));
        return;
    L11:
        ArrayList r6 = new ArrayList();
        if ((!r0.getProducts().isEmpty()) == false) goto L15;
        r6.addAll(r10.n(r0.getProducts(), false));
    L15:
        if ((!r0.getRecommendProducts().isEmpty()) == false) goto L17;
        ((SearchProductListDataSource) r10).e = true;
        ((SearchProductListDataSource) r10).c = new en.c(false, r0.getProducts().isEmpty());
        r6.addAll(r10.n(r0.getRecommendProducts(), true));
    L17:
        r3.onResult(r6);
        goto L18
    }
}
