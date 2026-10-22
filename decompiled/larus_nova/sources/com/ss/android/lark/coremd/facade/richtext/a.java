package com.ss.android.lark.coremd.facade.richtext;

import com.ss.android.lark.coremd.facade.bizext.props.IMAtNodeExtend;
import com.ss.android.lark.coremd.facade.bizext.props.IMImageExtend;
import com.ss.android.lark.coremd.facade.bizext.props.IMMediaExtend;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import eab.f;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v7b.l;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f419802a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f419803b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C4946a f419804c = null;

    /* JADX INFO: renamed from: com.ss.android.lark.coremd.facade.richtext.a$a, reason: collision with other inner class name */
    public static final class C4946a<N extends s> implements com.ss.android.lark.richtextmd.generate.c.InterfaceC5271c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C4946a<N> f419805a = null;

        static {
            f419805a = new C4946a();
        }

        public C4946a() {
        }

        @Override // com.ss.android.lark.richtextmd.generate.c.InterfaceC5271c
        public final RichTextElement a(com.ss.android.lark.richtextmd.generate.c.b r100, s r101) {
            final eab.a r102 = (eab.a) r101;
            Intrinsics.checkNotNullParameter(r100, "$this$NodeHandler");
            Intrinsics.checkNotNullParameter(r102, "it");
            final RichTextElement.AtProperty r103 = new RichTextElement.AtProperty();
            r103.setUserId(r102.f471734k);
            r103.setContent(r102.f471733j);
            IMAtNodeExtend.f419650i.b(new IMMarkdownToRichTextHandlers$at$1$1(r103, r102));
            return RichTextElementCreator.h(r103);
        }
    }

    public static final class b<N extends s> implements com.ss.android.lark.richtextmd.generate.c.InterfaceC5271c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<N> f419806a = null;

        static {
            f419806a = new b();
        }

        public b() {
        }

        @Override // com.ss.android.lark.richtextmd.generate.c.InterfaceC5271c
        public final RichTextElement a(com.ss.android.lark.richtextmd.generate.c.b r100, s r101) {
            final l r102 = (l) r101;
            Intrinsics.checkNotNullParameter(r100, "$this$NodeHandler");
            Intrinsics.checkNotNullParameter(r102, "it");
            final RichTextElement.ImageProperty r103 = new RichTextElement.ImageProperty();
            IMImageExtend.f419659p.b(new IMMarkdownToRichTextHandlers$image$1$1(r103, r102));
            RichTextElement r104 = RichTextElementCreator.h(r103);
            RichTextElement r105 = RichTextElementCreator.h(new RichTextElement.FigureProperty());
            r100.a(r105, r104);
            return r105;
        }
    }

    public static final class c<N extends s> implements com.ss.android.lark.richtextmd.generate.c.InterfaceC5271c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<N> f419807a = null;

        static {
            f419807a = new c();
        }

        public c() {
        }

        @Override // com.ss.android.lark.richtextmd.generate.c.InterfaceC5271c
        public final RichTextElement a(com.ss.android.lark.richtextmd.generate.c.b r100, s r101) {
            final f r102 = (f) r101;
            Intrinsics.checkNotNullParameter(r100, "$this$NodeHandler");
            Intrinsics.checkNotNullParameter(r102, "it");
            final RichTextElement.MediaProperty r103 = new RichTextElement.MediaProperty();
            IMMediaExtend.f419669q.b(new IMMarkdownToRichTextHandlers$media$1$1(r103, r102));
            RichTextElement r104 = RichTextElementCreator.h(r103);
            RichTextElement r105 = RichTextElementCreator.h(new RichTextElement.FigureProperty());
            String r106 = String.valueOf(r100.f439566d.getAndIncrement());
            r105.setChildIds(CollectionsKt.listOf(r106));
            r100.f439565c.put(r106, r104);
            return r105;
        }
    }

    static {
        f419802a = b.f419806a;
        f419803b = c.f419807a;
        f419804c = C4946a.f419805a;
    }
}
