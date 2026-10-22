package com.bytedance.android.shopping.api.mall.preload.resource;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000  2\u00020\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R(\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006#"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/preload/resource/ECMallResourcePreloadConfig;", "Ljava/io/Serializable;", "", "onceExecuteEnable", "Z", "getOnceExecuteEnable", "()Z", "eventExecuteEnable", "getEventExecuteEnable", "", "defaultMaxAge", "Ljava/lang/Integer;", "getDefaultMaxAge", "()Ljava/lang/Integer;", "", "defaultDelay", "Ljava/lang/Long;", "getDefaultDelay", "()Ljava/lang/Long;", "defaultAsyncEnable", "Ljava/lang/Boolean;", "getDefaultAsyncEnable", "()Ljava/lang/Boolean;", "", "", "Lcom/bytedance/android/shopping/api/mall/preload/resource/ECMallResourcePreloadConfig$ItemConfig;", "itemConfigMap", "Ljava/util/Map;", "getItemConfigMap", "()Ljava/util/Map;", "<init>", "()V", "Companion", "a", "ItemConfig", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallResourcePreloadConfig implements Serializable {
    public static final a Companion = null;
    public static final int ONCE_EXECUTE_TIMING_BOOT_FINISH = 0;
    public static final int ONCE_EXECUTE_TIMING_FMP = 2;
    public static final int ONCE_EXECUTE_TIMING_OPEN = 1;
    public static final int ONCE_EXECUTE_TIMING_TTI = 3;

    @SerializedName("default_async_enable")
    private final Boolean defaultAsyncEnable;

    @SerializedName("default_delay")
    private final Long defaultDelay;

    @SerializedName("default_max_age")
    private final Integer defaultMaxAge;

    @SerializedName("event_execute_enable")
    private final boolean eventExecuteEnable;

    @SerializedName("item_config_map")
    private final Map<String, ItemConfig> itemConfigMap;

    @SerializedName("once_execute_enable")
    private final boolean onceExecuteEnable;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00158\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u001d\u0010\u000bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\"\u0010\u0010R\u001a\u0010#\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b$\u0010\u0017R\u0018\u0010%\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 ¨\u0006'"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/preload/resource/ECMallResourcePreloadConfig$ItemConfig;", "Ljava/io/Serializable;", "()V", "accessiblePages", "", "", "getAccessiblePages", "()Ljava/util/List;", "asyncEnable", "", "getAsyncEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "delay", "", "getDelay", "()Ljava/lang/Long;", "Ljava/lang/Long;", "endTimestamp", "getEndTimestamp", "maxAge", "", "getMaxAge", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "onceExecuteTiming", "getOnceExecuteTiming", "()I", "predecodeEnable", "getPredecodeEnable", "scene", "getScene", "()Ljava/lang/String;", "startTimestamp", "getStartTimestamp", "type", "getType", "url", "getUrl", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ItemConfig implements Serializable {

        @SerializedName("accessible_pages")
        private final List<String> accessiblePages;

        @SerializedName("async_enable")
        private final Boolean asyncEnable;

        @SerializedName("delay")
        private final Long delay;

        @SerializedName("end_timestamp")
        private final Long endTimestamp;

        @SerializedName("max_age")
        private final Integer maxAge;

        @SerializedName("once_execute_timing")
        private final int onceExecuteTiming;

        @SerializedName("predecode_enable")
        private final Boolean predecodeEnable;

        @SerializedName("scene")
        private final String scene;

        @SerializedName("start_timestamp")
        private final Long startTimestamp;

        @SerializedName("type")
        private final Integer type;

        @SerializedName("url")
        private final String url;

        public ItemConfig() {
            this.onceExecuteTiming = 3;
        }

        public final List<String> getAccessiblePages() {
            return this.accessiblePages;
        }

        public final Boolean getAsyncEnable() {
            return this.asyncEnable;
        }

        public final Long getDelay() {
            return this.delay;
        }

        public final Long getEndTimestamp() {
            return this.endTimestamp;
        }

        public final Integer getMaxAge() {
            return this.maxAge;
        }

        public final int getOnceExecuteTiming() {
            return this.onceExecuteTiming;
        }

        public final Boolean getPredecodeEnable() {
            return this.predecodeEnable;
        }

        public final String getScene() {
            return this.scene;
        }

        public final Long getStartTimestamp() {
            return this.startTimestamp;
        }

        public final Integer getType() {
            return this.type;
        }

        public final String getUrl() {
            return this.url;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECMallResourcePreloadConfig() {
    }

    public final Boolean getDefaultAsyncEnable() {
        return this.defaultAsyncEnable;
    }

    public final Long getDefaultDelay() {
        return this.defaultDelay;
    }

    public final Integer getDefaultMaxAge() {
        return this.defaultMaxAge;
    }

    public final boolean getEventExecuteEnable() {
        return this.eventExecuteEnable;
    }

    public final Map<String, ItemConfig> getItemConfigMap() {
        return this.itemConfigMap;
    }

    public final boolean getOnceExecuteEnable() {
        return this.onceExecuteEnable;
    }
}
