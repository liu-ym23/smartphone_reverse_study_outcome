package com.bytedance.android.livesdk.ktvimpl.base.util;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.sei.x;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.message.model.WantListenInfo;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o {
    public static final MusicPanel a(com.bytedance.android.livesdk.ktvimpl.base.sei.k r44) {
        Intrinsics.checkNotNullParameter(r44, "seiModel");
        KtvMusic r0 = new KtvMusic(0, null, null, null, 0, null, null, 0, 0.0f, null, null, null, null, null, null, null, false, null, null, null, null, null, null, 0, null, 0, null, null, 0, null, null, null, null, null, null, -1, 7, null);
        r0.setMId(r44.j());
        r0.setMDuration((long) r44.h());
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r2 = r44.w();
        String r3 = "";
        if (r2 == null) goto L6;
        String r4 = r2.g();
        if (r4 == null) goto L6;
    L7:
        r0.setMTitle(r4);
        OrderInfo r5 = new OrderInfo();
        InteractiveSongUserInfo r6 = new InteractiveSongUserInfo();
        r6.setIdString(r44.A());
        String r7 = r44.A();
        com.bytedance.android.livesdk.chatroom.o r8 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        String r9 = null;
        if (r8 == null) goto L25;
        DataCenter r10 = r8.getDataCenter();
        if (r10 == null) goto L25;
        List r11 = (List) r10.get("data_online_changed_list", new ArrayList());
        if (r11 == null) goto L25;
        Iterator r12 = r11.iterator();
    L15:
        if (r12.hasNext() == false) goto L23;
        Object r13 = r12.next();
        IBaseUser r14 = ((LinkPlayerInfo) r13).getUser();
        if (r14 == null) goto L19;
        String r15 = r14.getIdString();
    L21:
        if (Intrinsics.areEqual(r15, r7) == false) goto L15;
    L24:
        LinkPlayerInfo r16 = (LinkPlayerInfo) r13;
    L26:
        if (r16 == null) goto L39;
        IBaseUser r17 = r16.getUser();
        if (r17 == null) goto L33;
        String r18 = r17.getRealNickName();
        if (r18 == null) goto L33;
        r3 = r18;
    L33:
        r6.setNickNameFlex(r3);
        IBaseUser r19 = r16.getUser();
        if (r19 == null) goto L37;
        py.k r20 = r19.getAvatarThumbKt();
        if (r20 == null) goto L37;
    L38:
        r6.setAvatarThumbFlex(r20);
    L37:
        r20 = qy.a.c();
    L39:
        Unit r21 = Unit.INSTANCE;
        r5.setTopUser(r6);
        r0.setOrderInfo(r5);
        String r22 = r44.p();
        if (r22 != null) goto L42;
    L49:
        r0.setMidiUrl(r44.p());
        r0.setSongType(0);
        r0.setMLyricType(r44.n());
        return new MusicPanel(r0, 0, null, false, null, null, null, 1073741822);
    L42:
        if (r22.length() <= 0) goto L44;
        boolean r23 = true;
    L45:
        if (r23 == false) goto L47;
        r9 = r22;
    L47:
        if (r9 == null) goto L49;
        ArrayList r24 = new ArrayList();
        r24.add(r9);
        r0.setMLyricUrlList(r24);
        goto L49
    L44:
        r23 = false;
        goto L45
    L19:
        r15 = null;
        goto L21
    L23:
        r13 = null;
    L25:
        r16 = null;
    L6:
        r4 = "";
        goto L7
    }

    public static final boolean b(long r8) {
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isKtvMode() == false) goto L5;
        OrderedSongDataContext r0 = KtvModeOrderedSongDataContext.Companion.getContext();
    L6:
        Object r3 = null;
        if (r0 == null) goto L20;
        List<SongUniqueInfo> r1 = r0.getKtvPublicSongUniqueInfoList();
        if (r1 == null) goto L20;
        Iterator<T> r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L19;
        Object r4 = r2.next();
        if (((SongUniqueInfo) r4).getSongId() != r8) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == false) goto L12;
        r3 = r4;
        goto L19
    L16:
        r5 = false;
    L19:
        r3 = (SongUniqueInfo) r3;
    L20:
        if (r3 == null) goto L28;
        return true;
    L28:
        return false;
    L5:
        r0 = KtvComponentOrderedSongDataContext.Companion.getContext();
        goto L6
    }

    public static final MusicPanel c(KtvRoomLyricsStateMachineConfig.d.f r4) {
        Intrinsics.checkNotNullParameter(r4, "from");
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r0 = r4.c;
        if (r0 == null) goto L8;
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.s(r4.b.a, r0.j(), r4.c.A()) == true) goto L8;
        return a(r4.c);
    L8:
        return r4.b;
    }

    public static final MusicPanel d(com.bytedance.android.livesdk.ktvimpl.base.sei.k r9) {
        Intrinsics.checkNotNullParameter(r9, "seiModel");
        boolean r2 = true;
        Long r3 = null;
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L37;
        Intrinsics.checkNotNullParameter(r9, "seiModel");
        ChorusContext.a r0 = ChorusContext.Companion;
        if (r0.c() == false) goto L36;
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r1 = r9.w();
        long r5 = r9.j();
        if (r1 != null) goto L9;
    L23:
        ChorusContext r4 = r0.getContext();
        if (r4 == null) goto L35;
        List<MusicPanel> r6 = r4.getChorusNotSelfSeeingMusicList();
        if (r6 == null) goto L35;
        MusicPanel r7 = (MusicPanel) CollectionsKt.getOrNull(r6, 0);
        if (r7 == null) goto L35;
        if (r7.a.getMId() != r5) goto L32;
        boolean r8 = true;
    L33:
        if (r8 == false) goto L35;
    L43:
        if (r7 != null) goto L45;
        r7 = a(r9);
    L46:
        Pair r10 = new Pair(r7, Boolean.valueOf(r2));
        MusicPanel r11 = (MusicPanel) r10.getFirst();
        if (((Boolean) r10.getSecond()).booleanValue() == false) goto L78;
        KtvMusic r12 = r11.a;
        if (r9.j() == 0) goto L51;
        r12.setMId(r9.j());
    L51:
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r13 = r9.w();
        if (r13 == null) goto L54;
        String r14 = r13.g();
    L56:
        if (StringUtils.isEmpty(r14) == true) goto L63;
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r15 = r9.w();
        if (r15 == null) goto L60;
        String r16 = r15.g();
    L61:
        r12.setMTitle(r16);
        goto L63
    L60:
        r16 = null;
    L63:
        if (((long) r9.h()) <= 0) goto L65;
        r12.setMDuration((long) r9.h());
    L65:
        KtvMusic r17 = r11.a;
        if (r17 == null) goto L69;
        WantListenInfo r18 = r17.getWantListenInfo();
        if (r18 == null) goto L69;
    L70:
        x r19 = r9.E();
        if (r19 == null) goto L73;
        r3 = Long.valueOf(r19.a());
    L73:
        if (r3 != null) goto L75;
    L77:
        Unit r20 = Unit.INSTANCE;
        r12.setWantListenInfo(r18);
        r12.setOrderInfo(f(r11, r9));
        goto L78
    L75:
        if (r9.E().a() == 0) goto L77;
        r18.setWantListenCount(r9.E().a());
    L69:
        r18 = new WantListenInfo();
        goto L70
    L54:
        r14 = null;
    L78:
        return r11;
    L45:
        r2 = false;
        goto L46
    L32:
        r8 = false;
    L35:
        r7 = null;
        goto L43
    L9:
        if (b(r5) == false) goto L23;
        ChorusContext r21 = r0.getContext();
        if (r21 == null) goto L35;
        List<MusicPanel> r22 = r21.getChorusNotSelfSeeingMusicList();
        if (r22 == null) goto L35;
        r7 = (MusicPanel) CollectionsKt.getOrNull(r22, 0);
        if (r7 == null) goto L35;
        if (r7.a.getMId() != r5) goto L20;
        boolean r23 = true;
    L21:
        if (r23 == false) goto L35;
    L20:
        r23 = false;
        goto L21
    L36:
        r7 = e(r9.w(), r9.j(), r9.A());
        goto L43
    L37:
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r24 = r9.w();
        long r25 = r9.j();
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r26 = r9.w();
        if (r26 == null) goto L41;
        String r27 = r26.h();
        if (r27 == null) goto L41;
    L42:
        r7 = e(r24, r25, r27);
    L41:
        r27 = "";
        goto L42
    }

    public static final OrderInfo f(MusicPanel r6, com.bytedance.android.livesdk.ktvimpl.base.sei.k r7) {
        Intrinsics.checkNotNullParameter(r6, "musicPanel");
        Intrinsics.checkNotNullParameter(r7, "seiModel");
        KtvMusic r0 = r6.a;
        if (r0 == null) goto L6;
        OrderInfo r1 = r0.getOrderInfo();
        if (r1 == null) goto L6;
    L7:
        OrderInfo r2 = r6.a.getOrderInfo();
        String r3 = null;
        if (r2 == null) goto L10;
        InteractiveSongUserInfo r4 = r2.getTopUser();
    L11:
        if (r4 == null) goto L95;
        OrderInfo r5 = r6.a.getOrderInfo();
        if (r5 == null) goto L94;
        String r8 = r5.getTopUser();
        if (r8 == null) goto L94;
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r9 = r7.w();
        String r10 = "";
        if (r9 == null) goto L20;
        String r11 = r9.h();
        if (r11 == null) goto L20;
    L22:
        if (r2.a(r11) != true) goto L29;
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r12 = r7.w();
        if (r12 == null) goto L27;
        String r13 = r12.h();
        if (r13 == null) goto L27;
    L28:
        r8.setIdString(r13);
    L27:
        r13 = "";
    L29:
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r14 = r7.w();
        if (r14 == null) goto L32;
        String r15 = r14.f();
    L34:
        if (StringUtils.isEmpty(r15) == true) goto L41;
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r16 = r7.w();
        if (r16 == null) goto L39;
        String r17 = r16.f();
        if (r17 == null) goto L39;
    L40:
        r8.setNickNameFlex(r17);
    L39:
        r17 = "";
    L41:
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r18 = r7.w();
        if (r18 == null) goto L44;
        py.k r19 = r18.b();
    L45:
        if (r19 == null) goto L51;
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r20 = r7.w();
        if (r20 == null) goto L49;
        py.k r21 = r20.b();
    L50:
        r8.setAvatarThumbFlex(r21);
        goto L51
    L49:
        r21 = null;
    L51:
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r22 = r7.w();
        if (r22 == null) goto L54;
        String r23 = r22.c();
    L56:
        if (StringUtils.isEmpty(r23) == true) goto L64;
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r24 = r7.w();
        if (r24 == null) goto L63;
        String r25 = r24.c();
        if (r25 == null) goto L63;
        r10 = r25;
    L63:
        r8.setHighScoreSongCountFlex(r10);
    L64:
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r26 = r7.w();
        int r27 = 0;
        if (r26 == null) goto L67;
        int r28 = r26.d();
    L68:
        if (r28 == 0) goto L74;
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r29 = r7.w();
        if (r29 == null) goto L72;
        int r30 = r29.d();
    L73:
        r8.setKtvComponentLyricTextSecondLine(r30);
        goto L74
    L72:
        r30 = 0;
    L74:
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r31 = r7.w();
        if (r31 == null) goto L77;
        int r32 = r31.e();
    L78:
        if (r32 == 0) goto L83;
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r33 = r7.w();
        if (r33 == null) goto L82;
        r27 = r33.e();
    L82:
        r8.setKtvLyricTextFlex(r27);
    L83:
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r34 = r7.w();
        if (r34 == null) goto L86;
        String r35 = r34.a();
    L88:
        if (StringUtils.isEmpty(r35) == true) goto L93;
        KtvMusic r36 = r6.a;
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r37 = r7.w();
        if (r37 == null) goto L92;
        r3 = r37.a();
    L92:
        r36.setMAuthor(r3);
    L93:
        Unit r38 = Unit.INSTANCE;
        r3 = r8;
        goto L94
    L86:
        r35 = null;
        goto L88
    L77:
        r32 = 0;
        goto L78
    L67:
        r28 = 0;
        goto L68
    L54:
        r23 = null;
        goto L56
    L44:
        r19 = null;
        goto L45
    L32:
        r15 = null;
    L20:
        r11 = "";
    L94:
        r1.setTopUser(r3);
    L95:
        return r1;
    L10:
        r4 = null;
    L6:
        r1 = new OrderInfo();
        goto L7
    }

    public static final MusicPanel e(com.bytedance.android.livesdk.ktvimpl.base.sei.q r2, long r3, String r5) {
        if (r2 != null) goto L4;
    L11:
        KtvContext.Companion.getClass();
        MusicPanel r4 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(KtvContext.a.g());
        if (r4 != null) goto L14;
    L19:
        return null;
    L14:
        if (r3 != r4.a.getMId()) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == false) goto L19;
        return r4;
    L16:
        r6 = false;
        goto L17
    L4:
        if (b(r3) == false) goto L11;
        KtvContext.Companion.getClass();
        MusicPanel r7 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(KtvContext.a.g());
        if (r7 == null) goto L19;
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.s(r7.a, r3, r5) == false) goto L19;
        return r7;
    }
}
