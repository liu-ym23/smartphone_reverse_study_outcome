package lu1;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class o implements iu1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PropertyOwner<ju1.n> f510825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ju1.h f510826b;

    @Override // iu1.b
    public final void onDestroy() {
    }

    @Override // iu1.b
    public final ju1.h getStrategy() {
        return this.f510826b;
    }

    public o(ju1.h r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        this.f510826b = r100;
        this.f510825a = new PropertyOwner(new ju1.n(r100.a(), true));
    }

    @Override // iu1.b
    public final void a(ju1.n r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f510825a.a(r100);
    }

    @Override // iu1.b
    public final void b(ju1.n r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f510825a.a(r100);
    }
}
