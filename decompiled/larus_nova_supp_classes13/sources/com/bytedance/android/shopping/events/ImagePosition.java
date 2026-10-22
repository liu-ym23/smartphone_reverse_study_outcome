package com.bytedance.android.shopping.events;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/events/ImagePosition;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "GOODS_HEADER", "SHOP_AVATAR", "GOODS_COMMENT", "BUYERS_SHOW", "GOODS_LARGE_COMMENT", "GOODS_CONTENT", "STORE_RECOMMEND_GOODS", "GOODS_RECOMMEND", "COMMENT_PAGE", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ImagePosition extends Enum<ImagePosition> {
    public static final ImagePosition BUYERS_SHOW = null;
    public static final ImagePosition COMMENT_PAGE = null;
    public static final ImagePosition GOODS_COMMENT = null;
    public static final ImagePosition GOODS_CONTENT = null;
    public static final ImagePosition GOODS_HEADER = null;
    public static final ImagePosition GOODS_LARGE_COMMENT = null;
    public static final ImagePosition GOODS_RECOMMEND = null;
    public static final ImagePosition SHOP_AVATAR = null;
    public static final ImagePosition STORE_RECOMMEND_GOODS = null;
    public static final /* synthetic */ ImagePosition[] a = null;
    private final String value;

    public static ImagePosition valueOf(String r1) {
        return (ImagePosition) a.a(ImagePosition.class, r1);
    }

    public static ImagePosition[] values() {
        return (ImagePosition[]) a.clone();
    }

    static {
        ImagePosition r1 = new ImagePosition("GOODS_HEADER", 0, "goods_header");
        GOODS_HEADER = r1;
        ImagePosition r2 = new ImagePosition("SHOP_AVATAR", 1, "shop_avatar");
        SHOP_AVATAR = r2;
        ImagePosition r3 = new ImagePosition("GOODS_COMMENT", 2, "goods_comment");
        GOODS_COMMENT = r3;
        ImagePosition r4 = new ImagePosition("BUYERS_SHOW", 3, "buyers_show");
        BUYERS_SHOW = r4;
        ImagePosition r5 = new ImagePosition("GOODS_LARGE_COMMENT", 4, "goods_large_comment");
        GOODS_LARGE_COMMENT = r5;
        ImagePosition r6 = new ImagePosition("GOODS_CONTENT", 5, "goods_content");
        GOODS_CONTENT = r6;
        ImagePosition r7 = new ImagePosition("STORE_RECOMMEND_GOODS", 6, "store_recommend_goods");
        STORE_RECOMMEND_GOODS = r7;
        ImagePosition r8 = new ImagePosition("GOODS_RECOMMEND", 7, "goods_recommend");
        GOODS_RECOMMEND = r8;
        ImagePosition r9 = new ImagePosition("COMMENT_PAGE", 8, "comment_page");
        COMMENT_PAGE = r9;
        a = new ImagePosition[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
    }

    public final String getValue() {
        return this.value;
    }

    public ImagePosition(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
