package com.xiaomi.push;

import android.system.Os;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: classes41.dex */
public class bz {
    public static long a(String r100) {
    L7:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        return 0;
    L4:
        if (new PolarisFileWrapper(r100).exists() == false) goto L12;
        return Os.stat(r100).st_size;
    L12:
        return 0;
    }
}
