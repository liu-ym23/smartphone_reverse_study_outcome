package com.bytedance.android.shopping.sku.common.function;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuRunCatchExtKt;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.event.common.e;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuCommonScrollToViewFunction {
    public final AndroidYaTaInstance a;
    public final e b;
    public final RecyclerView c;
    public final SlcRenderContext d;
    public final mh3.a e;

    public final void b() {
        SkuRunCatchExtKt.a(null, "SkuCommonScrollToViewFunction", new SkuCommonScrollToViewFunction$doAction$1(this));
    }

    public static final void a(SkuCommonScrollToViewFunction r4, View r5, boolean r6) {
        r4.getClass();
        int[] r0 = new int[2];
        r5.getLocationInWindow(r0);
        Unit r7 = Unit.INSTANCE;
        Integer r1 = ArraysKt.getOrNull(r0, 1);
        if (r1 == null) goto L5;
        final int r2 = r1.intValue();
    L6:
        r4.c.getLocationInWindow(r0);
        Integer r8 = ArraysKt.getOrNull(r0, 1);
        if (r8 == null) goto L9;
        final int r9 = r8.intValue();
    L10:
        Lazy r3 = SkuCommonLog.a;
        SkuCommonLog.a("SkuCommonScrollToViewFunction", new SkuCommonScrollToViewFunction$doScroll$1(r2, r9));
        if (r6 == false) goto L13;
        r4.c.smoothScrollBy(0, r2 - r9);
        return;
    L13:
        r4.c.scrollBy(0, r2 - r9);
        return;
    L9:
        r9 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public SkuCommonScrollToViewFunction(AndroidYaTaInstance r2, com.bytedance.kmp.ec.yata.event.core.a r3, RecyclerView r4, SlcRenderContext r5, mh3.a r6) {
        Intrinsics.checkNotNullParameter(r2, "yataInstance");
        Intrinsics.checkNotNullParameter(r3, "input");
        Intrinsics.checkNotNullParameter(r4, "bodyRecyclerView");
        Intrinsics.checkNotNullParameter(r5, "slcRenderContext");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
