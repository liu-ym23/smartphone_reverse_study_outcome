package ey7;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;

/* JADX INFO: loaded from: classes23.dex */
public final class a {
    public static Boolean a(Object r100) {
        if ((r100 instanceof Boolean) == false) goto L7;
        return (Boolean) r100;
    L7:
        if ((r100 instanceof String) == false) goto L16;
        String r101 = (String) r100;
        if ("true".equalsIgnoreCase(r101) == false) goto L13;
        return Boolean.TRUE;
    L13:
        if ("false".equalsIgnoreCase(r101) == true) goto L15;
        return null;
    L15:
        return Boolean.FALSE;
    L16:
        return null;
    }

    public static Double b(Object r100) {
        if ((r100 instanceof Double) == false) goto L7;
        return (Double) r100;
    L7:
        if ((r100 instanceof Number) == false) goto L11;
        return Double.valueOf(((Number) r100).doubleValue());
    L11:
        if ((r100 instanceof String) == true) goto L17;
        return null;
    L17:
        return CastDoubleProtector.valueOf((String) r100);
    L19:
        return null;
    }

    public static Integer c(Object r100) {
        if ((r100 instanceof Integer) == false) goto L7;
        return (Integer) r100;
    L7:
        if ((r100 instanceof Number) == false) goto L11;
        return Integer.valueOf(((Number) r100).intValue());
    L11:
        if ((r100 instanceof String) == true) goto L17;
        return null;
    L17:
        return Integer.valueOf((int) CastDoubleProtector.parseDouble((String) r100));
    L19:
        return null;
    }

    public static Long d(Object r100) {
        if ((r100 instanceof Long) == false) goto L7;
        return (Long) r100;
    L7:
        if ((r100 instanceof Number) == false) goto L11;
        return Long.valueOf(((Number) r100).longValue());
    L11:
        if ((r100 instanceof String) == true) goto L17;
        return null;
    L17:
        return Long.valueOf((long) CastDoubleProtector.parseDouble((String) r100));
    L19:
        return null;
    }
}
