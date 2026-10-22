package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f464826d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f464827e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f464828f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f464829g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f464830h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f464825c, r101.f464825c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464826d, r101.f464826d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f464827e, r101.f464827e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f464828f, r101.f464828f) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f464829g, r101.f464829g) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f464830h, r101.f464830h) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f464825c.hashCode() * 31) + this.f464826d.hashCode()) * 31) + this.f464827e.hashCode()) * 31;
        String r101 = this.f464828f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.f464829g;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.f464830h;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CollaboratedMultiFeatureSelectorDescriptor(widgetId=" + this.f464825c + ", actionChannel=" + this.f464826d + ", version=" + this.f464827e + ", template=" + this.f464828f + ", parentInstructionType=" + this.f464829g + ", multiSelectorItemId=" + this.f464830h + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.f464827e;
    }

    public f(String r100, com.larus.bmhome.instruction.core.impl.base.b.C4081b r101, String r102, Integer r103, Integer r104) {
        String r105 = a0.a.a();
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "actionChannel");
        Intrinsics.checkNotNullParameter(r105, "version");
        super("CollaboratedMultiFeatureSelectorDescriptor");
        this.f464825c = r100;
        this.f464826d = r101;
        this.f464827e = r105;
        this.f464828f = r102;
        this.f464829g = r103;
        this.f464830h = r104;
    }
}
