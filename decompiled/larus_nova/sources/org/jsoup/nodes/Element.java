package org.jsoup.nodes;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import kotlin.text.Typography;
import org.jsoup.helper.ChangeNotifyingArrayList;
import org.jsoup.helper.ValidationException;
import org.jsoup.select.Elements;

/* JADX INFO: loaded from: classes42.dex */
public class Element extends j {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List<Element> f525903h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Pattern f525904i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f525905j = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public org.jsoup.parser.f f525906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public WeakReference<List<Element>> f525907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<j> f525908f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public b f525909g;

    public static final class NodeList extends ChangeNotifyingArrayList<j> {
        private final Element owner;

        @Override // org.jsoup.helper.ChangeNotifyingArrayList
        public void onContentsChanged() {
            this.owner.f525907e = null;
        }

        public NodeList(Element r100, int r101) {
            super(r101);
            this.owner = r100;
        }
    }

    public class a implements gwc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StringBuilder f525910a;

        public a(StringBuilder r100) {
            this.f525910a = r100;
        }

        @Override // gwc.b
        public final void a(j r100, int r101) {
            if ((r100 instanceof Element) == true) goto L5;
            return;
        L5:
            if (((Element) r100).f525906d.f526036c == true) goto L7;
            return;
        L7:
            if ((r100.s() instanceof m) == true) goto L9;
            return;
        L9:
            if (m.I(this.f525910a) == true) goto L15;
            this.f525910a.append(' ');
            return;
        }

