package tsc;

import android.widget.TextView;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.noties.markwon.html.jsoup.parser.ParseErrorList;
import io.noties.markwon.html.jsoup.parser.Token;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class h extends lsc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v.a f547446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f547447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r f547448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public s f547449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f547450e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, a0> f547451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set<String> f547452b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set<String> f547453c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f547454d;

        public a() {
            this.f547451a = new HashMap(2);
            this.f547452b = new HashSet();
            this.f547453c = new HashSet();
        }

        public final void a(a0 r100) {
            Iterator<String> r101 = r100.c().iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            String r102 = r101.next();
            if (((HashMap) this.f547451a).containsKey(r102) == true) goto L4;
            ((HashMap) this.f547451a).put(r102, r100);
            goto L4
        }
    }

    public h() {
        this.f547450e = new g();
        this.f547446a = new v.a();
        this.f547447b = new a();
    }

    @Override // lsc.a, lsc.j
    public final void g(lsc.h.a r110) {
        v.a r111 = this.f547446a;
        this.f547447b.getClass();
        this.f547447b.a(new io.noties.markwon.html.tag.e(new io.noties.markwon.html.tag.f(new c.a())));
        this.f547447b.a(new io.noties.markwon.html.tag.g());
        this.f547447b.a(new io.noties.markwon.html.tag.a());
        this.f547447b.a(new io.noties.markwon.html.tag.l());
        this.f547447b.a(new io.noties.markwon.html.tag.m());
        this.f547447b.a(new io.noties.markwon.html.tag.k());
        this.f547447b.a(new io.noties.markwon.html.tag.j());
        this.f547447b.a(new io.noties.markwon.html.tag.n());
        this.f547447b.a(new io.noties.markwon.html.tag.h());
        this.f547447b.a(new io.noties.markwon.html.tag.b());
        this.f547447b.a(new io.noties.markwon.html.tag.c());
        a r100 = this.f547447b;
        if (r100.f547454d == true) goto L19;
        r100.f547454d = true;
        Map<String, a0> r101 = Collections.unmodifiableMap(r100.f547451a);
        g r102 = this.f547450e;
        a r103 = this.f547447b;
        Set<String> r104 = r103.f547452b;
        Set<String> r105 = r103.f547453c;
        this.f547448c = new r(r102, r101, new b0.a(), r104, r105);
        boolean r106 = r111.f547489c;
        if (r106 == true) goto L17;
        r111.f547487a = r101;
        if (r106 == true) goto L15;
        r111.f547489c = true;
        if (r101.size() <= 0) goto L11;
        s r107 = new v(r111.f547488b, r111.f547487a);
    L12:
        this.f547449d = r107;
        return;
    L11:
        r107 = new w();
        goto L12
    L15:
        throw new IllegalStateException("Builder has been already built");
    L17:
        throw new IllegalStateException("Builder has been already built");
    L19:
        throw new IllegalStateException("Builder has been already built");
    }

    public final void n(a0 r100) {
        a r101 = this.f547447b;
        if (r101.f547454d == true) goto L10;
        Iterator<String> r102 = r100.c().iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        String r103 = r102.next();
        ((HashMap) r101.f547451a).put(r103, r100);
        goto L6
    L8:
        return;
    L10:
        throw new IllegalStateException("Builder has been already built");
    }

    public void o(lsc.m r110, String r111) {
        if (r111 == null) goto L154;
        r r100 = this.f547448c;
        lsc.y r112 = r110.builder();
        r100.getClass();
        io.noties.markwon.html.jsoup.parser.c r101 = new io.noties.markwon.html.jsoup.parser.c(new io.noties.markwon.html.jsoup.parser.a(r111), ParseErrorList.noTracking());
    L4:
        Token r113 = r101.o();
        Token.TokenType r102 = r113.f492582a;
        if (Token.TokenType.EOF == r102) goto L181;
        int r103 = r.a.f547480a[r102.ordinal()];
        boolean r104 = true;
        if (r103 == 1) goto L92;
        if (r103 != 2) goto L11;
        Token.f r105 = (Token.f) r113;
        if (r.f547468j.contains(r105.f492590c) == false) goto L50;
    L79:
        String r106 = r105.f492590c;
        int r107 = ((ArrayList) r100.f547476f).size() - 1;
    L80:
        if (r107 <= (-1)) goto L87;
        m.b r108 = (m.b) ListProtector.get(r100.f547476f, r107);
        if (r106.equals(r108.f547459a) == false) goto L86;
        if (r108.f547462d >= 0) goto L86;
    L88:
        if (r108 == null) goto L153;
        r108.f547463e = r112.subSequence(r108.f547460b, r112.length()).toString();
        r100.b(r112, r108);
        int r109 = r112.length();
        if (r108.isClosed() == true) goto L153;
        r108.f547462d = r109;
    L153:
        r113.a();
    L86:
        r107 = r107 - 1;
        goto L80
    L87:
        r108 = null;
        goto L88
    L50:
        if (r100.f547475e.contains(r105.f492590c) == true) goto L79;
        String r114 = r105.f492590c;
        m.a r115 = r100.f547477g;
    L53:
        if (r115 == null) goto L59;
        if (r114.equals(r115.f547459a) == true) goto L59;
        if (r115.isClosed() == true) goto L59;
        r115 = r115.f547464f;
    L59:
        if (r115 == null) goto L153;
        if (TeaEventTrack.ACTION_DRAMA_PRE.equals(r114) == false) goto L63;
        r100.f547478h = false;
    L63:
        r115.f547463e = r112.subSequence(r115.f547460b, r112.length()).toString();
        r100.b(r112, r115);
        r115.c(r112.length());
        if (r115.f547460b != r115.f547462d) goto L66;
        boolean r116 = true;
    L67:
        if (r116 == true) goto L76;
        if (r.f547470l.contains(r115.f547459a) == false) goto L71;
    L74:
        r100.f547479i = r104;
        goto L76
    L71:
        if (r100.f547474d.contains(r114) == true) goto L74;
        r104 = false;
    L76:
        if ("p".equals(r114) == false) goto L78;
        tsc.a.a(r112, '\n');
    L78:
        r100.f547477g = r115.f547464f;
        goto L153
    L66:
        r116 = false;
        goto L67
    L11:
        if (r103 != 3) goto L153;
        Token.b r117 = (Token.b) r113;
        if (r100.f547478h == false) goto L22;
        r112.append(r117.f492584b);     // Catch: IOException -> L18
    L18:
        e = move-exception;
        throw new RuntimeException(e);
    L22:
        if (r100.f547479i == false) goto L29;
        int r118 = r112.length();
        if (r118 > 0) goto L26;
    L28:
        r100.f547479i = false;
        goto L29
    L26:
        if ('\n' == r112.charAt(r118 - 1)) goto L28;
        tsc.a.a(r112, '\n');
    L29:
        b0 r119 = r100.f547473c;
        String r120 = r117.f492584b;
        ((b0.a) r119).getClass();
        int r121 = r112.length();
        int r122 = r120.length();
        int r123 = 0;
        boolean r124 = false;
    L31:
        if (r123 >= r122) goto L43;
        char r125 = r120.charAt(r123);
        if (Character.isWhitespace(r125) == false) goto L35;
        r124 = true;
    L42:
        r123 = r123 + 1;
        goto L31
    L35:
        if (r124 == false) goto L41;
        int r126 = r112.length();
        if (r126 <= 0) goto L41;
        if (Character.isWhitespace(r112.charAt(r126 - 1)) == true) goto L41;
        tsc.a.a(r112, ' ');
    L41:
        tsc.a.a(r112, r125);
        r124 = false;
        goto L42
    L43:
        if (r124 == false) goto L153;
        if (r121 >= r112.length()) goto L153;
        tsc.a.a(r112, ' ');
        goto L153
    L92:
        Token.g r127 = (Token.g) r113;
        if (r.f547468j.contains(r127.f492590c) == false) goto L95;
    L137:
        String r128 = r127.f492590c;
        int r129 = r112.length();
        m.b r130 = new m.b(r128, r129, r.a(r127));
        if (r100.f547479i == false) goto L146;
        int r131 = r112.length();
        if (r131 > 0) goto L142;
    L144:
        r100.f547479i = false;
        goto L146
    L142:
        if ('\n' == r112.charAt(r131 - 1)) goto L144;
        tsc.a.a(r112, '\n');
    L146:
        if (r.f547469k.contains(r128) == false) goto L148;
    L149:
        r130.f547463e = r112.subSequence(r129, r112.length()).toString();
        r100.b(r112, r130);
        int r132 = r112.length();
        if (r130.isClosed() == true) goto L152;
        r130.f547462d = r132;
    L152:
        ((ArrayList) r100.f547476f).add(r130);
        goto L153
    L148:
        if (r127.f492596i == false) goto L152;
    L95:
        if (r100.f547475e.contains(r127.f492590c) == true) goto L137;
        String r133 = r127.f492590c;
        if ("p".equals(r100.f547477g.f547459a) == false) goto L101;
        r100.f547477g.c(r112.length());
        tsc.a.a(r112, '\n');
        r100.f547477g = r100.f547477g.f547464f;
    L106:
        if (r.f547470l.contains(r133) == false) goto L108;
    L118:
        r100.f547478h = TeaEventTrack.ACTION_DRAMA_PRE.equals(r133);
        int r134 = r112.length();
        if (r134 > 0) goto L121;
    L123:
        int r135 = r112.length();
        Map<String, String> r136 = r.a(r127);
        m.a r137 = r100.f547477g;
        m.a r138 = new m.a(r133, r135, r136, r137);
        if (r.f547469k.contains(r133) == false) goto L126;
    L129:
        if (r104 == false) goto L131;
        r138.f547463e = r112.subSequence(r135, r112.length()).toString();
        r100.b(r112, r138);
        r138.c(r112.length());
    L131:
        List r139 = r137.f547465g;
        if (r139 != null) goto L134;
        r139 = new ArrayList(2);
        r137.f547465g = r139;
    L134:
        r139.add(r138);
        if (r104 == true) goto L153;
        r100.f547477g = r138;
        goto L153
    L126:
        if (r127.f492596i == true) goto L129;
        r104 = false;
        goto L129
    L121:
        if ('\n' == r112.charAt(r134 - 1)) goto L123;
        tsc.a.a(r112, '\n');
        goto L123
    L108:
        if (r100.f547474d.contains(r133) == true) goto L118;
        if (r100.f547479i == false) goto L123;
        int r140 = r112.length();
        if (r140 > 0) goto L115;
    L117:
        r100.f547479i = false;
        goto L123
    L115:
        if ('\n' == r112.charAt(r140 - 1)) goto L117;
        tsc.a.a(r112, '\n');
        goto L117
    L101:
        if ("li".equals(r133) == false) goto L106;
        if ("li".equals(r100.f547477g.f547459a) == false) goto L106;
        r100.f547477g.c(r112.length());
        r100.f547477g = r100.f547477g.f547464f;
        goto L106
    L181:
        return;
    }

    @Override // lsc.a, lsc.j
    public final void a(TextView r100, uvc.b r101, lsc.p r102) {
        s r103 = this.f547449d;
        if (r103 == null) goto L7;
        r103.a(r102, this.f547448c);
        return;
    L7:
        throw new IllegalStateException("Unexpected state, html-renderer is not defined");
    }

    @Override // lsc.a, lsc.j
    public final void d(CharSequence r100, uvc.b r101, lsc.p r102) {
        s r103 = this.f547449d;
        if (r103 == null) goto L7;
        r103.a(r102, this.f547448c);
        return;
    L7:
        throw new IllegalStateException("Unexpected state, html-renderer is not defined");
    }
}
