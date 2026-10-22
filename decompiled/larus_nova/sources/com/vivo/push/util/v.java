package com.vivo.push.util;

import android.os.UserHandle;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes41.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f462609a = -1;

    public static int a() {
        int r100 = f462609a;
        if (r100 == (-1)) goto L11;
        return r100;
    L11:
        Method r101 = UserHandle.class.getDeclaredMethod("myUserId", new Class[0]);     // Catch: Exception -> L8
        r101.setAccessible(true);     // Catch: Exception -> L8
        f462609a = ((Integer) r101.invoke(null, null)).intValue();     // Catch: Exception -> L8
        t.d("MultiUserManager", "getMyUserId = " + f462609a);     // Catch: Exception -> L8
        return f462609a;
    L8:
        e = move-exception;
        t.a("MultiUserManager", "getMyUserId error " + e.getMessage());
        return 0;
    }
}
