package k41;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.android.livesdk.revenue.service.livecore.IRegion;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a<T> f501734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f501735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f501736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Matrix f501737d;

    public final RectF a(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, "rectF");
        Matrix r101 = this.f501737d;
        RectF r102 = new RectF(r100);
        r101.mapRect(r102);
        return r102;
    }

    public final void b(IRegion r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, EffectConfiguration.KEY_REGION);
        Matrix r102 = this.f501736c;
        RectF r103 = this.f501734a.b(r101);
        if (r103 != null) goto L6;
        r100.D3(0.1d, 0.1d);
        r100.C4(1.0d, 1.0d);
        return;
    L6:
        RectF r104 = new RectF(r103);
        r102.mapRect(r104);
        r100.D3(r104.width(), r104.height());
        r100.C4(r104.left, r104.top);
    }

    public b(a<T> r100, RectF r101, Matrix r102, Matrix r103) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        Intrinsics.checkNotNullParameter(r102, "matrix2Canvas");
        Intrinsics.checkNotNullParameter(r103, "matrix2Sei");
        this.f501734a = r100;
        this.f501735b = r101;
        this.f501736c = r102;
        this.f501737d = r103;
    }
}
