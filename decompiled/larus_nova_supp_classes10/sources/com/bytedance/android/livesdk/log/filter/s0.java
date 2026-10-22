package com.bytedance.android.livesdk.log.filter;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.live.core.cache.LruCache;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.config.po0;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorData;
import com.bytedance.android.livesdkapi.depend.model.live.ClientComponent;
import com.bytedance.android.livesdkapi.depend.model.live.GameAnchorInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.MatchRoomData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.im.IMIndustryServiceInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PaidLiveConfig;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PaidLiveUIBaseConfig;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.PreviewLandScapeUtils;
import com.bytedance.android.livesdkapi.model.LiveRoomMemoryOptConfig;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.utility.StringUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s0 extends a<Room> implements u<Room> {
    public final Map<String, String> c;
    public final Map<String, String> d;
    public final Map<Long, Room> e;
    public final LruCache<Long, Room> f;
    public String g;
    public String h;
    public ym0.a i;
    public String j;
    public boolean k;
    public long l;
    public long m;
    public String n;
    public String o;
    public Pair<String, String> p;

    @Override // com.bytedance.android.livesdk.log.filter.u
    public final String n() {
        return String.valueOf(this.h);
    }

    @Override // com.bytedance.android.livesdk.log.filter.u
    public final void x() {
        this.j = "6dof";
    }

    public s0() {
        this.j = "non_6dof";
        this.k = false;
        this.l = 0;
        this.m = 0;
        this.n = BDLocationException.ERROR_TIMEOUT;
        this.o = "";
        this.c = Collections.synchronizedMap(new HashMap());
        this.d = Collections.synchronizedMap(new HashMap());
        this.e = Collections.synchronizedMap(new HashMap());
        po0 r0 = po0.a;
        if (((LiveRoomMemoryOptConfig) r0.getValue()).getEnable() == false) goto L10;
        int r1 = ((LiveRoomMemoryOptConfig) r0.getValue()).getMaxCacheCount();
        if (r1 > 0) goto L8;
        r1 = 50;
    L8:
        this.f = new LruCache(r1);
        return;
    }

    @Override // com.bytedance.android.livesdk.log.filter.u
    public final void C(ym0.a r1) {
        this.i = r1;
    }

    public final void J(Map<String, String> r7) {
        Map<String, String> r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.containsKey("home_team_state") == false) goto L20;
        String r3 = "";
        if (StringUtils.equal(this.b.get("home_team_state"), "1") == false) goto L17;
        r7.put("home_team_state", "1");
        if (this.b.get("team_id") != null) goto L11;
        String r1 = "";
    L12:
        r7.put("team_id", r1);
        if (this.b.get("team_name") == null) goto L16;
        r3 = this.b.get("team_name");
    L16:
        r7.put("team_name", r3);
        return;
    L11:
        r1 = this.b.get("team_id");
        goto L12
    L17:
        r7.put("home_team_state", BDLocationException.ERROR_TIMEOUT);
        r7.put("team_id", BDLocationException.ERROR_TIMEOUT);
        r7.put("team_name", "");
        return;
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r9) {
        super.a(r9);
        long r0 = this.m;
        String r5 = "1";
        if (r0 != 0) goto L5;
    L7:
        r9.put("is_related_room", BDLocationException.ERROR_TIMEOUT);
    L9:
        if (this.d.get(this.g) == null) goto L11;
        r9.put("request_id", this.d.get(this.g));
    L11:
        r9.put("log_pb", this.c.get(this.g));
        Pair<String, String> r1 = this.p;
        if (r1 == null) goto L18;
        Object r2 = r1.first;
        if (r2 == null) goto L18;
        if (((String) r2).equals(this.g) == false) goto L18;
        r9.put("audience_type", (String) this.p.second);
    L18:
        Map<String, String> r3 = this.b;
        if (r3 != null) goto L21;
    L23:
        Map<String, String> r4 = this.b;
        if (r4 != null) goto L26;
    L28:
        Map<String, String> r6 = this.b;
        if (r6 != null) goto L31;
    L33:
        Map<String, String> r7 = this.b;
        if (r7 != null) goto L36;
    L38:
        Map<String, String> r8 = this.b;
        if (r8 != null) goto L41;
    L43:
        ce1.d r10 = ce1.e.a;
        if (r10 != null) goto L46;
    L57:
        Map<String, String> r11 = this.b;
        if (r11 != null) goto L60;
    L62:
        J(r9);
        K(null, r9);
        r9.put("vr_6dof_type", this.j);
        Map<String, String> r12 = this.b;
        if (r12 != null) goto L65;
    L67:
        M(r9, "is_key_anchor");
        M(r9, "game_category_id");
        IHostBusiness r13 = jc1.k.f(IHostBusiness.class);
        if (r13 == null) goto L72;
        String r14 = r13.getDesktopParams();
        if (r14 == null) goto L72;
        r9.put("launch_method", r14);
    L72:
        M(r9, "is_game_live");
        M(r9, "game_tag_id");
        M(r9, "has_game_cp");
        M(r9, "dual_live_type");
        M(r9, "is_anchor");
        return;
    L65:
        if (r12.containsKey("multi_tab_room") == false) goto L67;
        r9.put("multi_tab_room", this.b.get("multi_tab_room"));
        goto L67
    L60:
        if (r11.containsKey("live_type") == false) goto L62;
        r9.put("live_type", this.b.get("live_type"));
        goto L62
    L46:
        if (r10.e() == false) goto L48;
        r9.put("liveroom_orientation", "1");
        r9.put("is_full_screen", "1");
        r9.put("vs_screen_type", "landscape");
    L50:
        if (TextUtils.isEmpty(this.o) == false) goto L52;
        this.o = r10.a();
    L52:
        r9.put("is_pad", this.o);
        r9.put("function_type", r10.c());
        if (r10.isEnableSwitchLandscape() == true) goto L56;
        r5 = BDLocationException.ERROR_TIMEOUT;
    L56:
        r9.put("is_landscape_screen_judge", r5);
        r10.f(this.g, r9);
        goto L57
    L48:
        r9.put("liveroom_orientation", BDLocationException.ERROR_TIMEOUT);
        r9.put("is_full_screen", BDLocationException.ERROR_TIMEOUT);
        r9.put("vs_screen_type", "portrait");
        goto L50
    L41:
        if (r8.containsKey("is_ecom_live") == false) goto L43;
        r9.put("is_ecom_live", this.b.get("is_ecom_live"));
        goto L43
    L36:
        if (r7.containsKey("visibility_range") == false) goto L38;
        r9.put("visibility_range", this.b.get("visibility_range"));
        goto L38
    L31:
        if (r6.containsKey("vr_type") == false) goto L33;
        r9.put("vr_type", this.b.get("vr_type"));
        goto L33
    L26:
        if (r4.containsKey("is_life") == false) goto L28;
        r9.put("is_life", this.b.get("is_life"));
        goto L28
    L21:
        if (r3.containsKey("room_type") == false) goto L23;
        r9.put("room_type", this.b.get("room_type"));
        goto L23
    L5:
        if (r0 != this.l) goto L7;
        r9.put("is_related_room", "1");
        goto L9
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void setData(Object r20) {
        Room r1 = (Room) r20;
        if (r1 != null) goto L6;
        return;
    L6:
        if (r1.getMRoomAuthStatus() == null) goto L8;
        this.k = !r1.getMRoomAuthStatus().getEnableUserCard();
    L8:
        this.g = String.valueOf(r1.getId());
        Map<String, String> r2 = this.b;
        if (r1.getId() == 0) goto L12;
        r2.put("room_id", String.valueOf(r1.getId()));
    L12:
        if (TextUtils.isEmpty(r1.getRequestId()) == true) goto L15;
        r2.put("request_id", r1.getRequestId());
    L15:
        if (TextUtils.isEmpty(r1.getLog_pb()) == true) goto L17;
        r2.put("log_pb", r1.getLog_pb());
    L19:
        if (r1.getBaseOwner() == null) goto L27;
        String r4 = r1.getBaseOwner().getIdString();
        if (r1.getBaseOwner().getFollowInfo() != null) goto L23;
    L28:
        r2.put("anchor_id", r4);
        if (r1.isVirtualLive() == false) goto L31;
        String r9 = "1";
    L32:
        r2.put("is_virtual_live", r9);
        if (TextUtils.isEmpty(r1.getSourceType()) == true) goto L36;
        r2.put("moment_room_source", r1.getSourceType());
    L36:
        if (r1.getSceneTypeInfo() == null) goto L45;
        if (r1.getSceneTypeInfo().isUnionLiveRoom() != true) goto L45;
        if (r1.getBaseOwner() == null) goto L42;
        r2.put("joint_anchor_id", r1.getBaseOwner().getIdString());
    L43:
        r2.put("is_joint_room", "1");
        goto L45
    L42:
        r2.put("joint_anchor_id", r1.getOwnerUserIdString());
    L45:
        if (r1.getSceneTypeInfo() != null) goto L47;
    L49:
        r2.put("is_life", BDLocationException.ERROR_TIMEOUT);
    L50:
        r2.put("vr_type", String.valueOf(r1.getVRType()));
        if (r1.getRoomCart() != null) goto L53;
    L55:
        r2.put("is_ecom_live", BDLocationException.ERROR_TIMEOUT);
    L56:
        r2.put("room_type", String.valueOf(r1.getStreamType().getLogStreamingType()));
        ce1.d r10 = ce1.e.a;
        if (r1.isMediaRoom() == false) goto L59;
        String r11 = "media";
    L60:
        r2.put("room_layout", r11);
        L(r1, r2);
        if (r10 == null) goto L64;
        r2.put("live_type", r10.d(r1.getStreamType()));
    L64:
        if (r1.getLiveHotSpotInfo() != null) goto L66;
    L68:
        r2.remove("trending_topic");
    L70:
        if (r1.isSimilarRoom == false) goto L72;
        r2.put("is_similar", "1");
    L73:
        String r12 = "regular";
        String r13 = "try_end";
        if (r1.getPaidLiveData() == null) goto L98;
        r2.put("is_paidlive", String.valueOf(r1.getPaidLiveData().getPaidType()));
        if (r1.isPaidRoom() == false) goto L81;
        if (r1.getPaidLiveData().getTicketSession() == null) goto L81;
        r2.put("ticket_id", String.valueOf(r1.getPaidLiveData().getTicketSession().getTicketId()));
        r2.put("ticket_type", r1.getPaidLiveData().getTicketSession().getTicketCategoryLogStr());
    L81:
        if (r1.getPaidLiveData().getDuration() != null) goto L83;
    L87:
        String r14 = "try";
    L89:
        if (r1.getPaidLiveData().getViewRight() != 9) goto L92;
        r14 = "vmember";
    L95:
        if (r1.getPaidLiveData().getMaxViewDuration() == null) goto L97;
        r2.put("try_duration", r1.getPaidLiveData().getMaxViewDuration().toString());
    L97:
        r2.put("watch_paidlive_status", r14);
    L99:
        r2.put("is_carry_paidlive", BDLocationException.ERROR_TIMEOUT);
        if (r1.isPaidSubscribeRoom() == false) goto L120;
        r2.put("is_member_live", "1");
        PrivilegeInfo r15 = (PrivilegeInfo) r1.getPaidLiveData().getPrivilegeInfo().get(String.valueOf(101));
        PaidLiveConfig r16 = r15.entityConfig;
        if (r16 == null) goto L118;
        PaidLiveUIBaseConfig r17 = r15.uiConfig;
        if (r17 == null) goto L118;
        String r18 = r4;
        if (r16.userRight.duration <= r17.duration) goto L113;
    L115:
        if (r15.entityConfig.userRight.viewRight != 0) goto L119;
        r12 = r13;
    L119:
        r2.put("watch_paidlive_status", r12);
    L121:
        Map r3 = r1.getPrivilegeInfo();
        if (r3 != null) goto L124;
        r2.put("privilege_status", "none");
    L131:
        ClientComponent r5 = r1.clientComponentData;
        if (r5 != null) goto L134;
    L138:
        r2.put("live_template_type", "-1");
    L139:
        IMIndustryServiceInfo r6 = r1.imIndustryServiceInfo;
        if (r6 != null) goto L142;
    L144:
        boolean r7 = false;
    L145:
        if (r7 == false) goto L147;
        String r8 = "1";
    L148:
        r2.put("enable_im", r8);
        if (r1.isCompoundScene() == false) goto L151;
        r2.put("cover_type", "camera");
        r2.put("frame_type", "camera");
    L152:
        String r19 = "";
        if (r1.getBaseOwner() == null) goto L159;
        r2.put("releationship", r1.getBaseOwner().getRelationship());
        if (r1.getBaseOwner().getFollowInfo() == null) goto L157;
        String r21 = String.valueOf(r1.getBaseOwner().getFollowInfo().getFollowStatus());
    L158:
        r2.put("follow_status", r21);
        goto L159
    L157:
        r21 = "";
    L159:
        MatchRoomData r22 = r1.matchRoomData;
        if (r22 != null) goto L162;
    L173:
        r2.put("home_team_state", BDLocationException.ERROR_TIMEOUT);
        r2.put("team_id", BDLocationException.ERROR_TIMEOUT);
        r2.put("team_name", "");
    L175:
        if (r2.containsKey("guide_type") == false) goto L180;
        if ("landscape_button".equals(r2.get("guide_type")) == false) goto L180;
        r2.remove("guide_type");
    L180:
        if (r2.containsKey("click_method") == false) goto L185;
        if ("landscape_button".equals(r2.get("click_method")) == false) goto L185;
        r2.remove("click_method");
    L185:
        if (r1.isMergeVSRoom() == true) goto L187;
    L198:
        r2.put("visibility_range", String.valueOf(r1.getVisibilityRange()));
        AnchorData r23 = r1.getAnchorData();
        if (r23 == null) goto L203;
        GameAnchorInfo r24 = r23.getAnchorInfo();
        if (r24 == null) goto L203;
        r2.put("is_key_anchor", r24.logIsKeyAnchor());
        r2.put("game_category_id", r24.logCategoryId());
    L203:
        r2.put("is_game_live", String.valueOf(r1.isGameRoom()));
        r2.put("game_tag_id", String.valueOf(r1.getGameTagId()));
        r2.put("has_game_cp", String.valueOf(r1.isGameCPRoom()));
        r2.put("dual_live_type", String.valueOf(r1.getCompoundSceneType()));
        if (r1.getStreamUrl() == null) goto L211;
        if (r1.getStreamUrl().getStreamOrientation() != 2) goto L208;
        String r25 = "1";
    L209:
        r2.put("is_anchor_live_mode_judge", r25);
        goto L211
    L208:
        r25 = BDLocationException.ERROR_TIMEOUT;
    L211:
        if (r1.getExtra() != null) goto L213;
    L215:
        r2.remove("xg_uid");
    L216:
        long r26 = r1.appId;
        if (r26 == 0) goto L219;
        r2.put("anchor_aid", String.valueOf(r26));
    L221:
        if (TextUtils.isEmpty(r1.getLiveReason()) == true) goto L223;
        r2.put("live_reason", String.valueOf(r1.getLiveReason()));
    L225:
        if (TextUtils.isEmpty(r1.liveRecommendInfo) == true) goto L227;
        r2.put("live_recommend_info", String.valueOf(r1.liveRecommendInfo));
    L229:
        if (r1.getStreamType() != LiveMode.MEDIA) goto L231;
        r2.put("is_media", "1");
    L232:
        LruCache<Long, Room> r27 = this.f;
        if (r27 == null) goto L235;
        r27.put(Long.valueOf(r1.getId()), r1);
    L237:
        if (t0.a(this, r18) == false) goto L240;
        r2.put("is_anchor", "1");
    L240:
        if (r1.isEcomNew() == false) goto L242;
        r2.put("is_ecom_new", "1");
        return;
    L242:
        r2.put("is_ecom_new", BDLocationException.ERROR_TIMEOUT);
        return;
    L235:
        this.e.put(Long.valueOf(r1.getId()), r1);
        goto L237
    L231:
        r2.remove("is_media");
        goto L232
    L227:
        r2.remove("live_recommend_info");
        goto L229
    L223:
        r2.remove("live_reason");
        goto L225
    L219:
        r2.remove("anchor_aid");
        goto L221
    L213:
        if (r1.getExtra().getXiguaUid() == 0) goto L215;
        r2.put("xg_uid", String.valueOf(r1.getExtra().getXiguaUid()));
        goto L216
    L187:
        if (r1.getEpisodeExtra() == null) goto L196;
        if (r1.getEpisodeExtra().getMultiTab() == null) goto L196;
        if (r1.getEpisodeExtra2().getMultiTab().getValidTabs() == null) goto L196;
        if (r1.getEpisodeExtra2().getMultiTab().getValidTabs().size() <= 1) goto L196;
        r2.put("multi_tab_room", "1");
    L196:
        if (PreviewLandScapeUtils.INSTANCE.isPreviewLandscapeEnterForVS() == false) goto L198;
        r2.put("guide_type", "landscape_button");
        r2.put("click_method", "landscape_button");
        goto L198
    L162:
        if (r22.getMatchUserInfo() == null) goto L173;
        if (r1.matchRoomData.getMatchUserInfo().getTeamInfo() == null) goto L173;
        MatchRoomData.TeamInfo r28 = r1.matchRoomData.getMatchUserInfo().getTeamInfo();
        long r110 = r28.getTeamId();
        String r29 = r28.getTeamName();
        if (r110 == 0) goto L172;
        r2.put("home_team_state", "1");
        r2.put("team_id", "" + r110);
        if (r29 == null) goto L171;
        r19 = r29;
    L171:
        r2.put("team_name", r19);
        goto L175
    L172:
        r2.put("home_team_state", BDLocationException.ERROR_TIMEOUT);
        r2.put("team_id", BDLocationException.ERROR_TIMEOUT);
        r2.put("team_name", "");
        goto L175
    L151:
        r2.remove("cover_type");
        r2.remove("frame_type");
        goto L152
    L147:
        r8 = BDLocationException.ERROR_TIMEOUT;
        goto L148
    L142:
        if (r6.isEntranceOpen() == false) goto L144;
        r7 = true;
        goto L145
    L134:
        if (r5.getTemplateId() == null) goto L138;
        if (r1.clientComponentData.getTemplateId().intValue() == 0) goto L138;
        r2.put("live_template_type", String.valueOf(r1.clientComponentData.getTemplateId()));
        goto L139
    L124:
        r2.put("privilege_status", "paid");
        Iterator r30 = r3.entrySet().iterator();
        if (r30.hasNext() == false) goto L131;
        Map.Entry r31 = (Map.Entry) r30.next();
        if (((PrivilegeInfo) r31.getValue()).paidLiveInfo == null) goto L131;
        if (((PrivilegeInfo) r31.getValue()).paidLiveInfo.viewRight != 0) goto L131;
        r2.put("privilege_status", "not_paid");
    L113:
        r13 = "try";
    L111:
        r18 = r4;
    L118:
        r18 = r4;
        r12 = "try";
        goto L119
    L120:
        r18 = r4;
        r2.put("is_member_live", BDLocationException.ERROR_TIMEOUT);
        r2.put("watch_member_live_status", "try");
        goto L121
    L92:
        if (r1.getPaidLiveData().getViewRight() == 0) goto L95;
        r14 = "regular";
        goto L95
    L83:
        if (r1.getPaidLiveData().getMaxViewDuration() == null) goto L87;
        if (r1.getPaidLiveData().getDuration().longValue() <= r1.getPaidLiveData().getMaxViewDuration().longValue()) goto L87;
        r14 = "try_end";
        goto L89
    L98:
        r2.put("is_paidlive", BDLocationException.ERROR_TIMEOUT);
        r2.put("watch_paidlive_status", "try");
        goto L99
    L72:
        r2.remove("is_similar");
        goto L73
    L66:
        if (TextUtils.isEmpty(r1.getLiveHotSpotInfo().title) == true) goto L68;
        r2.put("trending_topic", r1.getLiveHotSpotInfo().title);
        goto L70
    L59:
        r11 = "normal";
        goto L60
    L53:
        if (r1.getRoomCart().getShowCartExt() != 1) goto L55;
        r2.put("is_ecom_live", "1");
        goto L56
    L47:
        if (r1.getSceneTypeInfo().isLife() != true) goto L49;
        r2.put("is_life", "1");
        goto L50
    L31:
        r9 = BDLocationException.ERROR_TIMEOUT;
        goto L32
    L23:
        if (r1.getBaseOwner().isFollowing() == false) goto L25;
        String r32 = "1";
    L26:
        r2.put("is_fans", r32);
        goto L28
    L25:
        r32 = BDLocationException.ERROR_TIMEOUT;
        goto L26
    L27:
        r4 = r1.getOwnerUserIdString();
        goto L28
    L17:
        r2.remove("log_pb");
        goto L19
    }

    @Override // com.bytedance.android.livesdk.log.filter.u
    public final void v(Map<String, String> r2) {
        K(null, r2);
    }

    @Override // com.bytedance.android.livesdk.log.filter.u
    public final void y(String r1) {
        this.n = r1;
    }

    @Override // com.bytedance.android.livesdk.log.filter.u
    public final String z(String r2) {
        if (this.d.containsKey(r2) == true) goto L5;
        return "";
    L5:
        return this.d.get(r2);
    }

    public static void L(Room r1, Map r2) {
        if (r1.mBasisRoomData != null) goto L5;
        return;
    L5:
        if (r1.isLiveTypeAudio() == true) goto L7;
        return;
    L7:
        if (r1.mBasisRoomData.isCustomizeAudioRoom().booleanValue() == false) goto L9;
        String r3 = "customize";
    L10:
        r2.put("voice_mode", r3);
        return;
    L9:
        r3 = "head";
        goto L10
    }

    public final void K(Room r7, Map<String, String> r8) {
        long r0 = d5.c(this.g);
        if (r7 != null) goto L7;
        LruCache<Long, Room> r2 = this.f;
        if (r2 == null) goto L7;
        r7 = (Room) r2.get(Long.valueOf(r0));
    L7:
        if (r7 != null) goto L11;
        Map<Long, Room> r3 = this.e;
        if (r3 == null) goto L11;
        r7 = r3.get(Long.valueOf(r0));
    L11:
        String r1 = "1";
        if (r7 != null) goto L14;
    L23:
        String r9 = BDLocationException.ERROR_TIMEOUT;
    L24:
        r8.put("is_multi_camera_mode_on", r9);
        ym0.a r10 = this.i;
        if (r10 == null) goto L43;
        r8.put("multi_camera_serial", String.valueOf(r10.b()));
        r8.put("stream_id", String.valueOf(this.i.f()));
        boolean r4 = false;
        if (this.i.d() != 1) goto L29;
        boolean r11 = true;
    L31:
        if (this.i.c() != 1) goto L33;
        r4 = true;
    L33:
        if (r11 == true) goto L37;
        if (r4 == false) goto L37;
        String r12 = "1";
    L38:
        r8.put("is_vr_machine", r12);
        if (this.i.d() == 1) goto L42;
        r1 = BDLocationException.ERROR_TIMEOUT;
    L42:
        r8.put("is_host_camera", r1);
        return;
    L37:
        r12 = BDLocationException.ERROR_TIMEOUT;
        goto L38
    L29:
        r11 = false;
        goto L31
    L43:
        r8.put("is_vr_machine", this.n);
        return;
    L14:
        if (r7.getToolbarData() == null) goto L23;
        if (r7.getToolbarData().getToolbarDataList() == null) goto L23;
        Iterator r13 = r7.getToolbarData().getToolbarDataList().iterator();
    L19:
        if (r13.hasNext() == false) goto L23;
        if (((IToolbarComponentData) r13.next()).getId() != 42) goto L19;
        r9 = "1";
        goto L24
    }

    public final void M(Map<String, String> r2, String r3) {
        Map<String, String> r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.containsKey(r3) == false) goto L9;
        r2.put(r3, this.b.get(r3));
        return;
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r11, Object r12) {
        Room r13 = (Room) r12;
        if (r13 == null) goto L90;
        long r0 = this.m;
        String r5 = BDLocationException.ERROR_TIMEOUT;
        if (r0 != 0) goto L8;
    L10:
        r11.put("is_related_room", BDLocationException.ERROR_TIMEOUT);
    L12:
        if (r13.getId() == 0) goto L15;
        r11.put("room_id", String.valueOf(r13.getId()));
    L15:
        if (TextUtils.isEmpty(r13.getRequestId()) == true) goto L18;
        r11.put("request_id", r13.getRequestId());
    L18:
        if (TextUtils.isEmpty(r13.getLog_pb()) == true) goto L21;
        r11.put("log_pb", r13.getLog_pb());
    L21:
        if (r13.getBaseOwner() == null) goto L23;
        String r1 = r13.getBaseOwner().getIdString();
    L24:
        r11.put("anchor_id", r1);
        if (r13.isVirtualLive() == false) goto L27;
        Object r2 = "1";
    L28:
        r11.put("is_virtual_live", r2);
        if (r13.getSceneTypeInfo() == null) goto L38;
        if (r13.getSceneTypeInfo().isUnionLiveRoom() != true) goto L38;
        if (r13.getBaseOwner() == null) goto L35;
        r11.put("joint_anchor_id", String.valueOf(r13.getBaseOwner().getIdString()));
    L36:
        r11.put("is_joint_room", "1");
        goto L38
    L35:
        r11.put("joint_anchor_id", String.valueOf(r13.getOwnerUserIdString()));
    L38:
        if (r13.isSimilarRoom == false) goto L40;
        r11.put("is_similar", "1");
    L40:
        Map<String, String> r3 = this.b;
        if (r3 != null) goto L43;
    L45:
        Map<String, String> r4 = this.b;
        if (r4 != null) goto L48;
    L50:
        Map<String, String> r6 = this.b;
        if (r6 != null) goto L53;
    L55:
        r11.put("visibility_range", String.valueOf(r13.getVisibilityRange()));
    L56:
        Map<String, String> r7 = this.b;
        if (r7 == null) goto L62;
        if (r7.containsKey("is_ecom_live") == false) goto L62;
        r11.put("is_ecom_live", this.b.get("is_ecom_live"));
    L62:
        if (TextUtils.isEmpty(r13.getSourceType()) == true) goto L64;
        r11.put("moment_room_source", r13.getSourceType());
    L64:
        L(r13, r11);
        ce1.d r8 = ce1.e.a;
        if (r8 == null) goto L78;
        r11.put("live_type", r8.d(r13.getStreamType()));
        r11.put("function_type", r8.c());
        if (r8.e() == false) goto L69;
        r11.put("liveroom_orientation", "1");
        r11.put("is_full_screen", "1");
        r11.put("vs_screen_type", "landscape");
    L71:
        if (TextUtils.isEmpty(this.o) == false) goto L73;
        this.o = r8.a();
    L73:
        r11.put("is_pad", this.o);
        if (r8.isEnableSwitchLandscape() == false) goto L76;
        r5 = "1";
    L76:
        r11.put("is_landscape_screen_judge", r5);
        r8.f(String.valueOf(r13.getId()), r11);
        goto L78
    L69:
        r11.put("liveroom_orientation", BDLocationException.ERROR_TIMEOUT);
        r11.put("is_full_screen", BDLocationException.ERROR_TIMEOUT);
        r11.put("vs_screen_type", "portrait");
    L78:
        if (r13.getLiveHashTagInfo() == null) goto L80;
        r11.put("tag_id", r13.getLiveHashTagInfo().id);
    L80:
        J(r11);
        K(r13, r11);
        r11.put("vr_6dof_type", this.j);
        IHostBusiness r9 = jc1.k.f(IHostBusiness.class);
        if (r9 == null) goto L85;
        String r10 = r9.getDesktopParams();
        if (r10 == null) goto L85;
        r11.put("launch_method", r10);
    L85:
        r11.put("is_game_live", String.valueOf(r13.isGameRoom()));
        r11.put("game_tag_id", String.valueOf(r13.getGameTagId()));
        r11.put("has_game_cp", String.valueOf(r13.isGameCPRoom()));
        r11.put("dual_live_type", String.valueOf(r13.getCompoundSceneType()));
        if (t0.a(this, r1) == false) goto L89;
        r11.put("is_anchor", "1");
        return;
    L89:
        return;
    L53:
        if (r6.containsKey("visibility_range") == false) goto L55;
        r11.put("visibility_range", this.b.get("visibility_range"));
        goto L56
    L48:
        if (r4.containsKey("vr_type") == false) goto L50;
        r11.put("vr_type", this.b.get("vr_type"));
        goto L50
    L43:
        if (r3.containsKey("is_life") == false) goto L45;
        r11.put("is_life", this.b.get("is_life"));
        goto L45
    L27:
        r2 = BDLocationException.ERROR_TIMEOUT;
        goto L28
    L23:
        r1 = r13.getOwnerUserIdString();
        goto L24
    L8:
        if (r0 != this.l) goto L10;
        r11.put("is_related_room", "1");
        goto L12
    }
}
