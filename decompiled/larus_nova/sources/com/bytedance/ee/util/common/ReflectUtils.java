package com.bytedance.ee.util.common;

import com.bytedance.ee.bear.edit.component.toolbar2.c0;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import tb5.i;

/* JADX INFO: loaded from: classes19.dex */
public final class ReflectUtils {

    public static class ReflectException extends RuntimeException {
        private static final long serialVersionUID = 858774075258496016L;

        public ReflectException(String r100) {
            super(r100);
        }

        public ReflectException(Throwable r100) {
            super(r100);
        }

        public ReflectException(String r100, Throwable r101) {
            super(r100, r101);
        }
    }

    public static Class a(c0 r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Type r101 = r100.getClass().getGenericSuperclass();
        if ((r101 instanceof ParameterizedType) == false) goto L16;
        if (r101 != null) goto L9;
        Type[] r102 = null;
    L10:
        if (r102 != null) goto L12;
        return null;
    L12:
        if (r102.length > 0) goto L15;
        return null;
    L15:
        return (Class) r102[0];
    L9:
        r102 = ((ParameterizedType) r101).getActualTypeArguments();
        goto L10
    L16:
        return null;
    }

    public static Class b(i r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Class<?> r101 = r100.getClass();
    L6:
        if (r101 == null) goto L12;
        if (r101.getGenericInterfaces() == null) goto L11;
        if (r101.getGenericInterfaces().length != 0) goto L12;
    L11:
        r101 = r101.getSuperclass();
    L12:
        if (r101 != null) goto L14;
        return null;
    L14:
        Type[] r102 = r101.getGenericInterfaces();
        if (r102 != null) goto L17;
    L22:
        Type[] r103 = null;
    L23:
        if (r103 != null) goto L25;
        return null;
    L25:
        if (r103.length > 0) goto L28;
        return null;
    L28:
        return (Class) r103[0];
    L17:
        if (r102.length <= 0) goto L22;
        Type r104 = r102[0];
        if ((r104 instanceof ParameterizedType) == false) goto L22;
        r103 = ((ParameterizedType) r104).getActualTypeArguments();
        goto L23
    }
}
