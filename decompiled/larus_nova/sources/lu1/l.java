package lu1;

import com.bytedance.android.livesdk.dynamicstrategy.api.entity.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class l extends n<Boolean> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f510821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f510822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s f510823d;

    @Override // lu1.n, com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // lu1.n, com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Object b() {
        return Boolean.valueOf(this.f510821b);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return this.f510822c;
    }

    public l(String r100, s r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "nfaInfo");
        this.f510822c = r100;
        this.f510823d = r101;
    }
}
