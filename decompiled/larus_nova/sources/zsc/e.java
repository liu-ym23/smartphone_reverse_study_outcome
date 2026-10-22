package zsc;

import java.util.Locale;
import java.util.regex.Pattern;
import org.commonmark.node.Image;
import org.commonmark.node.Link;
import org.commonmark.node.LinkReferenceDefinition;

/* JADX INFO: loaded from: classes5.dex */
public final class e extends i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f573515e = null;

    @Override // zsc.i
    public final char d() {
        return ']';
    }

    static {
        f573515e = j.f573526o;
    }

    @Override // zsc.i
    public final uvc.b b() {
        boolean r100 = true;
        int r101 = this.f573521d + 1;
        this.f573521d = r101;
        k r102 = this.f573518a;
        org.commonmark.internal.e r103 = ((j) r102).f573536j;
        if (r103 != null) goto L7;
        return f("]");
    L7:
        if (r103.f525677f == true) goto L10;
        j r104 = (j) r102;
        r104.f573536j = r104.f573536j.f525675d;
        return f("]");
    L10:
        LinkReferenceDefinition r105 = null;
        if (c() != '(') goto L35;
        this.f573521d++;
        e();
        k r106 = this.f573518a;
        int r107 = this.f573521d;
        j r108 = (j) r106;
        r108.f573534h = r107;
        int r109 = tvc.c.a(r108.f573533g, r107);
        if (r109 != (-1)) goto L16;
        String r110 = null;
    L20:
        this.f573521d = ((j) this.f573518a).f573534h;
        if (r110 == null) goto L34;
        e();
        Pattern r111 = f573515e;
        String r112 = this.f573520c;
        int r113 = this.f573521d;
        if (r111.matcher(r112.substring(r113 - 1, r113)).matches() == false) goto L29;
        k r114 = this.f573518a;
        int r115 = this.f573521d;
        j r116 = (j) r114;
        r116.f573534h = r115;
        int r117 = tvc.c.c(r116.f573533g, r115);
        if (r117 != (-1)) goto L27;
        String r118 = null;
    L28:
        this.f573521d = ((j) this.f573518a).f573534h;
        e();
    L31:
        if (c() != ')') goto L33;
        this.f573521d++;
        boolean r119 = true;
    L37:
        if (r119 == true) goto L67;
        int r120 = this.f573521d;
        j r121 = (j) this.f573518a;
        r121.f573534h = r120;
        if (r120 < r121.f573533g.length()) goto L41;
    L54:
        int r122 = ((j) this.f573518a).f573534h;
        this.f573521d = r122;
        int r123 = r122 - r120;
        if (r123 <= 2) goto L58;
        String r124 = this.f573520c.substring(r120, r123 + r120);
    L61:
        if (r124 == null) goto L67;
        Pattern r125 = tvc.a.f547710a;
        String r126 = tvc.a.f547712c.matcher(r124.substring(1, r124.length() - 1).trim().toLowerCase(Locale.ROOT)).replaceAll(" ");
        j r127 = (j) this.f573518a;
        if (r127.f573528b == false) goto L65;
        r105 = ((org.commonmark.internal.m) r127.f573527a).f525719b.get(r126);
    L65:
        if (r105 == null) goto L67;
        r110 = r105.f525776i;
        r118 = r105.f525777j;
    L68:
        if (r100 == true) goto L70;
        this.f573521d = r101;
        j r128 = (j) this.f573518a;
        r128.f573536j = r128.f573536j.f525675d;
        return f("]");
    L70:
        if (r103.f525674c == false) goto L72;
        uvc.b r129 = new Image(r110, r118);
    L73:
        uvc.b r130 = r103.f525672a.f551904e;
    L74:
        if (r130 == null) goto L76;
        uvc.b r131 = r130.f551904e;
        r129.b(r130);
        r130 = r131;
        goto L74
    L76:
        org.commonmark.internal.f r132 = r103.f525676e;
        j r133 = (j) this.f573518a;
        r133.f573534h = this.f573521d;
        r133.e(r132);
        this.f573521d = ((j) this.f573518a).f573534h;
        uvc.b r134 = r129.f551901b;
        uvc.b r135 = r129.f551902c;
        if (r134 == r135) goto L80;
        h.b(r134, r135);
    L80:
        r103.f525672a.g();
        k r136 = this.f573518a;
        j r137 = (j) r136;
        r137.f573536j = r137.f573536j.f525675d;
        if (r103.f525674c == true) goto L88;
        org.commonmark.internal.e r138 = ((j) r136).f573536j;
    L83:
        if (r138 == null) goto L88;
        if (r138.f525674c == true) goto L87;
        r138.f525677f = false;
    L87:
        r138 = r138.f525675d;
    L88:
        return r129;
    L72:
        r129 = new Link(r110, r118);
        goto L73
    L58:
        if (r103.f525678g == true) goto L60;
        r124 = this.f573520c.substring(r103.f525673b, r101);
        goto L61
    L60:
        r124 = null;
        goto L61
    L41:
        if (r121.f573533g.charAt(r121.f573534h) != '[') goto L54;
        int r139 = r121.f573534h + 1;
        int r140 = tvc.c.b(r121.f573533g, r139);
        int r141 = r140 - r139;
        if (r140 == (-1)) goto L54;
        if (r141 > 999) goto L54;
        if (r140 >= r121.f573533g.length()) goto L54;
        if (r121.f573533g.charAt(r140) != ']') goto L54;
        r121.f573534h = r140 + 1;
    L67:
        r100 = r119;
        goto L68
    L33:
        this.f573521d = r101;
    L36:
        r119 = false;
        goto L37
    L27:
        String r142 = r116.f573533g.substring(r116.f573534h + 1, r117 - 1);
        r116.f573534h = r117;
        r118 = tvc.a.a(r142);
        goto L28
    L29:
        r118 = null;
        goto L31
    L34:
        r118 = null;
        goto L36
    L16:
        if (r108.d() != '<') goto L18;
        String r143 = r108.f573533g.substring(r108.f573534h + 1, r109 - 1);
    L19:
        r108.f573534h = r109;
        r110 = tvc.a.a(r143);
        goto L20
    L18:
        r143 = r108.f573533g.substring(r108.f573534h, r109);
        goto L19
    L35:
        r110 = null;
        r118 = null;
        goto L36
    }

    public e() {
    }
}
