package com.xiaomi.push;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes41.dex */
public class cy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static cx f463315a;

    public static File a(Context r100) {
        if (r100 != null) goto L6;
        com.xiaomi.channel.commonutils.logger.b.d("ERROR: Context cannot be null.");
        return null;
    L6:
        cx r101 = f463315a;
        if (r101 != null) goto L9;
        com.xiaomi.channel.commonutils.logger.b.d("ERROR: XMSF not configure the instance of LogAgent.");
        return null;
    L9:
        return r101.a(r100);
    }
}
