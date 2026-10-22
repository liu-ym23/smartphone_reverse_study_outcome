package com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2;

import android.text.Editable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f429020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Editable f429021b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f429020a == r101.f429020a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f429021b, r101.f429021b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f429020a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        Editable r102 = this.f429021b;
        if (r102 != null) goto L5;
        int r103 = 0;
    L7:
        return r101 + r103;
    L5:
        r103 = r102.hashCode();
        goto L7
    }

    public final String toString() {
        return "EditableWrapper(id=" + this.f429020a + ", editable=" + this.f429021b + ')';
    }

    public b(long r100, Editable r101) {
        this.f429020a = r100;
        this.f429021b = r101;
    }
}
