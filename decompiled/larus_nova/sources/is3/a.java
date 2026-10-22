package is3;

import com.optimize.statistics.FrescoMonitorConst;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends hs3.a<hs3.c> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile a f495590h;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f495591g;

    public static a h() {
        if (f495590h != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f495590h != null) goto L9;
        f495590h = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f495590h;
    }

    public a() {
    }

    @Override // hs3.a
    public final void c(hs3.c r100) {
        JSONObject r101 = r100.a();
        boolean r102 = r100.c(r101);
        if (com.bytedance.apm.d.j() == true) goto L21;
    L9:
        if (r102 == false) goto L11;
    L13:
        g(r100.d(), r100.e(), r101, r102, false);
        b r103 = this.f495591g;
        if (r103 == null) goto L23;
        r100.d();
        String r104 = r100.e();
        ws3.b r105 = (ws3.b) r103;
        if (r105.f560947a.f560952a == true) goto L18;
        return;
    L18:
        if (FrescoMonitorConst.MONITOR_IMAGE_V2.equals(r104) == false) goto L25;
        r105.f560947a.getClass();
        return;
    L25:
        return;
    L23:
        return;
    L11:
        if (r100.b() == true) goto L13;
        return;
    L21:
        ps3.b.b(new Object[]{"logType: " + r100.d() + ", subType: " + r100.e() + "data: " + r101, " ,sample: " + r102});     // Catch: Exception -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }
}
