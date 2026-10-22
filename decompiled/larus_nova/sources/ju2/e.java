package ju2;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e {
    public static final boolean a(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isMergeVSLive");
        IEpisodeExtraInfo r101 = r100.getEpisodeExtra();
        if (r101 == null) goto L9;
        IBaseEpisodeMod r102 = r101.getMod();
        if (r102 == null) goto L9;
        if (r102.getEpisodeStage() != EpisodeMod.EpisodeStageType.LIVE) goto L9;
        return true;
    L9:
        return false;
    }
}
