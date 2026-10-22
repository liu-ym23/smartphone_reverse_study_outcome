package lu1;

import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class h extends n<List<? extends String>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f510816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.dynamicstrategy.api.entity.n f510817c;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Object b() {
        return this.f510817c.stringArrayVal;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return this.f510816b;
    }

    public h(String r100, com.bytedance.android.livesdk.dynamicstrategy.api.entity.n r101) {
        this.f510816b = r100;
        this.f510817c = r101;
    }
}
