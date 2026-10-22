package com.bytedance.android.shopping.mall.settings;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MallSettings {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;

    public static boolean a() {
        return ((Boolean) a.getValue()).booleanValue();
    }

    static {
        a = LazyKt.lazy(MallSettings$mallMemoryOptEnable$2.INSTANCE);
        b = LazyKt.lazy(MallSettings$fixChunkMemoryLeak$2.INSTANCE);
        c = LazyKt.lazy(MallSettings$mallFeedSupportSplitScreen$2.INSTANCE);
        d = LazyKt.lazy(MallSettings$mallFeedComponentV3Enable$2.INSTANCE);
    }
}
