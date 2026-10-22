package yz5;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends f {
    @Override // yz5.f
    public final int b() {
        return 400;
    }

    @Override // yz5.f
    public final String c() {
        return "==";
    }

    public c() {
    }

    @Override // yz5.f
    public final Object a(Object r100, Object r101) {
        if ((r100 instanceof Double) == true) goto L7;
        if ((r101 instanceof Double) == false) goto L13;
    L7:
        if (CastDoubleProtector.parseDouble(String.valueOf(r100)) != CastDoubleProtector.parseDouble(String.valueOf(r101))) goto L9;
        boolean r102 = true;
    L10:
        return Boolean.valueOf(r102);
    L9:
        r102 = false;
    L13:
        return Boolean.valueOf(Intrinsics.areEqual(String.valueOf(r100), String.valueOf(r101)));
    }
}
