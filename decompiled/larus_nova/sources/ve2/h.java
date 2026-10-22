package ve2;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class h implements qh0.d<rh0.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rj0.b f554340a;

    public h(com.bytedance.android.livesdk.ktvimpl.multichorus.d r100) {
        this.f554340a = r100;
    }

    @Override // qh0.d
    public final void b(BaseCheckException r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("SingleBroadcastMultiChorusStrategy", "checkPermission, failed");
        this.f554340a.onFailed(r100);
        InteractLinkFullLinkMonitor.e(OperateType.PRE_APPLY.ordinal(), 2, r100);
    }

    @Override // qh0.d
    public final void onResult(rh0.a r100) {
        com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("SingleBroadcastMultiChorusStrategy", "checkPermission, success");
        this.f554340a.onSuccess();
        InteractLinkFullLinkMonitor.f(OperateType.PRE_APPLY.ordinal(), 2);
    }
}
