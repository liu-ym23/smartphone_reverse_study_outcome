package com.bytedance.android.shopping.store.home.entity;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/StoreUITheme;", "", "DefaultDark", "Light", "OLD", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum StoreUITheme extends Enum<StoreUITheme> {
    public static final StoreUITheme DefaultDark = null;
    public static final StoreUITheme Light = null;
    public static final StoreUITheme OLD = null;
    public static final /* synthetic */ StoreUITheme[] a = null;

    static {
        StoreUITheme r1 = new StoreUITheme("DefaultDark", 0);
        DefaultDark = r1;
        StoreUITheme r2 = new StoreUITheme("Light", 1);
        Light = r2;
        StoreUITheme r3 = new StoreUITheme("OLD", 2);
        OLD = r3;
        a = new StoreUITheme[]{r1, r2, r3};
    }

    public static StoreUITheme valueOf(String r1) {
        return (StoreUITheme) r27.a.a(StoreUITheme.class, r1);
    }

    public static StoreUITheme[] values() {
        return (StoreUITheme[]) a.clone();
    }

    public StoreUITheme(String r1, int r2) {
        super(r1, r2);
    }
}
