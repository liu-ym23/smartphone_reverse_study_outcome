package com.bytedance.android.livesdk.log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class l0 {
    public static String a(String r1, com.bytedance.android.livesdk.log.filter.o r2) {
        if (r2 != null) goto L5;
        return "";
    L5:
        String r3 = r2.getMap().get(r1);
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3;
    }
}
