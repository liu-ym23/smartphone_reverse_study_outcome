package com.bytedance.locallife.cube.experiments;

import com.bytedance.locallife.cube.api.CubeTimingVersion;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR\u0016\u0010\u0016\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0006R\u0016\u0010\u0018\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0006R\u0016\u0010\u001a\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0006R\u0016\u0010\u001c\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0006R\u0016\u0010\u001e\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0006R\u0016\u0010 \u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0006R\u0016\u0010\"\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0006R\u0016\u0010$\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0006R\u0016\u0010&\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0006R\u0018\u0010(\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0006R\u0016\u0010.\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0006R \u00100\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u0001018\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00104\u001a\u0004\b2\u00103R\u0016\u00105\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0006¨\u00067"}, d2 = {"Lcom/bytedance/locallife/cube/experiments/CubeSetting;", "", "()V", "asyncLynxCheckFile", "", "getAsyncLynxCheckFile", "()Z", "clearUselessInstance", "getClearUselessInstance", "codeCacheIDForCityFeed", "", "getCodeCacheIDForCityFeed", "()Ljava/lang/String;", "cubeBid", "getCubeBid", "cubeErrorIgnoreConfigList", "", "Lcom/bytedance/locallife/cube/experiments/CubeErrorIgnoreConfig;", "getCubeErrorIgnoreConfigList", "()Ljava/util/List;", "cubeTimingVersion", "getCubeTimingVersion", "disableCubeParseSchemaData", "getDisableCubeParseSchemaData", "disableGlobalPropsSafeArea", "getDisableGlobalPropsSafeArea", "disableGlobalPropsWidthHeight", "getDisableGlobalPropsWidthHeight", "disableParseSchemaData", "getDisableParseSchemaData", "disablePoiLynxEventCenter", "getDisablePoiLynxEventCenter", "enableBizExpandNaComponent", "getEnableBizExpandNaComponent", "enableIpadAdapter", "getEnableIpadAdapter", "enableJsbReleaseOpt", "getEnableJsbReleaseOpt", "enableMultiAsyncThread", "getEnableMultiAsyncThread", "fontFamily", "Lcom/bytedance/locallife/cube/experiments/CubeFontFamily;", "getFontFamily", "()Lcom/bytedance/locallife/cube/experiments/CubeFontFamily;", "newLynxCheckFile", "getNewLynxCheckFile", "newLynxMonitor", "getNewLynxMonitor", "teaWhiteList", "", "getTeaWhiteList", "()[Ljava/lang/String;", "[Ljava/lang/String;", "useNewBreakStrategy", "getUseNewBreakStrategy", "cube-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class CubeSetting {

    @SerializedName("async_lynx_check_file")
    private final boolean asyncLynxCheckFile;

    @SerializedName("clear_useless_instance")
    private final boolean clearUselessInstance;

    @SerializedName("codeCacheIDForCityFeed")
    private final String codeCacheIDForCityFeed;

    @SerializedName("cubeBid4Android")
    private final String cubeBid;

    @SerializedName("cube_error_ignore_config_list")
    private final List<CubeErrorIgnoreConfig> cubeErrorIgnoreConfigList;

    @SerializedName("cube_timing_version")
    private final String cubeTimingVersion;

    @SerializedName("disable_cube_parse_schema_data")
    private final boolean disableCubeParseSchemaData;

    @SerializedName("disable_global_props_safe_area")
    private final boolean disableGlobalPropsSafeArea;

    @SerializedName("disable_global_props_width_height")
    private final boolean disableGlobalPropsWidthHeight;

    @SerializedName("disable_parse_schema_data")
    private final boolean disableParseSchemaData;

    @SerializedName("disable_poi_lynx_event_center")
    private final boolean disablePoiLynxEventCenter;

    @SerializedName("enableBizExpandNaComponent")
    private final boolean enableBizExpandNaComponent;

    @SerializedName("enableIpadAdapter")
    private final boolean enableIpadAdapter;

    @SerializedName("enableJsbReleaseOpt")
    private final boolean enableJsbReleaseOpt;

    @SerializedName("enable_multi_async_thread")
    private final boolean enableMultiAsyncThread;

    @SerializedName("custom_font_family")
    private final CubeFontFamily fontFamily;

    @SerializedName("new_lynx_check_file")
    private final boolean newLynxCheckFile;

    @SerializedName("newLynxMonitor")
    private final boolean newLynxMonitor;

    @SerializedName("tea_white_list")
    private final String[] teaWhiteList;

    @SerializedName("useNewBreakStrategy")
    private final boolean useNewBreakStrategy;

    public CubeSetting() {
        this.enableIpadAdapter = true;
        this.enableJsbReleaseOpt = true;
        this.useNewBreakStrategy = true;
        this.clearUselessInstance = true;
        this.disablePoiLynxEventCenter = true;
        this.disableParseSchemaData = true;
        this.cubeTimingVersion = CubeTimingVersion.V2.name();
        this.cubeBid = "bid_poi";
        this.newLynxCheckFile = true;
        this.asyncLynxCheckFile = true;
        this.disableGlobalPropsSafeArea = true;
        this.enableBizExpandNaComponent = true;
        this.newLynxMonitor = true;
    }

    public final boolean getAsyncLynxCheckFile() {
        return this.asyncLynxCheckFile;
    }

    public final boolean getClearUselessInstance() {
        return this.clearUselessInstance;
    }

    public final String getCodeCacheIDForCityFeed() {
        return this.codeCacheIDForCityFeed;
    }

    public final String getCubeBid() {
        return this.cubeBid;
    }

    public final List<CubeErrorIgnoreConfig> getCubeErrorIgnoreConfigList() {
        return this.cubeErrorIgnoreConfigList;
    }

    public final String getCubeTimingVersion() {
        return this.cubeTimingVersion;
    }

    public final boolean getDisableCubeParseSchemaData() {
        return this.disableCubeParseSchemaData;
    }

    public final boolean getDisableGlobalPropsSafeArea() {
        return this.disableGlobalPropsSafeArea;
    }

    public final boolean getDisableGlobalPropsWidthHeight() {
        return this.disableGlobalPropsWidthHeight;
    }

    public final boolean getDisableParseSchemaData() {
        return this.disableParseSchemaData;
    }

    public final boolean getDisablePoiLynxEventCenter() {
        return this.disablePoiLynxEventCenter;
    }

    public final boolean getEnableBizExpandNaComponent() {
        return this.enableBizExpandNaComponent;
    }

    public final boolean getEnableIpadAdapter() {
        return this.enableIpadAdapter;
    }

    public final boolean getEnableJsbReleaseOpt() {
        return this.enableJsbReleaseOpt;
    }

    public final boolean getEnableMultiAsyncThread() {
        return this.enableMultiAsyncThread;
    }

    public final CubeFontFamily getFontFamily() {
        return this.fontFamily;
    }

    public final boolean getNewLynxCheckFile() {
        return this.newLynxCheckFile;
    }

    public final boolean getNewLynxMonitor() {
        return this.newLynxMonitor;
    }

    public final String[] getTeaWhiteList() {
        return this.teaWhiteList;
    }

    public final boolean getUseNewBreakStrategy() {
        return this.useNewBreakStrategy;
    }
}
