package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import android.text.Spanned;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.GroupingKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CommentVoiceLog {
    public static final CommentVoiceLog a = null;

    public static final class a implements Grouping<RichTextElement, String> {
        public final /* synthetic */ Iterable a;

        public final Iterator<RichTextElement> sourceIterator() {
            return this.a.iterator();
        }

        public a(Iterable r1) {
            this.a = r1;
        }

        public final String keyOf(RichTextElement r1) {
            RichTextElement.RichTextTag r2 = r1.getTag();
            if (r2 == null) goto L6;
            String r3 = r2.name();
            if (r3 == null) goto L6;
            return r3;
        L6:
            return "null";
        }
    }

    static {
        a = new CommentVoiceLog();
    }

    public CommentVoiceLog() {
    }

    public static boolean a() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        LarkAppContext.Companion.getClass();     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Boolean.valueOf(DevEnvUtil.isDebugMode(LarkAppContext.access$getInstance$cp().getContext())));     // Catch: Throwable -> L4
    L6:
        Boolean r2 = Boolean.FALSE;
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = r2;
    L10:
        return ((Boolean) r1).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public static String b(List r9) {
        if (r9.isEmpty() == false) goto L6;
        return "[]";
    L6:
        return CollectionsKt.joinToString$default(r9, null, "[", "]", 0, null, null, 57, null);
    }

    public static String e(String r18) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r18, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null), "\t", "\\t", false, 4, null);
    }

    public static String f(RichText r6) {
        Intrinsics.checkNotNullParameter(r6, "richText");
        final boolean r0 = a();
        RichText.RichTextElements r1 = r6.getElements();
        if (r1 == null) goto L5;
        Map r2 = r1.getDictionary();
    L6:
        if (r2 != null) goto L8;
        r2 = MapsKt.emptyMap();
    L8:
        List r7 = r6.getElementIds();
        if (r7 != null) goto L11;
        r7 = CollectionsKt.emptyList();
    L11:
        Map r3 = GroupingKt.eachCount(new a(r2.values()));
        List r4 = SequencesKt.toList(SequencesKt.map(SequencesKt.take(SequencesKt.filter(MapsKt.asSequence(r2), CommentVoiceLog$richTextSummary$atNodes$1.INSTANCE), 8), new CommentVoiceLog$richTextSummary$atNodes$2(r0)));
        StringBuilder r5 = new StringBuilder("richText={rootCount=");
        r5.append(r7.size());
        r5.append(", elementCount=");
        r5.append(r2.size());
        r5.append(", tagCounts=");
        r5.append(r3);
        r5.append(", atNodeCount=");
        Collection r8 = r2.values();
        int r9 = 0;
        if ((r8 instanceof Collection) == true) goto L14;
    L16:
        Iterator r10 = r8.iterator();
        int r11 = 0;
    L18:
        if (r10.hasNext() == false) goto L27;
        if (((RichTextElement) r10.next()).getTag() != RichTextElement.RichTextTag.AT) goto L22;
        boolean r12 = true;
    L23:
        if (r12 == false) goto L18;
        r11 = r11 + 1;
        if (r11 >= 0) goto L18;
        CollectionsKt.throwCountOverflow();
        goto L18
    L22:
        r12 = false;
        goto L23
    L27:
        r9 = r11;
    L28:
        r5.append(r9);
        r5.append(", atNodes=");
        r5.append(b(r4));
        r5.append('}');
        return r5.toString();
    L14:
        if (r8.isEmpty() == false) goto L16;
    L5:
        r2 = null;
        goto L6
    }

    public static String c(String r1, boolean r2) {
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        if (r1.length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return "<empty>";
    L11:
        if (r2 == false) goto L14;
        return "\"" + e(r1) + '\"';
    L14:
        return "{len=" + r1.length() + ", tail=\"" + e(StringsKt.takeLast(r1, 6)) + "\"}";
    L7:
        r0 = false;
        goto L8
    }

    public static String d(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "label");
        return r1 + '=' + c(r2, a());
    }

    public static String i(String r17, CharSequence r18) {
        Intrinsics.checkNotNullParameter(r17, "label");
        if (r18 == null) goto L5;
        String r2 = r18.toString();
        StringBuilder r3 = new StringBuilder();
        r3.append(r17);
        r3.append("={len=");
        r3.append(r18.length());
        r3.append(", blank=");
        r3.append(StringsKt.isBlank(r2));
        r3.append(", ");
        boolean r4 = a();
        if (r4 == false) goto L9;
        String r5 = "content";
    L10:
        r3.append(h(r5, r2, r4));
        r3.append(", ");
        if ((r18 instanceof Spanned) == true) goto L13;
        String r0 = "spans={spanned=false}";
        char r1 = '}';
    L25:
        r3.append(r0);
        r3.append(r1);
        return r3.toString();
    L13:
        boolean r6 = a();
        Spanned r7 = (Spanned) r18;
        un5.l[] r8 = (un5.l[]) r7.getSpans(0, r18.length(), un5.l.class);
        com.ss.android.lark.keyboard.edittext2.span.a[] r9 = (com.ss.android.lark.keyboard.edittext2.span.a[]) r7.getSpans(0, r18.length(), com.ss.android.lark.keyboard.edittext2.span.a.class);
        Intrinsics.checkNotNull(r8);
        List r10 = ArraysKt.take(r8, 8);
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r12 = r10.iterator();
    L15:
        if (r12.hasNext() == false) goto L20;
        un5.l r13 = (un5.l) r12.next();
        int r15 = r7.getSpanStart(r13);
        int r14 = r7.getSpanEnd(r13);
        StringBuilder r16 = new StringBuilder("{range=");
        r16.append(r15);
        r16.append("..");
        r16.append(r14);
        r16.append(", token=");
        CommentVoiceLog r19 = a;
        String r110 = r13.d;
        r19.getClass();
        r16.append(c(r110, r6));
        r16.append(", gray=");
        r16.append(r13.j);
        r16.append(", canShare=");
        r16.append(r13.k);
        r16.append(", ");
        r16.append(g(r18, r15, r14, r6));
        r16.append(", ");
        String r111 = r13.i;
        if (r111 != null) goto L19;
        r111 = "";
    L19:
        r16.append(h("spanContent", r111, r6));
        r16.append('}');
        r11.add(r16.toString());
        goto L15
    L20:
        Intrinsics.checkNotNull(r9);
        List r20 = ArraysKt.take(r9, 8);
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator r22 = r20.iterator();
    L22:
        if (r22.hasNext() == false) goto L24;
        com.ss.android.lark.keyboard.edittext2.span.a r112 = (com.ss.android.lark.keyboard.edittext2.span.a) r22.next();
        int r113 = r7.getSpanStart(r112);
        int r114 = r7.getSpanEnd(r112);
        StringBuilder r23 = new StringBuilder("{range=");
        r23.append(r113);
        r23.append("..");
        r23.append(r114);
        Spanned r115 = r7;
        r23.append(", uid=");
        CommentVoiceLog r24 = a;
        String r116 = r112.b;
        r24.getClass();
        r23.append(c(r116, r6));
        r23.append(", ");
        r23.append(g(r18, r113, r114, r6));
        r23.append('}');
        r21.add(r23.toString());
        r7 = r115;
        goto L22
    L24:
        StringBuilder r25 = new StringBuilder("spans={userCount=");
        r25.append(r8.length);
        r25.append(", users=");
        r25.append(b(r11));
        r25.append(", imAtCount=");
        r25.append(r9.length);
        r25.append(", imAts=");
        r25.append(b(r21));
        r1 = '}';
        r25.append('}');
        r0 = r25.toString();
        goto L25
    L9:
        r5 = "desensitizedContent";
        goto L10
    L5:
        return r17.concat("={null}");
    }

    public static String h(String r0, String r1, boolean r2) {
        if (r2 == true) goto L6;
        r1 = com.ss.android.lark.audio.voiceinput.utils.b.a(r1);
    L6:
        return r0 + "=\"" + e(r1) + '\"';
    }

    public static String g(CharSequence r1, int r2, int r3, boolean r4) {
        if (r2 < 0) goto L10;
        if (r3 <= r2) goto L10;
        if (r3 > r1.length()) goto L10;
        return h("visible", r1.subSequence(r2, r3).toString(), r4);
    L10:
        return "visible=<invalid>";
    }
}
