package ey4;

import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f474803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f474804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f474805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f474806d;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f474803a, Integer.valueOf(this.f474805c), Boolean.valueOf(this.f474806d)});
    }

    public final String toString() {
        return "PanelHeightInfo(panelId=" + this.f474803a + ", panelHeight=" + this.f474804b + ", orientation=" + this.f474805c + ", editStatus=" + this.f474806d + ')';
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L9;
        return false;
    L9:
        if (super.equals(r100) == true) goto L11;
        return false;
    L11:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f474803a, r101.f474803a) == true) goto L15;
        return false;
    L15:
        if (this.f474805c == r101.f474805c) goto L18;
        return false;
    L18:
        if (this.f474806d == r101.f474806d) goto L20;
        return false;
    L20:
        return true;
    }

    public g(String r100, int r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "panelId");
        this.f474803a = r100;
        this.f474804b = r101;
        this.f474805c = r102;
        this.f474806d = r103;
    }
}
