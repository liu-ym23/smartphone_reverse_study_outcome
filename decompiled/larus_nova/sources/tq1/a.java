package tq1;

import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class a {
    public static final List<Episode> a(List<? extends EpisodeGroup> r100) {
        if (r100 == null) goto L12;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L5:
        if (r102.hasNext() == false) goto L16;
        List<Episode> r103 = ((EpisodeGroup) r102.next()).episodes;
        if (r103 != null) goto L10;
        r103 = CollectionsKt.emptyList();
    L10:
        r101.addAll(r103);
        goto L5
    L16:
        return r101;
    L12:
        return CollectionsKt.emptyList();
    }
}
