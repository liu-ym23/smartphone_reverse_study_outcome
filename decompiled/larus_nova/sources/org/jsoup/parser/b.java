package org.jsoup.parser;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.common.TeaEventTrack;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.platform.api.creation.TplType;
import com.larus.trace.CopyContentTypeString;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.jsoup.helper.ValidationException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.j;
import org.jsoup.nodes.m;

/* JADX INFO: loaded from: classes42.dex */
public final class b extends i {
    public static final String[] A = null;
    public static final String[] B = null;
    public static final String[] C = null;
    public static final String[] D = null;
    public static final String[] E = null;
    public static final String[] F = null;
    public static final String[] G = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String[] f526003z = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public HtmlTreeBuilderState f526004l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public HtmlTreeBuilderState f526005m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f526006n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public Element f526007o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public org.jsoup.nodes.h f526008p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public Element f526009q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ArrayList<Element> f526010r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ArrayList<HtmlTreeBuilderState> f526011s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List<String> f526012t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Token.f f526013u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f526014v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f526015w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f526016x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String[] f526017y;

    static {
        f526003z = new String[]{"applet", "caption", "html", "marquee", "object", CopyContentTypeString.TABLE, "td", "th"};
        A = new String[]{"ol", "ul"};
        B = new String[]{"button"};
        C = new String[]{"html", CopyContentTypeString.TABLE};
        D = new String[]{"optgroup", "option"};
        E = new String[]{"dd", BytedCertConstant.LivenessInfoConfigKey.DETECT_TYPE, "li", "optgroup", "option", "p", "rb", "rp", "rt", "rtc"};
        F = new String[]{"caption", "colgroup", "dd", BytedCertConstant.LivenessInfoConfigKey.DETECT_TYPE, "li", "optgroup", "option", "p", "rb", "rp", "rt", "rtc", "tbody", "td", "tfoot", "th", "thead", "tr"};
        G = new String[]{"address", "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", ContainerPosition.BODY, SRStrategy.MEDIAINFO_KEY_BITRATE, "button", "caption", "center", "col", "colgroup", "command", "dd", "details", MapBundleKey.MapObjKey.OBJ_DIR, "div", "dl", BytedCertConstant.LivenessInfoConfigKey.DETECT_TYPE, "embed", "fieldset", "figcaption", "figure", ContainerPosition.FOOTER, "form", "frame", "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hgroup", "hr", "html", "iframe", "img", "input", "isindex", "li", "link", "listing", "marquee", TplType.MENU, "meta", "nav", "noembed", "noframes", "noscript", "object", "ol", "p", "param", "plaintext", TeaEventTrack.ACTION_DRAMA_PRE, "script", "section", "select", "style", "summary", CopyContentTypeString.TABLE, "tbody", "td", "textarea", "tfoot", "th", "thead", "title", "tr", "ul", "wbr", "xmp"};
    }

    public final void D() {
        Element r100 = (Element) ListProtector.remove(this.f526071e, this.f526071e.size() - 1);
    }

    @Nullable
    public final void F() {
        if (this.f526011s.size() <= 0) goto L6;
        ArrayList<HtmlTreeBuilderState> r100 = this.f526011s;
        HtmlTreeBuilderState r101 = (HtmlTreeBuilderState) ListProtector.remove(r100, r100.size() - 1);
        return;
    }

