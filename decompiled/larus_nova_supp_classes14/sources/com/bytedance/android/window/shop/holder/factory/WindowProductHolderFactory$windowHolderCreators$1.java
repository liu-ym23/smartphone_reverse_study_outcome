package com.bytedance.android.window.shop.holder.factory;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import com.bytedance.android.window.shop.holder.WindowProductEmptyNoticeHolder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/fragment/app/Fragment;", "p1", "Lfo/b;", "p2", "Lcom/bytedance/android/window/shop/holder/WindowProductEmptyNoticeHolder;", "invoke", "(Landroidx/fragment/app/Fragment;Lfo/b;)Lcom/bytedance/android/window/shop/holder/WindowProductEmptyNoticeHolder;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowProductHolderFactory$windowHolderCreators$1 extends FunctionReferenceImpl implements Function2<Fragment, fo.b, WindowProductEmptyNoticeHolder> {
    public WindowProductHolderFactory$windowHolderCreators$1(WindowProductHolderFactory r8) {
        super(2, r8, WindowProductHolderFactory.class, "createNoProductNoticeHolder", "createNoProductNoticeHolder(Landroidx/fragment/app/Fragment;Lcom/bytedance/android/ec/window/base/common/typeddata/WindowTypedDataCache;)Lcom/bytedance/android/window/shop/holder/WindowProductEmptyNoticeHolder;", 0);
    }

    public final WindowProductEmptyNoticeHolder invoke(Fragment r3, fo.b r4) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        Intrinsics.checkNotNullParameter(r4, "p2");
        WindowProductHolderFactory r5 = (WindowProductHolderFactory) ((CallableReference) this).receiver;
        Map<Integer, Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>>> r0 = WindowProductHolderFactory.a;
        r5.getClass();
        ShoppingAsyncInflater.a r6 = ShoppingAsyncInflater.e;
        Context r7 = r3.requireContext();
        r6.getClass();
        return new WindowProductEmptyNoticeHolder(com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r7), 2131560908, null, 4));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Fragment) r1, (fo.b) r2);
    }
}
