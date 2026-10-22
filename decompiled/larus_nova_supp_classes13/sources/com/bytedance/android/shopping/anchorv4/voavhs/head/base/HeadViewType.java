package com.bytedance.android.shopping.anchorv4.voavhs.head.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/HeadViewType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "VIDEO", "PICTURE", "SIMPLE_LINK", "COMBINATION", "COMMENT", "SHOW", "GOOD_COMMENT", "FIND_SAME", "SIZE", "SKU", "PIONEER", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum HeadViewType extends Enum<HeadViewType> {
    public static final HeadViewType COMBINATION = null;
    public static final HeadViewType COMMENT = null;
    public static final HeadViewType FIND_SAME = null;
    public static final HeadViewType GOOD_COMMENT = null;
    public static final HeadViewType PICTURE = null;
    public static final HeadViewType PIONEER = null;
    public static final HeadViewType SHOW = null;
    public static final HeadViewType SIMPLE_LINK = null;
    public static final HeadViewType SIZE = null;
    public static final HeadViewType SKU = null;
    public static final HeadViewType VIDEO = null;
    public static final /* synthetic */ HeadViewType[] a = null;
    private final String type;

    public static HeadViewType valueOf(String r1) {
        return (HeadViewType) r27.a.a(HeadViewType.class, r1);
    }

    public static HeadViewType[] values() {
        return (HeadViewType[]) a.clone();
    }

    static {
        HeadViewType r1 = new HeadViewType("VIDEO", 0, "video");
        VIDEO = r1;
        HeadViewType r2 = new HeadViewType("PICTURE", 1, "image");
        PICTURE = r2;
        HeadViewType r3 = new HeadViewType("SIMPLE_LINK", 2, "simple_link");
        SIMPLE_LINK = r3;
        HeadViewType r4 = new HeadViewType("COMBINATION", 3, "combination");
        COMBINATION = r4;
        HeadViewType r5 = new HeadViewType("COMMENT", 4, "comment");
        COMMENT = r5;
        HeadViewType r6 = new HeadViewType("SHOW", 5, "show");
        SHOW = r6;
        HeadViewType r7 = new HeadViewType("GOOD_COMMENT", 6, "good_comment");
        GOOD_COMMENT = r7;
        HeadViewType r8 = new HeadViewType("FIND_SAME", 7, "find_same");
        FIND_SAME = r8;
        HeadViewType r9 = new HeadViewType("SIZE", 8, "size");
        SIZE = r9;
        HeadViewType r10 = new HeadViewType("SKU", 9, "sku");
        SKU = r10;
        HeadViewType r11 = new HeadViewType("PIONEER", 10, "pioneer_test");
        PIONEER = r11;
        a = new HeadViewType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
    }

    public final String getType() {
        return this.type;
    }

    public HeadViewType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
