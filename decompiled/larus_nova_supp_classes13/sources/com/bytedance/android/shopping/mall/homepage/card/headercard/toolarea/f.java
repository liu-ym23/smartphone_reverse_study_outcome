package com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea;

import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ToolVO;
import com.bytedance.common.utility.Logger;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f<V> implements Callable {
    public final /* synthetic */ ToolListAdapter a;
    public final /* synthetic */ int b;
    public final /* synthetic */ ToolVO c;

    public f(ToolListAdapter r1, int r2, ToolVO r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        Logger.d("ToolListAdapter", "reportToolItemOnScroll newShowIndex=" + this.b);
        final h r0 = this.a.b;
        final int r1 = this.b;
        final ToolVO r2 = this.c;
        r0.getClass();
        kk.d.c(new ToolReporter$reportItemShow$2(r0, r2, r1));
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
