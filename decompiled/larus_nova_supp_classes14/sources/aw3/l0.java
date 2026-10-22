package aw3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l0 {
    public final q0 a;
    public final m0 b;

    public /* synthetic */ l0() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r6 = (l0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        m0 r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "BackgroundAudioCommandResult(state=" + this.a + ", error=" + this.b + ')';
    }

    public l0(q0 r2, m0 r3) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.a = r2;
        this.b = r3;
    }
}
