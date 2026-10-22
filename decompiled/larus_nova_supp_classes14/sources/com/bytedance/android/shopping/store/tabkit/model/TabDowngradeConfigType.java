package com.bytedance.android.shopping.store.tabkit.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/model/TabDowngradeConfigType;", "", "", "type", "I", "getType", "()I", "NORMAL", "CLOSE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TabDowngradeConfigType extends Enum<TabDowngradeConfigType> {
    public static final TabDowngradeConfigType CLOSE = null;
    public static final TabDowngradeConfigType NORMAL = null;
    public static final /* synthetic */ TabDowngradeConfigType[] a = null;
    private final int type;

    static {
        TabDowngradeConfigType r1 = new TabDowngradeConfigType("NORMAL", 0, 0);
        NORMAL = r1;
        TabDowngradeConfigType r2 = new TabDowngradeConfigType("CLOSE", 1, 1);
        CLOSE = r2;
        a = new TabDowngradeConfigType[]{r1, r2};
    }

    public static TabDowngradeConfigType valueOf(String r1) {
        return (TabDowngradeConfigType) r27.a.a(TabDowngradeConfigType.class, r1);
    }

    public static TabDowngradeConfigType[] values() {
        return (TabDowngradeConfigType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public TabDowngradeConfigType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
