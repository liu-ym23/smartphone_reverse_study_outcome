package ry9;

import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.uaigc.bean.createpage.component.mediacontainer.UIStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f539928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f539929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ResourceItemBean f539930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final UIStatus f539931d;

    public f() {
        this(null, 0, null, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f539928a, r101.f539928a) == true) goto L12;
        return false;
    L12:
        if (this.f539929b == r101.f539929b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f539930c, r101.f539930c) == true) goto L18;
        return false;
    L18:
        if (this.f539931d == r101.f539931d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f539928a.hashCode() * 31;
        long r101 = this.f539929b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        ResourceItemBean r103 = this.f539930c;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return ((r102 + r104) * 31) + this.f539931d.hashCode();
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        return "CreationUpdateUIStatus(resourceKey=" + this.f539928a + ", progress=" + this.f539929b + ", replaceBean=" + this.f539930c + ", uiStatus=" + this.f539931d + ')';
    }

    public f(String r100, long r101, ResourceItemBean r102, UIStatus r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = UIStatus.STATUS_INIT;
    L14:
        Intrinsics.checkNotNullParameter(r100, "resourceKey");
        Intrinsics.checkNotNullParameter(r103, "uiStatus");
        this.f539928a = r100;
        this.f539929b = r101;
        this.f539930c = r102;
        this.f539931d = r103;
    }
}
