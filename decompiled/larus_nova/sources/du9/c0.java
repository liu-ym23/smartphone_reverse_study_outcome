package du9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b&\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\t\u00103\u001a\u00020\u0012HÆ\u0003J\u0095\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u00105\u001a\u00020\u00032\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0006HÖ\u0001J\t\u00108\u001a\u000209HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0016\u0010\u0010\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006:"}, d2 = {"Lcom/larus/settings/provider/chat/CreationPreviewPerformanceOptConfig;", "", "ugcPreviewArgb", "", "bigImageFullSizeResize", "bigImageFullSizeResizeSize", "", "previewGalleryUseHeic", "msgCardResize", "feedRefResize", "feedAvatarResize", "feedArgb", "feedCoverSr", "videoCoverResize", "videoCoverArgb", "canvasResize", "largeMemGb", "srMinRatio", "", "<init>", "(ZZIZZZZZZZZZIF)V", "getUgcPreviewArgb", "()Z", "getBigImageFullSizeResize", "getBigImageFullSizeResizeSize", "()I", "getPreviewGalleryUseHeic", "getMsgCardResize", "getFeedRefResize", "getFeedAvatarResize", "getFeedArgb", "getFeedCoverSr", "getVideoCoverResize", "getVideoCoverArgb", "getCanvasResize", "getLargeMemGb", "getSrMinRatio", "()F", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c0 {

    @SerializedName("big_image_full_size_resize")
    private final boolean bigImageFullSizeResize;

    @SerializedName("big_image_full_size_resize_size")
    private final int bigImageFullSizeResizeSize;

    @SerializedName("canvas_resize")
    private final boolean canvasResize;

    @SerializedName("feed_argb")
    private final boolean feedArgb;

    @SerializedName("feed_avatar_resize")
    private final boolean feedAvatarResize;

    @SerializedName("feed_cover_sr")
    private final boolean feedCoverSr;

    @SerializedName("feed_ref_resize")
    private final boolean feedRefResize;

    @SerializedName("large_mem_gb")
    private final int largeMemGb;

    @SerializedName("msg_card_resize")
    private final boolean msgCardResize;

    @SerializedName("preview_gallery_use_heic")
    private final boolean previewGalleryUseHeic;

    @SerializedName("sr_min_ratio")
    private final float srMinRatio;

    @SerializedName("ugc_preview_argb")
    private final boolean ugcPreviewArgb;

    @SerializedName("video_cover_argb")
    private final boolean videoCoverArgb;

    @SerializedName("video_cover_resize")
    private final boolean videoCoverResize;

    public c0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r101 = (c0) r100;
        if (this.ugcPreviewArgb == r101.ugcPreviewArgb) goto L12;
        return false;
    L12:
        if (this.bigImageFullSizeResize == r101.bigImageFullSizeResize) goto L15;
        return false;
    L15:
        if (this.bigImageFullSizeResizeSize == r101.bigImageFullSizeResizeSize) goto L18;
        return false;
    L18:
        if (this.previewGalleryUseHeic == r101.previewGalleryUseHeic) goto L21;
        return false;
    L21:
        if (this.msgCardResize == r101.msgCardResize) goto L24;
        return false;
    L24:
        if (this.feedRefResize == r101.feedRefResize) goto L27;
        return false;
    L27:
        if (this.feedAvatarResize == r101.feedAvatarResize) goto L30;
        return false;
    L30:
        if (this.feedArgb == r101.feedArgb) goto L33;
        return false;
    L33:
        if (this.feedCoverSr == r101.feedCoverSr) goto L36;
        return false;
    L36:
        if (this.videoCoverResize == r101.videoCoverResize) goto L39;
        return false;
    L39:
        if (this.videoCoverArgb == r101.videoCoverArgb) goto L42;
        return false;
    L42:
        if (this.canvasResize == r101.canvasResize) goto L45;
        return false;
    L45:
        if (this.largeMemGb == r101.largeMemGb) goto L48;
        return false;
    L48:
        if (Float.compare(this.srMinRatio, r101.srMinRatio) == 0) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.ugcPreviewArgb == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.bigImageFullSizeResize == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((r102 + r103) * 31) + this.bigImageFullSizeResizeSize) * 31;
        if (this.previewGalleryUseHeic == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.msgCardResize == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.feedRefResize == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.feedAvatarResize == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.feedArgb == false) goto L29;
        int r113 = 1231;
    L30:
        int r114 = (r112 + r113) * 31;
        if (this.feedCoverSr == false) goto L33;
        int r115 = 1231;
    L34:
        int r116 = (r114 + r115) * 31;
        if (this.videoCoverResize == false) goto L37;
        int r117 = 1231;
    L38:
        int r118 = (r116 + r117) * 31;
        if (this.videoCoverArgb == false) goto L41;
        int r119 = 1231;
    L42:
        int r120 = (r118 + r119) * 31;
        if (this.canvasResize == true) goto L47;
        r100 = 1237;
    L47:
        return ((((r120 + r100) * 31) + this.largeMemGb) * 31) + Float.floatToIntBits(this.srMinRatio);
    L41:
        r119 = 1237;
        goto L42
    L37:
        r117 = 1237;
        goto L38
    L33:
        r115 = 1237;
        goto L34
    L29:
        r113 = 1237;
        goto L30
    L25:
        r111 = 1237;
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "CreationPreviewPerformanceOptConfig(ugcPreviewArgb=" + this.ugcPreviewArgb + ", bigImageFullSizeResize=" + this.bigImageFullSizeResize + ", bigImageFullSizeResizeSize=" + this.bigImageFullSizeResizeSize + ", previewGalleryUseHeic=" + this.previewGalleryUseHeic + ", msgCardResize=" + this.msgCardResize + ", feedRefResize=" + this.feedRefResize + ", feedAvatarResize=" + this.feedAvatarResize + ", feedArgb=" + this.feedArgb + ", feedCoverSr=" + this.feedCoverSr + ", videoCoverResize=" + this.videoCoverResize + ", videoCoverArgb=" + this.videoCoverArgb + ", canvasResize=" + this.canvasResize + ", largeMemGb=" + this.largeMemGb + ", srMinRatio=" + this.srMinRatio + ')';
    }

    public final boolean a() {
        return this.bigImageFullSizeResize;
    }

    public final int b() {
        return this.bigImageFullSizeResizeSize;
    }

    public final boolean c() {
        return this.canvasResize;
    }

    public final boolean d() {
        return this.feedArgb;
    }

    public final boolean e() {
        return this.feedAvatarResize;
    }

    public final boolean f() {
        return this.feedCoverSr;
    }

    public final boolean g() {
        return this.feedRefResize;
    }

    public final int h() {
        return this.largeMemGb;
    }

    public final boolean i() {
        return this.msgCardResize;
    }

    public final boolean j() {
        return this.previewGalleryUseHeic;
    }

    public final float k() {
        return this.srMinRatio;
    }

    public final boolean l() {
        return this.ugcPreviewArgb;
    }

    public final boolean m() {
        return this.videoCoverArgb;
    }

    public final boolean n() {
        return this.videoCoverResize;
    }

    public c0(int r100) {
        this.ugcPreviewArgb = false;
        this.bigImageFullSizeResize = false;
        this.bigImageFullSizeResizeSize = 5000;
        this.previewGalleryUseHeic = false;
        this.msgCardResize = false;
        this.feedRefResize = false;
        this.feedAvatarResize = false;
        this.feedArgb = false;
        this.feedCoverSr = false;
        this.videoCoverResize = false;
        this.videoCoverArgb = false;
        this.canvasResize = false;
        this.largeMemGb = 6;
        this.srMinRatio = 1.1f;
    }
}
