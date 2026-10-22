package uh1;

import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;
import java.util.ArrayList;
import java.util.List;
import ls2.d;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends com.bytedance.android.livesdk.room.Task.base.a<d, ls2.c> {
    @Override // gs2.a
    public final String taskID() {
        return "LiveSessionAdLoggerInitTask";
    }

    @Override // com.bytedance.android.livesdk.room.Task.base.LiveTask
    public final List<String> f() {
        ArrayList r100 = new ArrayList();
        r100.add("RoomSessionTaskConst_SessionInitProviderAndExtraTask");
        return r100;
    }

    @Override // gs2.a
    public final void run() {
        if (h().f510528q == true) goto L6;
        a.a(h().f510519h);
        return;
    }

    public c() {
    }

    @Override // gs2.a
    public final LiveTaskType d() {
        return LiveTaskType.MAIN;
    }
}
