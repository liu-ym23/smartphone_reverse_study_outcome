package y36;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f extends i<Long> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // t36.c
    public final String a() {
        Long r100 = (Long) this.f565862b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    @Override // y36.i
    public final Long c(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if ((r100 instanceof Long) == false) goto L5;
        Long r101 = (Long) r100;
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        return (Long) super.c(r100);
    L5:
        r101 = null;
        goto L6
    }

    @Override // y36.i
    public final Long d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "string");
        return Long.valueOf(CastLongProtector.parseLong(r100));
    L5:
        return null;
    }

    public f(t36.d r100, String r101, Long r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "key");
        super(null);
        b(r100, r101, r102);
    }
}
