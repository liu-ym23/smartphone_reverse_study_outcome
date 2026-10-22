package com.bytedance.android.shopping.store.router.hybridpage.setting;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class HybridPageConfigSetting {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final boolean d = false;
    public static final Lazy e = null;
    public static final boolean f = false;

    static {
        a = LazyKt.lazy(HybridPageConfigSetting$sliceConfigSetting$2.INSTANCE);
        b = LazyKt.lazy(HybridPageConfigSetting$classificationSliceConfigSetting$2.INSTANCE);
        Lazy r0 = LazyKt.lazy(HybridPageConfigSetting$sliceSearchResultPage$2.INSTANCE);
        c = r0;
        boolean r1 = false;
        if (((Number) r0.getValue()).intValue() <= 0) goto L5;
        boolean r2 = true;
    L6:
        d = r2;
        Lazy r3 = LazyKt.lazy(HybridPageConfigSetting$sliceClassificationPage$2.INSTANCE);
        e = r3;
        if (((Number) r3.getValue()).intValue() <= 0) goto L9;
        r1 = true;
    L9:
        f = r1;
        return;
    L5:
        r2 = false;
        goto L6
    }
}
