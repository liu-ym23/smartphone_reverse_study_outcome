package com.bytedance.android.shopping.mall.background;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import yj.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class DYLiteBackground$onThemeChangeListener$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ c this$0;

    public DYLiteBackground$onThemeChangeListener$1(c r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(boolean r6) {
        c r0 = this.this$0;
        r0.getClass();
        if (r6 == false) goto L5;
        String r7 = "dark";
    L6:
        int r1 = s93.c.a;
        Object r2 = 0;
        IHybridHostService r3 = com.bytedance.android.ec.hybrid.a.h();
        if (r3 == null) goto L14;
        g r4 = r3.getHostAB();
        if (r4 == null) goto L14;
        Object r5 = r4.a("ec_mall_theme_update_opt", r2);
        if (r5 == null) goto L14;
        r2 = r5;
    L14:
        Lazy r8 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : ec_mall_theme_update_opt, Value: " + r2);
        if (((Number) r2).intValue() > 0) goto L17;
    L19:
        r0.a = r7;
        throw null;
    L17:
        if (Intrinsics.areEqual(r0.a, r7) == false) goto L19;
        return;
    L5:
        r7 = "light";
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Boolean) r1).booleanValue());
        return Unit.INSTANCE;
    }
}
