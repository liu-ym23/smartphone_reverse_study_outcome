package com.bytedance.ee.bear.list;

import android.text.TextUtils;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t4 {
    static {
    }

    @JvmStatic
    public static final boolean a(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(r3, ((com.bytedance.ee.bear.contract.b0) org.koin.java.a.c(com.bytedance.ee.bear.contract.b0.class, null, null, 6)).getUid()) == false) goto L7;
        return true;
    }
}
