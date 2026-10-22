package v61;

import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f553382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NextLiveData<Boolean> f553383b;

    public d() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (this.f553382a == r101.f553382a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f553383b, r101.f553383b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r100 = this.f553382a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        NextLiveData<Boolean> r103 = this.f553383b;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "PreLoadingConfig(isPreLoading=" + this.f553382a + ", preLoadingResult=" + this.f553383b + ")";
    }

    public d(int r100) {
        NextLiveData<Boolean> r101 = new NextLiveData();
        Intrinsics.checkNotNullParameter(r101, "preLoadingResult");
        this.f553382a = false;
        this.f553383b = r101;
    }
}
