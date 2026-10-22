package com.bytedance.android.shopping.store.live;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/store/live/SwitchLiveTabSource;", "", "", "method", "Ljava/lang/String;", "getMethod", "()Ljava/lang/String;", "CLICK_TAB", "CLICK_FLOAT_LIVE", "CLICK_LIVE_PREVIEW", "CLICK_LIVE_CARD", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SwitchLiveTabSource extends Enum<SwitchLiveTabSource> {
    public static final SwitchLiveTabSource CLICK_FLOAT_LIVE = null;
    public static final SwitchLiveTabSource CLICK_LIVE_CARD = null;
    public static final SwitchLiveTabSource CLICK_LIVE_PREVIEW = null;
    public static final SwitchLiveTabSource CLICK_TAB = null;
    public static final /* synthetic */ SwitchLiveTabSource[] a = null;
    private final String method;

    static {
        SwitchLiveTabSource r1 = new SwitchLiveTabSource("CLICK_TAB", 0, "shop_live_tab");
        CLICK_TAB = r1;
        SwitchLiveTabSource r2 = new SwitchLiveTabSource("CLICK_FLOAT_LIVE", 1, "shop_mini_window");
        CLICK_FLOAT_LIVE = r2;
        SwitchLiveTabSource r3 = new SwitchLiveTabSource("CLICK_LIVE_PREVIEW", 2, "shop_live_cell");
        CLICK_LIVE_PREVIEW = r3;
        SwitchLiveTabSource r4 = new SwitchLiveTabSource("CLICK_LIVE_CARD", 3, "shop_live_cell_card");
        CLICK_LIVE_CARD = r4;
        a = new SwitchLiveTabSource[]{r1, r2, r3, r4};
    }

    public static SwitchLiveTabSource valueOf(String r1) {
        return (SwitchLiveTabSource) r27.a.a(SwitchLiveTabSource.class, r1);
    }

    public static SwitchLiveTabSource[] values() {
        return (SwitchLiveTabSource[]) a.clone();
    }

    public final String getMethod() {
        return this.method;
    }

    public SwitchLiveTabSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.method = r3;
    }
}
