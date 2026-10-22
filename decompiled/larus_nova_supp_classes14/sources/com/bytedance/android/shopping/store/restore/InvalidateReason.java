package com.bytedance.android.shopping.store.restore;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/restore/InvalidateReason;", "", "Expired", "Disabled", "TabConfigChanged", "Unknown", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InvalidateReason extends Enum<InvalidateReason> {
    public static final InvalidateReason Disabled = null;
    public static final InvalidateReason Expired = null;
    public static final InvalidateReason TabConfigChanged = null;
    public static final InvalidateReason Unknown = null;
    public static final /* synthetic */ InvalidateReason[] a = null;

    static {
        InvalidateReason r1 = new InvalidateReason("Expired", 0);
        Expired = r1;
        InvalidateReason r2 = new InvalidateReason("Disabled", 1);
        Disabled = r2;
        InvalidateReason r3 = new InvalidateReason("TabConfigChanged", 2);
        TabConfigChanged = r3;
        InvalidateReason r4 = new InvalidateReason("Unknown", 3);
        Unknown = r4;
        a = new InvalidateReason[]{r1, r2, r3, r4};
    }

    public static InvalidateReason valueOf(String r1) {
        return (InvalidateReason) r27.a.a(InvalidateReason.class, r1);
    }

    public static InvalidateReason[] values() {
        return (InvalidateReason[]) a.clone();
    }

    public InvalidateReason(String r1, int r2) {
        super(r1, r2);
    }
}
