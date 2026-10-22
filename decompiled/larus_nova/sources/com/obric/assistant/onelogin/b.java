package com.obric.assistant.onelogin;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f390917a = null;

    static {
        f390917a = new ConcurrentHashMap();
    }

    public static void a(int r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "tag");
        String r103 = r100 + ':' + r101;
        if (r102 == false) goto L5;
        f390917a.put(r103, Boolean.TRUE);
        return;
    L5:
        f390917a.remove(r103);
    }
}
