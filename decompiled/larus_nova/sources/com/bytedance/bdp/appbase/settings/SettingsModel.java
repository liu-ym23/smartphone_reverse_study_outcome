package com.bytedance.bdp.appbase.settings;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0017\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0001*B/\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b'\u0010(J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bHÆ\u0003J\t\u0010\n\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0002HÆ\u0003J\t\u0010\f\u001a\u00020\u0002HÆ\u0003J\t\u0010\r\u001a\u00020\bHÆ\u0003J;\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\bHÆ\u0001J\t\u0010\u0015\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0018\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0017\u0010\u000e\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u000f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b!\u0010\u001bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b%\u0010$R\u0017\u0010\u0012\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b&\u0010 ¨\u0006+"}, d2 = {"Lcom/bytedance/bdp/appbase/settings/SettingsModel;", "", "Lorg/json/JSONObject;", "toJson", "", "isSettingsValid", "", "toString", "", "component1", "component2", "component3", "component4", "component5", "lastUpdateTime", "ctxInfo", "settings", "vidInfo", "settingsTime", "copy", "", "hashCode", "other", "equals", "reqFrom", "Ljava/lang/String;", "getReqFrom", "()Ljava/lang/String;", "setReqFrom", "(Ljava/lang/String;)V", "J", "getLastUpdateTime", "()J", "getCtxInfo", "Lorg/json/JSONObject;", "getSettings", "()Lorg/json/JSONObject;", "getVidInfo", "getSettingsTime", "<init>", "(JLjava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;J)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public final class SettingsModel {
    public static final a Companion = null;
    private static final String KEY_CTX_INFO = "ctx_info";
    private static final String KEY_LAST_UPDATE_TIME = "update_time";
    private static final String KEY_SETTINGS_JSON = "settings_json";
    private static final String KEY_SETTINGS_TIME = "settings_time";
    private static final String KEY_VID_INFO = "vid_info";
    private static final String TAG = "SettingsModel";
    private static final long VALID_DURATION = 3600000;
    private final String ctxInfo;
    private final long lastUpdateTime;
    private String reqFrom;
    private final JSONObject settings;
    private final long settingsTime;
    private final JSONObject vidInfo;

    public static final class a {
        public a() {
        }

        public static SettingsModel a(String r110) {
            if (r110 != null) goto L5;
        L8:
            boolean r100 = true;
        L10:
            if (r100 == false) goto L26;
            return null;
        L26:
            JSONObject r101 = new JSONObject(r110);     // Catch: Exception -> L23
            long r102 = r101.optLong("update_time");     // Catch: Exception -> L23
            JSONObject r103 = r101.optJSONObject("vid_info");     // Catch: Exception -> L23
            if (r103 != null) goto L15;
            r103 = new JSONObject();     // Catch: Exception -> L23
        L15:
            JSONObject r111 = r103;
            String r104 = r101.optString("ctx_info");     // Catch: Exception -> L23
            if (r104 != null) goto L18;
            r104 = "";
        L18:
            String r105 = r104;
            long r112 = r101.optLong("settings_time");     // Catch: Exception -> L23
            JSONObject r106 = r101.optJSONObject("settings_json");     // Catch: Exception -> L23
            if (r106 != null) goto L21;
            r106 = new JSONObject();     // Catch: Exception -> L23
        L21:
            return new SettingsModel(r102, r105, r106, r111, r112);
        L23:
            e = move-exception;
            g94.b.d("SettingsModel", new Object[]{r110});
            e.printStackTrace();
            g94.b.b("SettingsModel", new Object[]{"toSettingsModel", e});
            return null;
        L5:
            if (r110.length() == 0) goto L8;
            r100 = false;
            goto L10
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ SettingsModel copy$default(SettingsModel r100, long r101, String r110, JSONObject r111, JSONObject r112, long r113, int r114, Object r115) {
        if ((r114 & 1) == 0) goto L5;
        long r102 = r100.lastUpdateTime;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = r100.ctxInfo;
    L11:
        if ((r114 & 4) == 0) goto L13;
        JSONObject r104 = r100.settings;
    L15:
        if ((r114 & 8) == 0) goto L17;
        JSONObject r105 = r100.vidInfo;
    L19:
        if ((r114 & 16) == 0) goto L21;
        long r106 = r100.settingsTime;
    L23:
        return r100.copy(r102, r103, r104, r105, r106);
    L21:
        r106 = r113;
        goto L23
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }

    public final long component1() {
        return this.lastUpdateTime;
    }

    public final String component2() {
        return this.ctxInfo;
    }

    public final JSONObject component3() {
        return this.settings;
    }

    public final JSONObject component4() {
        return this.vidInfo;
    }

    public final long component5() {
        return this.settingsTime;
    }

    public final SettingsModel copy(long r110, String r111, JSONObject r112, JSONObject r113, long r114) {
        return new SettingsModel(r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SettingsModel) == false) goto L16;
        SettingsModel r101 = (SettingsModel) r100;
        if (this.lastUpdateTime == r101.lastUpdateTime) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.ctxInfo, r101.ctxInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.settings, r101.settings) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.vidInfo, r101.vidInfo) == true) goto L14;
        return false;
    L14:
        if (this.settingsTime == r101.settingsTime) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        long r100 = this.lastUpdateTime;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.ctxInfo;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        JSONObject r106 = this.settings;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        JSONObject r109 = this.vidInfo;
        if (r109 == null) goto L13;
        r103 = r109.hashCode();
    L13:
        int r110 = (r108 + r103) * 31;
        long r111 = this.settingsTime;
        return r110 + ((int) (r111 ^ (r111 >>> 32)));
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("update_time", this.lastUpdateTime);     // Catch: JSONException -> L5
        r100.put("vid_info", this.vidInfo);     // Catch: JSONException -> L5
        r100.put("ctx_info", this.ctxInfo);     // Catch: JSONException -> L5
        r100.put("settings_time", this.settingsTime);     // Catch: JSONException -> L5
        r100.put("settings_json", this.settings);     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        g94.b.b("SettingsModel", new Object[]{"toJson", e});
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

    public final String getCtxInfo() {
        return this.ctxInfo;
    }

    public final long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public final String getReqFrom() {
        return this.reqFrom;
    }

    public final JSONObject getSettings() {
        return this.settings;
    }

    public final long getSettingsTime() {
        return this.settingsTime;
    }

    public final JSONObject getVidInfo() {
        return this.vidInfo;
    }

    public final void setReqFrom(String r100) {
        this.reqFrom = r100;
    }

    public SettingsModel(long r100, String r101, JSONObject r102, JSONObject r103, long r104) {
        this.lastUpdateTime = r100;
        this.ctxInfo = r101;
        this.settings = r102;
        this.vidInfo = r103;
        this.settingsTime = r104;
        this.reqFrom = "unknown";
    }
}
