package gtc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gtc.d f482721a;

    public interface a {
        List<f> a();

        String name();
    }

    /* JADX INFO: loaded from: classes41.dex */
    public interface b {
        int c();

        boolean d();
    }

    /* JADX INFO: loaded from: classes41.dex */
    public interface c {
        boolean a();

        String alias();

        Pattern b();

        boolean c();

        a d();
    }

    /* JADX INFO: loaded from: classes41.dex */
    public interface d extends b {
        boolean a();

        String alias();

        List<? extends b> children();

        String type();
    }

    /* JADX INFO: loaded from: classes41.dex */
    public interface e extends b {
        String b();
    }

    /* JADX INFO: loaded from: classes41.dex */
    public interface f {
        List<c> a();

        String name();
    }

    public g(etc.a r100) {
        this.f482721a = r100;
    }

    public static gtc.f d(Pattern r100) {
        return new gtc.f(r100, false, false, null, null);
    }

    public static gtc.f h(Pattern r100) {
        return new gtc.f(r100, true, false, null, null);
    }

    public final a b(String r100) {
        return this.f482721a.a(this, r100);
    }

    public static gtc.c a(String r100, f... r101) {
        int r102 = r101.length;
        ArrayList r103 = new ArrayList(r102);
        if (r102 <= 0) goto L6;
        Collections.addAll(r103, r101);
    L6:
        return new gtc.c(r100, r103);
    }

    public static gtc.f e(Pattern r100, boolean r101) {
        return new gtc.f(r100, r101, true, null, null);
    }

    public static k i(String r100, c... r101) {
        int r102 = r101.length;
        ArrayList r103 = new ArrayList(r102);
        if (r102 <= 0) goto L6;
        Collections.addAll(r103, r101);
    L6:
        return new k(r100, r103);
    }

    public static List j(String r100, a r101) {
        ArrayList r102 = new ArrayList(3);
        r102.add(new i(r100));
        c(r100, r102, r101, 0, 0, false, null);
        return r102;
    }

    public static gtc.f f(Pattern r100, boolean r101, boolean r102, String r110) {
        return new gtc.f(r100, r101, r102, r110, null);
    }

    public static gtc.f g(Pattern r100, boolean r101, boolean r102, String r110, a r111) {
        return new gtc.f(r100, r101, r102, r110, r111);
    }

    public static void c(String r310, List r311, a r312, int r313, int r314, boolean r315, f r316) {
        int r100 = r310.length();
        if (r100 != 0) goto L5;
        return;
    L5:
        Iterator<f> r110 = r312.a().iterator();
    L7:
        if (r110.hasNext() == false) goto L100;
        f r111 = r110.next();
        if (r111 == r316) goto L10;
        Iterator<c> r112 = r111.a().iterator();
    L13:
        if (r112.hasNext() == false) goto L7;
        c r113 = r112.next();
        boolean r114 = r113.c();
        boolean r115 = r113.a();
        Pattern r101 = r113.b();
        int r102 = r313;
        int r103 = r314;
        int r104 = 0;
    L15:
        ArrayList r105 = (ArrayList) r311;
        if (r102 >= r105.size()) goto L97;
        if (r105.size() > r100) goto L96;
        b r106 = (b) ListProtector.get(r311, r102);
        if (r106.d() == false) goto L22;
        int r116 = r104;
        int r210 = r100;
    L61:
        r110 = r110;
        Iterator<c> r211 = r112;
        r104 = r116;
        int r117 = 1;
    L94:
        r103 = r103 + ((b) ListProtector.get(r311, r102)).c();
        r102 = r102 + r117;
        r110 = r110;
        r100 = r210;
        r113 = r113;
        r112 = r211;
        r101 = r101;
        goto L15
    L22:
        String r107 = ((e) r106).b();
        if (r115 == false) goto L54;
        r116 = r104;
        if (r102 == (r105.size() - 1)) goto L55;
        Matcher r108 = r101.matcher(r310);
        r108.region(r103, r100);
        if (r108.find() == false) goto L97;
        int r109 = r108.start();
        if (r114 == false) goto L32;
        r109 = r109 + r108.group(1).length();
    L32:
        int r118 = r108.start() + r108.group(0).length();
        int r119 = r105.size();
        int r120 = r103;
        r210 = r100;
        int r121 = r120;
        int r122 = r102;
    L33:
        if (r102 >= r119) goto L51;
        if (r120 < r118) goto L46;
        if (((b) ListProtector.get(r311, r102)).d() == true) goto L51;
        b r123 = (b) ListProtector.get(r311, r102 - 1);
        if (r123.d() == true) goto L40;
    L42:
        boolean r124 = false;
    L43:
        if (r124 == true) goto L51;
    L40:
        if (((d) r123).a() == false) goto L42;
        r124 = true;
    L46:
        r120 = r120 + ((b) ListProtector.get(r311, r102)).c();
        if (r109 < r120) goto L49;
        r122 = r122 + 1;
        r121 = r120;
    L49:
        r102 = r102 + 1;
        r119 = r119;
    L51:
        if (((b) ListProtector.get(r311, r122)).d() == false) goto L53;
        r102 = r122;
        r103 = r121;
        goto L61
    L53:
        String r125 = r310.substring(r121, r120);
        int r126 = -r121;
        Matcher r127 = r108;
        boolean r128 = true;
        int r212 = r121;
        int r129 = r102 - r122;
        r102 = r122;
        r103 = r212;
        String r130 = r125;
        int r131 = r126;
    L56:
        if (r128 == false) goto L58;
    L62:
        if (r114 == false) goto L68;
        String r132 = r127.group(1);
        if (r132 == null) goto L66;
        int r133 = r132.length();
    L67:
        int r134 = r133;
    L69:
        int r135 = (r127.start() + r131) + r134;
        if (r134 <= 0) goto L72;
        String r136 = r127.group().substring(r134);
    L73:
        int r213 = r134;
        int r137 = r135 + r136.length();
        int r138 = 0;
    L74:
        if (r138 >= r129) goto L76;
        ListProtector.remove(r311, r102);
        r138 = r138 + 1;
        goto L74
    L76:
        if (r135 == 0) goto L78;
        String r139 = r130.substring(0, r135);
        r103 = r103 + r139.length();
        ListProtector.add(r311, r102, new i(r139));
        int r140 = r102 + 1;
    L79:
        int r141 = r103;
        a r142 = r113.d();
        if (r142 == null) goto L82;
        boolean r214 = true;
    L83:
        if (r214 == false) goto L85;
        List r143 = j(r136, r142);
    L86:
        int r144 = r140 + 1;
        r211 = r112;
        int r145 = r140;
        String r215 = r130;
        r117 = 1;
        ListProtector.add(r311, r145, new h(r111.name(), r143, r113.alias(), r136, r115, r214));
        if (r137 >= r215.length()) goto L89;
        ListProtector.add(r311, r144, new i(r215.substring(r137)));
    L89:
        if (r129 == 1) goto L91;
        c(r310, r311, r312, r145, r141, true, r111);
    L91:
        if (r315 == true) goto L99;
        r102 = r145;
        r103 = r141;
        r104 = r213;
    L99:
        r110 = r110;
        r100 = r210;
        r112 = r211;
        goto L13
    L85:
        r143 = Collections.singletonList(new i(r136));
        goto L86
    L82:
        r214 = false;
        goto L83
    L78:
        r140 = r102;
        goto L79
    L72:
        r136 = r127.group();
        goto L73
    L66:
        r133 = 0;
        goto L67
    L68:
        r134 = r116;
        goto L69
    L58:
        if (r127.find() == true) goto L62;
        if (r315 == false) goto L61;
    L98:
        r110 = r110;
        r211 = r112;
    L55:
        r210 = r100;
        r127 = r101.matcher(r107);
        r130 = r107;
        r128 = false;
        r131 = 0;
        r129 = 1;
        goto L56
    L54:
        r116 = r104;
        goto L55
    L96:
        throw new RuntimeException("Prism4j internal error. Number of entry nodes is greater that the text length.\nNodes: " + r311 + "\nText: " + r310);
    L97:
        r210 = r100;
        goto L98
    L10:
        return;
    }
}
