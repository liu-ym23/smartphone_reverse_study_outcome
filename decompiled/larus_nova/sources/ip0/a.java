package ip0;

import java.util.Iterator;
import java.util.List;
import kotlin.Result;

/* JADX INFO: loaded from: classes46.dex */
public final class a {
    public static final com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.c a(Object r100, long r101) {
        Object r102 = null;
        if (Result.m9455isFailureimpl(r100) == false) goto L5;
        r100 = null;
    L5:
        b r103 = (b) r100;
        if (r103 == null) goto L25;
        List<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.c> r104 = r103.f495251c;
        if (r104 == null) goto L26;
        Iterator<T> r105 = r104.iterator();
    L11:
        if (r105.hasNext() == false) goto L19;
        Object r106 = r105.next();
        if (((com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.c) r106).groupId != r101) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == false) goto L11;
        r102 = r106;
        goto L19
    L15:
        r107 = false;
    L19:
        return (com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.c) r102;
    L26:
        return null;
    L25:
        return null;
    }
}
