package com.ss.android.ugc.route_monitor.impl.route_in.config;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import ihc.b;
import ihc.c;
import ihc.e;
import ihc.q;
import ihc.s;
import ihc.t;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR%\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/ss/android/ugc/route_monitor/impl/route_in/config/RouteMonitorModeData;", "", "Lihc/c;", "getRouteMonitorMode", "", "toString", "modeName", "Ljava/lang/String;", "getModeName", "()Ljava/lang/String;", "", "modeData", "Ljava/util/Map;", "getModeData", "()Ljava/util/Map;", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "route-monitor_release"}, k = 1, mv = {1, 4, 0})
public final class RouteMonitorModeData {
    private final Map<String, String> modeData;
    private final String modeName;

    public final c getRouteMonitorMode() {
        String r100 = this.modeName;
        if (r100 == null) goto L41;
        int r101 = 1;
        switch(r100.hashCode()) {
            case -1762350171: goto L39;
            case -1287120073: goto L36;
            case -769328550: goto L27;
            case 653124271: goto L18;
            case 2098117939: goto L9;
            default: goto L41;
        };
    L9:
        if (r100.equals("AtLeastPageCountMonitorMode") == false) goto L41;
        Map<String, String> r102 = this.modeData;     // Catch: Throwable -> L43
        if (r102 == null) goto L49;
        String r103 = r102.get("minPageCount");     // Catch: Throwable -> L43
        if (r103 == null) goto L49;
        r101 = CastIntegerProtector.parseInt(r103);     // Catch: Throwable -> L43
    L49:
        return new b(r101);
    L18:
        if (r100.equals("SpecificPageCountMonitorMode") == false) goto L41;
        Map<String, String> r104 = this.modeData;     // Catch: Throwable -> L44
        if (r104 == null) goto L50;
        String r105 = r104.get("pageCount");     // Catch: Throwable -> L44
        if (r105 == null) goto L50;
        r101 = CastIntegerProtector.parseInt(r105);     // Catch: Throwable -> L44
    L50:
        return new t(r101);
    L27:
        if (r100.equals("SpecificDestPageMonitorMode") == false) goto L41;
        Map<String, String> r106 = this.modeData;
        if (r106 == null) goto L33;
        String r107 = r106.get("destPageClassName");
        if (r107 == null) goto L33;
    L51:
        return new s(r107);
    L33:
        r107 = "";
        goto L51
    L36:
        if (r100.equals("DeeplinkMonitorMode") == false) goto L41;
        return e.f489937b;
    L39:
        if (r100.equals("NoneMonitorMode") == false) goto L41;
        return q.f489956b;
    L41:
        return null;
    }

    public String toString() {
        return "{modeName = " + this.modeName + ", modeData = " + this.modeData + '}';
    }

    public final Map<String, String> getModeData() {
        return this.modeData;
    }

    public final String getModeName() {
        return this.modeName;
    }

    public RouteMonitorModeData(String r100, Map<String, String> r101) {
        this.modeName = r100;
        this.modeData = r101;
    }
}
