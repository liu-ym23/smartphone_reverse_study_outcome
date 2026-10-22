package com.larus.bmhome.utils;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class w2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Integer> f315144a = null;

    static {
        f315144a = new ConcurrentHashMap();
    }

    public static int a(String r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        Integer r101 = f315144a.get(r100);
        if (r101 != null) goto L8;
        return 0;
    L8:
        return r101.intValue();
    }

    public static void b(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parentMessageId");
        FLogger.f375446a.i("MultiContentSelectManager", "updateSelectIndex: " + r100 + " to " + r101);
        if (a(r100) == r101) goto L10;
        dh8.b.f468639a.getClass();
        Intrinsics.checkNotNullParameter(r100, "parentMessageId");
        if (dh8.b.f468640b == null) goto L10;
        if (StringsKt.isBlank(r100) == true) goto L10;
        dh8.b.f468645g.add(r100 + "#sub:" + r101);
    L10:
        f315144a.put(r100, Integer.valueOf(r101));
    }
}
