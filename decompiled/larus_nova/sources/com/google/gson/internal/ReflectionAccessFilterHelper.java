package com.google.gson.internal;

import com.google.gson.ReflectionAccessFilter;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ReflectionAccessFilterHelper {

    /* JADX INFO: renamed from: com.google.gson.internal.ReflectionAccessFilterHelper$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes23.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class AccessChecker {
        public static final AccessChecker INSTANCE = null;

        private AccessChecker() {
        }

        public abstract boolean canAccess(AccessibleObject r100, Object r101);

        static {
            if (JavaVersion.isJava9OrLater() == true) goto L12;
        L6:
            AccessChecker r100 = null;
        L7:
            if (r100 != null) goto L9;
            r100 = new AnonymousClass2();
        L9:
            INSTANCE = r100;
            return;
        L12:
            final Method r101 = AccessibleObject.class.getDeclaredMethod("canAccess", new Class[]{Object.class});     // Catch: NoSuchMethodException -> L11
            r100 = new AnonymousClass1(r101);     // Catch: NoSuchMethodException -> L11
            goto L7
        }

        public /* synthetic */ AccessChecker(AnonymousClass1 r100) {
            this();
        }
    }

    private ReflectionAccessFilterHelper() {
    }

    private static boolean isAndroidType(String r100) {
        if (r100.startsWith("android.") == false) goto L5;
    L10:
        return true;
    L5:
        if (r100.startsWith("androidx.") == true) goto L10;
        if (isJavaType(r100) == true) goto L10;
        return false;
    }

    public static boolean isAnyPlatformType(Class<?> r100) {
        String r101 = r100.getName();
        if (isAndroidType(r101) == false) goto L5;
    L12:
        return true;
    L5:
        if (r101.startsWith("kotlin.") == true) goto L12;
        if (r101.startsWith("kotlinx.") == true) goto L12;
        if (r101.startsWith("scala.") == true) goto L12;
        return false;
    }

    private static boolean isJavaType(String r100) {
        if (r100.startsWith("java.") == false) goto L5;
    L8:
        return true;
    L5:
        if (r100.startsWith("javax.") == true) goto L8;
        return false;
    }

    public static boolean isAndroidType(Class<?> r100) {
        return isAndroidType(r100.getName());
    }

    public static boolean isJavaType(Class<?> r100) {
        return isJavaType(r100.getName());
    }

    public static boolean canAccess(AccessibleObject r100, Object r101) {
        return AccessChecker.INSTANCE.canAccess(r100, r101);
    }

    public static ReflectionAccessFilter.FilterResult getFilterResult(List<ReflectionAccessFilter> r100, Class<?> r101) {
        Iterator<ReflectionAccessFilter> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        ReflectionAccessFilter.FilterResult r103 = r102.next().check(r101);
        if (r103 == ReflectionAccessFilter.FilterResult.INDECISIVE) goto L4;
        return r103;
    L9:
        return ReflectionAccessFilter.FilterResult.ALLOW;
    }
}
