package yh1;

import ck1.f;
import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class d extends com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ls2.c> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final hi1.a f567547g;

    @Override // gs2.a
    public final String taskID() {
        return "SessionLoadFirstRoomTask";
    }

    @Override // com.bytedance.android.livesdk.room.Task.base.LiveTask
    public final List<String> f() {
        ArrayList r100 = new ArrayList();
        r100.add("RoomSessionTaskConst_SessionFeedInnerContextInitTask");
        return r100;
    }

    @Override // gs2.a
    public final void run() {
        ik1.d r100 = (ik1.d) h().b("RoomSessionTaskConst_live_room_container_data");
        ik1.b r101 = (ik1.b) h().b("RoomSessionTaskConst_live_room_inner_feed_data");
        f r102 = (f) h().a(f.class);
        if (r101.f490186c == null) goto L6;
        r102.cc(h().f510526o.getString(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_LIVE_SOURCE), r100.f490245u, r100.f490227c, h().f510515d, this.f567547g);
        r102.ia();
        return;
    }

    @Override // gs2.a
    public final LiveTaskType d() {
        return LiveTaskType.MAIN;
    }

    public d(hi1.a r100) {
        this.f567547g = r100;
    }
}
