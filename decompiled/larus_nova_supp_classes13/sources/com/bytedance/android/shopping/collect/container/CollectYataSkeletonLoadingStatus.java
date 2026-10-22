package com.bytedance.android.shopping.collect.container;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/collect/container/CollectYataSkeletonLoadingStatus;", "", "SUCCESS", "ERROR", "LOADING", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CollectYataSkeletonLoadingStatus extends Enum<CollectYataSkeletonLoadingStatus> {
    public static final CollectYataSkeletonLoadingStatus ERROR = null;
    public static final CollectYataSkeletonLoadingStatus LOADING = null;
    public static final CollectYataSkeletonLoadingStatus SUCCESS = null;
    public static final /* synthetic */ CollectYataSkeletonLoadingStatus[] a = null;

    static {
        CollectYataSkeletonLoadingStatus r1 = new CollectYataSkeletonLoadingStatus("SUCCESS", 0);
        SUCCESS = r1;
        CollectYataSkeletonLoadingStatus r2 = new CollectYataSkeletonLoadingStatus("ERROR", 1);
        ERROR = r2;
        CollectYataSkeletonLoadingStatus r3 = new CollectYataSkeletonLoadingStatus("LOADING", 2);
        LOADING = r3;
        a = new CollectYataSkeletonLoadingStatus[]{r1, r2, r3};
    }

    public static CollectYataSkeletonLoadingStatus valueOf(String r1) {
        return (CollectYataSkeletonLoadingStatus) r27.a.a(CollectYataSkeletonLoadingStatus.class, r1);
    }

    public static CollectYataSkeletonLoadingStatus[] values() {
        return (CollectYataSkeletonLoadingStatus[]) a.clone();
    }

    public CollectYataSkeletonLoadingStatus(String r1, int r2) {
        super(r1, r2);
    }
}
