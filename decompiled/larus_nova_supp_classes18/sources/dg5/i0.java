package dg5;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i0 implements Function1<String, Boolean> {
    public final /* synthetic */ a0 a;

    public i0(a0 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        com.bytedance.ee.bear.middleground.feed.export.bean.i r0 = this.a.l.d;
        return Boolean.valueOf(r0.d((String) r2));
    }
}
