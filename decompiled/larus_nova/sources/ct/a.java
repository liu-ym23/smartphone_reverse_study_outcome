package ct;

import com.bytedance.android.gamecp.business.gamedetail.page.root.effect.h;
import com.bytedance.ies.sve_core.Store;
import com.bytedance.ies.sve_core.w;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<String, Object, Unit> f465293d;

    @Override // com.bytedance.ies.sve_core.h
    public final void a(com.bytedance.ies.sve_core.a r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if ((r100 instanceof h) == false) goto L11;
        int r101 = ((h) r100).f55513a;
        if (r101 != 0) goto L8;
        this.f465293d.invoke("gamecpCardSlidingStateUpdate", MapsKt.mapOf(TuplesKt.to("gameDetailViewSlidingState", 0)));
        return;
    L8:
        if (r101 != 1) goto L13;
        this.f465293d.invoke("gamecpCardSlidingStateUpdate", MapsKt.mapOf(TuplesKt.to("gameDetailViewSlidingState", 1)));
        return;
    L13:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Store r100, Function2<? super String, Object, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        Intrinsics.checkNotNullParameter(r101, "sendJsEvent");
        super(r100);
        this.f465293d = r101;
    }
}
