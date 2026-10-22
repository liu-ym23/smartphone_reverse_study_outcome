package com.bytedance.android.shopping.store.mall.follows;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/store/mall/follows/ThemeStatus;", "", "", "value", "I", "getValue", "()I", "COMMON_LIGHT", "BIG_SALE_LIGHT", "BIG_SALE_DARK", "COMMON_DARK", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ThemeStatus extends Enum<ThemeStatus> {
    public static final ThemeStatus BIG_SALE_DARK = null;
    public static final ThemeStatus BIG_SALE_LIGHT = null;
    public static final ThemeStatus COMMON_DARK = null;
    public static final ThemeStatus COMMON_LIGHT = null;
    public static final /* synthetic */ ThemeStatus[] a = null;
    private final int value;

    static {
        ThemeStatus r1 = new ThemeStatus("COMMON_LIGHT", 0, 0);
        COMMON_LIGHT = r1;
        ThemeStatus r2 = new ThemeStatus("BIG_SALE_LIGHT", 1, 1);
        BIG_SALE_LIGHT = r2;
        ThemeStatus r3 = new ThemeStatus("BIG_SALE_DARK", 2, 2);
        BIG_SALE_DARK = r3;
        ThemeStatus r4 = new ThemeStatus("COMMON_DARK", 3, 3);
        COMMON_DARK = r4;
        a = new ThemeStatus[]{r1, r2, r3, r4};
    }

    public static ThemeStatus valueOf(String r1) {
        return (ThemeStatus) a.a(ThemeStatus.class, r1);
    }

    public static ThemeStatus[] values() {
        return (ThemeStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ThemeStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
