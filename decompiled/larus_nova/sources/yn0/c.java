package yn0;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdkapi.depend.model.live.abs.IVSCompatRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeBasic;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements l81.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f568499a = null;

    public c() {
    }

    static {
        f568499a = new c();
    }

    @Override // l81.c
    public final EpisodeBasic a(DataCenter r100) {
        if (r100 == null) goto L6;
        IVSCompatRoom r101 = z.q(r100);
        if (r101 == null) goto L6;
        return r101.getEpisodeBasic();
    L6:
        return null;
    }
}
