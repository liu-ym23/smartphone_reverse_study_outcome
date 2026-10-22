package com.bytedance.locallife.poi.experiment;

import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
public final class PoiShelfNativeContainerConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f262567a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f262568b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f262569c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f262570d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f262571e = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/locallife/poi/experiment/PoiShelfNativeContainerConfig$a;", "", "Lcom/bytedance/locallife/poi/experiment/PoiShelfNativeContainerConfig$c;", "food", "Lcom/bytedance/locallife/poi/experiment/PoiShelfNativeContainerConfig$c;", "getFood", "()Lcom/bytedance/locallife/poi/experiment/PoiShelfNativeContainerConfig$c;", "general", "getGeneral", "trip", "getTrip", "deliver", "getDeliver", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("deliver")
        private final c deliver;

        @SerializedName("food")
        private final c food;

        @SerializedName("general")
        private final c general;

        @SerializedName("trip")
        private final c trip;

        public a() {
            this.food = null;
            this.general = null;
            this.trip = null;
            this.deliver = null;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/locallife/poi/experiment/PoiShelfNativeContainerConfig$b;", "", "", "enable", "I", "getEnable", "()I", "Lcom/bytedance/locallife/poi/experiment/PoiShelfNativeContainerConfig$a;", "preloadConfig", "Lcom/bytedance/locallife/poi/experiment/PoiShelfNativeContainerConfig$a;", "getPreloadConfig", "()Lcom/bytedance/locallife/poi/experiment/PoiShelfNativeContainerConfig$a;", "enableUpdateSizeBeforeLoad", "getEnableUpdateSizeBeforeLoad", "firstLoadCountWhenHalfScreen", "getFirstLoadCountWhenHalfScreen", "firstLoadCountWhenFullScreen", "getFirstLoadCountWhenFullScreen", "aheadLoadMode", "getAheadLoadMode", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("ahead_load_mode")
        private final int aheadLoadMode;

        @SerializedName("enable")
        private final int enable;

        @SerializedName("enable_update_size_before_load")
        private final int enableUpdateSizeBeforeLoad;

        @SerializedName("first_load_count_when_full_screen")
        private final int firstLoadCountWhenFullScreen;

        @SerializedName("first_load_count_when_half_screen")
        private final int firstLoadCountWhenHalfScreen;

        @SerializedName("preload_config")
        private final a preloadConfig;

        public b() {
            this(0);
        }

        public b(int r100) {
            this.enable = 0;
            this.preloadConfig = null;
            this.enableUpdateSizeBeforeLoad = 0;
            this.firstLoadCountWhenHalfScreen = 0;
            this.firstLoadCountWhenFullScreen = 0;
            this.aheadLoadMode = 0;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/locallife/poi/experiment/PoiShelfNativeContainerConfig$c;", "", "Lcom/bytedance/locallife/poi/experiment/PoiShelfNativeContainerConfig$d;", "shelfProductCard", "Lcom/bytedance/locallife/poi/experiment/PoiShelfNativeContainerConfig$d;", "getShelfProductCard", "()Lcom/bytedance/locallife/poi/experiment/PoiShelfNativeContainerConfig$d;", "shelfCouponBar", "getShelfCouponBar", "atmosphereHeader", "getAtmosphereHeader", "atmosphereBg", "getAtmosphereBg", "", "disableCodeCache", "Ljava/lang/Boolean;", "getDisableCodeCache", "()Ljava/lang/Boolean;", "enablePreload", "getEnablePreload", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("atmosphere_highlight_bg")
        private final d atmosphereBg;

        @SerializedName("atmosphere_header")
        private final d atmosphereHeader;

        @SerializedName("disable_code_cache")
        private final Boolean disableCodeCache;

        @SerializedName("enable_preload")
        private final Boolean enablePreload;

        @SerializedName("poi_shelf_coupon_bar")
        private final d shelfCouponBar;

        @SerializedName("shelf_product_card")
        private final d shelfProductCard;

        public c() {
            this.shelfProductCard = null;
            this.shelfCouponBar = null;
            this.atmosphereHeader = null;
            this.atmosphereBg = null;
            this.disableCodeCache = null;
            this.enablePreload = null;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/locallife/poi/experiment/PoiShelfNativeContainerConfig$d;", "", "", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "", "preloadCount", "I", "getPreloadCount", "()I", "preCreateCount", "getPreCreateCount", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        @SerializedName("precreate_count")
        private final int preCreateCount;

        @SerializedName("preload_count")
        private final int preloadCount;

        @SerializedName("url")
        private final String url;

        public d() {
            this.url = null;
            this.preloadCount = 1;
            this.preCreateCount = 0;
        }
    }

    public PoiShelfNativeContainerConfig() {
    }

    static {
        f262567a = new b(0);
        f262568b = LazyKt.lazy(PoiShelfNativeContainerConfig$rawJson$2.INSTANCE);
        f262569c = LazyKt.lazy(PoiShelfNativeContainerConfig$serverJson$2.INSTANCE);
        f262570d = LazyKt.lazy(PoiShelfNativeContainerConfig$turboV2Enable$2.INSTANCE);
        f262571e = LazyKt.lazy(PoiShelfNativeContainerConfig$clientConfig$2.INSTANCE);
    }
}
