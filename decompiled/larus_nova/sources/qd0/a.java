package qd0;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.google.gson.JsonObject;
import gd0.p;
import hh1.w0;
import tf0.q;
import w20.xc;

/* JADX INFO: loaded from: classes46.dex */
public interface a extends rj0.d {
    boolean B(String r100);

    void D5(int r100, int r101, boolean r102, boolean r103, int r104, xc.a r105);

    boolean L();

    void a(q r100);

    int b();

    void c(Context r100, String r101);

    BaseMultiLinkWidget createVoiceChatRoomGuestWidget(w0 r100, p r101);

    boolean d(String r100, boolean r101);

    boolean e(boolean r100, String r101);

    void finishAudioTalk(String r100);

    String getFunctionType();

    JsonObject getLinkmicAreaFrameInfo();

    JsonObject getLinkmicSeatListInfo();

    JsonObject getTopLeftSeatFrameInfo();

    com.bytedance.android.live.pushstream.d guestLiveStream();

    void h(h80.a r100);

    void i(String r100);

    boolean isEngineOn();

    boolean isKtvOn();

    boolean isSelfVoiceChatRoomAudience();

    void ktvApply(KtvMusic r100, String r101, LinkApplyType r102, int r103, tf0.b r104);

    boolean ktvWillAutoSilenceSelf();

    void muteLocalAudio(boolean r100);

    void n();

    void openEmojiDialog(String r100, String r101);

    boolean p(User r100);

    boolean q(boolean r100, String r101);

    void r0(Context r100, IRoom r101, rj0.b r102);

    void switchVoiceSceneWithCheck(Context r100, String r101);

    void v();

    BaseMultiLinkWidget w(FragmentManager r100, com.bytedance.android.live.pushstream.d r101, w0 r102);
}
