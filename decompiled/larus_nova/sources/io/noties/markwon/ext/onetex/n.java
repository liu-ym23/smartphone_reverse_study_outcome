package io.noties.markwon.ext.onetex;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import io.noties.markwon.onetex.LatexMathNode;
import java.util.regex.Pattern;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes5.dex */
public final class n extends zsc.i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f492449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Pattern f492450f;

    @Override // zsc.i
    public final char d() {
        return Typography.dollar;
    }

    @Override // zsc.i
    public final uvc.b b() {
        int r100 = this.f573521d;
        String r101 = a(this.f492450f);
        if (r101 != null) goto L8;
        com.larus.business.markdown.api.depend.d r102 = IMarkdownLoggerKt.a();
        if (r102 == null) goto L7;
        r102.e("md_parse", "error parse latex: raw: " + this.f573520c + "; context: " + this.f573518a + "; index: " + this.f573521d + "; oldIndex: " + r100);
    L7:
        return null;
    L8:
        LatexMathNode r103 = new LatexMathNode();
        int r104 = 2;
        if (this.f492449e == true) goto L11;
        int r105 = r101.length();
    L17:
        String r106 = r101.substring(r104, r105 - r104);
        com.larus.business.markdown.api.depend.d r107 = IMarkdownLoggerKt.a();
        if (r107 == null) goto L20;
        r107.i("md_parse", "latex: " + r106 + "; index: " + this.f573521d + "; oldIndex: " + r100);
    L20:
        r103.f492653h = r106;
        return r103;
    L11:
        if (StringsKt.startsWith$default(r101, "$$", false, 2, null) == true) goto L13;
    L15:
        r105 = r101.length();
        r104 = 1;
        goto L17
    L13:
        if (StringsKt.endsWith$default(r101, "$$", false, 2, null) == false) goto L15;
        r105 = r101.length();
        goto L17
    }

    public n(boolean r100, String r101) {
        this.f492449e = r100;
        if (r101 == null) goto L7;
        boolean r102 = true;
        if ((!StringsKt.isBlank(r101)) != true) goto L7;
    L8:
        if (r102 == false) goto L10;
        Pattern r103 = PatternProtector.compile(r101);
    L13:
        this.f492450f = r103;
        return;
    L10:
        if (r100 == false) goto L12;
        r103 = PatternProtector.compile("^(\\${1,2})[^\\s\\$](([^\\r\\n\\$]*?)[^\\s\\$])?\\1(?!\\d)");
        goto L13
    L12:
        r103 = PatternProtector.compile("^(\\${2})[^\\s\\$](([^\\r\\n\\$]*?)[^\\s\\$])?\\1(?!\\d)");
    L7:
        r102 = false;
        goto L8
    }
}
