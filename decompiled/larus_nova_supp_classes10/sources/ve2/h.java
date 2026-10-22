package ve2;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements qh0.d<rh0.a> {
    public final /* synthetic */ rj0.b a;

    public h(com.bytedance.android.livesdk.ktvimpl.multichorus.d r1) {
        this.a = r1;
    }

    public final void b(BaseCheckException r3) {
        Intrinsics.checkNotNullParameter(r3, "exception");
        com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("SingleBroadcastMultiChorusStrategy", "checkPermission, failed");
        this.a.onFailed(r3);
        InteractLinkFullLinkMonitor.e(OperateType.PRE_APPLY.ordinal(), 2, r3);
    }

    public final void onResult(Object r2) {
        rh0.a r3 = (rh0.a) r2;
        com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("SingleBroadcastMultiChorusStrategy", "checkPermission, success");
        this.a.onSuccess();
        InteractLinkFullLinkMonitor.f(OperateType.PRE_APPLY.ordinal(), 2);
    }
}
