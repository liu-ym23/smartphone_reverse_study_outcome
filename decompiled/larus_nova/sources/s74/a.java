package s74;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import p74.b;
import q74.c;
import q74.d;
import q74.e;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<p74.a> f540924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f540925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v74.a f540926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f540927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f540928e;

    public abstract List<String> b();

    public abstract String c();

    public final void a(Map<String, JSONObject> r100) {
        Iterator<Map.Entry<String, JSONObject>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L45;
        Map.Entry<String, JSONObject> r102 = r101.next();
        String r103 = r102.getKey();
        if (b().contains(r102.getKey()) == false) goto L4;
        switch(r103.hashCode()) {
            case 3073450: goto L25;
            case 3073481: goto L22;
            case 3073698: goto L19;
            case 3073822: goto L16;
            case 3073977: goto L13;
            default: goto L27;
        };     // Catch: Exception -> L43
    L27:
        byte r104 = -1;
    L28:
        if (r104 == 0) goto L38;
        if (r104 == 1) goto L37;
        if (r104 == 2) goto L36;
        if (r104 == 3) goto L35;
        if (r104 == 4) goto L34;
        p74.a r105 = null;
    L40:
        if (r105 == null) goto L4;
        ((ArrayList) this.f540924a).add(r105);     // Catch: Exception -> L43
        goto L4
    L34:
        p74.a r106 = new d(r102.getValue());     // Catch: Exception -> L43
    L39:
        r105 = r106;
        goto L40
    L35:
        r106 = new c(r102.getValue());     // Catch: Exception -> L43
        goto L39
    L36:
        r106 = new e(r102.getValue());     // Catch: Exception -> L43
        goto L39
    L37:
        r106 = new q74.b(r102.getValue());     // Catch: Exception -> L43
        goto L39
    L38:
        r106 = new q74.a(r102.getValue());     // Catch: Exception -> L43
        goto L39
    L13:
        if (r103.equals("d_r0") == false) goto L27;
        r104 = 2;
        goto L28
    L16:
        if (r103.equals("d_m0") == false) goto L27;
        r104 = 4;
        goto L28
    L19:
        if (r103.equals("d_i0") == false) goto L27;
        r104 = 3;
        goto L28
    L22:
        if (r103.equals("d_b0") == false) goto L27;
        r104 = 1;
        goto L28
    L25:
        if (r103.equals("d_a0") == false) goto L27;
        r104 = 0;
    L43:
        e = move-exception;
        m74.a.b("[dt] " + c() + "addLoader# error " + e.getMessage());
        goto L4
    }

    public a(Context r100, b r101, v74.a r102, boolean r103) {
        this.f540927d = r101;
        this.f540926c = r102;
        this.f540925b = r100;
        this.f540924a = new ArrayList();
        this.f540928e = r103;
    }
}
