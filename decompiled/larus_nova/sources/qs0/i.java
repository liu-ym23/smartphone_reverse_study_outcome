package qs0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes47.dex */
public interface i {
    String changeMode2String(int r100);

    Boolean chatRoomIsOpen();

    void g(long r100, IBaseUser r101);

    mv0.k.a getAudioTalkService();

    String getCurrentFunctionType();

    int getCurrentScene();

    String getFunctionType2();

    String getLinkConnectionType();

    mv0.k.d getLinkUserInfoCenter();

    mv0.k.e getVideoTalkService();

    mv0.k.b h(DataCenter r100);

    boolean isAnonymousUser(String r100);

    boolean isInLinkMicGameAnchorLinkMode();

    boolean isMicRoomHost(String r100);

    mv0.k.c linkRoomFightService();
}
