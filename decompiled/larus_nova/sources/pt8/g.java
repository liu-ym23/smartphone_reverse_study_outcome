package pt8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g implements ot8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f530675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f530676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b> f530677c;

    public g() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f530675a == r101.f530675a) goto L12;
        return false;
    L12:
        if (this.f530676b == r101.f530676b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f530677c, r101.f530677c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f530675a * 31;
        if (this.f530676b == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f530677c.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "WidgetDoubleTinyMenu(id=" + this.f530675a + ", removeAroundDivider=" + this.f530676b + ", itemList=" + this.f530677c + ')';
    }

    @Override // ot8.a
    public final boolean a() {
        return this.f530676b;
    }

    @Override // ot8.a
    public final int getId() {
        return this.f530675a;
    }

    public g(int r100, List r101) {
        Intrinsics.checkNotNullParameter(r101, "itemList");
        this.f530675a = r100;
        this.f530676b = false;
        this.f530677c = r101;
    }
}
