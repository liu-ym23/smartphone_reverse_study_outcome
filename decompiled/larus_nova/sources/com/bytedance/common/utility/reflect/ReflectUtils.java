package com.bytedance.common.utility.reflect;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes15.dex */
public final class ReflectUtils {
    public static Method getMethod(Class<?> r100, String r101, Class<?>[] r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (StringUtils.isEmpty(r101) == true) goto L19;
        Logger.d("ReflectUtils", "thread id : " + ThreadMethodProxy.currentThread().getName());     // Catch: Throwable -> L9
        return r100.getMethod(r101, r102);
    L9:
        th = move-exception;
        Logger.e("ReflectUtils", "exception in getMethod, pkg : " + r100.getName() + ", function : " + r101 + ", " + th.toString());
        return r100.getDeclaredMethod(r101, r102);
    L21:
        return null;
    L19:
        return null;
    }
}
