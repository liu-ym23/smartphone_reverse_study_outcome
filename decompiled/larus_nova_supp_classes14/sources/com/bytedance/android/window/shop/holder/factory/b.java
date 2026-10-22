package com.bytedance.android.window.shop.holder.factory;

import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import com.bytedance.android.window.shop.holder.WindowGroupHolder;
import com.bytedance.android.window.shop.holder.WindowLynxHolder;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static WindowGroupHolder a(Fragment r2, int r3, fo.b r4, Function2 r5) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "callback");
        ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Integer>> r0 = c.a;
        int r1 = com.bytedance.android.window.shop.b.a;
        Pair<Integer, Integer> r6 = c.b.get(Integer.valueOf(r3 & (-1073741825)));
        if (r6 != null) goto L5;
        r6 = c.c;
    L5:
        int r7 = ((Number) r6.component1()).intValue();
        int r8 = ((Number) r6.component2()).intValue() & (-1073741825);
        return new WindowGroupHolder(b(r2, r7 & (-1073741825), r4, r5), b(r2, r8, r4, r5));
    }

    public static ShopWindowItemHolder b(Fragment r2, int r3, fo.b r4, Function2 r5) {
        IntRange r0 = c.d;
        int r1 = com.bytedance.android.window.shop.b.a;
        if (r0.contains((-1073741825) & r3) == false) goto L7;
        return a(r2, r3, r4, r5);
    L7:
        if (com.bytedance.android.window.shop.repository.tab.datasource.mapping.g.a(r3) == false) goto L10;
        int r6 = h.a;
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r5, "callback");
        return new WindowLynxHolder(r2, r5, false);
    L10:
        return i.b.a(r3, r2, r4);
    }
}
