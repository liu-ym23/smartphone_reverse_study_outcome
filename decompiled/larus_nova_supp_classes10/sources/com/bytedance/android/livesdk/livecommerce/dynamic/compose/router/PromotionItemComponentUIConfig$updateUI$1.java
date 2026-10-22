package com.bytedance.android.livesdk.livecommerce.dynamic.compose.router;

import com.bytedance.android.ec.common.api.NewPromotionListItemModuleName;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"getVisibility", "", "module", "Lcom/bytedance/android/ec/common/api/NewPromotionListItemModuleName;", "invoke"}, k = 3, mv = {1, 4, 3})
public final class PromotionItemComponentUIConfig$updateUI$1 extends Lambda implements Function1<NewPromotionListItemModuleName, Integer> {
    final /* synthetic */ JSONObject $canShowModule;

    public PromotionItemComponentUIConfig$updateUI$1(JSONObject r1) {
        this.$canShowModule = r1;
        super(1);
    }

    public final int invoke(NewPromotionListItemModuleName r3) {
        Intrinsics.checkNotNullParameter(r3, "module");
        JSONObject r0 = this.$canShowModule;
        if (r0 != null) goto L5;
        return 1;
    L5:
        if (r0.optBoolean(r3.getModuleName(), true) != true) goto L9;
        return 0;
    L9:
        return 1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return Integer.valueOf(invoke((NewPromotionListItemModuleName) r1));
    }
}
