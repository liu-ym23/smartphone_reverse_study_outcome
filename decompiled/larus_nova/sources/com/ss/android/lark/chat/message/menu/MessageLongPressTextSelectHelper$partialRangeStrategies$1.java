package com.ss.android.lark.chat.message.menu;

import android.text.Spanned;
import android.text.style.ClickableSpan;
import com.ss.android.lark.coremd.impl.parse.h;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class MessageLongPressTextSelectHelper$partialRangeStrategies$1 extends FunctionReferenceImpl implements Function2<CharSequence, Integer, IntRange> {
    public MessageLongPressTextSelectHelper$partialRangeStrategies$1(Object r100) {
        super(2, r100, MessageLongPressTextSelectHelper.class, "findClickableSpanRange", "findClickableSpanRange(Ljava/lang/CharSequence;I)Lkotlin/ranges/IntRange;", 0);
    }

    public final IntRange invoke(CharSequence r100, int r110) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        MessageLongPressTextSelectHelper r101 = (MessageLongPressTextSelectHelper) this.receiver;
        MessageLongPressTextSelectHelper r102 = MessageLongPressTextSelectHelper.f415451a;
        r101.getClass();
        if ((r100 instanceof Spanned) == false) goto L24;
        int r111 = RangesKt.coerceIn(r110, 0, r100.length());
        Spanned r103 = (Spanned) r100;
        Object[] r104 = r103.getSpans(0, r100.length(), ClickableSpan.class);
        int r105 = r104.length;
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L24;
        ClickableSpan r107 = (ClickableSpan) r104[r106];
        MessageLongPressTextSelectHelper r108 = MessageLongPressTextSelectHelper.f415451a;
        Intrinsics.checkNotNull(r107);
        r108.getClass();
        boolean r109 = true;
        if ((r107 instanceof h) == true) goto L10;
    L12:
        boolean r112 = false;
    L13:
        if (r112 == true) goto L23;
        int r113 = r103.getSpanStart(r107);
        int r114 = r103.getSpanEnd(r107);
        if (r113 > r111) goto L19;
        if (r111 > r114) goto L19;
    L20:
        if (r109 == false) goto L23;
        if (r113 >= r114) goto L23;
        return RangesKt.until(r113, r114);
    L19:
        r109 = false;
    L23:
        r106 = r106 + 1;
        goto L6
    L10:
        if (MessageLongPressTextSelectHelper.f415453c.contains(((h) r107).getType()) == false) goto L12;
        r112 = true;
    L24:
        return null;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ IntRange invoke(CharSequence r100, Integer r101) {
        return invoke(r100, r101.intValue());
    }
}
