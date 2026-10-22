package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class p extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f464924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f464925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.bmhome.actionbar.model.k f464926f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f464923c, r101.f464923c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464924d, r101.f464924d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f464925e, r101.f464925e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f464926f, r101.f464926f) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f464923c.hashCode() * 31) + this.f464924d.hashCode()) * 31) + this.f464925e.hashCode()) * 31;
        com.larus.bmhome.actionbar.model.k r101 = this.f464926f;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "FeatureSelectorDescriptor(widgetId=" + this.f464923c + ", actionChannel=" + this.f464924d + ", version=" + this.f464925e + ", template=" + this.f464926f + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.f464925e;
    }

    public p(String r100, com.larus.bmhome.instruction.core.impl.base.b.C4081b r101, com.larus.bmhome.actionbar.model.k r102) {
        String r103 = a0.a.a();
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "actionChannel");
        Intrinsics.checkNotNullParameter(r103, "version");
        super("FeatureSelectorDescriptor");
        this.f464923c = r100;
        this.f464924d = r101;
        this.f464925e = r103;
        this.f464926f = r102;
    }
}
