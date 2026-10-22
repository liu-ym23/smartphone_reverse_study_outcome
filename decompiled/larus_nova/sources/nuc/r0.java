package nuc;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class r0 extends g2 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f520763m;

    @Override // nuc.g2
    public final int hashCode() {
        return super.hashCode() * 31;
    }

    @Override // nuc.g2, luc.f
    public final boolean isInline() {
        return this.f520763m;
    }

    @Override // nuc.g2
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r0) == false) goto L29;
        luc.f r101 = (luc.f) r100;
        if (Intrinsics.areEqual(this.f520683a, r101.f()) == false) goto L29;
        r0 r102 = (r0) r100;
        if (r102.f520763m == true) goto L14;
    L16:
        boolean r103 = false;
    L17:
        if (r103 == false) goto L29;
        if (this.f520685c != r101.d()) goto L29;
        int r104 = this.f520685c;
        int r105 = 0;
    L23:
        if (r105 >= r104) goto L36;
        if (Intrinsics.areEqual(h(r105).f(), r101.h(r105).f()) == false) goto L29;
        if (Intrinsics.areEqual(h(r105).getKind(), r101.h(r105).getKind()) == false) goto L29;
        r105 = r105 + 1;
        goto L23
    L36:
        return true;
    L14:
        if (Arrays.equals((luc.f[]) this.f520693k.getValue(), (luc.f[]) r102.f520693k.getValue()) == false) goto L16;
        r103 = true;
    L29:
        return false;
    }

    public r0(String r100, m0<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "generatedSerializer");
        super(r100, r101, 1);
        this.f520763m = true;
    }
}
