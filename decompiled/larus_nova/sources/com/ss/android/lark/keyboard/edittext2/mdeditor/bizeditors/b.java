package com.ss.android.lark.keyboard.edittext2.mdeditor.bizeditors;

import android.text.SpannableStringBuilder;
import com.ss.android.lark.keyboard.edittext2.edittors.d;
import com.ss.android.lark.keyboard.edittext2.mdeditor.MarkdownNodeEditor;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiHandler;
import eab.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends d {
    public b() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.d, com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final /* bridge */ /* synthetic */ void S(SpannableStringBuilder r100, String r101, int r102) {
        U(r100, r101, r102);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.d
    public final void U(SpannableStringBuilder r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "emojiKey");
        c r103 = new c(EmojiHandler.e(r101), r101);
        ((MarkdownNodeEditor) q(MarkdownNodeEditor.f429172g)).R(r103, r100);
    }
}
