package jq;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001eR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001b¨\u0006\u001f"}, d2 = {"Ljq/a;", "", "", "eventName", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "btmId", "e", "adLabel", "b", "id", "h", "", "allowDuplicate", "Z", "c", "()Z", "", "params", "Ljava/util/Map;", RXScreenCaptureService.KEY_INDEX, "()Ljava/util/Map;", "", "bstReportType", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "standard", ce.f26395j, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f500015a = 0;

    @SerializedName("ad_label")
    private final String adLabel;

    @SerializedName("allow_duplicate")
    private final boolean allowDuplicate;

    @SerializedName("bst_report_type")
    private final Integer bstReportType;

    @SerializedName("btm_id")
    private final String btmId;

    @SerializedName(ReportCardMonitorPlugin.EVENT_NAME)
    private final String eventName;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f500016id;

    @SerializedName("params")
    private final Map<String, String> params;

    @SerializedName("standard")
    private final Integer standard;

    /* JADX INFO: renamed from: jq.a$a, reason: collision with other inner class name */
    public static final class C6473a {
        public static a a(Map r110) {
            Integer r100 = null;
            if (r110 != null) goto L5;
            return null;
        L5:
            Intrinsics.checkNotNullParameter(r110, "data");
            String r101 = mq.b.d(r110, ReportCardMonitorPlugin.EVENT_NAME, null);
            String r102 = mq.b.d(r110, "btm_id", null);
            String r103 = mq.b.d(r110, "ad_label", null);
            String r104 = mq.b.d(r110, "id", null);
            boolean r105 = mq.b.c(r110, "allow_duplicate", true);
            Intrinsics.checkNotNullParameter(r110, "$this$getStringMap");
            Intrinsics.checkNotNullParameter("params", "key");
            Object r106 = r110.get("params");
            if ((r106 instanceof Map) == true) goto L8;
            r106 = null;
        L8:
            Map r107 = (Map) r106;
            Object r108 = r110.get("bst_report_type");
            if (r108 == null) goto L11;
            Integer r109 = Integer.valueOf(mq.b.b(r108, 0));
        L12:
            Object r111 = r110.get("standard");
            if (r111 == null) goto L16;
            r100 = Integer.valueOf(mq.b.b(r111, 0));
        L16:
            return new a(r101, r102, r103, r104, r105, r107, r109, r100);
        L11:
            r109 = null;
            goto L12
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L22;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.eventName, r101.eventName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.btmId, r101.btmId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.adLabel, r101.adLabel) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f500016id, r101.f500016id) == true) goto L14;
        return false;
    L14:
        if (this.allowDuplicate == r101.allowDuplicate) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bstReportType, r101.bstReportType) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.standard, r101.standard) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v24 */
    public final int hashCode() {
        String r100 = this.eventName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.btmId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.adLabel;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f500016id;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.allowDuplicate;
        ?? r114 = r113;
        if (r113 == false) goto L21;
        r114 = 1;
    L21:
        int r115 = (r112 + r114) * 31;
        Map<String, String> r116 = this.params;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.bstReportType;
        if (r119 == null) goto L28;
        int r120 = r119.hashCode();
    L29:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.standard;
        if (r122 == null) goto L33;
        r101 = r122.hashCode();
    L33:
        return r121 + r101;
    L28:
        r120 = 0;
        goto L29
    L24:
        r117 = 0;
        goto L25
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LogData(eventName=" + this.eventName + ", btmId=" + this.btmId + ", adLabel=" + this.adLabel + ", id=" + this.f500016id + ", allowDuplicate=" + this.allowDuplicate + ", params=" + this.params + ", bstReportType=" + this.bstReportType + ", standard=" + this.standard + ")";
    }

    public final String g() {
        String r100 = this.eventName;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String b() {
        return this.adLabel;
    }

    public final boolean c() {
        return this.allowDuplicate;
    }

    public final Integer d() {
        return this.bstReportType;
    }

    public final String e() {
        return this.btmId;
    }

    public final String f() {
        return this.eventName;
    }

    public final String h() {
        return this.f500016id;
    }

    public final Map<String, String> i() {
        return this.params;
    }

    public final Integer j() {
        return this.standard;
    }

    public /* synthetic */ a(String r110, Map r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r112 & 16) == 0) goto L9;
        boolean r101 = true;
    L11:
        if ((r112 & 32) == 0) goto L13;
        Map r102 = null;
    L14:
        this(r100, null, null, null, r101, r102, null, null);
        return;
    L13:
        r102 = r111;
        goto L14
    L9:
        r101 = false;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public static a a(a r100, String r110, String r111) {
        String r101 = r100.btmId;
        String r102 = r100.adLabel;
        boolean r103 = r100.allowDuplicate;
        Map<String, String> r104 = r100.params;
        Integer r105 = r100.bstReportType;
        Integer r106 = r100.standard;
        r100.getClass();
        return new a(r110, r101, r102, r111, r103, r104, r105, r106);
    }

    public a(String r100, String r101, String r102, String r103, boolean r104, Map<String, String> r105, Integer r106, Integer r107) {
        this.eventName = r100;
        this.btmId = r101;
        this.adLabel = r102;
        this.f500016id = r103;
        this.allowDuplicate = r104;
        this.params = r105;
        this.bstReportType = r106;
        this.standard = r107;
    }
}
