package com.bytedance.locallife.poi.experiment;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
public final class PoiStandardEmbeddedViewConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f262572a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f262573b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f262574c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f262575d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f262576e = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/locallife/poi/experiment/PoiStandardEmbeddedViewConfig$a;", "", "", "Lcom/bytedance/locallife/poi/experiment/PoiStandardEmbeddedViewConfig$d;", "food", "Ljava/util/List;", "getFood", "()Ljava/util/List;", "general", "getGeneral", "trip", "getTrip", "deliver", "getDeliver", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("deliver")
        private final List<d> deliver;

        @SerializedName("food")
        private final List<d> food;

        @SerializedName("general")
        private final List<d> general;

        @SerializedName("trip")
        private final List<d> trip;

        public a() {
            this.food = null;
            this.general = null;
            this.trip = null;
            this.deliver = null;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/locallife/poi/experiment/PoiStandardEmbeddedViewConfig$b;", "", "", "enable", "I", "getEnable", "()I", "enablePreload", "getEnablePreload", "Lcom/bytedance/locallife/poi/experiment/PoiStandardEmbeddedViewConfig$a;", "preloadConfig", "Lcom/bytedance/locallife/poi/experiment/PoiStandardEmbeddedViewConfig$a;", "getPreloadConfig", "()Lcom/bytedance/locallife/poi/experiment/PoiStandardEmbeddedViewConfig$a;", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("enable")
        private final int enable;

        @SerializedName("enable_preload")
        private final int enablePreload;

        @SerializedName("preload_config")
        private final a preloadConfig;

        public b() {
            this(0);
        }

        public b(int r100) {
            this.enable = 0;
            this.enablePreload = 0;
            this.preloadConfig = null;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/locallife/poi/experiment/PoiStandardEmbeddedViewConfig$c;", "", "", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "", "preCreateCount", "I", "getPreCreateCount", "()I", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("precreate_count")
        private final int preCreateCount;

        @SerializedName("url")
        private final String url;

        public c() {
            this.url = null;
            this.preCreateCount = 0;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/locallife/poi/experiment/PoiStandardEmbeddedViewConfig$d;", "", "", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "", "preloadCount", "I", "getPreloadCount", "()I", "preCreateCount", "getPreCreateCount", "", "Lcom/bytedance/locallife/poi/experiment/PoiStandardEmbeddedViewConfig$c;", "framePreDecodeList", "Ljava/util/List;", "getFramePreDecodeList", "()Ljava/util/List;", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        @SerializedName("frame_predecode_list")
        private final List<c> framePreDecodeList;

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
            this.framePreDecodeList = null;
        }
    }

    public PoiStandardEmbeddedViewConfig() {
    }

    static {
        f262572a = new b(0);
        f262573b = LazyKt.lazy(PoiStandardEmbeddedViewConfig$rawJson$2.INSTANCE);
        f262574c = LazyKt.lazy(PoiStandardEmbeddedViewConfig$serverJson$2.INSTANCE);
        f262575d = LazyKt.lazy(PoiStandardEmbeddedViewConfig$clientConfig$2.INSTANCE);
        f262576e = LazyKt.lazy(PoiStandardEmbeddedViewConfig$enablePresetSize$2.INSTANCE);
    }
}
