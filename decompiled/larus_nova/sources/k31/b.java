package k31;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {
    public static final int a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$computeMoveDistance");
        int r101 = 0;
        if (r41.f.f536019a == false) goto L5;
        int r102 = com.bytedance.android.live.revenue.common.i.b(20);
    L6:
        n r103 = r100.f501635b;
        if (r103 != null) goto L9;
    L12:
        g r104 = r100.f501634a;
        if (r104 != null) goto L15;
    L21:
        return r102;
    L15:
        if (r104.f501648a == false) goto L21;
        Integer r105 = r104.f501649b;
        if (r105 == null) goto L20;
        r101 = r105.intValue();
    L20:
        return r101 + r102;
    L9:
        if (r103.f501682a != true) goto L12;
        return r103.f501683b + r102;
    L5:
        r102 = 0;
        goto L6
    }
}
