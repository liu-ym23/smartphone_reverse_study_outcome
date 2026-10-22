package com.bytedance.android.shopping.sku.inner.container;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/sku/inner/container/SkuYataSkeletonLoadingStatus;", "", "SUCCESS", "ERROR", "LOADING", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SkuYataSkeletonLoadingStatus extends Enum<SkuYataSkeletonLoadingStatus> {
    public static final SkuYataSkeletonLoadingStatus ERROR = null;
    public static final SkuYataSkeletonLoadingStatus LOADING = null;
    public static final SkuYataSkeletonLoadingStatus SUCCESS = null;
    public static final /* synthetic */ SkuYataSkeletonLoadingStatus[] a = null;

    static {
        SkuYataSkeletonLoadingStatus r1 = new SkuYataSkeletonLoadingStatus("SUCCESS", 0);
        SUCCESS = r1;
        SkuYataSkeletonLoadingStatus r2 = new SkuYataSkeletonLoadingStatus("ERROR", 1);
        ERROR = r2;
        SkuYataSkeletonLoadingStatus r3 = new SkuYataSkeletonLoadingStatus("LOADING", 2);
        LOADING = r3;
        a = new SkuYataSkeletonLoadingStatus[]{r1, r2, r3};
    }

    public static SkuYataSkeletonLoadingStatus valueOf(String r1) {
        return (SkuYataSkeletonLoadingStatus) r27.a.a(SkuYataSkeletonLoadingStatus.class, r1);
    }

    public static SkuYataSkeletonLoadingStatus[] values() {
        return (SkuYataSkeletonLoadingStatus[]) a.clone();
    }

    public SkuYataSkeletonLoadingStatus(String r1, int r2) {
        super(r1, r2);
    }
}
