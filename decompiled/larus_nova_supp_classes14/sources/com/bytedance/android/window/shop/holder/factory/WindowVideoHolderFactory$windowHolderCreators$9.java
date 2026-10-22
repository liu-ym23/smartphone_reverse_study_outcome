package com.bytedance.android.window.shop.holder.factory;

import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import com.bytedance.android.window.shop.holder.WindowPlayableExplainProductHolder;
import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u000e\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004j\u0002`\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroidx/fragment/app/Fragment;", "p1", "Lfo/b;", "p2", "Lcom/bytedance/android/window/shop/holder/ShopWindowItemHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "Lcom/bytedance/android/window/shop/holder/ShopWindowHolder;", "invoke", "(Landroidx/fragment/app/Fragment;Lfo/b;)Lcom/bytedance/android/window/shop/holder/ShopWindowItemHolder;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowVideoHolderFactory$windowHolderCreators$9 extends FunctionReferenceImpl implements Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>> {
    public WindowVideoHolderFactory$windowHolderCreators$9(WindowVideoHolderFactory r8) {
        super(2, r8, WindowVideoHolderFactory.class, "createPlayableExplainProductHolder", "createPlayableExplainProductHolder(Landroidx/fragment/app/Fragment;Lcom/bytedance/android/ec/window/base/common/typeddata/WindowTypedDataCache;)Lcom/bytedance/android/window/shop/holder/ShopWindowItemHolder;", 0);
    }

    public final ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f> invoke(Fragment r3, fo.b r4) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        Intrinsics.checkNotNullParameter(r4, "p2");
        WindowVideoHolderFactory r0 = (WindowVideoHolderFactory) ((CallableReference) this).receiver;
        Map<Integer, Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>>> r1 = WindowVideoHolderFactory.a;
        r0.getClass();
        return new WindowPlayableExplainProductHolder(r3, (WindowLayoutType) r4.a(WindowConstDef.a));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Fragment) r1, (fo.b) r2);
    }
}
