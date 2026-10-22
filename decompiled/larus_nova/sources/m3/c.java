package m3;

import com.bytedance.ai.bridge.method.bottomsheet.DoubaoBottomSheetButtonRole;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DoubaoBottomSheetButtonRole f511689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f511690b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f511689a == r101.f511689a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f511690b, r101.f511690b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f511689a.hashCode() * 31) + this.f511690b.hashCode();
    }

    public final String toString() {
        return "DoubaoBottomSheetButton(role=" + this.f511689a + ", text=" + this.f511690b + ')';
    }

    public c(DoubaoBottomSheetButtonRole r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "role");
        Intrinsics.checkNotNullParameter(r101, "text");
        this.f511689a = r100;
        this.f511690b = r101;
    }
}
