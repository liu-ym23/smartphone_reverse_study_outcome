package rj0;

import android.content.Context;
import android.view.SurfaceView;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkMatchType;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.videolink.VideoTalkGuestContext;
import com.bytedance.android.live.liveinteract.voicechat.MuteStateChecker;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.SongListItemViewHolder$bindClickListener$3;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerChangeMediaInfoContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerClientUIInfoChangeContent;
import com.bytedance.live.datacontext.DataContext;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;
import uf2.z;

/* JADX INFO: loaded from: classes46.dex */
public interface l extends f {

    /* JADX INFO: renamed from: n2, reason: collision with root package name */
    public static final a f537955n2 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f537956a = null;

        public a() {
        }

        static {
            f537956a = new a();
        }

        public static l a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d("guest_video_talk");
            if ((r100 instanceof VideoTalkGuestContext) == true) goto L5;
            r100 = null;
        L5:
            VideoTalkGuestContext r101 = (VideoTalkGuestContext) r100;
            if (r101 == null) goto L11;
            com.bytedance.live.datacontext.j<l> r102 = r101.getService();
            if (r102 != null) goto L10;
            return null;
        L10:
            return r102.getValue();
        L11:
            return null;
        }
    }

    public static final class b {
        public static /* synthetic */ void c(l r100, String r101, int r102) {
            if ((r102 & 2) == 0) goto L5;
            boolean r103 = true;
        L7:
            if ((r102 & 4) == 0) goto L9;
            r101 = null;
        L9:
            r100.cancelApply(null, r103, r101);
            return;
        L5:
            r103 = false;
            goto L7
        }

        public static /* synthetic */ void a(l r100, int r101, int r102, String r103) {
            r100.M8(r101, r102, r103, null, null);
        }

        public static /* synthetic */ void d(l r100, int r101, boolean r102, boolean r103, int r104) {
            if ((r104 & 4) == 0) goto L5;
            r103 = true;
        L5:
            r100.Cb(r101, r102, r103, null);
        }

        public static /* synthetic */ void b(l r110, int r111, int r112, String r113, String r114, Integer r115, LinkApplyType r116, int r117) {
            if ((r117 & 16) == 0) goto L5;
            Integer r100 = null;
        L7:
            if ((r117 & 32) == 0) goto L9;
            LinkApplyType r101 = null;
        L10:
            r110.kc(r111, r112, r113, r114, r100, r101, null);
            return;
        L9:
            r101 = r116;
            goto L10
        L5:
            r100 = r115;
            goto L7
        }
    }

    static {
        f537955n2 = a.f537956a;
    }

    void Cb(int r100, boolean r101, boolean r102, c r103);

    MuteStateChecker Hg();

    void Hi();

    void M8(int r100, int r101, String r102, LinkApplyType r103, tf0.b r104);

    SurfaceView R0();

    void S8(String r100, int r101, String r102);

    void Sj();

    void So(int r100, rj0.a r101, String r102, boolean r103);

    boolean T2();

    void Td(String r100, MediaOperation.a r101);

    zj0.d U1();

    void Wg(z0 r100);

    void X3(long r100, String r101, String r102, int r103);

    ei6.a Z0();

    void a2(boolean r100, List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r101, ClientUIInfo r102, long r103, Map<Long, ? extends g2> r104);

    void apply(sf0.a r100);

    void b3();

    z.a c3(String r100);

    void cancelApply(h80.a<Boolean> r100, boolean r101, String r102);

    void commonWMUpdateLiveCoreAndRtcInfo(String r100);

    String currentCPositionChangeTrackData();

    int currentCPositionOpenSource();

    ILinkPlayerInfoBridge currentCPositionUser();

    String currentCPositionUserType();

    void ec(LinkApplyType r100, LinkMatchType r101, String r102);

    void exitRoom();

    void forceReverseCamera();

    void g2(int r100, int r101);

    List<ILinkPlayerInfoBridge> getCrossRoomFightLinkUserInfoList();

    tf0.h getInteractAnimationService();

    com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> getLinkUserInfoCenter();

    JsonObject getLinkmicAreaFrameInfo();

    tf0.k getLinkmicReturnRoomParams();

    JsonObject getLinkmicSeatListInfo();

    com.bytedance.android.live.pushstream.d getLiveStream();

    int getSelfSilenceType();

    tf0.m getSwitchLayoutStatisticsUtils();

    m00.g hh();

    boolean isCurrentLinkPaid();

    boolean isEngineOn();

    void j1(int r100, Integer r101, String r102, Boolean r103);

    void j3(long r100);

    void kc(int r100, int r101, String r102, String r103, Integer r104, LinkApplyType r105, tf0.b r106);

    void li(String r100, MediaOperation.a r101);

    void n4(SurfaceView r100);

    void o2(boolean r100, SongListItemViewHolder$bindClickListener$3.c r101, sf0.a r102);

    void onChangeMediaInfo(ILinkerChangeMediaInfoContent r100, int r101);

    void onProfileCardClick(String r100, int r101, String r102);

    cj0.e paidLinkManager();

    void r0(Context r100, IRoom r101, rj0.b r102);

    void replyCPosition(long r100, String r101, boolean r102);

    void se();

    void tm(String r100, String r101);

    void tryAutoFastMatch();

    void u5(ILinkerClientUIInfoChangeContent r100);

    void updateFullScreenDialogShowStatus(boolean r100);

    boolean userIsCPosition(String r100);

    void w4();

    tf0.o windowManager();

    void z0(boolean r100, String r101);
}
