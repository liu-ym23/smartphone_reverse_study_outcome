package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class r0 extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f464947d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f464948e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.bmhome.actionbar.model.i0 f464949f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f464950g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f464951h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r0) == true) goto L8;
        return false;
    L8:
        r0 r101 = (r0) r100;
        if (Intrinsics.areEqual(this.f464946c, r101.f464946c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464947d, r101.f464947d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f464948e, r101.f464948e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f464949f, r101.f464949f) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f464950g, r101.f464950g) == true) goto L24;
        return false;
    L24:
        if (this.f464951h == r101.f464951h) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f464946c.hashCode() * 31) + this.f464947d.hashCode()) * 31) + this.f464948e.hashCode()) * 31;
        com.larus.bmhome.actionbar.model.i0 r101 = this.f464949f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f464950g;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        int r106 = (r104 + r102) * 31;
        if (this.f464951h == false) goto L13;
        int r107 = 1231;
    L15:
        return r106 + r107;
    L13:
        r107 = 1237;
        goto L15
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "TabSelectorDescriptor(widgetId=" + this.f464946c + ", actionChannel=" + this.f464947d + ", version=" + this.f464948e + ", template=" + this.f464949f + ", subTitle=" + this.f464950g + ", enableBottomLine=" + this.f464951h + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.f464948e;
    }

    public r0(String r100, com.larus.bmhome.instruction.core.impl.base.b.C4081b r101, com.larus.bmhome.actionbar.model.i0 r102, String r103, boolean r104) {
        String r105 = a0.a.a();
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "actionChannel");
        Intrinsics.checkNotNullParameter(r105, "version");
        super("TabSelectorDescriptor");
        this.f464946c = r100;
        this.f464947d = r101;
        this.f464948e = r105;
        this.f464949f = r102;
        this.f464950g = r103;
        this.f464951h = r104;
    }
}
