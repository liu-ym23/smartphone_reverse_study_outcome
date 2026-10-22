package com.larus.bmhome.view.actionbar.edit.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f316469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f316470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f316471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f316472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f316473e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u1) == true) goto L8;
        return false;
    L8:
        u1 r101 = (u1) r100;
        if (Intrinsics.areEqual(this.f316469a, r101.f316469a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f316470b, r101.f316470b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f316471c, r101.f316471c) == true) goto L18;
        return false;
    L18:
        if (this.f316472d == r101.f316472d) goto L21;
        return false;
    L21:
        if (this.f316473e == r101.f316473e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f316469a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f316470b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f316471c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        int r108 = (((r106 + r101) * 31) + this.f316472d) * 31;
        long r109 = this.f316473e;
        return r108 + ((int) (r109 ^ (r109 >>> 32)));
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PendingDropdownSubscribeRestore(actionBarKey=" + this.f316469a + ", itemId=" + this.f316470b + ", instructionItemId=" + this.f316471c + ", dropdownBoxId=" + this.f316472d + ", optionId=" + this.f316473e + ')';
    }

    public u1(String r100, Long r101, Integer r102, int r103, long r104) {
        this.f316469a = r100;
        this.f316470b = r101;
        this.f316471c = r102;
        this.f316472d = r103;
        this.f316473e = r104;
    }
}
