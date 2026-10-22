package lu1;

import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class g extends n<List<? extends Long>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f510814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.dynamicstrategy.api.entity.n f510815c;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Object b() {
        return this.f510815c.longArrayVal;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return this.f510814b;
    }

    public g(String r100, com.bytedance.android.livesdk.dynamicstrategy.api.entity.n r101) {
        this.f510814b = r100;
        this.f510815c = r101;
    }
}
