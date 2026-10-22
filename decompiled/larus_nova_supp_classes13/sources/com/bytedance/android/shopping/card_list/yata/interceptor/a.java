package com.bytedance.android.shopping.card_list.yata.interceptor;

import aa6.b;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final AtomicReference<Pair<Long, e>> a;
    public final AtomicReference<b> b;
    public final CardListObjectContainer c;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.card_list.yata.interceptor.a$a, reason: collision with other inner class name */
    public static final class C0039a {
    }

    static {
    }

    public final long a() {
        Pair<Long, e> r0 = this.a.get();
        if (r0 == null) goto L7;
        Long r1 = (Long) r0.getFirst();
        if (r1 == null) goto L7;
        long r2 = r1.longValue();
    L8:
        dm.a.a("RollBackImpl").i("getRollBackVersion: " + r2);
        return r2;
    L7:
        r2 = Long.MIN_VALUE;
        goto L8
    }

    public a(CardListObjectContainer r4) {
        Intrinsics.checkNotNullParameter(r4, "objectContainer");
        this.c = r4;
        this.a = new AtomicReference(new Pair(Long.MIN_VALUE, null));
        this.b = new AtomicReference(null);
    }
}
