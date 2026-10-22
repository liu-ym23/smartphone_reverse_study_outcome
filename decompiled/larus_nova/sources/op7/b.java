package op7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qp7.e;
import qp7.g;
import qp7.h;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements qp7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public qp7.d f524730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d> f524731b;

    public b() {
        this.f524731b = new ArrayList();
    }

    public final void b(h r100) throws JSONException {
        JSONArray r101 = new JSONArray();
        List<d> r102 = this.f524731b;
        monitor-enter(r102);
        int r103 = 0;
    L14:
    L11:
        th = move-exception;
        throw th;
    L6:
        if (r103 >= ((ArrayList) this.f524731b).size()) goto L8;
        d r104 = (d) ((ArrayList) this.f524731b).get(r103);     // Catch: Throwable -> L11
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L11
        r105.put("type", "page");     // Catch: Throwable -> L11
        r105.put("title", r104.f524734b);     // Catch: Throwable -> L11
        r105.put("id", "" + r103);     // Catch: Throwable -> L11
        r105.put("description", "");     // Catch: Throwable -> L11
        r105.put("webSocketDebuggerUrl", "ws://" + r104.f524736d);     // Catch: Throwable -> L11
        r105.put("devtoolsFrontendUrl", "/devtools/inspector.html?ws=" + r104.f524736d);     // Catch: Throwable -> L11
        r101.put(r105);     // Catch: Throwable -> L11
        r103 = r103 + 1;     // Catch: Throwable -> L11
        goto L14
    L8:
        monitor-exit(r102);     // Catch: Throwable -> L11
        qp7.d r106 = e.a(r101.toString(), "application/json");
        r100.f534357c = 200;
        r100.f534358d = "OK";
        r100.f534359e = r106;
    }

    public final void c(h r100) throws JSONException {
        if (this.f524730a != null) goto L16;
        JSONObject r101 = new JSONObject();
        r101.put("Browser", "VMSDK-Debugger");
        r101.put("Protocol-Version", "1.3");
        monitor-enter(xp7.a.class);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (xp7.a.f564736c == true) goto L10;
        xp7.a.f564736c = true;     // Catch: Throwable -> L13
        xp7.a.f564735b = xp7.a.a();     // Catch: IOException -> L18 Throwable -> L13
    L10:
        String r102 = xp7.a.f564735b;     // Catch: Throwable -> L13
        monitor-exit(xp7.a.class);
        r101.put("Android-Package", r102);
        r101.put("V8-Version", "7.2.1");
        this.f524730a = e.a(r101.toString(), "application/json");
    L16:
        qp7.d r103 = this.f524730a;
        r100.f534357c = 200;
        r100.f534358d = "OK";
        r100.f534359e = r103;
    }

    @Override // qp7.c
    public final boolean a(pp7.e r100, g r101, h r102) throws IOException {
        String r103 = r101.f534356c.getPath();
    L14:
        e = move-exception;
        r102.f534357c = 500;
        r102.f534358d = "Internal server error";
        r102.f534359e = e.a(e.toString() + "\n", "text/plain");
        return true;
    L4:
        if ("/json/version".equals(r103) == false) goto L7;
        c(r102);     // Catch: JSONException -> L14
    L18:
        return true;
    L7:
        if ("/json".equals(r103) == false) goto L10;
        b(r102);     // Catch: JSONException -> L14
        goto L18
    L10:
        if ("/json/list".equals(r103) == false) goto L12;
        b(r102);     // Catch: JSONException -> L14
        goto L18
    L12:
        r102.f534357c = 501;     // Catch: JSONException -> L14
        r102.f534358d = "Not implemented";     // Catch: JSONException -> L14
        r102.f534359e = e.a("No support for " + r103 + "\n", "text/plain");     // Catch: JSONException -> L14
        goto L18
    }
}
