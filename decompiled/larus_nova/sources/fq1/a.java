package fq1;

import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ReplayPaidInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainEpisode;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements mq1.i, com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Episode f478400a;

    public a() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public final IMainEpisode a() {
        Episode r100 = this.f478400a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return (IMainEpisode) r100.castToOrNull(IMainEpisode.class);
    }

    public final void c(Integer r100, Integer r101) {
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.d().isSaas() == false) goto L5;
        return;
    L5:
        if (r100 == null) goto L13;
        r100.intValue();
        Episode r102 = this.f478400a;
        if (r102 == null) goto L13;
        IMainEpisode r103 = (IMainEpisode) r102.castTo(IMainEpisode.class);
        if (r103 == null) goto L13;
        ReplayPaidInfo r104 = r103.getReplayPaidInfo();
        if (r104 == null) goto L13;
        r104.setViewRight(r100.intValue());
    L13:
        if (r101 == null) goto L22;
        r101.intValue();
        Episode r105 = this.f478400a;
        if (r105 == null) goto L23;
        IMainEpisode r106 = (IMainEpisode) r105.castTo(IMainEpisode.class);
        if (r106 == null) goto L24;
        ReplayPaidInfo r107 = r106.getReplayPaidInfo();
        if (r107 == null) goto L25;
        r107.setDelivery(r101.intValue());
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    }
}
