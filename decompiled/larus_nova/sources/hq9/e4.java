package hq9;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f486585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f486586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f486587d;

    public e4() {
        this(false, null, null, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e4) == true) goto L8;
        return false;
    L8:
        e4 r101 = (e4) r100;
        if (this.f486584a == r101.f486584a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486585b, r101.f486585b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f486586c, r101.f486586c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f486587d, r101.f486587d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f486584a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((((r100 * 31) + this.f486585b.hashCode()) * 31) + this.f486586c.hashCode()) * 31;
        Function0<Unit> r102 = this.f486587d;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "RightTextAction(isShowRightText=" + this.f486584a + ", rightTextActionSchema=" + this.f486585b + ", rightText=" + this.f486586c + ", rightTextActionInterceptor=" + this.f486587d + ')';
    }

    public e4(boolean r100, String r101, String r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r101, "rightTextActionSchema");
        Intrinsics.checkNotNullParameter(r102, "rightText");
        this.f486584a = r100;
        this.f486585b = r101;
        this.f486586c = r102;
        this.f486587d = r103;
    }

    public /* synthetic */ e4(boolean r100, String r101, String r102, Function0 r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = "";
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
