package com.bytedance.locallife.poi.experiment;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\b¨\u0006'"}, d2 = {"Lcom/bytedance/locallife/poi/experiment/g;", "", "", "enable", "Ljava/lang/Boolean;", "getEnable", "()Ljava/lang/Boolean;", "setEnable", "(Ljava/lang/Boolean;)V", "enableFontOpt", "c", "setEnableFontOpt", "enablePredecodeOpt", "f", "setEnablePredecodeOpt", "enablePredecodeDynamicOpt", "e", "setEnablePredecodeDynamicOpt", "enableClassOpt", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setEnableClassOpt", "enableJsonOpt", "d", "setEnableJsonOpt", "enableMapPluginOpt", "getEnableMapPluginOpt", "setEnableMapPluginOpt", "", "poiWarmupThrottleInterval", "Ljava/lang/Long;", ce.f26391f, "()Ljava/lang/Long;", "setPoiWarmupThrottleInterval", "(Ljava/lang/Long;)V", "enableCodecacheOpt", "b", "setEnableCodecacheOpt", "<init>", "()V", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("enable")
    private Boolean enable;

    @SerializedName("enable_class_opt")
    private Boolean enableClassOpt;

    @SerializedName("enable_codecache_opt")
    private Boolean enableCodecacheOpt;

    @SerializedName("enable_font_opt")
    private Boolean enableFontOpt;

    @SerializedName("enable_json_opt")
    private Boolean enableJsonOpt;

    @SerializedName("enable_map_plugin_opt")
    private Boolean enableMapPluginOpt;

    @SerializedName("enable_predecode_dynamic_opt")
    private Boolean enablePredecodeDynamicOpt;

    @SerializedName("enable_predecode_opt")
    private Boolean enablePredecodeOpt;

    @SerializedName("poi_warmup_throttle_interval")
    private Long poiWarmupThrottleInterval;

    public g() {
        Boolean r100 = Boolean.FALSE;
        this.enable = r100;
        this.enableFontOpt = r100;
        this.enablePredecodeOpt = r100;
        this.enablePredecodeDynamicOpt = r100;
        this.enableClassOpt = r100;
        this.enableJsonOpt = r100;
        this.enableMapPluginOpt = r100;
        this.poiWarmupThrottleInterval = 0L;
        this.enableCodecacheOpt = r100;
    }

    public final Boolean a() {
        return this.enableClassOpt;
    }

    public final Boolean b() {
        return this.enableCodecacheOpt;
    }

    public final Boolean c() {
        return this.enableFontOpt;
    }

    public final Boolean d() {
        return this.enableJsonOpt;
    }

    public final Boolean e() {
        return this.enablePredecodeDynamicOpt;
    }

    public final Boolean f() {
        return this.enablePredecodeOpt;
    }

    public final Long g() {
        return this.poiWarmupThrottleInterval;
    }
}
