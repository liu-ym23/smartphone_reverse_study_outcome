package qp1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.vs.player.VSPlayerServiceImpl;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements com.bytedance.android.livesdk.chatroom.vs_base.player.a, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mm1.a f534328a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public b(mm1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f534328a = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.a
    public final IPlayerProgressService a(DataCenter r100) {
        return ((rk1.a) k.n(rk1.a.class)).M4(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.a
    public final void releaseService(DataCenter r100) {
        StringBuilder r101 = new StringBuilder("start do PlayerBrickService release for dataCenter:");
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        r101.append(r102);
        ALogger.w(VSPlayerServiceImpl.TAG, r101.toString());
        ((rk1.a) k.n(rk1.a.class)).E5(r100);
        return;
    L5:
        r102 = 0;
        goto L6
    }
}
