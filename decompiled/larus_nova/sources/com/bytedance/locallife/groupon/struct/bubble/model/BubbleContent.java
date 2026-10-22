package com.bytedance.locallife.groupon.struct.bubble.model;

import com.bytedance.locallife.dito.common.data.UrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import com.tencent.open.SocialConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0001*BO\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006¢\u0006\u0004\b'\u0010(J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006HÆ\u0003JQ\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b \u0010\u001cR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b!\u0010\u001fR\"\u0010\"\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010$\"\u0004\b%\u0010&¨\u0006+"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/bubble/model/BubbleContent;", "", "Lcom/bytedance/locallife/dito/common/data/UrlModel;", "component1", "", "component2", "", "component3", "component4", "Lcom/bytedance/locallife/groupon/struct/bubble/model/TagDesc;", "component5", "imageUrl", "imageStyle", "imageUrlList", "title", SocialConstants.PARAM_APP_DESC, "copy", "toString", "", "hashCode", "other", "", "equals", "Lcom/bytedance/locallife/dito/common/data/UrlModel;", "getImageUrl", "()Lcom/bytedance/locallife/dito/common/data/UrlModel;", "Ljava/lang/String;", "getImageStyle", "()Ljava/lang/String;", "Ljava/util/List;", "getImageUrlList", "()Ljava/util/List;", "getTitle", "getDesc", "isTitleWrapContent", "Z", "()Z", "setTitleWrapContent", "(Z)V", "<init>", "(Lcom/bytedance/locallife/dito/common/data/UrlModel;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class BubbleContent {
    public static final a Companion = null;
    public static final String IMAGE_STYLE_ICON = "icon";
    public static final String IMAGE_STYLE_IMAGE = "image";
    public static final String IMAGE_STYLE_IMG = "img";

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private final List<TagDesc> desc;

    @SerializedName("img_style")
    private final String imageStyle;

    @SerializedName(VideoThumbInfo.KEY_IMG_URL)
    private final UrlModel imageUrl;

    @SerializedName("img_url_list")
    private final List<UrlModel> imageUrlList;
    private boolean isTitleWrapContent;

    @SerializedName("title")
    private final String title;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public BubbleContent() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BubbleContent copy$default(BubbleContent r100, UrlModel r101, String r102, List r103, String r104, List r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.imageUrl;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.imageStyle;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.imageUrlList;
    L11:
        List r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.title;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.desc;
    L17:
        UrlModel r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final UrlModel component1() {
        return this.imageUrl;
    }

    public final String component2() {
        return this.imageStyle;
    }

    public final List<UrlModel> component3() {
        return this.imageUrlList;
    }

    public final String component4() {
        return this.title;
    }

    public final List<TagDesc> component5() {
        return this.desc;
    }

    public final BubbleContent copy(UrlModel r100, String r101, List<? extends UrlModel> r110, String r111, List<TagDesc> r112) {
        return new BubbleContent(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BubbleContent) == true) goto L8;
        return false;
    L8:
        BubbleContent r101 = (BubbleContent) r100;
        if (Intrinsics.areEqual(this.imageUrl, r101.imageUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imageStyle, r101.imageStyle) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageUrlList, r101.imageUrlList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        UrlModel r100 = this.imageUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.imageStyle;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<UrlModel> r107 = this.imageUrlList;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.title;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<TagDesc> r113 = this.desc;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "BubbleContent(imageUrl=" + this.imageUrl + ", imageStyle=" + this.imageStyle + ", imageUrlList=" + this.imageUrlList + ", title=" + this.title + ", desc=" + this.desc + ')';
    }

    public final List<TagDesc> getDesc() {
        return this.desc;
    }

    public final String getImageStyle() {
        return this.imageStyle;
    }

    public final UrlModel getImageUrl() {
        return this.imageUrl;
    }

    public final List<UrlModel> getImageUrlList() {
        return this.imageUrlList;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isTitleWrapContent() {
        return this.isTitleWrapContent;
    }

    public final void setTitleWrapContent(boolean r100) {
        this.isTitleWrapContent = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BubbleContent(UrlModel r100, String r101, List<? extends UrlModel> r102, String r103, List<TagDesc> r104) {
        this.imageUrl = r100;
        this.imageStyle = r101;
        this.imageUrlList = r102;
        this.title = r103;
        this.desc = r104;
    }

    public /* synthetic */ BubbleContent(UrlModel r100, String r101, List r102, String r103, List r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        UrlModel r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        List r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        List r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
