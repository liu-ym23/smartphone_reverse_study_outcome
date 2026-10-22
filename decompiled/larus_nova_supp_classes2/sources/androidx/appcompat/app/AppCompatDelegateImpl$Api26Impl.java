package androidx.appcompat.app;

import android.content.res.Configuration;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatDelegateImpl$Api26Impl {
    private AppCompatDelegateImpl$Api26Impl() {
    }

    public static void generateConfigDelta_colorMode(Configuration r3, Configuration r4, Configuration r5) {
        int r0 = r3.colorMode & 3;
        int r1 = r4.colorMode;
        if (r0 == (r1 & 3)) goto L5;
        r5.colorMode |= r1 & 3;
    L5:
        int r6 = r3.colorMode & 12;
        int r7 = r4.colorMode;
        if (r6 == (r7 & 12)) goto L9;
        r5.colorMode |= r7 & 12;
        return;
    }
}
