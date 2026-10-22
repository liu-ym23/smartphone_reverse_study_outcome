package g0a;

import com.larus.ugc.feed.api.model.CommunityCreateLaunchModeKmp;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f479521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f479522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f479523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CommunityCreateLaunchModeKmp f479524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f479525e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f479526f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f479521a, r101.f479521a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f479522b, r101.f479522b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f479523c, r101.f479523c) == true) goto L18;
        return false;
    L18:
        if (this.f479524d == r101.f479524d) goto L21;
        return false;
    L21:
        if (this.f479525e == r101.f479525e) goto L24;
        return false;
    L24:
        if (this.f479526f == r101.f479526f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f479521a.hashCode() * 31) + this.f479522b.hashCode()) * 31) + this.f479523c.hashCode()) * 31) + this.f479524d.hashCode()) * 31;
        int r101 = 1231;
        if (this.f479525e == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f479526f == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "OpenMixCreationParamsKmp(currentPage=" + this.f479521a + ", previousPage=" + this.f479522b + ", enterMethod=" + this.f479523c + ", launchMode=" + this.f479524d + ", isEnterTemplate=" + this.f479525e + ", openNewChatPageOnSend=" + this.f479526f + ')';
    }

    public k(String r100, String r101, String r102, CommunityCreateLaunchModeKmp r103) {
        Intrinsics.checkNotNullParameter(r100, "currentPage");
        Intrinsics.checkNotNullParameter(r101, "previousPage");
        Intrinsics.checkNotNullParameter(r102, "enterMethod");
        Intrinsics.checkNotNullParameter(r103, "launchMode");
        this.f479521a = r100;
        this.f479522b = r101;
        this.f479523c = r102;
        this.f479524d = r103;
        this.f479525e = false;
        this.f479526f = true;
    }
}
