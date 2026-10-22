package com.ss.ugc.live.sdk.msg.dispatch;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<Long> f458278a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Long, Map<String, xlc.b>> f458279b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Long, Map<String, tlc.c>> f458280c = null;

    static {
        f458278a = new CopyOnWriteArraySet();
        f458279b = new ConcurrentHashMap();
        f458280c = new ConcurrentHashMap();
    }

    public static String a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return r100;
    L12:
        return r100 + "_" + r101;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
