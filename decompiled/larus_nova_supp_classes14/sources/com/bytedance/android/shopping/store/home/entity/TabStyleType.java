package com.bytedance.android.shopping.store.home.entity;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/TabStyleType;", "", "", "type", "I", "getType", "()I", "NORMAL", "IMMERSE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TabStyleType extends Enum<TabStyleType> {
    public static final TabStyleType IMMERSE = null;
    public static final TabStyleType NORMAL = null;
    public static final /* synthetic */ TabStyleType[] a = null;
    private final int type;

    static {
        TabStyleType r1 = new TabStyleType("NORMAL", 0, 0);
        NORMAL = r1;
        TabStyleType r2 = new TabStyleType("IMMERSE", 1, 1);
        IMMERSE = r2;
        a = new TabStyleType[]{r1, r2};
    }

    public static TabStyleType valueOf(String r1) {
        return (TabStyleType) r27.a.a(TabStyleType.class, r1);
    }

    public static TabStyleType[] values() {
        return (TabStyleType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public TabStyleType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
