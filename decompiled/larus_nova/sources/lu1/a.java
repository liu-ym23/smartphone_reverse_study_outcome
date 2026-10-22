package lu1;

import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends n<List<? extends Double>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f510802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.dynamicstrategy.api.entity.n f510803c;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Object b() {
        return this.f510803c.doubleArrayVal;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return this.f510802b;
    }

    public a(String r100, com.bytedance.android.livesdk.dynamicstrategy.api.entity.n r101) {
        this.f510802b = r100;
        this.f510803c = r101;
    }
}
