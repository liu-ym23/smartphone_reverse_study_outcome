package com.bytedance.android.window.shop.holder.factory;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.holder.ShopWindowEmptyHolder;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i extends a {
    public static final List<a> a = null;
    public static final i b = null;

    static {
        b = new i();
        a = CollectionsKt.listOf(new a[]{WindowProductHolderFactory.b, WindowDiscoveryHolderFactory.b, WindowVideoHolderFactory.b, WindowHotsaleHolderFactory.b, WindowDynamicHolderFactory.c, WindowHeaderHolderFactory.b});
    }

    @Override // com.bytedance.android.window.shop.holder.factory.a
    public final Map<Integer, Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>>> b() {
        List<a> r0 = a;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((a) r2.next()).b());
        goto L4
    L6:
        Iterator r3 = r1.iterator();
        if (r3.hasNext() == false) goto L15;
        Object r4 = r3.next();
    L10:
        if (r3.hasNext() == false) goto L13;
        Map r5 = (Map) r4;
        r4 = MapsKt.plus(r5, (Map) r3.next());
        goto L10
    L13:
        return (Map) r4;
    L15:
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    public i() {
    }

    @Override // com.bytedance.android.window.shop.holder.factory.a
    public final ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f> a(int r3, Fragment r4, fo.b r5) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "config");
        Iterator<T> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r1 = ((a) r0.next()).a(r3, r4, r5);
        if (r1 == null) goto L4;
        return r1;
    L9:
        return new ShopWindowEmptyHolder(new View(r4.requireContext()));
    }
}
