package com.bytedance.awemeopen.infra.plugs.settings;

import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.npth.AoExceptionReporter;
import com.bytedance.awemeopen.infra.base.npth.ErrorPriority;
import com.bytedance.awemeopen.servicesapi.npth.AoNpthService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bHÆ\u0003J\t\u0010\n\u001a\u00020\u0002HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u0002HÆ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u000b\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/bytedance/awemeopen/infra/plugs/settings/SettingsModel;", "", "Lorg/json/JSONObject;", "toJson", "", "isSettingsValid", "", "toString", "", "component1", "component2", "lastUpdateTime", "settings", "copy", "", "hashCode", "other", "equals", "J", "getLastUpdateTime", "()J", "Lorg/json/JSONObject;", "getSettings", "()Lorg/json/JSONObject;", "<init>", "(JLorg/json/JSONObject;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_plugin_settings_release"}, k = 1, mv = {1, 7, 1})
public final class SettingsModel {
    public static final a Companion = null;
    private static final String KEY_LAST_UPDATE_TIME = "update_time";
    private static final String KEY_SETTINGS_JSON = "settings_json";
    private static final String TAG = "SettingsModel";
    private static final long VALID_DURATION = 3600000;
    private final long lastUpdateTime;
    private final JSONObject settings;

    public static final class a {
        public a() {
        }

        public static SettingsModel a(String r100) {
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L10:
            if (r101 == false) goto L20;
            return null;
        L20:
            JSONObject r102 = new JSONObject(r100);     // Catch: Exception -> L17
            long r103 = r102.optLong("update_time");     // Catch: Exception -> L17
            JSONObject r104 = r102.optJSONObject("settings_json");     // Catch: Exception -> L17
            if (r104 != null) goto L15;
            r104 = new JSONObject();     // Catch: Exception -> L17
        L15:
            return new SettingsModel(r103, r104);
        L17:
            e = move-exception;
            AoNpthService r105 = AoExceptionReporter.f198706a;
            AoExceptionReporter.a(ErrorPriority.f198712p2, "settingsModel", "toSettingsModel", "json_parse_error", e);
            AoLogger.c("SettingsModel", new Object[]{"toSettingsModel", e});
            return null;
        L5:
            if (r100.length() == 0) goto L8;
            r101 = false;
            goto L10
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ SettingsModel copy$default(SettingsModel r100, long r101, JSONObject r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.lastUpdateTime;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.settings;
    L9:
        return r100.copy(r101, r102);
    }

    public final long component1() {
        return this.lastUpdateTime;
    }

    public final JSONObject component2() {
        return this.settings;
    }

    public final SettingsModel copy(long r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "settings");
        return new SettingsModel(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SettingsModel) == true) goto L8;
        return false;
    L8:
        SettingsModel r101 = (SettingsModel) r100;
        if (this.lastUpdateTime == r101.lastUpdateTime) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.settings, r101.settings) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        long r100 = this.lastUpdateTime;
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.settings.hashCode();
    }

    public final JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("update_time", this.lastUpdateTime);     // Catch: JSONException -> L5
        r100.put("settings_json", this.settings);     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        AoLogger.c("SettingsModel", new Object[]{"toJson", e});
        goto L7
    }

    public final boolean isSettingsValid() {
        if ((System.currentTimeMillis() - this.lastUpdateTime) >= 3600000) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return toJson().toString();
    }

    public final long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public final JSONObject getSettings() {
        return this.settings;
    }

    public SettingsModel(long r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "settings");
        this.lastUpdateTime = r100;
        this.settings = r101;
    }
}
