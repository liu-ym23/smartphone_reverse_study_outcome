package com.bytedance.locallife.groupon.basic.utils;

import com.bytedance.android.locallife.core.service.LifeServiceManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f258790a = 0;

    static {
    }

    public static Object a(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        ConcurrentHashMap<Class<?>, Object> r101 = LifeServiceManager.f162660a;
        Intrinsics.checkNotNullParameter(r100, "clazz");
        if (LifeServiceManager.f162660a.get(r100) == null) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L10;
        return null;
    L10:
        return LifeServiceManager.b(r100);
    L5:
        r102 = false;
        goto L6
    }
}
