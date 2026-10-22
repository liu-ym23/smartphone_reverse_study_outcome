package io.noties.markwon.ext.onetex;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import io.noties.markwon.onetex.LatexMathNode;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public final class v extends zsc.i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Pattern f492484e;

    public static final class a {
    }

    static {
    }

    @Override // zsc.i
    public final char d() {
        return '\\';
    }

    @Override // zsc.i
    public final uvc.b b() {
        boolean r100 = true;
        if ((this.f573521d + 1) < this.f573520c.length()) goto L6;
    L4:
        r100 = false;
    L11:
        if (r100 == true) goto L13;
        return null;
    L13:
        int r101 = this.f573521d;
        String r102 = a(this.f492484e);
        if (r102 != null) goto L19;
        com.larus.business.markdown.api.depend.d r103 = IMarkdownLoggerKt.a();
        if (r103 == null) goto L18;
        r103.e("md_parse", "NewLatexMathInlineProcessor error parse latex: raw: " + this.f573520c + "; context: " + this.f573518a + "; index: " + this.f573521d + "; oldIndex: " + r101);
    L18:
        return null;
    L19:
        LatexMathNode r104 = new LatexMathNode();
        com.larus.business.markdown.api.depend.d r105 = IMarkdownLoggerKt.a();
        if (r105 == null) goto L22;
        r105.i("md_parse", "NewLatexMathInlineProcessor latex: " + r102 + "; index: " + this.f573521d + "; oldIndex: " + r101);
    L22:
        r104.f492653h = r102.substring(2, r102.length() - 2);
        return r104;
    L6:
        if (this.f573520c.charAt(this.f573521d + 1) == '(') goto L11;
        if (this.f573520c.charAt(this.f573521d + 1) == '[') goto L11;
        goto L4
    }

    public v() {
        this.f492484e = PatternProtector.compile("^\\\\\\(([\\s\\S]*?)\\\\\\)|\\\\\\[([\\s\\S]*?)\\\\\\]");
    }
}
