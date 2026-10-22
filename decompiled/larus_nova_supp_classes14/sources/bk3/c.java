package bk3;

import com.bytedance.android.ec.store.common.param.StoreV2RequestParam;
import com.bytedance.android.ec.store.monitor.ErrorDomain;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductListResponseVO;
import com.bytedance.android.ec.store.repository.vo.q;
import com.bytedance.android.ec.store.search.datasource.SearchProductListDataSource;
import com.bytedance.android.ec.store.search.repository.dto.LogPbDTO;
import com.bytedance.android.ec.store.search.repository.vo.SearchProductListResponseVO;
import com.bytedance.android.ec.store.shopping.paging.ListStatusPositionalLoadInitialCallback;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.repository.dto.StoreV3SearchResponseExpDTO;
import com.bytedance.android.shopping.store.search.datasource.ShopSearchProductListDataSource;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ ShopSearchProductListDataSource a;
    public final /* synthetic */ ListStatusPositionalLoadInitialCallback b;

    public c(ShopSearchProductListDataSource r1, ListStatusPositionalLoadInitialCallback r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r9) {
        StoreV3SearchResponseExpDTO r10 = (StoreV3SearchResponseExpDTO) r9;
        if (r10.getStatusCode() == 0) goto L5;
        ShopSearchProductListDataSource r0 = this.a;
        int r3 = SearchProductListDataSource.m;
        r0.k("0", false);
        ListStatusPositionalLoadInitialCallback r1 = this.b;
        ErrorDomain.NET.getCode();
        r10.getStatusCode();
        r10.getStatusMsg();
        r1.a();
        return;
    L5:
        Map r2 = qm.a.a;
        qm.a.a("ec_perf_duration_shop_search_result", "request_end", System.currentTimeMillis());
        SearchProductListResponseVO.Companion.getClass();
        StoreV2ProductListResponseVO r4 = SearchProductListResponseVO.a.b(r10);
        ShopSearchProductListDataSource r5 = this.a;
        int r6 = ShopSearchProductListDataSource.p;
        r5.o(r10);
        StoreV2RequestParam r7 = this.a.o;
        LogPbDTO r11 = r10.getLogPb();
        Long r8 = null;
        if (r11 == null) goto L8;
        String r12 = r11.getImprId();
    L9:
        r7.setSearchId(r12);
        if (r4.getProducts().isEmpty() == false) goto L12;
        this.a.k("0", true);
    L13:
        ShopSearchProductListDataSource r13 = this.a;
        ListStatusPositionalLoadInitialCallback r14 = this.b;
        Function1 r15 = ((SearchProductListDataSource) r13).l;
        if (r15 == null) goto L16;
        Unit r16 = (Unit) r15.invoke(r4);
    L16:
        jm.a r17 = ((SearchProductListDataSource) r13).h;
        if (r17 == null) goto L19;
        List r18 = (List) r17.getValue();
    L20:
        if (r18 != null) goto L24;
        jm.a r19 = ((SearchProductListDataSource) r13).h;
        if (r19 == null) goto L24;
        r19.c(r4.getGoodTypes());
    L24:
        jm.a r20 = ((SearchProductListDataSource) r13).i;
        if (r20 == null) goto L27;
        List r21 = (List) r20.getValue();
    L28:
        if (r21 != null) goto L33;
        jm.a r22 = ((SearchProductListDataSource) r13).i;
        if (r22 == null) goto L33;
        r22.c(r4.getSortTypes());
    L33:
        if (k.c(r4.getMaterialTitle()) == false) goto L42;
        jm.a r23 = ((SearchProductListDataSource) r13).j;
        if (r23 == null) goto L37;
        String r24 = (String) r23.getValue();
    L38:
        if (r24 != null) goto L42;
        jm.a r25 = ((SearchProductListDataSource) r13).j;
        if (r25 == null) goto L42;
        r25.c(r4.getMaterialTitle());
        goto L42
    L37:
        r24 = null;
    L42:
        ArrayList r26 = new ArrayList();
        if ((!r4.getProducts().isEmpty()) == false) goto L46;
        r26.addAll(r13.n(r4.getProducts(), false));
    L46:
        if ((!r4.getRecommendProducts().isEmpty()) == false) goto L52;
        ((SearchProductListDataSource) r13).e = true;
        if (r4.getProducts().isEmpty() == false) goto L50;
        ((SearchProductListDataSource) r13).c = new en.c(true, true);
    L51:
        r26.addAll(r13.n(r4.getRecommendProducts(), true));
        goto L52
    L50:
        ((SearchProductListDataSource) r13).c = new en.c(false, false);
    L52:
        r14.onResult(r26, 0);
        r13.o.setCursor(Long.valueOf(r4.getCursor()));
        r13.o.setHasMore(r4.getHasMore());
        StoreV2RequestParam r27 = r13.o;
        List r28 = r4.getGoodTypes();
        if (r28 == null) goto L64;
        Iterator<T> r29 = r28.iterator();
    L56:
        if (r29.hasNext() == false) goto L60;
        T r30 = r29.next();
        if (((q) r30).b == false) goto L56;
    L61:
        q r31 = (q) r30;
        if (r31 == null) goto L64;
        r8 = Long.valueOf(r31.a);
        goto L64
    L60:
        r30 = null;
    L64:
        r27.setGoodsType(r8);
        Map r32 = qm.a.a;
        qm.a.a("ec_perf_duration_shop_search_result", "render_start", System.currentTimeMillis());
        return;
    L27:
        r21 = null;
        goto L28
    L19:
        r18 = null;
        goto L20
    L12:
        this.a.k(CommentScene.COMMENTSCENE_NO_AWEME, false);
        goto L13
    L8:
        r12 = null;
        goto L9
    }
}
