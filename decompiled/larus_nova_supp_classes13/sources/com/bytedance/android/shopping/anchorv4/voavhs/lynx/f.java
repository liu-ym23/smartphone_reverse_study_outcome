package com.bytedance.android.shopping.anchorv4.voavhs.lynx;

import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f extends VOIdentifier {
    public final String b;
    public final Map<?, ?> c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L10;
        f r4 = (f) r3;
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<?, ?> r4 = this.c;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "RefreshEpVO(name=" + this.b + ", data=" + this.c + ")";
    }

    public f(String r2, Map<?, ?> r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "data");
        this.b = r2;
        this.c = r3;
    }
}
