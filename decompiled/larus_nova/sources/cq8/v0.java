package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class v0 extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f464972d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f464973e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.bmhome.actionbar.model.l0 f464974f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f464975g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f464976h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f464977i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final z0 f464978j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v0) == true) goto L8;
        return false;
    L8:
        v0 r101 = (v0) r100;
        if (Intrinsics.areEqual(this.f464971c, r101.f464971c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464972d, r101.f464972d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f464973e, r101.f464973e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f464974f, r101.f464974f) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f464975g, r101.f464975g) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f464976h, r101.f464976h) == true) goto L27;
        return false;
    L27:
        if (this.f464977i == r101.f464977i) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f464978j, r101.f464978j) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f464971c.hashCode() * 31) + this.f464972d.hashCode()) * 31) + this.f464973e.hashCode()) * 31;
        com.larus.bmhome.actionbar.model.l0 r101 = this.f464974f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f464975g;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f464976h;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        int r109 = (r107 + r102) * 31;
        if (this.f464977i == false) goto L17;
        int r110 = 1231;
    L19:
        return ((r109 + r110) * 31) + this.f464978j.hashCode();
    L17:
        r110 = 1237;
        goto L19
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "TranslatorDescriptor(widgetId=" + this.f464971c + ", actionChannel=" + this.f464972d + ", version=" + this.f464973e + ", template=" + this.f464974f + ", subTitle=" + this.f464975g + ", displaySubTitleName=" + this.f464976h + ", enableBottomLine=" + this.f464977i + ", trackingContext=" + this.f464978j + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.f464973e;
    }

    public v0(String r100, com.larus.bmhome.instruction.core.impl.base.b.C4081b r101, com.larus.bmhome.actionbar.model.l0 r102, String r103, String r104, boolean r105, z0 r106) {
        String r107 = a0.a.a();
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "actionChannel");
        Intrinsics.checkNotNullParameter(r107, "version");
        Intrinsics.checkNotNullParameter(r106, "trackingContext");
        super("TranslatorDescriptor");
        this.f464971c = r100;
        this.f464972d = r101;
        this.f464973e = r107;
        this.f464974f = r102;
        this.f464975g = r103;
        this.f464976h = r104;
        this.f464977i = r105;
        this.f464978j = r106;
    }
}
