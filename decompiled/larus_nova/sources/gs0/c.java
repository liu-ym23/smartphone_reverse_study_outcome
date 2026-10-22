package gs0;

import com.bytedance.android.live.platformplayer.layout.n1;
import com.bytedance.android.live.room.h;
import com.bytedance.android.livesdk.chatroom.ui.q6;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.android.livesdkapi.eventbus.ChangeCameraStreamEvent;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import is2.g;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes46.dex */
public interface c extends g {
    void A70();

    void Ap(String r100);

    boolean BE();

    void E(cy0.a r100);

    void HI(boolean r100);

    void Jy();

    void M30(int r100, String r101);

    void Mu(AbsLivePlayerView r100);

    void On();

    AbsLivePlayerView R8();

    void Rl(h r100);

    void Rz(boolean r100);

    void Tk(cs0.a r100);

    void Wu(String r100, boolean r101);

    void Xk(String r100);

    void Z70(boolean r100);

    void ZW(ChangeCameraStreamEvent r100);

    void a4(VSCameraInfo r100, boolean r101, boolean r102, boolean r103);

    boolean cn();

    void dG(Function0<? extends com.bytedance.android.live.platformplayer.b> r100);

    void ep(boolean r100);

    void gV(boolean r100);

    void hG(boolean r100);

    void hI(boolean r100);

    boolean isInteracting();

    void ji(a r100);

    void l60(boolean r100);

    com.bytedance.android.live.platformplayer.layout.c ly();

    void mj(String r100);

    void qQ();

    void rz(xj1.a r100);

    void setNestedOutside(boolean r100);

    void setUserVisibleHint(boolean r100);

    void stopRoomWithoutReleasePlayer(boolean r100);

    void tX(n1 r100);

    void tp(q6 r100);

    void uZ(cs0.c r100);

    void uu();

    void vR(boolean r100);

    void we(AbsLivePlayerView r100, String r101);

    void x6(VSCameraInfo r100, boolean r101);

    void zS(cs0.b r100);
}
