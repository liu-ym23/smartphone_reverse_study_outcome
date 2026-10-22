package ch3;

import android.content.Context;
import com.bytedance.android.shopping.product.flow.view.bottom.ProductFlowCardSimpleAbilityView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static ProductFlowCardSimpleAbilityView a(Context r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, "text");
        ProductFlowCardSimpleAbilityView r0 = new ProductFlowCardSimpleAbilityView(r4, null, 6, 0);
        r0.setIcon(r5);
        r0.setText(r6);
        return r0;
    }
}
