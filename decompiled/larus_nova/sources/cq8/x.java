package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class x extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f464994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f464995e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.bmhome.actionbar.model.p f464996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f464997g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.f464993c, r101.f464993c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464994d, r101.f464994d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f464995e, r101.f464995e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f464996f, r101.f464996f) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f464997g, r101.f464997g) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f464993c.hashCode() * 31) + this.f464994d.hashCode()) * 31) + this.f464995e.hashCode()) * 31;
        com.larus.bmhome.actionbar.model.p r101 = this.f464996f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f464997g;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "InputBoxDescriptor(widgetId=" + this.f464993c + ", actionChannel=" + this.f464994d + ", version=" + this.f464995e + ", template=" + this.f464996f + ", userInput=" + this.f464997g + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.f464995e;
    }

    public x(String r100, com.larus.bmhome.instruction.core.impl.base.b.C4081b r101, com.larus.bmhome.actionbar.model.p r102) {
        String r103 = a0.a.a();
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "actionChannel");
        Intrinsics.checkNotNullParameter(r103, "version");
        super("InputBoxDescriptor");
        this.f464993c = r100;
        this.f464994d = r101;
        this.f464995e = r103;
        this.f464996f = r102;
        this.f464997g = null;
    }
}
