package hq9;

import com.larus.platform.model.LarkSocialFeedPresentationMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class r2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarkSocialFeedPresentationMode f486761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v2 f486762b;

    public r2() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r2) == true) goto L8;
        return false;
    L8:
        r2 r101 = (r2) r100;
        if (this.f486761a == r101.f486761a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486762b, r101.f486762b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f486761a.hashCode() * 31;
        v2 r101 = this.f486762b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "LarkSocialFeedPresentationState(mode=" + this.f486761a + ", failedFallbackSession=" + this.f486762b + ')';
    }

    public /* synthetic */ r2(int r100) {
        this(LarkSocialFeedPresentationMode.NATIVE, null);
    }

    public r2(LarkSocialFeedPresentationMode r100, v2 r101) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        this.f486761a = r100;
        this.f486762b = r101;
    }
}
