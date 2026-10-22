package com.bytedance.android.window.shop.holder.factory;

import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import com.bytedance.android.window.shop.holder.WindowHotsaleTitleHolder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/fragment/app/Fragment;", "p1", "Lfo/b;", "p2", "Lcom/bytedance/android/window/shop/holder/WindowHotsaleTitleHolder;", "invoke", "(Landroidx/fragment/app/Fragment;Lfo/b;)Lcom/bytedance/android/window/shop/holder/WindowHotsaleTitleHolder;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowHotsaleHolderFactory$windowHolderCreators$2 extends FunctionReferenceImpl implements Function2<Fragment, fo.b, WindowHotsaleTitleHolder> {
    public WindowHotsaleHolderFactory$windowHolderCreators$2(WindowHotsaleHolderFactory r8) {
        super(2, r8, WindowHotsaleHolderFactory.class, "createShopWindowHybridHotsaleTitleHolder", "createShopWindowHybridHotsaleTitleHolder(Landroidx/fragment/app/Fragment;Lcom/bytedance/android/ec/window/base/common/typeddata/WindowTypedDataCache;)Lcom/bytedance/android/window/shop/holder/WindowHotsaleTitleHolder;", 0);
    }

    public final WindowHotsaleTitleHolder invoke(Fragment r4, fo.b r5) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        Intrinsics.checkNotNullParameter(r5, "p2");
        WindowHotsaleHolderFactory r6 = (WindowHotsaleHolderFactory) ((CallableReference) this).receiver;
        Map<Integer, Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>>> r0 = WindowHotsaleHolderFactory.a;
        r6.getClass();
        bp.a r7 = new bp.a(r4.requireContext());
        r7.setPadding(r7.getPaddingLeft(), com.bytedance.android.shopping.extensions.b.b(16), r7.getPaddingRight(), com.bytedance.android.shopping.extensions.b.b(4));
        Unit r8 = Unit.INSTANCE;
        return new WindowHotsaleTitleHolder(r7);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Fragment) r1, (fo.b) r2);
    }
}
