package com.larus.home.impl.main.side_bar.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f344481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f344482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f344483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f344484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f344485e;

    public c() {
        this(null, null, null, null, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f344481a, r101.f344481a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f344482b, r101.f344482b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f344483c, r101.f344483c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f344484d, r101.f344484d) == true) goto L21;
        return false;
    L21:
        if (this.f344485e == r101.f344485e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f344481a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f344482b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f344483c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.f344484d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        int r111 = (r109 + r101) * 31;
        if (this.f344485e == false) goto L21;
        int r112 = 1231;
    L23:
        return r111 + r112;
    L21:
        r112 = 1237;
        goto L23
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
        return "ConversationGroupConfigCache(groupPolicy=" + this.f344481a + ", sortPolicy=" + this.f344482b + ", archiveFilter=" + this.f344483c + ", socialIndependentGroup=" + this.f344484d + ", hasManuallyChangedConversationGroupPolicy=" + this.f344485e + ')';
    }

    public c(Integer r100, Integer r101, Integer r102, Boolean r103, boolean r104) {
        this.f344481a = r100;
        this.f344482b = r101;
        this.f344483c = r102;
        this.f344484d = r103;
        this.f344485e = r104;
    }
}
