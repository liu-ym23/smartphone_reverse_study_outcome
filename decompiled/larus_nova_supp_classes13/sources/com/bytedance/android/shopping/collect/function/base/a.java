package com.bytedance.android.shopping.collect.function.base;

import com.bytedance.android.shopping.collect.container.CollectYataFragment;
import com.bytedance.android.shopping.collect.util.CollectCommonLog;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends com.bytedance.kmp.ec.yata.event.common.a {
    public final CollectYataFragment a;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.collect.function.base.a$a, reason: collision with other inner class name */
    public static final class C0045a {
    }

    static {
    }

    public a(CollectYataFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r6, Function1 r7) {
        Intrinsics.checkNotNullParameter(r6, "input");
        Intrinsics.checkNotNullParameter(r7, "chainNextCallback");
        CollectCommonLog.c("CollectSelfFun-selfDelay", "selfDelay");
        Map r8 = r6.q();
        if (r8 == null) goto L5;
        Object r9 = r8.get("duration");
    L7:
        if ((r9 instanceof Long) == true) goto L9;
        r9 = null;
    L9:
        Long r10 = (Long) r9;
        if (r10 == null) goto L12;
        long r3 = r10.longValue();
    L14:
        if (r3 > 0) goto L16;
        int r11 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r7.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    L16:
        com.bytedance.android.ec.core.async.a.a(Completable.timer(r3, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(new b(r3, r7)), this.a);
        return;
    L12:
        r3 = 0;
        goto L14
    L5:
        r9 = null;
        goto L7
    }
}
