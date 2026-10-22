package com.lynx.tasm.utils;

import android.text.StaticLayout;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes32.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Field f384084a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Field f384085b = null;

    static {
        Field r100 = StaticLayout.class.getDeclaredField("mLines");     // Catch: Exception -> L4
        f384084a = r100;     // Catch: Exception -> L4
        r100.setAccessible(true);     // Catch: Exception -> L4
        Field r101 = StaticLayout.class.getDeclaredField("mColumns");     // Catch: Exception -> L4
        f384085b = r101;     // Catch: Exception -> L4
        r101.setAccessible(true);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
