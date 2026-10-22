package gz3;

import com.bytedance.awemeopen.apps.framework.feed.profile.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public final String a;
    public final f.a b;
    public final int c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        int r0 = this.a.hashCode() * 31;
        f.a r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.c;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "AosProfileFeedSelectedIndexEvent(userOpenId=" + this.a + ", profileType=" + this.b + ", selectedIndex=" + this.c + ')';
    }

    public d(String r2, f.a r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "userOpenId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
