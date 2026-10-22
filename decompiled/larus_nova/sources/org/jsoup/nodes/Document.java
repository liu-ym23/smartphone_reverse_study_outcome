package org.jsoup.nodes;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes42.dex */
public final class Document extends Element {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OutputSettings f525890k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public org.jsoup.parser.e f525891l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public QuirksMode f525892m;

    public static class OutputSettings implements Cloneable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Entities.EscapeMode f525893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Charset f525894b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ThreadLocal<CharsetEncoder> f525895c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public Entities.CoreCharset f525896d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f525897e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f525898f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f525899g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Syntax f525900h;

        public static final enum Syntax extends Enum<Syntax> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Syntax[] f525901a = null;
            public static final Syntax html = null;
            public static final Syntax xml = null;

            static {
                Syntax r100 = new Syntax("html", 0);
                html = r100;
                Syntax r101 = new Syntax("xml", 1);
                xml = r101;
                f525901a = new Syntax[]{r100, r101};
            }

            public static Syntax[] values() {
                return (Syntax[]) f525901a.clone();
            }

            public static Syntax valueOf(String r100) {
                return (Syntax) r27.a.a(Syntax.class, r100);
            }

            public Syntax(String r100, int r101) {
                super(r100, r101);
            }
        }

        public OutputSettings() {
            this.f525893a = Entities.EscapeMode.base;
            this.f525894b = ewc.a.f474616a;
            this.f525895c = new ThreadLocal();
            this.f525897e = true;
            this.f525898f = 1;
            this.f525899g = 30;
            this.f525900h = Syntax.html;
        }

        public final OutputSettings a() {
            OutputSettings r100 = (OutputSettings) super.clone();     // Catch: CloneNotSupportedException -> L5
            String r101 = this.f525894b.name();
            r100.getClass();
            r100.f525894b = Charset.forName(r101);
            r100.f525893a = Entities.EscapeMode.valueOf(this.f525893a.name());
            return r100;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
            return a();
        }
    }

    public static final enum QuirksMode extends Enum<QuirksMode> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ QuirksMode[] f525902a = null;
        public static final QuirksMode limitedQuirks = null;
        public static final QuirksMode noQuirks = null;
        public static final QuirksMode quirks = null;

        static {
            QuirksMode r100 = new QuirksMode("noQuirks", 0);
            noQuirks = r100;
            QuirksMode r101 = new QuirksMode("quirks", 1);
            quirks = r101;
            QuirksMode r102 = new QuirksMode("limitedQuirks", 2);
            limitedQuirks = r102;
            f525902a = new QuirksMode[]{r100, r101, r102};
        }

        public static QuirksMode[] values() {
            return (QuirksMode[]) f525902a.clone();
        }

        public static QuirksMode valueOf(String r100) {
            return (QuirksMode) r27.a.a(QuirksMode.class, r100);
        }

        public QuirksMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.j
    public final String t() {
        return "#document";
    }

    static {
        new org.jsoup.select.c.n0("title");
    }

    @Override // org.jsoup.nodes.Element
    public final Element N() {
        Document r100 = (Document) super.N();
        r100.f525890k = this.f525890k.a();
        return r100;
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.j
    public final Object clone() throws CloneNotSupportedException {
        Document r100 = (Document) super.N();
        r100.f525890k = this.f525890k.a();
        return r100;
    }

    public final Element d0() {
        Iterator<Element> r100 = J().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Element r101 = r100.next();
        if (r101.f525906d.f526035b.equals("html") == false) goto L4;
    L9:
        Iterator<Element> r102 = r101.J().iterator();
    L11:
        if (r102.hasNext() == false) goto L17;
        Element r103 = r102.next();
        if (ContainerPosition.BODY.equals(r103.f525906d.f526035b) == true) goto L16;
        if ("frameset".equals(r103.f525906d.f526035b) == false) goto L11;
    L16:
        return r103;
    L17:
        Element r104 = new Element(org.jsoup.parser.f.a(ContainerPosition.BODY, k.a(r101).f526026c), r101.g(), null);
        r101.G(r104);
        return r104;
    L8:
        r101 = new Element(org.jsoup.parser.f.a("html", k.a(this).f526026c), g(), null);
        G(r101);
        goto L9
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.j
    public final j k() {
        Document r100 = (Document) super.N();
        r100.f525890k = this.f525890k.a();
        return r100;
    }

    @Override // org.jsoup.nodes.j
    public final String u() {
        return T();
    }

    public Document(String r100) {
        super(org.jsoup.parser.f.a("#root", org.jsoup.parser.d.f526020c), r100, null);
        this.f525890k = new OutputSettings();
        this.f525892m = QuirksMode.noQuirks;
        this.f525891l = new org.jsoup.parser.e(new org.jsoup.parser.b());
    }

    @Override // org.jsoup.nodes.Element
    public final void b0(String r100) {
        d0().b0(r100);
    }
}
