package l93;

import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class b {
    public static final String a(Object r100) {
        if ((r100 instanceof String) == false) goto L7;
        return (String) r100;
    L7:
        if ((r100 instanceof Map) == false) goto L15;
        Object r101 = ((Map) r100).get(ScoreTags.STAR_URL_LIST);
        if ((r101 instanceof List) == true) goto L11;
        r101 = null;
    L11:
        List r102 = (List) r101;
        if (r102 != null) goto L14;
        return null;
    L14:
        return (String) CollectionsKt.getOrNull(r102, 0);
    L15:
        return null;
    }
}
