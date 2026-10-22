package com.bytedance.android.shopping.mall.homepage.pagecard.dynamicparams;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0007j\u0002`\bH\n¢\u0006\u0002\b\t"}, d2 = {"syncApiParams", "", "apiParamsMap", "", "", "", "nativeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/android/shopping/mall/homepage/pagecard/dynamicparams/ApiDynamicParams;", "invoke"}, k = 3, mv = {1, 4, 3})
public final class DynamicParamsController$syncLocalDynamicParams$1 extends Lambda implements Function2<Map<String, ? extends Object>, ConcurrentHashMap<String, Map<String, ? extends Object>>, Unit> {
    public static final DynamicParamsController$syncLocalDynamicParams$1 INSTANCE = null;

    static {
        INSTANCE = new DynamicParamsController$syncLocalDynamicParams$1();
    }

    public DynamicParamsController$syncLocalDynamicParams$1() {
        super(2);
    }

    public final void invoke(Map<String, ? extends Object> r4, ConcurrentHashMap<String, Map<String, Object>> r5) {
        Intrinsics.checkNotNullParameter(r4, "apiParamsMap");
        Intrinsics.checkNotNullParameter(r5, "nativeMap");
        Iterator<Map.Entry<String, ? extends Object>> r6 = r4.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L11;
        Map.Entry<String, ? extends Object> r0 = r6.next();
        String r1 = r0.getKey();
        Object r2 = r0.getValue();
        if ((r2 instanceof Map) == true) goto L8;
        r2 = null;
    L8:
        Map<String, Object> r3 = (Map) r2;
        if (r3 == null) goto L4;
        r5.put(r1, r3);
        goto L4
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Map) r1, (ConcurrentHashMap) r2);
        return Unit.INSTANCE;
    }
}
