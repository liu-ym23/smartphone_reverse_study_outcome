package y36;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d extends i<Integer> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // t36.c
    public final String a() {
        Integer r100 = (Integer) this.f565862b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    public d(Integer r100) {
        super(r100);
    }

    @Override // y36.i
    public final Integer c(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if ((r100 instanceof Integer) == false) goto L5;
        Integer r101 = (Integer) r100;
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        return (Integer) super.c(r100);
    L5:
        r101 = null;
        goto L6
    }

    @Override // y36.i
    public final Integer d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "string");
        return Integer.valueOf(CastIntegerProtector.parseInt(r100));
    L5:
        return null;
    }

    public d(t36.d r100, String r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "key");
        super(null);
        b(r100, r101, r102);
    }
}
