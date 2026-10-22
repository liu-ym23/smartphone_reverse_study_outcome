package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class q0 extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f464935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f464936e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q0) == true) goto L8;
        return false;
    L8:
        q0 r101 = (q0) r100;
        if (Intrinsics.areEqual(this.f464934c, r101.f464934c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464935d, r101.f464935d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f464936e, r101.f464936e) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f464934c.hashCode() * 31) + this.f464935d.hashCode()) * 31) + this.f464936e.hashCode();
    }

    public final String toString() {
        return "StubDescriptor(widgetId=" + this.f464934c + ", actionChannel=" + this.f464935d + ", version=" + this.f464936e + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.f464936e;
    }

    public q0(String r100, com.larus.bmhome.instruction.core.impl.base.b.C4081b r101) {
        String r102 = a0.a.a();
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "actionChannel");
        Intrinsics.checkNotNullParameter(r102, "version");
        super("StubDescriptor");
        this.f464934c = r100;
        this.f464935d = r101;
        this.f464936e = r102;
    }
}
