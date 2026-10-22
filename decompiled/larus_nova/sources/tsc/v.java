package tsc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class v extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f547485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, a0> f547486b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<String, a0> f547487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f547488b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f547489c;

        public a() {
            this.f547487a = Collections.emptyMap();
        }
    }

    public final a0 b(String r100) {
        return this.f547486b.get(r100);
    }

    public v(boolean r100, Map<String, a0> r101) {
        this.f547485a = r100;
        this.f547486b = r101;
    }

    @Override // tsc.s
    public final void a(lsc.p r100, r r101) {
        if (this.f547485a == true) goto L5;
        int r102 = -1;
    L6:
        t r103 = new t(this, r100);
        if (((ArrayList) r101.f547476f).size() <= 0) goto L16;
        if (r102 <= (-1)) goto L15;
        Iterator r104 = ((ArrayList) r101.f547476f).iterator();
    L11:
        if (r104.hasNext() == false) goto L15;
        m.b r105 = (m.b) r104.next();
        if (r105.isClosed() == true) goto L11;
        r105.f547462d = r102;
    L15:
        ArrayList r106 = new ArrayList(r101.f547476f);
        Collections.reverse(r106);
        r103.a(r106);
        ((ArrayList) r101.f547476f).clear();
    L17:
        u r107 = new u(this, r100);
        m.a r108 = r101.f547477g;
    L18:
        m.a r109 = r108.f547464f;
        if (r109 == null) goto L21;
        r108 = r109;
        goto L18
    L21:
        if (r102 <= (-1)) goto L23;
        r108.c(r102);
    L23:
        List<l.a> r110 = r108.children();
        if (r110.size() <= 0) goto L26;
        r107.a(r110);
    L27:
        r101.f547477g = new m.a("", 0, Collections.emptyMap(), null);
        ((ArrayList) r101.f547476f).clear();
        r101.f547477g = new m.a("", 0, Collections.emptyMap(), null);
        return;
    L26:
        r107.a(Collections.emptyList());
        goto L27
    L16:
        r103.a(Collections.emptyList());
        goto L17
    L5:
        r102 = r100.length();
        goto L6
    }
}
