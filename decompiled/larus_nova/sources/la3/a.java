package la3;

import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.shopping.buynow.data.model.BuyNowOrderSchema;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {
    public static final BuyNowOrderSchema a(IOrderSchema r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$convert");
        return new BuyNowOrderSchema(r100.formatToUrl(), r100.W0());
    }
}
