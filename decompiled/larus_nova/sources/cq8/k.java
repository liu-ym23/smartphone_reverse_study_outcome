package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class k extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f464863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f464864e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.bmhome.actionbar.model.h f464865f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f464866g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f464867h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f464868i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final z0 f464869j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f464862c, r101.f464862c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464863d, r101.f464863d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f464864e, r101.f464864e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f464865f, r101.f464865f) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f464866g, r101.f464866g) == true) goto L24;
        return false;
    L24:
        if (this.f464867h == r101.f464867h) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f464868i, r101.f464868i) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f464869j, r101.f464869j) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f464862c.hashCode() * 31) + this.f464863d.hashCode()) * 31) + this.f464864e.hashCode()) * 31;
        com.larus.bmhome.actionbar.model.h r101 = this.f464865f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f464866g;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        if (this.f464867h == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        Integer r110 = this.f464868i;
        if (r110 == null) goto L19;
        r102 = r110.hashCode();
    L19:
        return ((r109 + r102) * 31) + this.f464869j.hashCode();
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DropFeatureSelectorDescriptor(widgetId=" + this.f464862c + ", actionChannel=" + this.f464863d + ", version=" + this.f464864e + ", template=" + this.f464865f + ", subTitle=" + this.f464866g + ", isStyleRadio=" + this.f464867h + ", parentInstructionType=" + this.f464868i + ", trackingContext=" + this.f464869j + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.f464864e;
    }

    public k(String r100, com.larus.bmhome.instruction.core.impl.base.b.C4081b r101, com.larus.bmhome.actionbar.model.h r102, String r103, boolean r104, Integer r105, z0 r106) {
        String r107 = a0.a.a();
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "actionChannel");
        Intrinsics.checkNotNullParameter(r107, "version");
        Intrinsics.checkNotNullParameter(r106, "trackingContext");
        super("DropFeatureSelectorDescriptor");
        this.f464862c = r100;
        this.f464863d = r101;
        this.f464864e = r107;
        this.f464865f = r102;
        this.f464866g = r103;
        this.f464867h = r104;
        this.f464868i = r105;
        this.f464869j = r106;
    }
}
