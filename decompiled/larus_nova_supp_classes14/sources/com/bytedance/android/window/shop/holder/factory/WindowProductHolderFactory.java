package com.bytedance.android.window.shop.holder.factory;

import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import com.bytedance.android.window.shop.holder.WindowAnchorCardHolder;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowProductHolderFactory extends a {
    public static final Map<Integer, Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>>> a = null;
    public static final WindowProductHolderFactory b = null;

    static {
        WindowProductHolderFactory r0 = new WindowProductHolderFactory();
        b = r0;
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to(3003, new WindowProductHolderFactory$windowHolderCreators$1(r0)), TuplesKt.to(3004, new WindowProductHolderFactory$windowHolderCreators$2(r0)), TuplesKt.to(3002, new WindowProductHolderFactory$windowHolderCreators$3(r0)), TuplesKt.to(3005, new WindowProductHolderFactory$windowHolderCreators$4(r0)), TuplesKt.to(2508, new WindowProductHolderFactory$windowHolderCreators$5(r0)), TuplesKt.to(2507, new WindowProductHolderFactory$windowHolderCreators$6(r0)), TuplesKt.to(101, new WindowProductHolderFactory$windowHolderCreators$7(r0)), TuplesKt.to(103, new WindowProductHolderFactory$windowHolderCreators$8(r0)), TuplesKt.to(504, new WindowProductHolderFactory$windowHolderCreators$9(r0)), TuplesKt.to(505, new WindowProductHolderFactory$windowHolderCreators$10(r0)), TuplesKt.to(501, new WindowProductHolderFactory$windowHolderCreators$11(r0)), TuplesKt.to(102, new WindowProductHolderFactory$windowHolderCreators$12(r0)), TuplesKt.to(302, new WindowProductHolderFactory$windowHolderCreators$13(r0)), TuplesKt.to(402, new WindowProductHolderFactory$windowHolderCreators$14(r0)), TuplesKt.to(309, new WindowProductHolderFactory$windowHolderCreators$15(WindowAnchorCardHolder.v))});
    }

    public WindowProductHolderFactory() {
    }

    @Override // com.bytedance.android.window.shop.holder.factory.a
    public final Map<Integer, Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>>> b() {
        return a;
    }

    @Override // com.bytedance.android.window.shop.holder.factory.a
    public final ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f> a(int r2, Fragment r3, fo.b r4) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "config");
        Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>> r5 = a.get(Integer.valueOf(r2));
        if (r5 != null) goto L7;
        return null;
    L7:
        return (ShopWindowItemHolder) r5.invoke(r3, r4);
    }
}
