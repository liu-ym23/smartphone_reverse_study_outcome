package com.bytedance.ies.bullet.redirect.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u000b\b\u0087\b\u0018\u0000 22\u00020\u0001:\u00013B5\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b0\u00101J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010\u000e\u001a\u00020\rHÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\rHÆ\u0001J\t\u0010\u0014\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R4\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170)0(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00064"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/data/RedirectSettingsData;", "Ljava/io/Serializable;", "", "isExpired", "Lcom/bytedance/ies/bullet/redirect/data/a;", "info", "Lcom/bytedance/ies/bullet/redirect/data/b;", "getTargetInfoWithEntryKey", "Lorg/json/JSONObject;", "component1", "component2", "", "component3", "", "component4", "redirectRules", "commonConfig", "geckoCDNVersion", "settingsDataInitTime", "copy", "toString", "", "hashCode", "", "other", "equals", "Lorg/json/JSONObject;", "getRedirectRules", "()Lorg/json/JSONObject;", "getCommonConfig", "Ljava/lang/String;", "getGeckoCDNVersion", "()Ljava/lang/String;", "setGeckoCDNVersion", "(Ljava/lang/String;)V", "J", "getSettingsDataInitTime", "()J", "setSettingsDataInitTime", "(J)V", "", "", "mRedirectRuleMap", "Ljava/util/Map;", "getMRedirectRuleMap", "()Ljava/util/Map;", "setMRedirectRuleMap", "(Ljava/util/Map;)V", "<init>", "(Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;J)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class RedirectSettingsData implements Serializable {
    public static final a Companion = null;
    private final JSONObject commonConfig;
    private String geckoCDNVersion;
    private Map<String, List<Object>> mRedirectRuleMap;
    private final JSONObject redirectRules;
    private long settingsDataInitTime;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public RedirectSettingsData() {
        this(null, null, null, 0, 15, null);
    }

    public static /* synthetic */ RedirectSettingsData copy$default(RedirectSettingsData r100, JSONObject r101, JSONObject r102, String r103, long r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.redirectRules;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.commonConfig;
    L8:
        JSONObject r111 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.geckoCDNVersion;
    L11:
        String r106 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.settingsDataInitTime;
    L14:
        JSONObject r107 = r101;
        return r100.copy(r107, r111, r106, r104);
    }

    public final JSONObject component1() {
        return this.redirectRules;
    }

    public final JSONObject component2() {
        return this.commonConfig;
    }

    public final String component3() {
        return this.geckoCDNVersion;
    }

    public final long component4() {
        return this.settingsDataInitTime;
    }

    public final RedirectSettingsData copy(JSONObject r100, JSONObject r101, String r110, long r111) {
        return new RedirectSettingsData(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RedirectSettingsData) == true) goto L8;
        return false;
    L8:
        RedirectSettingsData r101 = (RedirectSettingsData) r100;
        if (Intrinsics.areEqual(this.redirectRules, r101.redirectRules) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.commonConfig, r101.commonConfig) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.geckoCDNVersion, r101.geckoCDNVersion) == true) goto L18;
        return false;
    L18:
        if (this.settingsDataInitTime == r101.settingsDataInitTime) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        JSONObject r100 = this.redirectRules;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        JSONObject r104 = this.commonConfig;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.geckoCDNVersion;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        int r108 = (r106 + r101) * 31;
        long r109 = this.settingsDataInitTime;
        return r108 + ((int) (r109 ^ (r109 >>> 32)));
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "RedirectSettingsData(redirectRules=" + this.redirectRules + ", commonConfig=" + this.commonConfig + ", geckoCDNVersion=" + this.geckoCDNVersion + ", settingsDataInitTime=" + this.settingsDataInitTime + ')';
    }

    public final boolean isExpired() {
        long r100 = System.currentTimeMillis() - this.settingsDataInitTime;
        JSONObject r101 = this.commonConfig;
        if (r101 == null) goto L5;
        long r102 = r101.optLong("limit_second");
    L7:
        if (r100 <= (r102 * ((long) 1000))) goto L9;
        return true;
    L9:
        return false;
    L5:
        r102 = 0;
        goto L7
    }

    public final JSONObject getCommonConfig() {
        return this.commonConfig;
    }

    public final String getGeckoCDNVersion() {
        return this.geckoCDNVersion;
    }

    public final Map<String, List<Object>> getMRedirectRuleMap() {
        return this.mRedirectRuleMap;
    }

    public final JSONObject getRedirectRules() {
        return this.redirectRules;
    }

    public final long getSettingsDataInitTime() {
        return this.settingsDataInitTime;
    }

    public final b getTargetInfoWithEntryKey(com.bytedance.ies.bullet.redirect.data.a r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        throw null;
    }

    public final void setGeckoCDNVersion(String r100) {
        this.geckoCDNVersion = r100;
    }

    public final void setMRedirectRuleMap(Map<String, List<Object>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mRedirectRuleMap = r100;
    }

    public final void setSettingsDataInitTime(long r100) {
        this.settingsDataInitTime = r100;
    }

    public RedirectSettingsData(JSONObject r100, JSONObject r101, String r102, long r103) {
        this.redirectRules = r100;
        this.commonConfig = r101;
        this.geckoCDNVersion = r102;
        this.settingsDataInitTime = r103;
        this.mRedirectRuleMap = new LinkedHashMap();
    }

    public /* synthetic */ RedirectSettingsData(JSONObject r100, JSONObject r101, String r102, long r103, int r104, DefaultConstructorMarker r105) {
        String r106 = null;
        if ((r104 & 1) == 0) goto L5;
        JSONObject r107 = null;
    L7:
        if ((r104 & 2) == 0) goto L9;
        JSONObject r108 = null;
    L11:
        if ((r104 & 4) != 0) goto L15;
        r106 = r102;
    L15:
        if ((r104 & 8) == 0) goto L17;
        r103 = System.currentTimeMillis();
    L17:
        this(r107, r108, r106, r103);
        return;
    L9:
        r108 = r101;
        goto L11
    L5:
        r107 = r100;
        goto L7
    }
}
