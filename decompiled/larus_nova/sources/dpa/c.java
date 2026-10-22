package dpa;

import com.google.gson.annotations.SerializedName;
import com.obric.sva.sdk.data.ISettingsModel;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    @SerializedName("akexg")
    public a aKexgSetting;

    @SerializedName(ISettingsModel.NAME_OF_GLOBAL_PREFERENCES)
    public b azerothGlobalSettings;

    @SerializedName("crypto")
    public e cryptoSetting;

    @SerializedName("daily_report")
    public f dailyReportSetting;

    @SerializedName("env_report")
    public g envReportSetting;

    @SerializedName("test_json_conf")
    public i testConf;

    public c() {
    }

    public static c a() {
        c r100 = new c();
        b r101 = new b();
        r101.global_function_switch = true;
        r100.azerothGlobalSettings = r101;
        i r102 = new i();
        r102.msg = "hello from local default!";
        r102.version = 0;
        r100.testConf = r102;
        g r103 = new g();
        r103.enabled = true;
        r103.version = 0;
        r103.report_interval = 24;
        r103.collect_android_id = false;
        r103.collect_iccid = false;
        r103.collect_imei = false;
        r103.collect_mac = false;
        r103.min_report_interval = 28800;
        r100.envReportSetting = r103;
        f r104 = new f();
        r104.enabled = true;
        r100.dailyReportSetting = r104;
        e r105 = new e();
        r105.enabled = true;
        r105.version = 0;
        r105.disable_crypto = false;
        r105.disable_android_key_store = false;
        r100.cryptoSetting = r105;
        a r106 = new a();
        r106.downgrade = false;
        r100.aKexgSetting = r106;
        return r100;
    }

    public final String toString() {
        return "AzerothSettings{global_function_switch=" + this.azerothGlobalSettings.global_function_switch + ", envReportSetting.version=" + this.envReportSetting.version + ", dailyReportSetting.enabled=" + this.dailyReportSetting.enabled + ", cryptoSetting.version=" + this.cryptoSetting.version + ", aKexgSetting.downgrade=" + this.aKexgSetting.downgrade + '}';
    }
}
