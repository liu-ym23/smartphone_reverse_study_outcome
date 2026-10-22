package org.commonmark.internal;

import org.commonmark.node.Block;
import org.commonmark.node.Heading;

/* JADX INFO: loaded from: classes42.dex */
public final class j extends wvc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Heading f525709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f525710b;

    /* JADX INFO: loaded from: classes5.dex */
    public static class a extends wvc.b {
        public a() {
        }

        @Override // wvc.e
        public wvc.f a(wvc.g r110, h.a r111) {
            h r112 = (h) r110;
            if (r112.f525696g < 4) goto L5;
            return null;
        L5:
            CharSequence r100 = r112.f525690a;
            int r113 = r112.f525694e;
            int r101 = tvc.d.b('#', r100, r113, r100.length()) - r113;
            if (r101 != 0) goto L8;
        L43:
            j r102 = null;
        L45:
            if (r102 == null) goto L48;
            d r114 = new d(new wvc.d[]{r102});
            r114.f525669b = r100.length();
            return r114;
        L48:
            char r103 = r100.charAt(r113);
            if (r103 == '-') goto L60;
            if (r103 == '=') goto L54;
        L65:
            int r115 = 0;
        L66:
            if (r115 <= 0) goto L71;
            CharSequence r116 = r111.a();
            if (r116 == null) goto L71;
            d r117 = new d(new wvc.d[]{new j(r115, ((StringBuilder) r116).toString())});
            r117.f525669b = r100.length();
            r117.f525671d = true;
            return r117;
        L71:
            return null;
        L54:
            if (tvc.d.c(r100, tvc.d.b(com.alipay.sdk.m.n.a.f25612h, r100, r113 + 1, r100.length()), r100.length()) < r100.length()) goto L56;
            boolean r104 = true;
        L57:
            if (r104 == false) goto L60;
            r115 = 1;
            goto L66
        L56:
            r104 = false;
        L60:
            if (tvc.d.c(r100, tvc.d.b('-', r100, r113 + 1, r100.length()), r100.length()) < r100.length()) goto L62;
            boolean r118 = true;
        L63:
            if (r118 == false) goto L65;
            r115 = 2;
            goto L66
        L62:
            r118 = false;
            goto L63
        L8:
            if (r101 > 6) goto L43;
            int r105 = r113 + r101;
            if (r105 < r100.length()) goto L13;
            r102 = new j(r101, "");
            goto L45
        L13:
            char r106 = r100.charAt(r105);
            if (r106 == ' ') goto L17;
            if (r106 != '\t') goto L43;
        L17:
            int r107 = r100.length();
        L23:
            r107 = r107 - 1;
            if (r107 < r105) goto L24;
            char r108 = r100.charAt(r107);
            if (r108 == '\t') goto L23;
            if (r108 == ' ') goto L23;
        L25:
            int r109 = r107;
        L26:
            if (r109 < r105) goto L31;
            if (r100.charAt(r109) != '#') goto L32;
            r109 = r109 - 1;
        L32:
            int r119 = r109;
        L33:
            if (r119 < r105) goto L39;
            char r120 = r100.charAt(r119);
            if (r120 == '\t') goto L38;
            if (r120 == ' ') goto L38;
        L40:
            if (r119 == r109) goto L42;
            r102 = new j(r101, r100.subSequence(r105, r119 + 1).toString());
            goto L45
        L42:
            r102 = new j(r101, r100.subSequence(r105, r107 + 1).toString());
        L38:
            r119 = r119 - 1;
            goto L33
        L39:
            r119 = r105 - 1;
            goto L40
        L31:
            r109 = r105 - 1;
            goto L32
        L24:
            r107 = r105 - 1;
            goto L25
        }
    }

    @Override // wvc.d
    public final wvc.c f(wvc.g r100) {
        return null;
    }

    @Override // wvc.d
    public final Block a() {
        return this.f525709a;
    }

    @Override // wvc.a, wvc.d
    public final void g(vvc.a r100) {
        r100.a(this.f525710b, this.f525709a);
    }

    public j(int r100, String r101) {
        Heading r102 = new Heading();
        this.f525709a = r102;
        r102.f525767h = r100;
        this.f525710b = r101;
    }
}
