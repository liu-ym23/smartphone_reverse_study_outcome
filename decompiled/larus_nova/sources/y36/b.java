package y36;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends i<Double> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // t36.c
    public final String a() {
        Double r100 = (Double) this.f565862b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    @Override // y36.i
    public final Double c(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if ((r100 instanceof Double) == false) goto L5;
        Double r101 = (Double) r100;
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        return (Double) super.c(r100);
    L5:
        r101 = null;
        goto L6
    }

    @Override // y36.i
    public final Double d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "string");
        return Double.valueOf(CastDoubleProtector.parseDouble(r100));
    L5:
        return null;
    }

    public b(t36.d r100, String r101, Double r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "key");
        super(null);
        b(r100, r101, r102);
    }
}
