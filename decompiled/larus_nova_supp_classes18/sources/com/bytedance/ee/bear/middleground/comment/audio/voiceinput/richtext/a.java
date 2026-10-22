package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.richtext;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceLog;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.d;
import com.bytedance.ee.bear.utils.AtUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.SuffixAsrSpan;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.preprocess.ElementExtra;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import rbb.b;
import s45.p;
import sbb.e;
import t45.c;
import un5.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final a a = null;
    public static final Set<RichTextElement.RichTextTag> b = null;
    public static final Set<RichTextElement.RichTextTag> c = null;
    public static final Regex d = null;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.audio.voiceinput.richtext.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0052a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RichTextElement.RichTextTag.values().length];
            r0[RichTextElement.RichTextTag.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[RichTextElement.RichTextTag.AT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[RichTextElement.RichTextTag.ANCHOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[RichTextElement.RichTextTag.PARAGRAPH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[RichTextElement.RichTextTag.OL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[RichTextElement.RichTextTag.UL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[RichTextElement.RichTextTag.LI.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    public a() {
    }

    static {
        a = new a();
        Set<RichTextElement.RichTextTag> r0 = SetsKt.setOf(new RichTextElement.RichTextTag[]{RichTextElement.RichTextTag.OL, RichTextElement.RichTextTag.UL});
        b = r0;
        c = SetsKt.plus(r0, RichTextElement.RichTextTag.LI);
        d = new Regex("\\d+\\.");
    }

    public static void g(SpannableStringBuilder r2) {
        if (r2.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        if (StringsKt.last(r2) == '\n') goto L12;
        r2.append('\n');
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static boolean i(RichTextElement r3) {
        if (r3.getTag() == RichTextElement.RichTextTag.BOLD) goto L18;
        Map r4 = r3.getStyle();
        if (r4 == null) goto L13;
        String r5 = (String) r4.get("fontWeight");
        if (r5 == null) goto L13;
        String r6 = StringsKt.trim(r5).toString();
        if (r6 == null) goto L13;
        if (StringsKt.equals(r6, "bold", true) != true) goto L13;
        boolean r7 = true;
    L14:
        if (r7 == true) goto L19;
        return false;
    L19:
        return true;
    L13:
        r7 = false;
        goto L14
    L18:
        return true;
    }

    public static void a(Context r26, RichTextElement r27, SpannableStringBuilder r28) {
        RichTextElement.AnchorProperty r2 = r27.getProperty();
        if (r2 != null) goto L5;
        return;
    L5:
        String r0 = r2.getHref();
        String r3 = "";
        if (r0 != null) goto L9;
        r0 = "";
    L9:
        if (r0.length() != 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L16;
        r0 = r2.getAndroidHref();
        if (r0 != null) goto L16;
        String r12 = "";
    L17:
        String r1 = r2.getDisplayTitle();
        if (r1 != null) goto L21;
        r1 = "";
    L21:
        if (r1.length() != 0) goto L23;
        boolean r5 = true;
    L24:
        if (r5 == false) goto L29;
        r1 = r2.getContent();
        if (r1 != null) goto L29;
        r1 = "";
    L29:
        if (r1.length() != 0) goto L31;
        boolean r6 = true;
    L32:
        if (r6 == false) goto L34;
        String r7 = r12;
    L36:
        if (r12.length() != 0) goto L38;
        boolean r8 = true;
    L39:
        if (r8 == false) goto L186;
        r28.append(r7);
        return;
    L186:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L51
        c r10 = p.a();     // Catch: Throwable -> L51
        if (r10.v6(r12) == true) goto L46;
        r10 = null;
    L46:
        if (r10 == null) goto L48;
        BearUrl r11 = r10.Z(r12);     // Catch: Throwable -> L51
    L49:
        Object r13 = Result.constructor-impl(r11);     // Catch: Throwable -> L51
    L54:
        if (Result.isFailure-impl(r13) == false) goto L56;
        r13 = null;
    L56:
        BearUrl r14 = (BearUrl) r13;
        if (r14 == null) goto L59;
        String r15 = r14.b;
    L60:
        if (r15 != null) goto L62;
    L65:
        boolean r16 = true;
    L66:
        if (r16 == false) goto L69;
        r28.append(r7);
        return;
    L69:
        int[] r17 = d.a;
        if (r14 == null) goto L72;
        String r18 = r14.a;
    L73:
        int r19 = r2.getLocalIconRes();
        String r110 = r2.getIconKey();
        if (r18 != null) goto L76;
        r18 = "";
    L76:
        e r20 = e.e(r18);
        boolean r111 = Intrinsics.areEqual(r20, e.n);
        if (r19 <= 0) goto L89;
        int[] r112 = d.a;
        int r113 = 0;
    L81:
        if (r113 >= 7) goto L89;
        int r21 = r112[r113];
        if (AtUtils.g(r21, -1) != r19) goto L85;
        boolean r22 = true;
    L86:
        if (r22 == true) goto L87;
        r113 = r113 + 1;
        goto L81
    L87:
        Integer r23 = Integer.valueOf(r21);
    L91:
        if (r23 == null) goto L93;
        int r24 = r23.intValue();
    L125:
        Integer r25 = Integer.valueOf(r19);
        if (r25.intValue() <= 0) goto L128;
        boolean r29 = true;
    L129:
        if (r29 == true) goto L133;
        r25 = null;
    L133:
        if (r111 == false) goto L135;
        int r114 = 16;
    L136:
        if (r111 == false) goto L139;
        if (r24 == 16) goto L139;
        int r115 = r24;
    L140:
        if (r25 != null) goto L152;
        if (r24 == 12) goto L144;
        r25 = null;
    L151:
        if (r25 != null) goto L152;
        if (r114 != 16) goto L156;
        if (r115 != (-1)) goto L156;
        r25 = 2131256245;
    L157:
        if (r25 != null) goto L152;
        int r30 = AtUtils.g(r114, r115);
    L161:
        if (r24 != 12) goto L175;
        String r31 = d.a(r7);
        if (r31.length() != 0) goto L166;
        boolean r32 = true;
    L167:
        if (r32 == false) goto L169;
        String r116 = "";
    L171:
        if (r116.length() != 0) goto L173;
        boolean r33 = true;
    L174:
        if (r33 == true) goto L175;
        String r34 = "{\"obj_type\":12,\"file_type\":\"" + StringsKt.replace$default(StringsKt.replace$default(r116, "\\", "\\\\", false, 4, null), "\"", "\\\"", false, 4, null) + "\"}";
    L177:
        d.a r35 = new d.a(r114, r115, r30, r34);
        if (r14 == null) goto L180;
        String r36 = r14.b;
    L181:
        if (r36 == null) goto L184;
        r3 = r36;
    L184:
        int r117 = r35.getType();
        int r118 = r35.b;
        int r37 = r35.c;
        String r119 = r35.d;
        String r120 = r2.getIconKey();
        int r38 = r28.length();
        r28.append("<doc.at.~#_%=`>");
        r28.append(r7);
        Object r39 = new un5.d(r26, r37, r117, r3);
        Object r40 = new un5.e(r26, r3, r117, r118, r12, r119, 0, r120, null, null);
        r28.setSpan(r39, r38, r38 + 15, 33);
        r28.setSpan(r40, r38, r28.length(), 33);
        return;
    L180:
        r36 = null;
        goto L181
    L173:
        r33 = false;
        goto L174
    L169:
        r116 = r31;
        goto L171
    L166:
        r32 = false;
    L175:
        r34 = "";
    L156:
        r25 = null;
        goto L157
    L144:
        String r41 = d.a(r7);
        if (r41.length() != 0) goto L147;
        boolean r121 = true;
    L148:
        if (r121 == false) goto L150;
        r41 = "";
    L150:
        r25 = Integer.valueOf(b.f(r41));
        goto L151
    L147:
        r121 = false;
    L152:
        r30 = r25.intValue();
    L139:
        r115 = -1;
        goto L140
    L135:
        r114 = r24;
        goto L136
    L128:
        r29 = false;
        goto L129
    L93:
        Intrinsics.checkNotNull(r20);
        Integer r122 = 12;
        if (Intrinsics.areEqual(r20, e.l) == true) goto L122;
        if (r110 != null) goto L98;
    L101:
        boolean r42 = true;
    L102:
        boolean r43 = !r42;
        if (r111 == false) goto L118;
        if (r19 <= 0) goto L118;
        if (r43 == true) goto L118;
        String r44 = d.a(r7);
        if (r44.length() != 0) goto L109;
        boolean r123 = true;
    L110:
        if (r123 == false) goto L113;
        r44 = "";
    L113:
        if (r44.length() <= 0) goto L115;
        boolean r45 = true;
    L116:
        if (r45 == false) goto L118;
        boolean r46 = true;
    L119:
        if (r46 == true) goto L122;
        r122 = null;
        goto L122
    L115:
        r45 = false;
        goto L116
    L109:
        r123 = false;
    L118:
        r46 = false;
        goto L119
    L98:
        if (r110.length() == 0) goto L101;
        r42 = false;
    L122:
        if (r122 == null) goto L124;
        r24 = r122.intValue();
        goto L125
    L124:
        r24 = AtUtils.f(r20);
        goto L125
    L85:
        r22 = false;
    L89:
        r23 = null;
        goto L91
    L72:
        r18 = null;
        goto L73
    L62:
        if (r15.length() == 0) goto L65;
        r16 = false;
        goto L66
    L59:
        r15 = null;
        goto L60
    L48:
        r11 = null;
    L51:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L54
    L38:
        r8 = false;
        goto L39
    L34:
        r7 = r1;
        goto L36
    L31:
        r6 = false;
        goto L32
    L23:
        r5 = false;
    L16:
        r12 = r0;
        goto L17
    L11:
        r4 = false;
        goto L12
    }

    public static void b(Context r17, RichTextElement r18, SpannableStringBuilder r19) {
        RichTextElement.AtProperty r1 = r18.getProperty();
        if (r1 != null) goto L5;
        return;
    L5:
        String r2 = r1.getUserId();
        if (r2 != null) goto L8;
        String r7 = "";
    L9:
        String r3 = r1.getAtContent();
        if (r3 != null) goto L12;
        r3 = "";
    L12:
        boolean r5 = true;
        if (r3.length() != 0) goto L15;
        boolean r4 = true;
    L17:
        if (r4 == false) goto L20;
        r3 = "";
    L24:
        if (r7.length() != 0) goto L26;
        boolean r6 = true;
    L27:
        if (r6 == false) goto L29;
    L40:
        StringBuilder r8 = new StringBuilder("[mapper] appendAt incomplete userIdEmpty=");
        if (r7.length() != 0) goto L43;
        boolean r9 = true;
    L44:
        r8.append(r9);
        r8.append(", atContentEmpty=");
        if (r3.length() != 0) goto L47;
        boolean r10 = true;
    L48:
        r8.append(r10);
        r8.append(", ");
        CommentVoiceLog.a.getClass();
        r8.append(CommentVoiceLog.i("atContent", r3));
        tt5.a.k("CommentVoice", r8.toString());
        if (r3.length() > 0) goto L52;
        r5 = false;
    L52:
        if (r5 == false) goto L55;
        r19.append(r3);
        return;
    L55:
        return;
    L47:
        r10 = false;
        goto L48
    L43:
        r9 = false;
        goto L44
    L29:
        if (r3.length() != 0) goto L31;
        boolean r11 = true;
    L32:
        if (r11 == true) goto L40;
        String r12 = r1.getOriginUserName();
        if (r12 != null) goto L37;
        String r13 = "";
    L38:
        int r14 = r19.length();
        r19.append(r3);
        String r15 = r3;
        r19.setSpan(new l(r17, r15, r7, "", StringsKt.removePrefix(r3, "@"), r13, null, false, null, false, null, null), r14, r19.length(), 33);
        return;
    L37:
        r13 = r12;
        goto L38
    L31:
        r11 = false;
        goto L32
    L26:
        r6 = false;
        goto L27
    L20:
        if (StringsKt.startsWith$default(r3, "@", false, 2, null) == true) goto L24;
        r3 = "@".concat(r3);
        goto L24
    L15:
        r4 = false;
        goto L17
    L8:
        r7 = r2;
        goto L9
    }

    public final SpannableStringBuilder h(Context r22, String r23, RichText r24) {
        Intrinsics.checkNotNullParameter(r22, "context");
        Intrinsics.checkNotNullParameter(r23, "fallback");
        Intrinsics.checkNotNullParameter(r24, "richText");
        RichText.RichTextElements r1 = r24.getElements();
        if (r1 == null) goto L5;
        Map r2 = r1.getDictionary();
    L6:
        Map r10 = r2;
        List r11 = r24.getElementIds();
        boolean r12 = true;
        if (r10 != null) goto L9;
    L12:
        boolean r3 = true;
    L14:
        if (r3 == true) goto L57;
        List r4 = r11;
        if (r4 != null) goto L18;
    L21:
        boolean r5 = true;
    L22:
        if (r5 == true) goto L57;
        SpannableStringBuilder r6 = new SpannableStringBuilder();
        Iterator r16 = r11.iterator();
        int r7 = 0;
    L26:
        if (r16.hasNext() == false) goto L48;
        Object r8 = r16.next();
        int r17 = r7 + 1;
        if (r7 >= 0) goto L30;
        CollectionsKt.throwIndexOverflow();
    L30:
        String r9 = (String) r8;
        RichTextElement r18 = (RichTextElement) r10.get(r9);
        a r13 = a;
        Intrinsics.checkNotNull(r9);
        r13.getClass();
        int r14 = r7;
        SpannableStringBuilder r19 = r6;
        c(r22, r9, r10, r6, 0, false);
        if (r14 >= CollectionsKt.getLastIndex(r11)) goto L46;
        if (r18 == null) goto L38;
        RichTextElement.RichTextTag r15 = r18.getTag();
        if (r15 == null) goto L38;
        if (c.contains(r15) != true) goto L38;
        boolean r20 = true;
    L39:
        if (r20 == false) goto L46;
        Character r21 = StringsKt.lastOrNull(r19);
        if (r21 != null) goto L44;
    L45:
        SpannableStringBuilder r25 = r19;
        r25.append('\n');
    L47:
        r6 = r25;
        r7 = r17;
        goto L26
    L44:
        if (r21.charValue() == '\n') goto L46;
    L38:
        r20 = false;
    L46:
        r25 = r19;
        goto L47
    L48:
        SpannableStringBuilder r26 = r6;
        if (r26.length() == 0) goto L52;
        r12 = false;
    L52:
        if (r12 == false) goto L55;
        SpannableStringBuilder r27 = j(r22, r23, false);
        StringBuilder r28 = new StringBuilder("[mapper] fromRichText fallback empty result, ");
        CommentVoiceLog.a.getClass();
        r28.append(CommentVoiceLog.i("result", r27));
        tt5.a.k("CommentVoice", r28.toString());
        return r27;
    L55:
        SpannableStringBuilder r29 = j(r22, r26, false);
        StringBuilder r30 = new StringBuilder("[mapper] fromRichText done, ");
        CommentVoiceLog.a.getClass();
        r30.append(CommentVoiceLog.f(r24));
        r30.append(", ");
        r30.append(CommentVoiceLog.i("result", r29));
        tt5.a.h("CommentVoice", r30.toString());
        return r29;
    L18:
        if (r4.isEmpty() == true) goto L21;
        r5 = false;
    L57:
        SpannableStringBuilder r31 = j(r22, r23, false);
        StringBuilder r32 = new StringBuilder("[mapper] fromRichText fallback empty tree, ");
        CommentVoiceLog.a.getClass();
        r32.append(CommentVoiceLog.i("result", r31));
        tt5.a.k("CommentVoice", r32.toString());
        return r31;
    L9:
        if (r10.isEmpty() == true) goto L12;
        r3 = false;
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    public final SpannableStringBuilder j(Context r31, CharSequence r32, boolean r33) {
        Intrinsics.checkNotNullParameter(r31, "context");
        Intrinsics.checkNotNullParameter(r32, "source");
        SpannableStringBuilder r15 = new SpannableStringBuilder(r32.toString());
        if (r33 == false) goto L5;
        f(this, r32, r15, SuffixAsrSpan.class, false, CommentVoiceRichTextMapper$copyAsrVisualSpans$1.INSTANCE, 8);
        f(this, r32, r15, com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.a.class, false, null, 24);
    L5:
        f(this, r32, r15, l.class, true, null, 16);
        f(this, r32, r15, un5.d.class, false, null, 24);
        f(this, r32, r15, un5.e.class, false, null, 24);
        if ((r32 instanceof Spanned) == false) goto L8;
        Spanned r0 = (Spanned) r32;
    L9:
        if (r0 == null) goto L55;
        com.ss.android.lark.keyboard.edittext2.span.a[] r12 = (com.ss.android.lark.keyboard.edittext2.span.a[]) r0.getSpans(0, r0.length(), com.ss.android.lark.keyboard.edittext2.span.a.class);
        Intrinsics.checkNotNull(r12);
        int r11 = r12.length;
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
    L12:
        if (r10 >= r11) goto L48;
        com.ss.android.lark.keyboard.edittext2.span.a r2 = r12[r10];
        int r6 = r0.getSpanStart(r2);
        int r5 = r0.getSpanEnd(r2);
        int r16 = r0.getSpanFlags(r2);
        if (r6 < 0) goto L45;
        if (r5 <= r6) goto L45;
        if (r5 > r15.length()) goto L45;
        if (r2.b.length() != 0) goto L21;
        boolean r3 = true;
    L22:
        if (r3 == true) goto L45;
        String r4 = r15.subSequence(r6, r5).toString();
        a r13 = a;
        String r14 = r2.b;
        r13.getClass();
        Object[] r17 = r15.getSpans(r6, r5, l.class);
        int r1 = r17.length;
        Spanned r18 = r0;
        int r19 = 0;
    L25:
        if (r19 >= r1) goto L37;
        int r110 = r1;
        l r20 = (l) r17[r19];
        Object[] r111 = r17;
        if (r15.getSpanStart(r20) == r6) goto L29;
    L33:
        boolean r21 = false;
    L34:
        if (r21 == true) goto L35;
        r19 = r19 + 1;
        r17 = r111;
        r1 = r110;
        goto L25
    L35:
        boolean r22 = true;
    L38:
        if (r22 == false) goto L40;
        r8 = r8 + 1;
        r10 = r10;
        r11 = r11;
        r12 = r12;
    L47:
        r10 = r10 + 1;
        r0 = r18;
        r11 = r11;
        r12 = r12;
        goto L12
    L40:
        a r23 = a;
        String r24 = r2.b;
        r23.getClass();
        int r25 = r7;
        int r28 = r9;
        int r112 = r8;
        l r26 = new l(r31, r4, r24, "", StringsKt.removePrefix(r4, "@"), "", null, false, null, false, null, null);
        if (r16 != 0) goto L43;
        int r27 = 33;
    L44:
        r15.setSpan(r26, r6, r5, r27);
        r9 = r28 + 1;
        r7 = r25;
    L46:
        r8 = r112;
        goto L47
    L43:
        r27 = r16;
        goto L44
    L29:
        if (r15.getSpanEnd(r20) != r5) goto L33;
        if (Intrinsics.areEqual(r20.d, r14) == false) goto L33;
        r21 = true;
        goto L34
    L37:
        r22 = false;
        goto L38
    L21:
        r3 = false;
    L45:
        r18 = r0;
        r112 = r8;
        r7 = r7 + 1;
        r9 = r9;
        goto L46
    L48:
        int r29 = r7;
        int r113 = r8;
        int r114 = r9;
        com.ss.android.lark.keyboard.edittext2.span.a[] r30 = r12;
        boolean r210 = false;
        if (r30.length != 0) goto L51;
        boolean r34 = true;
        r210 = true;
    L53:
        if ((r34 ^ r210) == false) goto L55;
        StringBuilder r35 = new StringBuilder("[mapper] normalize IM at spans total=");
        r35.append(r30.length);
        r35.append(", copied=");
        r35.append(r114);
        r35.append(", existing=");
        r35.append(r113);
        r35.append(", invalid=");
        r35.append(r29);
        r35.append(", ");
        CommentVoiceLog.a.getClass();
        r35.append(CommentVoiceLog.i("result", r15));
        tt5.a.h("CommentVoice", r35.toString());
        goto L55
    L51:
        r34 = true;
    L55:
        return r15;
    L8:
        r0 = null;
        goto L9
    }

    public static void c(Context r8, String r9, Map r10, SpannableStringBuilder r11, int r12, boolean r13) {
        RichTextElement r1 = (RichTextElement) r10.get(r9);
        if (r1 != null) goto L5;
        return;
    L5:
        int r14 = 0;
        boolean r0 = true;
        int r2 = 1;
        if (r13 == false) goto L8;
    L11:
        boolean r15 = true;
    L12:
        RichTextElement.RichTextTag r3 = r1.getTag();
        if (r3 != null) goto L15;
        int r4 = -1;
    L16:
        String r5 = "";
        String r6 = null;
        Integer r7 = null;
        String r16 = null;
        switch(r4) {
            case 1: goto L82;
            case 2: goto L76;
            case 3: goto L70;
            case 4: goto L51;
            case 5: goto L50;
            case 6: goto L49;
            case 7: goto L21;
            default: goto L18;
        };
    L18:
        List r17 = r1.getChildIds();
        if (r17 == null) goto L103;
        Iterator r18 = r17.iterator();
    L101:
        if (r18.hasNext() == false) goto L120;
        String r19 = (String) r18.next();
        a r20 = a;
        Intrinsics.checkNotNull(r19);
        r20.getClass();
        c(r8, r19, r10, r11, r12, r15);
        goto L101
    L120:
        return;
    L103:
        return;
    L21:
        g(r11);
        RichTextElement.LIProperty r21 = r1.getProperty();
        if (r21 == null) goto L24;
        String r22 = r21.getListNum();
    L25:
        if (r22 == null) goto L28;
        r5 = r22;
    L28:
        String r23 = StringsKt.trim(r5).toString();
        ElementExtra.FloorInfo r24 = r1.getElementExtra().getFloorInfo();
        if (d.matches(r23) == false) goto L33;
        String r25 = r23 + ' ';
    L31:
        String r26 = r25;
        if (r21 == null) goto L48;
        r14 = r21.getFloor();
    L48:
        e(r8, r1, r10, r11, Math.max(r12, r14), r26, r15);
        return;
    L33:
        if ((r24.getFloorProperty() instanceof RichTextElement.OLProperty) == true) goto L35;
    L45:
        r25 = "- ";
        goto L31
    L35:
        if (r24.index < 0) goto L45;
        RichTextElement.OLProperty r27 = r24.getFloorProperty();
        Intrinsics.checkNotNull(r27, "null cannot be cast to non-null type com.ss.android.lark.widget.richtext.RichTextElement.OLProperty");
        Integer r28 = Integer.valueOf(r27.getStart());
        if (r28.intValue() <= 0) goto L39;
        boolean r29 = true;
    L40:
        if (r29 == false) goto L42;
        r7 = r28;
    L42:
        if (r7 == null) goto L44;
        r2 = r7.intValue();
    L44:
        r25 = (r2 + r24.index) + ". ";
        goto L31
    L39:
        r29 = false;
        goto L40
    L24:
        r22 = null;
        goto L25
    L49:
        d(r8, r1, r10, r11, r12, false, r15);
        return;
    L50:
        d(r8, r1, r10, r11, r12, true, r15);
        return;
    L51:
        List r30 = r1.getChildIds();
        if (r30 != null) goto L54;
        r30 = CollectionsKt.emptyList();
    L54:
        RichTextElement.ParagraphProperty r31 = r1.getProperty();
        if (r30.isEmpty() == false) goto L60;
        if (r31 == null) goto L58;
        r0 = r31.getIsNeedEnter();
    L58:
        if (r0 == false) goto L109;
        g(r11);
        r11.append('\n');
        return;
    L109:
        return;
    L60:
        if (r31 != null) goto L62;
    L64:
        if (r14 == 0) goto L66;
        g(r11);
    L66:
        Iterator r32 = r30.iterator();
    L68:
        if (r32.hasNext() == false) goto L121;
        String r33 = (String) r32.next();
        a r34 = a;
        Intrinsics.checkNotNull(r33);
        r34.getClass();
        c(r8, r33, r10, r11, r12, r15);
        goto L68
    L121:
        return;
    L62:
        if (r31.getIsNeedEnter() != true) goto L64;
        r14 = 1;
        goto L64
    L70:
        if (r15 == true) goto L72;
        a.getClass();
        a(r8, r1, r11);
        return;
    L72:
        int r35 = r11.length();
        r11.append("**");
        int r110 = r11.length();
        a.getClass();
        a(r8, r1, r11);
        if (r11.length() != r110) goto L75;
        r11.delete(r35, r110);
        return;
    L75:
        r11.append("**");
        return;
    L76:
        if (r15 == true) goto L78;
        a.getClass();
        b(r8, r1, r11);
        return;
    L78:
        int r36 = r11.length();
        r11.append("**");
        int r111 = r11.length();
        a.getClass();
        b(r8, r1, r11);
        if (r11.length() != r111) goto L81;
        r11.delete(r36, r111);
        return;
    L81:
        r11.append("**");
        return;
    L82:
        if (r15 == true) goto L90;
        a.getClass();
        RichTextElement.TextProperty r37 = r1.getProperty();
        if (r37 == null) goto L86;
        r16 = r37.getContent();
    L86:
        if (r16 == null) goto L89;
        r5 = r16;
    L89:
        r11.append(r5);
        return;
    L90:
        int r38 = r11.length();
        r11.append("**");
        int r39 = r11.length();
        a.getClass();
        RichTextElement.TextProperty r112 = r1.getProperty();
        if (r112 == null) goto L93;
        r6 = r112.getContent();
    L93:
        if (r6 == null) goto L96;
        r5 = r6;
    L96:
        r11.append(r5);
        if (r11.length() != r39) goto L99;
        r11.delete(r38, r39);
        return;
    L99:
        r11.append("**");
        return;
    L15:
        r4 = C0052a.a[r3.ordinal()];
        goto L16
    L8:
        if (i(r1) == true) goto L11;
        r15 = false;
        goto L12
    }

    public static void d(Context r14, RichTextElement r15, Map r16, SpannableStringBuilder r17, int r18, boolean r19, boolean r20) {
        g(r17);
        int r0 = 0;
        int r1 = 1;
        if (r19 == false) goto L15;
        RichTextElement.OLProperty r3 = r15.getProperty();
        if (r3 == null) goto L15;
        Integer r4 = Integer.valueOf(r3.getStart());
        if (r4.intValue() <= 0) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L15;
        r1 = r4.intValue();
        goto L15
    L9:
        r5 = false;
    L15:
        List r6 = r15.getChildIds();
        if (r6 != null) goto L18;
        r6 = CollectionsKt.emptyList();
    L18:
        Iterator r7 = r6.iterator();
    L20:
        if (r7.hasNext() == false) goto L41;
        String r8 = (String) r7.next();
        RichTextElement r9 = (RichTextElement) r16.get(r8);
        if (r9 == null) goto L20;
        if (r9.getTag() != RichTextElement.RichTextTag.LI) goto L26;
        a.getClass();
        g(r17);
        if (r19 == false) goto L39;
        int r10 = r1 + r0;
        RichTextElement.LIProperty r11 = r9.getProperty();
        if (r11 == null) goto L32;
        String r12 = r11.getListNum();
    L33:
        if (r12 != null) goto L35;
        r12 = "";
    L35:
        String r13 = StringsKt.trim(r12).toString();
        if (d.matches(r13) == false) goto L38;
        String r21 = r13 + ' ';
    L40:
        e(r14, r9, r16, r17, r18, r21, r20);
        r0 = r0 + 1;
        goto L20
    L38:
        r21 = r10 + ". ";
        goto L40
    L32:
        r12 = null;
        goto L33
    L39:
        r21 = "- ";
        goto L40
    L26:
        a r22 = a;
        Intrinsics.checkNotNull(r8);
        r22.getClass();
        c(r14, r8, r16, r17, r18, r20);
        goto L20
    }

    public static void e(Context r6, RichTextElement r7, Map r8, SpannableStringBuilder r9, int r10, String r11, boolean r12) {
        r9.append(StringsKt.repeat("  ", r10)).append(r11);
        if (r12 == false) goto L5;
    L8:
        boolean r13 = true;
    L9:
        List r14 = r7.getChildIds();
        if (r14 != null) goto L12;
        r14 = CollectionsKt.emptyList();
    L12:
        Iterator r15 = r14.iterator();
    L14:
        if (r15.hasNext() == false) goto L23;
        String r1 = (String) r15.next();
        RichTextElement r16 = (RichTextElement) r8.get(r1);
        if (r16 == null) goto L14;
        if (b.contains(r16.getTag()) == false) goto L21;
        int r4 = r10 + 1;
    L22:
        a r17 = a;
        Intrinsics.checkNotNull(r1);
        r17.getClass();
        c(r6, r1, r8, r9, r4, r13);
        goto L14
    L21:
        r4 = r10;
        goto L22
    L23:
        return;
    L5:
        if (i(r7) == true) goto L8;
        r13 = false;
        goto L9
    }

    public static void f(a r5, CharSequence r6, SpannableStringBuilder r7, Class r8, boolean r9, Function1 r10, int r11) {
        int r1 = 0;
        if ((r11 & 8) == 0) goto L6;
        r9 = false;
    L6:
        if ((r11 & 16) == 0) goto L8;
        r10 = CommentVoiceRichTextMapper$copySpans$1.INSTANCE;
    L8:
        r5.getClass();
        if ((r6 instanceof Spanned) == false) goto L11;
        Spanned r12 = (Spanned) r6;
    L12:
        if (r12 == null) goto L28;
        Object[] r13 = r12.getSpans(0, r12.length(), r8);
        int r14 = r13.length;
    L15:
        if (r1 >= r14) goto L34;
        Object r15 = r13[r1];
        a r0 = a;
        Intrinsics.checkNotNull(r15);
        Object r2 = r10.invoke(r15);
        r0.getClass();
        int r3 = r12.getSpanStart(r15);
        int r4 = r12.getSpanEnd(r15);
        if (r3 < 0) goto L27;
        if (r4 <= r3) goto L27;
        if (r4 > r7.length()) goto L27;
        int r16 = r12.getSpanFlags(r15);
        if (r9 == true) goto L26;
        if (r16 != 0) goto L26;
        r16 = 33;
    L26:
        r7.setSpan(r2, r3, r4, r16);
    L27:
        r1 = r1 + 1;
        goto L15
    L34:
        return;
    L28:
        return;
    L11:
        r12 = null;
        goto L12
    }
}
