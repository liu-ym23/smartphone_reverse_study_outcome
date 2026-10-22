package com.bytedance.ee.bear.middleground.comment.widget;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.commonmark.parser.IncludeSourceSpans;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class v implements CommentTextView.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Regex f232366c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Regex f232367d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CommentTextView f232368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CommentTextView.c f232369b;

    public static final class a implements com.ss.android.lark.coremd.base.parse.g {
        public a() {
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void a(com.ss.android.lark.coremd.impl.parse.l.a r100) {
            Intrinsics.checkNotNullParameter(r100, "builder");
            r100.a(v7b.b0.class, new s());
            r100.a(v7b.v.class, new t());
            r100.a(v7b.a0.class, new u());
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void b(com.ss.android.lark.coremd.impl.parse.g r100) {
            Intrinsics.checkNotNullParameter(r100, "registry");
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void c(com.ss.android.lark.coremd.impl.parse.j.a r100) {
            Intrinsics.checkNotNullParameter(r100, "builder");
            r100.a(v7b.a0.class, new r());
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void d(com.ss.android.lark.coremd.impl.parse.c r100) {
            Intrinsics.checkNotNullParameter(r100, "registry");
        }
    }

    public static final class b implements com.ss.android.lark.coremd.base.parse.g {
        public b() {
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void a(com.ss.android.lark.coremd.impl.parse.l.a r100) {
            Intrinsics.checkNotNullParameter(r100, "builder");
            r100.a(v7b.i.class, new x());
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void b(com.ss.android.lark.coremd.impl.parse.g r100) {
            Intrinsics.checkNotNullParameter(r100, "registry");
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void c(com.ss.android.lark.coremd.impl.parse.j.a r100) {
            Intrinsics.checkNotNullParameter(r100, "builder");
            r100.a(v7b.i.class, new w());
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void d(com.ss.android.lark.coremd.impl.parse.c r100) {
            Intrinsics.checkNotNullParameter(r100, "registry");
        }
    }

    public static final class c implements com.ss.android.lark.coremd.base.parse.g {
        public c() {
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void c(com.ss.android.lark.coremd.impl.parse.j.a r100) {
            Intrinsics.checkNotNullParameter(r100, "builder");
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void a(com.ss.android.lark.coremd.impl.parse.l.a r100) {
            Intrinsics.checkNotNullParameter(r100, "builder");
            r100.a(v7b.d.class, new y());
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void b(com.ss.android.lark.coremd.impl.parse.g r100) {
            Intrinsics.checkNotNullParameter(r100, "registry");
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void d(com.ss.android.lark.coremd.impl.parse.c r100) {
            Intrinsics.checkNotNullParameter(r100, "registry");
        }
    }

    public static final class d implements com.ss.android.lark.coremd.base.parse.g {
        public d() {
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void c(com.ss.android.lark.coremd.impl.parse.j.a r100) {
            Intrinsics.checkNotNullParameter(r100, "builder");
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void a(com.ss.android.lark.coremd.impl.parse.l.a r100) {
            Intrinsics.checkNotNullParameter(r100, "builder");
            r100.a(v7b.w.class, new z());
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void b(com.ss.android.lark.coremd.impl.parse.g r100) {
            Intrinsics.checkNotNullParameter(r100, "registry");
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void d(com.ss.android.lark.coremd.impl.parse.c r100) {
            Intrinsics.checkNotNullParameter(r100, "registry");
        }
    }

    public static final class e implements com.ss.android.lark.coremd.base.parse.g {
        public e() {
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void c(com.ss.android.lark.coremd.impl.parse.j.a r100) {
            Intrinsics.checkNotNullParameter(r100, "builder");
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void a(com.ss.android.lark.coremd.impl.parse.l.a r100) {
            Intrinsics.checkNotNullParameter(r100, "builder");
            r100.a(v7b.b.class, new a0());
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void b(com.ss.android.lark.coremd.impl.parse.g r100) {
            Intrinsics.checkNotNullParameter(r100, "registry");
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void d(com.ss.android.lark.coremd.impl.parse.c r100) {
            Intrinsics.checkNotNullParameter(r100, "registry");
        }
    }

    public static final class f implements com.ss.android.lark.coremd.base.parse.g {
        public f() {
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void c(com.ss.android.lark.coremd.impl.parse.j.a r100) {
            Intrinsics.checkNotNullParameter(r100, "builder");
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void a(com.ss.android.lark.coremd.impl.parse.l.a r100) {
            Intrinsics.checkNotNullParameter(r100, "builder");
            r100.a(v7b.f.class, new b0());
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void b(com.ss.android.lark.coremd.impl.parse.g r100) {
            Intrinsics.checkNotNullParameter(r100, "registry");
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void d(com.ss.android.lark.coremd.impl.parse.c r100) {
            Intrinsics.checkNotNullParameter(r100, "registry");
        }
    }

    public static final class g {
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final un5.d f232370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final un5.e f232371b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final IntRange f232372c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f232373d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L8;
            return false;
        L8:
            h r101 = (h) r100;
            if (Intrinsics.areEqual(this.f232370a, r101.f232370a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f232371b, r101.f232371b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f232372c, r101.f232372c) == true) goto L18;
            return false;
        L18:
            if (this.f232373d == r101.f232373d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            un5.d r100 = this.f232370a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return (((((r101 * 31) + this.f232371b.hashCode()) * 31) + this.f232372c.hashCode()) * 31) + this.f232373d;
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public final String toString() {
            return "DocSpanMapping(prefixSpan=" + this.f232370a + ", docsFileSpan=" + this.f232371b + ", targetRange=" + this.f232372c + ", displayLength=" + this.f232373d + ')';
        }

        public h(un5.d r100, un5.e r101, IntRange r102, int r103) {
            Intrinsics.checkNotNullParameter(r101, "docsFileSpan");
            Intrinsics.checkNotNullParameter(r102, "targetRange");
            this.f232370a = r100;
            this.f232371b = r101;
            this.f232372c = r102;
            this.f232373d = r103;
        }
    }

    public static boolean e(char r100) {
        if (r100 != 160) goto L5;
    L14:
        return true;
    L5:
        if (r100 == 5760) goto L14;
        if (r100 == 8239) goto L14;
        if (r100 == 8287) goto L14;
        if (r100 == 12288) goto L14;
        switch(r100) {
            case 8192: goto L14;
            case 8193: goto L14;
            case 8194: goto L14;
            case 8195: goto L14;
            case 8196: goto L14;
            case 8197: goto L14;
            case 8198: goto L14;
            case 8199: goto L14;
            case 8200: goto L14;
            case 8201: goto L14;
            case 8202: goto L14;
            default: goto L13;
        };
    L13:
        return false;
    }

    static {
        f232366c = new Regex("^([ \\t]*)([-+*]|\\d{1,9}[.)])([ \\t]+).*$");
        f232367d = new Regex("^( {0,3})(#{7,9})(?:([ \\t]+)(.*)|[ \\t]*)$");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.widget.CommentTextView.c
    public final CharSequence a(CharSequence r310) {
        String r100 = r310.toString();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        String r101 = r100;
        CharSequence r110 = r310;
        CharSequence r111 = this.f232369b.a(r110);     // Catch: Exception -> L10
    L16:
        if (r101.length() != 0) goto L18;
        boolean r102 = true;
    L19:
        if (r102 == false) goto L45;
        if (r111 != null) goto L23;
        return r110;
    L23:
        return r111;
    L45:
        final ArrayList r103 = new ArrayList();     // Catch: Exception -> L38
        String r104 = CollectionsKt.joinToString$default(StringsKt.split$default(CollectionsKt.joinToString$default(StringsKt.split$default(r101, new char[]{'\n'}, false, 0, 6, null), "\n", null, null, 0, null, new CommentMarkdownParser$normalizeListIndent$1(this, r103), 30, null), new char[]{'\n'}, false, 0, 6, null), "\n", null, null, 0, null, CommentMarkdownParser$normalizeExtendedHeadingLevel$1.INSTANCE, 30, null);     // Catch: Exception -> L38
        w7b.d.a r105 = new w7b.d.a();     // Catch: Exception -> L38
        r105.f558605f = IncludeSourceSpans.BLOCKS;     // Catch: Exception -> L38
        r105.a(new com.ss.android.lark.commonmark.html.c(false));     // Catch: Exception -> L38
        v7b.s r106 = new w7b.d(r105).a(r104);     // Catch: Exception -> L38
        f(this, r106);     // Catch: Exception -> L38
        Ref.BooleanRef r107 = new Ref.BooleanRef();     // Catch: Exception -> L38
        d(r107, r106);     // Catch: Exception -> L38
        if (r107.element == true) goto L30;
        if (r111 != null) goto L29;
        return r110;
    L29:
        return r111;
    L30:
        t9b.b r108 = t9b.b.f545143a;     // Catch: Exception -> L38
        com.ss.android.lark.coremd.impl.parse.b.a r109 = t9b.b.a(this.f232368a.getContext());     // Catch: Exception -> L38
        List<Float> r112 = f0.f232333a;     // Catch: Exception -> L38
        CommentTextView r113 = this.f232368a;     // Catch: Exception -> L38
        Intrinsics.checkNotNullParameter(r113, "textView");     // Catch: Exception -> L38
        float r114 = r113.getTextSize();     // Catch: Exception -> L38
        Resources r115 = r113.getResources();     // Catch: Exception -> L38
        final int r116 = RangesKt.coerceAtLeast(MathKt.roundToInt(r114 / WindowDisplayMetricsOverride.apply(r115, r115.getDisplayMetrics()).scaledDensity), 1);     // Catch: Exception -> L38
        Function2<com.ss.android.lark.coremd.base.parse.k, com.ss.android.lark.coremd.base.parse.j, Unit> r117 = new CommentMarkdownTheme$create$1(r116);     // Catch: Exception -> L38
        Intrinsics.checkNotNullParameter(r117, "action");     // Catch: Exception -> L38
        r109.c(com.ss.android.lark.coremd.base.parse.l.a(com.ss.android.lark.coremd.base.parse.k.f419543b, r117));     // Catch: Exception -> L38
        r109.e(new a());     // Catch: Exception -> L38
        r109.e(new f());     // Catch: Exception -> L38
        r109.e(new c());     // Catch: Exception -> L38
        r109.e(new d());     // Catch: Exception -> L38
        r109.e(new e());     // Catch: Exception -> L38
        r109.e(new b());     // Catch: Exception -> L38
        r109.e(new m());     // Catch: Exception -> L38
        CharSequence r118 = r109.d(r106);     // Catch: Exception -> L38
        if ((!StringsKt.isBlank(r101)) == true) goto L33;
    L36:
        return b(r118, r111);
    L33:
        if (StringsKt.isBlank(r118) == false) goto L36;
        if (r111 == null) goto L44;
        return r111;
    L44:
        return r110;
    L38:
        e = move-exception;
        tt5.a.l("Comment#CommentMarkdownParser", "Failed to parse comment markdown!", e);
        if (r111 == null) goto L44;
        r110 = r111;
        goto L44
    L18:
        r102 = false;
    L10:
        e = e;
    L14:
        tt5.a.l("Comment#CommentMarkdownParser", "Failed to parse comment rich text!", e);
        r111 = r110;
    L12:
        e = e;
        r110 = r310;
        goto L14
    }

    public v(CommentTextView r100, m0 r101) {
        Intrinsics.checkNotNullParameter(r100, "commentTextView");
        Intrinsics.checkNotNullParameter(r101, "fallbackParser");
        this.f232368a = r100;
        this.f232369b = r101;
    }

    public static CharSequence b(CharSequence r210, CharSequence r211) {
        if ((r211 instanceof Spanned) == false) goto L5;
        Spanned r100 = (Spanned) r211;
    L6:
        if (r100 != null) goto L8;
        return r210;
    L8:
        String r101 = r100.toString();
        String r102 = r210.toString();
        List r103 = CollectionsKt.createListBuilder();
        List r104 = r103;
        CollectionsKt.addAll(r104, r100.getSpans(0, r100.length(), un5.a.class));
        CollectionsKt.addAll(r104, r100.getSpans(0, r100.length(), un5.d.class));
        CollectionsKt.addAll(r104, r100.getSpans(0, r100.length(), StyleSpan.class));
        List r105 = CollectionsKt.distinct(CollectionsKt.build(r103));
        if (r105.isEmpty() == false) goto L11;
    L108:
        return r210;
    L11:
        if (Intrinsics.areEqual(r101, r102) == true) goto L13;
    L15:
        SpannableStringBuilder r106 = new SpannableStringBuilder(r210);
        String r107 = r100.toString();
        String r108 = r106.toString();
        String r109 = StringsKt.replace$default(r107, "<doc.at.~#_%=`>", "", false, 4, null);
        List r110 = ArraysKt.sortedWith(r100.getSpans(0, r100.length(), un5.e.class), new c0(r100));
        if (r110.isEmpty() == false) goto L18;
        Set r111 = SetsKt.emptySet();
    L68:
        if (r111 != null) goto L70;
        return r211;
    L70:
        Iterator r112 = r105.iterator();
    L72:
        if (r112.hasNext() == false) goto L107;
        Object r113 = r112.next();
        if (r111.contains(r113) == true) goto L72;
        int r114 = r100.getSpanStart(r113);
        int r115 = r100.getSpanEnd(r113);
        if (r114 < 0) goto L99;
        if (r115 <= r114) goto L99;
        if (r115 > r101.length()) goto L99;
        String r116 = r101.substring(r114, r115);
        IntRange r117 = c(r101, r106.toString(), r116, r114);
        if (r117 == null) goto L85;
        if ((r113 instanceof StyleSpan) == false) goto L96;
        Object r118 = new StyleSpan(((StyleSpan) r113).getStyle());
    L97:
        r106.setSpan(r118, r117.getFirst(), r117.getLast() + 1, r100.getSpanFlags(r113));
        goto L72
    L96:
        r118 = r113;
        goto L97
    L85:
        if ((r113 instanceof un5.a) == false) goto L87;
    L90:
        boolean r119 = true;
    L91:
        if (r119 == false) goto L72;
        return r211;
    L87:
        if ((r113 instanceof un5.d) == true) goto L90;
        r119 = false;
    L99:
        if ((r113 instanceof un5.a) == false) goto L101;
    L104:
        boolean r120 = true;
    L105:
        if (r120 == false) goto L72;
        return r211;
    L101:
        if ((r113 instanceof un5.d) == true) goto L104;
        r120 = false;
        goto L105
    L107:
        return r106;
    L18:
        ArrayList r121 = new ArrayList();
        Iterator r122 = r110.iterator();
    L20:
        if (r122.hasNext() == false) goto L57;
        un5.e r123 = (un5.e) r122.next();
        int r124 = r100.getSpanStart(r123);
        int r125 = r100.getSpanEnd(r123);
        if (r124 < 0) goto L53;
        if (r125 <= r124) goto L53;
        if (r125 > r107.length()) goto L53;
        String r126 = r107.substring(r124, r125);
        String r127 = StringsKt.removePrefix(r126, "<doc.at.~#_%=`>");
        if (r127.length() != 0) goto L30;
        boolean r128 = true;
    L31:
        if (r128 == true) goto L53;
        if (Intrinsics.areEqual(r127, r126) == true) goto L53;
        IntRange r129 = c(r109, r108, r127, StringsKt.replace$default(r107.substring(0, RangesKt.coerceIn(r124, 0, r107.length())), "<doc.at.~#_%=`>", "", false, 4, null).length());
        if (r129 == null) goto L53;
        Intrinsics.checkNotNull(r123);
        int r130 = r124 + 15;
        Object[] r131 = r100.getSpans(r124, r130, un5.d.class);
        int r132 = r131.length;
        int r133 = 0;
    L39:
        if (r133 >= r132) goto L51;
        Object r212 = r131[r133];
        Object[] r213 = r131;
        un5.d r134 = (un5.d) r212;
        int r214 = r132;
        if (r100.getSpanStart(r134) == r124) goto L43;
    L47:
        boolean r135 = false;
    L48:
        if (r135 == true) goto L52;
        r133 = r133 + 1;
        r131 = r213;
        r132 = r214;
    L52:
        h r136 = new h((un5.d) r212, r123, r129, r127.length());
    L54:
        if (r136 == null) goto L56;
        r121.add(r136);
    L56:
        r107 = r107;
        r108 = r108;
        r109 = r109;
        goto L20
    L43:
        if (r100.getSpanEnd(r134) > r130) goto L47;
        if (Intrinsics.areEqual(r134.f550777c, r123.f550786d) == false) goto L47;
        r135 = true;
        goto L48
    L51:
        r212 = null;
        goto L52
    L30:
        r128 = false;
    L53:
        r136 = null;
        goto L54
    L57:
        List r137 = CollectionsKt.sortedWith(r121, new d0());
        if (r137.size() == r110.size()) goto L60;
        r111 = null;
        goto L68
    L60:
        LinkedHashSet r138 = new LinkedHashSet();
        Iterator r139 = r137.iterator();
    L62:
        if (r139.hasNext() == false) goto L67;
        h r140 = (h) r139.next();
        int r141 = r140.f232372c.getFirst();
        r106.insert(r141, "<doc.at.~#_%=`>");
        un5.d r142 = r140.f232370a;
        if (r142 == null) goto L66;
        r106.setSpan(r142, r141, r141 + 15, r100.getSpanFlags(r142));
        r138.add(r142);
    L66:
        int r143 = (r141 + 15) + r140.f232373d;
        un5.e r144 = r140.f232371b;
        r106.setSpan(r144, r141, r143, r100.getSpanFlags(r144));
        r138.add(r140.f232371b);
        goto L62
    L67:
        r111 = r138;
        goto L68
    L13:
        if ((r210 instanceof Spanned) == false) goto L15;
    L5:
        r100 = null;
        goto L6
    }

    public static final void d(Ref.BooleanRef r100, v7b.s r101) {
        if ((r101 instanceof v7b.a0) == false) goto L5;
    L10:
        r100.element = true;
    L11:
        v7b.s r102 = r101.f553569e;
    L12:
        if (r102 == null) goto L14;
        v7b.s r103 = r102.f553572h;
        d(r100, r102);
        r102 = r103;
        goto L12
    L14:
        return;
    L5:
        if ((r101 instanceof v7b.i) == true) goto L10;
        if ((r101 instanceof v7b.c) == true) goto L10;
        if ((r101 instanceof v7b.u) == false) goto L11;
        goto L10
    }

    public static final void f(v r100, v7b.s r101) {
        if ((r101 instanceof v7b.i) == false) goto L34;
        v7b.i r102 = (v7b.i) r101;
        r100.getClass();
        v7b.s r103 = r102.f553569e;
        if ((r103 instanceof v7b.b0) == false) goto L7;
        v7b.b0 r104 = (v7b.b0) r103;
    L8:
        if (r104 == null) goto L34;
        String r105 = r104.f553548j;
        if (r105 != null) goto L13;
        r105 = "";
    L13:
        boolean r106 = false;
        if (StringsKt.startsWith$default(r105, "COMMENT_MD_HEADING_LEVEL_", false, 2, null) == false) goto L34;
        Character r107 = StringsKt.getOrNull(r105, 25);
        if (r107 == null) goto L34;
        Integer r108 = CharsKt.digitToIntOrNull(r107.charValue());
        if (r108 == null) goto L34;
        int r109 = r108.intValue();
        if (7 <= r109) goto L23;
    L25:
        boolean r110 = false;
    L26:
        if (r110 == false) goto L34;
        r102.f553557j = r109;
        String r111 = StringsKt.removePrefix(r105.substring(RangesKt.coerceAtMost(26, r105.length())), " ");
        if (r111.length() != 0) goto L31;
        r106 = true;
    L31:
        if (r106 == false) goto L33;
        r104.p();
        goto L34
    L33:
        r104.f553548j = r111;
        goto L34
    L23:
        if (r109 >= 10) goto L25;
        r110 = true;
        goto L26
    L7:
        r104 = null;
    L34:
        v7b.s r112 = r101.f553569e;
    L35:
        if (r112 == null) goto L37;
        v7b.s r113 = r112.f553572h;
        f(r100, r112);
        r112 = r113;
        goto L35
    }

    public static IntRange c(String r110, String r111, String r112, int r113) {
        int r100 = 0;
        if (r112.length() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L9;
        return null;
    L9:
        int r102 = 0;
        int r103 = 0;
    L10:
        if (r103 >= r113) goto L16;
        int r104 = StringsKt.indexOf$default(r110, r112, r103, false, 4, null);
        if (r104 < 0) goto L16;
        if (r104 >= r113) goto L16;
        r102 = r102 + 1;
        r103 = r104 + r112.length();
    L16:
        int r105 = r102 + 1;
        int r114 = -1;
        int r106 = 0;
    L17:
        if (r100 >= r105) goto L23;
        r114 = StringsKt.indexOf$default(r111, r112, r106, false, 4, null);
        if (r114 < 0) goto L20;
        r106 = r114 + r112.length();
        r100 = r100 + 1;
        goto L17
    L20:
        return null;
    L23:
        return RangesKt.until(r114, r112.length() + r114);
    L5:
        r101 = false;
        goto L7
    }
}
