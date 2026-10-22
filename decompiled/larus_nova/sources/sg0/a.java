package sg0;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f541760a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f541761b = null;

    static {
        int[] r100 = new int[MicSeatScene.values().length];
        f541760a = r100;
        MicSeatScene r101 = MicSeatScene.AUDIO_LINK_LARGE;
        r100[r101.ordinal()] = 1;
        MicSeatScene r102 = MicSeatScene.AUDIO_LINK_C_POSITION;
        r100[r102.ordinal()] = 2;
        MicSeatScene r103 = MicSeatScene.AUDIO_LINK_C_POSITION_V2;
        r100[r103.ordinal()] = 3;
        r100[MicSeatScene.AUDIO_LINK_STAGE_ENLARGE.ordinal()] = 4;
        int[] r104 = new int[MicSeatScene.values().length];
        f541761b = r104;
        r104[r101.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
        r104[r103.ordinal()] = 3;
    }
}
