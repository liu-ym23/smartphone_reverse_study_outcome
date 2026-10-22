package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f464848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f464849e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.bmhome.actionbar.model.c f464850f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f464851g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final z0 f464852h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f464847c, r101.f464847c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464848d, r101.f464848d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f464849e, r101.f464849e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f464850f, r101.f464850f) == true) goto L21;
        return false;
    L21:
        if (this.f464851g == r101.f464851g) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f464852h, r101.f464852h) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f464847c.hashCode() * 31) + this.f464848d.hashCode()) * 31) + this.f464849e.hashCode()) * 31;
        com.larus.bmhome.actionbar.model.c r101 = this.f464850f;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f464851g == false) goto L9;
        int r104 = 1231;
    L11:
        return ((r103 + r104) * 31) + this.f464852h.hashCode();
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CommandDescriptor(widgetId=" + this.f464847c + ", actionChannel=" + this.f464848d + ", version=" + this.f464849e + ", commandOption=" + this.f464850f + ", renderSelection=" + this.f464851g + ", trackingContext=" + this.f464852h + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.f464849e;
    }

    public i(String r100, com.larus.bmhome.instruction.core.impl.base.b.C4081b r101, com.larus.bmhome.actionbar.model.c r102, boolean r103, z0 r104) {
        String r105 = a0.a.a();
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "actionChannel");
        Intrinsics.checkNotNullParameter(r105, "version");
        Intrinsics.checkNotNullParameter(r104, "trackingContext");
        super("CommandDescriptor");
        this.f464847c = r100;
        this.f464848d = r101;
        this.f464849e = r105;
        this.f464850f = r102;
        this.f464851g = r103;
        this.f464852h = r104;
    }
}
