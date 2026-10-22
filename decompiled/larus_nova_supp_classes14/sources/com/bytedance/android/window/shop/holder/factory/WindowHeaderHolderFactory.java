package com.bytedance.android.window.shop.holder.factory;

import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowHeaderHolderFactory extends a {
    public static final Map<Integer, Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>>> a = null;
    public static final WindowHeaderHolderFactory b = null;

    static {
        WindowHeaderHolderFactory r0 = new WindowHeaderHolderFactory();
        b = r0;
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to(701, new WindowHeaderHolderFactory$windowHolderCreators$1(r0)), TuplesKt.to(702, new WindowHeaderHolderFactory$windowHolderCreators$2(r0)), TuplesKt.to(704, new WindowHeaderHolderFactory$windowHolderCreators$3(r0)), TuplesKt.to(705, new WindowHeaderHolderFactory$windowHolderCreators$4(r0)), TuplesKt.to(998, new WindowHeaderHolderFactory$windowHolderCreators$5(r0)), TuplesKt.to(703, new WindowHeaderHolderFactory$windowHolderCreators$6(r0)), TuplesKt.to(999, new WindowHeaderHolderFactory$windowHolderCreators$7(r0))});
    }

    @Override // com.bytedance.android.window.shop.holder.factory.a
    public final Map<Integer, Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>>> b() {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Map.Entry<Integer, Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>>>> r1 = a.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry<Integer, Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>>> r2 = r1.next();
        int r3 = r2.getKey().intValue();
        final Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>> r4 = r2.getValue();
        r0.put(Integer.valueOf(r3), new WindowHeaderHolderFactory$getOriginWindowHolderCreators$1(r4));
        goto L4
    L6:
        return r0;
    }

    public WindowHeaderHolderFactory() {
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
