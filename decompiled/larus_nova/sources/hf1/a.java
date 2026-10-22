package hf1;

import com.bytedance.common.utility.collection.WeakContainer;
import com.bytedance.mt.dataguard.cacheinvalidate.BusinessType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeakContainer<Object> f484912a = null;

    public a() {
    }

    static {
        a r100 = new a();
        BusinessType r101 = BusinessType.LIVE_BANNER;
        Map<BusinessType, List<Object>> r102 = q27.a.f531452a;
        monitor-enter(q27.a.class);
        if (r101 != null) goto L19;
        monitor-exit(q27.a.class);
    L17:
        f484912a = new WeakContainer();
        return;
    L19:
        Map<BusinessType, List<Object>> r103 = q27.a.f531452a;     // Catch: Throwable -> L13
        List r104 = (List) ((HashMap) r103).get(r101);     // Catch: Throwable -> L13
        if (r104 != null) goto L9;
        r104 = new ArrayList();     // Catch: Throwable -> L13
        ((HashMap) r103).put(r101, r104);     // Catch: Throwable -> L13
    L9:
        if (r104.contains(r100) == true) goto L11;
        r104.add(r100);     // Catch: Throwable -> L13
    L11:
        monitor-exit(q27.a.class);
    L13:
        th = move-exception;
        throw th;
    }
}
