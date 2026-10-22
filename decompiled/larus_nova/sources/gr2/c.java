package gr2;

import com.bytedance.android.livesdk.revenue.service.livecore.IConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public class c implements IConfig {
    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IConfig
    public final boolean G() {
        return ((f) this).f482304a.Z;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IConfig
    public final void b() {
        ((f) this).f482304a.Z = true;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IConfig
    public final void e() {
        ((f) this).f482304a.R = true;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IConfig
    public final void q0() {
        ((f) this).f482304a.f477391j0 = false;
    }

    public c(fi6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
    }
}
