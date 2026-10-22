package cyb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/opmonitor/config/TraceFilter;", "Lcom/ss/android/lark/opmonitor/config/IMonitorFilter;", "<init>", "()V", "monitorDomain", "", "", "monitorDomainPrefix", "monitorId", "eventName", "filter", "", "monitor", "Lcom/ss/android/lark/opmonitor/service/OPMonitor;", "opmonitor_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {

    @SerializedName(ReportCardMonitorPlugin.EVENT_NAME)
    @Expose
    private final List<String> eventName;

    @SerializedName(ReportCardMonitorPlugin.MONITOR_DOMAIN)
    @Expose
    private final List<String> monitorDomain;

    @SerializedName("monitor_domain_prefix")
    @Expose
    private final List<String> monitorDomainPrefix;

    @SerializedName("monitor_id")
    @Expose
    private final List<String> monitorId;

    public e() {
        this.monitorDomain = CollectionsKt.emptyList();
        this.monitorDomainPrefix = CollectionsKt.emptyList();
        this.monitorId = CollectionsKt.emptyList();
        this.eventName = CollectionsKt.emptyList();
    }

    public final boolean a(OPMonitor r100) {
        Intrinsics.checkNotNullParameter(r100, "monitor");
        OPMonitorCode r101 = r100.getMonitorCode();
        if (r101 == null) goto L22;
        Iterator<T> r102 = this.monitorDomain.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        String r103 = (String) r102.next();
        if (Intrinsics.areEqual(r101.domain, r103) == false) goto L6;
        return true;
    L10:
        Iterator<T> r104 = this.monitorDomainPrefix.iterator();
    L12:
        if (r104.hasNext() == false) goto L16;
        String r105 = (String) r104.next();
        if (StringsKt.startsWith$default(r101.domain, r105, false, 2, null) == false) goto L12;
        return true;
    L16:
        Iterator<T> r106 = this.monitorId.iterator();
    L18:
        if (r106.hasNext() == false) goto L22;
        String r107 = (String) r106.next();
        if (StringsKt.contains$default(r101.ID, r107, false, 2, null) == false) goto L18;
        return true;
    L22:
        String r108 = r100.getName();
        if (r108 == null) goto L30;
        Iterator<T> r109 = this.eventName.iterator();
    L26:
        if (r109.hasNext() == false) goto L30;
        if (Intrinsics.areEqual(r108, (String) r109.next()) == false) goto L26;
        return true;
    L30:
        return false;
    }
}
