package com.bytedance.android.tools.superkv;

import android.os.Build;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.security.AccessController;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m {
    public static Class a;
    public static Method b;
    public static Method c;
    public static Class d;
    public static Method e;

    public static void a(MappedByteBuffer r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        r2.force();
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        AccessController.doPrivileged(new k(r2));
        return;
    L7:
        AccessController.doPrivileged(new l(r2));
    }
}
