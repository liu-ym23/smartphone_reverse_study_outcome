package hr9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b)\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003JY\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0005HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011¨\u00060"}, d2 = {"Lcom/larus/platform/model/security/SecurityAEnvReport;", "", "enabled", "", "version", "", "report_interval", "min_report_interval", "collect_android_id", "collect_iccid", "collect_imei", "collect_mac", "<init>", "(ZIIIZZZZ)V", "getEnabled", "()Z", "setEnabled", "(Z)V", "getVersion", "()I", "setVersion", "(I)V", "getReport_interval", "setReport_interval", "getMin_report_interval", "setMin_report_interval", "getCollect_android_id", "setCollect_android_id", "getCollect_iccid", "setCollect_iccid", "getCollect_imei", "setCollect_imei", "getCollect_mac", "setCollect_mac", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName("collect_android_id")
    private boolean collect_android_id;

    @SerializedName("collect_iccid")
    private boolean collect_iccid;

    @SerializedName("collect_imei")
    private boolean collect_imei;

    @SerializedName("collect_mac")
    private boolean collect_mac;

    @SerializedName("enabled")
    private boolean enabled;

    @SerializedName("min_report_interval")
    private int min_report_interval;

    @SerializedName("report_interval")
    private int report_interval;

    @SerializedName("version")
    private int version;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.enabled == r101.enabled) goto L12;
        return false;
    L12:
        if (this.version == r101.version) goto L15;
        return false;
    L15:
        if (this.report_interval == r101.report_interval) goto L18;
        return false;
    L18:
        if (this.min_report_interval == r101.min_report_interval) goto L21;
        return false;
    L21:
        if (this.collect_android_id == r101.collect_android_id) goto L24;
        return false;
    L24:
        if (this.collect_iccid == r101.collect_iccid) goto L27;
        return false;
    L27:
        if (this.collect_imei == r101.collect_imei) goto L30;
        return false;
    L30:
        if (this.collect_mac == r101.collect_mac) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enabled == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((((r101 * 31) + this.version) * 31) + this.report_interval) * 31) + this.min_report_interval) * 31;
        if (this.collect_android_id == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.collect_iccid == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.collect_imei == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.collect_mac == true) goto L23;
        r100 = 1237;
    L23:
        return r108 + r100;
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "SecurityAEnvReport(enabled=" + this.enabled + ", version=" + this.version + ", report_interval=" + this.report_interval + ", min_report_interval=" + this.min_report_interval + ", collect_android_id=" + this.collect_android_id + ", collect_iccid=" + this.collect_iccid + ", collect_imei=" + this.collect_imei + ", collect_mac=" + this.collect_mac + ')';
    }

    public final boolean a() {
        return this.collect_android_id;
    }

    public final boolean b() {
        return this.collect_iccid;
    }

    public final boolean c() {
        return this.collect_imei;
    }

    public final boolean d() {
        return this.collect_mac;
    }

    public final boolean e() {
        return this.enabled;
    }

    public final int f() {
        return this.min_report_interval;
    }

    public final int g() {
        return this.report_interval;
    }

    public final int h() {
        return this.version;
    }

    public d(int r100) {
        this.enabled = true;
        this.version = 0;
        this.report_interval = 24;
        this.min_report_interval = 28800;
        this.collect_android_id = false;
        this.collect_iccid = false;
        this.collect_imei = false;
        this.collect_mac = false;
    }
}
