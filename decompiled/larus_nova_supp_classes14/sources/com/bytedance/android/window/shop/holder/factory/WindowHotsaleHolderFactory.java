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
public final class WindowHotsaleHolderFactory extends a {
    public static final Map<Integer, Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>>> a = null;
    public static final WindowHotsaleHolderFactory b = null;

    static {
        WindowHotsaleHolderFactory r0 = new WindowHotsaleHolderFactory();
        b = r0;
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to(303, new WindowHotsaleHolderFactory$windowHolderCreators$1(r0)), TuplesKt.to(302, new WindowHotsaleHolderFactory$windowHolderCreators$2(r0)), TuplesKt.to(301, new WindowHotsaleHolderFactory$windowHolderCreators$3(r0)), TuplesKt.to(2506, new WindowHotsaleHolderFactory$windowHolderCreators$4(r0)), TuplesKt.to(305, new WindowHotsaleHolderFactory$windowHolderCreators$5(r0)), TuplesKt.to(307, new WindowHotsaleHolderFactory$windowHolderCreators$6(r0)), TuplesKt.to(308, new WindowHotsaleHolderFactory$windowHolderCreators$7(r0)), TuplesKt.to(2505, new WindowHotsaleHolderFactory$windowHolderCreators$8(r0))});
    }

    public WindowHotsaleHolderFactory() {
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
