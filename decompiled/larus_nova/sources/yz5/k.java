package yz5;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class k extends f {
    @Override // yz5.f
    public final int b() {
        return 700;
    }

    @Override // yz5.f
    public final String c() {
        return GXTemplateKey.GAIAX_PE;
    }

    public k() {
    }

    @Override // yz5.f
    public final Object a(Object r100, Object r101) {
        return Long.valueOf(CastLongProtector.parseLong(String.valueOf(r100)) % CastLongProtector.parseLong(String.valueOf(r101)));
    }
}
