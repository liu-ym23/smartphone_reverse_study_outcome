package com.heytap.mcssdk.utils;

import android.os.Binder;
import android.os.UserHandle;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes23.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f276433a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f276434b = 100000;

    static {
        f276433a = "PushService";
    }

    public g() {
    }

    public static int a() {
        UserHandle r100 = Binder.getCallingUserHandle();     // Catch: Exception -> L5
        Method r101 = r100.getClass().getDeclaredMethod("getIdentifier", new Class[0]);     // Catch: Exception -> L5
        r101.setAccessible(true);     // Catch: Exception -> L5
        return ((Integer) r101.invoke(r100, new Object[0])).intValue();
    L5:
        e = move-exception;
        d.b(f276433a, "get userId exception," + e);
        return 0;
    }

    public static int a(int r100, int r101) {
        return (r101 * 100000) + (r100 % 100000);
    }
}
