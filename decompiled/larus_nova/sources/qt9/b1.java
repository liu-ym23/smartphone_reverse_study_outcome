package qt9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b<\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BÝ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00105\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010:\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010;\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010<\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010>\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJä\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010EJ\u0013\u0010F\u001a\u00020\u00032\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010H\u001a\u00020\u0007HÖ\u0001J\t\u0010I\u001a\u00020JHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\"\u0010\u001cR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b#\u0010\u001cR\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b$\u0010\u001cR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b%\u0010\u001cR\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010(\u001a\u0004\b)\u0010'R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010(\u001a\u0004\b*\u0010'R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b+\u0010\u001cR\u001a\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010(\u001a\u0004\b,\u0010'R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b-\u0010\u001cR\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b.\u0010\u001cR\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b/\u0010\u001cR\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b0\u0010\u001cR\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b1\u0010\u001c¨\u0006K"}, d2 = {"Lcom/larus/settings/provider/FlowFrescoOptConfig;", "", "enable", "", "localVideoThumbOptEnable", "heifDecodeOptEnable", "heifDecodeOptType", "", "splitMemCacheEnable", "bigImgCacheEnable", "optReuseBitmapCacheEnable", "anrOptEnable", "maxNormalMemoryCacheSizePercent", "", "maxAnimMemoryCacheSizePercent", "maxBigMemoryCacheSizePercent", "encodedMemoryCacheOpt", "encodedMemoryCacheSizePercent", "optLazyInit", "skipLazyRead", "ignoreContentLengthCheck", "useBitmapPrepareToDraw", "preparePrefetchToDraw", "<init>", "(ZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getEnable", "()Z", "getLocalVideoThumbOptEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHeifDecodeOptEnable", "getHeifDecodeOptType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSplitMemCacheEnable", "getBigImgCacheEnable", "getOptReuseBitmapCacheEnable", "getAnrOptEnable", "getMaxNormalMemoryCacheSizePercent", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getMaxAnimMemoryCacheSizePercent", "getMaxBigMemoryCacheSizePercent", "getEncodedMemoryCacheOpt", "getEncodedMemoryCacheSizePercent", "getOptLazyInit", "getSkipLazyRead", "getIgnoreContentLengthCheck", "getUseBitmapPrepareToDraw", "getPreparePrefetchToDraw", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "(ZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larus/settings/provider/FlowFrescoOptConfig;", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b1 {

    @SerializedName("anr_opt_enable")
    private final Boolean anrOptEnable;

    @SerializedName("big_img_cache_enable")
    private final Boolean bigImgCacheEnable;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("encoded_memory_cache_opt")
    private final Boolean encodedMemoryCacheOpt;

    @SerializedName("encoded_memory_cache_size_percent")
    private final Float encodedMemoryCacheSizePercent;

    @SerializedName("heif_decode_opt_enable")
    private final Boolean heifDecodeOptEnable;

    @SerializedName("heif_decode_opt_type")
    private final Integer heifDecodeOptType;

    @SerializedName("ignore_content_length_check")
    private final Boolean ignoreContentLengthCheck;

    @SerializedName("local_video_thumb_opt_enable")
    private final Boolean localVideoThumbOptEnable;

    @SerializedName("max_anim_memory_cache_size_percent")
    private final Float maxAnimMemoryCacheSizePercent;

    @SerializedName("max_big_memory_cache_size_percent")
    private final Float maxBigMemoryCacheSizePercent;

    @SerializedName("max_normal_memory_cache_size_percent")
    private final Float maxNormalMemoryCacheSizePercent;

    @SerializedName("encoded_fresco_lazy_init")
    private final Boolean optLazyInit;

    @SerializedName("opt_reuse_bitmap_cache_enable")
    private final Boolean optReuseBitmapCacheEnable;

    @SerializedName("prepare_prefetch_to_draw")
    private final Boolean preparePrefetchToDraw;

    @SerializedName("skip_lazy_read")
    private final Boolean skipLazyRead;

    @SerializedName("split_mem_cache_enable")
    private final Boolean splitMemCacheEnable;

    @SerializedName("use_bitmap_prepare_to_draw")
    private final Boolean useBitmapPrepareToDraw;

    public b1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b1) == true) goto L8;
        return false;
    L8:
        b1 r101 = (b1) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.localVideoThumbOptEnable, r101.localVideoThumbOptEnable) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.heifDecodeOptEnable, r101.heifDecodeOptEnable) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.heifDecodeOptType, r101.heifDecodeOptType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.splitMemCacheEnable, r101.splitMemCacheEnable) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.bigImgCacheEnable, r101.bigImgCacheEnable) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.optReuseBitmapCacheEnable, r101.optReuseBitmapCacheEnable) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.anrOptEnable, r101.anrOptEnable) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.maxNormalMemoryCacheSizePercent, r101.maxNormalMemoryCacheSizePercent) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.maxAnimMemoryCacheSizePercent, r101.maxAnimMemoryCacheSizePercent) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.maxBigMemoryCacheSizePercent, r101.maxBigMemoryCacheSizePercent) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.encodedMemoryCacheOpt, r101.encodedMemoryCacheOpt) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.encodedMemoryCacheSizePercent, r101.encodedMemoryCacheSizePercent) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.optLazyInit, r101.optLazyInit) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.skipLazyRead, r101.skipLazyRead) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.ignoreContentLengthCheck, r101.ignoreContentLengthCheck) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.useBitmapPrepareToDraw, r101.useBitmapPrepareToDraw) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.preparePrefetchToDraw, r101.preparePrefetchToDraw) == true) goto L62;
        return false;
    L62:
        return true;
    }

    public final int hashCode() {
        if (this.enable == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        Boolean r102 = this.localVideoThumbOptEnable;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        Boolean r106 = this.heifDecodeOptEnable;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        Integer r109 = this.heifDecodeOptType;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        Boolean r112 = this.splitMemCacheEnable;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        Boolean r115 = this.bigImgCacheEnable;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        Boolean r118 = this.optReuseBitmapCacheEnable;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        Boolean r121 = this.anrOptEnable;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        Float r124 = this.maxNormalMemoryCacheSizePercent;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        Float r127 = this.maxAnimMemoryCacheSizePercent;
        if (r127 != null) goto L41;
        int r128 = 0;
    L42:
        int r129 = (r126 + r128) * 31;
        Float r130 = this.maxBigMemoryCacheSizePercent;
        if (r130 != null) goto L45;
        int r131 = 0;
    L46:
        int r132 = (r129 + r131) * 31;
        Boolean r133 = this.encodedMemoryCacheOpt;
        if (r133 != null) goto L49;
        int r134 = 0;
    L50:
        int r135 = (r132 + r134) * 31;
        Float r136 = this.encodedMemoryCacheSizePercent;
        if (r136 != null) goto L53;
        int r137 = 0;
    L54:
        int r138 = (r135 + r137) * 31;
        Boolean r139 = this.optLazyInit;
        if (r139 != null) goto L57;
        int r140 = 0;
    L58:
        int r141 = (r138 + r140) * 31;
        Boolean r142 = this.skipLazyRead;
        if (r142 != null) goto L61;
        int r143 = 0;
    L62:
        int r144 = (r141 + r143) * 31;
        Boolean r145 = this.ignoreContentLengthCheck;
        if (r145 != null) goto L65;
        int r146 = 0;
    L66:
        int r147 = (r144 + r146) * 31;
        Boolean r148 = this.useBitmapPrepareToDraw;
        if (r148 != null) goto L69;
        int r149 = 0;
    L70:
        int r150 = (r147 + r149) * 31;
        Boolean r151 = this.preparePrefetchToDraw;
        if (r151 == null) goto L75;
        r103 = r151.hashCode();
    L75:
        return r150 + r103;
    L69:
        r149 = r148.hashCode();
        goto L70
    L65:
        r146 = r145.hashCode();
        goto L66
    L61:
        r143 = r142.hashCode();
        goto L62
    L57:
        r140 = r139.hashCode();
        goto L58
    L53:
        r137 = r136.hashCode();
        goto L54
    L49:
        r134 = r133.hashCode();
        goto L50
    L45:
        r131 = r130.hashCode();
        goto L46
    L41:
        r128 = r127.hashCode();
        goto L42
    L37:
        r125 = r124.hashCode();
        goto L38
    L33:
        r122 = r121.hashCode();
        goto L34
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlowFrescoOptConfig(enable=" + this.enable + ", localVideoThumbOptEnable=" + this.localVideoThumbOptEnable + ", heifDecodeOptEnable=" + this.heifDecodeOptEnable + ", heifDecodeOptType=" + this.heifDecodeOptType + ", splitMemCacheEnable=" + this.splitMemCacheEnable + ", bigImgCacheEnable=" + this.bigImgCacheEnable + ", optReuseBitmapCacheEnable=" + this.optReuseBitmapCacheEnable + ", anrOptEnable=" + this.anrOptEnable + ", maxNormalMemoryCacheSizePercent=" + this.maxNormalMemoryCacheSizePercent + ", maxAnimMemoryCacheSizePercent=" + this.maxAnimMemoryCacheSizePercent + ", maxBigMemoryCacheSizePercent=" + this.maxBigMemoryCacheSizePercent + ", encodedMemoryCacheOpt=" + this.encodedMemoryCacheOpt + ", encodedMemoryCacheSizePercent=" + this.encodedMemoryCacheSizePercent + ", optLazyInit=" + this.optLazyInit + ", skipLazyRead=" + this.skipLazyRead + ", ignoreContentLengthCheck=" + this.ignoreContentLengthCheck + ", useBitmapPrepareToDraw=" + this.useBitmapPrepareToDraw + ", preparePrefetchToDraw=" + this.preparePrefetchToDraw + ')';
    }

    public final Boolean a() {
        return this.anrOptEnable;
    }

    public final Boolean b() {
        return this.bigImgCacheEnable;
    }

    public final boolean c() {
        return this.enable;
    }

    public final Boolean d() {
        return this.encodedMemoryCacheOpt;
    }

    public final Float e() {
        return this.encodedMemoryCacheSizePercent;
    }

    public final Boolean f() {
        return this.heifDecodeOptEnable;
    }

    public final Integer g() {
        return this.heifDecodeOptType;
    }

    public final Boolean h() {
        return this.ignoreContentLengthCheck;
    }

    public final Boolean i() {
        return this.localVideoThumbOptEnable;
    }

    public final Float j() {
        return this.maxAnimMemoryCacheSizePercent;
    }

    public final Float k() {
        return this.maxBigMemoryCacheSizePercent;
    }

    public final Float l() {
        return this.maxNormalMemoryCacheSizePercent;
    }

    public final Boolean m() {
        return this.optLazyInit;
    }

    public final Boolean n() {
        return this.optReuseBitmapCacheEnable;
    }

    public final Boolean o() {
        return this.preparePrefetchToDraw;
    }

    public final Boolean p() {
        return this.skipLazyRead;
    }

    public final Boolean q() {
        return this.splitMemCacheEnable;
    }

    public final Boolean r() {
        return this.useBitmapPrepareToDraw;
    }

    public b1(int r100) {
        Boolean r101 = Boolean.FALSE;
        Boolean r102 = Boolean.TRUE;
        this.enable = false;
        this.localVideoThumbOptEnable = r101;
        this.heifDecodeOptEnable = r101;
        this.heifDecodeOptType = null;
        this.splitMemCacheEnable = r101;
        this.bigImgCacheEnable = r101;
        this.optReuseBitmapCacheEnable = r101;
        this.anrOptEnable = r101;
        this.maxNormalMemoryCacheSizePercent = null;
        this.maxAnimMemoryCacheSizePercent = null;
        this.maxBigMemoryCacheSizePercent = null;
        this.encodedMemoryCacheOpt = r101;
        this.encodedMemoryCacheSizePercent = null;
        this.optLazyInit = r102;
        this.skipLazyRead = r101;
        this.ignoreContentLengthCheck = r102;
        this.useBitmapPrepareToDraw = r101;
        this.preparePrefetchToDraw = r101;
    }
}
