package uc0;

import com.bytedance.android.live.base.model.message.b4;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.i;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes46.dex */
public class a extends i {
    public a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.i
    public k getAvatarForRoomIntroMessage(b4 r100) {
        Intrinsics.checkNotNullParameter(r100, "roomIntroMessage");
        m0 r101 = r100.getBaseMessage();
        if (r101 == null) goto L15;
        long r102 = r101.getRoomId();
        ILiveRoomService r103 = (ILiveRoomService) jc1.k.f(ILiveRoomService.class);
        if (r103 == null) goto L7;
        Room r104 = r103.getCurrentRoomFromRoomContext();
    L8:
        if (r104 != null) goto L10;
        return null;
    L10:
        if (r102 != r104.getRoomId()) goto L17;
        User r105 = r104.mo8271getOwner();
        RoomAuthStatus r106 = r104.getMRoomAuthStatus();
        if (r105 != null) goto L14;
        return null;
    L14:
        return r105.getAvatarThumbByRoomAuth(r106);
    L17:
        return null;
    L7:
        r104 = null;
        goto L8
    L15:
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.i
    public String getCommentTip(DataCenter r100) {
        if (r100 == null) goto L5;
        Boolean r101 = (Boolean) r100.get("enter_from_effect_ad", Boolean.FALSE);
    L7:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == true) goto L9;
        return null;
    L9:
        return s1.B(R.string.ttlive_live_send_hint);
    L5:
        r101 = null;
        goto L7
    }
}
