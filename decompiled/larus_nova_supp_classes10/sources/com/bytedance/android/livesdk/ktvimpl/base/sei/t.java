package com.bytedance.android.livesdk.ktvimpl.base.sei;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.message.model.RegionList;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.feed.data.FeedViewRoomInfoStore;
import com.bytedance.common.utility.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t {
    public static List<ILinkPlayerInfoBridge> a;
    public static IInteractService b;

    static {
        a = new ArrayList();
    }

    public static final IInteractService g() {
        if (b != null) goto L6;
        b = jc1.k.f(IInteractService.class);
    L6:
        return b;
    }

    public static OrderedSongDataContext j() {
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isKtvMode() == false) goto L6;
        return KtvModeOrderedSongDataContext.Companion.getContext();
    L6:
        return KtvComponentOrderedSongDataContext.Companion.getContext();
    }

    public static final String f() {
        com.bytedance.live.datacontext.m r0 = o3.f().getRoom();
        String r1 = "";
        if (r0 == null) goto L8;
        IRoom r2 = (IRoom) r0.getValue();
        if (r2 == null) goto L8;
        String r3 = r2.getOwnerUserIdString();
        if (r3 == null) goto L8;
    L9:
        IInteractService r4 = g();
        if (r4 == null) goto L20;
        FeedViewRoomInfoStore r5 = r4.getFeedViewRoomInfoStore();
        if (r5 == null) goto L20;
        IRoom r6 = r5.getRoom();
        if (r6 == null) goto L20;
        String r7 = r6.getOwnerUserIdString();
        if (r7 == null) goto L20;
        r1 = r7;
    L20:
        if (TextUtils.isEmpty(r3) == true) goto L22;
        return r3;
    L22:
        return r1;
    L8:
        r3 = "";
        goto L9
    }

    public static final List<ILinkPlayerInfoBridge> i() {
        IInteractService r0 = g();
        if (r0 == null) goto L7;
        com.bytedance.android.live.liveinteract.plantform.base.i r1 = r0.getLinkUserInfoCenter();
        if (r1 == null) goto L7;
        List r2 = r1.getOnlineUserList();
    L9:
        if (Lists.notEmpty(r2) == true) goto L11;
        IInteractService r3 = g();
        if (r3 == null) goto L42;
        FeedViewRoomInfoStore r4 = r3.getFeedViewRoomInfoStore();
        if (r4 == null) goto L42;
        List r5 = r4.getOnlineList();
    L44:
        if (Lists.notEmpty(r5) == false) goto L51;
        IInteractService r6 = g();
        if (r6 == null) goto L60;
        FeedViewRoomInfoStore r7 = r6.getFeedViewRoomInfoStore();
        if (r7 != null) goto L62;
        return null;
    L62:
        return r7.getOnlineList();
    L60:
        return null;
    L51:
        return a;
    L42:
        r5 = null;
        goto L44
    L11:
        if (a.isEmpty() == false) goto L32;
        IInteractService r8 = g();
        if (r8 == null) goto L30;
        com.bytedance.android.live.liveinteract.plantform.base.i r9 = r8.getLinkUserInfoCenter();
        if (r9 == null) goto L30;
        List r10 = r9.getOnlineUserList();
        if (r10 == null) goto L30;
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L20:
        if (r12.hasNext() == false) goto L28;
        Object r13 = r12.next();
        IBaseUser r14 = ((ILinkPlayerInfoBridge) r13).getUser();
        if (r14 == null) goto L24;
        String r15 = r14.getIdString();
    L26:
        if (Intrinsics.areEqual(r15, f()) == false) goto L20;
        r11.add(r13);
        goto L20
    L24:
        r15 = null;
        goto L26
    L28:
        List<ILinkPlayerInfoBridge> r16 = CollectionsKt.toMutableList(r11);
        if (r16 == null) goto L30;
    L31:
        a = r16;
    L30:
        r16 = new ArrayList();
    L32:
        IInteractService r17 = g();
        if (r17 == null) goto L57;
        com.bytedance.android.live.liveinteract.plantform.base.i r18 = r17.getLinkUserInfoCenter();
        if (r18 != null) goto L59;
        return null;
    L59:
        return r18.getOnlineUserList();
    L57:
        return null;
    L7:
        r2 = null;
        goto L9
    }

    public static final long h(String r9) {
        Intrinsics.checkNotNullParameter(r9, "userId");
        List<ILinkPlayerInfoBridge> r0 = i();
        Object r5 = null;
        if (r0 == null) goto L29;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L23;
        Object r6 = r1.next();
        ILinkPlayerInfoBridge r7 = (ILinkPlayerInfoBridge) r6;
        IBaseUser r8 = r7.getUser();
        if (r8 == null) goto L10;
        String r10 = r8.getIdString();
    L12:
        if (TextUtils.isEmpty(r10) == true) goto L20;
        IBaseUser r11 = r7.getUser();
        if (r11 == null) goto L16;
        String r12 = r11.getIdString();
    L18:
        if (Intrinsics.areEqual(r12, r9) == false) goto L20;
        boolean r13 = true;
    L21:
        if (r13 == false) goto L6;
    L24:
        ILinkPlayerInfoBridge r14 = (ILinkPlayerInfoBridge) r6;
        if (r14 == null) goto L29;
        Long r2 = r14.getKSongUid();
        if (r2 == null) goto L29;
        long r15 = r2.longValue();
    L31:
        if (r15 == 0) goto L33;
        return r15;
    L33:
        ChorusContext.a r3 = ChorusContext.Companion;
        if (r3.c() == false) goto L71;
        ChorusContext r4 = r3.getContext();
        if (r4 == null) goto L105;
        com.bytedance.live.datacontext.n<List<MusicPanel>> r16 = r4.getChorusSelectedSongList();
        if (r16 == null) goto L106;
        List r17 = (List) r16.getValue();
        if (r17 == null) goto L107;
        Iterator r18 = r17.iterator();
    L43:
        if (r18.hasNext() == false) goto L64;
        Object r19 = r18.next();
        MusicPanel r20 = (MusicPanel) r19;
        OrderInfo r21 = r20.d();
        if (r21 == null) goto L49;
        InteractiveSongUserInfo r22 = r21.getTopUser();
        if (r22 == null) goto L49;
        String r23 = r22.getIdString();
    L51:
        if (TextUtils.isEmpty(r23) == true) goto L61;
        OrderInfo r24 = r20.d();
        if (r24 == null) goto L57;
        InteractiveSongUserInfo r25 = r24.getTopUser();
        if (r25 == null) goto L57;
        String r26 = r25.getIdString();
    L59:
        if (Intrinsics.areEqual(r26, r9) == false) goto L61;
        boolean r27 = true;
    L62:
        if (r27 == false) goto L43;
        r5 = r19;
    L57:
        r26 = null;
    L61:
        r27 = false;
    L49:
        r23 = null;
    L64:
        MusicPanel r28 = (MusicPanel) r5;
        if (r28 == null) goto L108;
        OrderInfo r29 = r28.d();
        if (r29 == null) goto L109;
        InteractiveSongUserInfo r30 = r29.getTopUser();
        if (r30 != null) goto L111;
        return 0;
    L111:
        return r30.getKSongUid().longValue();
    L109:
        return 0;
    L108:
        return 0;
    L107:
        return 0;
    L106:
        return 0;
    L105:
        return 0;
    L71:
        OrderedSongDataContext r31 = j();
        if (r31 == null) goto L112;
        List<SongUniqueInfo> r32 = r31.getKtvPublicSongUniqueInfoList();
        if (r32 == null) goto L113;
        Iterator<T> r33 = r32.iterator();
    L77:
        if (r33.hasNext() == false) goto L86;
        Object r34 = r33.next();
        SongUniqueInfo r35 = (SongUniqueInfo) r34;
        if (TextUtils.isEmpty(r35.getUserId()) == false) goto L81;
    L83:
        boolean r36 = false;
    L84:
        if (r36 == false) goto L77;
        r5 = r34;
        goto L86
    L81:
        if (Intrinsics.areEqual(r35.getUserId(), r9) == false) goto L83;
        r36 = true;
    L86:
        SongUniqueInfo r37 = (SongUniqueInfo) r5;
        if (r37 != null) goto L89;
        return 0;
    L89:
        return r37.getKSongUid();
    L113:
        return 0;
    L112:
        return 0;
    L16:
        r12 = null;
    L20:
        r13 = false;
        goto L21
    L10:
        r10 = null;
        goto L12
    L23:
        r6 = null;
    L29:
        r15 = 0;
        goto L31
    }

    public static final String k(long r12) {
        List<ILinkPlayerInfoBridge> r0 = i();
        Object r6 = null;
        if (r0 == null) goto L28;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L21;
        Object r7 = r1.next();
        ILinkPlayerInfoBridge r8 = (ILinkPlayerInfoBridge) r7;
        Long r9 = r8.getKSongUid();
        if (r9 != null) goto L11;
    L12:
        Long r10 = r8.getKSongUid();
        if (r10 != null) goto L16;
    L18:
        boolean r11 = false;
    L19:
        if (r11 == false) goto L6;
    L22:
        ILinkPlayerInfoBridge r13 = (ILinkPlayerInfoBridge) r7;
        if (r13 == null) goto L28;
        IBaseUser r2 = r13.getUser();
        if (r2 == null) goto L28;
        String r3 = r2.getIdString();
        if (r3 == null) goto L28;
    L30:
        if (TextUtils.isEmpty(r3) == true) goto L32;
        return r3;
    L32:
        ChorusContext.a r4 = ChorusContext.Companion;
        if (r4.c() == false) goto L68;
        ChorusContext r5 = r4.getContext();
        if (r5 == null) goto L105;
        com.bytedance.live.datacontext.n<List<MusicPanel>> r14 = r5.getChorusSelectedSongList();
        if (r14 == null) goto L106;
        List r15 = (List) r14.getValue();
        if (r15 == null) goto L107;
        Iterator r16 = r15.iterator();
    L42:
        if (r16.hasNext() == false) goto L59;
        Object r17 = r16.next();
        MusicPanel r18 = (MusicPanel) r17;
        OrderInfo r19 = r18.d();
        if (r19 == null) goto L49;
        InteractiveSongUserInfo r20 = r19.getTopUser();
        if (r20 == null) goto L49;
        if (r20.getKSongUid().longValue() != 0) goto L49;
    L56:
        boolean r21 = false;
    L57:
        if (r21 == false) goto L42;
        r6 = r17;
    L49:
        OrderInfo r22 = r18.d();
        if (r22 == null) goto L56;
        InteractiveSongUserInfo r23 = r22.getTopUser();
        if (r23 == null) goto L56;
        if (r23.getKSongUid().longValue() != r12) goto L56;
        r21 = true;
    L59:
        MusicPanel r24 = (MusicPanel) r6;
        if (r24 == null) goto L108;
        OrderInfo r110 = r24.d();
        if (r110 == null) goto L109;
        InteractiveSongUserInfo r111 = r110.getTopUser();
        if (r111 == null) goto L110;
        String r112 = r111.getIdString();
        if (r112 != null) goto L89;
        return "";
    L89:
        return r112;
    L110:
        return "";
    L109:
        return "";
    L108:
        return "";
    L107:
        return "";
    L106:
        return "";
    L105:
        return "";
    L68:
        OrderedSongDataContext r25 = j();
        if (r25 == null) goto L111;
        List<SongUniqueInfo> r26 = r25.getKtvPublicSongUniqueInfoList();
        if (r26 == null) goto L112;
        Iterator<T> r27 = r26.iterator();
    L74:
        if (r27.hasNext() == false) goto L83;
        Object r28 = r27.next();
        SongUniqueInfo r29 = (SongUniqueInfo) r28;
        if (r29.getKSongUid() != 0) goto L78;
    L80:
        boolean r30 = false;
    L81:
        if (r30 == false) goto L74;
        r6 = r28;
        goto L83
    L78:
        if (r29.getKSongUid() != r12) goto L80;
        r30 = true;
    L83:
        SongUniqueInfo r31 = (SongUniqueInfo) r6;
        if (r31 == null) goto L113;
        r112 = r31.getUserId();
        if (r112 != null) goto L89;
        return "";
    L113:
        return "";
    L112:
        return "";
    L111:
        return "";
    L16:
        if (r10.longValue() != r12) goto L18;
        r11 = true;
        goto L19
    L11:
        if (r9.longValue() == 0) goto L18;
    L21:
        r7 = null;
    L28:
        r3 = "";
        goto L30
    }

    public static final JSONObject e(int r2, long r3) {
        return new JSONObject().put("cmd", r2).put("id", r3);
    }

    public static final JSONObject c(int r7, KtvMusic r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "anchorId");
        boolean r2 = true;
        JSONObject r0 = new JSONObject().put("cmd", 1);
        if (r8 == null) goto L5;
        long r3 = r8.getMId();
    L6:
        JSONObject r10 = r0.put("id", r3).put(BaseCoreViewModel.CORE_TAG_STATE, r7);
        KtvComponentContext r1 = KtvComponentContext.Companion.getContext();
        int r4 = 0;
        if (r1 == null) goto L21;
        com.bytedance.live.datacontext.n<Float> r5 = r1.getBallRelativeY();
        if (r5 == null) goto L21;
        Float r6 = (Float) r5.getValue();
        if (r6 == null) goto L21;
        if (r6.floatValue() >= 0) goto L16;
        r2 = false;
    L16:
        if (r2 == true) goto L19;
        r6 = null;
    L19:
        if (r6 == null) goto L21;
        r10.put("grid_y", Float.valueOf(r6.floatValue()));
    L21:
        KtvContext.Companion.getClass();
        KtvContext r11 = KtvContext.a.g();
        if (r11 == null) goto L28;
        com.bytedance.live.datacontext.n<String> r12 = r11.getCurrentMvVid();
        if (r12 == null) goto L28;
        Object r13 = (String) r12.getValue();
        if (r13 == null) goto L28;
        r10.put("vid", r13);
    L28:
        String r14 = "";
        if (KtvSettingHelper.w() == true) goto L31;
    L46:
        JSONObject r15 = new JSONObject();
        if (r8 == null) goto L54;
        OrderInfo r16 = r8.getOrderInfo();
        if (r16 == null) goto L54;
        InteractiveSongUserInfo r17 = r16.getTopUser();
        if (r17 == null) goto L54;
        String r18 = r17.getIdString();
        if (r18 == null) goto L54;
    L55:
        JSONObject r19 = r15.put("user_id", h(r18)).put("anchor_id", h(r9));
        if (r8 == null) goto L59;
        String r20 = r8.getMTitle();
        if (r20 == null) goto L59;
    L60:
        JSONObject r21 = r19.put("song_title", r20);
        if (r8 == null) goto L68;
        OrderInfo r22 = r8.getOrderInfo();
        if (r22 == null) goto L68;
        InteractiveSongUserInfo r23 = r22.getTopUser();
        if (r23 == null) goto L68;
        String r24 = r23.getNickNameFlex();
        if (r24 == null) goto L68;
    L69:
        JSONObject r25 = r21.put("nickname", r24);
        if (r8 == null) goto L79;
        OrderInfo r26 = r8.getOrderInfo();
        if (r26 == null) goto L79;
        InteractiveSongUserInfo r27 = r26.getTopUser();
        if (r27 == null) goto L79;
        String r28 = r27.getHighScoreSongCountFlex();
        if (r28 == null) goto L79;
        r14 = r28;
    L79:
        JSONObject r29 = r25.put("h_song_count", r14);
        if (r8 == null) goto L86;
        OrderInfo r30 = r8.getOrderInfo();
        if (r30 == null) goto L86;
        InteractiveSongUserInfo r31 = r30.getTopUser();
        if (r31 == null) goto L86;
        int r32 = r31.getKtvComponentLyricTextSecondLine();
    L87:
        JSONObject r33 = r29.put("ksong_lyric", r32);
        if (r8 == null) goto L94;
        OrderInfo r34 = r8.getOrderInfo();
        if (r34 == null) goto L94;
        InteractiveSongUserInfo r35 = r34.getTopUser();
        if (r35 == null) goto L94;
        r4 = r35.getKtvLyricTextFlex();
    L94:
        JSONObject r36 = r33.put("ktv_lyric", r4);
        if (r8 == null) goto L99;
        String r37 = r8.getMAuthor();
        if (TextUtils.isEmpty(r37) == true) goto L99;
        r36.put("author", r37);
    L99:
        JSONObject r38 = new JSONObject();
        if (r8 == null) goto L112;
        OrderInfo r39 = r8.getOrderInfo();
        if (r39 == null) goto L112;
        InteractiveSongUserInfo r40 = r39.getTopUser();
        if (r40 == null) goto L112;
        py.k r41 = r40.getAvatarThumbFlex();
        if (r41 == null) goto L112;
        List r42 = r41.getUrls();
        if (r42 == null) goto L112;
        String r43 = (String) CollectionsKt.firstOrNull(r42);
        if (r43 == null) goto L112;
        r38.put("url_list", new JSONArray().put(r43));
    L112:
        r36.put("avatar_thumb", r38);
        r10.put("order_info", r36);
        return r10;
    L86:
        r32 = 0;
    L68:
        r24 = "";
    L59:
        r20 = "";
    L54:
        r18 = "";
        goto L55
    L31:
        if (((Boolean) KtvSettingHelper.a1.getValue()).booleanValue() == true) goto L46;
        if (r8 == null) goto L46;
        JSONObject r44 = r10.put("lyrics_type", r8.getMLyricType()).put("lyrics_offset", Float.valueOf(r8.getMPreviewStartTime()));
        List r45 = r8.getMLyricUrlList();
        if (r45 == null) goto L37;
        Object r46 = (String) CollectionsKt.firstOrNull(r45);
        if (r46 == null) goto L37;
    L38:
        JSONObject r47 = r44.put("lyric_url", r46);
        KtvMusic.Companion.getClass();
        JSONObject r48 = r47.put("duration", KtvMusic.a.a(r8)).put("copyrighted_app_ids", new JSONArray(r8.getCopyrightedAppIds()));
        Map r49 = r8.getGlobalCopyrightRegionInfo();
        if (r49 == null) goto L44;
        com.bytedance.android.livesdk.ktvimpl.base.util.j.l.getClass();
        RegionList r50 = (RegionList) r49.get(Long.valueOf(com.bytedance.android.livesdk.ktvimpl.base.util.j.d));
        if (r50 == null) goto L44;
        List r51 = r50.getValues();
        if (r51 == null) goto L44;
    L45:
        r48.put("copyrighted_region_ids", new JSONArray(r51));
    L44:
        r51 = CollectionsKt.emptyList();
    L37:
        r46 = "";
        goto L38
    L5:
        r3 = 0;
        goto L6
    }

    public static final JSONObject d(int r2, float r3, Integer r4, Boolean r5) {
        JSONObject r0 = new JSONObject();
        r0.put("cmd", r2);
        r0.put("row", r4);
        r0.put("score", Float.valueOf(r3));
        r0.put("show_score", r5);
        return r0;
    }

    public static final JSONObject a(float r2, float r3, float r4, int r5, int r6, String r7, int r8, String r9, Integer r10) {
        Intrinsics.checkNotNullParameter(r7, "anchorId");
        JSONObject r0 = new JSONObject();
        r0.put("cur_tone", Float.valueOf(r2));
        r0.put("standard_tone", Float.valueOf(r3));
        r0.put("score", Float.valueOf(r4));
        r0.put("sentence_index", r5);
        r0.put("hit_type", r6);
        if (r9 != null) goto L5;
        r9 = jc1.k.n(IMiddlewareUserService.class).user().n();
    L5:
        r0.put("sender_user_id", h(r9));
        r0.put("anchor_id", h(r7));
        r0.put("combo", r8);
        r0.put("forward", r10);
        return r0;
    }

    public static final JSONObject b(String r6, String r7, String r8, String r9, long r10, String r12, float r13, boolean r14, String r15, boolean r16, long r17, String r19, double r20) {
        Intrinsics.checkNotNullParameter(r15, "tips");
        Intrinsics.checkNotNullParameter(r19, "anchorId");
        JSONObject r1 = new JSONObject();
        r1.put("avatar_thumb", r6);
        if (r7 != null) goto L5;
        String r3 = "";
    L6:
        r1.put("user_id", h(r3));
        r1.put("sec_uid", r8);
        r1.put("nick_name", r9);
        r1.put(LayoutSizeLargeModeConfig.TYPE_PERCENTAGE, r10);
        r1.put("song_title", r12);
        r1.put("score", Float.valueOf(r13));
        r1.put("is_high_score", r14);
        r1.put("midi_tips", r15);
        r1.put("hit_record_ab", r16);
        r1.put("song_id", r17);
        r1.put("threshold", r20);
        r1.put("sender_user_id", h(jc1.k.n(IMiddlewareUserService.class).user().n()));
        r1.put("anchor_id", h(r19));
        return r1;
    L5:
        r3 = r7;
        goto L6
    }
}
