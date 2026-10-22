package jq7;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import oq7.c;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final oq7.b f500072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f500073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Uri f500074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f500075d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f500076e;

    public b(oq7.b r100) {
        this.f500072a = r100;
    }

    public final void a(String r100, int r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.startsWith("http") == true) goto L7;
        return;
    L7:
        if (r100.equals(this.f500073b) == true) goto L83;
        this.f500073b = r100;
        Uri r102 = UriProtector.parse(r100);     // Catch: Exception -> L59
        this.f500074c = r102;     // Catch: Exception -> L59
        HashSet<a.b> r103 = ((oq7.a) this.f500072a).f524889a.f495400f;
        if (r103 != null) goto L61;
    L20:
        String r104 = UriProtector.getQueryParameter(this.f500074c, "bdwk_extension");
        if (r101 != 0) goto L30;
        List<a.C6475a> r105 = a.a(0, r104);
        if (this.f500075d != null) goto L25;
        this.f500075d = new a();
    L25:
        Iterator r106 = ((ArrayList) r105).iterator();
    L27:
        if (r106.hasNext() == false) goto L30;
        a.C6475a r107 = (a.C6475a) r106.next();
        Map<String, a.C6475a> r108 = this.f500075d.f500068a;
        HashMap r109 = (HashMap) r108;
        r109.put(r107.f500069a, r107);
    L30:
        if (this.f500075d != null) goto L33;
        kq7.a.a("AddressProcessor");
        return;
    L33:
        List<a.C6475a> r110 = a.a(1, r104);
        a r111 = this.f500076e;
        if (r111 != null) goto L36;
        this.f500076e = new a();
    L37:
        Iterator r112 = ((ArrayList) r110).iterator();
    L39:
        if (r112.hasNext() == false) goto L41;
        a.C6475a r113 = (a.C6475a) r112.next();
        Map<String, a.C6475a> r114 = this.f500076e.f500068a;
        HashMap r115 = (HashMap) r114;
        r115.put(r113.f500069a, r113);
        goto L39
    L41:
        a r116 = this.f500076e;
        a r117 = this.f500075d;
        r116.getClass();
        Iterator r118 = ((HashMap) r117.f500068a).entrySet().iterator();
    L43:
        if (r118.hasNext() == false) goto L47;
        Map.Entry r119 = (Map.Entry) r118.next();
        Map<String, a.C6475a> r120 = r116.f500068a;
        HashMap r121 = (HashMap) r120;
        if (r121.containsKey(r119.getKey()) == true) goto L43;
        Map<String, a.C6475a> r122 = r116.f500068a;
        HashMap r123 = (HashMap) r122;
        r123.put((String) r119.getKey(), (a.C6475a) r119.getValue());
        goto L43
    L47:
        a r124 = this.f500076e;
        if (r124 != null) goto L50;
        return;
    L50:
        if (((HashMap) r124.f500068a).isEmpty() == true) goto L79;
        Iterator<c> r125 = ((oq7.a) this.f500072a).f524891c.iterator();
    L54:
        if (r125.hasNext() == false) goto L80;
        c r126 = r125.next();
        if ((r126 instanceof iq7.a) == false) goto L54;
        ((iq7.a) r126).getClass();
        goto L54
    L80:
        return;
    L79:
        return;
    L36:
        ((HashMap) r111.f500068a).clear();
        goto L37
    L61:
        Iterator<a.b> r127 = r103.iterator();     // Catch: Exception -> L19
    L16:
        if (r127.hasNext() == false) goto L20;
        r127.next().a(r102);     // Catch: Exception -> L19
    L19:
        kq7.a.a("AddressParam");
    L59:
        kq7.a.a("AddressProcessor");
        return;
    }
}
