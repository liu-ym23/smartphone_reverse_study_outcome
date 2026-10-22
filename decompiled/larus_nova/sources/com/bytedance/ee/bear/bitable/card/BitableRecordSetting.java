package com.bytedance.ee.bear.bitable.card;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@AppConfig(key = "base_itemview_config")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0003%&'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/BitableRecordSetting;", "", "<init>", "()V", "openUpdateJsOpt", "", "getOpenUpdateJsOpt", "()Z", "setOpenUpdateJsOpt", "(Z)V", "columnThreshold", "", "getColumnThreshold", "()I", "setColumnThreshold", "(I)V", "belowThresholdConfig", "Lcom/bytedance/ee/bear/bitable/card/BitableRecordSetting$CardListFetchConfig;", "getBelowThresholdConfig", "()Lcom/bytedance/ee/bear/bitable/card/BitableRecordSetting$CardListFetchConfig;", "setBelowThresholdConfig", "(Lcom/bytedance/ee/bear/bitable/card/BitableRecordSetting$CardListFetchConfig;)V", "aboveThresholdConfig", "getAboveThresholdConfig", "setAboveThresholdConfig", "switchActionConfig", "Lcom/bytedance/ee/bear/bitable/card/BitableRecordSetting$SwitchActionConfig;", "getSwitchActionConfig", "()Lcom/bytedance/ee/bear/bitable/card/BitableRecordSetting$SwitchActionConfig;", "setSwitchActionConfig", "(Lcom/bytedance/ee/bear/bitable/card/BitableRecordSetting$SwitchActionConfig;)V", "deviceConfig", "Lcom/bytedance/ee/bear/bitable/card/BitableRecordSetting$DeviceConfig;", "getDeviceConfig", "()Lcom/bytedance/ee/bear/bitable/card/BitableRecordSetting$DeviceConfig;", "setDeviceConfig", "(Lcom/bytedance/ee/bear/bitable/card/BitableRecordSetting$DeviceConfig;)V", "CardListFetchConfig", "SwitchActionConfig", "DeviceConfig", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableRecordSetting {

    @SerializedName("above_threshold")
    private a aboveThresholdConfig;

    @SerializedName("below_threshold")
    private a belowThresholdConfig;

    @SerializedName("column_threshold")
    private int columnThreshold;

    @SerializedName("device_config")
    private b deviceConfig;

    @SerializedName("open_update_record_js_opt")
    private boolean openUpdateJsOpt;

    @SerializedName("switch_action_config")
    private c switchActionConfig;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/BitableRecordSetting$CardListFetchConfig;", "", "<init>", "()V", "offset", "", "getOffset", "()I", "setOffset", "(I)V", "length", "getLength", "setLength", "toString", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("updatePreloadSize")
        private int length;

        @SerializedName("updateOffsetSize")
        private int offset;

        public final String toString() {
            return "o=" + this.offset + ";l=" + this.length;
        }

        public a() {
            this.offset = 5;
            this.length = 11;
        }

        public final int a() {
            return this.length;
        }

        public final int b() {
            return this.offset;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/BitableRecordSetting$DeviceConfig;", "", "<init>", "()V", "lowDeviceScoreThreshold", "", "getLowDeviceScoreThreshold", "()F", "setLowDeviceScoreThreshold", "(F)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("lowDeviceScoreThreshold")
        private float lowDeviceScoreThreshold;

        public b() {
            this.lowDeviceScoreThreshold = 7.3f;
        }

        public final float a() {
            return this.lowDeviceScoreThreshold;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/BitableRecordSetting$SwitchActionConfig;", "", "<init>", "()V", "saveSwitchMaxDays", "", "getSaveSwitchMaxDays", "()I", "setSaveSwitchMaxDays", "(I)V", "saveSwitchMaxCount", "getSaveSwitchMaxCount", "setSaveSwitchMaxCount", "highFrequencyThreshold", "getHighFrequencyThreshold", "setHighFrequencyThreshold", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c {

        @SerializedName("highFrequencyThreshold")
        private int highFrequencyThreshold;

        @SerializedName("saveSwitchMaxCount")
        private int saveSwitchMaxCount;

        @SerializedName("saveSwitchMaxDays")
        private int saveSwitchMaxDays;

        public c() {
            this.saveSwitchMaxDays = 2;
            this.saveSwitchMaxCount = 100;
            this.highFrequencyThreshold = 4;
        }

        public final int a() {
            return this.highFrequencyThreshold;
        }

        public final int b() {
            return this.saveSwitchMaxCount;
        }

        public final int c() {
            return this.saveSwitchMaxDays;
        }
    }

    public BitableRecordSetting() {
        this.belowThresholdConfig = new a();
        this.aboveThresholdConfig = new a();
        this.switchActionConfig = new c();
        this.deviceConfig = new b();
    }

    public final a a() {
        return this.aboveThresholdConfig;
    }

    public final a b() {
        return this.belowThresholdConfig;
    }

    public final int c() {
        return this.columnThreshold;
    }

    public final b d() {
        return this.deviceConfig;
    }

    public final boolean e() {
        return this.openUpdateJsOpt;
    }

    public final c f() {
        return this.switchActionConfig;
    }
}
