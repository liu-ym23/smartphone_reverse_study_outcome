package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f464808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f464809e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.bmhome.actionbar.model.a f464810f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final z0 f464811g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f464807c, r101.f464807c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464808d, r101.f464808d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f464809e, r101.f464809e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f464810f, r101.f464810f) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f464811g, r101.f464811g) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f464807c.hashCode() * 31) + this.f464808d.hashCode()) * 31) + this.f464809e.hashCode()) * 31;
        com.larus.bmhome.actionbar.model.a r101 = this.f464810f;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f464811g.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ButtonRouterDescriptor(widgetId=" + this.f464807c + ", actionChannel=" + this.f464808d + ", version=" + this.f464809e + ", template=" + this.f464810f + ", trackingContext=" + this.f464811g + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.f464809e;
    }

    public c(String r100, com.larus.bmhome.instruction.core.impl.base.b.C4081b r101, com.larus.bmhome.actionbar.model.a r102, z0 r103) {
        String r104 = a0.a.a();
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "actionChannel");
        Intrinsics.checkNotNullParameter(r104, "version");
        Intrinsics.checkNotNullParameter(r103, "trackingContext");
        super("ButtonRouterDescriptor");
        this.f464807c = r100;
        this.f464808d = r101;
        this.f464809e = r104;
        this.f464810f = r102;
        this.f464811g = r103;
    }
}
