package com.bytedance.android.window.shop.holder.footer;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/holder/footer/FooterStatus;", "", "LOADING", "NO_MORE", "NOTHING", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FooterStatus extends Enum<FooterStatus> {
    public static final FooterStatus LOADING = null;
    public static final FooterStatus NOTHING = null;
    public static final FooterStatus NO_MORE = null;
    public static final /* synthetic */ FooterStatus[] a = null;

    static {
        FooterStatus r1 = new FooterStatus("LOADING", 0);
        LOADING = r1;
        FooterStatus r2 = new FooterStatus("NO_MORE", 1);
        NO_MORE = r2;
        FooterStatus r3 = new FooterStatus("NOTHING", 2);
        NOTHING = r3;
        a = new FooterStatus[]{r1, r2, r3};
    }

    public static FooterStatus valueOf(String r1) {
        return (FooterStatus) r27.a.a(FooterStatus.class, r1);
    }

    public static FooterStatus[] values() {
        return (FooterStatus[]) a.clone();
    }

    public FooterStatus(String r1, int r2) {
        super(r1, r2);
    }
}
