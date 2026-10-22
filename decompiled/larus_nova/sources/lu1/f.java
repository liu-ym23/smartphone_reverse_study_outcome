package lu1;

import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class f extends n<Map<String, ? extends String>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f510812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.dynamicstrategy.api.entity.n f510813c;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Object b() {
        return this.f510813c.mapVal;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return this.f510812b;
    }

    public f(String r100, com.bytedance.android.livesdk.dynamicstrategy.api.entity.n r101) {
        this.f510812b = r100;
        this.f510813c = r101;
    }
}
