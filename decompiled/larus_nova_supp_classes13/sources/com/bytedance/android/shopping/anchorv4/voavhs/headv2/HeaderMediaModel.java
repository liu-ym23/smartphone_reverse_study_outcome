package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b$\b\u0086\b\u0018\u00002\u00020\u0001BÉ\u0001\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0012\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010(\u001a\u00020\u0002\u0012\b\b\u0002\u0010)\u001a\u00020\u0012\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010-\u001a\u00020\u0012\u0012\b\b\u0002\u0010.\u001a\u00020\u0002¢\u0006\u0004\bT\u0010UJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010\u0010\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0012HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010\u0016\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0012HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0002HÆ\u0003JË\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010#\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00122\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010(\u001a\u00020\u00022\b\b\u0002\u0010)\u001a\u00020\u00122\b\b\u0002\u0010*\u001a\u00020\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010-\u001a\u00020\u00122\b\b\u0002\u0010.\u001a\u00020\u0002HÆ\u0001J\t\u00100\u001a\u00020\u000eHÖ\u0001J\t\u00101\u001a\u00020\u0012HÖ\u0001J\u0013\u00104\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u000102HÖ\u0003R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00105\u001a\u0004\b6\u00107R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00105\u001a\u0004\b8\u00107R\u001c\u0010 \u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u00109\u001a\u0004\b:\u0010;R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010<\u001a\u0004\b=\u0010>R\u001c\u0010\"\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010?\u001a\u0004\b@\u0010AR\u001a\u0010#\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010B\u001a\u0004\bC\u0010DR\u001a\u0010$\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010B\u001a\u0004\bE\u0010DR\u001a\u0010%\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010F\u001a\u0004\bG\u0010HR\u001c\u0010&\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010?\u001a\u0004\bI\u0010AR\u001c\u0010'\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010?\u001a\u0004\bJ\u0010AR\u001a\u0010(\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010B\u001a\u0004\bK\u0010DR\u001a\u0010)\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010F\u001a\u0004\bL\u0010HR\u001a\u0010*\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010B\u001a\u0004\bM\u0010DR\u001c\u0010+\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010N\u001a\u0004\bO\u0010PR\u001c\u0010,\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010?\u001a\u0004\bQ\u0010AR\u001a\u0010-\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010F\u001a\u0004\bR\u0010HR\u001a\u0010.\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010B\u001a\u0004\bS\u0010D¨\u0006V"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderMediaModel;", "Ljava/io/Serializable;", "", "withPreview", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getImageUrl", "Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "component1", "component2", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "component3", "", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderMediaPreviewModel;", "component4", "", "component5", "component6", "component7", "", "component8", "component9", "component10", "component11", "component12", "component13", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/n;", "component14", "component15", "component16", "component17", "video", "previewVideo", "image", "previewList", "previewImageUrl", "supportPreview", "supportThumbList", "previewType", "findSameUrl", "findSameUrlForScreenShot", "supportNavBlur", "previewIndex", "videoButtonNewStyle", "videoInteractor", "imageScaleType", "fillMode", "disableNavDecor", "copy", "toString", "hashCode", "", "other", "equals", "Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "getVideo", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "getPreviewVideo", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "getImage", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "Ljava/util/List;", "getPreviewList", "()Ljava/util/List;", "Ljava/lang/String;", "getPreviewImageUrl", "()Ljava/lang/String;", "Z", "getSupportPreview", "()Z", "getSupportThumbList", "I", "getPreviewType", "()I", "getFindSameUrl", "getFindSameUrlForScreenShot", "getSupportNavBlur", "getPreviewIndex", "getVideoButtonNewStyle", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/n;", "getVideoInteractor", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/n;", "getImageScaleType", "getFillMode", "getDisableNavDecor", "<init>", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Ljava/util/List;Ljava/lang/String;ZZILjava/lang/String;Ljava/lang/String;ZIZLcom/bytedance/android/shopping/anchorv4/voavhs/headv2/n;Ljava/lang/String;IZ)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderMediaModel implements Serializable {

    @SerializedName("disable_nav_decor")
    private final boolean disableNavDecor;

    @SerializedName("fill_mode")
    private final int fillMode;

    @SerializedName("find_same_url")
    private final String findSameUrl;

    @SerializedName("find_same_url_v2")
    private final String findSameUrlForScreenShot;

    @SerializedName("image")
    private final ImageModel image;

    @SerializedName("image_scale_type")
    private final String imageScaleType;

    @SerializedName("pre_image_url")
    private final String previewImageUrl;

    @SerializedName("preview_index")
    private final int previewIndex;

    @SerializedName("preview_list")
    private final List<HeaderMediaPreviewModel> previewList;

    @SerializedName("preview_type")
    private final int previewType;

    @SerializedName("preview_video")
    private final VideoModel previewVideo;

    @SerializedName("support_nav_blur")
    private final boolean supportNavBlur;

    @SerializedName("support_preview")
    private final boolean supportPreview;

    @SerializedName("support_thumb_list")
    private final boolean supportThumbList;

    @SerializedName("video")
    private final VideoModel video;

    @SerializedName("video_button_new_style")
    private final boolean videoButtonNewStyle;

    @SerializedName("video_lynx_interactor")
    private final n videoInteractor;

    public HeaderMediaModel() {
        this(null, null, null, null, null, false, false, 0, null, null, false, 0, false, null, null, 0, false, 131071, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HeaderMediaModel copy$default(HeaderMediaModel r17, VideoModel r18, VideoModel r19, ImageModel r20, List r21, String r22, boolean r23, boolean r24, int r25, String r26, String r27, boolean r28, int r29, boolean r30, n r31, String r32, int r33, boolean r34, int r35, Object r36) {
        if ((r35 & 1) == 0) goto L5;
        VideoModel r2 = r17.video;
    L7:
        if ((r35 & 2) == 0) goto L9;
        VideoModel r3 = r17.previewVideo;
    L11:
        if ((r35 & 4) == 0) goto L13;
        ImageModel r4 = r17.image;
    L15:
        if ((r35 & 8) == 0) goto L17;
        List r5 = r17.previewList;
    L19:
        if ((r35 & 16) == 0) goto L21;
        String r6 = r17.previewImageUrl;
    L23:
        if ((r35 & 32) == 0) goto L25;
        boolean r7 = r17.supportPreview;
    L27:
        if ((r35 & 64) == 0) goto L29;
        boolean r8 = r17.supportThumbList;
    L31:
        if ((r35 & 128) == 0) goto L33;
        int r9 = r17.previewType;
    L35:
        if ((r35 & 256) == 0) goto L37;
        String r10 = r17.findSameUrl;
    L39:
        if ((r35 & 512) == 0) goto L41;
        String r11 = r17.findSameUrlForScreenShot;
    L43:
        if ((r35 & 1024) == 0) goto L45;
        boolean r12 = r17.supportNavBlur;
    L47:
        if ((r35 & 2048) == 0) goto L49;
        int r13 = r17.previewIndex;
    L51:
        if ((r35 & 4096) == 0) goto L53;
        boolean r14 = r17.videoButtonNewStyle;
    L55:
        if ((r35 & 8192) == 0) goto L57;
        n r15 = r17.videoInteractor;
    L58:
        n r37 = r15;
        if ((r35 & 16384) == 0) goto L61;
        String r16 = r17.imageScaleType;
    L62:
        String r38 = r16;
        if ((r35 & 32768) == 0) goto L65;
        int r110 = r17.fillMode;
    L67:
        if ((r35 & 65536) == 0) goto L69;
        boolean r1 = r17.disableNavDecor;
    L71:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r37, r38, r110, r1);
    L69:
        r1 = r34;
        goto L71
    L65:
        r110 = r33;
        goto L67
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final VideoModel component1() {
        return this.video;
    }

    public final String component10() {
        return this.findSameUrlForScreenShot;
    }

    public final boolean component11() {
        return this.supportNavBlur;
    }

    public final int component12() {
        return this.previewIndex;
    }

    public final boolean component13() {
        return this.videoButtonNewStyle;
    }

    public final n component14() {
        return this.videoInteractor;
    }

    public final String component15() {
        return this.imageScaleType;
    }

    public final int component16() {
        return this.fillMode;
    }

    public final boolean component17() {
        return this.disableNavDecor;
    }

    public final VideoModel component2() {
        return this.previewVideo;
    }

    public final ImageModel component3() {
        return this.image;
    }

    public final List<HeaderMediaPreviewModel> component4() {
        return this.previewList;
    }

    public final String component5() {
        return this.previewImageUrl;
    }

    public final boolean component6() {
        return this.supportPreview;
    }

    public final boolean component7() {
        return this.supportThumbList;
    }

    public final int component8() {
        return this.previewType;
    }

    public final String component9() {
        return this.findSameUrl;
    }

    public final HeaderMediaModel copy(VideoModel r20, VideoModel r21, ImageModel r22, List<HeaderMediaPreviewModel> r23, String r24, boolean r25, boolean r26, int r27, String r28, String r29, boolean r30, int r31, boolean r32, n r33, String r34, int r35, boolean r36) {
        return new HeaderMediaModel(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HeaderMediaModel) == false) goto L40;
        HeaderMediaModel r4 = (HeaderMediaModel) r3;
        if (Intrinsics.areEqual(this.video, r4.video) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.previewVideo, r4.previewVideo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.image, r4.image) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.previewList, r4.previewList) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.previewImageUrl, r4.previewImageUrl) == true) goto L16;
        return false;
    L16:
        if (this.supportPreview == r4.supportPreview) goto L18;
        return false;
    L18:
        if (this.supportThumbList == r4.supportThumbList) goto L20;
        return false;
    L20:
        if (this.previewType == r4.previewType) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.findSameUrl, r4.findSameUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.findSameUrlForScreenShot, r4.findSameUrlForScreenShot) == true) goto L26;
        return false;
    L26:
        if (this.supportNavBlur == r4.supportNavBlur) goto L28;
        return false;
    L28:
        if (this.previewIndex == r4.previewIndex) goto L30;
        return false;
    L30:
        if (this.videoButtonNewStyle == r4.videoButtonNewStyle) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.videoInteractor, r4.videoInteractor) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.imageScaleType, r4.imageScaleType) == true) goto L36;
        return false;
    L36:
        if (this.fillMode == r4.fillMode) goto L38;
        return false;
    L38:
        if (this.disableNavDecor == r4.disableNavDecor) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v34, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v24, types: [int] */
    /* JADX WARN: Type inference failed for: r2v27, types: [int] */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        VideoModel r0 = this.video;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        VideoModel r4 = this.previewVideo;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ImageModel r7 = this.image;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<HeaderMediaPreviewModel> r10 = this.previewList;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.previewImageUrl;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        boolean r16 = this.supportPreview;
        ?? r17 = 1;
        ?? r18 = r16;
        if (r16 == false) goto L25;
        r18 = 1;
    L25:
        int r19 = (r15 + r18) * 31;
        boolean r20 = this.supportThumbList;
        ?? r21 = r20;
        if (r20 == false) goto L28;
        r21 = 1;
    L28:
        int r22 = (((r19 + r21) * 31) + this.previewType) * 31;
        String r23 = this.findSameUrl;
        if (r23 == null) goto L31;
        int r24 = r23.hashCode();
    L32:
        int r25 = (r22 + r24) * 31;
        String r26 = this.findSameUrlForScreenShot;
        if (r26 == null) goto L35;
        int r27 = r26.hashCode();
    L36:
        int r28 = (r25 + r27) * 31;
        boolean r29 = this.supportNavBlur;
        ?? r30 = r29;
        if (r29 == false) goto L39;
        r30 = 1;
    L39:
        int r31 = (((r28 + r30) * 31) + this.previewIndex) * 31;
        boolean r32 = this.videoButtonNewStyle;
        ?? r33 = r32;
        if (r32 == false) goto L42;
        r33 = 1;
    L42:
        int r34 = (r31 + r33) * 31;
        n r35 = this.videoInteractor;
        if (r35 == null) goto L45;
        int r36 = r35.hashCode();
    L46:
        int r37 = (r34 + r36) * 31;
        String r38 = this.imageScaleType;
        if (r38 == null) goto L49;
        r1 = r38.hashCode();
    L49:
        int r39 = (((r37 + r1) * 31) + this.fillMode) * 31;
        boolean r40 = this.disableNavDecor;
        if (r40 == true) goto L54;
        r17 = r40;
    L54:
        return r39 + r17;
    L45:
        r36 = 0;
        goto L46
    L35:
        r27 = 0;
        goto L36
    L31:
        r24 = 0;
        goto L32
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "HeaderMediaModel(video=" + this.video + ", previewVideo=" + this.previewVideo + ", image=" + this.image + ", previewList=" + this.previewList + ", previewImageUrl=" + this.previewImageUrl + ", supportPreview=" + this.supportPreview + ", supportThumbList=" + this.supportThumbList + ", previewType=" + this.previewType + ", findSameUrl=" + this.findSameUrl + ", findSameUrlForScreenShot=" + this.findSameUrlForScreenShot + ", supportNavBlur=" + this.supportNavBlur + ", previewIndex=" + this.previewIndex + ", videoButtonNewStyle=" + this.videoButtonNewStyle + ", videoInteractor=" + this.videoInteractor + ", imageScaleType=" + this.imageScaleType + ", fillMode=" + this.fillMode + ", disableNavDecor=" + this.disableNavDecor + ")";
    }

    public final boolean getDisableNavDecor() {
        return this.disableNavDecor;
    }

    public final int getFillMode() {
        return this.fillMode;
    }

    public final String getFindSameUrl() {
        return this.findSameUrl;
    }

    public final String getFindSameUrlForScreenShot() {
        return this.findSameUrlForScreenShot;
    }

    public final ImageModel getImage() {
        return this.image;
    }

    public final String getImageScaleType() {
        return this.imageScaleType;
    }

    public final String getPreviewImageUrl() {
        return this.previewImageUrl;
    }

    public final int getPreviewIndex() {
        return this.previewIndex;
    }

    public final List<HeaderMediaPreviewModel> getPreviewList() {
        return this.previewList;
    }

    public final int getPreviewType() {
        return this.previewType;
    }

    public final VideoModel getPreviewVideo() {
        return this.previewVideo;
    }

    public final boolean getSupportNavBlur() {
        return this.supportNavBlur;
    }

    public final boolean getSupportPreview() {
        return this.supportPreview;
    }

    public final boolean getSupportThumbList() {
        return this.supportThumbList;
    }

    public final VideoModel getVideo() {
        return this.video;
    }

    public final boolean getVideoButtonNewStyle() {
        return this.videoButtonNewStyle;
    }

    public final n getVideoInteractor() {
        return this.videoInteractor;
    }

    public final ECUrlModel getImageUrl(boolean r2) {
        if (r2 == false) goto L11;
        ImageModel r3 = this.image;
        if (r3 == null) goto L7;
        ECUrlModel r4 = r3.getPreview();
    L8:
        if (r4 == null) goto L11;
        return this.image.getPreview();
    L7:
        r4 = null;
    L11:
        ImageModel r5 = this.image;
        if (r5 != null) goto L20;
        VideoModel r6 = this.video;
        if (r6 == null) goto L21;
        ImageModel r7 = r6.getPosterImage();
        if (r7 != null) goto L19;
        return null;
    L19:
        return r7.getRemote();
    L21:
        return null;
    L20:
        return r5.getRemote();
    }

    public static /* synthetic */ ECUrlModel getImageUrl$default(HeaderMediaModel r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.getImageUrl(r1);
    }

    public HeaderMediaModel(VideoModel r3, VideoModel r4, ImageModel r5, List<HeaderMediaPreviewModel> r6, String r7, boolean r8, boolean r9, int r10, String r11, String r12, boolean r13, int r14, boolean r15, n r16, String r17, int r18, boolean r19) {
        this.video = r3;
        this.previewVideo = r4;
        this.image = r5;
        this.previewList = r6;
        this.previewImageUrl = r7;
        this.supportPreview = r8;
        this.supportThumbList = r9;
        this.previewType = r10;
        this.findSameUrl = r11;
        this.findSameUrlForScreenShot = r12;
        this.supportNavBlur = r13;
        this.previewIndex = r14;
        this.videoButtonNewStyle = r15;
        this.videoInteractor = r16;
        this.imageScaleType = r17;
        this.fillMode = r18;
        this.disableNavDecor = r19;
    }

    public /* synthetic */ HeaderMediaModel(VideoModel r19, VideoModel r20, ImageModel r21, List r22, String r23, boolean r24, boolean r25, int r26, String r27, String r28, boolean r29, int r30, boolean r31, n r32, String r33, int r34, boolean r35, int r36, DefaultConstructorMarker r37) {
        if ((r36 & 1) == 0) goto L5;
        VideoModel r1 = null;
    L7:
        if ((r36 & 2) == 0) goto L9;
        VideoModel r3 = null;
    L11:
        if ((r36 & 4) == 0) goto L13;
        ImageModel r4 = null;
    L15:
        if ((r36 & 8) == 0) goto L17;
        List r5 = null;
    L19:
        if ((r36 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r36 & 32) == 0) goto L25;
        boolean r7 = false;
    L27:
        if ((r36 & 64) == 0) goto L29;
        boolean r9 = false;
    L31:
        if ((r36 & 128) == 0) goto L33;
        int r10 = 0;
    L35:
        if ((r36 & 256) == 0) goto L37;
        String r11 = null;
    L39:
        if ((r36 & 512) == 0) goto L41;
        String r12 = null;
    L43:
        if ((r36 & 1024) == 0) goto L45;
        boolean r13 = false;
    L47:
        if ((r36 & 2048) == 0) goto L49;
        int r14 = 0;
    L51:
        if ((r36 & 4096) == 0) goto L53;
        boolean r15 = false;
    L55:
        if ((r36 & 8192) == 0) goto L57;
        n r2 = null;
    L59:
        if ((r36 & 16384) == 0) goto L61;
        String r8 = null;
    L63:
        if ((r36 & 32768) == 0) goto L65;
        int r16 = 0;
    L67:
        if ((r36 & 65536) == 0) goto L69;
        boolean r0 = false;
    L70:
        this(r1, r3, r4, r5, r6, r7, r9, r10, r11, r12, r13, r14, r15, r2, r8, r16, r0);
        return;
    L69:
        r0 = r35;
        goto L70
    L65:
        r16 = r34;
        goto L67
    L61:
        r8 = r33;
        goto L63
    L57:
        r2 = r32;
        goto L59
    L53:
        r15 = r31;
        goto L55
    L49:
        r14 = r30;
        goto L51
    L45:
        r13 = r29;
        goto L47
    L41:
        r12 = r28;
        goto L43
    L37:
        r11 = r27;
        goto L39
    L33:
        r10 = r26;
        goto L35
    L29:
        r9 = r25;
        goto L31
    L25:
        r7 = r24;
        goto L27
    L21:
        r6 = r23;
        goto L23
    L17:
        r5 = r22;
        goto L19
    L13:
        r4 = r21;
        goto L15
    L9:
        r3 = r20;
        goto L11
    L5:
        r1 = r19;
        goto L7
    }
}
