package com.bytedance.android.shopping.card_list.container.init;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/card_list/container/init/LauncherBizType;", "", "NONE", "CART", "COLLECT", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LauncherBizType extends Enum<LauncherBizType> {
    public static final LauncherBizType CART = null;
    public static final LauncherBizType COLLECT = null;
    public static final LauncherBizType NONE = null;
    public static final /* synthetic */ LauncherBizType[] a = null;

    static {
        LauncherBizType r1 = new LauncherBizType("NONE", 0);
        NONE = r1;
        LauncherBizType r2 = new LauncherBizType("CART", 1);
        CART = r2;
        LauncherBizType r3 = new LauncherBizType("COLLECT", 2);
        COLLECT = r3;
        a = new LauncherBizType[]{r1, r2, r3};
    }

    public static LauncherBizType valueOf(String r1) {
        return (LauncherBizType) r27.a.a(LauncherBizType.class, r1);
    }

    public static LauncherBizType[] values() {
        return (LauncherBizType[]) a.clone();
    }

    public LauncherBizType(String r1, int r2) {
        super(r1, r2);
    }
}
