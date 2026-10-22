package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(long r9) {
        if (r9 <= 0) goto L18;
        StringBuilder r0 = new StringBuilder();
        if (r9 <= 3600000) goto L10;
        long r6 = r9 / 3600000;
        r9 = r9 - (3600000 * r6);
        if (r6 > 9) goto L9;
        r0.append(0);
    L9:
        r0.append(r6);
        r0.append(":");
    L10:
        long r7 = r9 / 60000;
        long r10 = r9 - (60000 * r7);
        long r4 = 9;
        if (r7 > r4) goto L13;
        r0.append(0);
    L13:
        r0.append(r7);
        r0.append(":");
        long r11 = r10 / 1000;
        if (r11 > r4) goto L16;
        r0.append(0);
    L16:
        r0.append(r11);
        return r0.toString();
    L18:
        return "";
    }
}
