package hr9;

import com.google.gson.annotations.SerializedName;
import com.obric.sva.sdk.data.ISettingsModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\rHÆ\u0003JQ\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u000205HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u00066"}, d2 = {"Lcom/larus/platform/model/security/SecurityAzerothSettings;", "", "azerothGlobalSettings", "Lcom/larus/platform/model/security/SecurityAGlobalSetting;", "testConf", "Lcom/larus/platform/model/security/SecurityATestConf;", "envReportSetting", "Lcom/larus/platform/model/security/SecurityAEnvReport;", "dailyReportSetting", "Lcom/larus/platform/model/security/SecurityADailyReportSetting;", "cryptoSetting", "Lcom/larus/platform/model/security/SecurityACryptoSetting;", "aKexgSetting", "Lcom/larus/platform/model/security/SecurityAAKexgSetting;", "<init>", "(Lcom/larus/platform/model/security/SecurityAGlobalSetting;Lcom/larus/platform/model/security/SecurityATestConf;Lcom/larus/platform/model/security/SecurityAEnvReport;Lcom/larus/platform/model/security/SecurityADailyReportSetting;Lcom/larus/platform/model/security/SecurityACryptoSetting;Lcom/larus/platform/model/security/SecurityAAKexgSetting;)V", "getAzerothGlobalSettings", "()Lcom/larus/platform/model/security/SecurityAGlobalSetting;", "setAzerothGlobalSettings", "(Lcom/larus/platform/model/security/SecurityAGlobalSetting;)V", "getTestConf", "()Lcom/larus/platform/model/security/SecurityATestConf;", "setTestConf", "(Lcom/larus/platform/model/security/SecurityATestConf;)V", "getEnvReportSetting", "()Lcom/larus/platform/model/security/SecurityAEnvReport;", "setEnvReportSetting", "(Lcom/larus/platform/model/security/SecurityAEnvReport;)V", "getDailyReportSetting", "()Lcom/larus/platform/model/security/SecurityADailyReportSetting;", "setDailyReportSetting", "(Lcom/larus/platform/model/security/SecurityADailyReportSetting;)V", "getCryptoSetting", "()Lcom/larus/platform/model/security/SecurityACryptoSetting;", "setCryptoSetting", "(Lcom/larus/platform/model/security/SecurityACryptoSetting;)V", "getAKexgSetting", "()Lcom/larus/platform/model/security/SecurityAAKexgSetting;", "setAKexgSetting", "(Lcom/larus/platform/model/security/SecurityAAKexgSetting;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g {

    @SerializedName("akexg")
    private a aKexgSetting;

    @SerializedName(ISettingsModel.NAME_OF_GLOBAL_PREFERENCES)
    private e azerothGlobalSettings;

    @SerializedName("crypto")
    private b cryptoSetting;

    @SerializedName("daily_report")
    private c dailyReportSetting;

    @SerializedName("env_report")
    private d envReportSetting;

    @SerializedName("test_json_conf")
    private f testConf;

    public g() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.azerothGlobalSettings, r101.azerothGlobalSettings) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.testConf, r101.testConf) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.envReportSetting, r101.envReportSetting) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.dailyReportSetting, r101.dailyReportSetting) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.cryptoSetting, r101.cryptoSetting) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.aKexgSetting, r101.aKexgSetting) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        e r100 = this.azerothGlobalSettings;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        f r104 = this.testConf;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        d r107 = this.envReportSetting;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        c r110 = this.dailyReportSetting;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        b r113 = this.cryptoSetting;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        a r116 = this.aKexgSetting;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SecurityAzerothSettings(azerothGlobalSettings=" + this.azerothGlobalSettings + ", testConf=" + this.testConf + ", envReportSetting=" + this.envReportSetting + ", dailyReportSetting=" + this.dailyReportSetting + ", cryptoSetting=" + this.cryptoSetting + ", aKexgSetting=" + this.aKexgSetting + ')';
    }

    public final a a() {
        return this.aKexgSetting;
    }

    public final e b() {
        return this.azerothGlobalSettings;
    }

    public final b c() {
        return this.cryptoSetting;
    }

    public final c d() {
        return this.dailyReportSetting;
    }

    public final d e() {
        return this.envReportSetting;
    }

    public final f f() {
        return this.testConf;
    }

    public g(int r100) {
        e r101 = new e(0);
        f r102 = new f(0);
        d r103 = new d(0);
        c r104 = new c(0);
        b r105 = new b(0);
        a r106 = new a(0);
        this.azerothGlobalSettings = r101;
        this.testConf = r102;
        this.envReportSetting = r103;
        this.dailyReportSetting = r104;
        this.cryptoSetting = r105;
        this.aKexgSetting = r106;
    }
}
