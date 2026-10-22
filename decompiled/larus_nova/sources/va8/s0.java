package va8;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class s0 implements j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f553978a;

    public s0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f553978a = r100;
    }

    @Override // va8.j0
    public final String a(ic8.w r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        return this.f553978a;
    }
}
