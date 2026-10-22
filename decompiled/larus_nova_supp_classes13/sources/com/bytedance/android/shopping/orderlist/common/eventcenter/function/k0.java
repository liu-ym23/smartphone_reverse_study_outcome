package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k0 {
    public final String a;
    public final SlcTemplateContext b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof k0) == false) goto L10;
        k0 r4 = (k0) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        SlcTemplateContext r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "TemplateContextCandidate(source=" + this.a + ", templateContext=" + this.b + ")";
    }

    public k0(String r2, SlcTemplateContext r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "templateContext");
        this.a = r2;
        this.b = r3;
    }
}
