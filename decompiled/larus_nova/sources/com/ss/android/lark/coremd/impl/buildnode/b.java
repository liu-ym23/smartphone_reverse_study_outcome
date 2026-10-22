package com.ss.android.lark.coremd.impl.buildnode;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.coremd.utils.BISURelocator;
import com.ss.android.lark.coremd.utils.NodeBISUUtils;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v7b.e;
import v7b.s;
import v7b.v;
import x9b.h;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f419831a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BISURelocator f419832b = null;

    public interface a {
        int a(s r100, s r101);
    }

    /* JADX INFO: renamed from: com.ss.android.lark.coremd.impl.buildnode.b$b, reason: collision with other inner class name */
    public static final class C4948b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s f419833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f419834b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f419835c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<C4948b> f419836d;

        public final String toString() {
            return "NodeWithInterval{node: " + this.f419833a + ", start: " + this.f419834b + ", end: " + this.f419835c + '}';
        }

        public C4948b(s r100, int r101, int r102, List<C4948b> r103) {
            Intrinsics.checkNotNullParameter(r100, "node");
            Intrinsics.checkNotNullParameter(r103, "children");
            this.f419833a = r100;
            this.f419834b = r101;
            this.f419835c = r102;
            this.f419836d = r103;
        }
    }

    public b() {
    }

    static {
        f419831a = new b();
        f419832b = new BISURelocator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r23v0, types: [com.ss.android.lark.coremd.impl.buildnode.b$a, com.ss.android.lark.coremd.impl.buildnode.d$a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r6v13 */
    public static e a(Spanned r210, d.a r211) {
        Intrinsics.checkNotNullParameter(r210, "spanned");
        Intrinsics.checkNotNullParameter(r211, "handler");
        long r100 = System.currentTimeMillis();
        e r101 = new e();
        NodeBISUUtils.f419961c.getClass();
        Intrinsics.checkNotNullParameter(r210, "content");
        SpannableStringBuilder r102 = (SpannableStringBuilder) r210;
        int r103 = r102.length();
        char[] r104 = new char[r103];
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L5;
        r104[r105] = 0;
        r105 = r105 + 1;
        goto L3
    L5:
        int r106 = r102.length();
        int r107 = 0;
    L6:
        if (r107 >= r106) goto L25;
        int r110 = r102.nextSpanTransition(r107, r106, h.class);
        h[] r108 = (h[]) r102.getSpans(r107, r110, h.class);
        int r111 = r108.length;
        int r112 = 0;
    L8:
        if (r112 >= r111) goto L24;
        h r113 = r108[r112];
        int r114 = r102.getSpanStart(r113);
        int r115 = r102.getSpanEnd(r113);
        if (r114 == (-1)) goto L23;
        if (r115 == (-1)) goto L23;
        NodeBISUUtils r109 = NodeBISUUtils.f419961c;
        boolean r116 = r113.f563010a;
        boolean r117 = r113.f563011b;
        boolean r118 = r113.f563012c;
        boolean r119 = r113.f563013d;
        r109.getClass();
        ?? r120 = r116;
        if (r117 == false) goto L16;
        r120 = (r116 ? 1 : 0) | 2;
    L16:
        if (r118 == false) goto L18;
        r120 = (r120 == true ? 1 : 0) | '\b';
    L18:
        if (r119 == false) goto L20;
        r120 = (r120 == true ? 1 : 0) | 4;
    L20:
        if (r114 >= r115) goto L23;
        r104[r114] = (r104[r114] | r120) == true ? 1 : 0;
        r114 = r114 + 1;
    L23:
        r112 = r112 + 1;
        r102 = r102;
        r106 = r106;
        r108 = r108;
        goto L8
    L24:
        r107 = r110;
        goto L6
    L25:
        SpannableStringBuilder r121 = (SpannableStringBuilder) r210;
        BitSet r122 = new BitSet(r121.length());
        BitSet r123 = new BitSet(r121.length());
        LinkedHashMap r124 = new LinkedHashMap();
        Iterator r125 = r211.c().iterator();
    L27:
        if (r125.hasNext() == false) goto L53;
        Class r126 = (Class) r125.next();
        Object[] r127 = r121.getSpans(0, r121.length(), r126);
        int r128 = r127.length;
        int r129 = 0;
    L29:
        if (r129 >= r128) goto L27;
        Object r130 = r127[r129];
        Iterator r131 = r125;
        int r132 = r121.getSpanStart(r130);
        Object[] r133 = r127;
        int r134 = r121.getSpanEnd(r130);
        Intrinsics.checkNotNull(r130);
        s r135 = r211.f(r126, r210, r130);
        if (r135 != null) goto L33;
        Class r212 = r126;
        int r213 = r128;
    L51:
        r129 = r129 + 1;
        r125 = r131;
        r127 = r133;
        r126 = r212;
        r128 = r213;
        goto L29
    L33:
        r212 = r126;
        if ((r135 instanceof v7b.h) == false) goto L36;
        r123.set(r132, r134);
    L36:
        r213 = r128;
        r124.put(r135, TuplesKt.to(Integer.valueOf(r132), Integer.valueOf(r134)));
        r122.set(r132, r134);
        if ((r135 instanceof v7b.a) == true) goto L51;
        if (r104.length != 0) goto L41;
        boolean r136 = true;
    L42:
        if (r136 == true) goto L51;
        int r137 = r132 + 1;
        char r138 = r104[r132];
    L45:
        if (r137 >= r134) goto L50;
        int r139 = r137 + 1;
        if (r104[r137] != r138) goto L51;
        r137 = r139;
        goto L45
    L50:
        NodeBISUUtils.f419961c.getClass();
        Intrinsics.checkNotNullParameter(r135, "node");
        NodeBISUUtils.b(r135, r138);
        goto L51
    L41:
        r136 = false;
        goto L42
    L53:
        if (r121.length() <= 0) goto L55;
        boolean r140 = true;
    L56:
        char r141 = '\n';
        if (r140 == false) goto L76;
        int r142 = r121.length();
        int r143 = 0;
    L59:
        if (r143 >= r142) goto L76;
        if (r121.charAt(r143) != r141) goto L75;
        if (r122.get(r143) == true) goto L75;
        v7b.h r144 = new v7b.h();
        if (r143 != 0) goto L67;
        r124.put(r144, TuplesKt.to(0, 1));
        r122.set(0, 1);
        r123.set(0, 1);
        goto L75
    L67:
        int r145 = r143 - 1;
        if (r121.charAt(r145) != '\n') goto L75;
        if (r123.get(r145) == true) goto L75;
        if (r122.get(r145) == true) goto L74;
        r124.put(r144, TuplesKt.to(Integer.valueOf(r145), Integer.valueOf(r143)));
        r122.set(r145, r143);
        r123.set(r145, r143);
        goto L75
    L74:
        int r146 = r143 + 1;
        r124.put(r144, TuplesKt.to(Integer.valueOf(r143), Integer.valueOf(r146)));
        r122.set(r143, r146);
        r123.set(r143, r146);
    L75:
        r143 = r143 + 1;
        r141 = '\n';
    L76:
        ArrayList r147 = new ArrayList(r124.size());
        Iterator r148 = r124.entrySet().iterator();
    L78:
        if (r148.hasNext() == false) goto L80;
        Map.Entry r149 = (Map.Entry) r148.next();
        s r150 = (s) r149.getKey();
        Pair r151 = (Pair) r149.getValue();
        r147.add(new C4948b(r150, ((Number) r151.getFirst()).intValue(), ((Number) r151.getSecond()).intValue(), new ArrayList()));
        goto L78
    L80:
        List r152 = CollectionsKt.sortedWith(r147, c.f419837a);
        ArrayList r153 = new ArrayList();
        Iterator r154 = r152.iterator();
    L81:
        boolean r155 = r154.hasNext();
        b r156 = f419831a;
        if (r155 == false) goto L84;
        r156.insert(r153, (C4948b) r154.next(), r211);
        goto L81
    L84:
        ArrayList r157 = new ArrayList();
        Iterator r158 = r153.iterator();
        int r159 = 0;
    L86:
        if (r158.hasNext() == false) goto L104;
        C4948b r160 = (C4948b) r158.next();
        int r161 = r160.f419834b;
        if (r161 <= r159) goto L90;
        r157.addAll(r211.b(r160.f419833a, r121.subSequence(r159, r161), r159, r104));
    L90:
        r157.add(b(r160.f419833a, r210, r160, r211, r104));
        int r162 = r160.f419835c;
        s r163 = (s) CollectionsKt.lastOrNull(r157);
        Character r164 = StringsKt.getOrNull(r210, r162);
        if (r164 != null) goto L94;
    L102:
        r159 = r162;
        goto L86
    L94:
        if (r164.charValue() != '\n') goto L102;
        if (r163 != null) goto L97;
        boolean r165 = false;
    L98:
        if (r165 == false) goto L100;
    L101:
        r162 = r162 + 1;
        goto L102
    L100:
        if ((r163 instanceof v7b.h) == false) goto L102;
    L97:
        r165 = r211.d(r163);
        goto L98
    L104:
        if (r159 >= r121.length()) goto L106;
        r157.addAll(r211.b(r101, r121.subSequence(r159, r121.length()), r159, r104));
    L106:
        List r166 = ListItemBuildUtils.g(r157);
        ArrayList r167 = new ArrayList();
        LinkedList r168 = new LinkedList();
        Iterator r169 = r166.iterator();
    L108:
        if (r169.hasNext() == false) goto L137;
        s r170 = (s) r169.next();
        if ((r170 instanceof v7b.h) == true) goto L112;
        if (r211.d(r170) == true) goto L122;
        r168.add(r170);
        goto L108
    L122:
        if ((!r168.isEmpty()) == true) goto L124;
        boolean r171 = false;
    L133:
        if (r171 == true) goto L108;
        r167.add(r170);
        goto L108
    L124:
        if ((r170 instanceof v) == false) goto L126;
        v r172 = (v) r170;
    L127:
        r171 = Intrinsics.areEqual(r172, r170);
        Iterator r173 = r168.iterator();
    L129:
        if (r173.hasNext() == false) goto L131;
        r172.e((s) r173.next());
        goto L129
    L131:
        r168.clear();
        r167.add(r172);
        goto L133
    L126:
        r172 = new v();
        goto L127
    L112:
        if ((!r168.isEmpty()) == false) goto L118;
        v r174 = new v();
        Iterator r175 = r168.iterator();
    L115:
        if (r175.hasNext() == false) goto L117;
        r174.e((s) r175.next());
        goto L115
    L117:
        r167.add(r174);
        r168.clear();
    L118:
        r167.add(r170);
        goto L108
    L137:
        if ((!r168.isEmpty()) == false) goto L143;
        v r176 = new v();
        Iterator r177 = r168.iterator();
    L140:
        if (r177.hasNext() == false) goto L142;
        r176.e((s) r177.next());
        goto L140
    L142:
        r167.add(r176);
    L143:
        Iterator r178 = r167.iterator();
    L145:
        if (r178.hasNext() == false) goto L147;
        r101.e((s) r178.next());
        goto L145
    L147:
        f419832b.d(r101);
        Log.d("SpannedNodeGenerateUtils", "build node cost " + (System.currentTimeMillis() - r100) + " mills.");
        return r101;
    L55:
        r140 = false;
        goto L56
    }

    private final void insert(List<C4948b> r110, C4948b r111, a r112) {
        Iterator<T> r100 = r110.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L32;
        Object r102 = r100.next();
        int r103 = r101 + 1;
        if (r101 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        C4948b r104 = (C4948b) r102;
        int r105 = r104.f419834b;
        int r106 = r111.f419834b;
        b r107 = f419831a;
        if (r105 == r106) goto L11;
    L17:
        int r108 = r104.f419835c;
        boolean r109 = true;
        if (r105 > r106) goto L21;
        if (r106 > r108) goto L21;
        boolean r113 = true;
    L22:
        if (r113 == false) goto L31;
        int r114 = r111.f419835c;
        if (r105 > r114) goto L27;
        if (r114 > r108) goto L27;
    L28:
        if (r109 == false) goto L31;
        r107.insert(r104.f419836d, r111, r112);
        return;
    L27:
        r109 = false;
    L31:
        r101 = r103;
    L21:
        r113 = false;
        goto L22
    L11:
        if (r104.f419835c != r111.f419835c) goto L17;
        if (r112.a(r104.f419833a, r111.f419833a) > 0) goto L15;
        r107.insert(r104.f419836d, r111, r112);
        return;
    L15:
        r107.insert(r111.f419836d, r104, r112);
        ListProtector.set(r110, r101, r111);
        return;
    L32:
        r110.add(r111);
    }

    public static s b(s r110, Spanned r111, C4948b r112, d.a r113, char[] r114) {
        s r100 = r112.f419833a;
        int r101 = r112.f419835c;
        int r102 = r112.f419834b;
        ArrayList r103 = new ArrayList();
        boolean r104 = false;
        if (r100 != null) goto L5;
        boolean r105 = false;
    L6:
        if (r105 == true) goto L8;
        return r100;
    L8:
        Iterator<T> r115 = r112.f419836d.iterator();
    L10:
        if (r115.hasNext() == false) goto L33;
        C4948b r106 = (C4948b) r115.next();
        int r107 = r106.f419834b;
        if (r107 <= r102) goto L14;
        r103.addAll(r113.b(r106.f419833a, ((SpannableStringBuilder) r111).subSequence(r102, r107), r102, r114));
    L14:
        r103.add(b(r106.f419833a, r111, r106, r113, r114));
        r102 = r106.f419835c;
        s r108 = (s) CollectionsKt.lastOrNull(r103);
        if (r108 != null) goto L17;
        boolean r109 = false;
    L18:
        if (r109 == false) goto L10;
        Character r116 = StringsKt.getOrNull(r111, r102 - 1);
        if (r116 != null) goto L23;
    L25:
        boolean r117 = false;
    L26:
        if (r117 == true) goto L10;
        Character r118 = StringsKt.getOrNull(r111, r102);
        if (r118 == null) goto L10;
        if (r118.charValue() != '\n') goto L10;
        r102 = r102 + 1;
        goto L10
    L23:
        if (r116.charValue() != '\n') goto L25;
        r117 = true;
        goto L26
    L17:
        r109 = r113.d(r108);
        goto L18
    L33:
        if (r100 == null) goto L36;
        r104 = r113.d(r100);
    L36:
        if (r104 == false) goto L43;
        int r119 = r101 - 1;
        Character r120 = StringsKt.getOrNull(r111, r119);
        if (r120 == null) goto L43;
        if (r120.charValue() != '\n') goto L43;
        r101 = r119;
    L43:
        if (r102 >= r101) goto L45;
        r103.addAll(r113.b(r110, ((SpannableStringBuilder) r111).subSequence(r102, r101), r102, r114));
    L45:
        Iterator r121 = r103.iterator();
    L47:
        if (r121.hasNext() == false) goto L49;
        r100.e((s) r121.next());
        goto L47
    L49:
        return r100;
    L5:
        r105 = r113.e(r100);
        goto L6
    }
}
