package com.bytedance.android.shopping.store.tabkit.container;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/container/Type;", "", "ACTIVITY", "FRAGMENT", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Type extends Enum<Type> {
    public static final Type ACTIVITY = null;
    public static final Type FRAGMENT = null;
    public static final /* synthetic */ Type[] a = null;

    static {
        Type r1 = new Type("ACTIVITY", 0);
        ACTIVITY = r1;
        Type r2 = new Type("FRAGMENT", 1);
        FRAGMENT = r2;
        a = new Type[]{r1, r2};
    }

    public static Type valueOf(String r1) {
        return (Type) r27.a.a(Type.class, r1);
    }

    public static Type[] values() {
        return (Type[]) a.clone();
    }

    public Type(String r1, int r2) {
        super(r1, r2);
    }
}
