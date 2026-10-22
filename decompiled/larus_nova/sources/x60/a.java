package x60;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class a {
    public static boolean a(Object r100, boolean r101) {
        if (r100 == null) goto L33;
        Integer r102 = null;
        if ((r100 instanceof Boolean) == false) goto L7;
        Boolean r103 = (Boolean) r100;
    L15:
        if (r103 == null) goto L19;
        return r103.booleanValue();
    L19:
        if ((r100 instanceof Integer) == false) goto L22;
        r102 = (Integer) r100;
    L27:
        if (r102 == null) goto L33;
        if (r102.intValue() == 0) goto L31;
        return true;
    L31:
        return false;
    L22:
        if ((r100 instanceof Number) == false) goto L25;
        r102 = Integer.valueOf(((Number) r100).intValue());
        goto L27
    L25:
        if ((r100 instanceof String) == false) goto L27;
        r102 = Integer.valueOf((int) CastDoubleProtector.parseDouble((String) r100));     // Catch: NumberFormatException -> L34
        goto L27
    L7:
        if ((r100 instanceof String) == false) goto L14;
        String r104 = (String) r100;
        if ("true".equalsIgnoreCase(r104) == false) goto L12;
        r103 = Boolean.TRUE;
        goto L15
    L12:
        if ("false".equalsIgnoreCase(r104) == false) goto L14;
        r103 = Boolean.FALSE;
    L14:
        r103 = null;
    L33:
        return r101;
    }
}
