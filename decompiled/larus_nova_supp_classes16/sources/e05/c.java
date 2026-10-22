package e05;

import com.bytedance.ee.bear.document.associated.QuickLaunchBarItemType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public final QuickLaunchBarItemType a;
    public final String b;
    public final boolean c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "QuickLaunchBarItemInfo(type=" + this.a + ", docUrl=" + this.b + ", onBoardingShow=" + this.c + ')';
    }

    public final QuickLaunchBarItemType getType() {
        return this.a;
    }

    public c(QuickLaunchBarItemType r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "docUrl");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
