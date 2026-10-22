package org.commonmark.internal;

import androidx.core.net.MailTo;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.commonmark.node.Code;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Image;
import org.commonmark.node.Link;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes42.dex */
public final class n implements vvc.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Pattern f525720i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f525721j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f525722k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f525723l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Pattern f525724m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Pattern f525725n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Pattern f525726o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Pattern f525727p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Pattern f525728q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Pattern f525729r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Pattern f525730s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Pattern f525731t = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitSet f525732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BitSet f525733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Character, xvc.a> f525734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vvc.b f525735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f525736e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f525737f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f525738g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e f525739h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f525740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f525741b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f525742c;

        public a(int r100, boolean r101, boolean r102) {
            this.f525740a = r100;
            this.f525742c = r101;
            this.f525741b = r102;
        }
    }

    static {
        f525720i = PatternProtector.compile("^[!\"#\\$%&'\\(\\)\\*\\+,\\-\\./:;<=>\\?@\\[\\\\\\]\\^_`\\{\\|\\}~\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]");
        f525721j = PatternProtector.compile("^(?:<[A-Za-z][A-Za-z0-9-_]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-_]*\\s*[>]|<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->|[<][?].*?[?][>]|<![A-Z]+\\s+[^>]*>|<!\\[CDATA\\[[\\s\\S]*?\\]\\]>)", 2);
        f525722k = PatternProtector.compile("^[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]");
        f525723l = PatternProtector.compile("^&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);
        f525724m = PatternProtector.compile("`+");
        f525725n = PatternProtector.compile("^`+");
        f525726o = PatternProtector.compile("^<([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)>");
        f525727p = PatternProtector.compile("^<[a-zA-Z][a-zA-Z0-9.+-]{1,31}:[^<>\u0000- ]*>");
        f525728q = PatternProtector.compile("^ *(?:\n *)?");
        f525729r = PatternProtector.compile("^[\\p{Zs}\t\r\n\f]");
        f525730s = PatternProtector.compile("\\s+");
        f525731t = PatternProtector.compile(" *$");
    }

    public final char g() {
        if (this.f525737f < this.f525736e.length()) goto L5;
        return 0;
    L5:
        return this.f525736e.charAt(this.f525737f);
    }

    public n(m r100) {
        List<xvc.a> r101 = r100.f525718a;
        HashMap r102 = new HashMap();
        c(Arrays.asList(new xvc.a[]{new svc.a(), new svc.c()}), r102);
        c(r101, r102);
        this.f525734c = r102;
        Set r103 = r102.keySet();
        BitSet r104 = new BitSet();
        Iterator r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        r104.set(((Character) r105.next()).charValue());
        goto L4
    L6:
        this.f525733b = r104;
        BitSet r106 = new BitSet();
        r106.or(r104);
        r106.set(10);
        r106.set(96);
        r106.set(91);
        r106.set(93);
        r106.set(92);
        r106.set(33);
        r106.set(60);
        r106.set(38);
        this.f525732a = r106;
        this.f525735d = r100;
    }

    public final String d(Pattern r100) {
        if (this.f525737f < this.f525736e.length()) goto L5;
        return null;
    L5:
        Matcher r101 = r100.matcher(this.f525736e);
        r101.region(this.f525737f, this.f525736e.length());
        if (r101.find() == false) goto L9;
        this.f525737f = r101.end();
        return r101.group();
    L9:
        return null;
    }

    public final void h(f r110) {
        HashMap r100 = new HashMap();
        f r101 = this.f525738g;
    L3:
        if (r101 == null) goto L7;
        f r102 = r101.f525683e;
        if (r102 == r110) goto L7;
        r101 = r102;
    L7:
        if (r101 == null) goto L48;
        char r103 = r101.f525680b;
        xvc.a r104 = (xvc.a) ((HashMap) this.f525734c).get(Character.valueOf(r103));
        if (r101.f525682d == false) goto L47;
        if (r104 == null) goto L47;
        char r105 = r104.c();
        f r106 = r101.f525683e;
        boolean r107 = false;
        int r108 = 0;
    L13:
        if (r106 == null) goto L25;
        if (r106 == r110) goto L25;
        if (r106 == r100.get(Character.valueOf(r103))) goto L25;
        if (r106.f525681c == false) goto L24;
        if (r106.f525680b != r105) goto L24;
        r108 = r104.d(r106, r101);
        r107 = true;
        if (r108 <= 0) goto L24;
        boolean r109 = true;
    L26:
        if (r107 == false) goto L27;
        Text r111 = r106.f525679a;
        Text r112 = r101.f525679a;
        r106.f525685g -= r108;
        r101.f525685g -= r108;
        String r113 = r111.f525783h;
        r111.f525783h = r113.substring(0, r113.length() - r108);
        String r114 = r112.f525783h;
        r112.f525783h = r114.substring(0, r114.length() - r108);
        f r115 = r101.f525683e;
    L33:
        if (r115 == null) goto L36;
        if (r115 == r106) goto L36;
        f r116 = r115.f525683e;
        i(r115);
        r115 = r116;
    L36:
        if (r111 == r112) goto L41;
        uvc.b r117 = r111.f551904e;
        if (r117 == r112) goto L41;
        f(r117, r112.f551903d);
    L41:
        r104.e(r111, r112, r108);
        if (r106.f525685g != 0) goto L45;
        r106.f525679a.g();
        i(r106);
    L45:
        if (r101.f525685g != 0) goto L7;
        f r118 = r101.f525684f;
        r101.f525679a.g();
        i(r101);
        r101 = r118;
        goto L7
    L27:
        if (r109 == true) goto L31;
        r100.put(Character.valueOf(r103), r101.f525683e);
        if (r101.f525681c == true) goto L31;
        i(r101);
    L31:
        r101 = r101.f525684f;
    L24:
        r106 = r106.f525683e;
    L25:
        r109 = r107;
        r107 = false;
    L47:
        r101 = r101.f525684f;
    L48:
        f r119 = this.f525738g;
        if (r119 == null) goto L52;
        if (r119 == r110) goto L79;
        i(r119);
        goto L48
    L79:
        return;
    }

    public final void i(f r100) {
        f r101 = r100.f525683e;
        if (r101 == null) goto L5;
        r101.f525684f = r100.f525684f;
    L5:
        f r102 = r100.f525684f;
        if (r102 != null) goto L8;
        this.f525738g = r101;
        return;
    L8:
        r102.f525683e = r101;
    }

    public static void c(Iterable<xvc.a> r100, Map<Character, xvc.a> r101) {
        Iterator<xvc.a> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L18;
        xvc.a r103 = r102.next();
        char r104 = r103.c();
        char r105 = r103.b();
        if (r104 == r105) goto L7;
        b(r104, r103, r101);
        b(r105, r103, r101);
        goto L4
    L7:
        HashMap r106 = (HashMap) r101;
        xvc.a r107 = (xvc.a) r106.get(Character.valueOf(r104));
        if (r107 == null) goto L16;
        if (r107.c() != r107.b()) goto L16;
        if ((r107 instanceof r) == false) goto L14;
        r r108 = (r) r107;
    L15:
        r108.f(r103);
        r106.put(Character.valueOf(r104), r108);
        goto L4
    L14:
        r r109 = new r(r104);
        r109.f(r107);
        r108 = r109;
    L16:
        b(r104, r103, r101);
        goto L4
    }

    public static void f(uvc.b r100, uvc.b r101) {
        Text r102 = null;
        Text r103 = null;
        int r104 = 0;
    L3:
        if (r100 == null) goto L14;
        if ((r100 instanceof Text) == false) goto L10;
        r103 = (Text) r100;
        if (r102 != null) goto L9;
        r102 = r103;
    L9:
        r104 = r104 + r103.f525783h.length();
    L11:
        if (r100 == r101) goto L14;
        r100 = r100.f551904e;
        goto L3
    L10:
        e(r102, r103, r104);
        r102 = null;
        r103 = null;
        r104 = 0;
    L14:
        e(r102, r103, r104);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r24v0, types: [uvc.b] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v70, types: [uvc.b] */
    /* JADX WARN: Type inference failed for: r4v71 */
    /* JADX WARN: Type inference failed for: r4v72 */
    /* JADX WARN: Type inference failed for: r4v73 */
    @Override // vvc.a
    public final void a(String r210, uvc.b r211) {
        this.f525736e = r210.trim();
        this.f525737f = 0;
        Object r100 = null;
        this.f525738g = null;
        this.f525739h = null;
        ?? r101 = 0;
    L3:
        char r110 = g();
        if (r110 != 0) goto L7;
        ?? r102 = r100;
    L248:
        if (r102 == 0) goto L250;
        r211.b(r102);
        r100 = null;
        r101 = r102;
        goto L3
    L250:
        h(null);
        uvc.b r103 = r211.f551901b;
        uvc.b r104 = r211.f551902c;
        if (r103 == r104) goto L266;
        f(r103, r104);
        return;
    L266:
        return;
    L7:
        if (r110 != '\n') goto L9;
        this.f525737f++;
        if ((r101 instanceof Text) == false) goto L243;
        Text r105 = (Text) r101;
        if (r105.f525783h.endsWith(" ") == false) goto L243;
        String r106 = r105.f525783h;
        Matcher r107 = f525731t.matcher(r106);
        if (r107.find() == false) goto L235;
        int r108 = r107.end() - r107.start();
    L236:
        if (r108 <= 0) goto L240;
        r105.f525783h = r106.substring(0, r106.length() - r108);
    L240:
        if (r108 < 2) goto L242;
        uvc.b r109 = new HardLineBreak();
    L244:
        r102 = r109;
    L245:
        if (r102 != 0) goto L248;
        this.f525737f++;
        r102 = new Text(String.valueOf(r110));
        goto L248
    L242:
        r109 = new SoftLineBreak();
        goto L244
    L235:
        r108 = 0;
    L243:
        r109 = new SoftLineBreak();
        goto L244
    L9:
        if (r110 != '!') goto L11;
        int r111 = this.f525737f + 1;
        this.f525737f = r111;
        if (g() != '[') goto L227;
        this.f525737f++;
        Text r112 = new Text("![");
        e r113 = this.f525739h;
        e r114 = new e(r112, r111, r113, this.f525738g, true);
        if (r113 == null) goto L224;
        r113.f525678g = true;
    L224:
        this.f525739h = r114;
        uvc.b r115 = r112;
    L225:
        uvc.b r116 = r115;
    L226:
        r102 = r116;
        goto L245
    L227:
        r116 = new Text("!");
        goto L226
    L11:
        if (r110 != '&') goto L13;
        String r117 = d(f525723l);
        if (r117 == null) goto L218;
        r115 = new Text(tvc.b.a(r117));
    L218:
        r116 = null;
        goto L226
    L13:
        if (r110 != '<') goto L15;
        String r118 = d(f525726o);
        if (r118 == null) goto L206;
        String r119 = r118.substring(1, r118.length() - 1);
        uvc.b r120 = new Link(MailTo.MAILTO_SCHEME + r119, null);
        r120.b(new Text(r119));
    L209:
        r116 = r120;
    L211:
        if (r116 != null) goto L226;
        String r121 = d(f525721j);
        if (r121 == null) goto L218;
        HtmlInline r122 = new HtmlInline();
        r122.f525769h = r121;
        r115 = r122;
        goto L225
    L206:
        String r123 = d(f525727p);
        if (r123 == null) goto L210;
        String r124 = r123.substring(1, r123.length() - 1);
        r120 = new Link(r124, null);
        r120.b(new Text(r124));
        goto L209
    L210:
        r116 = null;
        goto L211
    L15:
        if (r110 == '`') goto L180;
        switch(r110) {
            case 91: goto L109;
            case 92: goto L100;
            case 93: goto L20;
            default: goto L18;
        };
    L20:
        int r125 = this.f525737f + 1;
        this.f525737f = r125;
        e r126 = this.f525739h;
        if (r126 != null) goto L24;
        r116 = new Text("]");
        goto L226
    L24:
        if (r126.f525677f == true) goto L27;
        this.f525739h = r126.f525675d;
        r116 = new Text("]");
        goto L226
    L27:
        if (g() != '(') goto L49;
        this.f525737f++;
        Pattern r127 = f525728q;
        d(r127);
        int r128 = tvc.c.a(this.f525736e, this.f525737f);
        if (r128 != (-1)) goto L32;
        String r129 = null;
    L36:
        if (r129 == null) goto L50;
        d(r127);
        Pattern r130 = f525730s;
        String r131 = this.f525736e;
        int r132 = this.f525737f;
        if (r130.matcher(r131.substring(r132 - 1, r132)).matches() == false) goto L44;
        int r133 = tvc.c.c(this.f525736e, this.f525737f);
        if (r133 != (-1)) goto L42;
        String r134 = null;
    L43:
        d(r127);
    L46:
        if (g() != ')') goto L48;
        this.f525737f++;
        boolean r135 = true;
    L52:
        if (r135 == true) goto L80;
        int r136 = this.f525737f;
        if (r136 < this.f525736e.length()) goto L56;
    L69:
        int r137 = this.f525737f - r136;
        if (r137 <= 2) goto L73;
        String r138 = this.f525736e.substring(r136, r137 + r136);
    L76:
        if (r138 == null) goto L80;
        Pattern r139 = tvc.a.f547710a;
        LinkReferenceDefinition r140 = ((m) this.f525735d).f525719b.get(tvc.a.f547712c.matcher(r138.substring(1, r138.length() - 1).trim().toLowerCase(Locale.ROOT)).replaceAll(" "));
        if (r140 == null) goto L80;
        r129 = r140.f525776i;
        r134 = r140.f525777j;
        r135 = true;
        goto L80
    L73:
        if (r126.f525678g == true) goto L75;
        r138 = this.f525736e.substring(r126.f525673b, r125);
        goto L76
    L75:
        r138 = null;
        goto L76
    L56:
        if (this.f525736e.charAt(this.f525737f) != '[') goto L69;
        int r141 = this.f525737f + 1;
        int r142 = tvc.c.b(this.f525736e, r141);
        int r143 = r142 - r141;
        if (r142 == (-1)) goto L69;
        if (r143 > 999) goto L69;
        if (r142 >= this.f525736e.length()) goto L69;
        if (this.f525736e.charAt(r142) != ']') goto L69;
        this.f525737f = r142 + 1;
    L80:
        if (r135 == true) goto L82;
        this.f525737f = r125;
        this.f525739h = this.f525739h.f525675d;
        r116 = new Text("]");
        goto L226
    L82:
        if (r126.f525674c == false) goto L84;
        r116 = new Image(r129, r134);
    L85:
        uvc.b r144 = r126.f525672a.f551904e;
    L86:
        if (r144 == null) goto L88;
        uvc.b r145 = r144.f551904e;
        r116.b(r144);
        r144 = r145;
        goto L86
    L88:
        h(r126.f525676e);
        uvc.b r146 = r116.f551901b;
        uvc.b r147 = r116.f551902c;
        if (r146 == r147) goto L92;
        f(r146, r147);
    L92:
        r126.f525672a.g();
        e r148 = this.f525739h.f525675d;
        this.f525739h = r148;
        if (r126.f525674c == true) goto L226;
    L94:
        if (r148 == null) goto L226;
        if (r148.f525674c == true) goto L98;
        r148.f525677f = false;
    L98:
        r148 = r148.f525675d;
        goto L94
    L84:
        r116 = new Link(r129, r134);
        goto L85
    L48:
        this.f525737f = r125;
    L51:
        r135 = false;
        goto L52
    L42:
        String r149 = this.f525736e.substring(this.f525737f + 1, r133 - 1);
        this.f525737f = r133;
        r134 = tvc.a.a(r149);
        goto L43
    L44:
        r134 = null;
    L50:
        r134 = null;
        goto L51
    L32:
        if (g() != '<') goto L34;
        String r150 = this.f525736e.substring(this.f525737f + 1, r128 - 1);
    L35:
        this.f525737f = r128;
        r129 = tvc.a.a(r150);
        goto L36
    L34:
        r150 = this.f525736e.substring(this.f525737f, r128);
        goto L35
    L49:
        r129 = null;
        goto L50
    L100:
        this.f525737f++;
        if (g() != '\n') goto L104;
        r116 = new HardLineBreak();
        this.f525737f++;
        goto L226
    L104:
        if (this.f525737f >= this.f525736e.length()) goto L108;
        Pattern r151 = f525722k;
        String r152 = this.f525736e;
        int r153 = this.f525737f;
        if (r151.matcher(r152.substring(r153, r153 + 1)).matches() == false) goto L108;
        String r154 = this.f525736e;
        int r155 = this.f525737f;
        uvc.b r156 = new Text(r154.substring(r155, r155 + 1));
        this.f525737f++;
    L179:
        r116 = r156;
    L108:
        r116 = new Text("\\");
        goto L226
    L109:
        int r157 = this.f525737f;
        this.f525737f = r157 + 1;
        Text r158 = new Text("[");
        e r159 = this.f525739h;
        e r160 = new e(r158, r157, r159, this.f525738g, false);
        if (r159 == null) goto L112;
        r159.f525678g = true;
    L112:
        this.f525739h = r160;
        r116 = r158;
        goto L226
    L18:
        if (this.f525733b.get(r110) == false) goto L169;
        xvc.a r161 = (xvc.a) ((HashMap) this.f525734c).get(Character.valueOf(r110));
        int r162 = this.f525737f;
        int r163 = 0;
    L114:
        if (g() != r110) goto L117;
        r163 = r163 + 1;
        this.f525737f++;
        goto L114
    L117:
        if (r163 >= r161.a()) goto L119;
        this.f525737f = r162;
        a r164 = null;
    L164:
        if (r164 == null) goto L218;
        int r165 = r164.f525740a;
        int r166 = this.f525737f;
        int r167 = r166 + r165;
        this.f525737f = r167;
        Text r168 = new Text(this.f525736e.substring(r166, r167));
        f r169 = new f(r168, r110, r164.f525742c, r164.f525741b, this.f525738g);
        this.f525738g = r169;
        r169.f525685g = r165;
        r169.f525686h = r165;
        f r170 = r169.f525683e;
        uvc.b r171 = r168;
        if (r170 == null) goto L201;
        r170.f525684f = r169;
        r171 = r168;
    L201:
        r116 = r171;
        goto L226
    L119:
        String r172 = "\n";
        if (r162 != 0) goto L122;
        String r173 = "\n";
    L123:
        char r174 = g();
        if (r174 == 0) goto L127;
        r172 = String.valueOf(r174);
    L127:
        Pattern r175 = f525720i;
        boolean r176 = r175.matcher(r173).matches();
        Pattern r177 = f525729r;
        boolean r178 = r177.matcher(r173).matches();
        boolean r179 = r175.matcher(r172).matches();
        boolean r180 = r177.matcher(r172).matches();
        if (r180 == true) goto L133;
        if (r179 == false) goto L132;
        if (r178 == true) goto L132;
        if (r176 == false) goto L133;
    L132:
        boolean r181 = true;
    L134:
        if (r178 == true) goto L139;
        if (r176 == false) goto L138;
        if (r180 == true) goto L138;
        if (r179 == false) goto L139;
    L138:
        boolean r182 = true;
    L141:
        if (r110 != '_') goto L152;
        if (r181 == false) goto L146;
        if (r182 == false) goto L145;
        if (r176 == false) goto L146;
    L145:
        boolean r183 = true;
    L147:
        if (r182 == false) goto L151;
        if (r181 == false) goto L150;
        if (r179 == false) goto L151;
    L150:
        boolean r184 = true;
    L163:
        this.f525737f = r162;
        r164 = new a(r163, r183, r184);
    L151:
        r184 = false;
    L146:
        r183 = false;
        goto L147
    L152:
        if (r181 == true) goto L154;
    L156:
        boolean r185 = false;
    L157:
        if (r182 == true) goto L159;
    L161:
        boolean r186 = false;
    L162:
        r184 = r186;
        r183 = r185;
        goto L163
    L159:
        if (r110 != r161.b()) goto L161;
        r186 = true;
        goto L162
    L154:
        if (r110 != r161.c()) goto L156;
        r185 = true;
    L139:
        r182 = false;
    L133:
        r181 = false;
        goto L134
    L122:
        r173 = this.f525736e.substring(r162 - 1, r162);
        goto L123
    L169:
        int r187 = this.f525737f;
        int r188 = this.f525736e.length();
    L170:
        int r189 = this.f525737f;
        if (r189 == r188) goto L176;
        if (this.f525732a.get(this.f525736e.charAt(r189)) == true) goto L176;
        this.f525737f++;
    L176:
        int r190 = this.f525737f;
        if (r187 == r190) goto L218;
        r156 = new Text(this.f525736e.substring(r187, r190));
        goto L179
    L180:
        String r191 = d(f525725n);
        if (r191 == null) goto L218;
        int r192 = this.f525737f;
    L184:
        String r193 = d(f525724m);
        if (r193 == null) goto L202;
        if (r193.equals(r191) == false) goto L184;
        Code r194 = new Code();
        String r195 = this.f525736e.substring(r192, this.f525737f - r191.length()).replace('\n', ' ');
        if (r195.length() >= 3) goto L191;
    L200:
        r194.f525760h = r195;
        r171 = r194;
        goto L201
    L191:
        if (r195.charAt(0) != ' ') goto L200;
        if (r195.charAt(r195.length() - 1) != ' ') goto L200;
        int r196 = r195.length();
        if (tvc.d.b(' ', r195, 0, r196) == r196) goto L197;
        boolean r197 = true;
    L198:
        if (r197 == false) goto L200;
        r195 = r195.substring(1, r195.length() - 1);
        goto L200
    L197:
        r197 = false;
        goto L198
    L202:
        this.f525737f = r192;
        r115 = new Text(r191);
        goto L225
    }

    public static void b(char r100, xvc.a r101, Map<Character, xvc.a> r102) {
        if (((xvc.a) ((HashMap) r102).put(Character.valueOf(r100), r101)) != null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Delimiter processor conflict with delimiter char '" + r100 + "'");
    }

    public static void e(Text r100, Text r101, int r102) {
        if (r100 == null) goto L11;
        if (r101 == null) goto L12;
        if (r100 == r101) goto L13;
        StringBuilder r103 = new StringBuilder(r102);
        r103.append(r100.f525783h);
        uvc.b r104 = r100.f551904e;
        uvc.b r105 = r101.f551904e;
    L6:
        if (r104 == r105) goto L8;
        r103.append(((Text) r104).f525783h);
        uvc.b r106 = r104.f551904e;
        r104.g();
        r104 = r106;
        goto L6
    L8:
        r100.f525783h = r103.toString();
        return;
    L13:
        return;
    L12:
        return;
    }
}
