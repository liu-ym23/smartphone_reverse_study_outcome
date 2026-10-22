package com.bytedance.android.shopping.api.mall.common.tools;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MallServiceUtil {
    public static final Lazy a = null;
    public static final Lazy b = null;

    public static yj.u a() {
        return (yj.u) a.getValue();
    }

    static {
        a = LazyKt.lazy(MallServiceUtil$MallPluginCheck$2.INSTANCE);
        b = LazyKt.lazy(MallServiceUtil$mallFrescoService$2.INSTANCE);
    }
}
