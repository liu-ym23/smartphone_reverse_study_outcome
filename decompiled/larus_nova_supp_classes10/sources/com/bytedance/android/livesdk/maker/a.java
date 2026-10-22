package com.bytedance.android.livesdk.maker;

import com.bytedance.android.livesdk.config.r51;
import com.bytedance.android.livesdk.config.w70;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final HonorStreamKit a = null;
    public static final r51 b = null;

    public a() {
    }

    static {
        r51 r0 = (r51) w70.a.getValue();
        b = r0;
        if (r0.a() == false) goto L6;
        a = new HonorStreamKit();
        return;
    }
}
