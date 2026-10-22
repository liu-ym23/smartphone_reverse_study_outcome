package com.ss.android.lark.coremd.facade.mdeditor;

import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.coremd.ext.g;
import com.ss.android.lark.coremd.facade.mdeditor.theme.IMEditorThemeExtend;
import com.ss.android.lark.keyboard.edittext2.mdeditor.RichTextMarkdownEditor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class IMRichTextMarkdownEditor extends RichTextMarkdownEditor {
    @Override // com.ss.android.lark.keyboard.edittext2.mdeditor.RichTextMarkdownEditor
    public final j Y(j r100) {
        Intrinsics.checkNotNullParameter(r100, "theme");
        j r101 = super.Y(r100);
        g.a(r101, IMEditorThemeExtend.f419771p, new IMRichTextMarkdownEditor$interceptTheme$1(this));
        return r101;
    }
}
