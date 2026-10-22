package com.bytedance.android.shopping.store.home.entity;

import com.google.gson.Gson;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m {
    public static final ECShopCartInfo a(l r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$getCartInfo");
        Blcok r5 = r4.f;     // Catch: Exception -> L19
        if (r5 == null) goto L18;
        List<Module> r6 = r5.getModuleList();     // Catch: Exception -> L19
        if (r6 == null) goto L18;
        Iterator<T> r7 = r6.iterator();     // Catch: Exception -> L19
    L9:
        if (r7.hasNext() == false) goto L13;
        Object r1 = r7.next();     // Catch: Exception -> L19
        if (Intrinsics.areEqual(((Module) r1).getName(), ECShopModuleType.SHOPCARTINFO.getType()) == false) goto L9;
    L14:
        Module r2 = (Module) r1;     // Catch: Exception -> L19
        if (r2 == null) goto L18;
        return (ECShopCartInfo) new Gson().fromJson(r2.getData(), ECShopCartInfo.class);
    L13:
        r1 = null;
    L18:
        return null;
    }
}
