package oi1;

import android.os.Bundle;
import com.bytedance.android.live.livepullstream.api.IPullStreamService;
import com.bytedance.android.livesdk.config.bn;
import com.bytedance.android.livesdk.config.dn;
import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;
import jc1.k;
import ls2.d;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends com.bytedance.android.livesdk.room.Task.base.a<d, ls2.c> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f523359g;

    @Override // gs2.a
    public final String taskID() {
        return "PlayerPrePullStreamTask";
    }

    @Override // gs2.a
    public final void run() {
        d r100 = h();
        if (r100 != null) goto L5;
        return;
    L5:
        if (dn.f120050a.getValue().booleanValue() == false) goto L7;
        return;
    L7:
        if (bn.f119885a.getValue().booleanValue() == false) goto L9;
        return;
    L9:
        if (this.f523359g == true) goto L22;
        Bundle r101 = r100.f510526o;
        if (r101 == null) goto L13;
        r101.putBoolean("is_LiveRoomFragment", true);
    L13:
        IPullStreamService r102 = (IPullStreamService) k.f(IPullStreamService.class);
        if (r102 == null) goto L23;
        gl0.c r103 = r102.getLivePlayerOptimizer();
        if (r103 == null) goto L24;
        com.bytedance.android.live.livepullstream.service.c r104 = (com.bytedance.android.live.livepullstream.service.c) r103;
        r104.c(r100.f510515d, r100.f510526o);
        return;
    L24:
        return;
    L23:
        return;
    }

    @Override // gs2.a
    public final LiveTaskType d() {
        return LiveTaskType.MAIN;
    }

    public a(boolean r100) {
        this.f523359g = r100;
    }
}
