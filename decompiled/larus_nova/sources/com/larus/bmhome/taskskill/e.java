package com.larus.bmhome.taskskill;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wc9.e f314282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wc9.e f314283b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f314282a, r101.f314282a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f314283b, r101.f314283b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        wc9.e r100 = this.f314282a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f314283b.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "ConversationChange(old=" + this.f314282a + ", new=" + this.f314283b + ')';
    }

    public e(wc9.e r100, wc9.e r101) {
        Intrinsics.checkNotNullParameter(r101, "new");
        this.f314282a = r100;
        this.f314283b = r101;
    }
}
