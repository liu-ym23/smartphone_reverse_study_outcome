package bw3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class w {
    public static final /* synthetic */ int c = 0;
    public final h0 a;
    public final x b;

    public static final class a {
        public static w b(h0 r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
            return new w(h0.a(r2), 2);
        }

        public static w a(x r1, h0 r2) {
            Intrinsics.checkNotNullParameter(r1, "error");
            if (r2 == null) goto L5;
            h0 r3 = h0.a(r2);
        L7:
            return new w(r3, r1);
        L5:
            r3 = null;
            goto L7
        }
    }

    static {
    }

    public w() {
        this(null, 3);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof w) == true) goto L8;
        return false;
    L8:
        w r6 = (w) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        h0 r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        x r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "InnerAudioCommandResult(state=" + this.a + ", error=" + this.b + ')';
    }

    public final boolean a() {
        if (this.b != null) goto L5;
        return true;
    L5:
        return false;
    }

    public /* synthetic */ w(h0 r2, int r3) {
        if ((r3 & 1) == 0) goto L5;
        r2 = null;
    L5:
        this(r2, null);
    }

    public w(h0 r1, x r2) {
        this.a = r1;
        this.b = r2;
    }
}
