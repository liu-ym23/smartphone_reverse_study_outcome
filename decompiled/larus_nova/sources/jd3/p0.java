package jd3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class p0 extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f498413c;

    public p0() {
        super("show_cart_entrance");
    }

    @Override // jd3.b, com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        super.buildParams();
        if (Intrinsics.areEqual(this.f498413c, Boolean.TRUE) == false) goto L5;
        String r100 = "1";
    L6:
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        appendParam("is_marked", r100, com.bytedance.android.ec.core.event.a.b.C0794a.f44003a);
        return;
    L5:
        r100 = "0";
        goto L6
    }
}
