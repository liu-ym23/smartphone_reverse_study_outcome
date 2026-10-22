package j77;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static boolean a(JSONObject r100, String r101) {
        Object r102 = r100.opt(r101);
        if ((r102 instanceof Boolean) == false) goto L6;
        Boolean r103 = (Boolean) r102;
    L27:
        if (r103 != null) goto L31;
        return false;
    L31:
        return r103.booleanValue();
    L6:
        if ((r102 instanceof Integer) == false) goto L14;
        Integer r104 = (Integer) r102;
        if (r104.intValue() != 1) goto L11;
        r103 = Boolean.TRUE;
        goto L27
    L11:
        if (r104.intValue() != 0) goto L26;
        r103 = Boolean.FALSE;
    L26:
        r103 = null;
        goto L27
    L14:
        if ((r102 instanceof String) == false) goto L26;
        String r105 = (String) r102;
        if ("true".equalsIgnoreCase(r105) == false) goto L18;
    L25:
        r103 = Boolean.TRUE;
        goto L27
    L18:
        if ("1".equals(r105) == true) goto L25;
        if ("false".equalsIgnoreCase(r105) == false) goto L23;
    L24:
        r103 = Boolean.FALSE;
        goto L27
    L23:
        if ("0".equals(r105) == false) goto L26;
        goto L24
    }
}
