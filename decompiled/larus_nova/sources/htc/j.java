package htc;

import com.bytedance.mt.protector.impl.PatternProtector;

/* JADX INFO: loaded from: classes41.dex */
public final class j {
    public static gtc.c a(gtc.g r100) {
        gtc.c r101 = gtc.e.a(gtc.e.h(r100, "java"), "scala", new i(), new gtc.g.f[]{gtc.g.i("keyword", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("<-|=>|\\b(?:abstract|case|catch|class|def|do|else|extends|final|finally|for|forSome|if|implicit|import|lazy|match|new|null|object|override|package|private|protected|return|sealed|self|super|this|throw|trait|try|type|val|var|while|with|yield)\\b"))}), gtc.g.i("string", new gtc.g.c[]{gtc.g.e(PatternProtector.compile("\"\"\"[\\s\\S]*?\"\"\""), false), gtc.g.e(PatternProtector.compile("(\"|')(?:\\\\.|(?!\\1)[^\\\\\\r\\n])*\\1"), false)}), gtc.g.i("number", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b0x[\\da-f]*\\.?[\\da-f]+|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:e\\d+)?[dfl]?", 2))})});
        r101.f482715b.add(gtc.g.i("symbol", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("'[^\\d\\s\\\\]\\w*"))}));
        gtc.e.f(r101, "number", new gtc.g.f[]{gtc.g.i("builtin", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b(?:String|Int|Long|Short|Byte|Boolean|Double|Float|Char|Any|AnyRef|AnyVal|Unit|Nothing)\\b"))})});
        return r101;
    }
}
