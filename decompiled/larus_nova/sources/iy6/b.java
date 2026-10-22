package iy6;

import com.amap.api.col.s.ce;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.locallife.poi.media.entity.PoiVideoStyle;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001a\u0010\u001d\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010 ¨\u0006#"}, d2 = {"Liy6/b;", "", "", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "I", "e", "()I", "videoStyle", RXScreenCaptureService.KEY_INDEX, "Lcom/google/gson/JsonObject;", "trackData", "Lcom/google/gson/JsonObject;", "h", "()Lcom/google/gson/JsonObject;", "extraParams", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Liy6/h;", "pageData", "Liy6/h;", "d", "()Liy6/h;", "", "mediaId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "index", "b", "", "shouldShowPageIndicator", "Z", "f", "()Z", "shouldShowScrollGuide", ce.f26391f, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("extra_params")
    private final JsonObject extraParams;

    @SerializedName("index")
    private final int index;

    @SerializedName(AppConstants.BUNDLE_MEDIA_ID)
    private final String mediaId;

    @SerializedName("page_data")
    private final h pageData;

    @SerializedName("scene_type")
    private final int sceneType;

    @SerializedName("should_show_page_indicator")
    private final boolean shouldShowPageIndicator;

    @SerializedName("should_show_scroll_guide")
    private final boolean shouldShowScrollGuide;

    @SerializedName("track_data")
    private final JsonObject trackData;

    @SerializedName(TextureRenderKeys.KEY_IS_VIDEO_STYLE)
    private final int videoStyle;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.sceneType == r101.sceneType) goto L12;
        return false;
    L12:
        if (this.videoStyle == r101.videoStyle) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.trackData, r101.trackData) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extraParams, r101.extraParams) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.pageData, r101.pageData) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.mediaId, r101.mediaId) == true) goto L27;
        return false;
    L27:
        if (this.index == r101.index) goto L30;
        return false;
    L30:
        if (this.shouldShowPageIndicator == r101.shouldShowPageIndicator) goto L33;
        return false;
    L33:
        if (this.shouldShowScrollGuide == r101.shouldShowScrollGuide) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.sceneType * 31) + this.videoStyle) * 31;
        JsonObject r101 = this.trackData;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        JsonObject r105 = this.extraParams;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        h r108 = this.pageData;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.mediaId;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        int r112 = (((r110 + r102) * 31) + this.index) * 31;
        int r113 = 1231;
        if (this.shouldShowPageIndicator == false) goto L21;
        int r114 = 1231;
    L22:
        int r115 = (r112 + r114) * 31;
        if (this.shouldShowScrollGuide == true) goto L27;
        r113 = 1237;
    L27:
        return r115 + r113;
    L21:
        r114 = 1237;
        goto L22
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "OpenMediaData(sceneType=" + this.sceneType + ", videoStyle=" + this.videoStyle + ", trackData=" + this.trackData + ", extraParams=" + this.extraParams + ", pageData=" + this.pageData + ", mediaId=" + this.mediaId + ", index=" + this.index + ", shouldShowPageIndicator=" + this.shouldShowPageIndicator + ", shouldShowScrollGuide=" + this.shouldShowScrollGuide + ')';
    }

    public b() {
        int r100 = PoiVideoStyle.VIDEO_STYLE_LYNX.getStyle();
        this.sceneType = -1;
        this.videoStyle = r100;
        this.trackData = null;
        this.extraParams = null;
        this.pageData = null;
        this.mediaId = null;
        this.index = 0;
        this.shouldShowPageIndicator = true;
        this.shouldShowScrollGuide = true;
    }

    public final JsonObject a() {
        return this.extraParams;
    }

    public final int b() {
        return this.index;
    }

    public final String c() {
        return this.mediaId;
    }

    public final h d() {
        return this.pageData;
    }

    public final int e() {
        return this.sceneType;
    }

    public final boolean f() {
        return this.shouldShowPageIndicator;
    }

    public final boolean g() {
        return this.shouldShowScrollGuide;
    }

    public final JsonObject h() {
        return this.trackData;
    }

    public final int i() {
        return this.videoStyle;
    }
}
