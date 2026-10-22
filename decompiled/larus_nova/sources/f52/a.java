package f52;

import com.tencent.open.SocialConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f475614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f475615b;

    public final int hashCode() {
        String r100 = this.f475614a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.f475615b;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "CommonPSTopViewType(desc=" + this.f475614a + ", priority=" + this.f475615b + ")";
    }

    @Override // f52.f
    public final int getPriority() {
        return this.f475615b;
    }

    public a(int r100) {
        Intrinsics.checkNotNullParameter("TestPSTopView", SocialConstants.PARAM_APP_DESC);
        this.f475614a = "TestPSTopView";
        this.f475615b = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f475614a, r101.f475614a) == true) goto L8;
        return false;
    L8:
        if (this.f475615b == r101.f475615b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }
}
