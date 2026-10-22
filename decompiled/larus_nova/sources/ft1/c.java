package ft1;

import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.vs.MultiTab;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f478751a = 0;

    static {
    }

    public static String a(Integer r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = EpisodeMod.EpisodeStageType.UNKNOWN;
        if (r100.intValue() == r101) goto L26;
        int r102 = EpisodeMod.EpisodeStageType.LIVE;
        if (r100.intValue() != r102) goto L11;
        return "LIVE";
    L11:
        int r103 = EpisodeMod.EpisodeStageType.PREMIERE;
        if (r100.intValue() != r103) goto L14;
        return "PREMIERE";
    L14:
        int r104 = EpisodeMod.EpisodeStageType.RECORD;
        if (r100.intValue() != r104) goto L17;
        return "RECORD";
    L17:
        int r105 = EpisodeMod.EpisodeStageType.REPLAY;
        if (r100.intValue() != r105) goto L21;
        return "REPLAY";
    L21:
        return String.valueOf(r100.intValue());
    L26:
        return null;
    }

    public static String b(EpisodeExtraInfo r100) {
        if (r100 == null) goto L36;
        MultiTab r101 = r100.getMultiTab();
        if ((r101 instanceof MultiTab) == true) goto L7;
        r101 = null;
    L7:
        if (r101 == null) goto L13;
        List<MultiTab.TabItem> r102 = r101.getValidTabs();
        if (r102 == null) goto L13;
        if ((!r102.isEmpty()) != true) goto L13;
        return "multi_tab";
    L13:
        IBaseEpisodeMod r103 = r100.getMod();
        if (r103 == null) goto L16;
        Integer r104 = Integer.valueOf(r103.getEpisodeSubType());
    L17:
        int r105 = EpisodeMod.EpisodeSubType.UNKNOWN;
        if (r104 != null) goto L21;
    L23:
        int r106 = EpisodeMod.EpisodeSubType.NORMAL;
        if (r104 != null) goto L27;
    L29:
        int r107 = EpisodeMod.EpisodeSubType.GUIDE;
        if (r104 != null) goto L33;
        return null;
    L33:
        if (r104.intValue() != r107) goto L39;
        return "GUIDE";
    L39:
        return null;
    L27:
        if (r104.intValue() != r106) goto L29;
        return EffectConstants.NORMAL;
    L21:
        if (r104.intValue() != r105) goto L23;
        return null;
    L16:
        r104 = null;
        goto L17
    L36:
        return null;
    }
}
