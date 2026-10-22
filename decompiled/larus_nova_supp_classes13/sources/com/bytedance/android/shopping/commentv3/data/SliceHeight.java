package com.bytedance.android.shopping.commentv3.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/SliceHeight;", "", "", "height", "I", "getHeight", "()I", "NA_CUSTOM", "MATCH_PARENT", "WRAP_CONTENT", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SliceHeight extends Enum<SliceHeight> {
    public static final SliceHeight MATCH_PARENT = null;
    public static final SliceHeight NA_CUSTOM = null;
    public static final SliceHeight WRAP_CONTENT = null;
    public static final /* synthetic */ SliceHeight[] a = null;
    private final int height;

    static {
        SliceHeight r1 = new SliceHeight("NA_CUSTOM", 0, -2);
        NA_CUSTOM = r1;
        SliceHeight r2 = new SliceHeight("MATCH_PARENT", 1, -1);
        MATCH_PARENT = r2;
        SliceHeight r3 = new SliceHeight("WRAP_CONTENT", 2, 0);
        WRAP_CONTENT = r3;
        a = new SliceHeight[]{r1, r2, r3};
    }

    public static SliceHeight valueOf(String r1) {
        return (SliceHeight) r27.a.a(SliceHeight.class, r1);
    }

    public static SliceHeight[] values() {
        return (SliceHeight[]) a.clone();
    }

    public final int getHeight() {
        return this.height;
    }

    public SliceHeight(String r1, int r2, int r3) {
        super(r1, r2);
        this.height = r3;
    }
}