    public final void I() {
        if (this.f526071e.size() <= 256) goto L6;
        return;
    L6:
        if (this.f526010r.size() <= 0) goto L8;
        ArrayList<Element> r100 = this.f526010r;
        Element r101 = (Element) ListProtector.get(r100, r100.size() - 1);
    L9:
        if (r101 != null) goto L11;
        return;
    L11:
        if (C(this.f526071e, r101) == true) goto L37;
        int r102 = this.f526010r.size();
        int r103 = r102 - 12;
        if (r103 >= 0) goto L16;
        r103 = 0;
    L16:
        boolean r104 = true;
        int r105 = r102 - 1;
        int r106 = r105;
    L17:
        if (r106 == r103) goto L25;
        r106 = r106 - 1;
        r101 = (Element) ListProtector.get(this.f526010r, r106);
        if (r101 == null) goto L30;
        if (C(this.f526071e, r101) == false) goto L17;
    L30:
        r104 = false;
    L25:
        if (r104 == true) goto L27;
        r106 = r106 + 1;
        r101 = (Element) ListProtector.get(this.f526010r, r106);
    L27:
        ewc.b.d(r101);
        Element r107 = new Element(g(r101.f525906d.f526035b, this.f526074h), null, r101.f().d());
        insert(r107);
        ListProtector.set(this.f526010r, r106, r107);
        if (r106 == r105) goto L38;
        r104 = false;
        goto L25
    L38:
        return;
    L37:
        return;
    L8:
        r101 = null;
        goto L9
    }

    public final boolean L() {
        int r100 = this.f526071e.size() - 1;
        if (r100 < 256) goto L5;
        int r101 = r100 - 256;
    L6:
        HtmlTreeBuilderState r102 = this.f526004l;
        if (this.f526071e.size() != 0) goto L9;
        this.f526004l = HtmlTreeBuilderState.InBody;
    L9:
        boolean r103 = false;
    L10:
        if (r100 < r101) goto L115;
        Element r104 = (Element) ListProtector.get(this.f526071e, r100);
        if (r100 == r101) goto L14;
    L17:
        if (r104 == null) goto L19;
        String r105 = r104.f525906d.f526035b;
    L20:
        r105.getClass();
        switch(r105.hashCode()) {
            case -1644953643: goto L80;
            case -1321546630: goto L76;
            case -906021636: goto L72;
            case -636197633: goto L68;
            case 3696: goto L64;
            case 3700: goto L60;
            case 3710: goto L56;
            case 3029410: goto L52;
            case 3198432: goto L48;
            case 3213227: goto L44;
            case 110115790: goto L40;
            case 110157846: goto L36;
            case 110277346: goto L32;
            case 110326868: goto L28;
            case 552573414: goto L24;
            default: goto L83;
        };
    L83:
        byte r106 = -1;
    L84:
        switch(r106) {
            case 0: goto L110;
            case 1: goto L103;
            case 2: goto L101;
            case 3: goto L100;
            case 4: goto L98;
            case 5: goto L98;
            case 6: goto L97;
            case 7: goto L96;
            case 8: goto L94;
            case 9: goto L90;
            case 10: goto L88;
            case 11: goto L87;
            case 12: goto L87;
            case 13: goto L87;
            case 14: goto L86;
            default: goto L111;
        };
    L94:
        if (r103 == true) goto L111;
        this.f526004l = HtmlTreeBuilderState.InHead;
        goto L115
    L98:
        if (r103 == true) goto L111;
        this.f526004l = HtmlTreeBuilderState.InCell;
    L111:
        if (r103 == true) goto L112;
        r100 = r100 - 1;
        goto L10
    L112:
        this.f526004l = HtmlTreeBuilderState.InBody;
        goto L115
    L86:
        this.f526004l = HtmlTreeBuilderState.InCaption;
        goto L115
    L87:
        this.f526004l = HtmlTreeBuilderState.InTableBody;
        goto L115
    L88:
        this.f526004l = HtmlTreeBuilderState.InTable;
        goto L115
    L90:
        if (this.f526007o != null) goto L92;
        HtmlTreeBuilderState r107 = HtmlTreeBuilderState.BeforeHead;
    L93:
        this.f526004l = r107;
        goto L115
    L92:
        r107 = HtmlTreeBuilderState.AfterHead;
        goto L93
    L96:
        this.f526004l = HtmlTreeBuilderState.InBody;
        goto L115
    L97:
        this.f526004l = HtmlTreeBuilderState.InRow;
        goto L115
    L100:
        this.f526004l = HtmlTreeBuilderState.InColumnGroup;
        goto L115
    L101:
        this.f526004l = HtmlTreeBuilderState.InSelect;
        goto L115
    L103:
        if (this.f526011s.size() <= 0) goto L105;
        ArrayList<HtmlTreeBuilderState> r108 = this.f526011s;
        HtmlTreeBuilderState r109 = (HtmlTreeBuilderState) ListProtector.get(r108, r108.size() - 1);
    L106:
        if (r109 == null) goto L109;
        this.f526004l = r109;
        goto L115
    L109:
        throw new ValidationException("Bug: no template insertion mode on stack!");
    L105:
        r109 = null;
        goto L106
    L110:
        this.f526004l = HtmlTreeBuilderState.InFrameset;
        goto L115
    L24:
        if (r105.equals("caption") == false) goto L83;
        r106 = 14;
        goto L84
    L28:
        if (r105.equals("thead") == false) goto L83;
        r106 = HTTP.CR;
        goto L84
    L32:
        if (r105.equals("tfoot") == false) goto L83;
        r106 = 12;
        goto L84
    L36:
        if (r105.equals("tbody") == false) goto L83;
        r106 = 11;
        goto L84
    L40:
        if (r105.equals(CopyContentTypeString.TABLE) == false) goto L83;
        r106 = 10;
        goto L84
    L44:
        if (r105.equals("html") == false) goto L83;
        r106 = 9;
        goto L84
    L48:
        if (r105.equals("head") == false) goto L83;
        r106 = 8;
        goto L84
    L52:
        if (r105.equals(ContainerPosition.BODY) == false) goto L83;
        r106 = 7;
        goto L84
    L56:
        if (r105.equals("tr") == false) goto L83;
        r106 = 6;
        goto L84
    L60:
        if (r105.equals("th") == false) goto L83;
        r106 = 5;
        goto L84
    L64:
        if (r105.equals("td") == false) goto L83;
        r106 = 4;
        goto L84
    L68:
        if (r105.equals("colgroup") == false) goto L83;
        r106 = 3;
        goto L84
    L72:
        if (r105.equals("select") == false) goto L83;
        r106 = 2;
        goto L84
    L76:
        if (r105.equals(ThumbGlideUrl.SOURCE_TEMPLATE) == false) goto L83;
        r106 = 1;
        goto L84
    L80:
        if (r105.equals("frameset") == false) goto L83;
        r106 = 0;
        goto L84
    L19:
        r105 = "";
        goto L20
    L14:
        if (this.f526016x == false) goto L16;
        r104 = this.f526009q;
    L16:
        r103 = true;
    L115:
        if (this.f526004l != r102) goto L133;
        return false;
    L133:
        return true;
    L5:
        r101 = 0;
        goto L6
    }

