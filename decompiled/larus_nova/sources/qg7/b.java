package qg7;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f532871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f532872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f532873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f532874d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (this.f532871a == r101.f532871a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f532872b, r101.f532872b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f532873c, r101.f532873c) == true) goto L12;
        return false;
    L12:
        if (this.f532874d == r101.f532874d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean r100 = this.f532871a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.f532872b;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f532873c;
        if (r107 == null) goto L13;
        r104 = r107.hashCode();
    L13:
        return ((r106 + r104) * 31) + this.f532874d;
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return StringsKt.trimMargin$default("{\n            |intercept=" + this.f532871a + ",\n            |message=" + this.f532872b + ",\n            |certToken=" + this.f532873c + ",\n            |code=" + this.f532874d + ",\n            |}", null, 1, null);
    }

    public b(boolean r100, String r101, String r102, int r103) {
        this.f532871a = r100;
        this.f532872b = r101;
        this.f532873c = r102;
        this.f532874d = r103;
    }
}
