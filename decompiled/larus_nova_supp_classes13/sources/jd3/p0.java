package jd3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p0 extends b {
    public Boolean c;

    public p0() {
        super("show_cart_entrance");
    }

    @Override // jd3.b
    public final void buildParams() {
        super.buildParams();
        if (Intrinsics.areEqual(this.c, Boolean.TRUE) == false) goto L5;
        String r0 = "1";
    L6:
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        appendParam("is_marked", r0, com.bytedance.android.ec.core.event.a.b.a.a);
        return;
    L5:
        r0 = "0";
        goto L6
    }
}
