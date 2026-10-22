package com.bytedance.ee.bear.bitable.core.usercomponent;

import com.bytedance.ee.bear.bitable.load.cache.CacheType;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f210588a = 0;

    static {
    }

    @JvmStatic
    public static final a a() {
        return (a) k.a(LarkContext.getApplication(), a.class);
    }

    @JvmStatic
    public static final com.bytedance.ee.bear.bitable.load.cache.a b(CacheType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (r100 != CacheType.MEMORY) goto L7;
        return a().b5();
    L7:
        return a().F4();
    }

    @JvmStatic
    public static final boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return a().S9().isCurrentEnable(r100);
    }

    @JvmStatic
    public static final boolean d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return a().S9().isEnable(r100);
    }
}
