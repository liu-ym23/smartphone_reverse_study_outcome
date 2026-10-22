package aw3;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m0 {
    public static final m0 c = null;
    public static final m0 d = null;
    public static final m0 e = null;
    public static final m0 f = null;
    public static final m0 g = null;
    public static final m0 h = null;
    public static final m0 i = null;
    public static final m0 j = null;
    public final int a;
    public final String b;

    public static final class a {
        public static m0 a(String r2) {
            String r0 = null;
            if (r2 != null) goto L5;
        L10:
            if (r0 != null) goto L13;
            r0 = "";
        L13:
            return new m0(-1002, "background audio play failed".concat(r0));
        L5:
            if ((!StringsKt.isBlank(r2)) == true) goto L8;
            r2 = null;
        L8:
            if (r2 == null) goto L10;
            r0 = ": ".concat(r2);
            goto L10
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m0) == true) goto L8;
        return false;
    L8:
        m0 r6 = (m0) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "BackgroundAudioError(errCode=" + this.a + ", errMsg=" + this.b + ')';
    }

    static {
        c = new m0(-1001, "background audio src is empty");
        d = new m0(-1002, "background audio play failed");
        e = new m0(-1003, "background audio seek failed");
        f = new m0(-1004, "background audio player unavailable");
        g = new m0(-1005, "background audio is occupied by another applet");
        h = new m0(-1006, "background audio action is invalid");
        i = new m0(-1007, "background audio params are invalid");
        j = new m0(-1008, "background audio appletId is empty");
    }

    public m0(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "errMsg");
        this.a = r2;
        this.b = r3;
    }
}
