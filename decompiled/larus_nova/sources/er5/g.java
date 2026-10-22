package er5;

import com.bytedance.ee.bear.workspace.HomepageListType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HomepageListType f473600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f473601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f473602c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f473600a == r101.f473600a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f473601b, r101.f473601b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f473602c, r101.f473602c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f473600a.hashCode() * 31;
        String r101 = this.f473601b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        i r105 = this.f473602c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "SelectedListInfo(type=" + this.f473600a + ", name=" + this.f473601b + ", value=" + this.f473602c + ')';
    }

    public final HomepageListType getType() {
        return this.f473600a;
    }

    public g(HomepageListType r100, String r101, i r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f473600a = r100;
        this.f473601b = r101;
        this.f473602c = r102;
    }
}
