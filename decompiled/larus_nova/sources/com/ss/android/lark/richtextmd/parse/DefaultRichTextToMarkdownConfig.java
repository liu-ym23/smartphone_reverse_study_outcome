package com.ss.android.lark.richtextmd.parse;

import b3c.d;
import com.ss.android.lark.richtextmd.parse.ext.b;
import com.ss.android.lark.richtextmd.parse.impl.RichTextTagHandlers;
import com.ss.android.lark.richtextmd.parse.impl.TableRichTextTagHandler;
import com.ss.android.lark.widget.richtext.RichTextElement;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/richtextmd/parse/DefaultRichTextToMarkdownConfig;", "Lcom/ss/android/lark/richtextmd/parse/ext/RichTextToMarkdownConfig;", "<init>", "()V", "configure", "", "generator", "Lcom/ss/android/lark/richtextmd/parse/base/RichTextToNodeGenerator;", "Companion", "richtext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DefaultRichTextToMarkdownConfig implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f439608a = null;

    public static final class a extends DefaultRichTextToMarkdownConfig {
        public a(int r100) {
        }
    }

    static {
        f439608a = new a(0);
    }

    public DefaultRichTextToMarkdownConfig() {
    }

    @Override // com.ss.android.lark.richtextmd.parse.ext.b
    public void a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "generator");
        Lazy r101 = RichTextTagHandlers.f439611a;
        com.ss.android.lark.richtextmd.parse.ext.a.c(r100, RichTextElement.RichTextTag.PARAGRAPH, (RichTextTagHandlers.s) RichTextTagHandlers.f439611a.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r100, RichTextElement.RichTextTag.TEXT, (RichTextTagHandlers.t) RichTextTagHandlers.f439612b.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r100, RichTextElement.RichTextTag.ANCHOR, (RichTextTagHandlers.AnchorTagHandler) RichTextTagHandlers.f439614d.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r100, RichTextElement.RichTextTag.IMG, (RichTextTagHandlers.ImageTagHandler) RichTextTagHandlers.f439616f.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r100, RichTextElement.RichTextTag.H1, (RichTextTagHandlers.g) RichTextTagHandlers.f439617g.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r100, RichTextElement.RichTextTag.H2, (RichTextTagHandlers.h) RichTextTagHandlers.f439618h.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r100, RichTextElement.RichTextTag.H3, (RichTextTagHandlers.i) RichTextTagHandlers.f439619i.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r100, RichTextElement.RichTextTag.H4, (RichTextTagHandlers.j) RichTextTagHandlers.f439620j.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r100, RichTextElement.RichTextTag.H5, (RichTextTagHandlers.k) RichTextTagHandlers.f439621k.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r100, RichTextElement.RichTextTag.H6, (RichTextTagHandlers.l) RichTextTagHandlers.f439622l.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r100, RichTextElement.RichTextTag.HR, (RichTextTagHandlers.m) RichTextTagHandlers.f439623m.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r100, RichTextElement.RichTextTag.CODE, (RichTextTagHandlers.e) RichTextTagHandlers.f439628r.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r100, RichTextElement.RichTextTag.CODE_BLOCK_V2, (RichTextTagHandlers.CodeBlockTagHandler) RichTextTagHandlers.f439629s.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r100, RichTextElement.RichTextTag.UL, (RichTextTagHandlers.d) RichTextTagHandlers.f439625o.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r100, RichTextElement.RichTextTag.OL, (RichTextTagHandlers.r) RichTextTagHandlers.f439626p.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r100, RichTextElement.RichTextTag.LI, (RichTextTagHandlers.o) RichTextTagHandlers.f439627q.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r100, RichTextElement.RichTextTag.QUOTE, (RichTextTagHandlers.c) RichTextTagHandlers.f439624n.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r100, RichTextElement.RichTextTag.EMOTION, (RichTextTagHandlers.f) RichTextTagHandlers.f439613c.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r100, RichTextElement.RichTextTag.AT, (RichTextTagHandlers.a) RichTextTagHandlers.f439615e.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r100, RichTextElement.RichTextTag.AT_USER_GROUP, (RichTextTagHandlers.b) RichTextTagHandlers.f439630t.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r100, RichTextElement.RichTextTag.TABLE, (TableRichTextTagHandler) RichTextTagHandlers.f439631u.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r100, RichTextElement.RichTextTag.MEDIA, (RichTextTagHandlers.q) RichTextTagHandlers.f439633w.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r100, RichTextElement.RichTextTag.MARKDOWN, (RichTextTagHandlers.p) RichTextTagHandlers.f439634x.getValue());
    }
}
