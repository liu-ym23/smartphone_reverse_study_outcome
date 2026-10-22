package vj1;

import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.android.livesdk.room.state.ContainerLifecycle;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import ls2.c;
import os2.d;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends d<c> {
    @Override // os2.a
    public final c d() {
        return null;
    }

    public b() {
    }

    @Override // os2.d
    public final List<com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ?>> g(ls2.d r100, ContainerLifecycle r101, ts2.a r102) {
        if (r101 != ContainerLifecycle.ON_DESTROY) goto L15;
        IHostLiveLocalLife r103 = (IHostLiveLocalLife) k.f(IHostLiveLocalLife.class);
        if (r103 == null) goto L15;
        if (r100.f510516e == null) goto L15;
        ik1.b r104 = (ik1.b) r100.b("RoomSessionTaskConst_live_room_inner_feed_data");     // Catch: Exception -> L10
    L11:
        int r105 = 1;
        if (r104 == null) goto L14;
        r105 = 1 + r104.L;
    L14:
        r103.notifyWatchedRoomCount(r100.f510516e, r105);
    L10:
        r104 = null;
    L15:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }
}
