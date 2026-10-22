package com.bytedance.android.shopping.commentv3.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/ItemViewType;", "", "", "type", "I", "getType", "()I", "SLICE", "LYNX", "NATIVE", "SLICE_TAB_FILTER", "SLICE_SORT_HEADER", "SLICE_COMMENT_HEAD", "SLICE_COMMENT_MEDIA", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ItemViewType extends Enum<ItemViewType> {
    public static final ItemViewType LYNX = null;
    public static final ItemViewType NATIVE = null;
    public static final ItemViewType SLICE = null;
    public static final ItemViewType SLICE_COMMENT_HEAD = null;
    public static final ItemViewType SLICE_COMMENT_MEDIA = null;
    public static final ItemViewType SLICE_SORT_HEADER = null;
    public static final ItemViewType SLICE_TAB_FILTER = null;
    public static final /* synthetic */ ItemViewType[] a = null;
    private final int type;

    static {
        ItemViewType r1 = new ItemViewType("SLICE", 0, 1);
        SLICE = r1;
        ItemViewType r2 = new ItemViewType("LYNX", 1, 2);
        LYNX = r2;
        ItemViewType r3 = new ItemViewType("NATIVE", 2, 3);
        NATIVE = r3;
        ItemViewType r4 = new ItemViewType("SLICE_TAB_FILTER", 3, 101);
        SLICE_TAB_FILTER = r4;
        ItemViewType r5 = new ItemViewType("SLICE_SORT_HEADER", 4, 102);
        SLICE_SORT_HEADER = r5;
        ItemViewType r6 = new ItemViewType("SLICE_COMMENT_HEAD", 5, 103);
        SLICE_COMMENT_HEAD = r6;
        ItemViewType r7 = new ItemViewType("SLICE_COMMENT_MEDIA", 6, 104);
        SLICE_COMMENT_MEDIA = r7;
        a = new ItemViewType[]{r1, r2, r3, r4, r5, r6, r7};
    }

    public static ItemViewType valueOf(String r1) {
        return (ItemViewType) r27.a.a(ItemViewType.class, r1);
    }

    public static ItemViewType[] values() {
        return (ItemViewType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ItemViewType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
