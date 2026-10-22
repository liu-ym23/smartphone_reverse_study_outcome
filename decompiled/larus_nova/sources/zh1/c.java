package zh1;

import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ls2.c> {
    @Override // gs2.a
    public final String taskID() {
        return "OwnerReleaseHandlerTask";
    }

    @Override // gs2.a
    public final void run() {
        ((ck1.c) h().a(ck1.c.class)).oi(123, h().f510525n.getString(R.string.ttlive_live_schema_anchor_can_not_jump));
        ((ik1.d) h().b("RoomSessionTaskConst_live_room_container_data")).f490248x.exitRoom();
    }

    public c() {
    }

    @Override // gs2.a
    public final LiveTaskType d() {
        return LiveTaskType.MAIN;
    }
}
