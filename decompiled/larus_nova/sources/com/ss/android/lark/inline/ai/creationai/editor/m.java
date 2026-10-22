package com.ss.android.lark.inline.ai.creationai.editor;

import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f427102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f427103b;

    public m() {
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f427102a, this.f427103b});
    }

    public final String toString() {
        return "ResRevision{revision='" + this.f427102a + "', version='" + this.f427103b + "'}";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (Intrinsics.areEqual(m.class, r100.getClass()) == false) goto L17;
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f427102a, r101.f427102a) == true) goto L13;
    L15:
        return false;
    L13:
        if (Intrinsics.areEqual(this.f427103b, r101.f427103b) == false) goto L15;
        return true;
    }
}
