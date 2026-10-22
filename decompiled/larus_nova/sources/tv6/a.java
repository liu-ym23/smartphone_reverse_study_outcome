package tv6;

import com.amap.api.col.s.ce;
import com.bytedance.locallife.model.album.AlbumPageInfo;
import com.bytedance.locallife.model.album.TabInfo;
import com.bytedance.locallife.model.response.BaseResponse;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u000f\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010 R$\u0010$\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u000f\u001a\u0004\b%\u0010\u0011\"\u0004\b&\u0010 R$\u0010'\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u000f\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010 R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R*\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0005\u001a\u0004\b3\u0010\u0007\"\u0004\b4\u00105R*\u00107\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0005\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u00105¨\u0006:"}, d2 = {"Ltv6/a;", "Lcom/bytedance/locallife/model/response/BaseResponse;", "", "Lcom/bytedance/locallife/model/album/TabInfo;", "tabInfo", "Ljava/util/List;", "h", "()Ljava/util/List;", "Lcom/bytedance/locallife/model/album/AlbumPageInfo;", "albumInfo", "Lcom/bytedance/locallife/model/album/AlbumPageInfo;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/locallife/model/album/AlbumPageInfo;", "", "photosReportSchema", "Ljava/lang/String;", ce.f26391f, "()Ljava/lang/String;", "galleryHeaderLynx", "e", "galleryBottomLynx", "d", "", "maxErrorPhotoNum", "Ljava/lang/Integer;", "f", "()Ljava/lang/Integer;", "setMaxErrorPhotoNum", "(Ljava/lang/Integer;)V", "topLynxUrl", ce.f26395j, "setTopLynxUrl", "(Ljava/lang/String;)V", "topLynxData", RXScreenCaptureService.KEY_INDEX, "setTopLynxData", "bottomLynxUrl", "c", "setBottomLynxUrl", "bottomLynxData", "b", "setBottomLynxData", "", "hideAlbumUploadButton", "Z", "getHideAlbumUploadButton", "()Z", "setHideAlbumUploadButton", "(Z)V", "Ltv6/c;", "pageTypeInfo", "getPageTypeInfo", "setPageTypeInfo", "(Ljava/util/List;)V", "Ltv6/d;", "videoStruct", "getVideoStruct", "setVideoStruct", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class a extends BaseResponse {

    @SerializedName("category_info")
    private final AlbumPageInfo albumInfo;

    @SerializedName("lynx_bottom_bar_data")
    private String bottomLynxData;

    @SerializedName("lynx_bottom_bar_url")
    private String bottomLynxUrl;

    @SerializedName("gallery_bottom_lynx_schema")
    private final String galleryBottomLynx;

    @SerializedName("gallery_header_lynx_schema")
    private final String galleryHeaderLynx;

    @SerializedName("hide_album_upload_button")
    private boolean hideAlbumUploadButton;

    @SerializedName("max_report_number")
    private Integer maxErrorPhotoNum;

    @SerializedName("page_type_info")
    private List<c> pageTypeInfo;

    @SerializedName("photos_report_schema")
    private final String photosReportSchema;

    @SerializedName("tab_info")
    private final List<TabInfo> tabInfo;

    @SerializedName("lynx_top_bar_data")
    private String topLynxData;

    @SerializedName("lynx_top_bar_url")
    private String topLynxUrl;

    @SerializedName("video_struct")
    private List<d> videoStruct;

    public a() {
        this.tabInfo = null;
        this.albumInfo = null;
        this.photosReportSchema = null;
        this.galleryHeaderLynx = null;
        this.galleryBottomLynx = null;
        this.maxErrorPhotoNum = 5;
        this.topLynxUrl = null;
        this.topLynxData = null;
        this.bottomLynxUrl = null;
        this.bottomLynxData = null;
        this.hideAlbumUploadButton = false;
        this.pageTypeInfo = null;
        this.videoStruct = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.tabInfo, r101.tabInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.albumInfo, r101.albumInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.photosReportSchema, r101.photosReportSchema) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.galleryHeaderLynx, r101.galleryHeaderLynx) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.galleryBottomLynx, r101.galleryBottomLynx) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.maxErrorPhotoNum, r101.maxErrorPhotoNum) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.topLynxUrl, r101.topLynxUrl) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.topLynxData, r101.topLynxData) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.bottomLynxUrl, r101.bottomLynxUrl) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.bottomLynxData, r101.bottomLynxData) == true) goto L39;
        return false;
    L39:
        if (this.hideAlbumUploadButton == r101.hideAlbumUploadButton) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.pageTypeInfo, r101.pageTypeInfo) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.videoStruct, r101.videoStruct) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        List<TabInfo> r100 = this.tabInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        AlbumPageInfo r104 = this.albumInfo;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.photosReportSchema;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.galleryHeaderLynx;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.galleryBottomLynx;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.maxErrorPhotoNum;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.topLynxUrl;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.topLynxData;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.bottomLynxUrl;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.bottomLynxData;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        if (this.hideAlbumUploadButton == false) goto L45;
        int r131 = 1231;
    L46:
        int r132 = (r130 + r131) * 31;
        List<c> r133 = this.pageTypeInfo;
        if (r133 != null) goto L49;
        int r134 = 0;
    L50:
        int r135 = (r132 + r134) * 31;
        List<d> r136 = this.videoStruct;
        if (r136 == null) goto L55;
        r101 = r136.hashCode();
    L55:
        return r135 + r101;
    L49:
        r134 = r133.hashCode();
        goto L50
    L45:
        r131 = 1237;
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
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

    @Override // com.bytedance.locallife.model.response.BaseResponse
    public final String toString() {
        return "AlbumStruct(tabInfo=" + this.tabInfo + ", albumInfo=" + this.albumInfo + ", photosReportSchema=" + this.photosReportSchema + ", galleryHeaderLynx=" + this.galleryHeaderLynx + ", galleryBottomLynx=" + this.galleryBottomLynx + ", maxErrorPhotoNum=" + this.maxErrorPhotoNum + ", topLynxUrl=" + this.topLynxUrl + ", topLynxData=" + this.topLynxData + ", bottomLynxUrl=" + this.bottomLynxUrl + ", bottomLynxData=" + this.bottomLynxData + ", hideAlbumUploadButton=" + this.hideAlbumUploadButton + ", pageTypeInfo=" + this.pageTypeInfo + ", videoStruct=" + this.videoStruct + ')';
    }

    public final AlbumPageInfo a() {
        return this.albumInfo;
    }

    public final String b() {
        return this.bottomLynxData;
    }

    public final String c() {
        return this.bottomLynxUrl;
    }

    public final String d() {
        return this.galleryBottomLynx;
    }

    public final String e() {
        return this.galleryHeaderLynx;
    }

    public final Integer f() {
        return this.maxErrorPhotoNum;
    }

    public final String g() {
        return this.photosReportSchema;
    }

    public final List<TabInfo> h() {
        return this.tabInfo;
    }

    public final String i() {
        return this.topLynxData;
    }

    public final String j() {
        return this.topLynxUrl;
    }
}
