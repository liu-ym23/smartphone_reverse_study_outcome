package fn0;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f477912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f477913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f477914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<Integer> f477915d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (this.f477912a == r101.f477912a) goto L8;
        return false;
    L8:
        if (this.f477913b == r101.f477913b) goto L10;
        return false;
    L10:
        if (this.f477914c == r101.f477914c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f477915d, r101.f477915d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r100 = ((((this.f477912a * 31) + this.f477913b) * 31) + this.f477914c) * 31;
        List<Integer> r101 = this.f477915d;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "MultiControlModeInfo(mode=" + this.f477912a + ", scene=" + this.f477913b + ", uiLayout=" + this.f477914c + ", playModes=" + this.f477915d + ")";
    }

    public /* synthetic */ a(int r100) {
        this(r100, 0, 0, null);
    }

    public a(int r100, int r101, int r102, List<Integer> r103) {
        this.f477912a = r100;
        this.f477913b = r101;
        this.f477914c = r102;
        this.f477915d = r103;
    }
}
