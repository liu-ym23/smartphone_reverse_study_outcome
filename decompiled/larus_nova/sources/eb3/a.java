package eb3;

import com.bytedance.android.ecom.arch.slice.render.e;
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
        if (r100.hashCode() == 410461789) goto L6;
    L8:
        return 0.0f;
    L6:
        if (r100.equals("view_only_with_1.15_large") == false) goto L8;
        return RangesKt.coerceAtMost(1.15f, LargeFontModeUtil.a());
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.e
    public final float b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "customScaleKey");
        if (r100.hashCode() == 410461789) goto L6;
    L8:
        return 0.0f;
    L6:
        if (r100.equals("view_only_with_1.15_large") == false) goto L8;
        return RangesKt.coerceAtMost(1.15f, LargeFontModeUtil.a());
    }
}
