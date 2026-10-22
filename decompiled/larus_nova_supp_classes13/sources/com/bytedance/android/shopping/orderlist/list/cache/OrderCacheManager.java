package com.bytedance.android.shopping.orderlist.list.cache;

import android.content.Context;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.opt.ab.c;
import com.bytedance.android.ec.core.order.OrderCacheConfig;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.shopping.orderlist.common.utils.m;
import com.bytedance.android.shopping.orderlist.list.starter.OrderListParams;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderCacheManager {
    public final OrderCacheConfig a;
    public String b;
    public List<SingleOrderListCache> c;
    public Map<OrderListCacheKey, SingleOrderListCache> d;
    public final Type e;
    public final AtomicBoolean f;
    public final String g;
    public final Context h;
    public final OrderListParams i;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/shopping/orderlist/list/cache/OrderCacheManager$b", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/shopping/orderlist/list/cache/SingleOrderListCache;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b extends TypeToken<List<? extends SingleOrderListCache>> {
        public b() {
        }
    }

    static {
    }

    public static final void a(OrderCacheManager r4) {
        List<SingleOrderListCache> r0 = r4.c;
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator<T> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Object r3 = r1.next();
        r2.put(((SingleOrderListCache) r3).getCacheKey(), r3);
        goto L4
    L6:
        r4.d = r2;
        Context r5 = r4.h;
        if (r5 == null) goto L11;
        int r6 = ka3.b.a;
        ka3.b.b(r5, "IESECOrderListCacheKey", GsonProtectorUtils.toJson(u0.c(), r4.c, r4.e));
        return;
    }

    public final SingleOrderListCache b(OrderListCacheKey r5) {
        Intrinsics.checkNotNullParameter(r5, "cacheKey");
        if (c.g() == true) goto L5;
        return null;
    L5:
        SingleOrderListCache r0 = this.d.get(r5);
        if (r0 == null) goto L12;
        boolean r3 = true;
        if (r0.isValid() != true) goto L12;
        if (r0.isExpired() == true) goto L12;
    L13:
        if (r3 == true) goto L15;
        List<SingleOrderListCache> r1 = this.c;
        SingleOrderListCache r6 = this.d.get(r5);
        if (r1 == null) goto L21;
        TypeIntrinsics.asMutableCollection(r1).remove(r6);
        m.a r7 = m.a;
        m.b(new OrderCacheManager$getCacheByKey$1(this));
        return null;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L15:
        return this.d.get(r5);
    L12:
        r3 = false;
        goto L13
    }

    public final void c(final gg3.c r2) {
        if (c.g() == true) goto L5;
        return;
    L5:
        this.b = UUID.randomUUID().toString();
        m.a r0 = m.a;
        m.b(new OrderCacheManager$saveCacheAsync$1(this, r2));
    }

    public OrderCacheManager(Context r1, OrderListParams r2) {
        this.h = r1;
        this.i = r2;
        this.a = ECSettingKeys.H();
        this.b = "";
        this.c = new ArrayList();
        this.d = MapsKt.emptyMap();
        this.e = new b().getType();
        this.f = new AtomicBoolean(false);
        this.g = r.a.getCurrentUserId();
    }
}
