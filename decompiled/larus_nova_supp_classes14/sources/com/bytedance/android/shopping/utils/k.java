package com.bytedance.android.shopping.utils;

import com.bytedance.android.ec.common.api.domainselect.IDomainSelect;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k {
    public static String a() {
        int r0 = ECSdk.a;
        IDomainSelect r1 = (IDomainSelect) ECSdk.a(IDomainSelect.class);
        if (r1 == null) goto L12;
        String r2 = r1.selectedHost();
        if (r2 == null) goto L12;
        if (StringsKt.trim(r2).toString().length() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
        return r2;
    L9:
        r3 = false;
    L12:
        return "https://aweme.snssdk.com";
    }

    static {
    }
}
