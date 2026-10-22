package jkb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f499517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f499518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f499519c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f499517a, r101.f499517a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f499518b, r101.f499518b) == true) goto L15;
        return false;
    L15:
        if (this.f499519c == r101.f499519c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f499517a.hashCode() * 31;
        Integer r101 = this.f499518b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f499519c == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return this.f499517a;
    }

    public /* synthetic */ e(String r100) {
        this(r100, null, false);
    }

    public e(String r100, Integer r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f499517a = r100;
        this.f499518b = r101;
        this.f499519c = r102;
    }
}
