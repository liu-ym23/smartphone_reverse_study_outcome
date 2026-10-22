package com.bytedance.android.window.shop.holder.factory;

import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import com.bytedance.android.window.shop.holder.WindowExploreProductHolder;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowDiscoveryHolderFactory extends a {
    public static final Map<Integer, Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>>> a = null;
    public static final WindowDiscoveryHolderFactory b = null;

    static {
        WindowDiscoveryHolderFactory r0 = new WindowDiscoveryHolderFactory();
        b = r0;
        a = MapsKt.mapOf(TuplesKt.to(402, new WindowDiscoveryHolderFactory$windowHolderCreators$1(r0)));
    }

    public WindowDiscoveryHolderFactory() {
    }

    @Override // com.bytedance.android.window.shop.holder.factory.a
    public final Map<Integer, Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>>> b() {
        return a;
    }

    @Override // com.bytedance.android.window.shop.holder.factory.a
    public final ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f> a(int r2, Fragment r3, fo.b r4) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "config");
        if (r2 == 402) goto L6;
        return null;
    L6:
        return new WindowExploreProductHolder(r3);
    }
}
