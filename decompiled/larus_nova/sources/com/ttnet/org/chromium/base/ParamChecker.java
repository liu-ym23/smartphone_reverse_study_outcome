package com.ttnet.org.chromium.base;

import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final class ParamChecker {
    public ParamChecker() {
    }

    private static String getTypeName(Class<?> r100) {
        if (r100 != null) goto L6;
        return "null";
    L6:
        if (r100.isArray() == false) goto L10;
        return r100.getCanonicalName();
    L10:
        if (r100.isPrimitive() == false) goto L14;
        return r100.getName();
    L14:
        return r100.getCanonicalName();
    }

    private static Class<?> toWrapperClass(Class<?> r100) {
        if (r100 != null) goto L4;
        return r100;
    L4:
        if (r100.isPrimitive() == false) goto L44;
        String r101 = r100.getName();
        if (r101.equals(ItemStyle.ITEM_STYLE_DOUBLE) == false) goto L9;
        return Double.class;
    L9:
        if (r101.equals("int") == false) goto L11;
        return Integer.class;
    L11:
        if (r101.equals("byte") == false) goto L13;
        return Byte.class;
    L13:
        if (r101.equals("char") == false) goto L15;
        return Character.class;
    L15:
        if (r101.equals("long") == false) goto L17;
        return Long.class;
    L17:
        if (r101.equals("void") == false) goto L19;
        return Void.class;
    L19:
        if (r101.equals("boolean") == false) goto L21;
        return Boolean.class;
    L21:
        if (r101.equals("float") == false) goto L23;
        return Float.class;
    L23:
        if (r101.equals("short") == true) goto L25;
        return r100;
    L25:
        return Short.class;
    L44:
        return r100;
    }

    public static void check(Class<?>[] r100, Object... r101) {
        Objects.requireNonNull(r100, "parameterType should not be null");
        if (r101 != null) goto L6;
        r101 = new Object[0];
    L6:
        if (r100.length != r101.length) goto L21;
        int r102 = 0;
    L9:
        if (r102 >= r100.length) goto L19;
        Class<?> r103 = r100[r102];
        Object r104 = r101[r102];
        if (isTypeCompatible(r103, r104) == false) goto L12;
        r102 = r102 + 1;
        goto L9
    L12:
        String r105 = getTypeName(r103);
        if (r104 != null) goto L15;
        String r106 = "null";
    L17:
        throw new IllegalArgumentException(String.format("The param %d type mismatch: expected %s, actual %s", new Object[]{Integer.valueOf(r102 + 1), r105, r106}));
    L15:
        r106 = getTypeName(r104.getClass());
        goto L17
    L19:
        return;
    L21:
        throw new IllegalArgumentException(String.format("param count mismatch: expected %d, actual %d", new Object[]{Integer.valueOf(r100.length), Integer.valueOf(r101.length)}));
    }

    private static boolean isTypeCompatible(Class<?> r100, Object r101) {
        if (r101 != null) goto L6;
        return !r100.isPrimitive();
    L6:
        return toWrapperClass(r100).isAssignableFrom(toWrapperClass(r101.getClass()));
    }
}
