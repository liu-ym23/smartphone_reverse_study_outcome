package com.ss.android.lark.chat.message.menu;

import android.text.Spanned;
import android.text.style.ReplacementSpan;
import java.text.BreakIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class MessageLongPressTextSelectHelper$partialRangeStrategies$4 extends FunctionReferenceImpl implements Function2<CharSequence, Integer, IntRange> {
    public MessageLongPressTextSelectHelper$partialRangeStrategies$4(Object r100) {
        super(2, r100, MessageLongPressTextSelectHelper.class, "findWordRange", "findWordRange(Ljava/lang/CharSequence;I)Lkotlin/ranges/IntRange;", 0);
    }

    public final IntRange invoke(CharSequence r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "p0");
        MessageLongPressTextSelectHelper r100 = (MessageLongPressTextSelectHelper) this.receiver;
        MessageLongPressTextSelectHelper r101 = MessageLongPressTextSelectHelper.f415451a;
        r100.getClass();
        boolean r102 = false;
        IntRange r103 = null;
        if ((r110 instanceof Spanned) == false) goto L15;
        int r104 = RangesKt.coerceIn(r111, 0, r110.length());
        Spanned r105 = (Spanned) r110;
        Object[] r106 = r105.getSpans(0, r110.length(), ReplacementSpan.class);
        int r107 = r106.length;
        int r108 = 0;
    L6:
        if (r108 >= r107) goto L15;
        ReplacementSpan r109 = (ReplacementSpan) r106[r108];
        int r112 = r105.getSpanStart(r109);
        int r113 = r105.getSpanEnd(r109);
        if (r112 > r104) goto L11;
        if (r104 >= r113) goto L11;
        boolean r114 = true;
    L12:
        if (r114 == true) goto L13;
        r108 = r108 + 1;
        goto L6
    L13:
        IntRange r115 = RangesKt.until(r112, r113);
    L16:
        if (r115 != null) goto L99;
        String r116 = r110.toString();
        if (r116.length() != 0) goto L21;
        boolean r117 = true;
    L22:
        if (r117 == true) goto L79;
        BreakIterator r118 = BreakIterator.getWordInstance(Locale.getDefault());
        r118.setText(r116);
        int r119 = RangesKt.coerceIn(r111, 0, r116.length() - 1);
        int r120 = r118.preceding(r119 + 1);
        int r121 = r118.following(r119);
        if (r120 == (-1)) goto L79;
        if (r121 == (-1)) goto L79;
        if (r120 >= r121) goto L79;
    L29:
        if (r120 <= 0) goto L44;
        CharSequence r122 = r116.subSequence(r120, r121);
        int r123 = 0;
    L32:
        if (r123 >= r122.length()) goto L37;
        if (MessageLongPressTextSelectHelper.e(r122.charAt(r123)) == true) goto L35;
        r123 = r123 + 1;
        goto L32
    L35:
        boolean r124 = true;
    L38:
        if (r124 == true) goto L44;
        int r125 = r118.preceding(r120);
        if (r125 == (-1)) goto L79;
        if (r125 >= r120) goto L79;
        int r126 = r120;
        r120 = r125;
        r121 = r126;
        goto L29
    L37:
        r124 = false;
    L44:
        IntRange r127 = MessageLongPressTextSelectHelper.g(r116, r120, r121);
        if (r127 == null) goto L79;
        CharSequence r128 = r116.subSequence(r127.getFirst(), r127.getLast() + 1);
        MessageLongPressTextSelectHelper r129 = MessageLongPressTextSelectHelper.f415451a;
        int r130 = 0;
    L49:
        if (r130 >= r128.length()) goto L54;
        char r131 = r128.charAt(r130);
        r129.getClass();
        if (MessageLongPressTextSelectHelper.e(r131) == true) goto L52;
        r130 = r130 + 1;
        goto L49
    L52:
        r102 = true;
    L54:
        if (r102 == true) goto L57;
        r127 = null;
    L57:
        if (r127 == null) goto L79;
        MessageLongPressTextSelectHelper.f415451a.getClass();
        if (((r127.getLast() - r127.getFirst()) + 1) >= 2) goto L78;
        IntRange r132 = MessageLongPressTextSelectHelper.a(r116, r111);
        if (r132 == null) goto L78;
        int r133 = Math.min(r127.getFirst(), r132.getFirst());
        int r134 = Math.max(r127.getLast() + 1, r132.getLast() + 1);
    L66:
        if (r133 >= r127.getFirst()) goto L71;
        if (MessageLongPressTextSelectHelper.e(r116.charAt(r133)) == true) goto L71;
        r133 = r133 + 1;
    L71:
        if (r134 <= (r127.getLast() + 1)) goto L76;
        int r135 = r134 - 1;
        if (MessageLongPressTextSelectHelper.e(r116.charAt(r135)) == true) goto L76;
        r134 = r135;
    L76:
        if ((r134 - r133) < 2) goto L78;
        r103 = RangesKt.until(r133, r134);
    L78:
        r103 = r127;
    L79:
        if (r103 == null) goto L82;
        return r103;
    L82:
        return MessageLongPressTextSelectHelper.a(r110, r111);
    L21:
        r117 = false;
        goto L22
    L99:
        return r115;
    L11:
        r114 = false;
    L15:
        r115 = null;
        goto L16
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ IntRange invoke(CharSequence r100, Integer r101) {
        return invoke(r100, r101.intValue());
    }
}
