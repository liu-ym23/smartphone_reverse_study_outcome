package com.bytedance.android.shopping.store.home.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/store/home/api/InterceptBackPressKey;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "MALLPOPUPKEY", "MALLKEY", "LEAVE_RED_PACK_KEY", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InterceptBackPressKey extends Enum<InterceptBackPressKey> {
    public static final InterceptBackPressKey LEAVE_RED_PACK_KEY = null;
    public static final InterceptBackPressKey MALLKEY = null;
    public static final InterceptBackPressKey MALLPOPUPKEY = null;
    public static final /* synthetic */ InterceptBackPressKey[] a = null;
    private final String type;

    static {
        InterceptBackPressKey r1 = new InterceptBackPressKey("MALLPOPUPKEY", 0, "brand_ad_popup");
        MALLPOPUPKEY = r1;
        InterceptBackPressKey r2 = new InterceptBackPressKey("MALLKEY", 1, "brand_ad_justjump");
        MALLKEY = r2;
        InterceptBackPressKey r3 = new InterceptBackPressKey("LEAVE_RED_PACK_KEY", 2, "leave_red_pack");
        LEAVE_RED_PACK_KEY = r3;
        a = new InterceptBackPressKey[]{r1, r2, r3};
    }

    public static InterceptBackPressKey valueOf(String r1) {
        return (InterceptBackPressKey) r27.a.a(InterceptBackPressKey.class, r1);
    }

    public static InterceptBackPressKey[] values() {
        return (InterceptBackPressKey[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public InterceptBackPressKey(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
