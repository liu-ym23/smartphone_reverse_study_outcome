package com.bytedance.android.shopping.store.tabkit.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/model/TabVisibleFrom;", "", "Enter", "Route", "App", "Unknown", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TabVisibleFrom extends Enum<TabVisibleFrom> {
    public static final TabVisibleFrom App = null;
    public static final TabVisibleFrom Enter = null;
    public static final TabVisibleFrom Route = null;
    public static final TabVisibleFrom Unknown = null;
    public static final /* synthetic */ TabVisibleFrom[] a = null;

    static {
        TabVisibleFrom r1 = new TabVisibleFrom("Enter", 0);
        Enter = r1;
        TabVisibleFrom r2 = new TabVisibleFrom("Route", 1);
        Route = r2;
        TabVisibleFrom r3 = new TabVisibleFrom("App", 2);
        App = r3;
        TabVisibleFrom r4 = new TabVisibleFrom("Unknown", 3);
        Unknown = r4;
        a = new TabVisibleFrom[]{r1, r2, r3, r4};
    }

    public static TabVisibleFrom valueOf(String r1) {
        return (TabVisibleFrom) r27.a.a(TabVisibleFrom.class, r1);
    }

    public static TabVisibleFrom[] values() {
        return (TabVisibleFrom[]) a.clone();
    }

    public TabVisibleFrom(String r1, int r2) {
        super(r1, r2);
    }
}
