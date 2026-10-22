package com.larus.camera.impl.utils;

import android.graphics.Bitmap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Bitmap> f322747a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f322748b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f322749c = null;

    static {
        f322747a = new ConcurrentHashMap();
        f322748b = new ConcurrentHashMap();
        f322749c = new ConcurrentHashMap();
    }

    public static Bitmap a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return f322747a.remove(r100);
    }

    public static void b(String r100, Bitmap r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        if (r101 != null) goto L5;
        return;
    L5:
        f322747a.put(r100, r101);
    }

    public static void c(String r100, String r101) {
        boolean r102 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L19;
        if (r101 != null) goto L12;
    L15:
        if (r102 == true) goto L20;
        f322748b.put(r100, r101);
        return;
    L20:
        return;
    L12:
        if (r101.length() == 0) goto L15;
        r102 = false;
        goto L15
    L19:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
