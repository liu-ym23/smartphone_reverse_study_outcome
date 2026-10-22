package lq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f510341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f510342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f510343c;

    public o() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f510341a, r101.f510341a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f510342b, r101.f510342b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f510343c, r101.f510343c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f510341a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        t r104 = this.f510342b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f510343c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraGUpdateConfig(enable=" + this.f510341a + ", popupConfig=" + this.f510342b + ", frequency=" + this.f510343c + ')';
    }

    public /* synthetic */ o(int r100) {
        this(Boolean.FALSE, null, 0L);
    }

    public o(Boolean r100, t r101, Long r102) {
        this.f510341a = r100;
        this.f510342b = r101;
        this.f510343c = r102;
    }
}
