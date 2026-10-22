package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class s {
    public final Object a;
    public final h b;
    public final Function1<Throwable, Unit> c;
    public final Object d;
    public final Throwable e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s) == true) goto L8;
        return false;
    L8:
        s r6 = (s) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Object r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        h r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Function1<Throwable, Unit> r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Object r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Throwable r13 = this.e;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CompletedContinuation";
    }

    public static s a(s r8, h r9, Throwable r10, int r11) {
        Object r1 = null;
        if ((r11 & 1) == 0) goto L5;
        Object r3 = r8.a;
    L7:
        if ((r11 & 2) == 0) goto L9;
        r9 = r8.b;
    L9:
        h r4 = r9;
        if ((r11 & 4) == 0) goto L12;
        Function1<Throwable, Unit> r5 = r8.c;
    L14:
        if ((r11 & 8) == 0) goto L16;
        r1 = r8.d;
    L16:
        Object r6 = r1;
        if ((r11 & 16) == 0) goto L19;
        r10 = r8.e;
    L19:
        r8.getClass();
        return new s(r3, r4, r5, r6, r10);
    L12:
        r5 = null;
        goto L14
    L5:
        r3 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s(Object r1, h r2, Function1<? super Throwable, Unit> r3, Object r4, Throwable r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public /* synthetic */ s(Object r9, h r10, Function1 r11, Object r12, Throwable r13, int r14) {
        if ((r14 & 2) == 0) goto L5;
        h r4 = null;
    L7:
        if ((r14 & 4) == 0) goto L9;
        Function1 r5 = null;
    L11:
        if ((r14 & 8) == 0) goto L13;
        Object r6 = null;
    L15:
        if ((r14 & 16) == 0) goto L17;
        Throwable r7 = null;
    L18:
        this(r9, r4, r5, r6, r7);
        return;
    L17:
        r7 = r13;
        goto L18
    L13:
        r6 = r12;
        goto L15
    L9:
        r5 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }
}
