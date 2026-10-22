package qt9;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import com.vivo.push.PushClientConstants;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0015\u001a\u00020\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0013\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0003J=\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/larus/settings/provider/DTraceConfig;", "", "enableDTrace", "", "guardReportType", "", "updateVersionCode", "", "dynamicTraceConfigs", "", "Lcom/larus/settings/provider/DynamicTraceConfig;", "<init>", "(ZILjava/lang/String;Ljava/util/List;)V", "getEnableDTrace", "()Z", "getGuardReportType", "()I", "getUpdateVersionCode", "()Ljava/lang/String;", "getDynamicTraceConfigs", "()Ljava/util/List;", "getTraceConfig", "Lcom/google/gson/JsonArray;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class m0 {

    @SerializedName("dynamic_trace_configs")
    private final List<t0> dynamicTraceConfigs;

    @SerializedName("enable_dtrace")
    private final boolean enableDTrace;

    @SerializedName("guard_report_type")
    private final int guardReportType;

    @SerializedName("update_version_code")
    private final String updateVersionCode;

    public m0() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m0) == true) goto L8;
        return false;
    L8:
        m0 r101 = (m0) r100;
        if (this.enableDTrace == r101.enableDTrace) goto L12;
        return false;
    L12:
        if (this.guardReportType == r101.guardReportType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.updateVersionCode, r101.updateVersionCode) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.dynamicTraceConfigs, r101.dynamicTraceConfigs) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.enableDTrace == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.guardReportType) * 31;
        String r102 = this.updateVersionCode;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        List<t0> r106 = this.dynamicTraceConfigs;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "DTraceConfig(enableDTrace=" + this.enableDTrace + ", guardReportType=" + this.guardReportType + ", updateVersionCode=" + this.updateVersionCode + ", dynamicTraceConfigs=" + this.dynamicTraceConfigs + ')';
    }

    public final JsonArray b() {
        JsonArray r100 = new JsonArray();
        List<t0> r101 = this.dynamicTraceConfigs;     // Catch: Throwable -> L24
        if (r101 == null) goto L23;
        Iterator<T> r102 = r101.iterator();     // Catch: Throwable -> L24
    L6:
        if (r102.hasNext() == false) goto L23;
        t0 r103 = (t0) r102.next();     // Catch: Throwable -> L24
        if (r103 == null) goto L6;
        JsonObject r104 = new JsonObject();     // Catch: Throwable -> L24
        r104.addProperty("action", Integer.valueOf(r103.a()));     // Catch: Throwable -> L24
        r104.addProperty(PushClientConstants.TAG_CLASS_NAME, r103.b());     // Catch: Throwable -> L24
        r104.addProperty("isConstructor", Boolean.valueOf(r103.g()));     // Catch: Throwable -> L24
        r104.addProperty("methodName", r103.d());     // Catch: Throwable -> L24
        r104.addProperty("methodSign", r103.e());     // Catch: Throwable -> L24
        r104.addProperty("traceThreadMode", Integer.valueOf(r103.f()));     // Catch: Throwable -> L24
        if (r103.c() != null) goto L13;
    L21:
        r100.add(r104);     // Catch: Throwable -> L24
        goto L6
    L13:
        if ((!r103.c().isEmpty()) == false) goto L21;
        JsonObject r105 = new JsonObject();     // Catch: Throwable -> L24
        Iterator<Map.Entry<String, Object>> r106 = r103.c().entrySet().iterator();     // Catch: Throwable -> L24
    L16:
        if (r106.hasNext() == false) goto L19;
        Map.Entry<String, Object> r107 = r106.next();     // Catch: Throwable -> L24
        r105.addProperty(r107.getKey(), String.valueOf(r107.getValue()));     // Catch: Throwable -> L24
        goto L16
    L19:
        if (r105.size() <= 0) goto L21;
        r104.add(ControlRule.KEY_EXTRA_DATA, r105);     // Catch: Throwable -> L24
    L23:
        return r100;
    }

    public final boolean a() {
        return this.enableDTrace;
    }

    public final String c() {
        return this.updateVersionCode;
    }

    public m0(Object r100) {
        List<t0> r101 = CollectionsKt.emptyList();
        this.enableDTrace = false;
        this.guardReportType = 0;
        this.updateVersionCode = "";
        this.dynamicTraceConfigs = r101;
    }
}
