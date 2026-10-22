package org.commonmark.internal;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;
import org.commonmark.node.Block;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.Paragraph;

/* JADX INFO: loaded from: classes42.dex */
public final class k extends wvc.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern[][] f525711e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HtmlBlock f525712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Pattern f525713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f525714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public org.commonmark.internal.a f525715d;

    /* JADX INFO: loaded from: classes5.dex */
    public static class a extends wvc.b {
        public a() {
        }

        @Override // wvc.e
        public final wvc.f a(wvc.g r100, h.a r110) {
            h r101 = (h) r100;
            int r102 = r101.f525694e;
            CharSequence r103 = r101.f525690a;
            if (r101.f525696g < 4) goto L5;
            return null;
        L5:
            if (r103.charAt(r102) != '<') goto L24;
            int r104 = 1;
        L8:
            if (r104 > 7) goto L25;
            if (r104 == 7) goto L11;
        L13:
            Pattern[] r105 = k.f525711e[r104];
            Pattern r106 = r105[0];
            Pattern r107 = r105[1];
            if (r106.matcher(r103.subSequence(r102, r103.length())).find() == false) goto L17;
            d r108 = new d(new wvc.d[]{new k(r107)});
            r108.f525669b = r101.f525691b;
            return r108;
        L17:
            r104 = r104 + 1;
            goto L8
        L11:
            if ((r110.f525705a.a() instanceof Paragraph) == false) goto L13;
        L25:
            return null;
        L24:
            return null;
        }
    }

    static {
        f525711e = new Pattern[][]{new Pattern[]{null, null}, new Pattern[]{PatternProtector.compile("^<(?:script|pre|style)(?:\\s|>|$)", 2), PatternProtector.compile("</(?:script|pre|style)>", 2)}, new Pattern[]{PatternProtector.compile("^<!--"), PatternProtector.compile("-->")}, new Pattern[]{PatternProtector.compile("^<[?]"), PatternProtector.compile("\\?>")}, new Pattern[]{PatternProtector.compile("^<![A-Z]"), PatternProtector.compile(">")}, new Pattern[]{PatternProtector.compile("^<!\\[CDATA\\["), PatternProtector.compile("\\]\\]>")}, new Pattern[]{PatternProtector.compile("^</?(?:address|article|aside|base|basefont|blockquote|body|caption|center|col|colgroup|dd|details|dialog|dir|div|dl|dt|fieldset|figcaption|figure|footer|form|frame|frameset|h1|h2|h3|h4|h5|h6|head|header|hr|html|iframe|legend|li|link|main|menu|menuitem|nav|noframes|ol|optgroup|option|p|param|section|source|summary|table|tbody|td|tfoot|th|thead|title|tr|track|ul)(?:\\s|[/]?[>]|$)", 2), null}, new Pattern[]{PatternProtector.compile("^(?:<[A-Za-z][A-Za-z0-9-_]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-_]*\\s*[>])\\s*$", 2), null}};
    }

    @Override // wvc.a, wvc.d
    public final void c() {
        HtmlBlock r100 = this.f525712a;
        r100.f525768h = this.f525715d.f525662a.toString();
        this.f525715d = null;
    }

    @Override // wvc.d
    public final Block a() {
        return this.f525712a;
    }

    public k(Pattern r100) {
        this.f525712a = new HtmlBlock();
        this.f525714c = false;
        this.f525715d = new org.commonmark.internal.a();
        this.f525713b = r100;
    }

    @Override // wvc.a, wvc.d
    public final void d(CharSequence r100) {
        org.commonmark.internal.a r101 = this.f525715d;
        if (r101.f525663b == 0) goto L5;
        r101.f525662a.append('\n');
    L5:
        r101.f525662a.append(r100);
        r101.f525663b++;
        Pattern r102 = this.f525713b;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.matcher(r100).find() == false) goto L12;
        this.f525714c = true;
        return;
    }

    @Override // wvc.d
    public final wvc.c f(wvc.g r100) {
        if (this.f525714c == false) goto L5;
        return null;
    L5:
        h r101 = (h) r100;
        if (r101.f525697h == false) goto L11;
        if (this.f525713b != null) goto L11;
        return null;
    L11:
        return wvc.c.a(r101.f525691b);
    }
}
