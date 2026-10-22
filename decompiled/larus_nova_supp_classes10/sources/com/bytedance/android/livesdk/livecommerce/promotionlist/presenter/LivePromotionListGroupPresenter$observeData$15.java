package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.bytedance.android.livesdk.livecommerce.iron.widgets.IronPromotionListToast;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/a$k;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/a$k;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LivePromotionListGroupPresenter$observeData$15 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.k, Unit> {
    public LivePromotionListGroupPresenter$observeData$15(LivePromotionListGroupPresenter r8) {
        super(1, r8, LivePromotionListGroupPresenter.class, "showListUpdateToast", "showListUpdateToast(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/LivePromotionListEvent$ListUpdateToast;)V", 0);
    }

    public final void invoke(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.k r9) {
        Intrinsics.checkNotNullParameter(r9, "p1");
        LivePromotionListGroupPresenter r0 = (LivePromotionListGroupPresenter) ((CallableReference) this).receiver;
        int r1 = LivePromotionListGroupPresenter.D;
        r0.getClass();
        si2.m r10 = r9.a;
        String r2 = r10.a;
        PromotionCategory r3 = r0.d0().getCurrentCategory();
        int r4 = 0;
        if (r3 != null) goto L5;
    L10:
        boolean r5 = false;
    L12:
        if (r10.b == true) goto L14;
    L16:
        boolean r7 = false;
    L17:
        if (r5 == true) goto L26;
        if (r7 == true) goto L26;
        if (r2 != null) goto L21;
    L24:
        boolean r6 = true;
    L25:
        if (r6 == true) goto L26;
    L27:
        if (r4 != 0) goto L32;
        IronPromotionListToast r8 = r0.m;
        if (r8 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("toastView");
    L31:
        r8.b(r2);
    L32:
        int r11 = r10.c;
        if (r11 == 1) goto L43;
        if (r11 != 2) goto L36;
        String r12 = "explain_update";
    L44:
        sg2.v r13 = new sg2.v("livesdk_list_update_prompt_show", r0.d0().getPromotionListParams());
        r13.a("product_num", r0.d0().getTotal());
        r13.c("toast_type", r12);
        r13.a("is_toast", r4 ^ 1);
        r13.i(null);
        return;
    L36:
        if (r11 != 3) goto L38;
        r12 = "cancel_explain";
        goto L44
    L38:
        if (r11 == 4) goto L40;
        r12 = "";
        goto L44
    L40:
        r12 = "classify_update";
        goto L44
    L43:
        r12 = "product_update";
        goto L44
    L21:
        if (r2.length() == 0) goto L24;
        r6 = false;
    L26:
        r4 = 1;
        goto L27
    L14:
        if (r10.c != 2) goto L16;
        r7 = true;
        goto L17
    L5:
        if (r3.isAllTab() == true) goto L10;
        if (r2 == null) goto L10;
        if (StringsKt.contains$default(r2, "讲解", false, 2, null) != true) goto L10;
        r5 = true;
        goto L12
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.k) r1);
        return Unit.INSTANCE;
    }
}
