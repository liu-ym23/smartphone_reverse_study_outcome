package hda;

import com.obric.assistant.cocreationreview.modules.memory.DiffType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DiffType f484649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f484650b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d1) == true) goto L8;
        return false;
    L8:
        d1 r101 = (d1) r100;
        if (this.f484649a == r101.f484649a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f484650b, r101.f484650b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f484649a.hashCode() * 31) + this.f484650b.hashCode();
    }

    public final String toString() {
        return "MemoryReviewTextDiffSegment(type=" + this.f484649a + ", text=" + this.f484650b + ')';
    }

    public final DiffType getType() {
        return this.f484649a;
    }

    public d1(DiffType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "text");
        this.f484649a = r100;
        this.f484650b = r101;
    }
}
