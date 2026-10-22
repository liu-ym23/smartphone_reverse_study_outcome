package com.bytedance.rts.kmp.foundation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@RTSHiddenFromObjC
public final class n {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static String a(int... r4) {
            Intrinsics.checkNotNullParameter(r4, "code");
            StringBuilder r0 = new StringBuilder();
            int r1 = r4.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L6;
            r0.append((char) r4[r2]);
            r2 = r2 + 1;
            goto L3
        L6:
            return r0.toString();
        }
    }

    static {
    }
}
