package lu1;

/* JADX INFO: loaded from: classes8.dex */
public final class e extends n<Boolean> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f510810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.dynamicstrategy.api.entity.n f510811c;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Object b() {
        return Boolean.valueOf(this.f510811c.boolVal);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return this.f510810b;
    }

    public e(String r100, com.bytedance.android.livesdk.dynamicstrategy.api.entity.n r101) {
        this.f510810b = r100;
        this.f510811c = r101;
    }
}
