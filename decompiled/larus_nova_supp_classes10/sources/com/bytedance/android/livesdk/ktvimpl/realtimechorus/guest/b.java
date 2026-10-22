package com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.live.liveinteract.plantform.model.s0;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusGlobalDataContext;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.live.datacontext.DataContext;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface b {
    public static final a X0 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static b a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d("real_time_chorus_admin_context");
            if ((r0 instanceof RealTimeChorusGlobalDataContext) == true) goto L5;
            r0 = null;
        L5:
            RealTimeChorusGlobalDataContext r1 = (RealTimeChorusGlobalDataContext) r0;
            if (r1 == null) goto L11;
            com.bytedance.live.datacontext.j<b> r2 = r1.getRealTimeChorusAdminService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (b) r2.getValue();
        L11:
            return null;
        }
    }

    static {
        X0 = a.a;
    }

    void K();

    void accept(String r1, String r2);

    boolean canSilenceSelf();

    List<s0> getHeadPointList();

    tf0.h getInteractAnimationService();

    com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> getLinkUserInfoCenter();

    List<ILinkPlayerInfoBridge> getOnlineUserList();

    void invite(com.bytedance.android.live.liveinteract.videolink.a r1);

    boolean isEngineOn();

    void kickOut(IBaseUser r1);

    com.bytedance.android.live.liveinteract.voicechat.b muteManager();

    void onSwitchSceneMessage(z0 r1);

    void openEmojiDialog(String r1, String r2);

    hg6.g rtcManger();

    void setInviteCallback(uf0.c r1);

    void setPermitCallback(uf0.d r1);

    void switchAudioByClient(boolean r1, List<com.bytedance.android.livesdk.link.model.bridge.k> r2, ClientUIInfo r3, long r4, Map<Long, ? extends RoomLinkerContent> r6, String r7);
}
