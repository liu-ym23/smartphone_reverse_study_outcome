package mg4;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
public final class i extends d {
    @Override // mg4.d
    public final float b(int r100) {
        return r100;
    }

    public i() {
    }

    @Override // mg4.d
    public final void a(float r100, h r101, int r102, float r103, float r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r101, "dynamicRect");
        float r106 = r102;
        float r107 = r106 - r103;
        float r108 = RangesKt.coerceIn(r104, 0.0f, r103);
        if (r105 == false) goto L5;
        r101.f513733a = r106 - r108;
        r101.f513735c = r106;
        return;
    L5:
        r101.f513733a = r107;
        r101.f513735c = r107 + r108;
    }
}
