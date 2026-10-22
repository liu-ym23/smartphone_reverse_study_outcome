package si1;

import com.bytedance.android.live.core.setting.l3;
import com.bytedance.android.live.core.setting.p7;
import com.bytedance.android.livehostapi.business.IHostFeed;
import com.bytedance.android.livesdk.model.a1;
import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;
import jc1.k;
import ls2.c;
import ls2.d;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends com.bytedance.android.livesdk.room.Task.base.a<d, c> {
    @Override // gs2.a
    public final String taskID() {
        return "TabPreLoadApiTask";
    }

    @Override // gs2.a
    public final void run() {
        boolean r100 = a1.f153924a;
        boolean r101 = false;
        if (l3.f65349a.getValue().booleanValue() == true) goto L6;
    L12:
        if (r101 == false) goto L16;
        IHostFeed r102 = (IHostFeed) k.f(IHostFeed.class);
        if (r102 == null) goto L16;
        r102.requestTabApi();
    L16:
        a1.f153925b = true;
        return;
    L6:
        if (a1.f153925b == true) goto L12;
        if (a1.f153924a == true) goto L12;
        if (p7.f65386a.getValue().a() != 1) goto L12;
        a1.b("enter_room");
        r101 = true;
        goto L12
    }

    public a() {
    }

    @Override // gs2.a
    public final LiveTaskType d() {
        return LiveTaskType.MAIN;
    }
}
