package b58;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import z48.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final Function1<b, Integer> a;
    public final Function1<b, String> b;
    public final Function1<b, Integer> c;

    public a() {
        this(null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Function1<b, Integer> r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Function1<b, String> r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Function1<b, Integer> r7 = this.c;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatSpeakerSpeechGroupUIConfig(groupIconImageResource=" + this.a + ", groupText=" + this.b + ", groupTextColor=" + this.c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function1<? super b, Integer> r1, Function1<? super b, String> r2, Function1<? super b, Integer> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
