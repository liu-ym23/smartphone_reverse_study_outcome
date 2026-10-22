package zj1;

import com.bytedance.android.livesdk.ability.IAbility;

/* JADX INFO: loaded from: classes7.dex */
public interface b extends IAbility {
    boolean In(String r100);

    h N6();

    boolean Oh(Runnable r100);

    void ensureMute(boolean r100);

    boolean l4();

    void mutePlayerClient(boolean r100);

    void prePullStream(boolean r100, String r101);

    void resetSmoothDoubleRenderSurface();

    as0.a roomPlayerContext();

    void stopPlayerForNextRoomPrePullStream();
}
