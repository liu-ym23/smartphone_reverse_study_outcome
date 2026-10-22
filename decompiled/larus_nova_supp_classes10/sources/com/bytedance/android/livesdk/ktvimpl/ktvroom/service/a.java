package com.bytedance.android.livesdk.ktvimpl.ktvroom.service;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.live.liveinteract.plantform.model.s0;
import com.bytedance.android.live.liveinteract.voicechat.MuteStateChecker;
import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerChangeMediaInfoContent;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import java.util.List;
import java.util.Map;
import kk0.f;
import kk0.g;
import tf0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface a {
    public static final C0028a S0 = null;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a$a, reason: collision with other inner class name */
    public static final class C0028a {
        public static final /* synthetic */ C0028a a = null;

        public C0028a() {
        }

        static {
            a = new C0028a();
        }

        public static a a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d("voice_chat_admin_context");
            if ((r0 instanceof KtvRoomGlobalDataContext) == true) goto L5;
            r0 = null;
        L5:
            KtvRoomGlobalDataContext r1 = (KtvRoomGlobalDataContext) r0;
            if (r1 == null) goto L11;
            j<a> r2 = r1.getKtvAdminService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (a) r2.getValue();
        L11:
            return null;
        }
    }

    static {
        S0 = C0028a.a;
    }

    f Bb();

    void accept(IBaseUser r1);

    void accept(String r1, String r2);

    boolean canSilenceSelf();

    jg6.a getAdminStatusCenter();

    List<s0> getHeadPointList();

    h getInteractAnimationService();

    g getLinkMicSeatCallback();

    i<ILinkPlayerInfoBridge> getLinkUserInfoCenter();

    List<ILinkPlayerInfoBridge> getOnlineUserList();

    void invite(com.bytedance.android.live.liveinteract.videolink.a r1);

    boolean isEngineOn();

    void kickOut(IBaseUser r1);

    boolean ktvWillAutoSilenceSelf();

    MuteStateChecker muteChecker();

    com.bytedance.android.live.liveinteract.voicechat.b muteManager();

    void onChangeMediaInfo(ILinkerChangeMediaInfoContent r1, int r2);

    void onSwitchSceneMessage(z0 r1);

    hg6.g rtcManger();

    void setInviteCallback(uf0.c r1);

    void setPermitCallback(uf0.d r1);

    void showInviteAndPermitDialog(boolean r1, String r2, int r3);

    void switchAudioByClient(boolean r1, List<k> r2, ClientUIInfo r3, long r4, Map<Long, ? extends RoomLinkerContent> r6, String r7);
}
