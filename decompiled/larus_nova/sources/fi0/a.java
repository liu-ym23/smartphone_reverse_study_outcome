package fi0;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.playmode.IncompatibleTag;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.live.profit.vote.e;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.HashMap;
import jc1.k;
import kotlin.collections.CollectionsKt;
import xh0.f;
import xh0.g;
import xh0.h;
import yt0.c;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends xh0.a {
    @Override // xh0.b
    public final void tryStartPlayMode(HashMap<String, Object> r100) {
    }

    @Override // xh0.b
    public final void tryStopPlayMode(HashMap<String, Object> r100) {
    }

    @Override // xh0.b
    public final ArrayList<f> getIncompatibleSourceList() {
        IncompatibleTag r100 = IncompatibleTag.PLAY_MODE;
        return CollectionsKt.arrayListOf(new f[]{new f(r100, 5), new f(r100, 6, ""), new f(r100, 7, ""), new f(r100, 11, ""), new f(r100, 16, ""), new f(r100, 17, ""), new f(r100, 19, ""), new f(r100, 21, ""), new f(r100, 22, ""), new f(r100, 23, "")});
    }

    @Override // xh0.b
    public final h getPlayModeInfo() {
        return new h(29, s1.B(R.string.ttlive_adventure_name));
    }

    @Override // xh0.b
    public final boolean isOpen() {
        AdventureContext.Companion.getClass();
        return AdventureContext.a.a();
    }

    public a() {
    }

    @Override // xh0.a, xh0.b
    public final g isCanOpen(HashMap<String, Object> r100) {
        if (((IKtvService) k.n(IKtvService.class)).currentIsMultipleKtvModeV2() == false) goto L6;
        IncompatibleTag r101 = IncompatibleTag.PLAY_MODE;
        return new g(r101, 21, false, r101 + "_21", s1.C(R.string.ttlive_adventure_open_be_conflicted, new Object[]{s1.B(R.string.ttlive_ktv_component_open_audience_sing)}));
    L6:
        e r102 = c.m();
        if (r102 == null) goto L13;
        if (r102.fi() != true) goto L13;
        return new g(IncompatibleTag.PLAY_MODE, getPlayModeInfo().f563852a, false, "giftVote", s1.B(R.string.ttlive_live_adventure_gift_vote_conflict));
    L13:
        if (InteractiveSongContext.Companion.f() == false) goto L17;
        return new g(IncompatibleTag.PLAY_MODE, getPlayModeInfo().f563852a, false, "giftVote", s1.B(R.string.ttlive_live_adventure_request_song_conflict));
    L17:
        return super.isCanOpen(r100);
    }
}
