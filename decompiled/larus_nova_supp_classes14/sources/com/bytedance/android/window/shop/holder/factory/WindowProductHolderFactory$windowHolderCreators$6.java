package com.bytedance.android.window.shop.holder.factory;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import com.bytedance.android.window.shop.holder.WindowMarginHolder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/fragment/app/Fragment;", "p1", "Lfo/b;", "p2", "Lcom/bytedance/android/window/shop/holder/WindowMarginHolder;", "invoke", "(Landroidx/fragment/app/Fragment;Lfo/b;)Lcom/bytedance/android/window/shop/holder/WindowMarginHolder;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowProductHolderFactory$windowHolderCreators$6 extends FunctionReferenceImpl implements Function2<Fragment, fo.b, WindowMarginHolder> {
    public WindowProductHolderFactory$windowHolderCreators$6(WindowProductHolderFactory r8) {
        super(2, r8, WindowProductHolderFactory.class, "createMarginHolder", "createMarginHolder(Landroidx/fragment/app/Fragment;Lcom/bytedance/android/ec/window/base/common/typeddata/WindowTypedDataCache;)Lcom/bytedance/android/window/shop/holder/WindowMarginHolder;", 0);
    }

    public final WindowMarginHolder invoke(Fragment r2, fo.b r3) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        Intrinsics.checkNotNullParameter(r3, "p2");
        WindowProductHolderFactory r4 = (WindowProductHolderFactory) ((CallableReference) this).receiver;
        Map<Integer, Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>>> r0 = WindowProductHolderFactory.a;
        r4.getClass();
        View r5 = new View(r2.requireContext());
        r5.setBackgroundResource(2131101227);
        Unit r6 = Unit.INSTANCE;
        return new WindowMarginHolder(r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Fragment) r1, (fo.b) r2);
    }
}
