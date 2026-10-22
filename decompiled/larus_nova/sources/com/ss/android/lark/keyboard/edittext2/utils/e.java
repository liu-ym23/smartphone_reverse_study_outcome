package com.ss.android.lark.keyboard.edittext2.utils;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.widget.EditText;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class e {
    public static /* synthetic */ com.ss.android.lark.keyboard.edittext2.base.a b(com.ss.android.lark.keyboard.edittext2.base.a r100) {
        return a(r100, ExtensionsKt$copy$1.INSTANCE);
    }

    public static final int c(EditText r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.getSelectionStart() - 1;
        Character r102 = StringsKt.getOrNull(r100.getText(), r101);
        if (r102 != null) goto L6;
    L8:
        return -1;
    L6:
        if (r102.charValue() != '@') goto L8;
        return r101;
    }

    public static final SpannableStringBuilder e(CharSequence r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        SpannableStringBuilder r100 = new SpannableStringBuilder(r110.toString());
        if ((r110 instanceof Spanned) == false) goto L12;
        Spanned r101 = (Spanned) r110;
        int r111 = r110.length();
        Object[] r102 = r101.getSpans(0, r111, Object.class);
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L12;
        int r105 = r101.getSpanStart(r102[r104]);
        int r106 = r101.getSpanEnd(r102[r104]);
        int r107 = r101.getSpanFlags(r102[r104]);
        if (r105 >= 0) goto L9;
        r105 = 0;
    L9:
        if (r106 <= r111) goto L11;
        r106 = r111;
    L11:
        r100.setSpan(r102[r104], (r105 - 0) + 0, (r106 - 0) + 0, r107);
        r104 = r104 + 1;
    L12:
        return r100;
    }

    public static final <S extends com.ss.android.lark.keyboard.edittext2.base.a> S a(S r100, Function2<? super S, ? super S, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "action");
        S r102 = (S) r100.getClass().newInstance();
        r102.A(r100.getTarget());
        r102.d();
        r102.G(r100);
        Intrinsics.checkNotNull(r102);
        r101.invoke(r102, r100);
        return r102;
    }

    public static final void d(EditText r110, Object r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "span");
        int r100 = r110.getSelectionEnd();
        Editable r101 = r110.getEditableText();
        int r102 = 0;
        Object[] r103 = r101.getSpans(0, r101.length(), SpanWatcher.class);
        int r104 = r103.length;
    L3:
        if (r102 >= r104) goto L5;
        ((SpanWatcher) r103[r102]).onSpanChanged(r110.getEditableText(), r111, 0, r110.getEditableText().length(), 0, r110.getEditableText().length());
        r102 = r102 + 1;
        goto L3
    L5:
        r110.setSelection(r100);
    }
}
