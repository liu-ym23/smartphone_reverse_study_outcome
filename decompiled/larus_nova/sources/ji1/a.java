package ji1;

import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import ik1.b;
import java.util.ArrayList;
import java.util.List;
import ls2.c;
import ls2.d;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends com.bytedance.android.livesdk.room.Task.base.a<d, c> {
    @Override // gs2.a
    public final String taskID() {
        return "LiveSessionLoggerInitTask";
    }

    @Override // com.bytedance.android.livesdk.room.Task.base.LiveTask
    public final List<String> f() {
        ArrayList r100 = new ArrayList();
        r100.add("RoomSessionTaskConst_SessionInitProviderAndExtraTask");
        return r100;
    }

    @Override // gs2.a
    public final void run() {
        ik1.d r100 = (ik1.d) h().b("RoomSessionTaskConst_live_room_container_data");
        b r101 = (b) h().b("RoomSessionTaskConst_live_room_inner_feed_data");     // Catch: Exception -> L5
    L7:
        if (h().f510528q == true) goto L12;
        String r102 = h().f510526o.getString(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_LIVE_SOURCE);
        hi1.b.a(h(), r101, r100, r102, r100.f490227c);
        return;
    L12:
        return;
    L5:
        r101 = null;
        goto L7
    }

    public a() {
    }

    @Override // gs2.a
    public final LiveTaskType d() {
        return LiveTaskType.MAIN;
    }
}
