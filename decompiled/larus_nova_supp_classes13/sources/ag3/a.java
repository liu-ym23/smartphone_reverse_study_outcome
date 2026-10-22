package ag3;

import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends com.bytedance.android.ecom.arch.slice.render.cache.a {
    public final boolean a() {
        return true;
    }

    public final String getElementType() {
        return "View";
    }

    public final int b() {
        Lazy r0 = CartSettingUtils.a;
        return ((Number) CartSettingUtils.d.getValue()).intValue();
    }

    public a() {
    }
}
