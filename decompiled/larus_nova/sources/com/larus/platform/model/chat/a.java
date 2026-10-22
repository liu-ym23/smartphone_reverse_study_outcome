package com.larus.platform.model.chat;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003Jc\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\fHÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lcom/larus/platform/model/chat/ActionBarOptConfig;", "", "enableCacheMerge", "", "enableAsyncStoreDisk", "enableCachePreload", "enableNormalHolderNitaPreload", "enableRedDotMemoryCache", "enableFastRender", "enableDefaultReplyOptionCache", "enableIndependentImageCache", "imagePrefetchCount", "", "<init>", "(ZZZZZZZZI)V", "getEnableCacheMerge", "()Z", "getEnableAsyncStoreDisk", "getEnableCachePreload", "getEnableNormalHolderNitaPreload", "getEnableRedDotMemoryCache", "getEnableFastRender", "getEnableDefaultReplyOptionCache", "getEnableIndependentImageCache", "getImagePrefetchCount", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("enable_async_store_disk")
    private final boolean enableAsyncStoreDisk;

    @SerializedName("enable_cache_merge")
    private final boolean enableCacheMerge;

    @SerializedName("enable_cache_preload")
    private final boolean enableCachePreload;

    @SerializedName("enable_default_reply_option_cache")
    private final boolean enableDefaultReplyOptionCache;

    @SerializedName("enable_fast_render")
    private final boolean enableFastRender;

    @SerializedName("enable_independent_image_cache")
    private final boolean enableIndependentImageCache;

    @SerializedName("enable_normal_holder_nita_preload")
    private final boolean enableNormalHolderNitaPreload;

    @SerializedName("enable_red_dot_memory_cache")
    private final boolean enableRedDotMemoryCache;

    @SerializedName("image_prefetch_count")
    private final int imagePrefetchCount;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.enableCacheMerge == r101.enableCacheMerge) goto L12;
        return false;
    L12:
        if (this.enableAsyncStoreDisk == r101.enableAsyncStoreDisk) goto L15;
        return false;
    L15:
        if (this.enableCachePreload == r101.enableCachePreload) goto L18;
        return false;
    L18:
        if (this.enableNormalHolderNitaPreload == r101.enableNormalHolderNitaPreload) goto L21;
        return false;
    L21:
        if (this.enableRedDotMemoryCache == r101.enableRedDotMemoryCache) goto L24;
        return false;
    L24:
        if (this.enableFastRender == r101.enableFastRender) goto L27;
        return false;
    L27:
        if (this.enableDefaultReplyOptionCache == r101.enableDefaultReplyOptionCache) goto L30;
        return false;
    L30:
        if (this.enableIndependentImageCache == r101.enableIndependentImageCache) goto L33;
        return false;
    L33:
        if (this.imagePrefetchCount == r101.imagePrefetchCount) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enableCacheMerge == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableAsyncStoreDisk == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.enableCachePreload == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.enableNormalHolderNitaPreload == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.enableRedDotMemoryCache == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.enableFastRender == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.enableDefaultReplyOptionCache == false) goto L29;
        int r113 = 1231;
    L30:
        int r114 = (r112 + r113) * 31;
        if (this.enableIndependentImageCache == true) goto L35;
        r100 = 1237;
    L35:
        return ((r114 + r100) * 31) + this.imagePrefetchCount;
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
        return "ActionBarOptConfig(enableCacheMerge=" + this.enableCacheMerge + ", enableAsyncStoreDisk=" + this.enableAsyncStoreDisk + ", enableCachePreload=" + this.enableCachePreload + ", enableNormalHolderNitaPreload=" + this.enableNormalHolderNitaPreload + ", enableRedDotMemoryCache=" + this.enableRedDotMemoryCache + ", enableFastRender=" + this.enableFastRender + ", enableDefaultReplyOptionCache=" + this.enableDefaultReplyOptionCache + ", enableIndependentImageCache=" + this.enableIndependentImageCache + ", imagePrefetchCount=" + this.imagePrefetchCount + ')';
    }

    public final boolean b() {
        return this.enableAsyncStoreDisk;
    }

    public final boolean c() {
        return this.enableCacheMerge;
    }

    public final boolean d() {
        return this.enableCachePreload;
    }

    public final boolean e() {
        return this.enableDefaultReplyOptionCache;
    }

    public final boolean f() {
        return this.enableFastRender;
    }

    public final boolean g() {
        return this.enableIndependentImageCache;
    }

    public final boolean h() {
        return this.enableNormalHolderNitaPreload;
    }

    public final boolean i() {
        return this.enableRedDotMemoryCache;
    }

    public final int j() {
        return this.imagePrefetchCount;
    }

    public /* synthetic */ a(int r110) {
        this(false, false, false, false, false, false, false, false, 5);
    }

    public static a a(a r110, boolean r111) {
        boolean r100 = r110.enableCacheMerge;
        boolean r101 = r110.enableAsyncStoreDisk;
        boolean r102 = r110.enableCachePreload;
        boolean r103 = r110.enableNormalHolderNitaPreload;
        boolean r104 = r110.enableRedDotMemoryCache;
        boolean r105 = r110.enableFastRender;
        boolean r106 = r110.enableDefaultReplyOptionCache;
        int r107 = r110.imagePrefetchCount;
        r110.getClass();
        return new a(r100, r101, r102, r103, r104, r105, r106, r111, r107);
    }

    public a(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107, int r108) {
        this.enableCacheMerge = r100;
        this.enableAsyncStoreDisk = r101;
        this.enableCachePreload = r102;
        this.enableNormalHolderNitaPreload = r103;
        this.enableRedDotMemoryCache = r104;
        this.enableFastRender = r105;
        this.enableDefaultReplyOptionCache = r106;
        this.enableIndependentImageCache = r107;
        this.imagePrefetchCount = r108;
    }
}
