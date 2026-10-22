package iu2;

import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends com.bytedance.android.livesdk.log.filter.a<ju2.b> {
    public a() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r100) {
        super.a(r100);
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r100, Object r101) {
        ju2.b r102 = (ju2.b) r101;
        super.u(r100, r102);
        r100.putAll(r102.c());
    }
}
