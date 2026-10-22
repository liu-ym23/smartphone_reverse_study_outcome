package com.bytedance.android.shopping.anchorv4.voavhs.comment;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/CommentType;", "", "TYPE_SHOP", "TYPE_PRODUCT", "TYPE_BUYERS_SHOW", "TYPE_COMMENT_REGION", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CommentType extends Enum<CommentType> {
    public static final CommentType TYPE_BUYERS_SHOW = null;
    public static final CommentType TYPE_COMMENT_REGION = null;
    public static final CommentType TYPE_PRODUCT = null;
    public static final CommentType TYPE_SHOP = null;
    public static final /* synthetic */ CommentType[] a = null;

    static {
        CommentType r1 = new CommentType("TYPE_SHOP", 0);
        TYPE_SHOP = r1;
        CommentType r2 = new CommentType("TYPE_PRODUCT", 1);
        TYPE_PRODUCT = r2;
        CommentType r3 = new CommentType("TYPE_BUYERS_SHOW", 2);
        TYPE_BUYERS_SHOW = r3;
        CommentType r4 = new CommentType("TYPE_COMMENT_REGION", 3);
        TYPE_COMMENT_REGION = r4;
        a = new CommentType[]{r1, r2, r3, r4};
    }

    public static CommentType valueOf(String r1) {
        return (CommentType) r27.a.a(CommentType.class, r1);
    }

    public static CommentType[] values() {
        return (CommentType[]) a.clone();
    }

    public CommentType(String r1, int r2) {
        super(r1, r2);
    }
}
