package com.bytedance.android.window.shop.search.datasource;

import androidx.paging.PositionalDataSource;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ec.window.base.common.param.WindowV2RequestParam;
import com.bytedance.android.ec.window.base.repository.dto.WindowSearchResultV2;
import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductListResponseDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductListResponseVO;
import com.bytedance.android.ec.window.base.repository.vo.j;
import com.bytedance.android.ec.window.base.search.datasource.WindowSearchProductListDataSource;
import com.bytedance.android.ec.window.base.shop.WindowV2Api;
import com.bytedance.android.ec.window.base.shopping.paging.WindowLoadStatus;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import jp.b;
import jp.c;
import jp.d;
import jp.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zn.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/window/shop/search/datasource/WindowSearchProductListDataSourceV2;", "Lcom/bytedance/android/ec/window/base/search/datasource/WindowSearchProductListDataSource;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowSearchProductListDataSourceV2 extends WindowSearchProductListDataSource {
    public final WindowV2RequestParam l;

    public final int k(List<? extends b> r2) {
        Intrinsics.checkNotNullParameter(r2, "productList");
        if (r2.isEmpty() == false) goto L6;
        return 0;
    L6:
        ListIterator<? extends b> r3 = r2.listIterator(r2.size());
    L8:
        if (r3.hasPrevious() == false) goto L12;
        if ((r3.previous() instanceof e) == false) goto L8;
        int r4 = r3.nextIndex();
    L14:
        return r4 + 1;
    L12:
        r4 = -1;
        goto L14
    }

    public final String h(Integer r3, Integer r4) {
        if (r3 == null) goto L22;
        if (r4 != null) goto L7;
        return "";
    L7:
        if (r3.intValue() != 0) goto L10;
        return "general";
    L10:
        if (r3.intValue() != 1) goto L13;
        return "sales";
    L13:
        if (r3.intValue() != 2) goto L16;
        return "newest";
    L16:
        if (r3.intValue() != 3) goto L19;
        return "price_ascend";
    L19:
        if (r3.intValue() != 4) goto L27;
        return "price_descend";
    L27:
        return "";
    L22:
        return "";
    }

    public final Observable<WindowV2ProductListResponseDTO> m(Long r23, long r24) {
        return Observable.just(new WindowV2ProductListResponseDTO(null, null, null, 0, false, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null));
    }

    public final void q(WindowV2ProductListResponseVO r2, PositionalDataSource.LoadRangeParams r3) {
        Intrinsics.checkNotNullParameter(r2, "response");
        Intrinsics.checkNotNullParameter(r3, "params");
        if (r2.getSearchResultHasRecommend() == true) goto L5;
        return;
    L5:
        if (r3.startPosition != 0) goto L7;
        boolean r4 = true;
    L8:
        WindowSearchProductListDataSource.o(this, r4);
        return;
    L7:
        r4 = false;
        goto L8
    }

    public final List<b> p(WindowV2ProductListResponseVO r3, List<? extends WindowV2ProductItemVO> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r4, "products");
        List<? extends WindowV2ProductItemVO> r6 = r4;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L10;
        WindowV2ProductItemVO r0 = (WindowV2ProductItemVO) r8.next();
        if ((r0 instanceof com.bytedance.android.ec.window.base.repository.vo.e) == false) goto L8;
        d r1 = new d(r0);
    L9:
        r7.add(r1);
        goto L4
    L8:
        r1 = new e(r0);
        goto L9
    L10:
        List<b> r9 = CollectionsKt.toMutableList(r7);
        if (r3.getSearchResultHasRecommend() == false) goto L24;
        ListIterator<b> r10 = r9.listIterator(r9.size());
    L14:
        if (r10.hasPrevious() == false) goto L18;
        if ((r10.previous() instanceof e) == false) goto L14;
        int r11 = r10.nextIndex();
    L19:
        int r12 = r11 + 1;
        if (r11 >= 0) goto L22;
        boolean r13 = true;
    L23:
        ListProtector.add(r9, r12, new c(r13, true));
        goto L24
    L22:
        r13 = false;
        goto L23
    L18:
        r11 = -1;
    L24:
        return r9;
    }

    public final Observable<WindowSearchResultV2> n(Long r17, long r18, String r20, String r21) {
        String r0 = (String) this.l.getPassThroughParam("pass_through_api");
        JsonObject r2 = new JsonObject();
        r2.addProperty("ecom_search_scene", "ecom_window_search");
        r2.addProperty("sec_author_id", this.l.getSecAuthorId());
        String r3 = this.l.getSecAuthorId();
        if (r0 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == false) goto L39;
        JsonObject r1 = new JsonObject();
    L15:
        r1.addProperty("sec_author_id", r3);
        r2.addProperty("common_search_passthrough", r1.toString());
        WindowV2Api.a.getClass();
        WindowV2Api r4 = WindowV2Api.a.b;
        if (r4 == null) goto L38;
        String r6 = this.l.getKeyWord();
        if (r6 != null) goto L20;
        r6 = "";
    L20:
        Long r7 = Long.valueOf(r18);
        String r10 = k.d(r2);
        Long r8 = this.l.getSortType();
        if (r8 == null) goto L26;
        r8.longValue();
        String r9 = (String) this.l.getIdToRequestParams().get(r8);
        if (r9 == null) goto L26;
        String r13 = r9;
    L27:
        String r11 = this.l.getLevel();
        if (r11 != null) goto L30;
        String r14 = "";
    L31:
        String r12 = this.l.getSearchId();
        if (r12 != null) goto L34;
        String r15 = "";
    L35:
        Observable<WindowSearchResultV2> r16 = r4.getProductListSearchNewPathV2("window", r6, r17, r7, "1004", "ecom_goods_shop", r10, "ecom_search_except_search_order_center_sonic_window_search", "douyin_search", r13, r14, r15);
        if (r16 == null) goto L38;
        return r16;
    L34:
        r15 = r12;
        goto L35
    L30:
        r14 = r11;
    L26:
        r13 = "";
    L38:
        return Observable.error(new Throwable("ECNetworkService not init"));
    L39:
        r1 = (JsonObject) new Gson().fromJson(r0, JsonObject.class);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r1 = new JsonObject();
        goto L15
    L5:
        if (r0.length() == 0) goto L8;
        r5 = false;
        goto L9
    }

    public WindowSearchProductListDataSourceV2(WindowV2RequestParam r2, a<List<j>> r3, a<List<com.bytedance.android.ec.window.base.repository.vo.k>> r4, QLiveData<WindowLoadStatus> r5, a<String> r6, com.bytedance.android.ec.core.async.b r7, Function1<? super WindowV2ProductListResponseVO, Unit> r8) {
        Intrinsics.checkNotNullParameter(r2, "reqParam");
        Intrinsics.checkNotNullParameter(r5, "loadStatus");
        Intrinsics.checkNotNullParameter(r7, "disposableScope");
        super(r2, r3, r4, r5, r6, r7, r8);
        this.l = r2;
    }
}
