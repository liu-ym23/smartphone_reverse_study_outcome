package com.bytedance.android.shopping.store.hybrid;

import com.bytedance.android.shopping.store.home.entity.ECStoreDynamicTabDTO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l {
    public static final /* synthetic */ int a = 0;

    public l() {
    }

    static {
    }

    public static void b(int r8) {
        Intrinsics.checkNotNullParameter("homepage", "tabName");
        new StoreTabConfig(-1, r8, "homepage", true, -1, null, null);
    }

    public static StoreTabConfig a(uj3.j r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "tabVO");
        int r1 = r9.hashCode();
        int r2 = r9.d;
        String r3 = r9.c();
        Integer r5 = r9.t;
        ECStoreDynamicTabDTO.Companion.getClass();
        return new StoreTabConfig(r1, r2, r3, r10, r5, ECStoreDynamicTabDTO.a.a(r9), null);
    }
}
