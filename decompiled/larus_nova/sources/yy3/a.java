package yy3;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import yy3.b;

/* JADX INFO: loaded from: classes14.dex */
public final class a<T extends b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<T> f569448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<T> f569449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f569450c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f569448a, r101.f569448a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f569449b, r101.f569449b) == true) goto L15;
        return false;
    L15:
        if (this.f569450c == r101.f569450c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f569448a.hashCode() * 31) + this.f569449b.hashCode()) * 31) + this.f569450c;
    }

    public final String toString() {
        return "AbilityChangeEvent(ability=" + this.f569448a + ", oldAbility=" + this.f569449b + ", eventType=" + this.f569450c + ')';
    }

    public a(WeakReference<T> r100, WeakReference<T> r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        Intrinsics.checkNotNullParameter(r101, "oldAbility");
        this.f569448a = r100;
        this.f569449b = r101;
        this.f569450c = r102;
    }
}
