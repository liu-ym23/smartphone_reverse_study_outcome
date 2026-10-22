package com.bytedance.ies.bullet.base.settings;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001a\u0010\n\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006R\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/b;", "", "", "isMemoryLeak", "I", "f", "()I", "isCleanAllLynxView", "isALogOpt", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "isHighFrequencyObjCreate", "d", "isJSONOpt", "e", "isHighFrequencyJSBOpt", "isResourceANROpt", "isANROpt", "isMemoryOpt", "isCrashOpt", "isAnnieSettingsParseOptQ2", "b", "isMemoryLeakQ2", ce.f26391f, "isCardBizEnvOptQ2", "c", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("is_alog_opt")
    private final int isALogOpt;

    @SerializedName("is_anr_opt")
    private final int isANROpt;

    @SerializedName("is_annie_settings_parse_opt_q2")
    private final int isAnnieSettingsParseOptQ2;

    @SerializedName("is_card_biz_env_opt_q2")
    private final int isCardBizEnvOptQ2;

    @SerializedName("is_clean_all_lynx_view")
    private final int isCleanAllLynxView;

    @SerializedName("is_crash_opt")
    private final int isCrashOpt;

    @SerializedName("is_high_frequency_jsb_opt")
    private final int isHighFrequencyJSBOpt;

    @SerializedName("is_high_frequency_obj_create")
    private final int isHighFrequencyObjCreate;

    @SerializedName("is_json_opt")
    private final int isJSONOpt;

    @SerializedName("is_memory_leak")
    private final int isMemoryLeak;

    @SerializedName("is_memory_leak_q2")
    private final int isMemoryLeakQ2;

    @SerializedName("is_memory_opt")
    private final int isMemoryOpt;

    @SerializedName("is_resource_anr_opt")
    private final int isResourceANROpt;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.isMemoryLeak == r101.isMemoryLeak) goto L12;
        return false;
    L12:
        if (this.isCleanAllLynxView == r101.isCleanAllLynxView) goto L15;
        return false;
    L15:
        if (this.isALogOpt == r101.isALogOpt) goto L18;
        return false;
    L18:
        if (this.isHighFrequencyObjCreate == r101.isHighFrequencyObjCreate) goto L21;
        return false;
    L21:
        if (this.isJSONOpt == r101.isJSONOpt) goto L24;
        return false;
    L24:
        if (this.isHighFrequencyJSBOpt == r101.isHighFrequencyJSBOpt) goto L27;
        return false;
    L27:
        if (this.isResourceANROpt == r101.isResourceANROpt) goto L30;
        return false;
    L30:
        if (this.isANROpt == r101.isANROpt) goto L33;
        return false;
    L33:
        if (this.isMemoryOpt == r101.isMemoryOpt) goto L36;
        return false;
    L36:
        if (this.isCrashOpt == r101.isCrashOpt) goto L39;
        return false;
    L39:
        if (this.isAnnieSettingsParseOptQ2 == r101.isAnnieSettingsParseOptQ2) goto L42;
        return false;
    L42:
        if (this.isMemoryLeakQ2 == r101.isMemoryLeakQ2) goto L45;
        return false;
    L45:
        if (this.isCardBizEnvOptQ2 == r101.isCardBizEnvOptQ2) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((((((((((((this.isMemoryLeak * 31) + this.isCleanAllLynxView) * 31) + this.isALogOpt) * 31) + this.isHighFrequencyObjCreate) * 31) + this.isJSONOpt) * 31) + this.isHighFrequencyJSBOpt) * 31) + this.isResourceANROpt) * 31) + this.isANROpt) * 31) + this.isMemoryOpt) * 31) + this.isCrashOpt) * 31) + this.isAnnieSettingsParseOptQ2) * 31) + this.isMemoryLeakQ2) * 31) + this.isCardBizEnvOptQ2;
    }

    public final String toString() {
        return "AnnieXMemoryOptConfig(isMemoryLeak=" + this.isMemoryLeak + ", isCleanAllLynxView=" + this.isCleanAllLynxView + ", isALogOpt=" + this.isALogOpt + ", isHighFrequencyObjCreate=" + this.isHighFrequencyObjCreate + ", isJSONOpt=" + this.isJSONOpt + ", isHighFrequencyJSBOpt=" + this.isHighFrequencyJSBOpt + ", isResourceANROpt=" + this.isResourceANROpt + ", isANROpt=" + this.isANROpt + ", isMemoryOpt=" + this.isMemoryOpt + ", isCrashOpt=" + this.isCrashOpt + ", isAnnieSettingsParseOptQ2=" + this.isAnnieSettingsParseOptQ2 + ", isMemoryLeakQ2=" + this.isMemoryLeakQ2 + ", isCardBizEnvOptQ2=" + this.isCardBizEnvOptQ2 + ')';
    }

    public final int a() {
        return this.isALogOpt;
    }

    public final int b() {
        return this.isAnnieSettingsParseOptQ2;
    }

    public final int c() {
        return this.isCardBizEnvOptQ2;
    }

    public final int d() {
        return this.isHighFrequencyObjCreate;
    }

    public final int e() {
        return this.isJSONOpt;
    }

    public final int f() {
        return this.isMemoryLeak;
    }

    public final int g() {
        return this.isMemoryLeakQ2;
    }

    public b(int r100) {
        this.isMemoryLeak = 1;
        this.isCleanAllLynxView = 1;
        this.isALogOpt = 1;
        this.isHighFrequencyObjCreate = 1;
        this.isJSONOpt = 1;
        this.isHighFrequencyJSBOpt = 1;
        this.isResourceANROpt = 1;
        this.isANROpt = 1;
        this.isMemoryOpt = 1;
        this.isCrashOpt = 1;
        this.isAnnieSettingsParseOptQ2 = 0;
        this.isMemoryLeakQ2 = 1;
        this.isCardBizEnvOptQ2 = 1;
    }
}
