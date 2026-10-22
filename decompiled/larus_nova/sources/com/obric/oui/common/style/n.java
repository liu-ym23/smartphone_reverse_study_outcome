package com.obric.oui.common.style;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, Integer> f399581a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<Integer> f399582b = null;

    static {
        f399581a = new ConcurrentHashMap();
        f399582b = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static void a() {
        wma.b.a("OUISoundEffectHelper", "release");     // Catch: Exception -> L5
        f399581a.clear();     // Catch: Exception -> L5
        f399582b.clear();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        wma.b.h("OUISoundEffectHelper", Intrinsics.stringPlus("release Exception: ", e));
    }
}
