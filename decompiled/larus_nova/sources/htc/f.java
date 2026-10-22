package htc;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.android.ugc.aweme.discover.model.CommodityText;

/* JADX INFO: loaded from: classes41.dex */
public final class f {
    public static gtc.c a(gtc.g r110) {
        gtc.c r100 = gtc.e.b(gtc.e.h(r110, "markup"), "markdown", new gtc.g.f[0]);
        gtc.k r101 = gtc.g.i(CommodityText.BOLD, new gtc.g.c[]{gtc.g.g(PatternProtector.compile("(^|[^\\\\])(\\*\\*|__)(?:(?:\\r?\\n|\\r)(?!\\r?\\n|\\r)|.)+?\\2"), true, false, null, gtc.g.a("inside", new gtc.g.f[]{gtc.g.i("punctuation", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("^\\*\\*|^__|\\*\\*$|__$"))})}))});
        gtc.k r102 = gtc.g.i("italic", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("(^|[^\\\\])([*_])(?:(?:\\r?\\n|\\r)(?!\\r?\\n|\\r)|.)+?\\2"), true, false, null, gtc.g.a("inside", new gtc.g.f[]{gtc.g.i("punctuation", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("^[*_]|[*_]$"))})}))});
        gtc.k r103 = gtc.g.i("url", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("!?\\[[^\\]]+\\](?:\\([^\\s)]+(?:[\\t ]+\"(?:\\\\.|[^\"\\\\])*\")?\\)| ?\\[[^\\]\\n]*\\])"), false, false, null, gtc.g.a("inside", new gtc.g.f[]{gtc.g.i("variable", new gtc.g.c[]{gtc.g.h(PatternProtector.compile("(!?\\[)[^\\]]+(?=\\]$)"))}), gtc.g.i("string", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\"(?:\\\\.|[^\"\\\\])*\"(?=\\)$)"))})}))});
        gtc.e.f(r100, "prolog", new gtc.g.f[]{gtc.g.i("blockquote", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("^>(?:[\\t ]*>)*", 8))}), gtc.g.i("code", new gtc.g.c[]{gtc.g.f(PatternProtector.compile("^(?: {4}|\\t).+", 8), false, false, "keyword"), gtc.g.f(PatternProtector.compile("``.+?``|`[^`\\n]+`"), false, false, "keyword")}), gtc.g.i("title", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("\\w+.*(?:\\r?\\n|\\r)(?:==+|--+)"), false, false, "important", gtc.g.a("inside", new gtc.g.f[]{gtc.g.i("punctuation", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("==+$|--+$"))})})), gtc.g.g(PatternProtector.compile("(^\\s*)#+.+", 8), true, false, "important", gtc.g.a("inside", new gtc.g.f[]{gtc.g.i("punctuation", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("^#+|#+$"))})}))}), gtc.g.i("hr", new gtc.g.c[]{gtc.g.f(PatternProtector.compile("(^\\s*)([*-])(?:[\\t ]*\\2){2,}(?=\\s*$)", 8), true, false, "punctuation")}), gtc.g.i("list", new gtc.g.c[]{gtc.g.f(PatternProtector.compile("(^\\s*)(?:[*+-]|\\d+\\.)(?=[\\t ].)", 8), true, false, "punctuation")}), gtc.g.i("url-reference", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("!?\\[[^\\]]+\\]:[\\t ]+(?:\\S+|<(?:\\\\.|[^>\\\\])+>)(?:[\\t ]+(?:\"(?:\\\\.|[^\"\\\\])*\"|'(?:\\\\.|[^'\\\\])*'|\\((?:\\\\.|[^)\\\\])*\\)))?"), false, false, "url", gtc.g.a("inside", new gtc.g.f[]{gtc.g.i("variable", new gtc.g.c[]{gtc.g.h(PatternProtector.compile("^(!?\\[)[^\\]]+"))}), gtc.g.i("string", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("(?:\"(?:\\\\.|[^\"\\\\])*\"|'(?:\\\\.|[^'\\\\])*'|\\((?:\\\\.|[^)\\\\])*\\))$"))}), gtc.g.i("punctuation", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("^[\\[\\]!:]|[<>]"))})}))}), r101, r102, r103});
        gtc.g.a r104 = gtc.e.c(r101);
        if (r104 == null) goto L5;
        r104.a().add(r103);
        r104.a().add(r102);
    L5:
        gtc.g.a r105 = gtc.e.c(r102);
        if (r105 == null) goto L8;
        r105.a().add(r103);
        r105.a().add(r101);
    L8:
        return r100;
    }
}
