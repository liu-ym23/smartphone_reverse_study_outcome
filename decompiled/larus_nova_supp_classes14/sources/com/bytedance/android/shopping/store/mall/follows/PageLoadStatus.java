package com.bytedance.android.shopping.store.mall.follows;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/store/mall/follows/PageLoadStatus;", "", "", "value", "I", "getValue", "()I", "SUCCESS", "EMPTY", "ERROR", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PageLoadStatus extends Enum<PageLoadStatus> {
    public static final PageLoadStatus EMPTY = null;
    public static final PageLoadStatus ERROR = null;
    public static final PageLoadStatus SUCCESS = null;
    public static final /* synthetic */ PageLoadStatus[] a = null;
    private final int value;

    static {
        PageLoadStatus r1 = new PageLoadStatus("SUCCESS", 0, 0);
        SUCCESS = r1;
        PageLoadStatus r2 = new PageLoadStatus("EMPTY", 1, 1);
        EMPTY = r2;
        PageLoadStatus r3 = new PageLoadStatus("ERROR", 2, 2);
        ERROR = r3;
        a = new PageLoadStatus[]{r1, r2, r3};
    }

    public static PageLoadStatus valueOf(String r1) {
        return (PageLoadStatus) a.a(PageLoadStatus.class, r1);
    }

    public static PageLoadStatus[] values() {
        return (PageLoadStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public PageLoadStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
