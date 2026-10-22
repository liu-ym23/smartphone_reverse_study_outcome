package com.bytedance.ug.sdk.luckycat.impl.manager;

import android.content.Context;

/* JADX INFO: loaded from: classes22.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile d0 f271316a;

    public d0(Context r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        com.bytedance.ug.sdk.luckycat.impl.utils.u.b(r100.getApplicationContext(), "luckycat_product_configs.prefs").c("init_settings", "");
    }
}
