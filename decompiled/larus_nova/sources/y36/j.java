package y36;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes19.dex */
public final class j extends i<Integer> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // t36.c
    public final String a() {
        Integer r100 = (Integer) this.f565862b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    @Override // y36.i
    public final Integer c(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Integer r101 = null;
        if ((r100 instanceof Integer) == false) goto L5;
        Integer r102 = (Integer) r100;
    L6:
        boolean r103 = false;
        IntRange r104 = new IntRange(0, 100);
        if (r102 != null) goto L9;
    L11:
        if (r103 == false) goto L13;
        r101 = r102;
    L13:
        if (r101 == null) goto L15;
        return r101;
    L15:
        return (Integer) super.c(r100);
    L9:
        if (r104.contains(r102.intValue()) == false) goto L11;
        r103 = true;
        goto L11
    L5:
        r102 = null;
        goto L6
    }

    @Override // y36.i
    public final Integer d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "string");
        int r101 = CastIntegerProtector.parseInt(r100);     // Catch: Exception -> L14
        if (r101 >= 0) goto L6;
    L8:
        boolean r102 = false;
    L9:
        if (r102 == false) goto L12;
        return Integer.valueOf(r101);
    L6:
        if (r101 >= 101) goto L8;
        r102 = true;
    L12:
        return null;
    }

    public j(t36.d r100, String r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "key");
        super(null);
        b(r100, r101, r102);
    }
}
