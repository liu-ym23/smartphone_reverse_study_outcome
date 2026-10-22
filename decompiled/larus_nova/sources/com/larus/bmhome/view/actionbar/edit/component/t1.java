package com.larus.bmhome.view.actionbar.edit.component;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f316459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f316460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f316461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k0 f316462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f316463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f316464f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t1) == true) goto L8;
        return false;
    L8:
        t1 r101 = (t1) r100;
        if (Intrinsics.areEqual(this.f316459a, r101.f316459a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f316460b, r101.f316460b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f316461c, r101.f316461c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f316462d, r101.f316462d) == true) goto L21;
        return false;
    L21:
        if (this.f316463e == r101.f316463e) goto L24;
        return false;
    L24:
        if (this.f316464f == r101.f316464f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f316459a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f316460b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f316461c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        int r108 = (((r106 + r101) * 31) + this.f316462d.hashCode()) * 31;
        int r109 = 1231;
        if (this.f316463e == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r108 + r110) * 31;
        if (this.f316464f == true) goto L23;
        r109 = 1237;
    L23:
        return r111 + r109;
    L17:
        r110 = 1237;
        goto L18
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PendingCollaboratedSubscribeRestore(actionBarKey=" + this.f316459a + ", itemId=" + this.f316460b + ", parentInstructionType=" + this.f316461c + ", request=" + this.f316462d + ", reopenPanel=" + this.f316463e + ", readyToApply=" + this.f316464f + ')';
    }

    public final boolean a(com.larus.bmhome.actionbar.model.z0 r100, Integer r110) {
        if (Intrinsics.areEqual(this.f316461c, r110) == true) goto L5;
        return false;
    L5:
        String r111 = this.f316459a;
        Long r101 = null;
        String r102 = null;
        if (r111 != null) goto L8;
    L16:
        Long r112 = this.f316460b;
        if (r112 != null) goto L19;
    L34:
        if (r100 == null) goto L47;
        com.larus.bmhome.actionbar.model.r r103 = r100.f295621q;
        if (r103 == null) goto L48;
        Integer r104 = r103.f295408a;
        if (r104 != null) goto L41;
        return false;
    L41:
        if (r104.intValue() != 28) goto L49;
        return true;
    L49:
        return false;
    L48:
        return false;
    L47:
        return false;
    L19:
        if (r112.longValue() <= 0) goto L21;
        boolean r105 = true;
    L22:
        if (r105 == false) goto L24;
        r101 = r112;
    L24:
        if (r101 == null) goto L34;
        long r106 = r101.longValue();
        if (r100 == null) goto L44;
        Long r107 = r100.f295605a;
        if (r107 != null) goto L31;
        return false;
    L31:
        if (r107.longValue() != r106) goto L45;
        return true;
    L45:
        return false;
    L44:
        return false;
    L21:
        r105 = false;
        goto L22
    L8:
        if ((!StringsKt.isBlank(r111)) == true) goto L11;
        r111 = null;
    L11:
        if (r111 == null) goto L16;
        if (r100 == null) goto L15;
        r102 = r100.f295606b;
    L15:
        return Intrinsics.areEqual(r102, r111);
    }

    public t1(String r100, Long r101, Integer r102, k0 r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r103, "request");
        this.f316459a = r100;
        this.f316460b = r101;
        this.f316461c = r102;
        this.f316462d = r103;
        this.f316463e = r104;
        this.f316464f = false;
    }
}
