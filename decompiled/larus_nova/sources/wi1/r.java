package wi1;

import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes7.dex */
public final class r extends com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ik1.b> {
    @Override // gs2.a
    public final String taskID() {
        return "RoomSessionTaskConst_session_inner_feed_reset_task";
    }

    @Override // gs2.a
    public final void run() {
        ls2.d r100 = h();
        if (r100 == null) goto L5;
        ((ck1.f) r100.a(ck1.f.class)).iq();
    L5:
        ui1.d.a(g());
        ls2.d r101 = h();
        if (r101 == null) goto L8;
        Bundle r102 = r101.f510526o;
    L9:
        if (r102 == null) goto L23;
        Bundle r103 = m0.a(r102);
        if (r103 == null) goto L14;
        Bundle r104 = new Bundle();
        r104.putAll(r103);
        r104.remove(ILiveRoomPlayFragmentConstant.EXTRA_BACK_PRE_ROOM_EXTRA);
        r103.putBundle("copy_extra", r104);
        if (Logger.debug() == false) goto L22;
        Logger.d("BackToRoomDataUtils", "copy:" + r104.toString());
        return;
    L22:
        return;
    L14:
        if (Logger.debug() == false) goto L20;
        Logger.d("BackToRoomDataUtils", "copy:null");
        return;
    L20:
        return;
    L23:
        return;
    L8:
        r102 = null;
        goto L9
    }

    public r() {
    }

    @Override // gs2.a
    public final LiveTaskType d() {
        return LiveTaskType.BOOT;
    }
}
