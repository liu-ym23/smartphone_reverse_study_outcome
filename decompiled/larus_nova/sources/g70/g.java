package g70;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g {
    public static final void a(f r100, j70.f r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$traceFilterDescriptor");
        Intrinsics.checkNotNullParameter(r101, "elementType");
        Intrinsics.checkNotNullParameter(r102, "reason");
        if (r100.a() == false) goto L6;
        r100.log("[" + r100.hashCode() + "]filter descriptor, type is " + r101 + ", reason is " + r102);
        return;
    }
}
