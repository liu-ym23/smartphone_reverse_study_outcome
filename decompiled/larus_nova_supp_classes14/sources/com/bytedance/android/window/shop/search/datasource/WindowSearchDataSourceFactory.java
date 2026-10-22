package com.bytedance.android.window.shop.search.datasource;

import androidx.paging.DataSource;
import com.bytedance.android.ec.core.async.b;
import com.bytedance.android.ec.window.base.common.param.WindowV2RequestParam;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductListResponseVO;
import com.bytedance.android.ec.window.base.repository.vo.j;
import com.bytedance.android.ec.window.base.repository.vo.k;
import com.bytedance.android.ec.window.base.search.datasource.WindowSearchProductListDataSource;
import com.bytedance.android.ec.window.base.search.datasource.WindowSearchResultDataSourceFactory;
import com.bytedance.android.ec.window.base.shopping.paging.WindowLoadStatus;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zn.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/window/shop/search/datasource/WindowSearchDataSourceFactory;", "Lcom/bytedance/android/ec/window/base/search/datasource/WindowSearchResultDataSourceFactory;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowSearchDataSourceFactory extends WindowSearchResultDataSourceFactory {
    public final QLiveData<WindowSearchProductListDataSource> a;
    public final Lazy b;
    public final WindowV2RequestParam c;
    public final a<List<j>> d;
    public final a<List<k>> e;
    public final QLiveData<WindowLoadStatus> f;
    public final a<String> g;
    public final b h;
    public final Function1<WindowV2ProductListResponseVO, Unit> i;

    public final void a() {
        WindowSearchProductListDataSource r0 = (WindowSearchProductListDataSource) this.a.a();
        if (r0 == null) goto L6;
        r0.invalidate();
        return;
    }

    public final DataSource<Integer, jp.b> create() {
        if (((Boolean) this.b.getValue()).booleanValue() == false) goto L5;
        DataSource<Integer, jp.b> r1 = new WindowSearchProductListDataSourceV2(this.c, this.d, this.e, this.f, this.g, this.h, this.i);
    L6:
        this.a.e(r1);
        return r1;
    L5:
        r1 = new WindowSearchProductListDataSourceV1(this.c, this.d, this.e, this.f, this.g, this.h, this.i);
        goto L6
    }

    public WindowSearchDataSourceFactory(WindowV2RequestParam r2, a<List<j>> r3, a<List<k>> r4, QLiveData<WindowLoadStatus> r5, a<String> r6, b r7, Function1<? super WindowV2ProductListResponseVO, Unit> r8) {
        Intrinsics.checkNotNullParameter(r2, "reqParam");
        Intrinsics.checkNotNullParameter(r5, "loadStatus");
        Intrinsics.checkNotNullParameter(r7, "disposableScope");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.a = new QLiveData();
        this.b = LazyKt.lazy(WindowSearchDataSourceFactory$useSearchEngine$2.INSTANCE);
    }
}
