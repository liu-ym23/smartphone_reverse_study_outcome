package com.bytedance.android.window.shop.search.datasource;

import com.bytedance.android.ec.core.async.b;
import com.bytedance.android.ec.window.base.common.param.WindowV2RequestParam;
import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductListResponseDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductListResponseVO;
import com.bytedance.android.ec.window.base.repository.vo.j;
import com.bytedance.android.ec.window.base.repository.vo.k;
import com.bytedance.android.ec.window.base.search.datasource.WindowSearchProductListDataSource;
import com.bytedance.android.ec.window.base.shop.WindowV2Api;
import com.bytedance.android.ec.window.base.shopping.paging.WindowLoadStatus;
import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import fo.a;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/window/shop/search/datasource/WindowSearchProductListDataSourceV1;", "Lcom/bytedance/android/ec/window/base/search/datasource/WindowSearchProductListDataSource;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowSearchProductListDataSourceV1 extends WindowSearchProductListDataSource {
    public final WindowV2RequestParam l;

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

    public final Observable<WindowV2ProductListResponseDTO> m(Long r22, long r23) {
        a<WindowLayoutType> r1 = WindowConstDef.a;
        Observable<WindowV2ProductListResponseDTO> r3 = null;
        if (WindowConstDef.u == false) goto L7;
        WindowV2Api.a.getClass();
        WindowV2Api r4 = WindowV2Api.a.b;
        if (r4 == null) goto L10;
        r3 = r4.getProductListSearchNewPath(this.l.getSecAuthorId(), this.l.getMaterialId(), this.l.getGoodsType(), this.l.getSortType(), this.l.getKeyWord(), r22, r23, this.l.getTmpId(), this.l.getToken(), Boolean.valueOf(this.l.isCustom()), "search", (String) this.l.getPassThroughParam("pass_through_api"), this.l.getCustomIds(), this.l.getCustomIdType(), this.l.getFilterProductIds());
    L10:
        if (r3 == null) goto L12;
        return r3;
    L12:
        return Observable.error(new Throwable("ECNetworkService not init"));
    L7:
        WindowV2Api.a.getClass();
        WindowV2Api r5 = WindowV2Api.a.a;
        if (r5 == null) goto L10;
        r3 = r5.getProductListSearchExp(this.l.getSecAuthorId(), this.l.getMaterialId(), this.l.getGoodsType(), this.l.getSortType(), this.l.getKeyWord(), r22, r23, this.l.getTmpId(), this.l.getToken(), Boolean.valueOf(this.l.isCustom()), "search", (String) this.l.getPassThroughParam("pass_through_api"), this.l.getCustomIds(), this.l.getCustomIdType(), this.l.getFilterProductIds());
        goto L10
    }

    public final Observable<WindowV2ProductListResponseDTO> n(Long r22, long r23, String r25, String r26) {
        a<WindowLayoutType> r1 = WindowConstDef.a;
        Observable<WindowV2ProductListResponseDTO> r3 = null;
        if (WindowConstDef.u == false) goto L7;
        WindowV2Api.a.getClass();
        WindowV2Api r4 = WindowV2Api.a.b;
        if (r4 == null) goto L10;
        r3 = r4.getProductListSearchNewPath(this.l.getSecAuthorId(), this.l.getMaterialId(), this.l.getGoodsType(), this.l.getSortType(), this.l.getKeyWord(), r22, r23, this.l.getTmpId(), this.l.getToken(), Boolean.valueOf(this.l.isCustom()), "search", (String) this.l.getPassThroughParam("pass_through_api"), this.l.getCustomIds(), this.l.getCustomIdType(), null);
    L10:
        if (r3 == null) goto L12;
        return r3;
    L12:
        return Observable.error(new Throwable("ECNetworkService not init"));
    L7:
        WindowV2Api.a.getClass();
        WindowV2Api r5 = WindowV2Api.a.a;
        if (r5 == null) goto L10;
        r3 = r5.getProductListSearchExp(this.l.getSecAuthorId(), this.l.getMaterialId(), this.l.getGoodsType(), this.l.getSortType(), this.l.getKeyWord(), r22, r23, this.l.getTmpId(), this.l.getToken(), Boolean.valueOf(this.l.isCustom()), "search", (String) this.l.getPassThroughParam("pass_through_api"), this.l.getCustomIds(), this.l.getCustomIdType(), null);
        goto L10
    }

    public WindowSearchProductListDataSourceV1(WindowV2RequestParam r2, zn.a<List<j>> r3, zn.a<List<k>> r4, QLiveData<WindowLoadStatus> r5, zn.a<String> r6, b r7, Function1<? super WindowV2ProductListResponseVO, Unit> r8) {
        Intrinsics.checkNotNullParameter(r2, "reqParam");
        Intrinsics.checkNotNullParameter(r5, "loadStatus");
        Intrinsics.checkNotNullParameter(r7, "disposableScope");
        super(r2, r3, r4, r5, r6, r7, r8);
        this.l = r2;
    }
}
