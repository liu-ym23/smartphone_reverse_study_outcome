package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.search;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.SongListItemViewHolder;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements e {
    public final com.bytedance.android.live.ktv.common.search.viewmodel.a a;
    public final com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b b;
    public final d c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final String b() {
        com.bytedance.android.live.ktv.common.search.viewmodel.a r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCurSearchKeyword();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final boolean e() {
        d r0 = this.c;
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
        d r0 = this.c;
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
        d r0 = this.c;
        if (r0 == null) goto L5;
        ModeType r1 = r0.getModeType();
    L7:
        if (r1 == ModeType.KTV_COMPONENT) goto L9;
        d r2 = this.c;
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
        if (j.i() == false) goto L21;
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
        if (j.i() == true) goto L19;
        d r3 = this.c;
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
    public final boolean d(MusicPanel r25) {
        if (r25 == null) goto L53;
        mb0.d.g("start_choose", r25);
        d r1 = this.c;
        if (r1 == null) goto L12;
        td2.b r2 = r1.getOrderSongExtraInfo();
        if (r2 == null) goto L12;
        String r3 = r2.a;
        if (r3 == null) goto L12;
        String r4 = r3;
    L13:
        int r5 = KSongOrderSongUtilKt.a;
        Intrinsics.checkNotNullParameter(r25, "musicPanel");
        Intrinsics.checkNotNullParameter(r4, "enterFrom");
        HashMap r12 = new HashMap();
        List r6 = r25.a.getTags();
        if (r6 != null) goto L16;
    L18:
        String r7 = BDLocationException.ERROR_TIMEOUT;
    L19:
        r12.put("is_original_flag", r7);
        pb0.a r8 = pb0.b.a;
        String r9 = j.g();
        String r10 = r25.a.getMTitle();
        if (r10 != null) goto L22;
        r10 = "";
    L22:
        long r11 = r25.a.getMId();
        String r13 = r25.d;
        String r14 = r25.b();
        String r15 = r25.a.getMAuthor();
        if (r15 != null) goto L25;
        String r16 = "";
    L26:
        bb0.a r17 = bb0.b.a;
        if (r17 == null) goto L29;
        String r18 = r17.c();
    L30:
        bb0.a r19 = bb0.b.a;
        if (r19 == null) goto L33;
        String r110 = r19.a();
    L34:
        Integer r20 = r25.x;
        String r21 = r25.y;
        String r22 = r25.z;
        String r111 = r25.a.getMidiUrl();
        if (r111 != null) goto L37;
        Boolean r112 = null;
    L42:
        Intrinsics.checkNotNullParameter(r4, "enterFrom");
        Intrinsics.checkNotNullParameter(r9, "userType");
        Intrinsics.checkNotNullParameter(r10, "songName");
        Intrinsics.checkNotNullParameter(r13, "fromRequestType");
        Intrinsics.checkNotNullParameter(r14, "artistId");
        Intrinsics.checkNotNullParameter(r16, "artistName");
        pb0.a r23 = pb0.b.a;
        if (r23 == null) goto L46;
        r23.f(r25, r4, r9, r10, r11, r13, false, r14, r16, r12, r18, r110, r20, r21, r22, r112);
    L46:
        d r24 = this.c;
        if (r24 != null) goto L49;
    L51:
        mb0.d.g("choose_song_limit", r25);
        ALogger.i("ttlive_ktv", "can't select more");
        return false;
    L49:
        if (r24.canSelectMore() != true) goto L51;
        return true;
    L37:
        if (r111.length() <= 0) goto L39;
        boolean r113 = true;
    L40:
        r112 = Boolean.valueOf(r113);
        goto L42
    L39:
        r113 = false;
        goto L40
    L33:
        r110 = null;
        goto L34
    L29:
        r18 = null;
        goto L30
    L25:
        r16 = r15;
        goto L26
    L16:
        if (r6.contains("原唱") != true) goto L18;
        r7 = "1";
    L12:
        r4 = "";
        goto L13
    L53:
        ALogger.i("ttlive_ktv", "panel is null");
        return false;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final void jumpToChorusRoom(MusicPanel r2) {
        d r0 = this.c;
        if (r0 == null) goto L6;
        r0.jumpToChorusRoom(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final void addFavorite(MusicPanel r2, ic0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "music");
        Intrinsics.checkNotNullParameter(r3, "favoriteCallback");
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = this.b;
        if (r0 == null) goto L6;
        r0.addFavorite(r2, r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final void delFavorite(MusicPanel r2, ic0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "music");
        Intrinsics.checkNotNullParameter(r3, "favoriteCallback");
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = this.b;
        if (r0 == null) goto L6;
        r0.delFavorite(r2, r3);
        return;
    }

    public c(com.bytedance.android.live.ktv.common.search.viewmodel.a r1, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r2, d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final void h(Context r2, MusicPanel r3, RecyclerView.ViewHolder r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "musicPanel");
        Intrinsics.checkNotNullParameter(r4, "viewHolder");
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = this.b;
        if (r0 == null) goto L6;
        r0.addSong(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final void i(Context r2, MusicPanel r3, SongListItemViewHolder r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "musicPanel");
        Intrinsics.checkNotNullParameter(r4, "viewHolder");
        d r0 = this.c;
        if (r0 == null) goto L6;
        r0.onItemClick(r2, r3, r4);
        return;
    }
}
