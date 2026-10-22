package e05;

import com.bytedance.ee.bear.document.associated.QuickLaunchBarItemType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final QuickLaunchBarItemType f470638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f470639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f470640c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f470638a == r101.f470638a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f470639b, r101.f470639b) == true) goto L15;
        return false;
    L15:
        if (this.f470640c == r101.f470640c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f470638a.hashCode() * 31) + this.f470639b.hashCode()) * 31;
        if (this.f470640c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "QuickLaunchBarItemInfo(type=" + this.f470638a + ", docUrl=" + this.f470639b + ", onBoardingShow=" + this.f470640c + ')';
    }

    public final QuickLaunchBarItemType getType() {
        return this.f470638a;
    }

    public c(QuickLaunchBarItemType r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "docUrl");
        this.f470638a = r100;
        this.f470639b = r101;
        this.f470640c = r102;
    }
}
