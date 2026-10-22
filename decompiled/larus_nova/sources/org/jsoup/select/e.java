package org.jsoup.select;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.helper.ValidationException;
import org.jsoup.parser.g;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes42.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f526107d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f526108e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f526109f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f526110g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f526111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f526112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<c> f526113c;

    static {
        f526107d = new String[]{",", ">", Marker.ANY_NON_NULL_MARKER, Constants.WAVE_SEPARATOR, " "};
        f526108e = new String[]{ContainerUtils.KEY_VALUE_DELIMITER, "!=", "^=", "$=", "*=", "~="};
        f526109f = PatternProtector.compile("(([+-])?(\\d+)?)n(\\s*([+-])?\\s*\\d+)?", 2);
        f526110g = PatternProtector.compile("([+-])?(\\d+)");
    }

    public final int b() {
        String r100 = this.f526111a.b().trim();
        String[] r101 = fwc.b.f479045a;
        boolean r102 = false;
        if (r100 != null) goto L5;
    L14:
        if (r102 == false) goto L18;
        return CastIntegerProtector.parseInt(r100);
    L18:
        throw new ValidationException("Index must be numeric");
    L5:
        if (r100.length() == 0) goto L14;
        int r103 = r100.length();
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L13;
        if (Character.isDigit(r100.codePointAt(r104)) == false) goto L14;
        r104 = r104 + 1;
        goto L8
    L13:
        r102 = true;
        goto L14
    }

    public final void f() {
        if (this.f526111a.h("#") == false) goto L6;
        String r100 = this.f526111a.e();
        ewc.b.b(r100);
        ((ArrayList) this.f526113c).add(new c.r(r100));
        return;
    L6:
        if (this.f526111a.h(".") == false) goto L9;
        String r101 = this.f526111a.e();
        ewc.b.b(r101);
        ((ArrayList) this.f526113c).add(new c.k(r101.trim()));
        return;
    L9:
        if (this.f526111a.k() == false) goto L11;
    L133:
        g r102 = this.f526111a;
        int r103 = r102.f526044b;
    L135:
        if (r102.g() == true) goto L141;
        if (r102.k() == true) goto L140;
        if (r102.j(new String[]{"*|", HiAnalyticsConstant.REPORT_VAL_SEPARATOR, "_", "-"}) == false) goto L141;
    L140:
        r102.f526044b++;
    L141:
        String r104 = fwc.a.b(r102.f526043a.substring(r103, r102.f526044b));
        ewc.b.b(r104);
        if (r104.startsWith("*|") == false) goto L145;
        String r105 = r104.substring(2);
        ((ArrayList) this.f526113c).add(new b.C7095b(new c[]{new c.n0(r105), new c.o0(r104.replace("*|", ":"))}));
        return;
    L145:
        if (r104.contains(HiAnalyticsConstant.REPORT_VAL_SEPARATOR) == false) goto L147;
        r104 = r104.replace(HiAnalyticsConstant.REPORT_VAL_SEPARATOR, ":");
    L147:
        ((ArrayList) this.f526113c).add(new c.n0(r104));
        return;
    L11:
        if (this.f526111a.i("*|") == true) goto L133;
        if (this.f526111a.i("[") == false) goto L48;
        g r106 = new g(this.f526111a.a('[', ']'));
        String[] r107 = f526108e;
        int r108 = r106.f526044b;
    L17:
        if (r106.g() == true) goto L21;
        if (r106.j(r107) == true) goto L21;
        r106.f526044b++;
    L21:
        String r109 = r106.f526043a.substring(r108, r106.f526044b);
        ewc.b.b(r109);
        r106.f();
        if (r106.g() == false) goto L28;
        if (r109.startsWith("^") == false) goto L26;
        ((ArrayList) this.f526113c).add(new c.d(r109.substring(1)));
        return;
    L26:
        ((ArrayList) this.f526113c).add(new c.b(r109));
        return;
    L28:
        if (r106.h(ContainerUtils.KEY_VALUE_DELIMITER) == false) goto L31;
        ((ArrayList) this.f526113c).add(new c.e(r109, r106.l()));
        return;
    L31:
        if (r106.h("!=") == false) goto L34;
        ((ArrayList) this.f526113c).add(new c.i(r109, r106.l()));
        return;
    L34:
        if (r106.h("^=") == false) goto L37;
        ((ArrayList) this.f526113c).add(new c.j(r109, r106.l()));
        return;
    L37:
        if (r106.h("$=") == false) goto L40;
        ((ArrayList) this.f526113c).add(new c.g(r109, r106.l()));
        return;
    L40:
        if (r106.h("*=") == false) goto L43;
        ((ArrayList) this.f526113c).add(new c.f(r109, r106.l()));
        return;
    L43:
        if (r106.h("~=") == false) goto L46;
        ((ArrayList) this.f526113c).add(new c.h(r109, PatternProtector.compile(r106.l())));
        return;
    L46:
        throw new Selector.SelectorParseException("Could not parse attribute query '%s': unexpected token at '%s'", new Object[]{this.f526112b, r106.l()});
    L48:
        if (this.f526111a.h("*") == false) goto L51;
        ((ArrayList) this.f526113c).add(new c.a());
        return;
    L51:
        if (this.f526111a.h(":lt(") == false) goto L54;
        ((ArrayList) this.f526113c).add(new c.v(b()));
        return;
    L54:
        if (this.f526111a.h(":gt(") == false) goto L57;
        ((ArrayList) this.f526113c).add(new c.u(b()));
        return;
    L57:
        if (this.f526111a.h(":eq(") == false) goto L60;
        ((ArrayList) this.f526113c).add(new c.s(b()));
        return;
    L60:
        if (this.f526111a.i(":has(") == false) goto L63;
        this.f526111a.d(":has");
        String r110 = this.f526111a.a('(', ')');
        ewc.b.c(r110, ":has(selector) sub-select must not be empty");
        ((ArrayList) this.f526113c).add(new f.a(j(r110)));
        return;
    L63:
        if (this.f526111a.i(":contains(") == false) goto L66;
        c(false);
        return;
    L66:
        if (this.f526111a.i(":containsOwn(") == false) goto L69;
        c(true);
        return;
    L69:
        if (this.f526111a.i(":containsWholeText(") == false) goto L72;
        d(false);
        return;
    L72:
        if (this.f526111a.i(":containsWholeOwnText(") == false) goto L75;
        d(true);
        return;
    L75:
        if (this.f526111a.i(":containsData(") == false) goto L78;
        this.f526111a.d(":containsData");
        String r111 = g.m(this.f526111a.a('(', ')'));
        ewc.b.c(r111, ":containsData(text) query must not be empty");
        ((ArrayList) this.f526113c).add(new c.l(r111));
        return;
    L78:
        if (this.f526111a.i(":matches(") == false) goto L81;
        g(false);
        return;
    L81:
        if (this.f526111a.i(":matchesOwn(") == false) goto L84;
        g(true);
        return;
    L84:
        if (this.f526111a.i(":matchesWholeText(") == false) goto L87;
        h(false);
        return;
    L87:
        if (this.f526111a.i(":matchesWholeOwnText(") == false) goto L90;
        h(true);
        return;
    L90:
        if (this.f526111a.i(":not(") == false) goto L93;
        this.f526111a.d(":not");
        String r112 = this.f526111a.a('(', ')');
        ewc.b.c(r112, ":not(selector) subselect must not be empty");
        ((ArrayList) this.f526113c).add(new f.d(j(r112)));
        return;
    L93:
        if (this.f526111a.h(":nth-child(") == false) goto L96;
        e(false, false);
        return;
    L96:
        if (this.f526111a.h(":nth-last-child(") == false) goto L99;
        e(true, false);
        return;
    L99:
        if (this.f526111a.h(":nth-of-type(") == false) goto L102;
        e(false, true);
        return;
    L102:
        if (this.f526111a.h(":nth-last-of-type(") == false) goto L105;
        e(true, true);
        return;
    L105:
        if (this.f526111a.h(":first-child") == false) goto L108;
        ((ArrayList) this.f526113c).add(new c.x());
        return;
    L108:
        if (this.f526111a.h(":last-child") == false) goto L111;
        ((ArrayList) this.f526113c).add(new c.z());
        return;
    L111:
        if (this.f526111a.h(":first-of-type") == false) goto L114;
        ((ArrayList) this.f526113c).add(new c.y());
        return;
    L114:
        if (this.f526111a.h(":last-of-type") == false) goto L117;
        ((ArrayList) this.f526113c).add(new c.a0());
        return;
    L117:
        if (this.f526111a.h(":only-child") == false) goto L120;
        ((ArrayList) this.f526113c).add(new c.f0());
        return;
    L120:
        if (this.f526111a.h(":only-of-type") == false) goto L123;
        ((ArrayList) this.f526113c).add(new c.g0());
        return;
    L123:
        if (this.f526111a.h(":empty") == false) goto L126;
        ((ArrayList) this.f526113c).add(new c.w());
        return;
    L126:
        if (this.f526111a.h(":root") == false) goto L129;
        ((ArrayList) this.f526113c).add(new c.h0());
        return;
    L129:
        if (this.f526111a.h(":matchText") == false) goto L132;
        ((ArrayList) this.f526113c).add(new c.i0());
        return;
    L132:
        throw new Selector.SelectorParseException("Could not parse query '%s': unexpected token at '%s'", new Object[]{this.f526112b, this.f526111a.l()});
    }

    public final c i() {
        this.f526111a.f();
        g r100 = this.f526111a;
        String[] r101 = f526107d;
        if (r100.j(r101) == false) goto L5;
        List<c> r102 = this.f526113c;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new f.g());
        a(this.f526111a.c());
    L7:
        if (this.f526111a.g() == true) goto L15;
        boolean r104 = this.f526111a.f();
        if (this.f526111a.j(r101) == true) goto L10;
        if (r104 == true) goto L12;
        f();
        goto L7
    L12:
        a(' ');
        goto L7
    L10:
        a(this.f526111a.c());
        goto L7
    L15:
        if (((ArrayList) this.f526113c).size() != 1) goto L19;
        return (c) ListProtector.get(this.f526113c, 0);
    L19:
        return new b.a(this.f526113c);
    L5:
        f();
        goto L7
    }

    public final String toString() {
        return this.f526112b;
    }

    public e(String r100) {
        this.f526113c = new ArrayList();
        ewc.b.b(r100);
        String r101 = r100.trim();
        this.f526112b = r101;
        this.f526111a = new g(r101);
    }

    public static c j(String r100) {
        return new e(r100).i();
    L4:
        e = move-exception;
        throw new Selector.SelectorParseException(e.getMessage());
    }

    public final void a(char r110) {
        this.f526111a.f();
        StringBuilder r100 = fwc.b.b();
    L4:
        if (this.f526111a.g() == true) goto L18;
        if (this.f526111a.i("(") == true) goto L7;
        if (this.f526111a.i("[") == true) goto L10;
        if (this.f526111a.j(f526107d) == true) goto L14;
        r100.append(this.f526111a.c());
        goto L4
    L14:
        if (r100.length() > 0) goto L18;
        this.f526111a.c();
        goto L4
    L10:
        r100.append("[");
        r100.append(this.f526111a.a('[', ']'));
        r100.append("]");
        goto L4
    L7:
        r100.append("(");
        r100.append(this.f526111a.a('(', ')'));
        r100.append(")");
    L18:
        c r101 = j(fwc.b.g(r100));
        if (((ArrayList) this.f526113c).size() != 1) goto L28;
        c r102 = (c) ListProtector.get(this.f526113c, 0);
        if ((r102 instanceof b.C7095b) == false) goto L29;
        if (r110 == ',') goto L29;
        b.C7095b r103 = (b.C7095b) r102;
        int r104 = r103.f526083b;
        if (r104 <= 0) goto L26;
        c r105 = (c) ListProtector.get(r103.f526082a, r104 - 1);
    L27:
        boolean r106 = true;
    L30:
        ((ArrayList) this.f526113c).clear();
        if (r110 != ' ') goto L33;
        b.a r111 = new b.a(new c[]{new f.e(r105), r101});
    L50:
        b r107 = r111;
    L51:
        if (r106 == false) goto L53;
        b.C7095b r112 = (b.C7095b) r102;
        ListProtector.set(r112.f526082a, r112.f526083b - 1, r107);
    L54:
        ((ArrayList) this.f526113c).add(r102);
        return;
    L53:
        r102 = r107;
        goto L54
    L33:
        if (r110 != '>') goto L35;
        r111 = new b.a(new c[]{new f.b(r105), r101});
        goto L50
    L35:
        if (r110 != '~') goto L37;
        r111 = new b.a(new c[]{new f.C7097f(r105), r101});
        goto L50
    L37:
        if (r110 == '+') goto L46;
        if (r110 != ',') goto L45;
        if ((r105 instanceof b.C7095b) == false) goto L42;
        r107 = (b.C7095b) r105;
    L43:
        r107.f526082a.add(r101);
        r107.f526083b = r107.f526082a.size();
        goto L51
    L42:
        b.C7095b r113 = new b.C7095b();
        r113.f526082a.add(r105);
        r113.f526083b = r113.f526082a.size();
        r107 = r113;
        goto L43
    L45:
        throw new Selector.SelectorParseException("Unknown combinator '%s'", new Object[]{Character.valueOf(r110)});
    L46:
        r111 = new b.a(new c[]{new f.c(r105), r101});
        goto L50
    L26:
        r105 = null;
    L29:
        r105 = r102;
        r106 = false;
        goto L30
    L28:
        r102 = new b.a(this.f526113c);
        goto L29
    }

    public final void c(boolean r100) {
        if (r100 == false) goto L4;
        String r101 = ":containsOwn";
    L5:
        this.f526111a.d(r101);
        String r102 = g.m(this.f526111a.a('(', ')'));
        ewc.b.c(r102, r101.concat("(text) query must not be empty"));
        List<c> r103 = this.f526113c;
        if (r100 == false) goto L8;
        Object r104 = new c.m(r102);
    L9:
        ((ArrayList) r103).add(r104);
        return;
    L8:
        r104 = new c.n(r102);
        goto L9
    L4:
        r101 = ":contains";
        goto L5
    }

    public final void d(boolean r100) {
        if (r100 == false) goto L4;
        String r101 = ":containsWholeOwnText";
    L5:
        this.f526111a.d(r101);
        String r102 = g.m(this.f526111a.a('(', ')'));
        ewc.b.c(r102, r101.concat("(text) query must not be empty"));
        List<c> r103 = this.f526113c;
        if (r100 == false) goto L8;
        Object r104 = new c.o(r102);
    L9:
        ((ArrayList) r103).add(r104);
        return;
    L8:
        r104 = new c.p(r102);
        goto L9
    L4:
        r101 = ":containsWholeText";
        goto L5
    }

    public final void g(boolean r100) {
        if (r100 == false) goto L4;
        String r101 = ":matchesOwn";
    L5:
        this.f526111a.d(r101);
        String r102 = this.f526111a.a('(', ')');
        ewc.b.c(r102, r101.concat("(regex) query must not be empty"));
        List<c> r103 = this.f526113c;
        if (r100 == false) goto L8;
        Object r104 = new c.k0(PatternProtector.compile(r102));
    L9:
        ((ArrayList) r103).add(r104);
        return;
    L8:
        r104 = new c.j0(PatternProtector.compile(r102));
        goto L9
    L4:
        r101 = ":matches";
        goto L5
    }

    public final void h(boolean r100) {
        if (r100 == false) goto L4;
        String r101 = ":matchesWholeOwnText";
    L5:
        this.f526111a.d(r101);
        String r102 = this.f526111a.a('(', ')');
        ewc.b.c(r102, r101.concat("(regex) query must not be empty"));
        List<c> r103 = this.f526113c;
        if (r100 == false) goto L8;
        Object r104 = new c.l0(PatternProtector.compile(r102));
    L9:
        ((ArrayList) r103).add(r104);
        return;
    L8:
        r104 = new c.m0(PatternProtector.compile(r102));
        goto L9
    L4:
        r101 = ":matchesWholeText";
        goto L5
    }

    public final void e(boolean r100, boolean r110) {
        String r101 = fwc.a.b(this.f526111a.b());
        Matcher r102 = f526109f.matcher(r101);
        Matcher r103 = f526110g.matcher(r101);
        int r104 = 2;
        int r105 = 1;
        if ("odd".equals(r101) == false) goto L6;
    L22:
        if (r110 == false) goto L26;
        if (r100 == false) goto L25;
        ((ArrayList) this.f526113c).add(new c.d0(r104, r105));
        return;
    L25:
        ((ArrayList) this.f526113c).add(new c.e0(r104, r105));
        return;
    L26:
        if (r100 == false) goto L28;
        ((ArrayList) this.f526113c).add(new c.c0(r104, r105));
        return;
    L28:
        ((ArrayList) this.f526113c).add(new c.b0(r104, r105));
        return;
    L6:
        if ("even".equals(r101) == false) goto L9;
        r105 = 0;
        goto L22
    L9:
        if (r102.matches() == false) goto L20;
        if (r102.group(3) == null) goto L13;
        int r106 = CastIntegerProtector.parseInt(r102.group(1).replaceFirst("^\\+", ""));
    L15:
        if (r102.group(4) == null) goto L17;
        r105 = CastIntegerProtector.parseInt(r102.group(4).replaceFirst("^\\+", ""));
    L18:
        r104 = r106;
        goto L22
    L17:
        r105 = 0;
        goto L18
    L13:
        r106 = 1;
        goto L15
    L20:
        if (r103.matches() == false) goto L31;
        r105 = CastIntegerProtector.parseInt(r103.group().replaceFirst("^\\+", ""));
        r104 = 0;
        goto L22
    L31:
        throw new Selector.SelectorParseException("Could not parse nth-index '%s': unexpected format", new Object[]{r101});
    }
}
