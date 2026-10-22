package com.bytedance.android.shopping.pre_purchase.arch.launch;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/pre_purchase/arch/launch/ChainName;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "PDP_STD_CHAIN", "PDP_PRELOAD", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ChainName extends Enum<ChainName> {
    public static final ChainName PDP_PRELOAD = null;
    public static final ChainName PDP_STD_CHAIN = null;
    public static final /* synthetic */ ChainName[] a = null;
    private final String value;

    static {
        ChainName r1 = new ChainName("PDP_STD_CHAIN", 0, "pdp_std_launcher");
        PDP_STD_CHAIN = r1;
        ChainName r2 = new ChainName("PDP_PRELOAD", 1, "pdp_preload_launcher");
        PDP_PRELOAD = r2;
        a = new ChainName[]{r1, r2};
    }

    public static ChainName valueOf(String r1) {
        return (ChainName) r27.a.a(ChainName.class, r1);
    }

    public static ChainName[] values() {
        return (ChainName[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public ChainName(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
