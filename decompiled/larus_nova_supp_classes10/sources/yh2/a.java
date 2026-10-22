package yh2;

import com.bytedance.android.ec.model.live.ECPromotionInterationData;
import com.bytedance.android.ec.model.live.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public volatile boolean a;
    public final List<ECPromotionInterationData> b;
    public List<ECPromotionInterationData> c;

    public final synchronized List<ECPromotionInterationData> b() {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L6
        r0.addAll(this.b);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public a() {
        this.a = true;
        this.b = new ArrayList();
    }

    public static boolean a(List r5, m r6) {
        if (r6 != null) goto L5;
        return true;
    L5:
        Iterator r7 = r5.iterator();
    L7:
        if (r7.hasNext() == false) goto L19;
        ql.a r1 = (ql.a) r7.next();
        if (Intrinsics.areEqual(r1.getProductId(), String.valueOf(r6.b())) == false) goto L7;
        if (r6.a() == r1.getIronIndex()) goto L18;
        return false;
    L18:
        return true;
    L19:
        return true;
    }
}
