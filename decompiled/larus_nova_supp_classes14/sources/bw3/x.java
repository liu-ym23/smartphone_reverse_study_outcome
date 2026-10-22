package bw3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class x {
    public static final x c = null;
    public static final x d = null;
    public static final x e = null;
    public static final x f = null;
    public static final x g = null;
    public static final x h = null;
    public static final x i = null;
    public static final x j = null;
    public static final x k = null;
    public final int a;
    public final String b;

    public static final class a {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof x) == true) goto L8;
        return false;
    L8:
        x r6 = (x) r5;
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
        return "InnerAudioError(errCode=" + this.a + ", errMsg=" + this.b + ')';
    }

    static {
        c = new x(-2001, "inner audio appletId is empty");
        d = new x(-2002, "inner audio instance not found");
        e = new x(-2003, "inner audio src is empty");
        f = new x(-2004, "inner audio src is invalid");
        g = new x(-2005, "inner audio player unavailable");
        h = new x(-2006, "inner audio seek failed");
        i = new x(-2008, "inner audio audioId is empty");
        new x(-2009, "inner audio playback is interrupted");
        new x(-2010, "inner audio runtime is unavailable");
        j = new x(-2011, "inner audio action is invalid");
        k = new x(-2012, "inner audio params are invalid");
    }

    public x(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "errMsg");
        this.a = r2;
        this.b = r3;
    }
}
