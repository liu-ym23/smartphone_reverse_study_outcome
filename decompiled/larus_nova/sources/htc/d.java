package htc;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes41.dex */
public final class d {
    public static gtc.c a(gtc.g r110) {
        gtc.c r111 = gtc.e.a(gtc.e.h(r110, "clike"), "kotlin", new c(), new gtc.g.f[]{gtc.g.i("keyword", new gtc.g.c[]{gtc.g.h(PatternProtector.compile("(^|[^.])\\b(?:abstract|actual|annotation|as|break|by|catch|class|companion|const|constructor|continue|crossinline|data|do|dynamic|else|enum|expect|external|final|finally|for|fun|get|if|import|in|infix|init|inline|inner|interface|internal|is|lateinit|noinline|null|object|open|operator|out|override|package|private|protected|public|reified|return|sealed|set|super|suspend|tailrec|this|throw|to|try|typealias|val|var|vararg|when|where|while)\\b"))}), gtc.g.i("function", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\w+(?=\\s*\\()")), gtc.g.h(PatternProtector.compile("(\\.)\\w+(?=\\s*\\{)"))}), gtc.g.i("number", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b(?:0[xX][\\da-fA-F]+(?:_[\\da-fA-F]+)*|0[bB][01]+(?:_[01]+)*|\\d+(?:_\\d+)*(?:\\.\\d+(?:_\\d+)*)?(?:[eE][+-]?\\d+(?:_\\d+)*)?[fFL]?)\\b"))}), gtc.g.i(OnekeyLoginConstants.CU_KEY_OPERATOR, new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\+[+=]?|-[-=>]?|==?=?|!(?:!|==?)?|[\\/*%<>]=?|[?:]:?|\\.\\.|&&|\\|\\||\\b(?:and|inv|or|shl|shr|ushr|xor)\\b"))})});
        gtc.e.f(r111, "string", new gtc.g.f[]{gtc.g.i("raw-string", new gtc.g.c[]{gtc.g.f(PatternProtector.compile("(\"\"\"|''')[\\s\\S]*?\\1"), false, false, "string")})});
        gtc.e.f(r111, "keyword", new gtc.g.f[]{gtc.g.i("annotation", new gtc.g.c[]{gtc.g.f(PatternProtector.compile("\\B@(?:\\w+:)?(?:[A-Z]\\w*|\\[[^\\]]+\\])"), false, false, "builtin")})});
        gtc.e.f(r111, "function", new gtc.g.f[]{gtc.g.i("label", new gtc.g.c[]{gtc.g.f(PatternProtector.compile("\\w+@|@\\w+"), false, false, "symbol")})});
        ArrayList r100 = new ArrayList(r111.f482715b.size() + 1);
        r100.add(gtc.g.i("delimiter", new gtc.g.c[]{gtc.g.f(PatternProtector.compile("^\\$\\{|\\}$"), false, false, "variable")}));
        r100.addAll(r111.f482715b);
        gtc.c r101 = gtc.g.a("inside", new gtc.g.f[]{gtc.g.i("interpolation", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("\\$\\{[^}]+\\}"), false, false, null, new gtc.c("inside", r100)), gtc.g.f(PatternProtector.compile("\\$\\w+"), false, false, "variable")})});
        gtc.g.f r102 = gtc.e.d(r111, "string");
        gtc.g.f r103 = gtc.e.d(r111, "raw-string");
        if (r102 == null) goto L8;
        if (r103 == null) goto L8;
        gtc.g.c r104 = (gtc.g.c) ListProtector.get(r102.a(), 0);
        gtc.g.c r105 = (gtc.g.c) ListProtector.get(r103.a(), 0);
        r102.a().add(gtc.g.g(r104.b(), r104.c(), r104.a(), r104.alias(), r101));
        r103.a().add(gtc.g.g(r105.b(), r105.c(), r105.a(), r105.alias(), r101));
        ListProtector.remove(r102.a(), 0);
        ListProtector.remove(r103.a(), 0);
        return r111;
    L8:
        throw new RuntimeException("Unexpected state, cannot find `string` and/or `raw-string` tokens inside kotlin grammar");
    }
}
