package eb3;

import com.bytedance.android.ecom.arch.slice.render.e;
import com.bytedance.android.shopping.utils.LargeFontModeUtil;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements e {
    public a() {
    }

    public final float a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "customScaleKey");
        if (r3.hashCode() == 410461789) goto L6;
    L8:
        return 0.0f;
    L6:
        if (r3.equals("view_only_with_1.15_large") == false) goto L8;
        return RangesKt.coerceAtMost(1.15f, LargeFontModeUtil.a());
    }

    public final float b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "customScaleKey");
        if (r3.hashCode() == 410461789) goto L6;
    L8:
        return 0.0f;
    L6:
        if (r3.equals("view_only_with_1.15_large") == false) goto L8;
        return RangesKt.coerceAtMost(1.15f, LargeFontModeUtil.a());
    }
}
