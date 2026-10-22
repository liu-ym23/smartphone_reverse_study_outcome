package com.ss.android.lark.keyboard.edittext2.mdeditor.bizeditors;

import android.text.SpannableStringBuilder;
import com.ss.android.lark.keyboard.edittext2.base.c;
import com.ss.android.lark.keyboard.edittext2.mdeditor.MarkdownNodeEditor;
import com.ss.android.lark.keyboard.edittext2.utils.e;
import hob.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends com.ss.android.lark.keyboard.edittext2.edittors.b {
    public a() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.b, com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final /* bridge */ /* synthetic */ void S(SpannableStringBuilder r100, d r101, int r102) {
        U(r100, r101, r102);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.b
    public final void U(SpannableStringBuilder r100, d r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "data");
        eab.b r103 = new eab.b(r101.f486319a, r101.f486320b, r101.f486321c);
        ((MarkdownNodeEditor) q(MarkdownNodeEditor.f429172g)).R(r103, r100);
        r100.append(" ");
        int r104 = e.c(c.a.a(this));
        if (r104 < 0) goto L6;
        c.a.a(this).getEditableText().delete(r104, r104 + 1);
        return;
    }
}
