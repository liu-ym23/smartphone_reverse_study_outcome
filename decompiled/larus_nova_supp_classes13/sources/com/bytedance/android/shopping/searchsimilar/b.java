package com.bytedance.android.shopping.searchsimilar;

import android.view.View;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.model.promotion.ECSimilarProductFunctionDescriptionViewUri;
import com.bytedance.android.ec.sdk.helper.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ SimilarProductFragment a;

    public b(SimilarProductFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        ECSimilarProductFunctionDescriptionViewUri r4 = ECSettingKeys.K0();
        if (r4 == null) goto L6;
        p.a.openSchema(this.a.getContext(), r4.getWhiteBackgroundUri());
        return;
    }
}
