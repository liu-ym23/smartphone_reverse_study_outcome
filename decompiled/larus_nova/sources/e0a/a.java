package e0a;

import java.util.Map;

/* JADX INFO: loaded from: classes31.dex */
public final class a {
    public static final boolean a(Map<String, ? extends Object> r100) {
        Integer r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get("is_in_lottery_state");
    L7:
        if ((r102 instanceof Integer) == false) goto L9;
        r101 = (Integer) r102;
    L9:
        if (r101 != null) goto L12;
    L14:
        return false;
    L12:
        if (r101.intValue() != 1) goto L14;
        return true;
    L5:
        r102 = null;
        goto L7
    }
}
