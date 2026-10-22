package com.ss.android.lark.richtextmd.parse.ext;

import android.content.Context;
import b3c.d;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.richtext.RichTextElement;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {
    public static final com.ss.android.lark.richtextmd.parse.impl.b b(Context r100) {
        Intrinsics.checkNotNullParameter(t9b.a.f545142a, "<this>");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.ss.android.lark.richtextmd.parse.impl.b r101 = new com.ss.android.lark.richtextmd.parse.impl.b(r100);
        a(r101, ExtRichTextMarkdownKt$fromRichText$1.INSTANCE);
        return r101;
    }

    public static final void a(com.ss.android.lark.richtextmd.parse.impl.b r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "config");
        ((b) r101.invoke(com.ss.android.lark.richtextmd.parse.a.f439609a)).a(r100);
    }

    public static final void c(d r100, RichTextElement.RichTextTag r101, b3c.a r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "handler");
        r100.a(r101, r102);
    }
}
