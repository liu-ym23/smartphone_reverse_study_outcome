package com.bytedance.android.shopping.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/api/PageDestroyTypeEvent;", "", "PRODUCT_INNER", "PRODUCT_DETAIL_FULL", "PRODUCT_DETAIL_HALF", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final enum PageDestroyTypeEvent extends Enum<PageDestroyTypeEvent> {
    public static final PageDestroyTypeEvent PRODUCT_DETAIL_FULL = null;
    public static final PageDestroyTypeEvent PRODUCT_DETAIL_HALF = null;
    public static final PageDestroyTypeEvent PRODUCT_INNER = null;
    public static final /* synthetic */ PageDestroyTypeEvent[] a = null;

    static {
        PageDestroyTypeEvent r1 = new PageDestroyTypeEvent("PRODUCT_INNER", 0);
        PRODUCT_INNER = r1;
        PageDestroyTypeEvent r2 = new PageDestroyTypeEvent("PRODUCT_DETAIL_FULL", 1);
        PRODUCT_DETAIL_FULL = r2;
        PageDestroyTypeEvent r3 = new PageDestroyTypeEvent("PRODUCT_DETAIL_HALF", 2);
        PRODUCT_DETAIL_HALF = r3;
        a = new PageDestroyTypeEvent[]{r1, r2, r3};
    }

    public static PageDestroyTypeEvent valueOf(String r1) {
        return (PageDestroyTypeEvent) a.a(PageDestroyTypeEvent.class, r1);
    }

    public static PageDestroyTypeEvent[] values() {
        return (PageDestroyTypeEvent[]) a.clone();
    }

    public PageDestroyTypeEvent(String r1, int r2) {
        super(r1, r2);
    }
}
