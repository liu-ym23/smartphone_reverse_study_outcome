package qt9;

import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0013\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bHÆ\u0003JQ\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J\t\u0010#\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/larus/settings/provider/XTraceConfig;", "", "enableXTrace", "", "enableXTraceLog", "enable32BitDevice", "guardReportType", "", "updateVersionCode", "", FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY, "", "Lcom/larus/settings/provider/XTraceMethodConfig;", "<init>", "(ZZZILjava/lang/String;Ljava/util/List;)V", "getEnableXTrace", "()Z", "getEnableXTraceLog", "getEnable32BitDevice", "getGuardReportType", "()I", "getUpdateVersionCode", "()Ljava/lang/String;", "getConfigs", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class z4 {

    @SerializedName(FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY)
    private final List<b5> configs;

    @SerializedName("enable_32bit_device")
    private final boolean enable32BitDevice;

    @SerializedName("enable_xtrace")
    private final boolean enableXTrace;

    @SerializedName("enable_xtrace_log")
    private final boolean enableXTraceLog;

    @SerializedName("guard_report_type")
    private final int guardReportType;

    @SerializedName("update_version_code")
    private final String updateVersionCode;

    public z4() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z4) == true) goto L8;
        return false;
    L8:
        z4 r101 = (z4) r100;
        if (this.enableXTrace == r101.enableXTrace) goto L12;
        return false;
    L12:
        if (this.enableXTraceLog == r101.enableXTraceLog) goto L15;
        return false;
    L15:
        if (this.enable32BitDevice == r101.enable32BitDevice) goto L18;
        return false;
    L18:
        if (this.guardReportType == r101.guardReportType) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.updateVersionCode, r101.updateVersionCode) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.configs, r101.configs) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enableXTrace == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableXTraceLog == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.enable32BitDevice == true) goto L14;
        r100 = 1237;
    L14:
        int r105 = (((r104 + r100) * 31) + this.guardReportType) * 31;
        String r106 = this.updateVersionCode;
        int r107 = 0;
        if (r106 != null) goto L17;
        int r108 = 0;
    L18:
        int r109 = (r105 + r108) * 31;
        List<b5> r110 = this.configs;
        if (r110 == null) goto L23;
        r107 = r110.hashCode();
    L23:
        return r109 + r107;
    L17:
        r108 = r106.hashCode();
        goto L18
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "XTraceConfig(enableXTrace=" + this.enableXTrace + ", enableXTraceLog=" + this.enableXTraceLog + ", enable32BitDevice=" + this.enable32BitDevice + ", guardReportType=" + this.guardReportType + ", updateVersionCode=" + this.updateVersionCode + ", configs=" + this.configs + ')';
    }

    public final List<b5> a() {
        return this.configs;
    }

    public final boolean b() {
        return this.enable32BitDevice;
    }

    public final boolean c() {
        return this.enableXTrace;
    }

    public final boolean d() {
        return this.enableXTraceLog;
    }

    public final int e() {
        return this.guardReportType;
    }

    public final String f() {
        return this.updateVersionCode;
    }

    public z4(Object r100) {
        List<b5> r101 = CollectionsKt.emptyList();
        this.enableXTrace = false;
        this.enableXTraceLog = false;
        this.enable32BitDevice = true;
        this.guardReportType = 0;
        this.updateVersionCode = "";
        this.configs = r101;
    }
}
