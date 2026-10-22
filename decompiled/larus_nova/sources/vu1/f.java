package vu1;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ju1.h f557327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final iu1.b f557328b;

    public f(ju1.h r100, iu1.b r101) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f557327a = r100;
        this.f557328b = r101;
    }
}
