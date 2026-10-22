package rj0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.videolink.VideoTalkAnchorContext;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerChangeMediaInfoContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerClientUIInfoChangeContent;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes46.dex */
public interface k extends e {

    /* JADX INFO: renamed from: m2, reason: collision with root package name */
    public static final a f537953m2 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f537954a = null;

        public a() {
        }

        static {
            f537954a = new a();
        }

        public static k a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d("anchor_video_talk");
            if ((r100 instanceof VideoTalkAnchorContext) == true) goto L5;
            r100 = null;
        L5:
            VideoTalkAnchorContext r101 = (VideoTalkAnchorContext) r100;
            if (r101 == null) goto L11;
            com.bytedance.live.datacontext.j<k> r102 = r101.getService();
            if (r102 != null) goto L10;
            return null;
        L10:
            return r102.getValue();
        L11:
            return null;
        }
    }

    public static final class b {
        public static /* synthetic */ void a(k r100) {
            r100.finishVideoTalk("stop_normally");
        }

        public static /* synthetic */ void d(k r100, String r101) {
            r100.im(r101, false, null);
        }

        public static /* synthetic */ void c(k r100, String r101, int r102, int r103) {
            if ((r103 & 4) == 0) goto L5;
            r102 = -1;
        L5:
            r100.v0(0, r101, r102, null);
        }

        public static /* synthetic */ void b(k r100, long r101, String r110, boolean r111, String r112) {
            r100.Ub(r101, r110, r111, r112, null);
        }

        public static /* synthetic */ void e(k r100, int r101, Integer r102, String r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r102 = 0;
        L6:
            if ((r104 & 4) == 0) goto L8;
            r103 = null;
        L8:
            r100.T1(r101, r102, r103);
        }

        public static /* synthetic */ void f(k r100, int r101, Integer r102, String r103, boolean r110) {
            r100.Cl(r101, r102, r103, r110, false);
        }

        public static /* synthetic */ void g(k r100, long r101, String r110, long r111, String r112) {
            r100.vl(r101, r110, r111, r112, null);
        }
    }

    static {
        f537953m2 = a.f537954a;
    }

    void Cl(int r100, Integer r101, String r102, boolean r103, boolean r104);

    void Kh(String r100, String r101);

    void Q();

    void Q5(String r100, boolean r101, MediaOperation.a r102);

    void Qj(String r100, String r101);

    void T1(int r100, Integer r101, String r102);

    zj0.d U1();

    void Ub(long r100, String r101, boolean r102, String r103, Function1<? super Boolean, Unit> r104);

    ei6.a Z0();

    void a2(boolean r100, List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r101, ClientUIInfo r102, long r103, Map<Long, ? extends g2> r104);

    void closeMultiEnlargePosition(long r100, List<String> r101);

    void commonWMUpdateLiveCoreAndRtcInfo(String r100);

    String currentCPositionChangeTrackData();

    int currentCPositionOpenSource();

    ILinkPlayerInfoBridge currentCPositionUser();

    String currentCPositionUserType();

    void finishVideoTalk(String r100);

    void forceReverseCamera();

    void g0(IBaseUser r100);

    void g2(int r100, int r101);

    List<ILinkPlayerInfoBridge> getCrossRoomFightLinkUserInfoList();

    tf0.h getInteractAnimationService();

    com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> getLinkUserInfoCenter();

    JsonObject getLinkmicAreaFrameInfo();

    JsonObject getLinkmicSeatListInfo();

    com.bytedance.android.live.pushstream.d getLiveStream();

    MixStreamType getMixStreamType();

    ArrayList<ILinkPlayerInfoBridge> getOnlineList();

    tf0.m getSwitchLayoutStatisticsUtils();

    void h2(gd0.d r100);

    void im(String r100, boolean r101, MediaOperation.a r102);

    void invite(com.bytedance.android.live.liveinteract.videolink.a r100);

    boolean isEngineOn();

    void j3(long r100);

    void j6(boolean r100, String r101);

    void lm(boolean r100);

    void onChangeMediaInfo(ILinkerChangeMediaInfoContent r100, int r101);

    void onSwitchSceneMessage(z0 r100);

    cj0.e paidLinkManager();

    void permit(ILinkPlayerInfoBridge r100);

    void pm();

    void replyCPosition(long r100, String r101, boolean r102);

    void s3();

    void setInviteCallback(uf0.c r100);

    void setPermitCallback(uf0.d r100);

    void u5(ILinkerClientUIInfoChangeContent r100);

    void updateFullScreenDialogShowStatus(boolean r100);

    boolean userIsCPosition(String r100);

    void v0(int r100, String r101, int r102, String r103);

    void vl(long r100, String r101, long r102, String r103, Function1<? super Boolean, Unit> r104);

    void w5();

    tf0.o windowManager();

    void z0(boolean r100, String r101);
}
