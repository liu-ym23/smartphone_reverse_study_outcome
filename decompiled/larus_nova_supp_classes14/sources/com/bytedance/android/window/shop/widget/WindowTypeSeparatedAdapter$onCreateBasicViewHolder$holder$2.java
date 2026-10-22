package com.bytedance.android.window.shop.widget;

import android.view.View;
import com.bytedance.android.ec.window.base.product.lynxcard.ECLynxCardEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "p1", "Lcom/bytedance/android/ec/window/base/product/lynxcard/ECLynxCardEvent;", "p2", "", "invoke", "(Lcom/bytedance/android/window/shop/repository/tab/entity/f;Lcom/bytedance/android/ec/window/base/product/lynxcard/ECLynxCardEvent;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class WindowTypeSeparatedAdapter$onCreateBasicViewHolder$holder$2 extends FunctionReferenceImpl implements Function2<com.bytedance.android.window.shop.repository.tab.entity.f, ECLynxCardEvent, Unit> {
    public WindowTypeSeparatedAdapter$onCreateBasicViewHolder$holder$2(WindowTypeSeparatedAdapter r8) {
        super(2, r8, WindowTypeSeparatedAdapter.class, "postFallbackEvent", "postFallbackEvent(Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;Lcom/bytedance/android/ec/window/base/product/lynxcard/ECLynxCardEvent;)V", 0);
    }

    public final void invoke(com.bytedance.android.window.shop.repository.tab.entity.f r4, ECLynxCardEvent r5) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        Intrinsics.checkNotNullParameter(r5, "p2");
        WindowTypeSeparatedAdapter r0 = (WindowTypeSeparatedAdapter) ((CallableReference) this).receiver;
        View r1 = r0.o.getView();
        if (r1 == null) goto L6;
        r1.post(new y(r0, r5, r4));
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((com.bytedance.android.window.shop.repository.tab.entity.f) r1, (ECLynxCardEvent) r2);
        return Unit.INSTANCE;
    }
}
