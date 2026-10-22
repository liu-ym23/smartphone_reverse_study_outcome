package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.view.View;
import com.bytedance.android.ec.core.utils.LoginUtil;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionEntry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke", "com/bytedance/android/livesdk/livecommerce/promotionlist/presenter/LivePromotionListGroupPresenter$getLiveShoppingCartView$2$1$1", "com/bytedance/android/livesdk/livecommerce/promotionlist/presenter/LivePromotionListGroupPresenter$$special$$inlined$also$lambda$1"}, k = 3, mv = {1, 4, 3})
final class LivePromotionListGroupPresenter$getLiveShoppingCartView$$inlined$let$lambda$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ ECPromotionEntry $entry$inlined;
    final /* synthetic */ LivePromotionListGroupPresenter this$0;

    public LivePromotionListGroupPresenter$getLiveShoppingCartView$$inlined$let$lambda$1(ECPromotionEntry r1, LivePromotionListGroupPresenter r2) {
        this.$entry$inlined = r1;
        this.this$0 = r2;
        super(1);
    }

    public final void invoke(View r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        LivePromotionListGroupPresenter r7 = this.this$0;
        ECPromotionEntry r0 = this.$entry$inlined;
        int r1 = LivePromotionListGroupPresenter.D;
        r7.getClass();
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        r2.element = "";
        Map r3 = LoginUtil.a;
        LoginUtil.e(r7.Y().c(), "list_card_click" + r0.getTrackName(), new LivePromotionListGroupPresenter$openCartPage$1(r7, r0, r2));
        sg2.v r4 = new sg2.v("livesdk_click_" + r0.getTrackName(), r7.d0().getPromotionListParams());
        r4.c("ecom_entrance_form", "live_list_card");
        if (a2.d((String) r2.element) == null) goto L5;
        r4.c("btm_id", (String) r2.element);
    L5:
        r4.d(r0.getTrackParams());
        r4.i(null);
        xh.c.a("Live").d("good_list", "header_right_entry", MapsKt.mapOf(TuplesKt.to("item_name", r0.getTrackName())));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((View) r1);
        return Unit.INSTANCE;
    }
}
