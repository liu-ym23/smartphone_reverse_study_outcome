package rib;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f537937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f537938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f537939c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f537937a == r101.f537937a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f537938b, r101.f537938b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f537939c, r101.f537939c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f537937a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.f537938b.hashCode()) * 31;
        String r102 = this.f537939c;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "ForwardAiKnowledgeInfo(isSuccess=" + this.f537937a + ", query=" + this.f537938b + ", displayMsg=" + this.f537939c + ')';
    }

    public c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "query");
        this.f537937a = true;
        this.f537938b = r100;
        this.f537939c = r101;
    }
}
