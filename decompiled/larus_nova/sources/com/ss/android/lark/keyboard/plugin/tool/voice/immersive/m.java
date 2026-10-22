package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.text.SpannableStringBuilder;
import com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public final class m extends RichTextEditor {
    public m() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor, com.ss.android.lark.widget.richtext.b
    public final void t(RichTextElement.AtProperty r100, Map<String, String> r101) {
        if (r100 == null) goto L8;
        com.ss.android.lark.keyboard.edittext2.edittors.a r102 = (com.ss.android.lark.keyboard.edittext2.edittors.a) q(com.ss.android.lark.keyboard.edittext2.edittors.a.f428974e);
        SpannableStringBuilder r103 = this.f429088p;
        if (r103 != null) goto L6;
        return;
    L6:
        int r104 = hob.c.f486307k;
        r102.R(hob.c.a.a(r100), r103);
        return;
    }
}
