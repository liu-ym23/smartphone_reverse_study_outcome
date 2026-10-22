package com.larus.bmhome.view.actionbar.edit.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f316398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f316399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f316400c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r101 = (l0) r100;
        if (this.f316398a == r101.f316398a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f316399b, r101.f316399b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f316400c, r101.f316400c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f316398a * 31;
        Long r101 = this.f316399b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.f316400c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CollaboratedParamSubscribeSelection(selectorId=" + this.f316398a + ", optionId=" + this.f316399b + ", duration=" + this.f316400c + ')';
    }

    public l0(int r100, Long r101, Integer r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this.f316398a = r100;
        this.f316399b = r101;
        this.f316400c = r102;
    }
}
