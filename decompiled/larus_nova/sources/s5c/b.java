package s5c;

import com.ss.android.lark.statistics.extensions.ParamsCollection;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public final class b {
    public static final d a(Map<String, ? extends Object> r100, d r101) {
        if ((r101 instanceof ParamsCollection) == false) goto L6;
        return r101.plus(r100);
    L6:
        return new ParamsCollection(r101).plus(r100);
    }
}
