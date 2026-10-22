package com.ss.android.lark.chat.message.menu;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class MessageLongPressTextSelectHelper$partialRangeStrategies$2 extends FunctionReferenceImpl implements Function2<CharSequence, Integer, IntRange> {
    public MessageLongPressTextSelectHelper$partialRangeStrategies$2(Object r100) {
        super(2, r100, MessageLongPressTextSelectHelper.class, "findParagraphRange", "findParagraphRange(Ljava/lang/CharSequence;I)Lkotlin/ranges/IntRange;", 0);
    }

    public final IntRange invoke(CharSequence r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        MessageLongPressTextSelectHelper r102 = (MessageLongPressTextSelectHelper) this.receiver;
        MessageLongPressTextSelectHelper r103 = MessageLongPressTextSelectHelper.f415451a;
        r102.getClass();
        boolean r104 = false;
        int r105 = RangesKt.coerceIn(r101, 0, r100.length());
        int r106 = RangesKt.coerceAtMost(r105 - 1, r100.length() - 1);
    L4:
        if (r106 < 0) goto L9;
        if (r100.charAt(r106) == '\n') goto L7;
        r106 = r106 - 1;
        goto L4
    L7:
        int r107 = r106 + 1;
    L10:
        int r108 = RangesKt.coerceAtMost(r105, r100.length());
    L12:
        if (r108 >= r100.length()) goto L17;
        if (r100.charAt(r108) == '\n') goto L18;
        r108 = r108 + 1;
    L18:
        IntRange r109 = MessageLongPressTextSelectHelper.g(r100, r107, r108);
        if (r109 != null) goto L21;
        IntRange r110 = null;
    L22:
        if (r110 != null) goto L25;
        return null;
    L25:
        if (MessageLongPressTextSelectHelper.c(r100, r110) == true) goto L45;
        int r111 = r110.getFirst();
        if (r105 > r110.getLast()) goto L31;
        if (r111 > r105) goto L31;
        boolean r112 = true;
    L32:
        if (r112 == false) goto L34;
    L35:
        r104 = true;
    L36:
        if (r104 == true) goto L38;
        return null;
    L38:
        return r110;
    L34:
        if (r105 != (r110.getLast() + 1)) goto L36;
    L31:
        r112 = false;
        goto L32
    L45:
        return null;
    L21:
        r110 = MessageLongPressTextSelectHelper.h(r100, r109);
        goto L22
    L17:
        r108 = r100.length();
        goto L18
    L9:
        r107 = 0;
        goto L10
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ IntRange invoke(CharSequence r100, Integer r101) {
        return invoke(r100, r101.intValue());
    }
}
