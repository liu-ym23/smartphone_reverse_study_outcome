package dl0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.multianchor.model.ListUserContent;
import com.bytedance.android.live.liveinteract.multianchor.model.ListUserLinkmicAudienceContent;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListUser;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListUserInfo;
import com.bytedance.android.live.liveinteract.utils.y;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.jm;
import com.bytedance.android.livesdk.config.km;
import com.bytedance.android.livesdk.link.model.bridge.k1;
import com.bytedance.android.livesdk.link.model.bridge.l1;
import gd0.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class n {
    public static final int a() {
        return ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
    }

    public static final boolean b() {
        if (km.f120613a.getValue().booleanValue() == true) goto L6;
        return false;
    L6:
        if (jm.f120536a.getValue().booleanValue() == true) goto L11;
        if (tc0.c.h().A == null) goto L11;
        return false;
    L11:
        if (v.a(((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode(), 32) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static final boolean c() {
        return ((IUserService) jc1.k.n(IUserService.class)).user().c();
    }

    public static final String d() {
        return ((IUserService) jc1.k.n(IUserService.class)).user().n();
    }

    public static final ArrayList<LinkPlayerInfo> f(List<WaitingListUser> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toLinkPlayerInfo");
        ArrayList<LinkPlayerInfo> r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        WaitingListUser r103 = (WaitingListUser) r102.next();
        Intrinsics.checkNotNullParameter(r103, "$this$toLinkPlayerInfo");
        LinkPlayerInfo r104 = new LinkPlayerInfo();
        r104.isHasApplied = r103.isHasApplied();
        r104.mUser = r103.getUserFlex();
        r104.setModifyTime(r103.getModifyTime());
        r104.setLinkStatus(r103.getMLinkStatus());
        r104.setLinkType(r103.getMLinkType());
        r104.setRoleType(r103.getMRoleType());
        r104.userPosition = r103.getUserPosition();
        r104.silenceStatus = r103.getSilenceStatus();
        r104.mInteractIdStr = r103.getLinkmicIdStr();
        r104.songList = r103.getSongList();
        r104.orderedSongCount = r103.getOrderedSongCount();
        r104.clientVersion = r103.getClientVersion();
        r104.appId = r103.getAppId();
        r104.applyTypeNew = r103.getApplyType();
        r104.devicePlatform = r103.getDevicePlatform();
        r104.listUserType = r103.getListUserType();
        r104.listUserFromType = r103.getListUserFromType();
        WaitingListUserInfo r105 = new WaitingListUserInfo();
        r104.waitingListUserInfo = r105;
        r105.hasExpired = r103.getHasExpired();
        WaitingListUserInfo r106 = r104.waitingListUserInfo;
        r106.isMutualFollow = r103.isMutualFollow();
        WaitingListUserInfo r107 = r104.waitingListUserInfo;
        r107.applyReason = r103.getApplyReason();
        WaitingListUserInfo r108 = r104.waitingListUserInfo;
        r108.last7DaysGiftCountTxt = r103.getLast7DaysGiftCountTxt();
        r104.fuzzyFanTicket = r103.getFanTicket();
        r104.rank = r103.getRank();
        r104.isAddPrice = r103.isAddPrice();
        r104.addPriceTime = r103.getAddPriceTime();
        r104.isAnonymous = r103.isAnonymous();
        r104.micPosTagInfo = r103.getMicPosTag();
        r101.add(r104);
        goto L4
    L6:
        return r101;
    }

    public static final LinkPlayerInfo e(com.bytedance.android.livesdk.link.model.bridge.k r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$toLinkPlayerInfo");
        ILinkPlayerInfoBridge r102 = (ILinkPlayerInfoBridge) vh7.f.c(ILinkPlayerInfoBridge.class);
        r102.setUser(r100.getUser());
        r102.setInteractId(r100.getLinkMicIdStr());
        r102.setLinkStatus(r100.getStatus());
        r102.setLinkType(r100.getLinkType());
        r102.setUserPositionFlex(r100.getUserPosition());
        r102.setSilenceStatus(r100.getSilenceStatus());
        r102.setMediaType(r100.getLinkType());
        r102.setModifyTime(r100.getModifyTime());
        r102.setRoleType(r100.getRoleType());
        r102.setApplyType(r100.getApplyType());
        r102.setMatchEffect(r100.getMatchEffect());
        r102.setCityEffect(r100.getCityEffect());
        r102.setShowCityEffect(r100.getShowCityEffect());
        r102.setMIsJoinUser(r100.isJoinUser());
        r102.setMcStatus(r100.getMcStatus());
        boolean r103 = false;
        if (((int) r100.isBackground()) != 1) goto L5;
        boolean r104 = true;
    L6:
        r102.setBackground(r104);
        k1 r105 = r100.getContent();
        String r106 = null;
        if (r105 == null) goto L11;
        l1 r107 = r105.getLinkMicAudienceContent();
        if (r107 == null) goto L11;
        kd1.b r108 = r107.getMicDress();
    L12:
        r102.setMicDress(r108);
        k1 r109 = r100.getContent();
        if (r109 == null) goto L19;
        l1 r110 = r109.getLinkMicAudienceContent();
        if (r110 == null) goto L19;
        if (r110.isEnlarged() != true) goto L19;
        r103 = true;
    L19:
        r102.setEnlarged(r103);
        r102.setMicPosTagInfo(r100.getMicPosTagInfo());
        r102.setLinkRoomId(r101);
        k1 r111 = r100.getContent();
        if ((r111 instanceof ListUserContent) == true) goto L22;
        r111 = null;
    L22:
        ListUserContent r112 = (ListUserContent) r111;
        if (r112 == null) goto L27;
        ListUserLinkmicAudienceContent r113 = r112.getLinkMicAudienceContent();
        if (r113 == null) goto L27;
        com.bytedance.android.live.liveinteract.model.c r114 = (com.bytedance.android.live.liveinteract.model.c) r113.castTo(com.bytedance.android.live.liveinteract.model.c.class);
    L28:
        if (r114 == null) goto L33;
        r102.setFanTicket(r114.getFanTicket());
        int r115 = y.f78839a;
        IBaseUser r116 = r100.getUser();
        if (r116 == null) goto L32;
        r106 = r116.getIdString();
    L32:
        r102.setFanTicketDisplayStr(y.a(r106, com.bytedance.android.live.liveinteract.model.d.a(r114), r114.getFanTicketRealStr(), r114.getFanTicketFuzzyStr()));
        r102.setHost(r114.isHost());
        r102.setAppId(r114.getAppId());
        r102.setClientVersion(r114.getClientVersion());
        r102.setDevicePlatform(r114.getDevicePlatform());
        r102.setLinkedListUserInfo(com.bytedance.android.live.liveinteract.plantform.model.p.a(r114.getJoinChannelTime(), r114.getExpectLeaveTime(), r114.getCurrentTime()));
        r102.setListUserRole(r114.getListUserRole());
        r102.setPaidCount(r114.getPaidCount());
        r102.setAnonymous(r114.isAnonymous());
        r102.setSelfDisciplineDuration(r114.getSelfDisciplineDurationTime());
        r102.setSelfDisciplineTargetDuration(r114.getSelfDisciplineTargetDuration());
        r102.setThemedCompetitionRole(r114.getThemedCompetitionRole());
    L33:
        vh7.c r117 = jm2.a.d(r102);
        if (r117 == null) goto L38;
        return (LinkPlayerInfo) r117;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo");
    L27:
        r114 = null;
    L11:
        r108 = null;
        goto L12
    L5:
        r104 = false;
        goto L6
    }

    public static final ArrayList g(List r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$toLinkPlayerInfoList");
        ArrayList r102 = new ArrayList();
        Iterator r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L14;
        vh7.c r104 = jm2.a.d((com.bytedance.android.livesdk.link.model.bridge.k) r103.next());
        if (r104 == null) goto L13;
        com.bytedance.android.livesdk.link.model.bridge.k r105 = (com.bytedance.android.livesdk.link.model.bridge.k) r104;
        if (r101 == null) goto L10;
        long r106 = r101.longValue();
    L11:
        r102.add(e(r105, r106));
        goto L4
    L10:
        r106 = 0;
        goto L11
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.link.model.bridge.IAnchorLinkUserBridge");
    L14:
        return r102;
    }
}
