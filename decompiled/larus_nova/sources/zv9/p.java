package zv9;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b+\b\u0086\b\u0018\u00002\u00020\u0001BÕ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0012<\b\u0002\u0010\u000f\u001a6\u0012\u0004\u0012\u00020\r\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0018\u00010\u0010j\u001a\u0012\u0004\u0012\u00020\r\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0018\u0001`\u0011\u0012\u0012\b\u0002\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010-\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0013\u00102\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003J\u0013\u00103\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003J=\u00104\u001a6\u0012\u0004\u0012\u00020\r\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0018\u00010\u0010j\u001a\u0012\u0004\u0012\u00020\r\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0018\u0001`\u0011HÆ\u0003J\u0013\u00105\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003JÜ\u0001\u00106\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2<\b\u0002\u0010\u000f\u001a6\u0012\u0004\u0012\u00020\r\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0018\u00010\u0010j\u001a\u0012\u0004\u0012\u00020\r\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0018\u0001`\u00112\u0012\b\u0002\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u00107J\u0013\u00108\u001a\u00020\u00032\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\u0006HÖ\u0001J\t\u0010;\u001a\u00020\rHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001d\u0010\u001aR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001e\u0010\u001aR\u001a\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001f\u0010\u001aR(\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R(\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#RR\u0010\u000f\u001a6\u0012\u0004\u0012\u00020\r\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0018\u00010\u0010j\u001a\u0012\u0004\u0012\u00020\r\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0018\u0001`\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R \u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010!¨\u0006<"}, d2 = {"Lcom/larus/settings/provider/security/SecurityAuditConfig;", "", "enable", "", "enableMock", "initStage", "", "auditInitSampleRate", "auditRemoveSampleRate", "auditReportSampleRate", "auditPerfSampleRate", "auditHeaderReportList", "", "", "auditMockHeaderList", "auditHeaderFilterDetail", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "auditSkipList", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/HashMap;Ljava/util/List;)V", "getEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnableMock", "getInitStage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAuditInitSampleRate", "getAuditRemoveSampleRate", "getAuditReportSampleRate", "getAuditPerfSampleRate", "getAuditHeaderReportList", "()Ljava/util/List;", "setAuditHeaderReportList", "(Ljava/util/List;)V", "getAuditMockHeaderList", "setAuditMockHeaderList", "getAuditHeaderFilterDetail", "()Ljava/util/HashMap;", "setAuditHeaderFilterDetail", "(Ljava/util/HashMap;)V", "getAuditSkipList", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/HashMap;Ljava/util/List;)Lcom/larus/settings/provider/security/SecurityAuditConfig;", "equals", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class p {

    @SerializedName("audit_header_filter_detail")
    private HashMap<String, List<String>> auditHeaderFilterDetail;

    @SerializedName("audit_header_report_list")
    private List<String> auditHeaderReportList;

    @SerializedName("audit_init_sample_rate")
    private final Integer auditInitSampleRate;

    @SerializedName("audit_mock_list")
    private List<String> auditMockHeaderList;

    @SerializedName("audit_perf_sample_rate")
    private final Integer auditPerfSampleRate;

    @SerializedName("audit_remove_sample_rate")
    private final Integer auditRemoveSampleRate;

    @SerializedName("audit_report_sample_rate")
    private final Integer auditReportSampleRate;

    @SerializedName("audit_skip_list")
    private final List<String> auditSkipList;

    @SerializedName("enable")
    private final Boolean enable;

    @SerializedName("enable_audit_mock")
    private final Boolean enableMock;

    @SerializedName("init_stage")
    private final Integer initStage;

    public p() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.enable, r101.enable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enableMock, r101.enableMock) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.initStage, r101.initStage) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.auditInitSampleRate, r101.auditInitSampleRate) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.auditRemoveSampleRate, r101.auditRemoveSampleRate) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.auditReportSampleRate, r101.auditReportSampleRate) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.auditPerfSampleRate, r101.auditPerfSampleRate) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.auditHeaderReportList, r101.auditHeaderReportList) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.auditMockHeaderList, r101.auditMockHeaderList) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.auditHeaderFilterDetail, r101.auditHeaderFilterDetail) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.auditSkipList, r101.auditSkipList) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.enable;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.enableMock;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.initStage;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.auditInitSampleRate;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.auditRemoveSampleRate;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.auditReportSampleRate;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.auditPerfSampleRate;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        List<String> r122 = this.auditHeaderReportList;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        List<String> r125 = this.auditMockHeaderList;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        HashMap<String, List<String>> r128 = this.auditHeaderFilterDetail;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        List<String> r131 = this.auditSkipList;
        if (r131 == null) goto L47;
        r101 = r131.hashCode();
    L47:
        return r130 + r101;
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
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
        return "SecurityAuditConfig(enable=" + this.enable + ", enableMock=" + this.enableMock + ", initStage=" + this.initStage + ", auditInitSampleRate=" + this.auditInitSampleRate + ", auditRemoveSampleRate=" + this.auditRemoveSampleRate + ", auditReportSampleRate=" + this.auditReportSampleRate + ", auditPerfSampleRate=" + this.auditPerfSampleRate + ", auditHeaderReportList=" + this.auditHeaderReportList + ", auditMockHeaderList=" + this.auditMockHeaderList + ", auditHeaderFilterDetail=" + this.auditHeaderFilterDetail + ", auditSkipList=" + this.auditSkipList + ')';
    }

    public final HashMap<String, List<String>> a() {
        return this.auditHeaderFilterDetail;
    }

    public final List<String> b() {
        return this.auditHeaderReportList;
    }

    public final Integer c() {
        return this.auditInitSampleRate;
    }

    public final List<String> d() {
        return this.auditMockHeaderList;
    }

    public final Integer e() {
        return this.auditPerfSampleRate;
    }

    public final Integer f() {
        return this.auditRemoveSampleRate;
    }

    public final Integer g() {
        return this.auditReportSampleRate;
    }

    public final List<String> h() {
        return this.auditSkipList;
    }

    public final Boolean i() {
        return this.enable;
    }

    public final Boolean j() {
        return this.enableMock;
    }

    public final Integer k() {
        return this.initStage;
    }

    public p(Object r110) {
        Boolean r111 = Boolean.FALSE;
        List<String> r100 = CollectionsKt.emptyList();
        List<String> r101 = CollectionsKt.emptyList();
        HashMap<String, List<String>> r102 = new HashMap();
        List<String> r103 = CollectionsKt.emptyList();
        this.enable = r111;
        this.enableMock = r111;
        this.initStage = 0;
        this.auditInitSampleRate = 0;
        this.auditRemoveSampleRate = 0;
        this.auditReportSampleRate = 0;
        this.auditPerfSampleRate = 0;
        this.auditHeaderReportList = r100;
        this.auditMockHeaderList = r101;
        this.auditHeaderFilterDetail = r102;
        this.auditSkipList = r103;
    }
}
