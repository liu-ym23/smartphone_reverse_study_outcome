package ag3;

import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends com.bytedance.android.ecom.arch.slice.render.cache.a {
    public final boolean a() {
        return true;
    }

    public final String getElementType() {
        return "Text";
    }

    public final int b() {
        Lazy r0 = CartSettingUtils.a;
        return ((Number) CartSettingUtils.b.getValue()).intValue();
    }

    public c() {
    }
}
