package com.bytedance.express.util;

import android.os.SystemClock;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
public final class ThreadTimeUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class<SystemClock> f243209a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f243210b = null;

    static {
        f243209a = SystemClock.class;
        f243210b = LazyKt.lazy(ThreadTimeUtil$method$2.INSTANCE);
    }

    @JvmStatic
    public static final long a() {
        Method r100 = (Method) f243210b.getValue();     // Catch: Throwable -> L15
        Object r101 = null;
        if (r100 == null) goto L6;
        Object r102 = r100.invoke(null, new Object[0]);     // Catch: Throwable -> L15
    L8:
        if ((r102 instanceof Long) == false) goto L11;
        r101 = r102;
    L11:
        Long r103 = (Long) r101;     // Catch: Throwable -> L15
        if (r103 == null) goto L18;
        return r103.longValue();
    L18:
        return 0;
    L6:
        r102 = null;
    L19:
        return 0;
    }
}
