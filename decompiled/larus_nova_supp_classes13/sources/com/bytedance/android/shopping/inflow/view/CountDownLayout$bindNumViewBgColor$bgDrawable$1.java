package com.bytedance.android.shopping.inflow.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/commerce/base/drawable/c;", "", "invoke", "(Lcom/bytedance/commerce/base/drawable/c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class CountDownLayout$bindNumViewBgColor$bgDrawable$1 extends Lambda implements Function1<com.bytedance.commerce.base.drawable.c, Unit> {
    final /* synthetic */ String $bgColor;

    public CountDownLayout$bindNumViewBgColor$bgDrawable$1(String r1) {
        this.$bgColor = r1;
        super(1);
    }

    public final void invoke(com.bytedance.commerce.base.drawable.c r3) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        r3.a(com.bytedance.android.shopping.extensions.a.a(this.$bgColor, 0));
        r3.c(AnonymousClass1.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.commerce.base.drawable.c) r1);
        return Unit.INSTANCE;
    }
}
