package com.bytedance.applog.priority.original;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public static final String a(byte[] r5) {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L3:
        if (r5 == null) goto L11;
        if (r1 >= r5.length) goto L11;
        String r2 = Integer.toHexString(r5[r1] & 255);
        if (r2.length() != 1) goto L9;
        r0.append('0');
    L9:
        r0.append(r2);
        r1 = r1 + 1;
    L11:
        return r0.toString();
    }
}
