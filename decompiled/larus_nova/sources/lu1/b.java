package lu1;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends n<Long> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f510804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.dynamicstrategy.api.entity.n f510805c;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Object b() {
        return Long.valueOf(this.f510805c.int64Val);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return this.f510804b;
    }

    public b(String r100, com.bytedance.android.livesdk.dynamicstrategy.api.entity.n r101) {
        this.f510804b = r100;
        this.f510805c = r101;
    }
}
