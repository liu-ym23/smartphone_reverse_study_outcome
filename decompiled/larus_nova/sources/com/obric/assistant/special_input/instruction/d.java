package com.obric.assistant.special_input.instruction;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f392744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<PanelInstructionItem> f392745b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f392744a == r101.f392744a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f392745b, r101.f392745b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f392744a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f392745b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "RefreshedPanelItems(hasUpdate=" + this.f392744a + ", items=" + this.f392745b + ')';
    }

    public d(boolean r100, List<PanelInstructionItem> r101) {
        Intrinsics.checkNotNullParameter(r101, "items");
        this.f392744a = r100;
        this.f392745b = r101;
    }
}