    public final void j() {
    L3:
        if (this.f526010r.isEmpty() == true) goto L9;
        int r100 = this.f526010r.size();
        if (r100 <= 0) goto L7;
        Element r101 = (Element) ListProtector.remove(this.f526010r, r100 - 1);
    L8:
        if (r101 != null) goto L3;
        return;
    L7:
        r101 = null;
        goto L8
    }

    public final void l() {
        k(new String[]{CopyContentTypeString.TABLE, ThumbGlideUrl.SOURCE_TEMPLATE});
    }

    public final String toString() {
        return "TreeBuilder{currentToken=" + this.f526073g + ", state=" + this.f526004l + ", currentElement=" + a() + '}';
    }

    public b() {
        this.f526017y = new String[]{null};
    }

    public final void A(j r100) {
        if (this.f526071e.isEmpty() == false) goto L6;
        this.f526070d.G(r100);
    L12:
        if ((r100 instanceof Element) == false) goto L19;
        Element r101 = (Element) r100;
        if (r101.f525906d.f526041h == false) goto L20;
        org.jsoup.nodes.h r102 = this.f526008p;
        if (r102 == null) goto L21;
        r102.f525930k.add(r101);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L6:
        if (this.f526015w == true) goto L8;
    L10:
        a().G(r100);
        goto L12
    L8:
        if (fwc.b.c(a().f525906d.f526035b, HtmlTreeBuilderState.b.A) == false) goto L10;
        z(r100);
        goto L12
    }

