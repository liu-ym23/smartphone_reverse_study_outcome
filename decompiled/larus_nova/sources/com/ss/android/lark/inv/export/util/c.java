package com.ss.android.lark.inv.export.util;

import android.util.Pair;
import com.android.ttcjpaysdk.base.wxpay.CJPayWXPaymentService;
import java.util.HashMap;

/* JADX INFO: loaded from: classes36.dex */
public final class c {
    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    public static <K, V> HashMap<K, V> a(Pair<K, V>... r100) {
        CJPayWXPaymentService.AnonymousClass3 r101 = (HashMap<K, V>) new HashMap();
        if (r100.length == 0) goto L12;
        int r102 = r100.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L12;
        Pair<K, V> r104 = r100[r103];
        if (r104 == null) goto L11;
        r101.put(r104.first, r104.second);
    L11:
        r103 = r103 + 1;
    L12:
        return r101;
    }
}
