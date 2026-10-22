package com.bytedance.android.shopping.mall.homepage.pagecard;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.k;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ PageCard a;
    public final /* synthetic */ List b;

    public a(PageCard r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        Function0<Unit> r5 = this.a.h;
        if (r5 == null) goto L5;
        r5.invoke();
        nf3.a r6 = this.a.m;
        int r0 = nf3.a.c;
        r6.a(false, false);
        Lazy r7 = ECMallLogUtil.a;
        ECMallLogUtil.c(k.b.b, "pagecard asyncGetDynamicParams timeout : " + this.b);
    L5:
        this.a.h = null;
    }
}
