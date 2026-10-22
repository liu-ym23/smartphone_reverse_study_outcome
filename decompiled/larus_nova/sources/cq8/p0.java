package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class p0 extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f464928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f464929e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final wa8.u f464930f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p0) == true) goto L8;
        return false;
    L8:
        p0 r101 = (p0) r100;
        if (Intrinsics.areEqual(this.f464927c, r101.f464927c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464928d, r101.f464928d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f464929e, r101.f464929e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f464930f, r101.f464930f) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f464927c.hashCode() * 31) + this.f464928d.hashCode()) * 31) + this.f464929e.hashCode()) * 31;
        wa8.u r101 = this.f464930f;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ReferenceImageUploadDescriptor(widgetId=" + this.f464927c + ", actionChannel=" + this.f464928d + ", version=" + this.f464929e + ", template=" + this.f464930f + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.f464929e;
    }

    public p0(String r100, com.larus.bmhome.instruction.core.impl.base.b.C4081b r101, wa8.u r102) {
        String r103 = a0.a.a();
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "actionChannel");
        Intrinsics.checkNotNullParameter(r103, "version");
        super("ReferenceImageUploadDescriptor");
        this.f464927c = r100;
        this.f464928d = r101;
        this.f464929e = r103;
        this.f464930f = r102;
    }
}
