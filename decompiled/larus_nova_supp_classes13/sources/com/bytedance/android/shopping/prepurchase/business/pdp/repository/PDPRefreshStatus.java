package com.bytedance.android.shopping.prepurchase.business.pdp.repository;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/business/pdp/repository/PDPRefreshStatus;", "", "SUCCESS", "FAILED", "CANCELED", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PDPRefreshStatus extends Enum<PDPRefreshStatus> {
    public static final PDPRefreshStatus CANCELED = null;
    public static final PDPRefreshStatus FAILED = null;
    public static final PDPRefreshStatus SUCCESS = null;
    public static final /* synthetic */ PDPRefreshStatus[] a = null;

    static {
        PDPRefreshStatus r1 = new PDPRefreshStatus("SUCCESS", 0);
        SUCCESS = r1;
        PDPRefreshStatus r2 = new PDPRefreshStatus("FAILED", 1);
        FAILED = r2;
        PDPRefreshStatus r3 = new PDPRefreshStatus("CANCELED", 2);
        CANCELED = r3;
        a = new PDPRefreshStatus[]{r1, r2, r3};
    }

    public static PDPRefreshStatus valueOf(String r1) {
        return (PDPRefreshStatus) r27.a.a(PDPRefreshStatus.class, r1);
    }

    public static PDPRefreshStatus[] values() {
        return (PDPRefreshStatus[]) a.clone();
    }

    public PDPRefreshStatus(String r1, int r2) {
        super(r1, r2);
    }
}
