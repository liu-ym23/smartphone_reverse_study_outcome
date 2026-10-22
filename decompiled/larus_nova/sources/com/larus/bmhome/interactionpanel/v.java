package com.larus.bmhome.interactionpanel;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f312433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<m> f312434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f312435c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.f312433a, r101.f312433a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f312434b, r101.f312434b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f312435c, r101.f312435c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f312433a.hashCode() * 31) + this.f312434b.hashCode()) * 31;
        m r101 = this.f312435c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "InteractionPanelSnapshot(scope=" + this.f312433a + ", entries=" + this.f312434b + ", active=" + this.f312435c + ')';
    }

    public v(n r100, List<m> r101, m r102) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "entries");
        this.f312433a = r100;
        this.f312434b = r101;
        this.f312435c = r102;
    }
}
