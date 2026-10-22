package com.bytedance.android.livesdk.ktvimpl.base.karaokestation;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.x;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.model.api.o0;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.util.q;
import com.bytedance.android.livesdk.logger.PanelType;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.model.ModeType;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KSongOrderSongHandler implements nb0.b {
    public d a;
    public com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b b;
    public final Lazy c;

    public final String c() {
        d r0 = this.a;
        if (r0 == null) goto L5;
        ModeType r1 = r0.getModeType();
    L6:
        ModeType r2 = ModeType.MUSIC_EFFECT;
        if (r1 == r2) goto L19;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r3 = this.b;
        if (r3 == null) goto L16;
        Pair r4 = r3.getSelectedFirstLevelTabValue();
        if (r4 == null) goto L16;
        Integer r5 = (Integer) r4.getFirst();
        if (r5 == null) goto L16;
        int r6 = r5.intValue();
    L18:
        return com.bytedance.android.live.ktv.common.karaokestation.model.f.b(com.bytedance.android.live.ktv.common.karaokestation.model.f.a(r6));
    L16:
        r6 = FirstLevelTab.OrderSongTab.getValue();
        goto L18
    L19:
        return r2.getValue();
    L5:
        r1 = null;
        goto L6
    }

    public final int g() {
        d r0 = this.a;
        if (r0 == null) goto L5;
        ModeType r1 = r0.getModeType();
    L7:
        return KSongOrderSongUtilKt.f(r1);
    L5:
        r1 = null;
        goto L7
    }

    public final String getRequiredSongInfo() {
        d r0 = this.a;
        if (r0 == null) goto L6;
        String r1 = r0.getRequiredSongInfo();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final x getRoomInfo() {
        return (x) this.c.getValue();
    }

    public final String h() {
        d r0 = this.a;
        if (r0 == null) goto L5;
        ModeType r1 = r0.getModeType();
    L6:
        ModeType r2 = ModeType.MUSIC_EFFECT;
        if (r1 == r2) goto L9;
        return null;
    L9:
        return r2.getValue();
    L5:
        r1 = null;
        goto L6
    }

    public KSongOrderSongHandler() {
        this.c = LazyKt.lazy(KSongOrderSongHandler$mRoomInfo$2.INSTANCE);
    }

    public final t61 e() {
        return com.bytedance.android.livesdk.ktvimpl.base.util.f.a();
    }

    public final Map<String, y> f(com.bytedance.android.live.ktv.common.karaokestation.model.d r2) {
        Intrinsics.checkNotNullParameter(r2, "firstLevelTabData");
        Intrinsics.checkNotNullParameter(r2, "firstLevelTabData");
        return null;
    }

    public final void postSyncSongListData(y r2) {
        Intrinsics.checkNotNullParameter(r2, "secondLevelTabData");
        d r0 = this.a;
        if (r0 == null) goto L6;
        r0.postSyncSongListData(r2);
        return;
    }

    public final void postSyncTabListData(com.bytedance.android.live.ktv.common.karaokestation.model.d r2) {
        Intrinsics.checkNotNullParameter(r2, "firstLevelTabData");
        d r0 = this.a;
        if (r0 == null) goto L6;
        r0.postSyncTabListData(r2);
        return;
    }

    public final void updateMusicPanelState(MusicPanel r2) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
        d r0 = this.a;
        if (r0 == null) goto L6;
        r0.updateMusicPanelState(r2);
        return;
    }

    public final void a(com.bytedance.android.live.ktv.common.karaokestation.model.d r1, List<o0> r2) {
        Intrinsics.checkNotNullParameter(r1, "firstLevelTabData");
        Intrinsics.checkNotNullParameter(r1, "firstLevelTabData");
    }

    public final void addFavorite(MusicPanel r2, ic0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
        Intrinsics.checkNotNullParameter(r3, "favoriteCallback");
        d r0 = this.a;
        if (r0 == null) goto L6;
        r0.addFavorite(r2, r3);
        return;
    }

    public final void delFavorite(MusicPanel r2, ic0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
        Intrinsics.checkNotNullParameter(r3, "favoriteCallback");
        d r0 = this.a;
        if (r0 == null) goto L6;
        r0.delFavorite(r2, r3);
        return;
    }

    public final void addSong(Context r3, MusicPanel r4, RecyclerView.ViewHolder r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "musicPanel");
        Intrinsics.checkNotNullParameter(r5, "viewHolder");
        d r0 = this.a;
        if (r0 == null) goto L6;
        r0.addSong(r3, r4, r5, null);
        return;
    }

    public final void b(boolean r4, Throwable r5, y r6, long r7) {
        Intrinsics.checkNotNullParameter(r6, "secondLevelTabData");
        if (r7 > 0) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r6.c, "recommend") == false) goto L15;
        ALogger.i("panel_first_frame_opt_tag", "real fetch song list success ;; duration == " + (System.currentTimeMillis() - r7));
        Map<String, cm2.a> r8 = q.a;
        Intrinsics.checkNotNullParameter(PanelType.ORDER_SONG_PANEL, "panelType");
        cm2.a r9 = q.b();
        if (r9 != null) goto L9;
    L11:
        if (r4 == true) goto L16;
        q.d(r5);
        return;
    L16:
        return;
    L9:
        if (r9.b == true) goto L11;
        r9.h = System.currentTimeMillis() - r7;
        r9.e = System.currentTimeMillis();
        goto L11
    }

    public final void d(boolean r4, Throwable r5, com.bytedance.android.live.ktv.common.karaokestation.model.d r6, long r7) {
        Intrinsics.checkNotNullParameter(r6, "firstLevelTabData");
        if (r7 > 0) goto L5;
        return;
    L5:
        if (r6.d != FirstLevelTab.OrderSongTab.getValue()) goto L11;
        ALogger.i("panel_first_frame_opt_tag", "real fetch tab list success ;; duration == " + (System.currentTimeMillis() - r7));
        if (r4 == true) goto L12;
        q.d(r5);
        return;
    L12:
        return;
    }
}
