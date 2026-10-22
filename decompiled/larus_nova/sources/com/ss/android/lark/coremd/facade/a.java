package com.ss.android.lark.coremd.facade;

import b3c.d;
import com.ss.android.lark.coremd.facade.richtext.IMRichTextTagHandlers;
import com.ss.android.lark.widget.richtext.RichTextElement;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends IMRichTextToMarkdownConfig {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f419621b = null;

    static {
        f419621b = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.coremd.facade.IMRichTextToMarkdownConfig, com.ss.android.lark.richtextmd.parse.DefaultRichTextToMarkdownConfig, com.ss.android.lark.richtextmd.parse.ext.b
    public final void a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "generator");
        super.a(r100);
        Lazy r101 = IMRichTextTagHandlers.f419798a;
        com.ss.android.lark.richtextmd.parse.ext.a.c(r100, RichTextElement.RichTextTag.TEXT, (com.ss.android.lark.coremd.facade.richtext.c) IMRichTextTagHandlers.f419801d.getValue());
    }
}
