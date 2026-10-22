package yz5;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class u extends f {
    @Override // yz5.f
    public final int b() {
        return 600;
    }

    @Override // yz5.f
    public final String c() {
        return "-";
    }

    public u() {
    }

    @Override // yz5.f
    public final Object a(Object r100, Object r101) {
        return Double.valueOf(CastDoubleProtector.parseDouble(String.valueOf(r100)) - CastDoubleProtector.parseDouble(String.valueOf(r101)));
    }
}
