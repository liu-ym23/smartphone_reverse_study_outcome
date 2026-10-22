package com.bytedance.android.window.shop.holder.factory;

import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import com.bytedance.android.window.shop.holder.WindowDynamicHolder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowDynamicHolderFactory extends a {
    public static final Lazy a = null;
    public static final Map<Integer, Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>>> b = null;
    public static final WindowDynamicHolderFactory c = null;

    static {
        c = new WindowDynamicHolderFactory();
        Lazy r0 = LazyKt.lazy(WindowDynamicHolderFactory$currentEnabledDynamicTypes$2.INSTANCE);
        a = r0;
        List r1 = (List) r0.getValue();
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r1, 10)), 16));
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Object r4 = r3.next();
        ((Number) r4).intValue();
        r2.put(r4, new WindowDynamicHolderFactory$windowHolderCreators$1$1(c));
        goto L4
    L6:
        b = r2;
    }

    public WindowDynamicHolderFactory() {
    }

    @Override // com.bytedance.android.window.shop.holder.factory.a
    public final Map<Integer, Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>>> b() {
        return b;
    }

    @Override // com.bytedance.android.window.shop.holder.factory.a
    public final ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f> a(int r2, Fragment r3, fo.b r4) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "config");
        if (((List) a.getValue()).contains(Integer.valueOf(r2)) == true) goto L7;
        return null;
    L7:
        return new WindowDynamicHolder(r3);
    }
}
