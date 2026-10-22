package com.bytedance.android.shopping.infeed.data.idl;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/infeed/data/idl/HeaderBannerItemType;", "", "Image", "Comment", "LivePlayback", "CoverVideo", "Skeleton", "VideoAndImage", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum HeaderBannerItemType extends Enum<HeaderBannerItemType> {
    public static final HeaderBannerItemType Comment = null;
    public static final HeaderBannerItemType CoverVideo = null;
    public static final HeaderBannerItemType Image = null;
    public static final HeaderBannerItemType LivePlayback = null;
    public static final HeaderBannerItemType Skeleton = null;
    public static final HeaderBannerItemType VideoAndImage = null;
    public static final /* synthetic */ HeaderBannerItemType[] a = null;

    static {
        HeaderBannerItemType r1 = new HeaderBannerItemType("Image", 0);
        Image = r1;
        HeaderBannerItemType r2 = new HeaderBannerItemType("Comment", 1);
        Comment = r2;
        HeaderBannerItemType r3 = new HeaderBannerItemType("LivePlayback", 2);
        LivePlayback = r3;
        HeaderBannerItemType r4 = new HeaderBannerItemType("CoverVideo", 3);
        CoverVideo = r4;
        HeaderBannerItemType r5 = new HeaderBannerItemType("Skeleton", 4);
        Skeleton = r5;
        HeaderBannerItemType r6 = new HeaderBannerItemType("VideoAndImage", 5);
        VideoAndImage = r6;
        a = new HeaderBannerItemType[]{r1, r2, r3, r4, r5, r6};
    }

    public static HeaderBannerItemType valueOf(String r1) {
        return (HeaderBannerItemType) a.a(HeaderBannerItemType.class, r1);
    }

    public static HeaderBannerItemType[] values() {
        return (HeaderBannerItemType[]) a.clone();
    }

    public HeaderBannerItemType(String r1, int r2) {
        super(r1, r2);
    }
}
