package com.ss.android.ugc.aweme.discover.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b(\u0010)J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003JL\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/FeedBoxBanner;", "Ljava/io/Serializable;", "", "component1", "", "component2", "()Ljava/lang/Integer;", "Lcom/ss/android/ugc/aweme/discover/model/ImgContent;", "component3", "Lcom/ss/android/ugc/aweme/discover/model/ImgTextContent;", "component4", "Lcom/ss/android/ugc/aweme/discover/model/FeedBoxBannerSceneInfo;", "component5", "insertType", "bannerContentType", "imgContent", "imgTextContent", "sceneInfo", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/ss/android/ugc/aweme/discover/model/ImgContent;Lcom/ss/android/ugc/aweme/discover/model/ImgTextContent;Lcom/ss/android/ugc/aweme/discover/model/FeedBoxBannerSceneInfo;)Lcom/ss/android/ugc/aweme/discover/model/FeedBoxBanner;", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getInsertType", "()Ljava/lang/String;", "Ljava/lang/Integer;", "getBannerContentType", "Lcom/ss/android/ugc/aweme/discover/model/ImgContent;", "getImgContent", "()Lcom/ss/android/ugc/aweme/discover/model/ImgContent;", "Lcom/ss/android/ugc/aweme/discover/model/ImgTextContent;", "getImgTextContent", "()Lcom/ss/android/ugc/aweme/discover/model/ImgTextContent;", "Lcom/ss/android/ugc/aweme/discover/model/FeedBoxBannerSceneInfo;", "getSceneInfo", "()Lcom/ss/android/ugc/aweme/discover/model/FeedBoxBannerSceneInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/ss/android/ugc/aweme/discover/model/ImgContent;Lcom/ss/android/ugc/aweme/discover/model/ImgTextContent;Lcom/ss/android/ugc/aweme/discover/model/FeedBoxBannerSceneInfo;)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedBoxBanner implements Serializable {

    @SerializedName("banner_content_type")
    private final Integer bannerContentType;

    @SerializedName("img_content")
    private final ImgContent imgContent;

    @SerializedName("img_text_content")
    private final ImgTextContent imgTextContent;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_INSERT_TYPE)
    private final String insertType;

    @SerializedName("scene_info")
    private final FeedBoxBannerSceneInfo sceneInfo;

    public FeedBoxBanner() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ FeedBoxBanner copy$default(FeedBoxBanner r100, String r101, Integer r102, ImgContent r103, ImgTextContent r104, FeedBoxBannerSceneInfo r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.insertType;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.bannerContentType;
    L8:
        Integer r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.imgContent;
    L11:
        ImgContent r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.imgTextContent;
    L14:
        ImgTextContent r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.sceneInfo;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.insertType;
    }

    public final Integer component2() {
        return this.bannerContentType;
    }

    public final ImgContent component3() {
        return this.imgContent;
    }

    public final ImgTextContent component4() {
        return this.imgTextContent;
    }

    public final FeedBoxBannerSceneInfo component5() {
        return this.sceneInfo;
    }

    public final FeedBoxBanner copy(String r100, Integer r101, ImgContent r110, ImgTextContent r111, FeedBoxBannerSceneInfo r112) {
        return new FeedBoxBanner(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FeedBoxBanner) == false) goto L16;
        FeedBoxBanner r101 = (FeedBoxBanner) r100;
        if (Intrinsics.areEqual(this.insertType, r101.insertType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bannerContentType, r101.bannerContentType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.imgContent, r101.imgContent) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imgTextContent, r101.imgTextContent) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.sceneInfo, r101.sceneInfo) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r100 = this.insertType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.bannerContentType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ImgContent r107 = this.imgContent;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ImgTextContent r110 = this.imgTextContent;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        FeedBoxBannerSceneInfo r113 = this.sceneInfo;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "FeedBoxBanner(insertType=" + this.insertType + ", bannerContentType=" + this.bannerContentType + ", imgContent=" + this.imgContent + ", imgTextContent=" + this.imgTextContent + ", sceneInfo=" + this.sceneInfo + ")";
    }

    public final Integer getBannerContentType() {
        return this.bannerContentType;
    }

    public final ImgContent getImgContent() {
        return this.imgContent;
    }

    public final ImgTextContent getImgTextContent() {
        return this.imgTextContent;
    }

    public final String getInsertType() {
        return this.insertType;
    }

    public final FeedBoxBannerSceneInfo getSceneInfo() {
        return this.sceneInfo;
    }

    public FeedBoxBanner(String r100, Integer r101, ImgContent r102, ImgTextContent r103, FeedBoxBannerSceneInfo r104) {
        this.insertType = r100;
        this.bannerContentType = r101;
        this.imgContent = r102;
        this.imgTextContent = r103;
        this.sceneInfo = r104;
    }

    public /* synthetic */ FeedBoxBanner(String r100, Integer r101, ImgContent r102, ImgTextContent r103, FeedBoxBannerSceneInfo r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        Integer r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        ImgContent r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        ImgTextContent r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        FeedBoxBannerSceneInfo r113 = null;
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
