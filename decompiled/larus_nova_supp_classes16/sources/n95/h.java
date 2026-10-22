package n95;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements n95.b {
    public final Map<String, List<g>> a;
    public volatile Map<String, String> b;

    public static final class a {
        public static final Map<String, List<g>> e = null;
        public boolean a;
        public Map<String, List<g>> b;
        public boolean c;
        public boolean d;

        static {
            String r0 = System.getProperty("http.agent");
            HashMap r1 = new HashMap(2);
            if (TextUtils.isEmpty(r0) == true) goto L5;
            r1.put("User-Agent", Collections.singletonList(new b(r0)));
        L5:
            r1.put("Accept-Encoding", Collections.singletonList(new b("identity")));
            e = Collections.unmodifiableMap(r1);
        }

        public a() {
            this.a = true;
            this.b = e;
            this.c = true;
            this.d = true;
        }

        public final void a(String r7, String r8) {
            if (r8 != null) goto L4;
            b r9 = null;
        L6:
            if (this.a == false) goto L12;
            this.a = false;
            HashMap r0 = new HashMap(this.b.size());
            Iterator<Map.Entry<String, List<g>>> r2 = this.b.entrySet().iterator();
        L9:
            if (r2.hasNext() == false) goto L11;
            Map.Entry<String, List<g>> r3 = r2.next();
            r0.put(r3.getKey(), new ArrayList(r3.getValue()));
            goto L9
        L11:
            this.b = r0;
        L12:
            if (r9 != null) goto L14;
            this.b.remove(r7);
        L19:
            if (this.c == false) goto L24;
            if ("Accept-Encoding".equalsIgnoreCase(r7) == false) goto L24;
            this.c = false;
        L24:
            if (this.d == true) goto L26;
            return;
        L26:
            if ("User-Agent".equalsIgnoreCase(r7) == false) goto L31;
            this.d = false;
            return;
        L31:
            return;
        L14:
            List<g> r1 = this.b.get(r7);
            if (r1 != null) goto L17;
            r1 = new ArrayList();
            this.b.put(r7, r1);
        L17:
            r1.clear();
            r1.add(r9);
            goto L19
        L4:
            r9 = new b(r8);
            goto L6
        }
    }

    public static final class b implements g {
        public final String a;

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "StringHeaderFactory{value='" + this.a + "'}";
        }

        @Override // n95.g
        public final String buildHeader() {
            return this.a;
        }

        public b(String r1) {
            this.a = r1;
        }

        public final boolean equals(Object r2) {
            if ((r2 instanceof b) == true) goto L5;
            return false;
        L5:
            return this.a.equals(((b) r2).a);
        }
    }

    public final Map<String, String> a() {
        HashMap r0 = new HashMap();
        Iterator<Map.Entry<String, List<g>>> r1 = this.a.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        Map.Entry<String, List<g>> r2 = r1.next();
        StringBuilder r3 = new StringBuilder();
        List<g> r4 = r2.getValue();
        int r5 = 0;
    L7:
        if (r5 >= r4.size()) goto L12;
        r3.append(((g) ListProtector.get(r4, r5)).buildHeader());
        if (r5 == (r4.size() - 1)) goto L11;
        r3.append(',');
    L11:
        r5 = r5 + 1;
        goto L7
    L12:
        r0.put(r2.getKey(), r3.toString());
        goto L4
    L13:
        return r0;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "LazyHeaders{headers=" + this.a + '}';
    }

    public h(Map<String, List<g>> r1) {
        this.a = Collections.unmodifiableMap(r1);
    }

    public final boolean equals(Object r2) {
        if ((r2 instanceof h) == true) goto L5;
        return false;
    L5:
        return this.a.equals(((h) r2).a);
    }
}
