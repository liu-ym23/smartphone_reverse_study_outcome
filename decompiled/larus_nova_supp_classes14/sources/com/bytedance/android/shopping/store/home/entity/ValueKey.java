package com.bytedance.android.shopping.store.home.entity;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ValueKey;", "", "", "desc", "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "SALES", "FANS", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ValueKey extends Enum<ValueKey> {
    public static final ValueKey FANS = null;
    public static final ValueKey SALES = null;
    public static final /* synthetic */ ValueKey[] a = null;
    private final String desc;

    static {
        ValueKey r1 = new ValueKey("SALES", 0, "sales");
        SALES = r1;
        ValueKey r2 = new ValueKey("FANS", 1, "fans");
        FANS = r2;
        a = new ValueKey[]{r1, r2};
    }

    public static ValueKey valueOf(String r1) {
        return (ValueKey) r27.a.a(ValueKey.class, r1);
    }

    public static ValueKey[] values() {
        return (ValueKey[]) a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public ValueKey(String r1, int r2, String r3) {
        super(r1, r2);
        this.desc = r3;
    }
}
