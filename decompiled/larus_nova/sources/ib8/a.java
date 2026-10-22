package ib8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f488998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final lb8.g f488999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kb8.i f489000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final nb8.i f489001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.larus.bmhome.chat.standarduikit.vlm.view.a f489002e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final tk8.e f489003f;

    public a() {
        this(null, null, null, null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f488998a, r101.f488998a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f488999b, r101.f488999b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f489000c, r101.f489000c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f489001d, r101.f489001d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f489002e, r101.f489002e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f489003f, r101.f489003f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f488998a.hashCode() * 31;
        lb8.g r101 = this.f488999b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        kb8.i r105 = this.f489000c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        nb8.i r108 = this.f489001d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        com.larus.bmhome.chat.standarduikit.vlm.view.a r111 = this.f489002e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        tk8.e r114 = this.f489003f;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ContainerViewInput(foldContainerViewInput=" + this.f488998a + ", deepThinkBlockList=" + this.f488999b + ", queryQueryKeywordReferencesViewInput=" + this.f489000c + ", deepThinkContentInput=" + this.f489001d + ", flowVlmViewInput=" + this.f489002e + ", elapsedBlockContentInput=" + this.f489003f + ')';
    }

    public a(n r310, lb8.g r311, kb8.i r312, nb8.i r313, com.larus.bmhome.chat.standarduikit.vlm.view.a r314, tk8.e r315, int r316) {
        if ((r316 & 1) == 0) goto L5;
        n r100 = new n(false, false, null, null, false, false, false, false, false, null, false, false, false, null, false, false, null, null, null, null, null, false, false, 0, 0, false, 0, false, 1073741823);
    L6:
        tk8.e r101 = null;
        if ((r316 & 2) == 0) goto L9;
        lb8.g r102 = null;
    L11:
        if ((r316 & 4) == 0) goto L13;
        kb8.i r103 = null;
    L15:
        if ((r316 & 8) == 0) goto L17;
        nb8.i r104 = null;
    L19:
        if ((r316 & 16) == 0) goto L21;
        com.larus.bmhome.chat.standarduikit.vlm.view.a r105 = null;
    L23:
        if ((r316 & 32) != 0) goto L26;
        r101 = r315;
    L26:
        Intrinsics.checkNotNullParameter(r100, "foldContainerViewInput");
        this.f488998a = r100;
        this.f488999b = r102;
        this.f489000c = r103;
        this.f489001d = r104;
        this.f489002e = r105;
        this.f489003f = r101;
        return;
    L21:
        r105 = r314;
        goto L23
    L17:
        r104 = r313;
        goto L19
    L13:
        r103 = r312;
        goto L15
    L9:
        r102 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L6
    }
}
