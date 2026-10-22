package com.bytedance.android.shopping.commentv3.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/PreviousPageEnum;", "", "", "page", "Ljava/lang/String;", "getPage", "()Ljava/lang/String;", "PRODUCT_DETAIL", "COMMENT_PAGE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PreviousPageEnum extends Enum<PreviousPageEnum> {
    public static final PreviousPageEnum COMMENT_PAGE = null;
    public static final PreviousPageEnum PRODUCT_DETAIL = null;
    public static final /* synthetic */ PreviousPageEnum[] a = null;
    private final String page;

    static {
        PreviousPageEnum r1 = new PreviousPageEnum("PRODUCT_DETAIL", 0, "product_detail");
        PRODUCT_DETAIL = r1;
        PreviousPageEnum r2 = new PreviousPageEnum("COMMENT_PAGE", 1, "comment_page");
        COMMENT_PAGE = r2;
        a = new PreviousPageEnum[]{r1, r2};
    }

    public static PreviousPageEnum valueOf(String r1) {
        return (PreviousPageEnum) r27.a.a(PreviousPageEnum.class, r1);
    }

    public static PreviousPageEnum[] values() {
        return (PreviousPageEnum[]) a.clone();
    }

    public final String getPage() {
        return this.page;
    }

    public PreviousPageEnum(String r1, int r2, String r3) {
        super(r1, r2);
        this.page = r3;
    }
}
