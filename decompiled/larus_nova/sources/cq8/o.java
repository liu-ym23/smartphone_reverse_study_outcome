package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class o extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f464907d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f464908e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.bmhome.actionbar.model.h f464909f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f464910g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f464911h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final z0 f464912i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f464906c, r101.f464906c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464907d, r101.f464907d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f464908e, r101.f464908e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f464909f, r101.f464909f) == true) goto L21;
        return false;
    L21:
        if (this.f464910g == r101.f464910g) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f464911h, r101.f464911h) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f464912i, r101.f464912i) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f464906c.hashCode() * 31) + this.f464907d.hashCode()) * 31) + this.f464908e.hashCode()) * 31;
        com.larus.bmhome.actionbar.model.h r101 = this.f464909f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f464910g) * 31;
        Long r105 = this.f464911h;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return ((r104 + r102) * 31) + this.f464912i.hashCode();
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DropdownSelectorDescriptor(widgetId=" + this.f464906c + ", actionChannel=" + this.f464907d + ", version=" + this.f464908e + ", dropdownBox=" + this.f464909f + ", dropdownBoxStyle=" + this.f464910g + ", selectedOptionId=" + this.f464911h + ", trackingContext=" + this.f464912i + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.f464908e;
    }

    public o(String r100, com.larus.bmhome.instruction.core.impl.base.b.C4081b r101, com.larus.bmhome.actionbar.model.h r102, int r103, Long r104, z0 r105) {
        String r106 = a0.a.a();
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "actionChannel");
        Intrinsics.checkNotNullParameter(r106, "version");
        Intrinsics.checkNotNullParameter(r105, "trackingContext");
        super("DropdownSelectorDescriptor");
        this.f464906c = r100;
        this.f464907d = r101;
        this.f464908e = r106;
        this.f464909f = r102;
        this.f464910g = r103;
        this.f464911h = r104;
        this.f464912i = r105;
    }
}
