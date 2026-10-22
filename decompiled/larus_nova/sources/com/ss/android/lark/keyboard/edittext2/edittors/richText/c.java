package com.ss.android.lark.keyboard.edittext2.edittors.richText;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.span.TextStyleInfo;
import com.ss.android.lark.widget.span.h0;
import com.ss.android.lark.widget.span.l0;
import com.ss.android.lark.widget.span.q;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import lec.f;

/* JADX INFO: loaded from: classes36.dex */
public final class c {
    public static final void a(SpannableStringBuilder r100, int r101, int r102, TextStyleInfo r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103.isBold == false) goto L8;
        r100.setSpan(new com.ss.android.lark.widget.span.c(), r101, r102, 33);
    L8:
        if (r103.isItalic == false) goto L11;
        r100.setSpan(new q(), r101, r102, 33);
    L11:
        if (r103.isUnderlineText == false) goto L14;
        r100.setSpan(new l0(), r101, r102, 33);
    L14:
        if (r103.isStrikeThruText == false) goto L18;
        r100.setSpan(new h0(), r101, r102, 33);
        return;
    }

    public static final void b(SpannableStringBuilder r100, int r101, int r102, Map<String, String> r103, Context r104) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r103 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == true) goto L19;
        if (r101 > r102) goto L20;
        if (r101 >= 0) goto L13;
        return;
    L13:
        if (r102 > r100.length()) goto L22;
        if (r104 != null) goto L17;
        r104 = UIHelper.getContext();
    L17:
        String r106 = r100.subSequence(r101, r102).toString();
        f r107 = new f(r104);
        r107.d();
        r107.c(r103);
        a(r100, r101, r102, r107.e(r106));
        return;
    L22:
        return;
    L20:
        return;
    L19:
        return;
    L5:
        if (r103.isEmpty() == true) goto L8;
        r105 = false;
        goto L9
    }
}
