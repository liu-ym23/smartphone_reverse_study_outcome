package yz5;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes19.dex */
public final class s extends f {
    @Override // yz5.f
    public final int b() {
        return 600;
    }

    @Override // yz5.f
    public final String c() {
        return Marker.ANY_NON_NULL_MARKER;
    }

    public s() {
    }

    @Override // yz5.f
    public final Object a(Object r100, Object r101) {
        return Double.valueOf(CastDoubleProtector.parseDouble(String.valueOf(r100)) + CastDoubleProtector.parseDouble(String.valueOf(r101)));
    }
}
