package com.bytedance.android.window.shop.repository.tab.datasource.impl;

import com.bytedance.android.window.shop.repository.ShopRepository;
import com.bytedance.android.window.shop.repository.api.WindowProductTabRequestParam;
import com.bytedance.android.window.shop.repository.dto.WindowHybridTabDataListResponseDTO;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0015\u0010\u0003\u001a\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lcom/bytedance/android/window/shop/repository/dto/WindowHybridTabDataListResponseDTO;", "p1", "Lcom/bytedance/android/window/shop/repository/api/WindowProductTabRequestParam;", "Lkotlin/ParameterName;", "name", "reqParam", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowTabHybridDataSource$currentFetcher$1 extends FunctionReferenceImpl implements Function1<WindowProductTabRequestParam, Observable<WindowHybridTabDataListResponseDTO>> {
    public WindowTabHybridDataSource$currentFetcher$1(ShopRepository r8) {
        super(1, r8, ShopRepository.class, "getTabBffData", "getTabBffData(Lcom/bytedance/android/window/shop/repository/api/reqparam/BasicReqParamsProvider;)Lio/reactivex/Observable;", 0);
    }

    public final Observable<WindowHybridTabDataListResponseDTO> invoke(WindowProductTabRequestParam r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        ((ShopRepository) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r2, "reqParam");
        return kq3.a.b(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((WindowProductTabRequestParam) r1);
    }
}
