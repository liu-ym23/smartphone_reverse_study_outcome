package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab;

import am2.x;
import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvChallengeDataContext;
import com.bytedance.android.livesdk.log.filter.t;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.PersonalSongInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements e {
    public final com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b a;
    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final String b() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final boolean e() {
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = this.b;
        if (r0 == null) goto L9;
        MutableLiveData<vb0.a> r1 = r0.getOrderSongUiState();
        if (r1 == null) goto L9;
        vb0.a r2 = (vb0.a) r1.getValue();
        if (r2 == null) goto L9;
        Boolean r3 = r2.i;
    L11:
        return Intrinsics.areEqual(r3, Boolean.TRUE);
    L9:
        r3 = null;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final boolean f() {
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = this.b;
        if (r0 == null) goto L5;
        ModeType r1 = r0.getModeType();
    L7:
        if (r1 != ModeType.MUSIC_EFFECT) goto L10;
        return false;
    L10:
        return true;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final String g() {
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = this.b;
        if (r0 == null) goto L5;
        ModeType r1 = r0.getModeType();
    L7:
        if (r1 == ModeType.KTV_COMPONENT) goto L9;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r2 = this.b;
        if (r2 == null) goto L15;
        ModeType r3 = r2.getModeType();
    L17:
        if (r3 == ModeType.MUSIC_EFFECT) goto L19;
        return null;
    L19:
        return s1.B(2131916419);
    L15:
        r3 = null;
        goto L17
    L9:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L21;
        return s1.B(2131918625);
    L21:
        return s1.B(2131918646);
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final int a() {
        return s1.h(2131108256);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final boolean c() {
        IBaseUser r0 = com.bytedance.android.live.ktv.common.util.a.c().getOwner();
        if (r0 == null) goto L5;
        boolean r1 = r0.isFollowing();
    L6:
        boolean r2 = hd0.c.f().g();
        if (r1 == true) goto L17;
        if (r2 == true) goto L10;
        return false;
    L10:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L19;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r3 = this.b;
        if (r3 != null) goto L14;
        return false;
    L14:
        if (r3.isOnlyAcceptFollowerApply() != true) goto L21;
        return true;
    L21:
        return false;
    L19:
        return false;
    L17:
        return false;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final boolean d(MusicPanel r14) {
        if (r14 == null) goto L107;
        mb0.d.g("start_choose", r14);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r2 = this.b;
        if (r2 == null) goto L10;
        td2.b r3 = r2.getOrderSongExtraInfo();
        if (r3 == null) goto L10;
        String r4 = r3.a;
        if (r4 == null) goto L10;
    L11:
        int r5 = KSongOrderSongUtilKt.a;
        Intrinsics.checkNotNullParameter(r14, "musicPanel");
        Intrinsics.checkNotNullParameter(r4, "enterFrom");
        String r6 = r14.d;
        com.bytedance.android.livesdk.log.filter.o r7 = j0.l().c(x.class);
        Long r8 = null;
        if ((r7 instanceof t) == true) goto L14;
        r7 = null;
    L14:
        t r9 = (t) r7;
        if (r9 == null) goto L19;
        Map<String, String> r10 = r9.getMap();
        if (r10 == null) goto L19;
        String r11 = r10.get("enter_from_merge");
    L21:
        if (Intrinsics.areEqual(r11, "single_song") == false) goto L40;
        com.bytedance.android.livesdk.log.filter.o r12 = j0.l().c(x.class);
        if ((r12 instanceof t) == true) goto L25;
        r12 = null;
    L25:
        t r13 = (t) r12;
        if (r13 == null) goto L30;
        Map<String, String> r15 = r13.getMap();
        if (r15 == null) goto L30;
        String r16 = r15.get("enter_method");
    L32:
        if (Intrinsics.areEqual(r16, "song") == false) goto L40;
        long r17 = r14.a.getMId();
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r18 = KtvRoomContext.a.a();
        if (r18 == null) goto L40;
        com.bytedance.live.datacontext.m<Long> r19 = r18.getRelevantLiveSongId();
        if (r19 == null) goto L40;
        if (r17 != ((Number) r19.getValue()).longValue()) goto L40;
        r6 = "from_detail_pop_music";
    L30:
        r16 = null;
    L40:
        Long r20 = KtvLoggerHelper.a;
        String r21 = r14.a.getMTitle();
        if (r21 != null) goto L43;
        r21 = "";
    L43:
        long r22 = r14.a.getMId();
        Intrinsics.checkNotNullParameter(r4, "enterFrom");
        Intrinsics.checkNotNullParameter(r6, "fromRequestType");
        Intrinsics.checkNotNullParameter(r21, "songName");
        HashMap r23 = new HashMap();
        r23.put("from_request_type", r6);
        if (r22 <= 0) goto L46;
        r23.put("song_id", String.valueOf(r22));
    L46:
        r23.put("live_type", KtvLoggerHelper.F());
        KtvLoggerHelper.A(r23);
        r23.put("enter_from", r4);
        r23.put("user_type", KtvLoggerHelper.I());
        r23.put("song_name", r21);
        String r24 = BDLocationException.ERROR_TIMEOUT;
        r23.put("is_play_all", BDLocationException.ERROR_TIMEOUT);
        if (Intrinsics.areEqual(r6, "recommend") == false) goto L49;
    L50:
        ke2.d.a(r14, r23, true);
    L51:
        com.bytedance.android.livesdk.ktvimpl.chorus.c.b(r23);
        int r25 = ke2.b.a;
        ke2.b.l(r23);
        ke2.b.m(r23);
        r23.put("midi_score", "");
        KtvMusic r26 = r14.a;
        if (r26 == null) goto L58;
        PersonalSongInfo r27 = r26.getPersonalSongInfo();
        if (r27 == null) goto L58;
        double r28 = r27.getMidiScore();
        if (r28 <= 0) goto L58;
        r23.put("midi_score", String.valueOf(r28));
    L58:
        KtvMusic r29 = r14.a;
        if (r29 == null) goto L61;
        String r30 = r29.getMidiUrl();
    L62:
        if (r30 != null) goto L64;
    L67:
        boolean r31 = true;
    L68:
        if (r31 == false) goto L70;
        String r32 = BDLocationException.ERROR_TIMEOUT;
    L71:
        r23.put("is_midi", r32);
        if (ne2.a.a() == false) goto L100;
        KtvChallengeDataContext.a r33 = KtvChallengeDataContext.Companion;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r34 = r33.a();
        if (r34 == null) goto L78;
        me2.a r35 = r34.getChallengeConfig();
        if (r35 == null) goto L78;
        Integer r36 = Integer.valueOf(r35.f);
    L79:
        r23.put("goal_type", KtvLoggerHelper.C(r36));
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r37 = r33.a();
        if (r37 == null) goto L84;
        me2.a r38 = r37.getChallengeConfig();
        if (r38 == null) goto L84;
        Long r39 = Long.valueOf(r38.d);
    L85:
        if (r39 == null) goto L88;
        String r40 = String.valueOf(r39.longValue());
        if (r40 == null) goto L88;
    L89:
        r23.put("play_time", r40);
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r41 = r33.a();
        if (r41 == null) goto L94;
        me2.a r42 = r41.getChallengeConfig();
        if (r42 == null) goto L94;
        r8 = Long.valueOf(r42.c);
    L94:
        if (r8 == null) goto L99;
        String r43 = String.valueOf(r8.longValue());
        if (r43 == null) goto L99;
        r24 = r43;
    L99:
        r23.put("goal", r24);
    L88:
        r40 = BDLocationException.ERROR_TIMEOUT;
    L84:
        r39 = null;
    L78:
        r36 = null;
    L100:
        KtvLoggerHelper.n0(r23, r14);
        xe2.h.b(r23);
        r23.put("order_limit", xe2.h.f(xe2.h.c));
        r23.put("join_limit", xe2.h.f(xe2.h.d));
        j0.l().sendLog("livesdk_anchor_ksong_request_button_click", r23, new Object[]{IRoom.class, new x()});
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r44 = this.b;
        if (r44 != null) goto L103;
    L105:
        mb0.d.g("choose_song_limit", r14);
        ALogger.i("ttlive_ktv", "can't select more");
        return false;
    L103:
        if (r44.canSelectMore() != true) goto L105;
        return true;
    L70:
        r32 = "1";
        goto L71
    L64:
        if (r30.length() == 0) goto L67;
        r31 = false;
        goto L68
    L61:
        r30 = null;
        goto L62
    L49:
        if (Intrinsics.areEqual(r6, "推荐") == false) goto L51;
    L19:
        r11 = null;
    L10:
        r4 = "";
        goto L11
    L107:
        ALogger.i("ttlive_ktv", "panel is null");
        return false;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final void jumpToChorusRoom(MusicPanel r2) {
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = this.b;
        if (r0 == null) goto L6;
        r0.jumpToChorusRoom(r2);
        return;
    }

    public j(com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r1, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final void addFavorite(MusicPanel r2, ic0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "music");
        Intrinsics.checkNotNullParameter(r3, "favoriteCallback");
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.addFavorite(r2, r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final void delFavorite(MusicPanel r2, ic0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "music");
        Intrinsics.checkNotNullParameter(r3, "favoriteCallback");
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.delFavorite(r2, r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final void h(Context r2, MusicPanel r3, RecyclerView.ViewHolder r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "musicPanel");
        Intrinsics.checkNotNullParameter(r4, "viewHolder");
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.addSong(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final void i(Context r2, MusicPanel r3, SongListItemViewHolder r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "musicPanel");
        Intrinsics.checkNotNullParameter(r4, "viewHolder");
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = this.b;
        if (r0 == null) goto L6;
        r0.onItemClick(r2, r3, r4);
        return;
    }
}
