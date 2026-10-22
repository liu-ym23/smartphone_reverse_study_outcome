package ey4;

import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g {
    public final String a;
    public int b;
    public final int c;
    public final boolean d;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.a, Integer.valueOf(this.c), Boolean.valueOf(this.d)});
    }

    public final String toString() {
        return "PanelHeightInfo(panelId=" + this.a + ", panelHeight=" + this.b + ", orientation=" + this.c + ", editStatus=" + this.d + ')';
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L9;
        return false;
    L9:
        if (super.equals(r5) == true) goto L11;
        return false;
    L11:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public g(String r2, int r3, int r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "panelId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
