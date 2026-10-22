package com.bytedance.android.window.shop.home.tab.presenter;

import com.bytedance.android.ec.window.base.status.WindowLazyStatusView;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowLayoutType;", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECWindowTabPresenterDeprecated$onLayoutControlInitialized$2 extends Lambda implements Function1<WindowLayoutType, Unit> {
    final /* synthetic */ ECWindowTabPresenterDeprecated this$0;

    public ECWindowTabPresenterDeprecated$onLayoutControlInitialized$2(ECWindowTabPresenterDeprecated r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(WindowLayoutType r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        ECWindowTabPresenterDeprecated r0 = this.this$0;
        int r1 = ECWindowTabPresenterDeprecated.x;
        r0.j0().updateUserLayoutType(r5);
        int r2 = ECWindowTabPresenterDeprecated.d0(this.this$0).r();
        this.this$0.i0().G2(r5);
        ECWindowTabPresenterDeprecated r3 = this.this$0;
        WindowLazyStatusView r4 = r3.j;
        if (r4 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L6:
        if (r5.isSingleColumn() == false) goto L8;
        com.bytedance.android.ec.window.base.status.c.e r6 = com.bytedance.android.ec.window.base.status.c.e.a;
    L9:
        r4.b(r6);
        r3.o0(r3.i0().h);
        r3.i0().notifyDataSetChanged();
        ECWindowTabPresenterDeprecated.d0(this.this$0).scrollToPosition(r2);
        return;
    L8:
        r6 = com.bytedance.android.ec.window.base.status.c.a.a;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((WindowLayoutType) r1);
        return Unit.INSTANCE;
    }
}
