package com.bytedance.reparo.core;

import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public class PatchInvokeSuperHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Class> f267314a = null;

    public PatchInvokeSuperHelper() {
    }

    static {
        f267314a = new HashMap();
        new HashMap();
    }

    public static boolean a(Class r100, Class r101) {
        if (r100 != null) goto L19;
        return false;
    L19:
        Field r102 = r100.getClass().getDeclaredField("superClass");     // Catch: NoSuchFieldException -> L7
    L9:
        if (r102 != null) goto L11;
        return false;
    L11:
        r102.setAccessible(true);
        r102.set(r100, r101);     // Catch: Exception -> L14
        return true;
    L14:
        e = move-exception;
        b97.a.c("replaceSuperClassForReflectionInvoke: ".concat(r100.getName()), e);
        return false;
    L7:
        e = move-exception;
        b97.a.c("replaceSuperClassForReflectionInvoke: ".concat(r100.getName()), e);
        r102 = null;
        goto L9
    }

    public static boolean replaceSuperClassForReflectionInvoke(String r100, Class r101) {
        if (n.h() == true) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L9;
        return false;
    L9:
        if (TextUtils.isEmpty(r100) == false) goto L11;
        return false;
    L11:
        Map<String, Class> r102 = f267314a;
        if (((HashMap) r102).containsKey(r100) == true) goto L14;
        return false;
    L14:
        Class r103 = (Class) ((HashMap) r102).get(r100);
        if (r103 != null) goto L18;
        return false;
    L18:
        return a(r103, r101);
    }
}
