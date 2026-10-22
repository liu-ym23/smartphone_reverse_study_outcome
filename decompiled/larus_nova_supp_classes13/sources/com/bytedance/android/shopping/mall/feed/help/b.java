package com.bytedance.android.shopping.mall.feed.help;

import android.os.Debug;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b<V> implements Callable {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        a r0 = this.a;
        Runtime.getRuntime().totalMemory();
        int r1 = a.e;
        r0.getClass();
        a r2 = this.a;
        Integer r3 = StringsKt.toIntOrNull(Debug.getRuntimeStat("art.gc.gc-count"));
        if (r3 == null) goto L5;
        int r4 = r3.intValue();
    L6:
        r2.a = r4;
        this.a.a();
        return;
    L5:
        r4 = 0;
        goto L6
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
