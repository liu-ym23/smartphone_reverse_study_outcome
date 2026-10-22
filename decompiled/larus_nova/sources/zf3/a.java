package zf3;

import com.bytedance.android.ecom.arch.slice.render.e;
import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import com.bytedance.android.shopping.utils.LargeFontModeUtil;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements e {
    public a() {
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.e
    public final float a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "customScaleKey");
        if (CartSettingUtils.b() == true) goto L5;
    L10:
        return 0.0f;
    L5:
        if (r100.hashCode() != 410461789) goto L10;
        if (r100.equals("view_only_with_1.15_large") == false) goto L10;
        return RangesKt.coerceAtMost(1.15f, LargeFontModeUtil.a());
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.e
    public final float b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "customScaleKey");
        if (CartSettingUtils.b() == true) goto L5;
    L10:
        return 0.0f;
    L5:
        if (r100.hashCode() != 410461789) goto L10;
        if (r100.equals("view_only_with_1.15_large") == false) goto L10;
        return RangesKt.coerceAtMost(1.15f, LargeFontModeUtil.a());
    }
}
