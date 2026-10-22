package y36;

import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends i<Float> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // t36.c
    public final String a() {
        Float r100 = (Float) this.f565862b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    @Override // y36.i
    public final Float c(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if ((r100 instanceof Float) == false) goto L5;
        Float r101 = (Float) r100;
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        return (Float) super.c(r100);
    L5:
        r101 = null;
        goto L6
    }

    @Override // y36.i
    public final Float d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "string");
        return Float.valueOf(CastFloatProtector.parseFloat(r100));
    L5:
        return null;
    }

    public c(t36.d r100, String r101, Float r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "key");
        super(null);
        b(r100, r101, r102);
    }
}
