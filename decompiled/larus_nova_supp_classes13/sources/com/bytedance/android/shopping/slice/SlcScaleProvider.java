package com.bytedance.android.shopping.slice;

import com.bytedance.android.ecom.arch.slice.render.e;
import com.bytedance.android.shopping.utils.LargeFontModeUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SlcScaleProvider implements e {
    public final Lazy a;

    public SlcScaleProvider() {
        this.a = LazyKt.lazy(SlcScaleProvider$expSwitch$2.INSTANCE);
    }

    public final float a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "customScaleKey");
        if (((Number) this.a.getValue()).intValue() == 1) goto L5;
    L10:
        return 0.0f;
    L5:
        if (r3.hashCode() != (-1986907590)) goto L10;
        if (r3.equals("original_view_no_extra_large") == false) goto L10;
        return RangesKt.coerceAtMost(1.15f, LargeFontModeUtil.a());
    }

    public final float b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "customScaleKey");
        if (((Number) this.a.getValue()).intValue() != 1) goto L15;
        int r0 = r3.hashCode();
        if (r0 == (-1986907590)) goto L13;
        if (r0 != 1863443539) goto L15;
        if (r3.equals("original_view") == false) goto L15;
    L14:
        return 1.0f;
    L13:
        if (r3.equals("original_view_no_extra_large") == true) goto L14;
    L15:
        return 0.0f;
    }
}
