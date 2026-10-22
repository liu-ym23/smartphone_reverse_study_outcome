package com.bytedance.ee.bear.middleground.comment.widget;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import androidx.appcompat.widget.AppCompatTextView;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v implements CommentTextView.c {
    public static final Regex c = null;
    public static final Regex d = null;
    public final CommentTextView a;
    public final CommentTextView.c b;

    public static final class a implements com.ss.android.lark.coremd.base.parse.g {
        public a() {
        }

        public final void a(com.ss.android.lark.coremd.impl.parse.l.a r3) {
            Intrinsics.checkNotNullParameter(r3, "builder");
            r3.a(v7b.b0.class, new s());
            r3.a(v7b.v.class, new t());
            r3.a(v7b.a0.class, new u());
        }

        public final void b(com.ss.android.lark.coremd.impl.parse.g r2) {
            Intrinsics.checkNotNullParameter(r2, "registry");
        }

        public final void c(com.ss.android.lark.coremd.impl.parse.j.a r3) {
            Intrinsics.checkNotNullParameter(r3, "builder");
            r3.a(v7b.a0.class, new r());
        }

        public final void d(com.ss.android.lark.coremd.impl.parse.c r2) {
            Intrinsics.checkNotNullParameter(r2, "registry");
        }
    }

    public static final class b implements com.ss.android.lark.coremd.base.parse.g {
        public b() {
        }

        public final void a(com.ss.android.lark.coremd.impl.parse.l.a r3) {
            Intrinsics.checkNotNullParameter(r3, "builder");
            r3.a(v7b.i.class, new x());
        }

        public final void b(com.ss.android.lark.coremd.impl.parse.g r2) {
            Intrinsics.checkNotNullParameter(r2, "registry");
        }

        public final void c(com.ss.android.lark.coremd.impl.parse.j.a r3) {
            Intrinsics.checkNotNullParameter(r3, "builder");
            r3.a(v7b.i.class, new w());
        }

        public final void d(com.ss.android.lark.coremd.impl.parse.c r2) {
            Intrinsics.checkNotNullParameter(r2, "registry");
        }
    }

    public static final class c implements com.ss.android.lark.coremd.base.parse.g {
        public c() {
        }

        public final void c(com.ss.android.lark.coremd.impl.parse.j.a r2) {
            Intrinsics.checkNotNullParameter(r2, "builder");
        }

        public final void a(com.ss.android.lark.coremd.impl.parse.l.a r3) {
            Intrinsics.checkNotNullParameter(r3, "builder");
            r3.a(v7b.d.class, new y());
        }

        public final void b(com.ss.android.lark.coremd.impl.parse.g r2) {
            Intrinsics.checkNotNullParameter(r2, "registry");
        }

        public final void d(com.ss.android.lark.coremd.impl.parse.c r2) {
            Intrinsics.checkNotNullParameter(r2, "registry");
        }
    }

    public static final class d implements com.ss.android.lark.coremd.base.parse.g {
        public d() {
        }

        public final void c(com.ss.android.lark.coremd.impl.parse.j.a r2) {
            Intrinsics.checkNotNullParameter(r2, "builder");
        }

        public final void a(com.ss.android.lark.coremd.impl.parse.l.a r3) {
            Intrinsics.checkNotNullParameter(r3, "builder");
            r3.a(v7b.w.class, new z());
        }

        public final void b(com.ss.android.lark.coremd.impl.parse.g r2) {
            Intrinsics.checkNotNullParameter(r2, "registry");
        }

        public final void d(com.ss.android.lark.coremd.impl.parse.c r2) {
            Intrinsics.checkNotNullParameter(r2, "registry");
        }
    }

    public static final class e implements com.ss.android.lark.coremd.base.parse.g {
        public e() {
        }

        public final void c(com.ss.android.lark.coremd.impl.parse.j.a r2) {
            Intrinsics.checkNotNullParameter(r2, "builder");
        }

        public final void a(com.ss.android.lark.coremd.impl.parse.l.a r3) {
            Intrinsics.checkNotNullParameter(r3, "builder");
            r3.a(v7b.b.class, new a0());
        }

        public final void b(com.ss.android.lark.coremd.impl.parse.g r2) {
            Intrinsics.checkNotNullParameter(r2, "registry");
        }

        public final void d(com.ss.android.lark.coremd.impl.parse.c r2) {
            Intrinsics.checkNotNullParameter(r2, "registry");
        }
    }

    public static final class f implements com.ss.android.lark.coremd.base.parse.g {
        public f() {
        }

        public final void c(com.ss.android.lark.coremd.impl.parse.j.a r2) {
            Intrinsics.checkNotNullParameter(r2, "builder");
        }

        public final void a(com.ss.android.lark.coremd.impl.parse.l.a r3) {
            Intrinsics.checkNotNullParameter(r3, "builder");
            r3.a(v7b.f.class, new b0());
        }

        public final void b(com.ss.android.lark.coremd.impl.parse.g r2) {
            Intrinsics.checkNotNullParameter(r2, "registry");
        }

        public final void d(com.ss.android.lark.coremd.impl.parse.c r2) {
            Intrinsics.checkNotNullParameter(r2, "registry");
        }
    }

    public static final class g {
    }

    public static final class h {
        public final un5.d a;
        public final un5.e b;
        public final IntRange c;
        public final int d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof h) == true) goto L8;
            return false;
        L8:
            h r6 = (h) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            un5.d r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (((((r1 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d;
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public final String toString() {
            return "DocSpanMapping(prefixSpan=" + this.a + ", docsFileSpan=" + this.b + ", targetRange=" + this.c + ", displayLength=" + this.d + ')';
        }

        public h(un5.d r2, un5.e r3, IntRange r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "docsFileSpan");
            Intrinsics.checkNotNullParameter(r4, "targetRange");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static boolean e(char r1) {
        if (r1 != 160) goto L5;
    L14:
        return true;
    L5:
        if (r1 == 5760) goto L14;
        if (r1 == 8239) goto L14;
        if (r1 == 8287) goto L14;
        if (r1 == 12288) goto L14;
        switch(r1) {
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
        c = new Regex("^([ \\t]*)([-+*]|\\d{1,9}[.)])([ \\t]+).*$");
        d = new Regex("^( {0,3})(#{7,9})(?:([ \\t]+)(.*)|[ \\t]*)$");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.widget.CommentTextView.c
    public final CharSequence a(CharSequence r31) {
        String r0 = r31.toString();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r9 = r0;
        CharSequence r10 = r31;
        CharSequence r11 = this.b.a(r10);     // Catch: Exception -> L10
    L16:
        if (r9.length() != 0) goto L18;
        boolean r1 = true;
    L19:
        if (r1 == false) goto L45;
        if (r11 != null) goto L23;
        return r10;
    L23:
        return r11;
    L45:
        final ArrayList r2 = new ArrayList();     // Catch: Exception -> L38
        String r3 = CollectionsKt.joinToString$default(StringsKt.split$default(CollectionsKt.joinToString$default(StringsKt.split$default(r9, new char[]{'\n'}, false, 0, 6, null), "\n", null, null, 0, null, new CommentMarkdownParser$normalizeListIndent$1(this, r2), 30, null), new char[]{'\n'}, false, 0, 6, null), "\n", null, null, 0, null, CommentMarkdownParser$normalizeExtendedHeadingLevel$1.INSTANCE, 30, null);     // Catch: Exception -> L38
        w7b.d.a r4 = new w7b.d.a();     // Catch: Exception -> L38
        r4.f = IncludeSourceSpans.BLOCKS;     // Catch: Exception -> L38
        r4.a(new com.ss.android.lark.commonmark.html.c(false));     // Catch: Exception -> L38
        v7b.s r5 = new w7b.d(r4).a(r3);     // Catch: Exception -> L38
        f(this, r5);     // Catch: Exception -> L38
        Ref.BooleanRef r6 = new Ref.BooleanRef();     // Catch: Exception -> L38
        d(r6, r5);     // Catch: Exception -> L38
        if (r6.element == true) goto L30;
        if (r11 != null) goto L29;
        return r10;
    L29:
        return r11;
    L30:
        t9b.b r7 = t9b.b.a;     // Catch: Exception -> L38
        com.ss.android.lark.coremd.impl.parse.b.a r8 = t9b.b.a(this.a.getContext());     // Catch: Exception -> L38
        List<Float> r12 = f0.a;     // Catch: Exception -> L38
        AppCompatTextView r13 = this.a;     // Catch: Exception -> L38
        Intrinsics.checkNotNullParameter(r13, "textView");     // Catch: Exception -> L38
        float r14 = r13.getTextSize();     // Catch: Exception -> L38
        Resources r15 = r13.getResources();     // Catch: Exception -> L38
        final int r16 = RangesKt.coerceAtLeast(MathKt.roundToInt(r14 / WindowDisplayMetricsOverride.apply(r15, r15.getDisplayMetrics()).scaledDensity), 1);     // Catch: Exception -> L38
        Function2<com.ss.android.lark.coremd.base.parse.k, com.ss.android.lark.coremd.base.parse.j, Unit> r17 = new CommentMarkdownTheme$create$1(r16);     // Catch: Exception -> L38
        Intrinsics.checkNotNullParameter(r17, "action");     // Catch: Exception -> L38
        r8.c(com.ss.android.lark.coremd.base.parse.l.a(com.ss.android.lark.coremd.base.parse.k.b, r17));     // Catch: Exception -> L38
        r8.e(new a());     // Catch: Exception -> L38
        r8.e(new f());     // Catch: Exception -> L38
        r8.e(new c());     // Catch: Exception -> L38
        r8.e(new d());     // Catch: Exception -> L38
        r8.e(new e());     // Catch: Exception -> L38
        r8.e(new b());     // Catch: Exception -> L38
        r8.e(new m());     // Catch: Exception -> L38
        CharSequence r18 = r8.d(r5);     // Catch: Exception -> L38
        if ((!StringsKt.isBlank(r9)) == true) goto L33;
    L36:
        return b(r18, r11);
    L33:
        if (StringsKt.isBlank(r18) == false) goto L36;
        if (r11 == null) goto L44;
        return r11;
    L44:
        return r10;
    L38:
        e = move-exception;
        tt5.a.l("Comment#CommentMarkdownParser", "Failed to parse comment markdown!", e);
        if (r11 == null) goto L44;
        r10 = r11;
        goto L44
    L18:
        r1 = false;
    L10:
        e = e;
    L14:
        tt5.a.l("Comment#CommentMarkdownParser", "Failed to parse comment rich text!", e);
        r11 = r10;
    L12:
        e = e;
        r10 = r31;
        goto L14
    }

    public v(CommentTextView r2, m0 r3) {
        Intrinsics.checkNotNullParameter(r2, "commentTextView");
        Intrinsics.checkNotNullParameter(r3, "fallbackParser");
        this.a = r2;
        this.b = r3;
    }

    public static CharSequence b(CharSequence r24, CharSequence r25) {
        if ((r25 instanceof Spanned) == false) goto L5;
        Spanned r2 = (Spanned) r25;
    L6:
        if (r2 != null) goto L8;
        return r24;
    L8:
        String r4 = r2.toString();
        String r5 = r24.toString();
        List r6 = CollectionsKt.createListBuilder();
        List r7 = r6;
        CollectionsKt.addAll(r7, r2.getSpans(0, r2.length(), un5.a.class));
        CollectionsKt.addAll(r7, r2.getSpans(0, r2.length(), un5.d.class));
        CollectionsKt.addAll(r7, r2.getSpans(0, r2.length(), StyleSpan.class));
        List r8 = CollectionsKt.distinct(CollectionsKt.build(r6));
        if (r8.isEmpty() == false) goto L11;
    L108:
        return r24;
    L11:
        if (Intrinsics.areEqual(r4, r5) == true) goto L13;
    L15:
        SpannableStringBuilder r9 = new SpannableStringBuilder(r24);
        String r0 = r2.toString();
        String r10 = r9.toString();
        String r11 = StringsKt.replace$default(r0, "<doc.at.~#_%=`>", "", false, 4, null);
        List r12 = ArraysKt.sortedWith(r2.getSpans(0, r2.length(), un5.e.class), new c0(r2));
        if (r12.isEmpty() == false) goto L18;
        Set r3 = SetsKt.emptySet();
    L68:
        if (r3 != null) goto L70;
        return r25;
    L70:
        Iterator r13 = r8.iterator();
    L72:
        if (r13.hasNext() == false) goto L107;
        Object r14 = r13.next();
        if (r3.contains(r14) == true) goto L72;
        int r15 = r2.getSpanStart(r14);
        int r16 = r2.getSpanEnd(r14);
        if (r15 < 0) goto L99;
        if (r16 <= r15) goto L99;
        if (r16 > r4.length()) goto L99;
        String r17 = r4.substring(r15, r16);
        IntRange r18 = c(r4, r9.toString(), r17, r15);
        if (r18 == null) goto L85;
        if ((r14 instanceof StyleSpan) == false) goto L96;
        Object r19 = new StyleSpan(((StyleSpan) r14).getStyle());
    L97:
        r9.setSpan(r19, r18.getFirst(), r18.getLast() + 1, r2.getSpanFlags(r14));
        goto L72
    L96:
        r19 = r14;
        goto L97
    L85:
        if ((r14 instanceof un5.a) == false) goto L87;
    L90:
        boolean r110 = true;
    L91:
        if (r110 == false) goto L72;
        return r25;
    L87:
        if ((r14 instanceof un5.d) == true) goto L90;
        r110 = false;
    L99:
        if ((r14 instanceof un5.a) == false) goto L101;
    L104:
        boolean r20 = true;
    L105:
        if (r20 == false) goto L72;
        return r25;
    L101:
        if ((r14 instanceof un5.d) == true) goto L104;
        r20 = false;
        goto L105
    L107:
        return r9;
    L18:
        ArrayList r111 = new ArrayList();
        Iterator r112 = r12.iterator();
    L20:
        if (r112.hasNext() == false) goto L57;
        un5.e r113 = (un5.e) r112.next();
        int r21 = r2.getSpanStart(r113);
        int r114 = r2.getSpanEnd(r113);
        if (r21 < 0) goto L53;
        if (r114 <= r21) goto L53;
        if (r114 > r0.length()) goto L53;
        String r115 = r0.substring(r21, r114);
        String r116 = StringsKt.removePrefix(r115, "<doc.at.~#_%=`>");
        if (r116.length() != 0) goto L30;
        boolean r117 = true;
    L31:
        if (r117 == true) goto L53;
        if (Intrinsics.areEqual(r116, r115) == true) goto L53;
        IntRange r118 = c(r11, r10, r116, StringsKt.replace$default(r0.substring(0, RangesKt.coerceIn(r21, 0, r0.length())), "<doc.at.~#_%=`>", "", false, 4, null).length());
        if (r118 == null) goto L53;
        Intrinsics.checkNotNull(r113);
        int r119 = r21 + 15;
        Object[] r1 = r2.getSpans(r21, r119, un5.d.class);
        int r22 = r1.length;
        int r23 = 0;
    L39:
        if (r23 >= r22) goto L51;
        Object r26 = r1[r23];
        Object[] r27 = r1;
        un5.d r28 = (un5.d) r26;
        int r29 = r22;
        if (r2.getSpanStart(r28) == r21) goto L43;
    L47:
        boolean r30 = false;
    L48:
        if (r30 == true) goto L52;
        r23 = r23 + 1;
        r1 = r27;
        r22 = r29;
    L52:
        h r31 = new h((un5.d) r26, r113, r118, r116.length());
    L54:
        if (r31 == null) goto L56;
        r111.add(r31);
    L56:
        r0 = r0;
        r10 = r10;
        r11 = r11;
        goto L20
    L43:
        if (r2.getSpanEnd(r28) > r119) goto L47;
        if (Intrinsics.areEqual(r28.c, r113.d) == false) goto L47;
        r30 = true;
        goto L48
    L51:
        r26 = null;
        goto L52
    L30:
        r117 = false;
    L53:
        r31 = null;
        goto L54
    L57:
        List r32 = CollectionsKt.sortedWith(r111, new d0());
        if (r32.size() == r12.size()) goto L60;
        r3 = null;
        goto L68
    L60:
        LinkedHashSet r33 = new LinkedHashSet();
        Iterator r34 = r32.iterator();
    L62:
        if (r34.hasNext() == false) goto L67;
        h r35 = (h) r34.next();
        int r36 = r35.c.getFirst();
        r9.insert(r36, "<doc.at.~#_%=`>");
        un5.d r120 = r35.a;
        if (r120 == null) goto L66;
        r9.setSpan(r120, r36, r36 + 15, r2.getSpanFlags(r120));
        r33.add(r120);
    L66:
        int r121 = (r36 + 15) + r35.d;
        un5.e r122 = r35.b;
        r9.setSpan(r122, r36, r121, r2.getSpanFlags(r122));
        r33.add(r35.b);
        goto L62
    L67:
        r3 = r33;
        goto L68
    L13:
        if ((r24 instanceof Spanned) == false) goto L15;
    L5:
        r2 = null;
        goto L6
    }

    public static final void d(Ref.BooleanRef r1, v7b.s r2) {
        if ((r2 instanceof v7b.a0) == false) goto L5;
    L10:
        r1.element = true;
    L11:
        v7b.s r3 = r2.e;
    L12:
        if (r3 == null) goto L14;
        v7b.s r0 = r3.h;
        d(r1, r3);
        r3 = r0;
        goto L12
    L14:
        return;
    L5:
        if ((r2 instanceof v7b.i) == true) goto L10;
        if ((r2 instanceof v7b.c) == true) goto L10;
        if ((r2 instanceof v7b.u) == false) goto L11;
        goto L10
    }

    public static final void f(v r7, v7b.s r8) {
        if ((r8 instanceof v7b.i) == false) goto L34;
        v7b.i r0 = (v7b.i) r8;
        r7.getClass();
        v7b.b0 r1 = ((v7b.s) r0).e;
        if ((r1 instanceof v7b.b0) == false) goto L7;
        v7b.b0 r2 = r1;
    L8:
        if (r2 == null) goto L34;
        String r3 = r2.j;
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        boolean r6 = false;
        if (StringsKt.startsWith$default(r3, "COMMENT_MD_HEADING_LEVEL_", false, 2, null) == false) goto L34;
        Character r4 = StringsKt.getOrNull(r3, 25);
        if (r4 == null) goto L34;
        Integer r5 = CharsKt.digitToIntOrNull(r4.charValue());
        if (r5 == null) goto L34;
        int r9 = r5.intValue();
        if (7 <= r9) goto L23;
    L25:
        boolean r10 = false;
    L26:
        if (r10 == false) goto L34;
        r0.j = r9;
        String r11 = StringsKt.removePrefix(r3.substring(RangesKt.coerceAtMost(26, r3.length())), " ");
        if (r11.length() != 0) goto L31;
        r6 = true;
    L31:
        if (r6 == false) goto L33;
        r2.p();
        goto L34
    L33:
        r2.j = r11;
        goto L34
    L23:
        if (r9 >= 10) goto L25;
        r10 = true;
        goto L26
    L7:
        r2 = null;
    L34:
        v7b.s r12 = r8.e;
    L35:
        if (r12 == null) goto L37;
        v7b.s r13 = r12.h;
        f(r7, r12);
        r12 = r13;
        goto L35
    }

    public static IntRange c(String r10, String r11, String r12, int r13) {
        int r2 = 0;
        if (r12.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        return null;
    L9:
        int r1 = 0;
        int r6 = 0;
    L10:
        if (r6 >= r13) goto L16;
        int r4 = StringsKt.indexOf$default(r10, r12, r6, false, 4, null);
        if (r4 < 0) goto L16;
        if (r4 >= r13) goto L16;
        r1 = r1 + 1;
        r6 = r4 + r12.length();
    L16:
        int r3 = r1 + 1;
        int r14 = -1;
        int r7 = 0;
    L17:
        if (r2 >= r3) goto L23;
        r14 = StringsKt.indexOf$default(r11, r12, r7, false, 4, null);
        if (r14 < 0) goto L20;
        r7 = r14 + r12.length();
        r2 = r2 + 1;
        goto L17
    L20:
        return null;
    L23:
        return RangesKt.until(r14, r12.length() + r14);
    L5:
        r0 = false;
        goto L7
    }
}
