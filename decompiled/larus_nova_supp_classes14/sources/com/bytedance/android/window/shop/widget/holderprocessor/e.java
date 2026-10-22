package com.bytedance.android.window.shop.widget.holderprocessor;

import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import com.bytedance.android.window.shop.holder.WindowGroupHolder;
import com.bytedance.android.window.shop.holder.WindowLynxHolder;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.s;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends gr3.d {
    public final Function0<WindowLayoutType> a;
    public final Function1<Integer, Integer> b;

    /* JADX WARN: Multi-variable type inference failed */
    public e(Function0<? extends WindowLayoutType> r2, Function1<? super Integer, Integer> r3) {
        Intrinsics.checkNotNullParameter(r2, "layoutTypeFetcher");
        Intrinsics.checkNotNullParameter(r3, "positionMapper");
        this.a = r2;
        this.b = r3;
    }

    @Override // gr3.d
    public final void a(ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r3, com.bytedance.android.window.shop.repository.tab.entity.f r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r4, "vo");
        if ((r3 instanceof WindowLynxHolder) == false) goto L6;
        WindowLynxHolder r6 = (WindowLynxHolder) r3;
        WindowLayoutType r0 = (WindowLayoutType) this.a.invoke();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r6.w = r0;
    L8:
        s.c(r4, ((Number) this.b.invoke(Integer.valueOf(r5))).intValue());
        return;
    L6:
        if ((r3 instanceof WindowGroupHolder) == false) goto L8;
        ((WindowGroupHolder) r3).u4((WindowLayoutType) this.a.invoke());
        goto L8
    }
}
