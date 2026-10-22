package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.bytedance.android.shopping.anchorv4.dto.base.FontStyle;
import com.bytedance.android.shopping.anchorv4.dto.base.Highlight;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class v {
    public static final SpannableString a(TextElement r9) {
        String r0 = "";
        if (r9 == null) goto L67;
        String r2 = r9.getText();
        if (r2 == null) goto L9;
        r0 = r2;
    L9:
        SpannableString r1 = new SpannableString(r0);
        FontStyle r3 = r9.getFontStyle();
        Integer r4 = null;
        if (r3 == null) goto L12;
        String r5 = r3.getTextColor();
    L13:
        r1.setSpan(new ForegroundColorSpan(com.bytedance.android.shopping.extensions.a.a(r5, ColorProtector.parseColor("#161823"))), 0, r1.length(), 33);
        FontStyle r6 = r9.getFontStyle();
        if (r6 == null) goto L16;
        r4 = Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r6.getFontSize())));
    L16:
        r1.setSpan(new AbsoluteSizeSpan(com.bytedance.android.shopping.extensions.k.g(r4, com.bytedance.android.shopping.extensions.b.b(13))), 0, r1.length(), 33);
        FontStyle r7 = r9.getFontStyle();
        if (r7 == null) goto L19;
        int r8 = r7.getFontWeight();
    L21:
        if (r8 <= 500) goto L23;
        r1.setSpan(new StyleSpan(1), 0, r1.length(), 33);
    L23:
        List r10 = r9.getHighlights();
        if (r10 != null) goto L26;
    L29:
        boolean r11 = true;
    L30:
        if (r11 == true) goto L59;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L55
        Iterator r13 = r9.getHighlights().iterator();     // Catch: Throwable -> L55
    L33:
        if (r13.hasNext() == false) goto L53;
        Highlight r14 = (Highlight) r13.next();     // Catch: Throwable -> L55
        FontStyle r15 = r14.getHighlightStyle();     // Catch: Throwable -> L55
        if (r15 == null) goto L33;
        ForegroundColorSpan r16 = new ForegroundColorSpan(com.bytedance.android.shopping.extensions.a.a(r15.getTextColor(), 0));     // Catch: Throwable -> L55
        Integer r17 = r14.getStart();     // Catch: Throwable -> L55
        if (r17 == null) goto L39;
        int r18 = r17.intValue();     // Catch: Throwable -> L55
    L40:
        Integer r19 = r14.getEnd();     // Catch: Throwable -> L55
        if (r19 == null) goto L43;
        int r20 = r19.intValue();     // Catch: Throwable -> L55
    L44:
        r1.setSpan(r16, r18, r20 + 1, 18);     // Catch: Throwable -> L55
        AbsoluteSizeSpan r21 = new AbsoluteSizeSpan(com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r15.getFontSize())));     // Catch: Throwable -> L55
        Integer r22 = r14.getStart();     // Catch: Throwable -> L55
        if (r22 == null) goto L47;
        int r23 = r22.intValue();     // Catch: Throwable -> L55
    L48:
        Integer r24 = r14.getEnd();     // Catch: Throwable -> L55
        if (r24 == null) goto L51;
        int r25 = r24.intValue();     // Catch: Throwable -> L55
    L52:
        r1.setSpan(r21, r23, r25 + 1, 18);     // Catch: Throwable -> L55
        goto L33
    L51:
        r25 = 0;
        goto L52
    L47:
        r23 = 0;
        goto L48
    L43:
        r20 = 0;
        goto L44
    L39:
        r18 = 0;
        goto L40
    L53:
        Object r26 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L55
    L57:
        Result.exceptionOrNull-impl(r26);
    L55:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
    L59:
        return r1;
    L26:
        if (r10.isEmpty() == true) goto L29;
        r11 = false;
        goto L30
    L19:
        r8 = 0;
        goto L21
    L12:
        r5 = null;
        goto L13
    L67:
        return new SpannableString("");
    }
}
