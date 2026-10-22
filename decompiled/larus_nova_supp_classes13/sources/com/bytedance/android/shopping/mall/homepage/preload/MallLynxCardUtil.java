package com.bytedance.android.shopping.mall.homepage.preload;

import com.bytedance.android.ec.hybrid.anniex.ECLynxAnnieXExperiment;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxLoadType;
import com.bytedance.android.ec.hybrid.card.service.ECLynxAnnieXService;
import com.bytedance.android.ec.hybrid.list.util.q;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MallLynxCardUtil implements q {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final String e;

    public MallLynxCardUtil(String r2) {
        Intrinsics.checkNotNullParameter(r2, "pageName");
        this.e = r2;
        this.a = LazyKt.lazy(new MallLynxCardUtil$alreadyPreTemplate$2(this));
        this.b = LazyKt.lazy(new MallLynxCardUtil$alreadyPreCreateView$2(this));
        this.c = LazyKt.lazy(new MallLynxCardUtil$annieXPreCreateItems$2(this));
        this.d = LazyKt.lazy(new MallLynxCardUtil$annieXPreLoadItems$2(this));
    }

    public final ECLynxLoadType a(int r4) {
        Lazy r0 = ECLynxAnnieXService.a;
        if (ECLynxAnnieXExperiment.c().a == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L19;
        Set r2 = (Set) this.d.getValue();
        if (r2 != null) goto L12;
    L13:
        Set r3 = (Set) this.a.getValue();
        if (r3 == null) goto L26;
        if (r3.contains(Integer.valueOf(r4)) != true) goto L26;
    L18:
        return ECLynxLoadType.PRE_LOAD;
    L26:
        if (ECLynxAnnieXService.b() == false) goto L33;
        CopyOnWriteArraySet r5 = (CopyOnWriteArraySet) this.c.getValue();
        if (r5 == null) goto L40;
        if (r5.contains(Integer.valueOf(r4)) != true) goto L40;
        return ECLynxLoadType.PRE_CREATE_VIEW;
    L40:
        return ECLynxLoadType.DEFAULT;
    L33:
        CopyOnWriteArraySet r6 = (CopyOnWriteArraySet) this.b.getValue();
        if (r6 == null) goto L40;
        if (r6.contains(Integer.valueOf(r4)) != true) goto L40;
        return ECLynxLoadType.PRE_CREATE_VIEW;
    L12:
        if (r2.contains(Integer.valueOf(r4)) == true) goto L18;
    L19:
        Set r7 = (Set) this.a.getValue();
        if (r7 == null) goto L26;
        if (r7.contains(Integer.valueOf(r4)) != true) goto L26;
        return ECLynxLoadType.PRE_LOAD;
    L5:
        if (ECLynxAnnieXExperiment.c().m == false) goto L7;
        r1 = true;
        goto L8
    }
}
