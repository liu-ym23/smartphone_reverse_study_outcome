package com.bytedance.android.shopping.mall.feed.opt;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MallFixSetting {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    static {
        a = LazyKt.lazy(MallFixSetting$updateTabIdOnLoadFeed$2.INSTANCE);
        b = LazyKt.lazy(MallFixSetting$fetchByUserOnly0$2.INSTANCE);
        c = LazyKt.lazy(MallFixSetting$fixCardShowEvent$2.INSTANCE);
    }
}
