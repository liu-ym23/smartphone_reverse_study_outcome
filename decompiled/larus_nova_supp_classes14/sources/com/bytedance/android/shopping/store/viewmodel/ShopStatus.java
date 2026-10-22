package com.bytedance.android.shopping.store.viewmodel;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/store/viewmodel/ShopStatus;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "NORMAL", "IN_PROGRESS", "PREVIEW_COLLAPSE", "PREVIEW_EXPANDED", "HIDE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShopStatus extends Enum<ShopStatus> {
    public static final a Companion = null;
    public static final ShopStatus HIDE = null;
    public static final ShopStatus IN_PROGRESS = null;
    public static final ShopStatus NORMAL = null;
    public static final ShopStatus PREVIEW_COLLAPSE = null;
    public static final ShopStatus PREVIEW_EXPANDED = null;
    public static final /* synthetic */ ShopStatus[] a = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    static {
        ShopStatus r2 = new ShopStatus("NORMAL", 0, 0);
        NORMAL = r2;
        ShopStatus r3 = new ShopStatus("IN_PROGRESS", 1, 2);
        IN_PROGRESS = r3;
        ShopStatus r4 = new ShopStatus("PREVIEW_COLLAPSE", 2, 3);
        PREVIEW_COLLAPSE = r4;
        ShopStatus r5 = new ShopStatus("PREVIEW_EXPANDED", 3, 4);
        PREVIEW_EXPANDED = r5;
        ShopStatus r6 = new ShopStatus("HIDE", 4, 5);
        HIDE = r6;
        a = new ShopStatus[]{r2, r3, r4, r5, r6};
        Companion = new a();
    }

    public static ShopStatus valueOf(String r1) {
        return (ShopStatus) r27.a.a(ShopStatus.class, r1);
    }

    public static ShopStatus[] values() {
        return (ShopStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ShopStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
