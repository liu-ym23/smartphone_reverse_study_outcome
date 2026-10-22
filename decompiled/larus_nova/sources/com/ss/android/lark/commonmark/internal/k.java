package com.ss.android.lark.commonmark.internal;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;
import v7b.v;

/* JADX INFO: loaded from: classes35.dex */
public final class k extends y7b.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern[][] f417233e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v7b.j f417234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Pattern f417235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f417236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.ss.android.lark.commonmark.internal.a f417237d;

    public static class a extends y7b.b {
        public a() {
        }

        @Override // y7b.e
        public final d a(y7b.g r100, h.a r110) {
            h r101 = (h) r100;
            int r102 = r101.f417210f;
            CharSequence r103 = r101.f417205a.f558606a;
            if (r101.f417212h < 4) goto L5;
            return null;
        L5:
            if (r103.charAt(r102) != '<') goto L27;
            int r104 = 1;
        L8:
            if (r104 > 7) goto L28;
            if (r104 == 7) goto L11;
        L15:
            Pattern[] r105 = k.f417233e[r104];
            Pattern r106 = r105[0];
            Pattern r107 = r105[1];
            if (r106.matcher(r103.subSequence(r102, r103.length())).find() == false) goto L19;
            d r108 = new d(new y7b.d[]{new k(r107)});
            r108.f417184b = r101.f417207c;
            return r108;
        L19:
            r104 = r104 + 1;
            goto L8
        L11:
            if ((r110.f417223a.a() instanceof v) == true) goto L19;
            if (r101.h().b() == false) goto L15;
        L28:
            return null;
        L27:
            return null;
        }
    }

    static {
        f417233e = new Pattern[][]{new Pattern[]{null, null}, new Pattern[]{PatternProtector.compile("^<(?:script|pre|style|textarea)(?:\\s|>|$)", 2), PatternProtector.compile("</(?:script|pre|style|textarea)>", 2)}, new Pattern[]{PatternProtector.compile("^<!--"), PatternProtector.compile("-->")}, new Pattern[]{PatternProtector.compile("^<[?]"), PatternProtector.compile("\\?>")}, new Pattern[]{PatternProtector.compile("^<![A-Z]"), PatternProtector.compile(">")}, new Pattern[]{PatternProtector.compile("^<!\\[CDATA\\["), PatternProtector.compile("\\]\\]>")}, new Pattern[]{PatternProtector.compile("^</?(?:address|article|aside|base|basefont|blockquote|body|caption|center|col|colgroup|dd|details|dialog|dir|div|dl|dt|fieldset|figcaption|figure|footer|form|frame|frameset|h1|h2|h3|h4|h5|h6|head|header|hr|html|iframe|legend|li|link|main|menu|menuitem|nav|noframes|ol|optgroup|option|p|param|search|section|summary|table|tbody|td|tfoot|th|thead|title|tr|track|ul)(?:\\s|[/]?[>]|$)", 2), null}, new Pattern[]{PatternProtector.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>])\\s*$", 2), null}};
    }

    @Override // y7b.a, y7b.d
    public final void c() {
        v7b.j r100 = this.f417234a;
        this.f417237d.f417177a.getClass();
        r100.getClass();
        this.f417237d = null;
    }

    @Override // y7b.d
    public final v7b.a a() {
        return this.f417234a;
    }

    public k(Pattern r100) {
        this.f417234a = new v7b.j();
        this.f417236c = false;
        this.f417237d = new com.ss.android.lark.commonmark.internal.a();
        this.f417235b = r100;
    }

    @Override // y7b.a, y7b.d
    public final void e(w7b.f r100) {
        com.ss.android.lark.commonmark.internal.a r101 = this.f417237d;
        CharSequence r102 = r100.f558606a;
        if (r101.f417178b == 0) goto L5;
        r101.f417177a.append('\n');
    L5:
        r101.f417177a.append(r102);
        r101.f417178b++;
        Pattern r103 = this.f417235b;
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.matcher(r100.f558606a).find() == false) goto L12;
        this.f417236c = true;
        return;
    }

    @Override // y7b.d
    public final y7b.c h(y7b.g r100) {
        if (this.f417236c == false) goto L5;
        return null;
    L5:
        h r101 = (h) r100;
        if (r101.f417213i == false) goto L11;
        if (this.f417235b != null) goto L11;
        return null;
    L11:
        return y7b.c.a(r101.f417207c);
    }
}
