package nu9;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/larus/settings/provider/dora/G2SilentOtaConfig;", "", "<init>", "()V", "featureEnabled", "Lcom/google/gson/JsonElement;", "getFeatureEnabled", "()Lcom/google/gson/JsonElement;", "setFeatureEnabled", "(Lcom/google/gson/JsonElement;)V", "autoInstallStartTime", "getAutoInstallStartTime", "setAutoInstallStartTime", "autoInstallEndTime", "getAutoInstallEndTime", "setAutoInstallEndTime", "manualRearmDelayMinutes", "getManualRearmDelayMinutes", "setManualRearmDelayMinutes", "installCooldownMinutes", "getInstallCooldownMinutes", "setInstallCooldownMinutes", "Companion", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class t {

    @SerializedName("auto_install_end_time")
    private JsonElement autoInstallEndTime;

    @SerializedName("auto_install_start_time")
    private JsonElement autoInstallStartTime;

    @SerializedName("feature_enabled")
    private JsonElement featureEnabled;

    @SerializedName("install_cooldown_minutes")
    private JsonElement installCooldownMinutes;

    @SerializedName("manual_rearm_delay_minutes")
    private JsonElement manualRearmDelayMinutes;

    public static final class a {
    }

    static {
    }

    public t() {
    }

    public final JsonElement a() {
        return this.autoInstallEndTime;
    }

    public final JsonElement b() {
        return this.autoInstallStartTime;
    }

    public final JsonElement c() {
        return this.featureEnabled;
    }

    public final JsonElement d() {
        return this.installCooldownMinutes;
    }

    public final JsonElement e() {
        return this.manualRearmDelayMinutes;
    }

    public final void f(JsonPrimitive r100) {
        this.autoInstallEndTime = r100;
    }

    public final void g(JsonPrimitive r100) {
        this.autoInstallStartTime = r100;
    }

    public final void h(JsonPrimitive r100) {
        this.featureEnabled = r100;
    }

    public final void i(JsonPrimitive r100) {
        this.installCooldownMinutes = r100;
    }

    public final void j(JsonPrimitive r100) {
        this.manualRearmDelayMinutes = r100;
    }
}
