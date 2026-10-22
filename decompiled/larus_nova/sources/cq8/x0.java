package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class x0 extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f464999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f465000e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.bmhome.actionbar.model.k0 f465001f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f465002g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x0) == true) goto L8;
        return false;
    L8:
        x0 r101 = (x0) r100;
        if (Intrinsics.areEqual(this.f464998c, r101.f464998c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464999d, r101.f464999d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f465000e, r101.f465000e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f465001f, r101.f465001f) == true) goto L21;
        return false;
    L21:
        if (this.f465002g == r101.f465002g) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f464998c.hashCode() * 31) + this.f464999d.hashCode()) * 31) + this.f465000e.hashCode()) * 31;
        com.larus.bmhome.actionbar.model.k0 r101 = this.f465001f;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f465002g == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "UserMessageSenderDescriptor(widgetId=" + this.f464998c + ", actionChannel=" + this.f464999d + ", version=" + this.f465000e + ", template=" + this.f465001f + ", isMemorized=" + this.f465002g + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.f465000e;
    }

    public x0(String r100, com.larus.bmhome.instruction.core.impl.base.b.C4081b r101, com.larus.bmhome.actionbar.model.k0 r102, boolean r103) {
        String r104 = a0.a.a();
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "actionChannel");
        Intrinsics.checkNotNullParameter(r104, "version");
        super("UserMessageSenderDescriptor");
        this.f464998c = r100;
        this.f464999d = r101;
        this.f465000e = r104;
        this.f465001f = r102;
        this.f465002g = r103;
    }
}
