package org.apache.commons.lang3;

import java.io.Serializable;

/* JADX INFO: loaded from: classes42.dex */
public class ObjectUtils {
    public static final Null NULL = null;

    public static class Null implements Serializable {
        private static final long serialVersionUID = 7092611880189329093L;

        public Null() {
        }

        private Object readResolve() {
            return ObjectUtils.NULL;
        }
    }

    public static <T> T defaultIfNull(T r100, T r101) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        return r101;
    }

    static {
        NULL = new Null();
    }

    public static String identityToString(Object r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = r100.getClass().getName();
        String r102 = Integer.toHexString(System.identityHashCode(r100));
        StringBuilder r103 = new StringBuilder((r101.length() + 1) + r102.length());
        r103.append(r101);
        r103.append('@');
        r103.append(r102);
        return r103.toString();
    }

    public static boolean equals(Object r100, Object r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        if (r100 == null) goto L10;
        if (r101 != null) goto L9;
        return false;
    L9:
        return r100.equals(r101);
    L10:
        return false;
    }

    public static void identityToString(StringBuffer r100, Object r101) {
        Validate.notNull(r101, "Cannot get the toString of a null object", new Object[0]);
        String r102 = r101.getClass().getName();
        String r103 = Integer.toHexString(System.identityHashCode(r101));
        r100.ensureCapacity(((r100.length() + r102.length()) + 1) + r103.length());
        r100.append(r102);
        r100.append('@');
        r100.append(r103);
    }

    public static boolean notEqual(Object r100, Object r101) {
        return !equals(r100, r101);
    }
}
