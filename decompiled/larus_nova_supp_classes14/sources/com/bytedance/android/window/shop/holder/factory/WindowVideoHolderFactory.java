package com.bytedance.android.window.shop.holder.factory;

import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowVideoHolderFactory extends a {
    public static final Map<Integer, Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>>> a = null;
    public static final WindowVideoHolderFactory b = null;

    static {
        WindowVideoHolderFactory r0 = new WindowVideoHolderFactory();
        b = r0;
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to(201, new WindowVideoHolderFactory$windowHolderCreators$1(r0)), TuplesKt.to(202, new WindowVideoHolderFactory$windowHolderCreators$2(r0)), TuplesKt.to(203, new WindowVideoHolderFactory$windowHolderCreators$3(r0)), TuplesKt.to(204, new WindowVideoHolderFactory$windowHolderCreators$4(r0)), TuplesKt.to(205, new WindowVideoHolderFactory$windowHolderCreators$5(r0)), TuplesKt.to(206, new WindowVideoHolderFactory$windowHolderCreators$6(r0)), TuplesKt.to(207, new WindowVideoHolderFactory$windowHolderCreators$7(r0)), TuplesKt.to(208, new WindowVideoHolderFactory$windowHolderCreators$8(r0)), TuplesKt.to(209, new WindowVideoHolderFactory$windowHolderCreators$9(r0)), TuplesKt.to(210, new WindowVideoHolderFactory$windowHolderCreators$10(r0))});
    }

    public WindowVideoHolderFactory() {
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
