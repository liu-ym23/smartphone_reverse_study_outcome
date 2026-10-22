package com.bytedance.android.livesdk.ktvimpl.realtimechorus.grouplive;

import am2.x;
import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.api.KtvCommonApi;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livehostapi.business.IMiddlewareHostSocial;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.config.mz;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IAnchorData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.GroupLiveGameConfig;
import com.bytedance.common.utility.UIUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final Map<String, Long> c = null;
    public final long a;
    public long b;

    public static final class a {
    }

    public static final class b implements IMiddlewareHostSocial.ICommonInviteParams.IClickCallback {
        public final /* synthetic */ c a;
        public final /* synthetic */ Context b;

        public final void onInvite(List<IMiddlewareHostSocial.ICommonInviteParams.ISelectedContact> r8) {
            ALogger.i("GroupLiveGameInviteUtils", "onInvite: " + r8);
            c r0 = this.a;
            Context r2 = this.b;
            r0.getClass();
            o r1 = m.i();
            if (r1 == null) goto L9;
            com.bytedance.live.datacontext.m r3 = r1.getRoom();
            if (r3 == null) goto L9;
            IRoom r4 = (IRoom) r3.getValue();
            if (r4 == null) goto L9;
            long r5 = r4.getRoomId();
        L10:
            if (r8 == null) goto L16;
            List<IMiddlewareHostSocial.ICommonInviteParams.ISelectedContact> r6 = r8;
            ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
            Iterator<T> r9 = r6.iterator();
        L13:
            if (r9.hasNext() == false) goto L15;
            r7.add(((IMiddlewareHostSocial.ICommonInviteParams.ISelectedContact) r9.next()).getUid());
            goto L13
        L15:
            String r10 = r7.toString();
        L17:
            ALogger.i("GroupLiveGameInviteUtils", "inviteFriends, roomId: " + r5 + ", toUserIds: " + r10);
            if (r10 == null) goto L24;
            if (r8 != null) goto L21;
        L23:
            RxUtilKt.i(((KtvCommonApi) com.bytedance.android.live.network.c.b().e(KtvCommonApi.class)).groupLiveChorusInviteFriend(r5, r10)).subscribe(d.a, new e(r2));
            return;
        L21:
            if (r8.isEmpty() != true) goto L23;
        L24:
            ALogger.e("GroupLiveGameInviteUtils", "inviteFriends return, cause: toUserIds is null");
            return;
        L16:
            r10 = null;
        L9:
            r5 = 0;
            goto L10
        }

        public b(c r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        c = new LinkedHashMap();
    }

    public c() {
        this.a = ((GroupLiveGameConfig) mz.a.getValue()).getInviteInterceptIntervalInMills();
    }

    public final void a(Context r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r19, "context");
        if ((System.currentTimeMillis() - this.b) >= 1000) goto L5;
        return;
    L5:
        this.b = System.currentTimeMillis();
        com.bytedance.live.datacontext.m r2 = m.i().getRoom();
        if (r2 == null) goto L15;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L15;
        if (r3.getVisibilityRange() != 16) goto L15;
        if (je0.d.D() == true) goto L15;
        f2.c("仅支持房主邀请好友", 0);
        return;
    L15:
        IMiddlewareHostSocial r4 = k.n(IMiddlewareHostSocial.class);
        IMiddlewareHostSocial.ICommonInviteParams r5 = new IMiddlewareHostSocial.ICommonInviteParams();
        com.bytedance.live.datacontext.m r6 = m.i().getRoom();
        String r7 = "";
        if (r6 == null) goto L23;
        IRoom r8 = (IRoom) r6.getValue();
        if (r8 == null) goto L23;
        IAnchorData r9 = r8.getAnchorData();
        if (r9 == null) goto L23;
        String r10 = r9.getConversationId();
        if (r10 == null) goto L23;
    L24:
        com.bytedance.live.datacontext.m r11 = m.i().getRoom();
        if (r11 == null) goto L29;
        IRoom r12 = (IRoom) r11.getValue();
        if (r12 == null) goto L29;
        Integer r13 = Integer.valueOf(r12.getVisibilityRange());
    L31:
        if (r13 != null) goto L34;
    L36:
        if (r13 != null) goto L39;
    L41:
        String r14 = "";
    L42:
        r5.setContext(r19);
        r5.setInitHeight(Integer.valueOf((int) (((double) UIUtils.getScreenHeight(jc1.a.b())) * 0.8d)));
        r5.setScene(r14);
        r5.setSelectType(IMiddlewareHostSocial.ICommonInviteParams.ISelectTypeEnum.MULTI_SELECT_RIGHT);
        r5.setBottomBtnText("邀请合唱");
        HashMap r15 = new HashMap();
        r15.put("conversation_id", r10);
        Unit r16 = Unit.INSTANCE;
        r5.setExtMap(r15);
        HashMap r17 = new HashMap();
        com.bytedance.live.datacontext.m r18 = m.i().getRoom();
        if (r18 == null) goto L47;
        IRoom r110 = (IRoom) r18.getValue();
        if (r110 == null) goto L47;
        Integer r111 = Integer.valueOf(r110.getVisibilityRange());
    L48:
        if (r111 != null) goto L51;
    L53:
        if (r111 != null) goto L56;
    L58:
        r17.put("chat_type", r7);
        r17.put("conversation_id", r10);
        r17.put("live_type", k.n(IInteractService.class).getLiveTypeForLog());
        r17.put("function_type2", k.n(IInteractService.class).getFunctionTypeForLog());
        r17.put("anchor_id", je0.d.a());
        r17.put("room_id", String.valueOf(je0.d.a0()));
        r17.put("enter_from", "co_sing");
        r17.put("enter_method", "click_co_sing");
        r5.setMobMap(r17);
        long r21 = System.currentTimeMillis();
        ArrayList r22 = new ArrayList();
        List r112 = k.n(IInteractService.class).getLinkUserInfoCenter().getOnlineUserList();
        String r113 = "GroupLiveGameInviteUtils";
        if (r112 == null) goto L73;
        List r114 = r112;
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
        Iterator r116 = r114.iterator();
    L62:
        if (r116.hasNext() == false) goto L72;
        ILinkPlayerInfoBridge r117 = (ILinkPlayerInfoBridge) r116.next();
        IBaseUser r118 = r117.getUser();
        if (r118 == null) goto L66;
        String r119 = r118.getUserId();
    L67:
        IBaseUser r120 = r117.getUser();
        if (r120 == null) goto L70;
        Intrinsics.checkNotNullParameter(r120, "$this$secUidExt");
        String r23 = r120.getCastSecUid();
    L71:
        r115.add(new IMiddlewareHostSocial.ICommonInviteParams.ISelectedContact(r119, r23));
        goto L62
    L70:
        r23 = null;
        goto L71
    L66:
        r119 = null;
        goto L67
    L72:
        ALogger.i("GroupLiveGameInviteUtils", "getDisableInviteUserList, onlineUserList: " + r115);
        r22.addAll(r115);
    L73:
        Map<String, Long> r24 = c;
        if (r24 == null) goto L90;
        LinkedHashMap r121 = new LinkedHashMap();
        Iterator r25 = ((LinkedHashMap) r24).entrySet().iterator();
    L77:
        if (r25.hasNext() == false) goto L85;
        Map.Entry r122 = (Map.Entry) r25.next();
        String r123 = r113;
        if ((r21 - ((Number) r122.getValue()).longValue()) >= this.a) goto L81;
        boolean r124 = true;
    L82:
        if (r124 == false) goto L84;
        r121.put(r122.getKey(), r122.getValue());
    L84:
        r113 = r123;
        goto L77
    L81:
        r124 = false;
        goto L82
    L85:
        String r125 = r113;
        ArrayList r26 = new ArrayList(r121.size());
        Iterator r27 = r121.entrySet().iterator();
    L87:
        if (r27.hasNext() == false) goto L89;
        r26.add(new IMiddlewareHostSocial.ICommonInviteParams.ISelectedContact((String) ((Map.Entry) r27.next()).getKey(), null));
        goto L87
    L89:
        String r28 = r125;
        ALogger.i(r28, "getDisableInviteUserList, inviteSuccessUserList: " + r26);
        r22.addAll(r26);
    L91:
        r5.setDisableUserList(r22);
        r5.setClickCallback(new b(this, r19));
        ALogger.i(r28, "showInvitePage，roomVisibilityRange: " + r13 + ", params: " + r5.getMobMap());
        Unit r1 = Unit.INSTANCE;
        r4.showNewInviteFriendActivity(r5);
        if (r20 == true) goto L106;
        j0 r29 = j0.l();
        HashMap r30 = new HashMap();
        if (gh0.a.d() == false) goto L96;
        String r31 = "anchor";
    L97:
        r30.put("user_type", r31);
        r29.sendLog("livesdk_chorus_end_panel_invite_click", r30, new Object[]{IRoom.class, x.class});
        return;
    L96:
        r31 = "guest";
        goto L97
    L106:
        return;
    L90:
        r28 = "GroupLiveGameInviteUtils";
        goto L91
    L56:
        if (17 != r111.intValue()) goto L58;
        r7 = "group";
        goto L58
    L51:
        if (16 != r111.intValue()) goto L53;
        r7 = "private";
    L47:
        r111 = null;
        goto L48
    L39:
        if (17 != r13.intValue()) goto L41;
        r14 = IMiddlewareHostSocial.ICommonInviteParams.IChatSceneTypeEnum.GROUP_PLAY_GAME_INVITE.getValue();
        goto L42
    L34:
        if (16 != r13.intValue()) goto L36;
        r14 = IMiddlewareHostSocial.ICommonInviteParams.IChatSceneTypeEnum.SINGLE_PLAY_GAME_INVITE.getValue();
    L29:
        r13 = null;
    L23:
        r10 = "";
        goto L24
    }
}
