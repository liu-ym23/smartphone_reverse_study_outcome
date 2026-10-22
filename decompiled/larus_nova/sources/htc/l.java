package htc;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class l {
    public static gtc.c a(gtc.g r110) {
        gtc.g.a r100 = null;
        gtc.c r111 = gtc.e.b(gtc.e.h(r110, "clike"), "swift", new gtc.g.f[]{gtc.g.i("string", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("(\"|')(\\\\(?:\\((?:[^()]|\\([^)]+\\))+\\)|\\r\\n|[\\s\\S])|(?!\\1)[^\\\\\\r\\n])*\\1"), false, true, null, gtc.g.a("inside", new gtc.g.f[]{gtc.g.i("interpolation", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("\\\\\\((?:[^()]|\\([^)]+\\))+\\)"), false, false, null, gtc.g.a("inside", new gtc.g.f[]{gtc.g.i("delimiter", new gtc.g.c[]{gtc.g.f(PatternProtector.compile("^\\\\\\(|\\)$"), false, false, "variable")})}))})}))}), gtc.g.i("keyword", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b(?:as|associativity|break|case|catch|class|continue|convenience|default|defer|deinit|didSet|do|dynamic(?:Type)?|else|enum|extension|fallthrough|final|for|func|get|guard|if|import|in|infix|init|inout|internal|is|lazy|left|let|mutating|new|none|nonmutating|operator|optional|override|postfix|precedence|prefix|private|protocol|public|repeat|required|rethrows|return|right|safe|self|Self|set|static|struct|subscript|super|switch|throws?|try|Type|typealias|unowned|unsafe|var|weak|where|while|willSet|__(?:COLUMN__|FILE__|FUNCTION__|LINE__))\\b"))}), gtc.g.i("number", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b(?:[\\d_]+(?:\\.[\\de_]+)?|0x[a-f0-9_]+(?:\\.[a-f0-9p_]+)?|0b[01_]+|0o[0-7_]+)\\b", 2))})});
        List<gtc.g.f> r101 = r111.f482715b;
        r101.add(gtc.g.i("constant", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b(?:nil|[A-Z_]{2,}|k[A-Z][A-Za-z_]+)\\b"))}));
        r101.add(gtc.g.i("atrule", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("@\\b(?:IB(?:Outlet|Designable|Action|Inspectable)|class_protocol|exported|noreturn|NS(?:Copying|Managed)|objc|UIApplicationMain|auto_closure)\\b"))}));
        r101.add(gtc.g.i("builtin", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b(?:[A-Z]\\S+|abs|advance|alignof(?:Value)?|assert|contains|count(?:Elements)?|debugPrint(?:ln)?|distance|drop(?:First|Last)|dump|enumerate|equal|filter|find|first|getVaList|indices|isEmpty|join|last|lexicographicalCompare|map|max(?:Element)?|min(?:Element)?|numericCast|overlaps|partition|print(?:ln)?|reduce|reflect|reverse|sizeof(?:Value)?|sort(?:ed)?|split|startsWith|stride(?:of(?:Value)?)?|suffix|swap|toDebugString|toString|transcode|underestimateCount|unsafeBitCast|with(?:ExtendedLifetime|Unsafe(?:MutablePointers?|Pointers?)|VaList))\\b"))}));
        gtc.g.f r102 = gtc.e.d(r111, "string/interpolation");
        if (r102 == null) goto L5;
        r100 = gtc.e.c(r102);
    L5:
        if (r100 == null) goto L7;
        r100.a().addAll(r111.f482715b);
    L7:
        return r111;
    }
}
