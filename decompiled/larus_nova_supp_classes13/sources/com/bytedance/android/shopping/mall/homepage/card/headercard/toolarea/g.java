package com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea;

import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ToolVO;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g<V> implements Callable {
    public final /* synthetic */ int a;
    public final /* synthetic */ ToolVO b;
    public final /* synthetic */ ToolListAdapter c;
    public final /* synthetic */ Map d;

    public g(int r1, ToolVO r2, ToolListAdapter r3, Map r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        h r0 = this.c.b;
        int r1 = this.a;
        ToolVO r2 = this.b;
        Map r3 = this.d;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "globalProps");
        kk.d.c(new ToolReporter$reportItemShow$1(r0, r2, r1, r3));
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
