package com.bytedance.reparo.core;

import java.lang.reflect.Field;
import java.util.HashSet;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Field f267338b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f267339a;

    static {
        Field r100 = Class.class.getDeclaredField("dexCache");     // Catch: NoSuchFieldException -> L4
        f267338b = r100;     // Catch: NoSuchFieldException -> L4
        r100.setAccessible(true);     // Catch: NoSuchFieldException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public c() {
        this.f267339a = new HashSet();
    }
}