    public final boolean B(String r100) {
        if (q(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Nullable
    public final void E(String r100) {
        int r101 = this.f526071e.size();
    L3:
        r101 = r101 - 1;
        if (r101 < 0) goto L12;
        Element r102 = (Element) ListProtector.get(this.f526071e, r101);
        ListProtector.remove(this.f526071e, r101);
        if (r102.f525906d.f526035b.equals(r100) == false) goto L3;
        boolean r103 = this.f526073g instanceof Token.f;
        return;
    }

    public final void H(HtmlTreeBuilderState r100) {
        this.f526011s.add(r100);
    }

    public final void J(Element r100) {
        int r101 = this.f526010r.size();
    L3:
        r101 = r101 - 1;
        if (r101 < 0) goto L12;
        if (((Element) ListProtector.get(this.f526010r, r101)) != r100) goto L3;
        ListProtector.remove(this.f526010r, r101);
        return;
    }

    public final void K(Element r100) {
        int r101 = this.f526071e.size() - 1;
    L3:
        if (r101 < 0) goto L9;
        if (((Element) ListProtector.get(this.f526071e, r101)) == r100) goto L6;
        r101 = r101 - 1;
        goto L3
    L6:
        ListProtector.remove(this.f526071e, r101);
        return;
    }

    @Override // org.jsoup.parser.i
    public final boolean c(Token r100) {
        this.f526073g = r100;
        return this.f526004l.process(r100, this);
    }

    @Nullable
    public final Element h(Element r100) {
        int r101 = this.f526071e.size() - 1;
    L3:
        if (r101 < 0) goto L9;
        if (((Element) ListProtector.get(this.f526071e, r101)) == r100) goto L7;
        r101 = r101 - 1;
        goto L3
    L7:
        return (Element) ListProtector.get(this.f526071e, r101 - 1);
    L9:
        return null;
    }

    public final void i(Element r100) {
        int r101 = this.f526010r.size() - 1;
        int r102 = r101 - 12;
        if (r102 >= 0) goto L5;
        r102 = 0;
    L5:
        int r103 = 0;
    L6:
        if (r101 < r102) goto L26;
        Element r104 = (Element) ListProtector.get(this.f526010r, r101);
        if (r104 == null) goto L27;
        if (r100.f525906d.f526035b.equals(r104.f525906d.f526035b) == true) goto L13;
    L15:
        boolean r105 = false;
    L16:
        if (r105 == false) goto L19;
        r103 = r103 + 1;
    L19:
        if (r103 == 3) goto L20;
        r101 = r101 - 1;
        goto L6
    L20:
        ListProtector.remove(this.f526010r, r101);
        return;
    L13:
        if (r100.f().equals(r104.f()) == false) goto L15;
        r105 = true;
        goto L16
    L27:
        return;
    }

    public Element insert(Token.g r110) {
        if (r110.l() == false) goto L38;
        org.jsoup.nodes.b r100 = r110.f525987l;
        int r101 = r100.f525924a;
        if (r101 != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L38;
        d r103 = this.f526074h;
        if (r101 != 0) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == false) goto L15;
        int r105 = 0;
    L33:
        if (r105 <= 0) goto L38;
        Object[] r106 = {r110.f525978c};
        ParseErrorList r107 = this.f526067a.f526025b;
        if (r107.canAddError() == false) goto L38;
        r107.add(new c(this.f526068b, "Dropped duplicate attribute(s) in tag [%s]", r106));
        goto L38
    L15:
        boolean r108 = r103.f526023b;
        int r109 = 0;
        r105 = 0;
    L17:
        if (r109 >= r100.f525925b.length) goto L33;
        int r111 = r109 + 1;
        int r112 = r111;
    L19:
        String[] r113 = r100.f525925b;
        if (r112 >= r113.length) goto L32;
        String r114 = r113[r112];
        if (r114 == null) goto L32;
        if (r108 == true) goto L26;
    L27:
        if (r108 == true) goto L31;
        String[] r115 = r100.f525925b;
        if (r115[r109].equalsIgnoreCase(r115[r112]) == false) goto L31;
    L30:
        r105 = r105 + 1;
        r100.m(r112);
        r112 = r112 - 1;
    L31:
        r112 = r112 + 1;
        goto L19
    L26:
        if (r113[r109].equals(r114) == true) goto L30;
    L32:
        r109 = r111;
        goto L17
    L12:
        r104 = false;
        goto L13
    L7:
        r102 = false;
    L38:
        if (r110.f525986k == false) goto L41;
        Element r116 = x(r110);
        this.f526071e.add(r116);
        this.f526069c.p(TokeniserState.Data);
        h r117 = this.f526069c;
        Token.f r118 = this.f526013u;
        r118.p();
        r118.n(r116.f525906d.f526034a);
        r117.i(r118);
        return r116;
    L41:
        f r119 = g(r110.m(), this.f526074h);
        d r120 = this.f526074h;
        org.jsoup.nodes.b r121 = r110.f525987l;
        r120.a(r121);
        Element r122 = new Element(r119, null, r121);
        insert(r122, r110);
        return r122;
    }

    public final void k(String... r100) {
        int r101 = this.f526071e.size() - 1;
    L3:
        if (r101 < 0) goto L15;
        Element r102 = (Element) ListProtector.get(this.f526071e, r101);
        String r103 = r102.f525906d.f526035b;
        String[] r104 = fwc.b.f479045a;
        int r105 = r100.length;
        boolean r106 = false;
        int r107 = 0;
    L5:
        if (r107 >= r105) goto L10;
        if (r100[r107].equals(r103) == true) goto L8;
        r107 = r107 + 1;
        goto L5
    L8:
        r106 = true;
    L10:
        if (r106 == true) goto L21;
        if (r102.f525906d.f526035b.equals("html") == true) goto L22;
        ListProtector.remove(this.f526071e, r101);
        r101 = r101 - 1;
        goto L3
    L22:
        return;
    L21:
        return;
    }

    public final void m(HtmlTreeBuilderState r100) {
        if (this.f526067a.f526025b.canAddError() == false) goto L6;
        this.f526067a.f526025b.add(new c(this.f526068b, "Unexpected %s token [%s] when in state [%s]", new Object[]{this.f526073g.getClass().getSimpleName(), this.f526073g, r100}));
        return;
    }

    public final void n(String r100) {
    L3:
        if (fwc.b.c(a().f525906d.f526035b, E) == false) goto L9;
        if (r100 == null) goto L8;
        if (b(r100) == false) goto L8;
        return;
    L8:
        D();
        goto L3
    }

    public final void o(boolean r100) {
        if (r100 == false) goto L4;
        String[] r101 = F;
    L6:
        if (fwc.b.c(a().f525906d.f526035b, r101) == false) goto L8;
        D();
        goto L6
    L8:
        return;
    L4:
        r101 = E;
        goto L6
    }

    public final Element p(String r100) {
        int r101 = this.f526010r.size() - 1;
    L3:
        if (r101 < 0) goto L11;
        Element r102 = (Element) ListProtector.get(this.f526010r, r101);
        if (r102 == null) goto L16;
        if (r102.f525906d.f526035b.equals(r100) == true) goto L9;
        r101 = r101 - 1;
        goto L3
    L9:
        return r102;
    L16:
        return null;
    L11:
        return null;
    }

    @Nullable
    public final Element q(String r100) {
        int r101 = this.f526071e.size() - 1;
        if (r101 < 256) goto L5;
        int r102 = r101 - 256;
    L6:
        if (r101 < r102) goto L11;
        Element r103 = (Element) ListProtector.get(this.f526071e, r101);
        if (r103.f525906d.f526035b.equals(r100) == true) goto L9;
        r101 = r101 - 1;
        goto L6
    L9:
        return r103;
    L11:
        return null;
    L5:
        r102 = 0;
        goto L6
    }

    public final boolean r(String r100) {
        return s(r100, B);
    }

    public final boolean t(String r100) {
        int r101 = this.f526071e.size() - 1;
    L3:
        if (r101 < 0) goto L13;
        String r102 = ((Element) ListProtector.get(this.f526071e, r101)).f525906d.f526035b;
        if (r102.equals(r100) == true) goto L6;
        if (fwc.b.c(r102, D) == false) goto L9;
        r101 = r101 - 1;
        goto L3
    L9:
        return false;
    L6:
        return true;
    L13:
        throw new ValidationException("Should not be reachable");
    }

    public final boolean v(String r100) {
        String[] r101 = C;
        String[] r102 = this.f526017y;
        r102[0] = r100;
        return u(r102, r101, null);
    }

    public final Element x(Token.g r100) {
        f r101 = g(r100.m(), this.f526074h);
        d r102 = this.f526074h;
        org.jsoup.nodes.b r103 = r100.f525987l;
        r102.a(r103);
        Element r104 = new Element(r101, null, r103);
        A(r104);
        if (r100.f525986k == true) goto L5;
    L12:
        return r104;
    L5:
        if (((HashMap) f.f526027j).containsKey(r101.f526034a) == true) goto L7;
        r101.f526039f = true;
        goto L12
    L7:
        if (r101.f526038e == true) goto L12;
        h r105 = this.f526069c;
        Object[] r106 = {r101.f526035b};
        if (r105.f526048b.canAddError() == false) goto L12;
        r105.f526048b.add(new c(r105.f526047a, "Tag [%s] cannot be self closing; not a void tag", r106));
        goto L12
    }

    public final void z(j r100) {
        Element r101 = q(CopyContentTypeString.TABLE);
        if (r101 == null) goto L8;
        Element r102 = (Element) r101.f525933a;
        if (r102 == null) goto L7;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        ewc.b.d(r101);
        ewc.b.d(r100);
        ewc.b.d(r101.f525933a);
        r101.f525933a.b(r101.f525934b, new j[]{r100});
        return;
    L12:
        r102.G(r100);
        return;
    L7:
        r102 = h(r101);
    L9:
        r103 = false;
        goto L10
    L8:
        r102 = (Element) ListProtector.get(this.f526071e, 0);
        goto L9
    }

    public void insert(Token.b r100) {
        Element r101 = a();
        String r102 = r101.f525906d.f526035b;
        String r103 = r100.f525969b;
        if ((r100 instanceof Token.a) == false) goto L6;
        j r104 = new org.jsoup.nodes.c(r103);
    L15:
        r101.G(r104);
        return;
    L6:
        if (r102.equals("script") == false) goto L8;
    L11:
        boolean r105 = true;
    L12:
        if (r105 == false) goto L14;
        r104 = new org.jsoup.nodes.e(r103);
        goto L15
    L14:
        r104 = new m(r103);
        goto L15
    L8:
        if (r102.equals("style") == true) goto L11;
        r105 = false;
        goto L12
    }

    public void insert(Token.c r100) {
        String r101 = r100.f525971c;
        if (r101 != null) goto L6;
        r101 = r100.f525970b.toString();
    L6:
        A(new org.jsoup.nodes.d(r101));
    }

    public void insert(Element r100) {
        A(r100);
        this.f526071e.add(r100);
    }

    public static boolean C(ArrayList<Element> r100, Element r101) {
        int r102 = r100.size() - 1;
        if (r102 < 256) goto L5;
        int r103 = r102 - 256;
    L6:
        if (r102 < r103) goto L11;
        if (((Element) ListProtector.get(r100, r102)) == r101) goto L9;
        r102 = r102 - 1;
        goto L6
    L9:
        return true;
    L11:
        return false;
    L5:
        r103 = 0;
        goto L6
    }

    private void insert(Element r100, @Nullable Token r101) {
        A(r100);
        this.f526071e.add(r100);
    }

    public final boolean G(Token r100, HtmlTreeBuilderState r101) {
        this.f526073g = r100;
        return r101.process(r100, this);
    }

    public final boolean s(String r100, String[] r101) {
        String[] r102 = f526003z;
        String[] r103 = this.f526017y;
        r103[0] = r100;
        return u(r103, r102, r101);
    }

    public final boolean u(String[] r100, String[] r101, String[] r102) {
        int r103 = this.f526071e.size() - 1;
        if (r103 <= 100) goto L5;
        int r104 = r103 - 100;
    L6:
        if (r103 < r104) goto L18;
        String r105 = ((Element) ListProtector.get(this.f526071e, r103)).f525906d.f526035b;
        if (fwc.b.c(r105, r100) == true) goto L9;
        if (fwc.b.c(r105, r101) == true) goto L12;
        if (r102 == null) goto L17;
        if (fwc.b.c(r105, r102) == false) goto L17;
        return false;
    L17:
        r103 = r103 - 1;
        goto L6
    L12:
        return false;
    L9:
        return true;
    L18:
        return false;
    L5:
        r104 = 0;
        goto L6
    }

    @ParametersAreNonnullByDefault
    public final void w(Reader r100, String r101, e r102) {
        if (r101 == null) goto L18;
        ewc.b.d(r102);
        Document r103 = new Document(r101);
        this.f526070d = r103;
        r103.f525891l = r102;
        this.f526067a = r102;
        this.f526074h = r102.f526026c;
        a r104 = new a(r100, 32768);
        this.f526068b = r104;
        if (r102.f526025b.getMaxSize() <= 0) goto L7;
        boolean r105 = true;
    L9:
        if (r105 == true) goto L11;
    L13:
        if (r105 == true) goto L15;
        r104.f525998i = null;
    L15:
        this.f526073g = null;
        this.f526069c = new h(this.f526068b, r102.f526025b);
        this.f526071e = new ArrayList(32);
        this.f526075i = new HashMap();
        this.f526072f = r101;
        this.f526004l = HtmlTreeBuilderState.Initial;
        this.f526005m = null;
        this.f526006n = false;
        this.f526007o = null;
        this.f526008p = null;
        this.f526009q = null;
        this.f526010r = new ArrayList();
        this.f526011s = new ArrayList();
        this.f526012t = new ArrayList();
        this.f526013u = new Token.f();
        this.f526014v = true;
        this.f526015w = false;
        this.f526016x = false;
        return;
    L11:
        if (r104.f525998i != null) goto L13;
        r104.f525998i = new ArrayList(409);
        r104.x();
        goto L15
    L7:
        r105 = false;
        goto L9
    L18:
        throw new ValidationException(String.format("The parameter '%s' must not be null.", new Object[]{"baseUri"}));
    }

    public final void y(Token.g r100, boolean r101, boolean r102) {
        f r103 = g(r100.m(), this.f526074h);
        d r104 = this.f526074h;
        org.jsoup.nodes.b r105 = r100.f525987l;
        r104.a(r105);
        org.jsoup.nodes.h r106 = new org.jsoup.nodes.h(r103, r105);
        if (r102 == true) goto L5;
        this.f526008p = r106;
    L8:
        A(r106);
        if (r101 == false) goto L12;
        this.f526071e.add(r106);
        return;
    L12:
        return;
    L5:
        if (B(ThumbGlideUrl.SOURCE_TEMPLATE) == true) goto L8;
        this.f526008p = r106;
        goto L8
    }
}
