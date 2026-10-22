package yy3;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import yy3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a<T extends b> {
    public final WeakReference<T> a;
    public final WeakReference<T> b;
    public final int c;

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
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c;
    }

    public final String toString() {
        return "AbilityChangeEvent(ability=" + this.a + ", oldAbility=" + this.b + ", eventType=" + this.c + ')';
    }

    public a(WeakReference<T> r2, WeakReference<T> r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        Intrinsics.checkNotNullParameter(r3, "oldAbility");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
