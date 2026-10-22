package ak5;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x implements l {
    public static String j;
    public int a;
    public final String b;
    public final HashMap<String, String> c;
    public final HashMap<String, String> d;
    public final HashMap<String, String> e;
    public Map<String, List<String>> f;
    public Map<String, List<String>> g;
    public String h;
    public String i;

    @Override // ak5.l
    public final String a() {
        String r0 = this.h;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r2 = this.b;
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        if (r0.toLowerCase().startsWith("https://") == false) goto L12;
        r0 = r0.replaceFirst("https://", "");
    L12:
        if (r0.toLowerCase().startsWith("http://") == false) goto L14;
        r0 = r0.replaceFirst("http://", "");
        boolean r3 = true;
    L15:
        Uri.Builder r5 = new Uri.Builder();
        if (r3 == false) goto L18;
        Uri.Builder r4 = r5.scheme("http");
    L19:
        Uri.Builder r1 = r4.authority(r0);
        if (r2.contains("?") == false) goto L42;
        String r6 = this.h;
        if (r6 != null) goto L24;
        r6 = "";
    L24:
        String r7 = this.b;
        if (r7 != null) goto L28;
        r7 = "";
    L28:
        if (r6.endsWith("/") == true) goto L31;
        r6 = r6.concat("/");
    L31:
        if (r6.startsWith("http") == true) goto L34;
        r6 = "https://".concat(r6);
    L34:
        if (r7.startsWith("/") == false) goto L36;
        r7 = r7.replaceFirst("/", "");
    L36:
        Uri r8 = UriProtector.parse(r6 + r7);
        r1.path(r8.getPath());
        Set r9 = UriProtector.getQueryParameterNames(r8);
        if (r9 == null) goto L43;
        Iterator r10 = r9.iterator();
    L40:
        if (r10.hasNext() == false) goto L43;
        String r11 = (String) r10.next();
        r1.appendQueryParameter(r11, UriProtector.getQueryParameter(r8, r11));
    L43:
        Iterator<Map.Entry<String, String>> r12 = this.e.entrySet().iterator();
    L45:
        if (r12.hasNext() == false) goto L47;
        Map.Entry<String, String> r13 = r12.next();
        r1.appendQueryParameter(r13.getKey(), r13.getValue());
        goto L45
    L47:
        Map<String, List<String>> r14 = this.f;
        if (r14 == null) goto L63;
        if (r14.size() <= 0) goto L63;
        Iterator<Map.Entry<String, List<String>>> r15 = this.f.entrySet().iterator();
    L53:
        if (r15.hasNext() == false) goto L63;
        Map.Entry<String, List<String>> r16 = r15.next();
        List<String> r17 = r16.getValue();
        if (r17 == null) goto L53;
        if (r17.size() <= 0) goto L53;
        Iterator<String> r18 = r17.iterator();
    L60:
        if (r18.hasNext() == false) goto L53;
        r1.appendQueryParameter(r16.getKey(), r18.next());
    L63:
        return r1.build().toString();
    L42:
        r1.path(this.b);
        goto L43
    L18:
        r4 = r5.scheme("https");
        goto L19
    L14:
        r3 = false;
        goto L15
    }

    public final String toString() {
        return "SimpleNetRequest{requestMethod=" + this.a + ", mPath='" + this.b + "', mBodyParams=" + this.c + ", mHeaderParams=" + this.d + ", mUrlParams=" + this.e + ", mHost='" + this.h + "'}";
    }

    @Override // ak5.l
    public final Map<String, String> b() {
        return this.d;
    }

    @Override // ak5.l
    public final Map<String, List<String>> c() {
        return this.g;
    }

    @Override // ak5.l
    public final String d() {
        return this.i;
    }

    @Override // ak5.l
    public final Map<String, String> e() {
        return this.c;
    }

    @Override // ak5.l
    public final int getRequestType() {
        return this.a;
    }

    public x(String r2) {
        this.a = 2;
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new HashMap();
        this.h = j;
        this.b = r2;
    }
}
