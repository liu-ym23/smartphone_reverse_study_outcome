package jd3;

import com.bytedance.android.shopping.buynow.data.model.PageScrollStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h {
    public final String a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof h) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((h) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "CloseAnchorV3Event(closeMethod=" + this.a + ")";
    }

    public h() {
        Intrinsics.checkNotNullParameter(PageScrollStatus.slide, "closeMethod");
        this.a = PageScrollStatus.slide;
    }
}
