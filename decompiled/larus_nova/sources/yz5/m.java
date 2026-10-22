package yz5;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class m extends f {
    @Override // yz5.f
    public final int b() {
        return 400;
    }

    @Override // yz5.f
    public final String c() {
        return "!=";
    }

    public m() {
    }

    @Override // yz5.f
    public final Object a(Object r100, Object r101) {
        if ((r100 instanceof Double) == true) goto L8;
        if ((r101 instanceof Double) == false) goto L14;
    L8:
        if (CastDoubleProtector.parseDouble(String.valueOf(r100)) == CastDoubleProtector.parseDouble(String.valueOf(r101))) goto L10;
        boolean r102 = true;
    L11:
        return Boolean.valueOf(r102);
    L10:
        r102 = false;
    L14:
        return Boolean.valueOf(!Intrinsics.areEqual(String.valueOf(r100), String.valueOf(r101)));
    }
}
