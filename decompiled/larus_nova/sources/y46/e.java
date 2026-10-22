package y46;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f566056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f566057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f566058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f566059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f566060e;

    public e() {
        this(null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f566056a, r101.f566056a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f566057b, r101.f566057b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f566058c, r101.f566058c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f566059d, r101.f566059d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f566060e, r101.f566060e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f566056a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f566057b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f566058c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f566059d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f566060e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ViewInfo(belongViewGroupName=" + this.f566056a + ", name=" + this.f566057b + ", id=" + this.f566058c + ", exposureId=" + this.f566059d + ", exposureScene=" + this.f566060e + ')';
    }

    public /* synthetic */ e(String r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, null, null, null, null);
    }

    public e(String r100, String r101, String r102, String r103, String r104) {
        this.f566056a = r100;
        this.f566057b = r101;
        this.f566058c = r102;
        this.f566059d = r103;
        this.f566060e = r104;
    }
}
