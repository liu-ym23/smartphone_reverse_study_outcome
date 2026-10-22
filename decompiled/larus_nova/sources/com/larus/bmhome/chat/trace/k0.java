package com.larus.bmhome.chat.trace;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Object, Long> f310229a = null;

    static {
        f310229a = new ConcurrentHashMap();
    }

    public static void a(final Object r100, final Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "task");
        ConcurrentHashMap<Object, Long> r102 = f310229a;
        if (r102.size() <= 300) goto L5;
        r102.clear();
    L5:
        final long r103 = System.currentTimeMillis();
        Function0 r104 = new j0(r100, r103, r101);
        Long r105 = r102.get(r100);
        if (r105 != null) goto L8;
        r104.invoke();
        return;
    L8:
        if ((r103 - r105.longValue()) <= 500) goto L10;
        r104.invoke();
        return;
    L10:
        FLogger.f375446a.i("DistinctTaskManager", "discard task key:" + r100);
    }
}
