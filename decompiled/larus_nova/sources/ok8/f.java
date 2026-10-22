package ok8;

import com.larus.im.bean.message.block.ResearchProcessBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f523706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ResearchProcessBlock f523707b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f523706a == r101.f523706a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f523707b, r101.f523707b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f523706a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        ResearchProcessBlock r102 = this.f523707b;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "DeepResearchProgressCardViewInput(isFinished=" + this.f523706a + ", researchProcessBlock=" + this.f523707b + ')';
    }

    public f(boolean r100, ResearchProcessBlock r101) {
        this.f523706a = r100;
        this.f523707b = r101;
    }
}
