package qg0;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f532861a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f532862b = null;

    static {
        int[] r100 = new int[MicSeatScene.values().length];
        f532861a = r100;
        MicSeatScene r101 = MicSeatScene.AUDIO_LINK_C_POSITION;
        r100[r101.ordinal()] = 1;
        MicSeatScene r102 = MicSeatScene.AUDIO_LINK_C_POSITION_V2;
        r100[r102.ordinal()] = 2;
        MicSeatScene r103 = MicSeatScene.AUDIO_LINK_HAMLET_AVATAR;
        r100[r103.ordinal()] = 3;
        MicSeatScene r104 = MicSeatScene.AUDIO_LINK_STAGE_ENLARGE;
        r100[r104.ordinal()] = 4;
        r100[MicSeatScene.AUDIO_LINK_HEAD_RADIO.ordinal()] = 5;
        int[] r105 = new int[MicSeatScene.values().length];
        f532862b = r105;
        r105[r101.ordinal()] = 1;
        r105[r102.ordinal()] = 2;
        r105[r103.ordinal()] = 3;
        r105[r104.ordinal()] = 4;
    }
}
