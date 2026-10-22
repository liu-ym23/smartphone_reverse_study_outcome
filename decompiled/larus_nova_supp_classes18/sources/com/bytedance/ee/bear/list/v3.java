package com.bytedance.ee.bear.list;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.util.info.AppInfoUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v3 {
    public static boolean a(NetService.f r2) {
        if (AppInfoUtils.f().booleanValue() == true) goto L6;
        return false;
    L6:
        r2.b("thumbnail_mode", "1");
        return true;
    }
}
