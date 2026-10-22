package com.bytedance.android.shopping.orderlist.common.widgets.state;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/state/ShowBarType;", "", "ALL", "ONLY_BACK", "ONLY_SEARCH_BAR", "NONE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShowBarType extends Enum<ShowBarType> {
    public static final ShowBarType ALL = null;
    public static final ShowBarType NONE = null;
    public static final ShowBarType ONLY_BACK = null;
    public static final ShowBarType ONLY_SEARCH_BAR = null;
    public static final /* synthetic */ ShowBarType[] a = null;

    static {
        ShowBarType r1 = new ShowBarType("ALL", 0);
        ALL = r1;
        ShowBarType r2 = new ShowBarType("ONLY_BACK", 1);
        ONLY_BACK = r2;
        ShowBarType r3 = new ShowBarType("ONLY_SEARCH_BAR", 2);
        ONLY_SEARCH_BAR = r3;
        ShowBarType r4 = new ShowBarType("NONE", 3);
        NONE = r4;
        a = new ShowBarType[]{r1, r2, r3, r4};
    }

    public static ShowBarType valueOf(String r1) {
        return (ShowBarType) r27.a.a(ShowBarType.class, r1);
    }

    public static ShowBarType[] values() {
        return (ShowBarType[]) a.clone();
    }

    public ShowBarType(String r1, int r2) {
        super(r1, r2);
    }
}
