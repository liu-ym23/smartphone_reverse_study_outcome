package zsc;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes5.dex */
public final class j implements vvc.a, k {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f573522k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f573523l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Pattern f573524m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Pattern f573525n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Pattern f573526o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vvc.b f573527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f573528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BitSet f573529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Character, List<i>> f573530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Character, xvc.a> f573531e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public uvc.b f573532f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f573533g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f573534h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public org.commonmark.internal.f f573535i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public org.commonmark.internal.e f573536j;

    /* JADX INFO: loaded from: classes41.dex */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f573537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f573538b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f573539c;

        public a(int r100, boolean r101, boolean r102) {
            this.f573537a = r100;
            this.f573539c = r101;
            this.f573538b = r102;
        }
    }

    public interface b {
    }

    public static class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<i> f573540a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<xvc.a> f573541b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f573542c;

        public c() {
            this.f573540a = new ArrayList(3);
            this.f573541b = new ArrayList(3);
        }

        public final c a(i r100) {
            ((ArrayList) this.f573540a).add(r100);
            return this;
        }

        public final c b(Class r100) {
            int r101 = ((ArrayList) this.f573540a).size();
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L8;
            if (r100.equals(((i) ListProtector.get(this.f573540a, r102)).getClass()) == true) goto L6;
            r102 = r102 + 1;
            goto L3
        L6:
            ListProtector.remove(this.f573540a, r102);
        L8:
            return this;
        }
    }

    public static class d implements vvc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f573543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<i> f573544b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<xvc.a> f573545c;

        @Override // vvc.c
        public final vvc.a a(org.commonmark.internal.m r100) {
            List<xvc.a> r101 = r100.f525718a;
            if (r101 == null) goto L5;
            int r102 = r101.size();
        L6:
            if (r102 <= 0) goto L8;
            ArrayList r103 = new ArrayList(r102 + this.f573545c.size());
            r103.addAll(this.f573545c);
            r103.addAll(r101);
            List r104 = r103;
        L10:
            return new j(r100, this.f573543a, this.f573544b, r104);
        L8:
            r104 = this.f573545c;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public d(boolean r100, List r101, List r102) {
            this.f573543a = r100;
            this.f573544b = r101;
            this.f573545c = r102;
        }
    }

    static {
        f573522k = PatternProtector.compile("^[!\"#\\$%&'\\(\\)\\*\\+,\\-\\./:;<=>\\?@\\[\\\\\\]\\^_`\\{\\|\\}~\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]");
        f573523l = PatternProtector.compile("^ *(?:\n *)?");
        f573524m = PatternProtector.compile("^[\\p{Zs}\t\r\n\f]");
        f573525n = PatternProtector.compile("^[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]");
        f573526o = PatternProtector.compile("\\s+");
    }

    public final char d() {
        if (this.f573534h < this.f573533g.length()) goto L5;
        return 0;
    L5:
        return this.f573533g.charAt(this.f573534h);
    }

    public final String c(Pattern r100) {
        if (this.f573534h < this.f573533g.length()) goto L5;
        return null;
    L5:
        Matcher r101 = r100.matcher(this.f573533g);
        r101.region(this.f573534h, this.f573533g.length());
        if (r101.find() == false) goto L9;
        this.f573534h = r101.end();
        return r101.group();
    L9:
        return null;
    }

    public final void e(org.commonmark.internal.f r110) {
        HashMap r100 = new HashMap();
        org.commonmark.internal.f r101 = this.f573535i;
    L3:
        if (r101 == null) goto L7;
        org.commonmark.internal.f r102 = r101.f525683e;
        if (r102 == r110) goto L7;
        r101 = r102;
    L7:
        if (r101 == null) goto L48;
        char r103 = r101.f525680b;
        xvc.a r104 = (xvc.a) ((HashMap) this.f573531e).get(Character.valueOf(r103));
        if (r101.f525682d == false) goto L47;
        if (r104 == null) goto L47;
        char r105 = r104.c();
        org.commonmark.internal.f r106 = r101.f525683e;
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
        org.commonmark.internal.f r115 = r101.f525683e;
    L33:
        if (r115 == null) goto L36;
        if (r115 == r106) goto L36;
        org.commonmark.internal.f r116 = r115.f525683e;
        f(r115);
        r115 = r116;
    L36:
        if (r111 == r112) goto L41;
        uvc.b r117 = r111.f551904e;
        if (r117 == r112) goto L41;
        h.b(r117, r112.f551903d);
    L41:
        r104.e(r111, r112, r108);
        if (r106.f525685g != 0) goto L45;
        r106.f525679a.g();
        f(r106);
    L45:
        if (r101.f525685g != 0) goto L7;
        org.commonmark.internal.f r118 = r101.f525684f;
        r101.f525679a.g();
        f(r101);
        r101 = r118;
        goto L7
    L27:
        if (r109 == true) goto L31;
        r100.put(Character.valueOf(r103), r101.f525683e);
        if (r101.f525681c == true) goto L31;
        f(r101);
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
        org.commonmark.internal.f r119 = this.f573535i;
        if (r119 == null) goto L52;
        if (r119 == r110) goto L79;
        f(r119);
        goto L48
    L79:
        return;
    }

    public final void f(org.commonmark.internal.f r100) {
        org.commonmark.internal.f r101 = r100.f525683e;
        if (r101 == null) goto L5;
        r101.f525684f = r100.f525684f;
    L5:
        org.commonmark.internal.f r102 = r100.f525684f;
        if (r102 != null) goto L8;
        this.f573535i = r101;
        return;
    L8:
        r102.f525683e = r101;
    }

    @Override // vvc.a
    public final void a(String r110, uvc.b r111) {
        this.f573533g = r110.trim();
        this.f573534h = 0;
        this.f573535i = null;
        this.f573536j = null;
        this.f573532f = r111;
    L3:
        char r100 = d();
        if (r100 != 0) goto L6;
        uvc.b r101 = null;
    L89:
        if (r101 == null) goto L91;
        r111.b(r101);
        goto L3
    L91:
        e(null);
        uvc.b r112 = r111.f551901b;
        uvc.b r113 = r111.f551902c;
        if (r112 == r113) goto L102;
        h.b(r112, r113);
        return;
    L102:
        return;
    L6:
        List r102 = (List) ((HashMap) this.f573530d).get(Character.valueOf(r100));
        if (r102 == null) goto L15;
        int r103 = this.f573534h;
        Iterator r104 = r102.iterator();
        r101 = null;
    L10:
        if (r104.hasNext() == false) goto L86;
        i r105 = (i) r104.next();
        r105.f573518a = this;
        r105.f573519b = this.f573532f;
        r105.f573520c = this.f573533g;
        r105.f573521d = this.f573534h;
        uvc.b r106 = r105.b();
        this.f573534h = r105.f573521d;
        if (r106 != null) goto L13;
        this.f573534h = r103;
        r101 = r106;
    L13:
        r101 = r106;
    L86:
        if (r101 != null) goto L89;
        this.f573534h++;
        r101 = new Text(String.valueOf(r100));
        goto L89
    L15:
        xvc.a r107 = (xvc.a) ((HashMap) this.f573531e).get(Character.valueOf(r100));
        if (r107 == null) goto L75;
        int r108 = this.f573534h;
        int r109 = 0;
    L19:
        if (d() != r100) goto L22;
        r109 = r109 + 1;
        this.f573534h++;
        goto L19
    L22:
        if (r109 >= r107.a()) goto L24;
        this.f573534h = r108;
        a r114 = null;
    L69:
        if (r114 == null) goto L85;
        int r115 = r114.f573537a;
        int r116 = this.f573534h;
        int r117 = r116 + r115;
        this.f573534h = r117;
        Text r118 = new Text(this.f573533g.substring(r116, r117));
        org.commonmark.internal.f r119 = new org.commonmark.internal.f(r118, r100, r114.f573539c, r114.f573538b, this.f573535i);
        this.f573535i = r119;
        r119.f525685g = r115;
        r119.f525686h = r115;
        org.commonmark.internal.f r120 = r119.f525683e;
        if (r120 == null) goto L74;
        r120.f525684f = r119;
    L74:
        r101 = r118;
    L85:
        r101 = null;
        goto L86
    L24:
        String r121 = "\n";
        if (r108 != 0) goto L27;
        String r122 = "\n";
    L28:
        char r123 = d();
        if (r123 == 0) goto L32;
        r121 = String.valueOf(r123);
    L32:
        Pattern r124 = f573522k;
        boolean r125 = r124.matcher(r122).matches();
        Pattern r126 = f573524m;
        boolean r127 = r126.matcher(r122).matches();
        boolean r128 = r124.matcher(r121).matches();
        boolean r129 = r126.matcher(r121).matches();
        if (r129 == true) goto L38;
        if (r128 == false) goto L37;
        if (r127 == true) goto L37;
        if (r125 == false) goto L38;
    L37:
        boolean r130 = true;
    L39:
        if (r127 == true) goto L44;
        if (r125 == false) goto L43;
        if (r129 == true) goto L43;
        if (r128 == false) goto L44;
    L43:
        boolean r131 = true;
    L46:
        if (r100 != '_') goto L57;
        if (r130 == false) goto L51;
        if (r131 == false) goto L50;
        if (r125 == false) goto L51;
    L50:
        boolean r132 = true;
    L52:
        if (r131 == false) goto L56;
        if (r130 == false) goto L55;
        if (r128 == false) goto L56;
    L55:
        boolean r133 = true;
    L68:
        this.f573534h = r108;
        r114 = new a(r109, r132, r133);
    L56:
        r133 = false;
    L51:
        r132 = false;
        goto L52
    L57:
        if (r130 == true) goto L59;
    L61:
        boolean r134 = false;
    L62:
        if (r131 == true) goto L64;
    L66:
        boolean r135 = false;
    L67:
        r133 = r135;
        r132 = r134;
        goto L68
    L64:
        if (r100 != r107.b()) goto L66;
        r135 = true;
        goto L67
    L59:
        if (r100 != r107.c()) goto L61;
        r134 = true;
    L44:
        r131 = false;
    L38:
        r130 = false;
        goto L39
    L27:
        r122 = this.f573533g.substring(r108 - 1, r108);
        goto L28
    L75:
        int r136 = this.f573534h;
        int r137 = this.f573533g.length();
    L76:
        int r138 = this.f573534h;
        if (r138 == r137) goto L82;
        if (this.f573529c.get(this.f573533g.charAt(r138)) == true) goto L82;
        this.f573534h++;
    L82:
        int r139 = this.f573534h;
        if (r136 == r139) goto L85;
        r106 = new Text(this.f573533g.substring(r136, r139));
        goto L13
    }

    public static void b(char r100, xvc.a r101, Map<Character, xvc.a> r102) {
        if (((xvc.a) ((HashMap) r102).put(Character.valueOf(r100), r101)) != null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Delimiter processor conflict with delimiter char '" + r100 + "'");
    }

    public j(org.commonmark.internal.m r100, boolean r101, List r102, List r103) {
        this.f573527a = r100;
        this.f573528b = r101;
        HashMap r104 = new HashMap(r102.size());
        Iterator r105 = r102.iterator();
    L4:
        if (r105.hasNext() == false) goto L9;
        i r106 = (i) r105.next();
        char r107 = r106.d();
        List r108 = (List) r104.get(Character.valueOf(r107));
        if (r108 != null) goto L8;
        r108 = new ArrayList(1);
        r104.put(Character.valueOf(r107), r108);
    L8:
        r108.add(r106);
        goto L4
    L9:
        this.f573530d = r104;
        HashMap r109 = new HashMap();
        Iterator r110 = r103.iterator();
    L11:
        if (r110.hasNext() == false) goto L25;
        xvc.a r111 = (xvc.a) r110.next();
        char r112 = r111.c();
        char r113 = r111.b();
        if (r112 == r113) goto L14;
        b(r112, r111, r109);
        b(r113, r111, r109);
        goto L11
    L14:
        xvc.a r114 = (xvc.a) r109.get(Character.valueOf(r112));
        if (r114 == null) goto L23;
        if (r114.c() != r114.b()) goto L23;
        if ((r114 instanceof o) == false) goto L21;
        o r115 = (o) r114;
    L22:
        r115.f(r111);
        r109.put(Character.valueOf(r112), r115);
        goto L11
    L21:
        o r116 = new o(r112);
        r116.f(r114);
        r115 = r116;
    L23:
        b(r112, r111, r109);
        goto L11
    L25:
        this.f573531e = r109;
        Set r117 = ((HashMap) this.f573530d).keySet();
        Set r118 = r109.keySet();
        BitSet r119 = new BitSet();
        Iterator r120 = r117.iterator();
    L27:
        if (r120.hasNext() == false) goto L29;
        r119.set(((Character) r120.next()).charValue());
        goto L27
    L29:
        Iterator r121 = r118.iterator();
    L31:
        if (r121.hasNext() == false) goto L33;
        r119.set(((Character) r121.next()).charValue());
        goto L31
    L33:
        this.f573529c = r119;
    }
}
