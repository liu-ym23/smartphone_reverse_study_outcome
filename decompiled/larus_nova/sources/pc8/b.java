package pc8;

import com.larus.bmhome.chat.bubble.floating.BubbleBannerRenderPart;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<BubbleBannerRenderPart> f528562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<BubbleBannerRenderPart> f528563b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f528562a, r101.f528562a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528563b, r101.f528563b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f528562a.hashCode() * 31) + this.f528563b.hashCode();
    }

    public final String toString() {
        return "BubbleBannerExitCompletion(requiredParts=" + this.f528562a + ", finishedParts=" + this.f528563b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Set<? extends BubbleBannerRenderPart> r100, Set<? extends BubbleBannerRenderPart> r101) {
        Intrinsics.checkNotNullParameter(r100, "requiredParts");
        Intrinsics.checkNotNullParameter(r101, "finishedParts");
        this.f528562a = r100;
        this.f528563b = r101;
    }
}
