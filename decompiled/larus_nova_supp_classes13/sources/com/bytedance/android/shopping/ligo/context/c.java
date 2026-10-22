package com.bytedance.android.shopping.ligo.context;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.hybrid.list.util.k;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements z83.a {
    public final CopyOnWriteArraySet<String> a;

    public static final class a {
    }

    static {
    }

    public c() {
        this.a = new CopyOnWriteArraySet();
    }

    @Override // z83.a
    public void onEvent(z83.b r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (this.a.contains(r5.a) == true) goto L5;
        dm.a.a("LigoContext").a("event " + r5.a + " is not registered for hybrid");
        return;
    L5:
        if ((r5 instanceof we3.a) == false) goto L9;
        dm.a.a("LigoContext").i("send event to hybrid: " + r5.a + ' ');
        dm.a.b r0 = dm.a.a("LigoContext");
        StringBuilder r1 = new StringBuilder("params is: ");
        we3.a r2 = (we3.a) r5;
        r1.append(r2.b);
        r0.a(r1.toString());
        ECLiveHybridUtil.f(r5.a, k.b(r2.b));
        return;
    }
}
