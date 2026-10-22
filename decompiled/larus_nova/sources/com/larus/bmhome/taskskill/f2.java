package com.larus.bmhome.taskskill;

import com.larus.bmhome.actionbar.model.ReplyOption;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReplyOption f314289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReplyOption f314290b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f2) == true) goto L8;
        return false;
    L8:
        f2 r101 = (f2) r100;
        if (Intrinsics.areEqual(this.f314289a, r101.f314289a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f314290b, r101.f314290b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        ReplyOption r100 = this.f314289a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ReplyOption r104 = this.f314290b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "TaskModeStatusChange(old=" + this.f314289a + ", new=" + this.f314290b + ')';
    }

    public f2(ReplyOption r100, ReplyOption r101) {
        this.f314289a = r100;
        this.f314290b = r101;
    }
}
