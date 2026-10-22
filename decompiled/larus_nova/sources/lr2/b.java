package lr2;

import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.vscore_api.paidlive.c;
import com.bytedance.android.livesdk.vscore_api.paidlive.scope.g;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements o, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.b f510389a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // lr2.a
    public final boolean isPaidLive() {
        DataCenter r100 = (DataCenter) this.f510389a.a().b(vp2.a.f556611d);
        if (r100 != null) goto L7;
        return false;
    L7:
        return g.d(r100).isPaidLive();
    }

    @Override // lr2.a
    public final boolean m3() {
        DataCenter r100 = (DataCenter) this.f510389a.a().b(vp2.a.f556611d);
        if (r100 != null) goto L7;
        return false;
    L7:
        return c.a.b(g.d(r100), PaidSceneEnum.PAID_ROOM, 2);
    }

    public b(com.bytedance.android.live.revenue.core.b r100) {
        Intrinsics.checkNotNullParameter(r100, "inst");
        this.f510389a = r100;
    }

    @Override // lr2.a
    public final boolean Pe(PaidInteractEntry r100) {
        Intrinsics.checkNotNullParameter(r100, "entry");
        return g.d((DataCenter) this.f510389a.a().b(vp2.a.f556611d)).F0(r100);
    }
}
