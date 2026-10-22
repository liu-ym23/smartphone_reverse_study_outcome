package com.larus.suggest.impl.wcb.policy;

/* JADX INFO: loaded from: classes31.dex */
public final class x {
    public static final String a(Long r110, long r111) {
        if (r110 == null) goto L17;
        if (r110.longValue() <= 0) goto L17;
        long r100 = r110.longValue() - r111;
        long r112 = Math.abs(r100);
        if (r112 >= 60) goto L9;
        StringBuilder r101 = new StringBuilder();
        r101.append(r112);
        r101.append('s');
        String r113 = r101.toString();
    L11:
        if (r100 <= 0) goto L13;
        String r114 = "expires in " + r113;
    L15:
        return r110 + " (" + r114 + ')';
    L13:
        r114 = "expired " + r113 + " ago";
        goto L15
    L9:
        r113 = (r112 / 60) + "min " + (r112 % 60) + 's';
    L17:
        return r110 + " (no valid expiry)";
    }
}
