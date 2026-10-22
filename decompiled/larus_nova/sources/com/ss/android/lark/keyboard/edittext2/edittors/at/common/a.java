package com.ss.android.lark.keyboard.edittext2.edittors.at.common;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import hob.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class a extends com.ss.android.lark.keyboard.edittext2.edittors.at.a<c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.edittext2.edittors.a f429041c;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.edittext2.edittors.at.common.a$a, reason: collision with other inner class name */
    public static final class C5090a {
    }

    static {
    }

    public void o(EditText r100) {
        Intrinsics.checkNotNullParameter(r100, "targetView");
        SpannableStringBuilder r101 = e(this.f429041c).getFirst();
        n(r101, this.f429040b, 0, r101.length());
        l(r100.getEditableText(), r101);
    }

    public a(com.ss.android.lark.keyboard.edittext2.edittors.a r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        Intrinsics.checkNotNullParameter(r101, "data");
        super(r101, "CommonAtSpanHolder");
        this.f429041c = r100;
    }

    public void n(SpannableStringBuilder r100, c r101, int r102, int r110) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "data");
        com.ss.android.lark.keyboard.edittext2.edittors.at.a.j(r101);
        RichTextElement.AtProperty r103 = r101.f486314g;
        if (r103 == null) goto L9;
        RichTextElement r104 = RichTextElementCreator.h(r103);
        r100.setSpan(new p(r104, r100.subSequence(0, r110).toString()), 0, r110, 33);
        if (r101.f486313f == false) goto L7;
        r100.append(" ");
    L7:
        h(r100, r101, 0, r110, r104);
        return;
    }
}
