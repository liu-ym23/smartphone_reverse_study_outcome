package fyb;

import androidx.camera.video.AudioStats;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import java.util.HashMap;

/* JADX INFO: loaded from: classes37.dex */
public final class e extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f479342b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public dyb.a f479343a;

    static {
        f479342b = new e();
    }

    public e() {
    }

    public e(dyb.a r100) {
        this.f479343a = r100;
    }

    @Override // byb.e
    public final void flush(OPMonitor r110) {
        if (this.f479343a != null) goto L6;
        return;
    L6:
        if (r110.getLevel() != OPMonitorLevel.TRACE) goto L8;
        return;
    L8:
        String r100 = getEventName(r110, this.f479343a);
        if (r110.getReportPlatform() != 0) goto L11;
        this.f479343a.getClass();
        r110.reportPlatform(2);
    L11:
        dyb.a r101 = this.f479343a;
        HashMap<String, Object> r102 = r110.getMetrics();
        HashMap<String, Object> r103 = r110.getCategories();
        r110.getReportPlatform();
        r101.getClass();
        cyb.c r111 = dyb.a.f470557c;
        HashMap r104 = new HashMap();
        r104.put(ReportCardMonitorPlugin.EVENT_NAME, r100);
        r104.putAll(r102);
        r104.putAll(r103);
        monitor-enter(r111);
        Object r105 = r104.get("monitor_level");     // Catch: Throwable -> L48
        if ((r105 instanceof OPMonitorLevel) == false) goto L17;
        OPMonitorLevel r106 = (OPMonitorLevel) r105;     // Catch: Throwable -> L48
    L21:
        if (r106 == null) goto L34;
        int r107 = cyb.c.a.f465990a[r106.ordinal()];     // Catch: Throwable -> L48
        if (r107 == 1) goto L34;
        if (r107 == 2) goto L34;
        if (r107 == 3) goto L34;
        if (r107 == 4) goto L34;
        if (r107 != 5) goto L34;
        double r108 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L36:
        if (r108 < 1.0d) goto L38;
        float r109 = 1.0f;
    L39:
        monitor-exit(r111);
        if (r109 == 0.0f) goto L54;
        byb.d r112 = r101.f470558a;
        if ((r112 instanceof byb.b) == false) goto L46;
        ((byb.b) r112).getClass();
        byb.b.b(r102, r103);
        return;
    L46:
        r112.a(r100, r102, r103);
        return;
    L54:
        return;
    L38:
        r109 = 0.0f;
    L34:
        r108 = 1.0d;
        goto L36
    L17:
        if ((r105 instanceof Integer) == false) goto L19;
        r106 = OPMonitorLevel.forNumber(((Integer) r105).intValue());     // Catch: Throwable -> L48
        goto L21
    L19:
        r106 = null;
    L48:
        th = move-exception;
        throw th;
    }

    @Override // byb.e
    public final void log(OPMonitor r100) {
        log(r100, this.f479343a);
    }
}
