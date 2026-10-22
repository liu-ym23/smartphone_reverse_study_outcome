package com.ss.android.lark.commonmark.html;

import com.ss.android.lark.conditional.access.display.DisplayUtilsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import v7b.s;
import w7b.d;
import w7b.e;

/* JADX INFO: loaded from: classes35.dex */
public final class HtmlCompatMarkdownParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f417156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Lambda f417157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f417158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f417159d;

    public static final class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HtmlCompatMarkdownParser f417160a;

        public a(HtmlCompatMarkdownParser r100) {
            this.f417160a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
        @Override // w7b.e
        public final s a(s r100) {
            return (s) this.f417160a.f417157b.invoke(r100);
        }
    }

    public HtmlCompatMarkdownParser() {
        this.f417157b = HtmlCompatMarkdownParser$processorDelegate$1.INSTANCE;
        this.f417158c = new a(this);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.lark.commonmark.html.HtmlCompatMarkdownParser$handleHtml$1$1, kotlin.jvm.internal.Lambda] */
    public final HtmlCompatMarkdownParser a(final DisplayUtilsKt.d r100) {
        Intrinsics.checkNotNullParameter(r100, "factory");
        this.f417157b = new HtmlCompatMarkdownParser$handleHtml$1$1(r100);
        return this;
    }

    public final s b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "markdownString");
        d r101 = this.f417159d;
        if (r101 != null) goto L7;
        d.a r102 = new d.a();
        r102.a(this.f417158c);
        r102.a(new c(this.f417156a));
        d r103 = new d(r102);
        this.f417159d = r103;
        Intrinsics.checkNotNull(r103);
        r101 = r103;
    L7:
        return r101.a(r100);
    }
}
