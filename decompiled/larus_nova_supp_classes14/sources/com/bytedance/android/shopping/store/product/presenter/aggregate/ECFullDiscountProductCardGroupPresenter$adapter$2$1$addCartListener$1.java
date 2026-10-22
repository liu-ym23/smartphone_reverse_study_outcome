package com.bytedance.android.shopping.store.product.presenter.aggregate;

import android.view.View;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.apm.constant.UploadTypeInf;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", UploadTypeInf.COUNT, "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class ECFullDiscountProductCardGroupPresenter$adapter$2$1$addCartListener$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ ECFullDiscountProductCardGroupPresenter$adapter$2.AnonymousClass1 this$0;

    public ECFullDiscountProductCardGroupPresenter$adapter$2$1$addCartListener$1(ECFullDiscountProductCardGroupPresenter$adapter$2.AnonymousClass1 r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(final int r9) {
        WeakReference<View> r0 = this.this$0.a.getDestView();
        if (r0 == null) goto L10;
        View r3 = r0.get();
        if (r3 == null) goto L11;
        int r1 = ECSdk.a;
        IECCommonService r2 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r2 == null) goto L12;
        IECCommonService.a.b(r2, this.this$0.d.this$0.Z().b(2131387382).f(), r3, 1999, Boolean.FALSE, new ECFullDiscountProductCardGroupPresenter$adapter$2$1$addCartListener$1$$special$$inlined$let$lambda$1(this, r9), 480);
        return;
    L12:
        return;
    L11:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Number) r1).intValue());
        return Unit.INSTANCE;
    }
}
