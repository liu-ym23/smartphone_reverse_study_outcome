package com.bytedance.sysoptimizer;

import android.graphics.Typeface;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.Origin;

/* JADX INFO: loaded from: classes22.dex */
public class TypeFaceLancet {
    public static ConcurrentHashMap cache;

    public TypeFaceLancet() {
    }

    static {
        cache = new ConcurrentHashMap();
    }

    public static Typeface createFromFile(File r100) {
        if (TypeFaceOptimizer.getSwitch() == false) goto L15;
        String r101 = r100.getPath();
        if (r101 == null) goto L15;
        if (cache.contains(r101) == true) goto L9;
        Typeface r102 = (Typeface) Origin.call();
        if (r102 == null) goto L15;
        cache.put(r101, r102);
        return r102;
    L9:
        return (Typeface) cache.get(r101);
    L15:
        return (Typeface) Origin.call();
    }

    public static Typeface createFromFile(String r100) {
        if (TypeFaceOptimizer.getSwitch() == false) goto L14;
        if (r100 == null) goto L14;
        if (cache.contains(r100) == true) goto L8;
        Typeface r101 = (Typeface) Origin.call();
        if (r101 == null) goto L14;
        cache.put(r100, r101);
        return r101;
    L8:
        return (Typeface) cache.get(r100);
    L14:
        return (Typeface) Origin.call();
    }
}
