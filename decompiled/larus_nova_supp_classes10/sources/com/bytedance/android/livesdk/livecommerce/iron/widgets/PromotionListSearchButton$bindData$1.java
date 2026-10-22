package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.livesdk.livecommerce.event.z0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
final class PromotionListSearchButton$bindData$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ String $searchSchema;
    final /* synthetic */ PromotionListSearchButton this$0;

    public PromotionListSearchButton$bindData$1(PromotionListSearchButton r1, String r2) {
        this.this$0 = r1;
        this.$searchSchema = r2;
        super(1);
    }

    public final void invoke(View r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        p.a.openSchema(this.this$0.getContext(), this.$searchSchema);
        z0 r5 = new z0(false);
        Intrinsics.checkNotNullParameter("icon", "style");
        r5.f("search_entrance_style", "icon");
        Intrinsics.checkNotNullParameter("button", "clickArea");
        r5.f("click_area", "button");
        r5.o(this.$searchSchema);
        r5.d("list_top_display_status", 0);
        r5.l("a1.b0715.c9204.d70073", BtmSDK.INSTANCE.getPageId(PageFinder.via(this.this$0)));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((View) r1);
        return Unit.INSTANCE;
    }
}
