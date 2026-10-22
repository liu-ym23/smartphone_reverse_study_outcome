package com.bytedance.android.shopping.api.video;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b!\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, d2 = {"Lcom/bytedance/android/shopping/api/video/AVScene;", "", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "subTag", "getSubTag", "setSubTag", "Companion", "a", "CONTENT_DEFAULT", "CONTENT_COMMENT_ITEM", "CONTENT_COMMENT_GALLERY", "CONTENT_PRODUCT_DETAIL_HEADER", "CONTENT_PRODUCT_DETAIL_FLOAT_WINDOW", "CONTENT_PRODUCT_DETAIL_FLOAT_WINDOW_OPT", "CONTENT_PD_LIVE_REPLAY_WINDOW", "CONTENT_PD_MORE_VIDEO_WINDOW", "CONTENT_PRODUCT_DETAIL_GALLERY", "CONTENT_PRODUCT_DETAIL_MEDIA_BOX", "CONTENT_BUYER_SHOW", "CONTENT_LIVE_REPLAY", "SHOP_DEFAULT", "WINDOW_RESERVED", "WINDOW_INNER_FLOW", "SHOP_HEADER", "MALL_PRODUCT_INFLOW_LIVE_REPLAY", "PDP_HEADER_KOL", "PDP_HEADER_KOL_OPT", "MALL", "MALL_HEVC", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AVScene extends Enum<AVScene> {
    public static final AVScene CONTENT_BUYER_SHOW = null;
    public static final AVScene CONTENT_COMMENT_GALLERY = null;
    public static final AVScene CONTENT_COMMENT_ITEM = null;
    public static final AVScene CONTENT_DEFAULT = null;
    public static final AVScene CONTENT_LIVE_REPLAY = null;
    public static final AVScene CONTENT_PD_LIVE_REPLAY_WINDOW = null;
    public static final AVScene CONTENT_PD_MORE_VIDEO_WINDOW = null;
    public static final AVScene CONTENT_PRODUCT_DETAIL_FLOAT_WINDOW = null;
    public static final AVScene CONTENT_PRODUCT_DETAIL_FLOAT_WINDOW_OPT = null;
    public static final AVScene CONTENT_PRODUCT_DETAIL_GALLERY = null;
    public static final AVScene CONTENT_PRODUCT_DETAIL_HEADER = null;
    public static final AVScene CONTENT_PRODUCT_DETAIL_MEDIA_BOX = null;
    public static final a Companion = null;
    public static final AVScene MALL = null;
    public static final AVScene MALL_HEVC = null;
    public static final AVScene MALL_PRODUCT_INFLOW_LIVE_REPLAY = null;
    public static final AVScene PDP_HEADER_KOL = null;
    public static final AVScene PDP_HEADER_KOL_OPT = null;
    public static final AVScene SHOP_DEFAULT = null;
    public static final AVScene SHOP_HEADER = null;
    public static final AVScene WINDOW_INNER_FLOW = null;
    public static final AVScene WINDOW_RESERVED = null;
    public static final /* synthetic */ AVScene[] a = null;
    private String subTag;
    private String tag;

    public static final class a {
        public a() {
        }
    }

    public static AVScene valueOf(String r1) {
        return (AVScene) r27.a.a(AVScene.class, r1);
    }

    public static AVScene[] values() {
        return (AVScene[]) a.clone();
    }

    static {
        AVScene r1 = new AVScene("CONTENT_DEFAULT", 0, "ecom_content", "default");
        CONTENT_DEFAULT = r1;
        AVScene r2 = new AVScene("CONTENT_COMMENT_ITEM", 1, "ecom_content", "comment_item");
        CONTENT_COMMENT_ITEM = r2;
        AVScene r3 = new AVScene("CONTENT_COMMENT_GALLERY", 2, "ecom_content", "comment_gallery");
        CONTENT_COMMENT_GALLERY = r3;
        AVScene r4 = new AVScene("CONTENT_PRODUCT_DETAIL_HEADER", 3, "ecom_content", "product_detail_header");
        CONTENT_PRODUCT_DETAIL_HEADER = r4;
        AVScene r5 = new AVScene("CONTENT_PRODUCT_DETAIL_FLOAT_WINDOW", 4, "ecom_content", "product_detail_float_window");
        CONTENT_PRODUCT_DETAIL_FLOAT_WINDOW = r5;
        AVScene r6 = new AVScene("CONTENT_PRODUCT_DETAIL_FLOAT_WINDOW_OPT", 5, "ecom_content", "product_detail_float_window_opt");
        CONTENT_PRODUCT_DETAIL_FLOAT_WINDOW_OPT = r6;
        AVScene r7 = new AVScene("CONTENT_PD_LIVE_REPLAY_WINDOW", 6, "ecom_content", "product_detail_replay_float");
        CONTENT_PD_LIVE_REPLAY_WINDOW = r7;
        AVScene r8 = new AVScene("CONTENT_PD_MORE_VIDEO_WINDOW", 7, "ecom_content", "product_detail_more_video");
        CONTENT_PD_MORE_VIDEO_WINDOW = r8;
        AVScene r9 = new AVScene("CONTENT_PRODUCT_DETAIL_GALLERY", 8, "ecom_content", "product_detail_gallery");
        CONTENT_PRODUCT_DETAIL_GALLERY = r9;
        AVScene r10 = new AVScene("CONTENT_PRODUCT_DETAIL_MEDIA_BOX", 9, "ecom_content", "product_detail_media_box");
        CONTENT_PRODUCT_DETAIL_MEDIA_BOX = r10;
        AVScene r11 = new AVScene("CONTENT_BUYER_SHOW", 10, "ecom_content", "buyer_show");
        CONTENT_BUYER_SHOW = r11;
        AVScene r12 = new AVScene("CONTENT_LIVE_REPLAY", 11, "ecom_content", "live_replay");
        CONTENT_LIVE_REPLAY = r12;
        AVScene r13 = new AVScene("SHOP_DEFAULT", 12, "shop", "default");
        SHOP_DEFAULT = r13;
        AVScene r14 = new AVScene("WINDOW_RESERVED", 13, "window", "reserved");
        WINDOW_RESERVED = r14;
        AVScene r15 = new AVScene("WINDOW_INNER_FLOW", 14, "window", "inner_flow");
        WINDOW_INNER_FLOW = r15;
        AVScene r16 = new AVScene("SHOP_HEADER", 15, "shop", "header");
        SHOP_HEADER = r16;
        AVScene r17 = new AVScene("MALL_PRODUCT_INFLOW_LIVE_REPLAY", 16, "mall", "mall_product_inflow_live_replay");
        MALL_PRODUCT_INFLOW_LIVE_REPLAY = r17;
        AVScene r18 = new AVScene("PDP_HEADER_KOL", 17, "ecom_content", "product_detail_header_kol");
        PDP_HEADER_KOL = r18;
        AVScene r19 = new AVScene("PDP_HEADER_KOL_OPT", 18, "ecom_content", "product_detail_header_kol_opt");
        PDP_HEADER_KOL_OPT = r19;
        AVScene r20 = new AVScene("MALL", 19, "mall", "mall_native");
        MALL = r20;
        AVScene r21 = new AVScene("MALL_HEVC", 20, "mall", "mall_native_hevc");
        MALL_HEVC = r21;
        a = new AVScene[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21};
        Companion = new a();
    }

    public final String getSubTag() {
        return this.subTag;
    }

    public final String getTag() {
        return this.tag;
    }

    public final void setSubTag(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.subTag = r2;
    }

    public final void setTag(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.tag = r2;
    }

    public AVScene(String r1, int r2, String r3, String r4) {
        super(r1, r2);
        this.tag = r3;
        this.subTag = r4;
    }
}
