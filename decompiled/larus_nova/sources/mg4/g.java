package mg4;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
public final class g extends d {
    @Override // mg4.d
    public final float b(int r100) {
        return 0.0f;
    }

    public g() {
    }

    @Override // mg4.d
    public final void a(float r100, h r101, int r102, float r103, float r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r101, "dynamicRect");
        float r106 = r102 - r100;
        float r107 = RangesKt.coerceIn(r104, 0.0f, r103);
        if ((this.f513730d % 2) != 0) goto L5;
        r101.f513733a = 0.0f;
        r101.f513735c = r107 + 0.0f;
        return;
    L5:
        r101.f513733a = r106;
        r101.f513735c = r106 + r107;
    }
}
