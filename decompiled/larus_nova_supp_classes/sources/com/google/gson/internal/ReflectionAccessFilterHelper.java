package com.google.gson.internal;

import com.google.gson.ReflectionAccessFilter;
import com.google.gson.ReflectionAccessFilter$FilterResult;
import java.lang.reflect.AccessibleObject;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ReflectionAccessFilterHelper {
    private ReflectionAccessFilterHelper() {
    }

    private static boolean isAndroidType(String r1) {
        if (r1.startsWith("android.") == false) goto L5;
    L10:
        return true;
    L5:
        if (r1.startsWith("androidx.") == true) goto L10;
        if (isJavaType(r1) == true) goto L10;
        return false;
    }

    public static boolean isAnyPlatformType(Class<?> r1) {
        String r2 = r1.getName();
        if (isAndroidType(r2) == false) goto L5;
    L12:
        return true;
    L5:
        if (r2.startsWith("kotlin.") == true) goto L12;
        if (r2.startsWith("kotlinx.") == true) goto L12;
        if (r2.startsWith("scala.") == true) goto L12;
        return false;
    }

    private static boolean isJavaType(String r1) {
        if (r1.startsWith("java.") == false) goto L5;
    L8:
        return true;
    L5:
        if (r1.startsWith("javax.") == true) goto L8;
        return false;
    }

    public static boolean isAndroidType(Class<?> r0) {
        return isAndroidType(r0.getName());
    }

    public static boolean isJavaType(Class<?> r0) {
        return isJavaType(r0.getName());
    }

    public static boolean canAccess(AccessibleObject r1, Object r2) {
        return AccessChecker.INSTANCE.canAccess(r1, r2);
    }

    public static ReflectionAccessFilter$FilterResult getFilterResult(List<ReflectionAccessFilter> r2, Class<?> r3) {
        Iterator<ReflectionAccessFilter> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        ReflectionAccessFilter$FilterResult r0 = r4.next().check(r3);
        if (r0 == ReflectionAccessFilter$FilterResult.INDECISIVE) goto L4;
        return r0;
    L9:
        return ReflectionAccessFilter$FilterResult.ALLOW;
    }
}
