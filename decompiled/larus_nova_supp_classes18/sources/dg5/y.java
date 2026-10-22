package dg5;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y implements Function1<String, Unit> {
    public final /* synthetic */ a0 a;

    public y(a0 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        com.bytedance.ee.bear.middleground.feed.export.bean.i r0 = this.a.l.d;
        r0.a((String) r2);
        return Unit.INSTANCE;
    }
}
