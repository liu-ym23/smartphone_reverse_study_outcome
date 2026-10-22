package yz5;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class j extends f {
    @Override // yz5.f
    public final int b() {
        return 500;
    }

    @Override // yz5.f
    public final String c() {
        return "<";
    }

    public j() {
    }

    @Override // yz5.f
    public final Object a(Object r100, Object r101) {
        if (CastDoubleProtector.parseDouble(String.valueOf(r100)) >= CastDoubleProtector.parseDouble(String.valueOf(r101))) goto L5;
        boolean r102 = true;
    L7:
        return Boolean.valueOf(r102);
    L5:
        r102 = false;
        goto L7
    }
}