        @Override // gwc.b
        public final void b(j r100, int r101) {
            if ((r100 instanceof m) == false) goto L6;
            StringBuilder r102 = this.f525910a;
            Element.H(r102, (m) r100);
            return;
        L6:
            if ((r100 instanceof Element) == false) goto L18;
            Element r103 = (Element) r100;
            if (this.f525910a.length() <= 0) goto L19;
            org.jsoup.parser.f r104 = r103.f525906d;
            if (r104.f526036c == true) goto L14;
            if (r104.f526035b.equals(SRStrategy.MEDIAINFO_KEY_BITRATE) == true) goto L14;
            return;
        L14:
            if (m.I(this.f525910a) == true) goto L21;
            this.f525910a.append(' ');
            return;
        L21:
            return;
        L19:
            return;
        }
    }

    public Element() {
        throw null;
    }

    public final Elements K() {
        return new Elements(J());
    }

    public final Set<String> L() {
        LinkedHashSet r100 = new LinkedHashSet(Arrays.asList(f525904i.split(d("class").trim())));
        r100.remove("");
        return r100;
    }

    public final int Q() {
        j r100 = this.f525933a;
        if (((Element) r100) != null) goto L7;
        return 0;
    L7:
        return U(this, ((Element) r100).J());
    }

    public final boolean S() {
        Iterator<j> r100 = this.f525908f.iterator();
    L4:
        if (r100.hasNext() == false) goto L15;
        j r101 = r100.next();
        if ((r101 instanceof m) == true) goto L8;
        if ((r101 instanceof Element) == false) goto L4;
        if (((Element) r101).S() == false) goto L4;
        return true;
    L8:
        if (fwc.b.d(((m) r101).F()) == true) goto L4;
        return true;
    L15:
        return false;
    }

    @Nullable
    public final Element Y() {
        j r100 = this.f525933a;
        if (r100 != null) goto L5;
        return null;
    L5:
        List<Element> r101 = ((Element) r100).J();
        int r102 = U(this, r101);
        if (r102 > 0) goto L8;
        return null;
    L8:
        return (Element) ListProtector.get(r101, r102 - 1);
    }

    @Override // org.jsoup.nodes.j
    public final b f() {
        if (this.f525909g != null) goto L6;
        this.f525909g = new b();
    L6:
        return this.f525909g;
    }

    @Override // org.jsoup.nodes.j
    public final String g() {
        String r100 = f525905j;
        Element r101 = this;
    L3:
        if (r101 == null) goto L13;
        b r102 = r101.f525909g;
        if (r102 == null) goto L12;
        if (r102.h(r100) == (-1)) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        return r101.f525909g.e(r100);
    L9:
        r103 = false;
    L12:
        r101 = (Element) r101.f525933a;
        goto L3
    L13:
        return "";
    }

    @Override // org.jsoup.nodes.j
    public final int i() {
        return this.f525908f.size();
    }

    @Override // org.jsoup.nodes.j
    public final j m() {
        this.f525908f.clear();
        return this;
    }

    @Override // org.jsoup.nodes.j
    public final List<j> n() {
        if (this.f525908f != j.f525932c) goto L6;
        this.f525908f = new NodeList(this, 4);
    L6:
        return this.f525908f;
    }

    @Override // org.jsoup.nodes.j
    public final boolean q() {
        if (this.f525909g == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.jsoup.nodes.j
    public String t() {
        return this.f525906d.f526034a;
    }

    @Override // org.jsoup.nodes.j
    @Nullable
    public final j y() {
        return (Element) this.f525933a;
    }

    static {
        f525903h = Collections.emptyList();
        f525904i = PatternProtector.compile("\\s+");
        f525905j = HTTP.URL_DEFAULT.concat("baseUri");
    }

    @Override // org.jsoup.nodes.j
    public final j D() {
        return (Element) super.D();
    }

    public final List<Element> J() {
        if (i() == 0) goto L5;
        WeakReference<List<Element>> r100 = this.f525907e;
        if (r100 == null) goto L10;
        List<Element> r101 = r100.get();
        if (r101 == null) goto L10;
        return r101;
    L10:
        int r102 = this.f525908f.size();
        ArrayList r103 = new ArrayList(r102);
        int r104 = 0;
    L11:
        if (r104 >= r102) goto L16;
        j r105 = (j) ListProtector.get(this.f525908f, r104);
        if ((r105 instanceof Element) == false) goto L15;
        r103.add((Element) r105);
    L15:
        r104 = r104 + 1;
        goto L11
    L16:
        this.f525907e = new WeakReference(r103);
        return r103;
    L5:
        return f525903h;
    }

    public Element N() {
        return (Element) super.k();
    }

    public final String O() {
        StringBuilder r100 = fwc.b.b();
        Iterator<j> r101 = this.f525908f.iterator();
    L4:
        if (r101.hasNext() == false) goto L18;
        j r102 = r101.next();
        if ((r102 instanceof e) == true) goto L7;
        if ((r102 instanceof d) == true) goto L10;
        if ((r102 instanceof Element) == true) goto L13;
        if ((r102 instanceof c) == false) goto L4;
        r100.append(((c) r102).F());
        goto L4
    L13:
        r100.append(((Element) r102).O());
        goto L4
    L10:
        r100.append(((d) r102).F());
        goto L4
    L7:
        r100.append(((e) r102).F());
        goto L4
    L18:
        return fwc.b.g(r100);
    }

    public final String T() {
        StringBuilder r100 = fwc.b.b();
        int r101 = this.f525908f.size();
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L10;
        j r103 = (j) ListProtector.get(this.f525908f, r102);
        r103.getClass();
        Document r104 = r103.x();
        if (r104 != null) goto L9;
        r104 = new Document("");
    L9:
        org.jsoup.select.d.b(new j.a(r100, r104.f525890k), r103);
        r102 = r102 + 1;
        goto L4
    L10:
        String r105 = fwc.b.g(r100);
        Document r106 = x();
        if (r106 != null) goto L15;
        r106 = new Document("");
    L15:
        if (r106.f525890k.f525897e == true) goto L17;
        return r105;
    L17:
        return r105.trim();
    }

    public final String X() {
        StringBuilder r100 = fwc.b.b();
        int r101 = 0;
    L4:
        if (r101 >= i()) goto L17;
        j r102 = (j) ListProtector.get(this.f525908f, r101);
        if ((r102 instanceof m) == false) goto L9;
        H(r100, (m) r102);
    L15:
        r101 = r101 + 1;
        goto L4
    L9:
        if ((r102 instanceof Element) == false) goto L15;
        if (((Element) r102).f525906d.f526035b.equals(SRStrategy.MEDIAINFO_KEY_BITRATE) == false) goto L15;
        if (m.I(r100) == true) goto L15;
        r100.append(" ");
        goto L15
    L17:
        return fwc.b.g(r100).trim();
    }

    public final String a0() {
        StringBuilder r100 = fwc.b.b();
        org.jsoup.select.d.b(new a(r100), this);
        return fwc.b.g(r100).trim();
    }

    public final String c0() {
        StringBuilder r100 = fwc.b.b();
        int r101 = i();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L6;
        I((j) ListProtector.get(this.f525908f, r102), r100);
        r102 = r102 + 1;
        goto L3
    L6:
        return fwc.b.g(r100);
    }

    @Override // org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return N();
    }

    @Override // org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ j k() {
        return N();
    }

    public final void G(j r100) {
        ewc.b.d(r100);
        j r101 = r100.f525933a;
        if (r101 == null) goto L5;
        r101.B(r100);
    L5:
        r100.f525933a = this;
        n();
        this.f525908f.add(r100);
        r100.f525934b = this.f525908f.size() - 1;
    }

    public final void M(Set r100) {
        if (r100.isEmpty() == false) goto L7;
        b r101 = f();
        int r102 = r101.h("class");
        if (r102 == (-1)) goto L9;
        r101.m(r102);
        return;
    L9:
        return;
    L7:
        f().k("class", fwc.b.f(r100, " "));
    }

    public final void P(String r100) {
        f().k(f525905j, r100);
    }

    public final boolean R(String r110) {
        b r100 = this.f525909g;
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = r100.f("class");
        int r102 = r101.length();
        int r103 = r110.length();
        if (r102 == 0) goto L31;
        if (r102 < r103) goto L31;
        if (r102 == r103) goto L11;
        boolean r104 = false;
        int r111 = 0;
        int r112 = 0;
    L13:
        if (r112 >= r102) goto L26;
        if (Character.isWhitespace(r101.charAt(r112)) == false) goto L23;
        if (r104 == false) goto L25;
        if ((r112 - r111) == r103) goto L20;
    L22:
        r104 = false;
        goto L25
    L20:
        if (r101.regionMatches(true, r111, r110, 0, r103) == false) goto L22;
        return true;
    L25:
        r112 = r112 + 1;
        goto L13
    L23:
        if (r104 == true) goto L25;
        r111 = r112;
        r104 = true;
        goto L25
    L26:
        if (r104 == false) goto L31;
        if ((r102 - r111) != r103) goto L31;
        return r101.regionMatches(true, r111, r110, 0, r103);
    L11:
        return r110.equalsIgnoreCase(r101);
    L31:
        return false;
    }

    public final void V(Collection r100) {
        if (r100 == null) goto L14;
        int r101 = i();
        int r102 = (-1) + (r101 + 1);
        if (r102 < 0) goto L7;
        if (r102 > r101) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L12;
        b(r102, (j[]) new ArrayList(r100).toArray(new j[0]));
        return;
    L12:
        throw new ValidationException("Insert position out of bounds.");
    L7:
        r103 = false;
        goto L8
    L14:
        throw new ValidationException("Children collection to be inserted must not be null.");
    }

    public final boolean W(org.jsoup.select.c r100) {
        return r100.a((Element) super.D(), this);
    }

    public final boolean Z(Document.OutputSettings r100) {
        if (r100.f525897e == false) goto L31;
        org.jsoup.parser.f r101 = this.f525906d;
        if (r101.f526037d == true) goto L11;
        Element r102 = (Element) this.f525933a;
        if (r102 != null) goto L9;
    L10:
        boolean r103 = false;
    L12:
        if (r103 == true) goto L14;
        return false;
    L14:
        if ((!r101.f526036c) == false) goto L27;
        j r104 = this.f525933a;
        Element r105 = (Element) r104;
        if (r105 != null) goto L18;
    L19:
        if (r104 != null) goto L22;
    L24:
        j r106 = null;
    L25:
        if (r106 == null) goto L27;
        boolean r107 = true;
    L28:
        if (r107 == true) goto L33;
        return true;
    L33:
        return false;
    L22:
        if (this.f525934b <= 0) goto L24;
        r106 = (j) ListProtector.get(r104.n(), this.f525934b - 1);
        goto L25
    L18:
        if (r105.f525906d.f526036c == true) goto L19;
    L27:
        r107 = false;
        goto L28
    L9:
        if (r102.f525906d.f526037d == false) goto L10;
    L11:
        r103 = true;
        goto L12
    L31:
        return false;
    }

    public void b0(String r100) {
        ewc.b.d(r100);
        this.f525908f.clear();
        Document r101 = x();
        if (r101 == null) goto L13;
        org.jsoup.parser.e r102 = r101.f525891l;
        String r103 = this.f525906d.f526035b;
        ((org.jsoup.parser.b) r102.f526024a).getClass();
        if (r103.equals("script") == false) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == false) goto L13;
        G(new e(r100));
        return;
    L7:
        if (r103.equals("style") == true) goto L10;
        r104 = false;
    L13:
        G(new m(r100));
    }

    @Override // org.jsoup.nodes.j
    public final j l(@Nullable j r100) {
        Element r101 = (Element) super.l(r100);
        b r102 = this.f525909g;
        if (r102 == null) goto L5;
        b r103 = r102.d();
    L6:
        r101.f525909g = r103;
        NodeList r104 = new NodeList(r101, this.f525908f.size());
        r101.f525908f = r104;
        r104.addAll(this.f525908f);
        return r101;
    L5:
        r103 = null;
        goto L6
    }

    public static void F(Element r100, Elements r101) {
        Element r102 = (Element) r100.f525933a;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.f525906d.f526034a.equals("#root") == true) goto L9;
        r101.add(r102);
        F(r102, r101);
        return;
    }

    public static void H(StringBuilder r100, m r101) {
        String r102 = r101.F();
        j r103 = r101.f525933a;
        boolean r104 = false;
        if ((r103 instanceof Element) == false) goto L11;
        Element r105 = (Element) r103;
        int r106 = 0;
    L6:
        if (r105.f525906d.f526040g == true) goto L7;
        r105 = (Element) r105.f525933a;
        r106 = r106 + 1;
        if (r106 >= 6) goto L11;
        if (r105 != null) goto L6;
    L7:
        r104 = true;
    L11:
        if (r104 == false) goto L13;
    L16:
        r100.append(r102);
        return;
    L13:
        if ((r101 instanceof c) == true) goto L16;
        fwc.b.a(r100, r102, m.I(r100));
    }

    public static void I(j r100, StringBuilder r101) {
        if ((r100 instanceof m) == false) goto L6;
        r101.append(((m) r100).F());
        return;
    L6:
        if ((r100 instanceof Element) == true) goto L8;
        return;
    L8:
        if (((Element) r100).f525906d.f526035b.equals(SRStrategy.MEDIAINFO_KEY_BITRATE) == false) goto L13;
        r101.append("\n");
        return;
    }

    public static <E extends Element> int U(Element r100, List<E> r101) {
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if (ListProtector.get(r101, r103) == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r103;
    L8:
        return 0;
    }

    public Element(org.jsoup.parser.f r100, @Nullable String r101, @Nullable b r102) {
        ewc.b.d(r100);
        this.f525908f = j.f525932c;
        this.f525909g = r102;
        this.f525906d = r100;
        if (r101 == null) goto L6;
        P(r101);
        return;
    }

    @Override // org.jsoup.nodes.j
    public void v(Appendable r100, int r101, Document.OutputSettings r102) throws IOException {
        if (Z(r102) == true) goto L5;
    L10:
        r100.append(Typography.less).append(this.f525906d.f526034a);
        b r103 = this.f525909g;
        if (r103 == null) goto L14;
        r103.g(r100, r102);
    L14:
        if (this.f525908f.isEmpty() == false) goto L28;
        org.jsoup.parser.f r104 = this.f525906d;
        boolean r105 = r104.f526038e;
        if (r105 == false) goto L18;
    L21:
        boolean r106 = true;
    L22:
        if (r106 == false) goto L28;
        if (r102.f525900h != Document.OutputSettings.Syntax.html) goto L27;
        if (r105 == false) goto L27;
        r100.append(Typography.greater);
        return;
    L27:
        r100.append(" />");
        return;
    L18:
        if (r104.f526039f == true) goto L21;
        r106 = false;
    L28:
        r100.append(Typography.greater);
        return;
    L5:
        if ((r100 instanceof StringBuilder) == true) goto L7;
        j.r(r100, r101, r102);
        goto L10
    L7:
        if (((StringBuilder) r100).length() <= 0) goto L10;
        j.r(r100, r101, r102);
        goto L10
    }

    @Override // org.jsoup.nodes.j
    public void w(Appendable r100, int r101, Document.OutputSettings r102) throws IOException {
        if (this.f525908f.isEmpty() == false) goto L13;
        org.jsoup.parser.f r103 = this.f525906d;
        if (r103.f526038e == false) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == false) goto L13;
        return;
    L7:
        if (r103.f526039f == true) goto L10;
        r104 = false;
    L13:
        if (r102.f525897e == true) goto L15;
    L20:
        r100.append("</").append(this.f525906d.f526034a).append(Typography.greater);
        return;
    L15:
        if (this.f525908f.isEmpty() == true) goto L20;
        if (this.f525906d.f526037d == false) goto L20;
        j.r(r100, r101, r102);
        goto L20
    }
}
