package dy6;

import android.os.Bundle;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c extends e<Integer> {
    @Override // dy6.e
    public final Integer b(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if ((r100 instanceof Integer) == false) goto L5;
        Integer r101 = (Integer) r100;
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        return (Integer) super.b(r100);
    L5:
        r101 = null;
        goto L6
    }

    @Override // dy6.e
    public final Integer c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "string");
        return Integer.valueOf(CastIntegerProtector.parseInt(r100));
    L5:
        return null;
    }

    public c(Bundle r100, String r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "key");
        a(r100, r101, r102);
    }
}
