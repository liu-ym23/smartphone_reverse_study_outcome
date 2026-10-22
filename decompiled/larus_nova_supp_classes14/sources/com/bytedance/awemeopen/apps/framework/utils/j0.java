package com.bytedance.awemeopen.apps.framework.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j0 {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static String a(int r2) {
            if (r2 >= 10) goto L6;
            return "0" + r2;
        L6:
            return String.valueOf(r2);
        }

        public static String b(int r3) {
            if (r3 >= 3600) goto L6;
            return a(r3 / 60) + ':' + a(r3 % 60);
        L6:
            return a(r3 / 3600) + ':' + b(r3 % 3600);
        }
    }

    static {
    }
}
