package ew4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f474551a;

    public g() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f474551a, ((g) r100).f474551a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f474551a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "CommentVoiceToggleIconConfig(keyboardToggleIconRes=" + this.f474551a + ')';
    }

    public g(Integer r100) {
        this.f474551a = r100;
    }
}
