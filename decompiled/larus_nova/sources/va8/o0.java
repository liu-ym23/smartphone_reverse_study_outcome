package va8;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class o0 implements j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<ic8.w, String> f553970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<ic8.w, Boolean> f553971b;

    @Override // va8.j0
    public final String a(ic8.w r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Function1<ic8.w, Boolean> r101 = this.f553971b;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        if (r102 == false) goto L11;
        return null;
    L11:
        return this.f553970a.invoke(r100);
    L5:
        if (r101.invoke(r100).booleanValue() == true) goto L7;
        r102 = true;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o0(Function1<? super ic8.w, String> r100, Function1<? super ic8.w, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "lazyGenerator");
        this.f553970a = r100;
        this.f553971b = r101;
    }
}
