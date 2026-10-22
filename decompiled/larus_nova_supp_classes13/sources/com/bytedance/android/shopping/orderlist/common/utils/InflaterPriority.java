package com.bytedance.android.shopping.orderlist.common.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/utils/InflaterPriority;", "", "ORIGIN_ASYNC_CONTEXT", "ASYNC_ORIGIN_CONTEXT", "CONTEXT_ORIGIN_ASYNC", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InflaterPriority extends Enum<InflaterPriority> {
    public static final InflaterPriority ASYNC_ORIGIN_CONTEXT = null;
    public static final InflaterPriority CONTEXT_ORIGIN_ASYNC = null;
    public static final InflaterPriority ORIGIN_ASYNC_CONTEXT = null;
    public static final /* synthetic */ InflaterPriority[] a = null;

    static {
        InflaterPriority r1 = new InflaterPriority("ORIGIN_ASYNC_CONTEXT", 0);
        ORIGIN_ASYNC_CONTEXT = r1;
        InflaterPriority r2 = new InflaterPriority("ASYNC_ORIGIN_CONTEXT", 1);
        ASYNC_ORIGIN_CONTEXT = r2;
        InflaterPriority r3 = new InflaterPriority("CONTEXT_ORIGIN_ASYNC", 2);
        CONTEXT_ORIGIN_ASYNC = r3;
        a = new InflaterPriority[]{r1, r2, r3};
    }

    public static InflaterPriority valueOf(String r1) {
        return (InflaterPriority) r27.a.a(InflaterPriority.class, r1);
    }

    public static InflaterPriority[] values() {
        return (InflaterPriority[]) a.clone();
    }

    public InflaterPriority(String r1, int r2) {
        super(r1, r2);
    }
}
