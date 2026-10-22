package com.bytedance.android.shopping.commentv3.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/TabTypeEnum;", "", "", "type", "I", "getType", "()I", "TAB", "TAG", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TabTypeEnum extends Enum<TabTypeEnum> {
    public static final TabTypeEnum TAB = null;
    public static final TabTypeEnum TAG = null;
    public static final /* synthetic */ TabTypeEnum[] a = null;
    private final int type;

    static {
        TabTypeEnum r2 = new TabTypeEnum("TAB", 0, 1);
        TAB = r2;
        TabTypeEnum r3 = new TabTypeEnum("TAG", 1, 2);
        TAG = r3;
        a = new TabTypeEnum[]{r2, r3};
    }

    public static TabTypeEnum valueOf(String r1) {
        return (TabTypeEnum) r27.a.a(TabTypeEnum.class, r1);
    }

    public static TabTypeEnum[] values() {
        return (TabTypeEnum[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public TabTypeEnum(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
