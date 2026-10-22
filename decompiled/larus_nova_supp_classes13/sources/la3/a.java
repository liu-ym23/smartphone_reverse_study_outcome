package la3;

import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.shopping.buynow.data.model.BuyNowOrderSchema;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final BuyNowOrderSchema a(IOrderSchema r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$convert");
        return new BuyNowOrderSchema(r2.formatToUrl(), r2.W0());
    }
}
