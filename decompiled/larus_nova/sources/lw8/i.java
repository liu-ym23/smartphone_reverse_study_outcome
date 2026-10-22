package lw8;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f511080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f511081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f511082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f511083d;

    public i() {
        this(false, null, false, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f511080a == r101.f511080a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f511081b, r101.f511081b) == true) goto L15;
        return false;
    L15:
        if (this.f511082c == r101.f511082c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f511083d, r101.f511083d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        boolean r100 = this.f511080a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        View r104 = this.f511081b;
        int r105 = 0;
        if (r104 != null) goto L8;
        int r106 = 0;
    L9:
        int r107 = (r103 + r106) * 31;
        boolean r108 = this.f511082c;
        if (r108 == true) goto L13;
        r101 = r108;
    L13:
        int r109 = (r107 + r101) * 31;
        String r110 = this.f511083d;
        if (r110 == null) goto L18;
        r105 = r110.hashCode();
    L18:
        return r109 + r105;
    L8:
        r106 = r104.hashCode();
        goto L9
    }

    public final String toString() {
        return "IncrementalTextSpanParams(abilitySwitch=" + this.f511080a + ", viewGroup=" + this.f511081b + ", incrementalConditionMet=" + this.f511082c + ", incrementalText=" + this.f511083d + ')';
    }

    public i(boolean r100, View r101, boolean r102, String r103) {
        this.f511080a = r100;
        this.f511081b = r101;
        this.f511082c = r102;
        this.f511083d = r103;
    }
}
