package com.bytedance.android.shopping.utils;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i {
    public static final boolean a = false;

    static {
        if (ECSettingKeys.s0() != 2) goto L5;
    L8:
        boolean r0 = true;
    L9:
        a = r0;
        return;
    L5:
        if (ECSettingKeys.s0() == 3) goto L8;
        r0 = false;
        goto L9
    }

    public static boolean a() {
        if (ECSettingKeys.s0() != 2) goto L5;
    L8:
        return true;
    L5:
        if (ECSettingKeys.s0() == 3) goto L8;
        return false;
    }
}
