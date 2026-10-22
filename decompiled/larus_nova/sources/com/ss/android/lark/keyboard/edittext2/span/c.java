package com.ss.android.lark.keyboard.edittext2.span;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import com.ss.android.lark.widget.codeblock.preview.CodeBlockV2Span;
import com.ss.android.lark.widget.codeblock.process.CodeBlockV2ProcessParams;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends CodeBlockV2Span implements f {
    public c(Context r100, List<LineContent> r101, CodeBlockV2ProcessParams r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lineContents");
        Intrinsics.checkNotNullParameter(r102, "params");
        super(r100, r101, r102, 0);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.span.k
    public final k.a e(int r100, int r101, Editable r102) {
        Intrinsics.checkNotNullParameter(r102, "text");
        int r103 = r102.getSpanStart(this);
        int r104 = r102.getSpanEnd(this);
        if (r101 <= r103) goto L6;
        if (r104 < r100) goto L6;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L10;
        return null;
    L10:
        if (r100 < 0) goto L22;
        if (r101 < 0) goto L22;
        if (r100 != r101) goto L22;
        int r106 = r102.getSpanEnd(this);
        if (r100 != r106) goto L19;
        if (r101 != r106) goto L19;
        return null;
    L19:
        Selection.setSelection(r102, r106, r106);
        return new k.a(r106, r106);
    L22:
        return new k.a(r100, r101);
    L6:
        r105 = false;
        goto L8
    }
}
