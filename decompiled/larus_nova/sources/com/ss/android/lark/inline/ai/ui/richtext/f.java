package com.ss.android.lark.inline.ai.ui.richtext;

import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f427631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f427632b;

    public f() {
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f427631a, this.f427632b});
    }

    public final String toString() {
        return "ResRevision{revision='" + this.f427631a + "', version='" + this.f427632b + "'}";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (Intrinsics.areEqual(f.class, r100.getClass()) == false) goto L17;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f427631a, r101.f427631a) == true) goto L13;
    L15:
        return false;
    L13:
        if (Intrinsics.areEqual(this.f427632b, r101.f427632b) == false) goto L15;
        return true;
    }
}
