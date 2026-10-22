package zf3;

import com.bytedance.android.ecom.arch.slice.render.e;
import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import com.bytedance.android.shopping.utils.LargeFontModeUtil;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements e {
    public a() {
    }

    public final float a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "customScaleKey");
        if (CartSettingUtils.b() == true) goto L5;
    L10:
        return 0.0f;
    L5:
        if (r3.hashCode() != 410461789) goto L10;
        if (r3.equals("view_only_with_1.15_large") == false) goto L10;
        return RangesKt.coerceAtMost(1.15f, LargeFontModeUtil.a());
    }

    public final float b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "customScaleKey");
        if (CartSettingUtils.b() == true) goto L5;
    L10:
        return 0.0f;
    L5:
        if (r3.hashCode() != 410461789) goto L10;
        if (r3.equals("view_only_with_1.15_large") == false) goto L10;
        return RangesKt.coerceAtMost(1.15f, LargeFontModeUtil.a());
    }
}
