package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.richtext;

import android.content.Context;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceLog;
import com.bytedance.ee.bear.middleground.comment.widget.CommentEditText;
import com.bytedance.ee.bear.middleground.comment.widget.i0;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import un5.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CommentVoiceEditTextBridge {
    public static final /* synthetic */ int i = 0;
    public final CommentEditText a;
    public boolean b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public String g;
    public final Map<String, c> h;

    public static final class a {
        public static String b(CharSequence r6) {
            Intrinsics.checkNotNullParameter(r6, "source");
            com.bytedance.ee.bear.middleground.comment.audio.voiceinput.richtext.a.a.getClass();
            Intrinsics.checkNotNullParameter(r6, "source");
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
            SpannableStringBuilder r2 = com.bytedance.ee.bear.middleground.comment.input.utils.d.a(r6);     // Catch: Throwable -> L9
            db5.e r3 = new db5.e();     // Catch: Throwable -> L9
            db5.a r4 = new i0().c(new db5.g(r2));     // Catch: Throwable -> L9
            StringBuilder r5 = new StringBuilder(r4.a);     // Catch: Throwable -> L9
            int r7 = r4.b.length;     // Catch: Throwable -> L9
        L4:
            r7 = r7 - 1;     // Catch: Throwable -> L9
            if (r7 < 0) goto L7;
            db5.f.c(r5, r4.b[r7]);     // Catch: Throwable -> L9
            goto L4
        L7:
            Object r8 = Result.constructor-impl(r3.c(r5.toString()));     // Catch: Throwable -> L9
        L11:
            Throwable r9 = Result.exceptionOrNull-impl(r8);
            if (r9 == null) goto L15;
            tt5.a.e("CommentVoice", "[mapper] toCommentXml failed, fallback plain text", r9, false);
            r8 = r6.toString();
        L15:
            String r10 = (String) r8;
            StringBuilder r11 = new StringBuilder("[mapper] toCommentXml ");
            CommentVoiceLog.a.getClass();
            r11.append(CommentVoiceLog.i("source", r6));
            r11.append(", ");
            r11.append(CommentVoiceLog.i("xml", r10));
            tt5.a.h("CommentVoice", r11.toString());
            return r10;
        L9:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            r8 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L11
        }

        public static SpannableStringBuilder a(Context r1, String r2, RichText r3) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "content");
            Intrinsics.checkNotNullParameter(r3, "richText");
            return com.bytedance.ee.bear.middleground.comment.audio.voiceinput.richtext.a.a.h(r1, r2, r3);
        }
    }

    public static final class b {
        public final int a;
        public final int b;
        public final String c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "MentionSpanInfo(start=" + this.a + ", end=" + this.b + ", token=" + this.c + ", content=" + this.d + ')';
        }

        public b(int r2, int r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(r5, "content");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class c {
        public final boolean a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == true) goto L11;
            r1 = 1237;
        L11:
            return r2 + r1;
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "UserSpanState(isGray=" + this.a + ", isCanBeShare=" + this.b + ')';
        }

        public c(boolean r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d {
        public final boolean a;
        public final boolean b;
        public final boolean c;
        public final boolean d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == false) goto L9;
            int r3 = 1231;
        L10:
            int r4 = (r2 + r3) * 31;
            if (this.c == false) goto L13;
            int r5 = 1231;
        L14:
            int r6 = (r4 + r5) * 31;
            if (this.d == true) goto L19;
            r1 = 1237;
        L19:
            return r6 + r1;
        L13:
            r5 = 1237;
            goto L14
        L9:
            r3 = 1237;
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "VoiceTextUpdateResult(success=" + this.a + ", mentionChanged=" + this.b + ", wroteNonEmptyText=" + this.c + ", hasMention=" + this.d + ')';
        }

        public d(boolean r1, boolean r2, boolean r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class e<T> implements Comparator {
        public e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((b) r1).a), Integer.valueOf(((b) r2).a));
        }
    }

    public static final class f<T> implements Comparator {
        public final /* synthetic */ Comparator a;

        public f(e r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r0 = this.a.compare(r2, r3);
            if (r0 == 0) goto L6;
            return r0;
        L6:
            return ComparisonsKt.compareValues(Integer.valueOf(((b) r2).b), Integer.valueOf(((b) r3).b));
        }
    }

    public static final class g<T> implements Comparator {
        public final /* synthetic */ Comparator a;

        public g(f r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r0 = this.a.compare(r2, r3);
            if (r0 == 0) goto L6;
            return r0;
        L6:
            return ComparisonsKt.compareValues(((b) r2).c, ((b) r3).c);
        }
    }

    public static final class h<T> implements Comparator {
        public final /* synthetic */ Comparator a;

        public h(g r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r0 = this.a.compare(r2, r3);
            if (r0 == 0) goto L6;
            return r0;
        L6:
            return ComparisonsKt.compareValues(((b) r2).d, ((b) r3).d);
        }
    }

    public static final class i<T> implements Comparator {
        public i() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues((Integer) ((Pair) r2).getFirst(), (Integer) ((Pair) r1).getFirst());
        }
    }

    static {
    }

    public final CharSequence c() {
        Editable r0 = this.a.getText();
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0;
    }

    public CommentVoiceEditTextBridge(CommentEditText r2) {
        Intrinsics.checkNotNullParameter(r2, "editText");
        this.a = r2;
        this.g = "";
        this.h = new LinkedHashMap();
    }

    public static List e(CharSequence r12) {
        if ((r12 instanceof Spanned) == false) goto L31;
        if (r12.length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L31;
        Spanned r1 = (Spanned) r12;
        Object[] r3 = r1.getSpans(0, r12.length(), l.class);
        ArrayList r4 = new ArrayList();
        int r5 = r3.length;
        int r6 = 0;
    L11:
        if (r6 >= r5) goto L29;
        l r7 = (l) r3[r6];
        int r8 = r1.getSpanStart(r7);
        int r9 = r1.getSpanEnd(r7);
        String r10 = r7.d;
        if (r10 != null) goto L15;
        r10 = "";
    L15:
        if (r8 < 0) goto L24;
        if (r9 <= r8) goto L24;
        if (r10.length() != 0) goto L20;
        boolean r11 = true;
    L21:
        if (r11 == true) goto L24;
        b r13 = new b(r8, r9, r10, r12.subSequence(r8, r9).toString());
    L25:
        if (r13 == null) goto L27;
        r4.add(r13);
    L27:
        r6 = r6 + 1;
        goto L11
    L20:
        r11 = false;
    L24:
        r13 = null;
        goto L25
    L29:
        return CollectionsKt.sortedWith(r4, new h(new g(new f(new e()))));
    L7:
        r0 = false;
    L31:
        return CollectionsKt.emptyList();
    }

    public static CharSequence h(CharSequence r11) {
        if ((r11 instanceof Spanned) == false) goto L5;
        Spanned r0 = (Spanned) r11;
    L6:
        if (r0 != null) goto L8;
        return r11;
    L8:
        SpannableStringBuilder r2 = new SpannableStringBuilder(r11);
        int r4 = 0;
        Object[] r12 = r0.getSpans(0, r0.length(), com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.a.class);
        ArrayList r3 = new ArrayList();
        int r5 = r12.length;
    L9:
        if (r4 >= r5) goto L25;
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.a r6 = (com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.a) r12[r4];
        int r7 = r0.getSpanStart(r6);
        int r8 = r0.getSpanEnd(r6);
        if (r7 < 0) goto L21;
        if (r8 <= r7) goto L21;
        if (r8 > r2.length()) goto L21;
        if (r7 <= 0) goto L20;
        int r9 = r7 - 1;
        if (r2.charAt(r9) != ' ') goto L20;
        r7 = r9;
    L20:
        Pair r10 = TuplesKt.to(Integer.valueOf(r7), Integer.valueOf(r8));
    L22:
        if (r10 == null) goto L24;
        r3.add(r10);
    L24:
        r4 = r4 + 1;
    L21:
        r10 = null;
        goto L22
    L25:
        Iterator r13 = CollectionsKt.sortedWith(r3, new i()).iterator();
    L27:
        if (r13.hasNext() == false) goto L29;
        Pair r1 = (Pair) r13.next();
        r2.delete(((Number) r1.component1()).intValue(), ((Number) r1.component2()).intValue());
        goto L27
    L29:
        return r2;
    L5:
        r0 = null;
        goto L6
    }

    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "pendingPeriod");
        Editable r0 = this.a.getText();
        if (r0 == null) goto L5;
        int r1 = r0.length();
    L6:
        this.c = RangesKt.coerceIn(Math.min(this.a.getSelectionStart(), this.a.getSelectionEnd()), 0, r1);
        this.d = RangesKt.coerceIn(Math.max(this.a.getSelectionStart(), this.a.getSelectionEnd()), 0, r1);
        this.e = 0;
        this.f = false;
        this.g = r5;
        ((LinkedHashMap) this.h).clear();
        f(this.a.getText());
        this.b = true;
        tt5.a.h("CommentVoice", "[bridge] beginVoiceSession start=" + this.c + ", end=" + this.d + ", textLength=" + r1 + ", pendingPeriodLen=" + r5.length());
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public final boolean d(CharSequence r9) {
        Intrinsics.checkNotNullParameter(r9, "text");
        final SpannableStringBuilder r10 = com.bytedance.ee.bear.middleground.comment.audio.voiceinput.richtext.a.a.j(this.a.getContext(), r9, false);
        final Editable r0 = this.a.getText();
        if (r0 == null) goto L5;
        CharSequence r1 = r0;
    L6:
        List r2 = e(r1);
        if (r0 != null) goto L18;
        this.a.O(new CommentVoiceEditTextBridge$insertCurrentText$1(this, r10));
        g(r10.length());
        StringBuilder r3 = new StringBuilder("[bridge] insertCurrentText setText mentionChanged=");
        Editable r4 = this.a.getText();
        Editable r5 = r4;
        if (r4 != null) goto L11;
        r5 = r10;
    L11:
        r3.append(!Intrinsics.areEqual(r2, e(r5)));
        r3.append(", ");
        CommentVoiceLog.a.getClass();
        r3.append(CommentVoiceLog.i("normalized", r10));
        tt5.a.h("CommentVoice", r3.toString());
        Editable r6 = this.a.getText();
        Editable r11 = r10;
        if (r6 == null) goto L15;
        r11 = r6;
    L15:
        boolean r12 = Intrinsics.areEqual(r2, e(r11));
    L17:
        return !r12;
    L18:
        final int r7 = RangesKt.coerceIn(Math.min(this.a.getSelectionStart(), this.a.getSelectionEnd()), 0, r0.length());
        final int r8 = RangesKt.coerceIn(Math.max(this.a.getSelectionStart(), this.a.getSelectionEnd()), 0, r0.length());
        this.a.O(new CommentVoiceEditTextBridge$insertCurrentText$2(r0, r7, r8, r10));
        b(r10, r0, r7, MapsKt.emptyMap());
        g(r10.length() + r7);
        StringBuilder r13 = new StringBuilder("[bridge] insertCurrentText start=");
        r13.append(r7);
        r13.append(", end=");
        r13.append(r8);
        r13.append(", mentionChanged=");
        r13.append(!Intrinsics.areEqual(r2, e(r0)));
        r13.append(", ");
        CommentVoiceLog.a.getClass();
        r13.append(CommentVoiceLog.i("current", r0));
        tt5.a.h("CommentVoice", r13.toString());
        r12 = Intrinsics.areEqual(r2, e(r0));
        goto L17
    L5:
        r1 = "";
        goto L6
    }

    public final void f(CharSequence r10) {
        if ((r10 instanceof Spanned) == true) goto L5;
        return;
    L5:
        if (r10.length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L31;
        Spanned r11 = (Spanned) r10;
        Object[] r12 = r11.getSpans(0, r11.length(), l.class);
        int r1 = r12.length;
        int r3 = 0;
    L11:
        if (r3 >= r1) goto L32;
        l r4 = (l) r12[r3];
        String r5 = r4.d;
        if (r5 != null) goto L16;
        r5 = "";
    L16:
        if (r5.length() <= 0) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == false) goto L25;
        boolean r7 = r4.j;
        if (r7 == false) goto L23;
    L24:
        this.h.put(r5, new c(r7, r4.k));
        goto L25
    L23:
        if (r4.k == true) goto L24;
    L25:
        r3 = r3 + 1;
        goto L11
    L18:
        r6 = false;
        goto L19
    L32:
        return;
    L31:
        return;
    L7:
        r0 = false;
        goto L8
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void g(int r4) {
        Editable r0 = this.a.getText();
        if (r0 == null) goto L5;
        int r1 = r0.length();
    L6:
        this.a.setSelection(RangesKt.coerceIn(r4, 0, r1));
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public final d i(CharSequence r12, boolean r13, RichText r14) {
        Intrinsics.checkNotNullParameter(r12, "text");
        if (this.b == false) goto L5;
        if (r13 == true) goto L9;
        if (r14 == null) goto L9;
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.richtext.a r0 = com.bytedance.ee.bear.middleground.comment.audio.voiceinput.richtext.a.a;
        Context r2 = this.a.getContext();
        String r15 = h(r12).toString();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r15, "fallback");
        Intrinsics.checkNotNullParameter(r14, "richText");
        final SpannableStringBuilder r16 = r0.h(r2, r15, r14);
    L13:
        boolean r17 = !StringsKt.isBlank(r16.toString());
        final Editable r3 = this.a.getText();
        if (r3 == null) goto L16;
        CharSequence r4 = r3;
    L17:
        List r5 = e(r4);
        if (r17 == false) goto L20;
    L25:
        if (r17 == false) goto L46;
        if (this.g.length() <= 0) goto L29;
        boolean r6 = true;
    L30:
        if (r6 == false) goto L46;
        int r7 = this.c;
        if (r3 == null) goto L34;
        int r8 = r3.length();
    L35:
        int r9 = RangesKt.coerceIn(r7, 0, r8);
        if (r3 == null) goto L42;
        if (r9 == 0) goto L42;
        Character r10 = StringsKt.lastOrNull(StringsKt.trimEnd(r3.subSequence(0, r9)));
        if (r10 == null) goto L42;
        boolean r11 = Character.isLetterOrDigit(r10.charValue());
    L43:
        if (r11 == false) goto L46;
        r16.insert(0, this.g);
    L42:
        r11 = false;
        goto L43
    L34:
        r8 = 0;
        goto L35
    L29:
        r6 = false;
    L46:
        if (r3 != null) goto L59;
        this.a.O(new CommentVoiceEditTextBridge$updateVoiceText$1(this, r16));
        f(this.a.getText());
        this.f = true;
        this.e = r16.length();
        g(r16.length());
        if (r13 == true) goto L53;
        StringBuilder r18 = new StringBuilder("[bridge] final setText mentionChanged=");
        Editable r1 = this.a.getText();
        Editable r19 = r1;
        if (r1 != null) goto L52;
        r19 = r16;
    L52:
        r18.append(!Intrinsics.areEqual(r5, e(r19)));
        r18.append(", ");
        CommentVoiceLog.a.getClass();
        r18.append(CommentVoiceLog.i("normalized", r16));
        tt5.a.h("CommentVoice", r18.toString());
    L53:
        Editable r110 = this.a.getText();
        Editable r111 = r16;
        if (r110 == null) goto L57;
        r111 = r110;
    L57:
        List r112 = e(r111);
        return new d(true, !Intrinsics.areEqual(r5, r112), r17, !r112.isEmpty());
    L59:
        final int r20 = RangesKt.coerceIn(this.c, 0, r3.length());
        if (this.f == true) goto L62;
        final int r21 = RangesKt.coerceIn(this.d, r20, r3.length());
    L63:
        f(r3);
        Map r22 = MapsKt.toMap(this.h);
        this.a.O(new CommentVoiceEditTextBridge$updateVoiceText$2(r3, r20, r21, r16));
        b(r16, r3, r20, r22);
        f(r3);
        this.f = true;
        this.e = r16.length();
        g(r16.length() + r20);
        if (r13 == true) goto L66;
        StringBuilder r113 = new StringBuilder("[bridge] final update replaceStart=");
        r113.append(r20);
        r113.append(", replaceEnd=");
        r113.append(r21);
        r113.append(", mentionChanged=");
        r113.append(!Intrinsics.areEqual(r5, e(r3)));
        r113.append(", ");
        CommentVoiceLog.a.getClass();
        r113.append(CommentVoiceLog.i("normalized", r16));
        r113.append(", ");
        r113.append(CommentVoiceLog.i("current", r3));
        tt5.a.h("CommentVoice", r113.toString());
    L66:
        List r114 = e(r3);
        return new d(true, !Intrinsics.areEqual(r5, r114), r17, !r114.isEmpty());
    L62:
        r21 = RangesKt.coerceIn(this.c + this.e, r20, r3.length());
        goto L63
    L20:
        if (this.f == true) goto L25;
        if (this.c == this.d) goto L25;
        return new d(true, false, false, !r5.isEmpty());
    L16:
        r4 = "";
    L9:
        if (r13 == true) goto L12;
        r12 = h(r12);
    L12:
        r16 = com.bytedance.ee.bear.middleground.comment.audio.voiceinput.richtext.a.a.j(this.a.getContext(), r12, r13);
        goto L13
    L5:
        return new d(false, false, false, false);
    }

    public static void b(CharSequence r17, Spannable r18, int r19, Map r20) {
        Spanned r2 = (Spanned) r17;
        Object[] r3 = r2.getSpans(0, r2.length(), l.class);
        int r4 = r3.length;
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L48;
        l r7 = (l) r3[r6];
        int r8 = r2.getSpanStart(r7);
        int r9 = r2.getSpanEnd(r7);
        String r10 = r7.d;
        if (r10 != null) goto L7;
        r10 = "";
    L7:
        int r11 = r19 + r8;
        int r12 = r19 + r9;
        if (r8 < 0) goto L19;
        if (r9 <= r8) goto L19;
        if (r10.length() != 0) goto L13;
        boolean r13 = true;
    L14:
        if (r13 == true) goto L19;
        if (r12 > r18.length()) goto L19;
        boolean r14 = false;
    L20:
        if (r14 == true) goto L46;
        Object[] r15 = r18.getSpans(r11, r12, l.class);
        ArrayList r16 = new ArrayList();
        int r110 = r15.length;
        int r111 = 0;
    L22:
        if (r111 >= r110) goto L34;
        Object r5 = r15[r111];
        l r112 = (l) r5;
        Object[] r113 = r3;
        if (r18.getSpanStart(r112) == r11) goto L26;
    L30:
        boolean r21 = false;
    L31:
        if (r21 == false) goto L33;
        r16.add(r5);
    L33:
        r111 = r111 + 1;
        r3 = r113;
        goto L22
    L26:
        if (r18.getSpanEnd(r112) != r12) goto L30;
        if (Intrinsics.areEqual(r112.d, r10) == false) goto L30;
        r21 = true;
        goto L31
    L34:
        Object[] r114 = r3;
        if ((!r16.isEmpty()) == false) goto L42;
        c r22 = (c) r20.get(r10);
        if (r22 == null) goto L47;
        Iterator r23 = r16.iterator();
    L40:
        if (r23.hasNext() == false) goto L47;
        l r24 = (l) r23.next();
        Intrinsics.checkNotNullParameter(r24, "span");
        r24.j = r22.a;
        r24.k = r22.b;
    L47:
        r6 = r6 + 1;
        r3 = r114;
        goto L3
    L42:
        c r25 = (c) r20.get(r10);
        if (r25 == null) goto L45;
        Intrinsics.checkNotNull(r7);
        Intrinsics.checkNotNullParameter(r7, "span");
        r7.j = r25.a;
        r7.k = r25.b;
    L45:
        r18.setSpan(r7, r11, r12, r2.getSpanFlags(r7));
        goto L47
    L46:
        r114 = r3;
        goto L47
    L13:
        r13 = false;
    L19:
        r14 = true;
        goto L20
    }
}
