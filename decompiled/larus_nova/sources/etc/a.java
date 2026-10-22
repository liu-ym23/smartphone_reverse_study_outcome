package etc;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ec.model.response.ECFloatWindowInfo;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.facebook.keyframes.model.KFAnimation;
import com.miui.easygo.constant.EasyGoConstant;
import gtc.k;
import htc.h;
import htc.j;
import htc.l;
import htc.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public final class a implements gtc.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C5819a f473958b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, gtc.g.a> f473959a;

    /* JADX INFO: renamed from: etc.a$a, reason: collision with other inner class name */
    public static class C5819a implements gtc.g.a {
        public C5819a() {
        }

        @Override // gtc.g.a
        public final List<gtc.g.f> a() {
            return null;
        }

        @Override // gtc.g.a
        public final String name() {
            return null;
        }
    }

    static {
        f473958b = new C5819a();
    }

    public a() {
        this.f473959a = new HashMap(3);
    }

    public static gtc.c b(gtc.g r210, String r211) {
        switch(r211.hashCode()) {
            case -1351281305: goto L102;
            case -1237466098: goto L98;
            case -1125574399: goto L94;
            case -1125180051: goto L90;
            case -1081305560: goto L86;
            case -973197092: goto L82;
            case -920649363: goto L78;
            case 99: goto L74;
            case 3304: goto L70;
            case 98723: goto L66;
            case 98819: goto L62;
            case 102354: goto L58;
            case 114126: goto L54;
            case 3075967: goto L50;
            case 3254818: goto L46;
            case 3271912: goto L42;
            case 3701415: goto L38;
            case 41047146: goto L34;
            case 94750330: goto L30;
            case 102744722: goto L26;
            case 109250886: goto L22;
            case 109854227: goto L18;
            case 188995949: goto L14;
            case 246938863: goto L10;
            case 866284260: goto L6;
            default: goto L105;
        };
    L105:
        byte r100 = -1;
    L107:
        switch(r100) {
            case 0: goto L160;
            case 1: goto L159;
            case 2: goto L187;
            case 3: goto L151;
            case 4: goto L186;
            case 5: goto L185;
            case 6: goto L184;
            case 7: goto L146;
            case 8: goto L145;
            case 9: goto L144;
            case 10: goto L126;
            case 11: goto L180;
            case 12: goto L179;
            case 13: goto L123;
            case 14: goto L122;
            case 15: goto L177;
            case 16: goto L176;
            case 17: goto L175;
            case 18: goto L174;
            case 19: goto L117;
            case 20: goto L172;
            case 21: goto L171;
            case 22: goto L111;
            case 23: goto L169;
            case 24: goto L168;
            default: goto L162;
        };
    L111:
        gtc.c r101 = gtc.e.b(gtc.e.h(r210, "clike"), "javascript", new gtc.g.f[]{gtc.g.i("keyword", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b(?:as|async|await|break|case|catch|class|const|continue|debugger|default|delete|do|else|enum|export|extends|finally|for|from|function|get|if|implements|import|in|instanceof|interface|let|new|null|of|package|private|protected|public|return|set|static|super|switch|this|throw|try|typeof|var|void|while|with|yield)\\b"))}), gtc.g.i("number", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b(?:0[xX][\\dA-Fa-f]+|0[bB][01]+|0[oO][0-7]+|NaN|Infinity)\\b|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:[Ee][+-]?\\d+)?"))}), gtc.g.i("function", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("[_$a-z\\xA0-\\uFFFF][$\\w\\xA0-\\uFFFF]*(?=\\s*\\()", 2))}), gtc.g.i(OnekeyLoginConstants.CU_KEY_OPERATOR, new gtc.g.c[]{gtc.g.d(PatternProtector.compile("-[-=]?|\\+[+=]?|!=?=?|<<?=?|>>?>?=?|=(?:==?|>)?|&[&=]?|\\|[|=]?|\\*\\*?=?|\\/=?|~|\\^=?|%=?|\\?|\\.{3}"))})});
        gtc.e.f(r101, "keyword", new gtc.g.f[]{gtc.g.i("regex", new gtc.g.c[]{gtc.g.e(PatternProtector.compile("((?:^|[^$\\w\\xA0-\\uFFFF.\"'\\])\\s])\\s*)\\/(\\[[^\\]\\r\\n]+]|\\\\.|[^/\\\\\\[\\r\\n])+\\/[gimyu]{0,5}(?=\\s*($|[\\r\\n,.;})\\]]))"), true)}), gtc.g.i("function-variable", new gtc.g.c[]{gtc.g.f(PatternProtector.compile("[_$a-z\\xA0-\\uFFFF][$\\w\\xA0-\\uFFFF]*(?=\\s*=\\s*(?:function\\b|(?:\\([^()]*\\)|[_$a-z\\xA0-\\uFFFF][$\\w\\xA0-\\uFFFF]*)\\s*=>))", 2), false, false, "function")}), gtc.g.i("constant", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b[A-Z][A-Z\\d_]*\\b"))})});
        k r102 = gtc.g.i("interpolation", new gtc.g.c[0]);
        gtc.e.f(r101, "string", new gtc.g.f[]{gtc.g.i("template-string", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("`(?:\\\\[\\s\\S]|\\$\\{[^}]+\\}|[^\\\\`])*`"), false, true, null, gtc.g.a("inside", new gtc.g.f[]{r102, gtc.g.i("string", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("[\\s\\S]+"))})}))})});
        ArrayList r103 = new ArrayList(r101.f482715b.size() + 1);
        r103.add(gtc.g.i("interpolation-punctuation", new gtc.g.c[]{gtc.g.f(PatternProtector.compile("^\\$\\{|\\}$"), false, false, "punctuation")}));
        r103.addAll(r101.f482715b);
        r102.f482731b.add(gtc.g.g(PatternProtector.compile("\\$\\{[^}]+\\}"), false, false, null, new gtc.c("inside", r103)));
        gtc.g.a r104 = r210.b("markup");
        if (r104 == null) goto L170;
        gtc.e.f(r104, "tag", new gtc.g.f[]{gtc.g.i("script", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("(<script[\\s\\S]*?>)[\\s\\S]*?(?=<\\/script>)", 2), true, true, "language-javascript", r101)})});
    L170:
        return r101;
    L117:
        Pattern r105 = PatternProtector.compile("\\\\(?:[^a-z()\\[\\]]|[a-z*]+)", 2);
        gtc.c r106 = gtc.g.a("inside", new gtc.g.f[]{gtc.g.i("equation-command", new gtc.g.c[]{gtc.g.f(r105, false, false, "regex")})});
        return gtc.g.a("latex", new gtc.g.f[]{gtc.g.i("comment", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("%.*", 8))}), gtc.g.i("cdata", new gtc.g.c[]{gtc.g.h(PatternProtector.compile("(\\\\begin\\{((?:verbatim|lstlisting)\\*?)\\})[\\s\\S]*?(?=\\\\end\\{\\2\\})"))}), gtc.g.i("equation", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("\\$(?:\\\\[\\s\\S]|[^\\\\$])*\\$|\\\\\\([\\s\\S]*?\\\\\\)|\\\\\\[[\\s\\S]*?\\\\\\]"), false, false, "string", r106), gtc.g.g(PatternProtector.compile("(\\\\begin\\{((?:equation|math|eqnarray|align|multline|gather)\\*?)\\})[\\s\\S]*?(?=\\\\end\\{\\2\\})"), true, false, "string", r106)}), gtc.g.i("keyword", new gtc.g.c[]{gtc.g.h(PatternProtector.compile("(\\\\(?:begin|end|ref|cite|label|usepackage|documentclass)(?:\\[[^\\]]+\\])?\\{)[^}]+(?=\\})"))}), gtc.g.i("url", new gtc.g.c[]{gtc.g.h(PatternProtector.compile("(\\\\url\\{)[^}]+(?=\\})"))}), gtc.g.i("headline", new gtc.g.c[]{gtc.g.f(PatternProtector.compile("(\\\\(?:part|chapter|section|subsection|frametitle|subsubsection|paragraph|subparagraph|subsubparagraph|subsubsubparagraph)\\*?(?:\\[[^\\]]+\\])?\\{)[^}]+(?=\\}(?:\\[[^\\]]+\\])?)"), true, false, "class-name")}), gtc.g.i("function", new gtc.g.c[]{gtc.g.f(r105, false, false, "selector")}), gtc.g.i("punctuation", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("[\\[\\]{}&]"))})});
    L122:
        k r107 = gtc.g.i("keyword", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b(?:abstract|continue|for|new|switch|assert|default|goto|package|synchronized|boolean|do|if|private|this|break|double|implements|protected|throw|byte|else|import|public|throws|case|enum|instanceof|return|transient|catch|extends|int|short|try|char|final|interface|static|void|class|finally|long|strictfp|volatile|const|float|native|super|while)\\b"))});
        gtc.c r108 = gtc.e.b(gtc.e.h(r210, "clike"), "java", new gtc.g.f[]{r107, gtc.g.i("number", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b0b[01]+\\b|\\b0x[\\da-f]*\\.?[\\da-fp-]+\\b|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:e[+-]?\\d+)?[df]?", 2))}), gtc.g.i(OnekeyLoginConstants.CU_KEY_OPERATOR, new gtc.g.c[]{gtc.g.h(PatternProtector.compile("(^|[^.])(?:\\+[+=]?|-[-=]?|!=?|<<?=?|>>?>?=?|==?|&[&=]?|\\|[|=]?|\\*=?|\\/=?|%=?|\\^=?|[?:~])", 8))})});
        gtc.e.f(r108, "function", new gtc.g.f[]{gtc.g.i("annotation", new gtc.g.c[]{gtc.g.f(PatternProtector.compile("(^|[^.])@\\w+"), true, false, "punctuation")})});
        gtc.e.f(r108, "class-name", new gtc.g.f[]{gtc.g.i("generics", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("<\\s*\\w+(?:\\.\\w+)?(?:\\s*,\\s*\\w+(?:\\.\\w+)?)*>", 2), false, false, "function", gtc.g.a("inside", new gtc.g.f[]{r107, gtc.g.i("punctuation", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("[<>(),.:]"))})}))})});
    L183:
        return r108;
    L123:
        gtc.c r110 = gtc.e.b(gtc.e.h(r210, "clike"), "dart", new gtc.g.f[]{gtc.g.i("string", new gtc.g.c[]{gtc.g.e(PatternProtector.compile("r?(\"\"\"|''')[\\s\\S]*?\\1"), false), gtc.g.e(PatternProtector.compile("r?(\"|')(?:\\\\.|(?!\\1)[^\\\\\\r\\n])*\\1"), false)}), gtc.g.i("keyword", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b(?:async|sync|yield)\\*")), gtc.g.d(PatternProtector.compile("\\b(?:abstract|assert|async|await|break|case|catch|class|const|continue|default|deferred|do|dynamic|else|enum|export|external|extends|factory|final|finally|for|get|if|implements|import|in|library|new|null|operator|part|rethrow|return|set|static|super|switch|this|throw|try|typedef|var|void|while|with|yield)\\b"))}), gtc.g.i(OnekeyLoginConstants.CU_KEY_OPERATOR, new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\bis!|\\b(?:as|is)\\b|\\+\\+|--|&&|\\|\\||<<=?|>>=?|~(?:\\/=?)?|[+\\-*\\/%&^|=!<>]=?|\\?"))})});
        gtc.e.f(r110, "function", new gtc.g.f[]{gtc.g.i("metadata", new gtc.g.c[]{gtc.g.f(PatternProtector.compile("@\\w+"), false, false, "symbol")})});
        return r110;
    L126:
        gtc.c r109 = gtc.g.a(GXTemplateKey.GAIAX_CSS, new gtc.g.f[]{gtc.g.i("comment", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\/\\*[\\s\\S]*?\\*\\/"))}), gtc.g.i("atrule", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("@[\\w-]+?.*?(?:;|(?=\\s*\\{))", 2), false, false, null, gtc.g.a("inside", new gtc.g.f[]{gtc.g.i(com.heytap.mcssdk.constant.b.f276366p, new gtc.g.c[]{gtc.g.d(PatternProtector.compile("@[\\w-]+"))})}))}), gtc.g.i("url", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("url\\((?:([\"'])(?:\\\\(?:\\r\\n|[\\s\\S])|(?!\\1)[^\\\\\\r\\n])*\\1|.*?)\\)", 2))}), gtc.g.i("selector", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("[^{}\\s][^{};]*?(?=\\s*\\{)"))}), gtc.g.i("string", new gtc.g.c[]{gtc.g.e(PatternProtector.compile("(\"|')(?:\\\\(?:\\r\\n|[\\s\\S])|(?!\\1)[^\\\\\\r\\n])*\\1"), false)}), gtc.g.i(KFAnimation.PROPERTY_TYPE_JSON_FIELD, new gtc.g.c[]{gtc.g.d(PatternProtector.compile("[-_a-z\\xA0-\\uFFFF][-\\w\\xA0-\\uFFFF]*(?=\\s*:)", 2))}), gtc.g.i("important", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\B!important\\b", 2))}), gtc.g.i("function", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("[-a-z0-9]+(?=\\()", 2))}), gtc.g.i("punctuation", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("[(){};:]"))})});
        gtc.g.a r111 = gtc.e.c((gtc.g.f) ListProtector.get(r109.f482715b, 1));
        if (r111 == null) goto L134;
        Iterator<gtc.g.f> r112 = r109.f482715b.iterator();
    L130:
        if (r112.hasNext() == false) goto L134;
        gtc.g.f r113 = r112.next();
        if ("atrule".equals(r113.name()) == true) goto L130;
        r111.a().add(r113);
    L134:
        gtc.g.a r114 = r210.b("markup");
        if (r114 == null) goto L181;
        gtc.e.f(r114, "tag", new gtc.g.f[]{gtc.g.i("style", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("(<style[\\s\\S]*?>)[\\s\\S]*?(?=<\\/style>)", 2), true, true, "language-css", r109)})});
        gtc.g.f r115 = gtc.e.d(r114, "tag");
        if (r115 == null) goto L141;
        gtc.g.a r116 = gtc.e.c(r115);
        if (r116 == null) goto L142;
        r116 = gtc.b.a.a(new gtc.b.a.C6066a(), r116);
    L142:
        gtc.e.f(r114, "tag/attr-value", new gtc.g.f[]{gtc.g.i("style-attr", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("\\s*style=(\"|')(?:\\\\[\\s\\S]|(?!\\1)[^\\\\])*\\1", 2), false, false, "language-css", gtc.g.a("inside", new gtc.g.f[]{gtc.g.i("attr-name", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("^\\s*style", 2), false, false, null, r116)}), gtc.g.i("punctuation", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("^\\s*=\\s*['\"]|['\"]\\s*$"))}), gtc.g.i("attr-value", new gtc.g.c[]{gtc.g.g(PatternProtector.compile(".+", 2), false, false, null, r109)})}))})});
        goto L181
    L141:
        r116 = null;
    L181:
        return r109;
    L144:
        r108 = gtc.e.b(gtc.e.h(r210, "c"), "cpp", new gtc.g.f[]{gtc.g.i("keyword", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b(?:alignas|alignof|asm|auto|bool|break|case|catch|char|char16_t|char32_t|class|compl|const|constexpr|const_cast|continue|decltype|default|delete|do|double|dynamic_cast|else|enum|explicit|export|extern|float|for|friend|goto|if|inline|int|int8_t|int16_t|int32_t|int64_t|uint8_t|uint16_t|uint32_t|uint64_t|long|mutable|namespace|new|noexcept|nullptr|operator|private|protected|public|register|reinterpret_cast|return|short|signed|sizeof|static|static_assert|static_cast|struct|switch|template|this|thread_local|throw|try|typedef|typeid|typename|union|unsigned|using|virtual|void|volatile|wchar_t|while)\\b"))}), gtc.g.i(OnekeyLoginConstants.CU_KEY_OPERATOR, new gtc.g.c[]{gtc.g.d(PatternProtector.compile("--?|\\+\\+?|!=?|<{1,2}=?|>{1,2}=?|->|:{1,2}|={1,2}|\\^|~|%|&{1,2}|\\|\\|?|\\?|\\*|\\/|\\b(?:and|and_eq|bitand|bitor|not|not_eq|or|or_eq|xor|xor_eq)\\b"))})});
        gtc.e.f(r108, "function", new gtc.g.f[]{gtc.g.i("boolean", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b(?:true|false)\\b"))})});
        gtc.e.f(r108, "keyword", new gtc.g.f[]{gtc.g.i("class-name", new gtc.g.c[]{gtc.g.h(PatternProtector.compile("(class\\s+)\\w+", 2))})});
        gtc.e.f(r108, "string", new gtc.g.f[]{gtc.g.i("raw-string", new gtc.g.c[]{gtc.g.f(PatternProtector.compile("R\"([^()\\\\ ]{0,16})\\([\\s\\S]*?\\)\\1\""), false, true, "string")})});
        goto L183
    L145:
        gtc.c r117 = gtc.e.a(gtc.e.h(r210, "clike"), "go", new htc.b(), new gtc.g.f[]{gtc.g.i("keyword", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b(?:break|case|chan|const|continue|default|defer|else|fallthrough|for|func|go(?:to)?|if|import|interface|map|package|range|return|select|struct|switch|type|var)\\b"))}), gtc.g.i("boolean", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b(?:_|iota|nil|true|false)\\b"))}), gtc.g.i(OnekeyLoginConstants.CU_KEY_OPERATOR, new gtc.g.c[]{gtc.g.d(PatternProtector.compile("[*\\/%^!=]=?|\\+[=+]?|-[=-]?|\\|[=|]?|&(?:=|&|\\^=?)?|>(?:>=?|=)?|<(?:<=?|=|-)?|:=|\\.\\.\\."))}), gtc.g.i("number", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("(?:\\b0x[a-f\\d]+|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:e[-+]?\\d+)?)i?", 2))}), gtc.g.i("string", new gtc.g.c[]{gtc.g.e(PatternProtector.compile("([\"'`])(\\\\[\\s\\S]|(?!\\1)[^\\\\])*\\1"), false)})});
        gtc.e.f(r117, "boolean", new gtc.g.f[]{gtc.g.i("builtin", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b(?:bool|byte|complex(?:64|128)|error|float(?:32|64)|rune|string|u?int(?:8|16|32|64)?|uintptr|append|cap|close|complex|copy|delete|imag|len|make|new|panic|print(?:ln)?|real|recover)\\b"))})});
        return r117;
    L146:
        r108 = gtc.e.a(gtc.e.h(r210, "clike"), "c", new htc.a(), new gtc.g.f[]{gtc.g.i("keyword", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b(?:_Alignas|_Alignof|_Atomic|_Bool|_Complex|_Generic|_Imaginary|_Noreturn|_Static_assert|_Thread_local|asm|typeof|inline|auto|break|case|char|const|continue|default|do|double|else|enum|extern|float|for|goto|if|int|long|register|return|short|signed|sizeof|static|struct|switch|typedef|union|unsigned|void|volatile|while)\\b"))}), gtc.g.i(OnekeyLoginConstants.CU_KEY_OPERATOR, new gtc.g.c[]{gtc.g.d(PatternProtector.compile("-[>-]?|\\+\\+?|!=?|<<?=?|>>?=?|==?|&&?|\\|\\|?|[~^%?*\\/]"))}), gtc.g.i("number", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("(?:\\b0x[\\da-f]+|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:e[+-]?\\d+)?)[ful]*", 2))})});
        gtc.e.f(r108, "string", new gtc.g.f[]{gtc.g.i("macro", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("(^\\s*)#\\s*[a-z]+(?:[^\\r\\n\\\\]|\\\\(?:\\r\\n|[\\s\\S]))*", 10), true, false, KFAnimation.PROPERTY_TYPE_JSON_FIELD, gtc.g.a("inside", new gtc.g.f[]{gtc.g.i("string", new gtc.g.c[]{gtc.g.h(PatternProtector.compile("(#\\s*include\\s*)(?:<.+?>|(\"|')(?:\\\\?.)+?\\2)"))}), gtc.g.i("directive", new gtc.g.c[]{gtc.g.f(PatternProtector.compile("(#\\s*)\\b(?:define|defined|elif|else|endif|error|ifdef|ifndef|if|import|include|line|pragma|undef|using)\\b"), true, false, "keyword")})}))}), gtc.g.i("constant", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b(?:__FILE__|__LINE__|__DATE__|__TIME__|__TIMESTAMP__|__func__|EOF|NULL|SEEK_CUR|SEEK_END|SEEK_SET|stdin|stdout|stderr)\\b"))})});
        goto L183
    L151:
        gtc.g.a r118 = r210.b(GXTemplateKey.GAIAX_CSS);
        if (r118 == null) goto L162;
        gtc.g.f r119 = gtc.e.d(r118, "selector");
        if (r119 == null) goto L156;
        gtc.f r120 = gtc.g.g(PatternProtector.compile("[^{}\\s][^{}]*(?=\\s*\\{)"), false, false, null, gtc.g.a("inside", new gtc.g.f[]{gtc.g.i("pseudo-element", new gtc.g.c[]{gtc.g.d(PatternProtector.compile(":(?:after|before|first-letter|first-line|selection)|::[-\\w]+"))}), gtc.g.i("pseudo-class", new gtc.g.c[]{gtc.g.d(PatternProtector.compile(":[-\\w]+(?:\\(.*\\))?"))}), gtc.g.i("class", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\.[-:.\\w]+"))}), gtc.g.i("id", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("#[-:.\\w]+"))}), gtc.g.i(ECFloatWindowInfo.INFO_TYPE_ATTRIBUTE, new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\[[^\\]]+\\]"))})}));
        r119.a().clear();
        r119.a().add(r120);
    L156:
        gtc.e.f(r118, "function", new gtc.g.f[]{gtc.g.i("hexcode", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("#[\\da-f]{3,8}", 2))}), gtc.g.i("entity", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\\\[\\da-f]{1,8}", 2))}), gtc.g.i("number", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("[\\d%.]+"))})});
        goto L162
    L159:
        r108 = gtc.e.b(gtc.e.h(r210, "clike"), "groovy", new gtc.g.f[]{gtc.g.i("keyword", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b(?:as|def|in|abstract|assert|boolean|break|byte|case|catch|char|class|const|continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|implements|import|instanceof|int|interface|long|native|new|package|private|protected|public|return|short|static|strictfp|super|switch|synchronized|this|throw|throws|trait|transient|try|void|volatile|while)\\b"))}), gtc.g.i("string", new gtc.g.c[]{gtc.g.e(PatternProtector.compile("(\"\"\"|''')[\\s\\S]*?\\1|(?:\\$\\/)(?:\\$\\/\\$|[\\s\\S])*?\\/\\$"), false), gtc.g.e(PatternProtector.compile("([\"'\\/])(?:\\\\.|(?!\\1)[^\\\\\\r\\n])*\\1"), false)}), gtc.g.i("number", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b(?:0b[01_]+|0x[\\da-f_]+(?:\\.[\\da-f_p\\-]+)?|[\\d_]+(?:\\.[\\d_]+)?(?:e[+-]?[\\d]+)?)[glidf]?\\b", 2))}), gtc.g.i(OnekeyLoginConstants.CU_KEY_OPERATOR, new gtc.g.c[]{gtc.g.h(PatternProtector.compile("(^|[^.])(?:~|==?~?|\\?[.:]?|\\*(?:[.=]|\\*=?)?|\\.[@&]|\\.\\.<|\\.{1,2}(?!\\.)|-[-=>]?|\\+[+=]?|!=?|<(?:<=?|=>?)?|>(?:>>?=?|=)?|&[&=]?|\\|[|=]?|\\/=?|\\^=?|%=?)"))}), gtc.g.i("punctuation", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\.+|[{}\\[\\];(),:$]"))})});
        gtc.e.f(r108, "string", new gtc.g.f[]{gtc.g.i("shebang", new gtc.g.c[]{gtc.g.f(PatternProtector.compile("#!.+"), false, false, "comment")})});
        gtc.e.f(r108, "punctuation", new gtc.g.f[]{gtc.g.i("spock-block", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b(?:setup|given|when|then|and|cleanup|expect|where):"))})});
        gtc.e.f(r108, "function", new gtc.g.f[]{gtc.g.i("annotation", new gtc.g.c[]{gtc.g.f(PatternProtector.compile("(^|[^.])@\\w+"), true, false, "punctuation")})});
        goto L183
    L160:
        gtc.c r121 = gtc.g.a("inside", new gtc.g.f[]{gtc.g.i("punctuation", new gtc.g.c[]{gtc.g.d(PatternProtector.compile(EasyGoConstant.VERSION_SEPARATIVE_SIGN))})});
        r108 = gtc.e.b(gtc.e.h(r210, "clike"), "csharp", new gtc.g.f[]{gtc.g.i("keyword", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b(?:abstract|add|alias|as|ascending|async|await|base|bool|break|byte|case|catch|char|checked|class|const|continue|decimal|default|delegate|descending|do|double|dynamic|else|enum|event|explicit|extern|false|finally|fixed|float|for|foreach|from|get|global|goto|group|if|implicit|in|int|interface|internal|into|is|join|let|lock|long|namespace|new|null|object|operator|orderby|out|override|params|partial|private|protected|public|readonly|ref|remove|return|sbyte|sealed|select|set|short|sizeof|stackalloc|static|string|struct|switch|this|throw|true|try|typeof|uint|ulong|unchecked|unsafe|ushort|using|value|var|virtual|void|volatile|where|while|yield)\\b"))}), gtc.g.i("string", new gtc.g.c[]{gtc.g.e(PatternProtector.compile("@(\"|')(?:\\1\\1|\\\\[\\s\\S]|(?!\\1)[^\\\\])*\\1"), false), gtc.g.e(PatternProtector.compile("(\"|')(?:\\\\.|(?!\\1)[^\\\\\\r\\n])*?\\1"), false)}), gtc.g.i("class-name", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("\\b[A-Z]\\w*(?:\\.\\w+)*\\b(?=\\s+\\w+)"), false, false, null, r121), gtc.g.g(PatternProtector.compile("(\\[)[A-Z]\\w*(?:\\.\\w+)*\\b"), true, false, null, r121), gtc.g.g(PatternProtector.compile("(\\b(?:class|interface)\\s+[A-Z]\\w*(?:\\.\\w+)*\\s*:\\s*)[A-Z]\\w*(?:\\.\\w+)*\\b"), true, false, null, r121), gtc.g.g(PatternProtector.compile("((?:\\b(?:class|interface|new)\\s+)|(?:catch\\s+\\())[A-Z]\\w*(?:\\.\\w+)*\\b"), true, false, null, r121)}), gtc.g.i("number", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b0x[\\da-f]+\\b|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)f?", 2))})});
        gtc.e.f(r108, "class-name", new gtc.g.f[]{gtc.g.i("generic-method", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("\\w+\\s*<[^>\\r\\n]+?>\\s*(?=\\()"), false, false, null, gtc.g.a("inside", new gtc.g.f[]{gtc.g.i("function", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("^\\w+"))}), gtc.g.i("class-name", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("\\b[A-Z]\\w*(?:\\.\\w+)*\\b"), false, false, null, r121)}), gtc.e.d(r108, "keyword"), gtc.g.i("punctuation", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("[<>(),.:]"))})}))}), gtc.g.i("preprocessor", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("(^\\s*)#.*", 8), true, false, KFAnimation.PROPERTY_TYPE_JSON_FIELD, gtc.g.a("inside", new gtc.g.f[]{gtc.g.i("directive", new gtc.g.c[]{gtc.g.f(PatternProtector.compile("(\\s*#)\\b(?:define|elif|else|endif|endregion|error|if|line|pragma|region|undef|warning)\\b"), true, false, "keyword")})}))})});
        goto L183
    L168:
        return gtc.g.a("clojure", new gtc.g.f[]{gtc.g.i("comment", new gtc.g.c[]{gtc.g.d(PatternProtector.compile(";+.*"))}), gtc.g.i("string", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\"(?:\\\\.|[^\\\\\"\\r\\n])*\""))}), gtc.g.i(OnekeyLoginConstants.CU_KEY_OPERATOR, new gtc.g.c[]{gtc.g.d(PatternProtector.compile("(?:::|[:|'])\\b[a-z][\\w*+!?-]*\\b", 2))}), gtc.g.i("keyword", new gtc.g.c[]{gtc.g.h(PatternProtector.compile("([^\\w+*'?-])(?:def|if|do|let|\\.\\.|quote|var|->>|->|fn|loop|recur|throw|try|monitor-enter|\\.|new|set!|def\\-|defn|defn\\-|defmacro|defmulti|defmethod|defstruct|defonce|declare|definline|definterface|defprotocol|==|defrecord|>=|deftype|<=|defproject|ns|\\*|\\+|\\-|\\/|<|=|>|accessor|agent|agent-errors|aget|alength|all-ns|alter|and|append-child|apply|array-map|aset|aset-boolean|aset-byte|aset-char|aset-double|aset-float|aset-int|aset-long|aset-short|assert|assoc|await|await-for|bean|binding|bit-and|bit-not|bit-or|bit-shift-left|bit-shift-right|bit-xor|boolean|branch\\?|butlast|byte|cast|char|children|class|clear-agent-errors|comment|commute|comp|comparator|complement|concat|conj|cons|constantly|cond|if-not|construct-proxy|contains\\?|count|create-ns|create-struct|cycle|dec|deref|difference|disj|dissoc|distinct|doall|doc|dorun|doseq|dosync|dotimes|doto|double|down|drop|drop-while|edit|end\\?|ensure|eval|every\\?|false\\?|ffirst|file-seq|filter|find|find-doc|find-ns|find-var|first|float|flush|for|fnseq|frest|gensym|get-proxy-class|get|hash-map|hash-set|identical\\?|identity|if-let|import|in-ns|inc|index|insert-child|insert-left|insert-right|inspect-table|inspect-tree|instance\\?|int|interleave|intersection|into|into-array|iterate|join|key|keys|keyword|keyword\\?|last|lazy-cat|lazy-cons|left|lefts|line-seq|list\\*|list|load|load-file|locking|long|loop|macroexpand|macroexpand-1|make-array|make-node|map|map-invert|map\\?|mapcat|max|max-key|memfn|merge|merge-with|meta|min|min-key|name|namespace|neg\\?|new|newline|next|nil\\?|node|not|not-any\\?|not-every\\?|not=|ns-imports|ns-interns|ns-map|ns-name|ns-publics|ns-refers|ns-resolve|ns-unmap|nth|nthrest|or|parse|partial|path|peek|pop|pos\\?|pr|pr-str|print|print-str|println|println-str|prn|prn-str|project|proxy|proxy-mappings|quot|rand|rand-int|range|re-find|re-groups|re-matcher|re-matches|re-pattern|re-seq|read|read-line|reduce|ref|ref-set|refer|rem|remove|remove-method|remove-ns|rename|rename-keys|repeat|replace|replicate|resolve|rest|resultset-seq|reverse|rfirst|right|rights|root|rrest|rseq|second|select|select-keys|send|send-off|seq|seq-zip|seq\\?|set|short|slurp|some|sort|sort-by|sorted-map|sorted-map-by|sorted-set|special-symbol\\?|split-at|split-with|str|string\\?|struct|struct-map|subs|subvec|symbol|symbol\\?|sync|take|take-nth|take-while|test|time|to-array|to-array-2d|tree-seq|true\\?|union|up|update-proxy|val|vals|var-get|var-set|var\\?|vector|vector-zip|vector\\?|when|when-first|when-let|when-not|with-local-vars|with-meta|with-open|with-out-str|xml-seq|xml-zip|zero\\?|zipmap|zipper)(?=[^\\w+*'?-])"))}), gtc.g.i("boolean", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b(?:true|false|nil)\\b"))}), gtc.g.i("number", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b[0-9A-Fa-f]+\\b"))}), gtc.g.i("punctuation", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("[{}\\[\\](),]"))})});
    L169:
        return htc.f.a(r210);
    L171:
        return l.a(r210);
    L172:
        return j.a(r210);
    L174:
        return gtc.g.a("clike", new gtc.g.f[]{gtc.g.i("comment", new gtc.g.c[]{gtc.g.h(PatternProtector.compile("(^|[^\\\\])\\/\\*[\\s\\S]*?(?:\\*\\/|$)")), gtc.g.e(PatternProtector.compile("(^|[^\\\\:])\\/\\/.*"), true)}), gtc.g.i("string", new gtc.g.c[]{gtc.g.e(PatternProtector.compile("([\"'])(?:\\\\(?:\\r\\n|[\\s\\S])|(?!\\1)[^\\\\\\r\\n])*\\1"), false)}), gtc.g.i("class-name", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("((?:\\b(?:class|interface|extends|implements|trait|instanceof|new)\\s+)|(?:catch\\s+\\())[\\w.\\\\]+"), true, false, null, gtc.g.a("inside", new gtc.g.f[]{gtc.g.i("punctuation", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("[.\\\\]"))})}))}), gtc.g.i("keyword", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b(?:if|else|while|do|for|return|in|instanceof|function|new|try|throw|catch|finally|null|break|continue)\\b"))}), gtc.g.i("boolean", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b(?:true|false)\\b"))}), gtc.g.i("function", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("[a-z0-9_]+(?=\\()", 2))}), gtc.g.i("number", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b0x[\\da-f]+\\b|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:e[+-]?\\d+)?", 2))}), gtc.g.i(OnekeyLoginConstants.CU_KEY_OPERATOR, new gtc.g.c[]{gtc.g.d(PatternProtector.compile("--?|\\+\\+?|!=?=?|<=?|>=?|==?=?|&&?|\\|\\|?|\\?|\\*|\\/|~|\\^|%"))}), gtc.g.i("punctuation", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("[{}\\[\\];(),.:]"))})});
    L175:
        return htc.e.a();
    L176:
        return m.a();
    L177:
        return gtc.g.a("json", new gtc.g.f[]{gtc.g.i(KFAnimation.PROPERTY_TYPE_JSON_FIELD, new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\"(?:\\\\.|[^\\\\\"\\r\\n])*\"(?=\\s*:)", 2))}), gtc.g.i("string", new gtc.g.c[]{gtc.g.e(PatternProtector.compile("\"(?:\\\\.|[^\\\\\"\\r\\n])*\"(?!\\s*:)"), false)}), gtc.g.i("number", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b0x[\\dA-Fa-f]+\\b|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:[Ee][+-]?\\d+)?"))}), gtc.g.i("punctuation", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("[{}\\[\\]);,]"))}), gtc.g.i(OnekeyLoginConstants.CU_KEY_OPERATOR, new gtc.g.c[]{gtc.g.d(PatternProtector.compile(":"))}), gtc.g.i("boolean", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\b(?:true|false)\\b", 2))}), gtc.g.i("null", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\bnull\\b", 2))})});
    L179:
        return htc.k.a();
    L180:
        return gtc.g.a("git", new gtc.g.f[]{gtc.g.i("comment", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("^#.*", 8))}), gtc.g.i("deleted", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("^[-–].*", 8))}), gtc.g.i("inserted", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("^\\+.*", 8))}), gtc.g.i("string", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("(\"|')(?:\\\\.|(?!\\1)[^\\\\\\r\\n])*\\1", 8))}), gtc.g.i("command", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("^.*\\$ git .*$", 8), false, false, null, gtc.g.a("inside", new gtc.g.f[]{gtc.g.i("parameter", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\s--?\\w+", 8))})}))}), gtc.g.i("coord", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("^@@.*@@$", 8))}), gtc.g.i("commit_sha1", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("^commit \\w{40}$", 8))})});
    L184:
        return gtc.g.a("brainfuck", new gtc.g.f[]{gtc.g.i("pointer", new gtc.g.c[]{gtc.g.f(PatternProtector.compile("<|>"), false, false, "keyword")}), gtc.g.i("increment", new gtc.g.c[]{gtc.g.f(PatternProtector.compile("\\+"), false, false, "inserted")}), gtc.g.i("decrement", new gtc.g.c[]{gtc.g.f(PatternProtector.compile("-"), false, false, "deleted")}), gtc.g.i("branching", new gtc.g.c[]{gtc.g.f(PatternProtector.compile("\\[|\\]"), false, false, "important")}), gtc.g.i(OnekeyLoginConstants.CU_KEY_OPERATOR, new gtc.g.c[]{gtc.g.d(PatternProtector.compile("[.,]"))}), gtc.g.i("comment", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\S+"))})});
    L185:
        return h.a();
    L186:
        return htc.g.a();
    L187:
        return htc.d.a(r210);
    L162:
        return null;
    L6:
        if (r211.equals("clojure") == false) goto L105;
        r100 = 24;
        goto L107
    L10:
        if (r211.equals("markdown") == false) goto L105;
        r100 = 23;
        goto L107
    L14:
        if (r211.equals("javascript") == false) goto L105;
        r100 = 22;
        goto L107
    L18:
        if (r211.equals("swift") == false) goto L105;
        r100 = 21;
        goto L107
    L22:
        if (r211.equals("scala") == false) goto L105;
        r100 = 20;
        goto L107
    L26:
        if (r211.equals("latex") == false) goto L105;
        r100 = 19;
        goto L107
    L30:
        if (r211.equals("clike") == false) goto L105;
        r100 = 18;
        goto L107
    L34:
        if (r211.equals("makefile") == false) goto L105;
        r100 = 17;
        goto L107
    L38:
        if (r211.equals("yaml") == false) goto L105;
        r100 = 16;
        goto L107
    L42:
        if (r211.equals("json") == false) goto L105;
        r100 = 15;
        goto L107
    L46:
        if (r211.equals("java") == false) goto L105;
        r100 = 14;
        goto L107
    L50:
        if (r211.equals("dart") == false) goto L105;
        r100 = HTTP.CR;
        goto L107
    L54:
        if (r211.equals("sql") == false) goto L105;
        r100 = 12;
        goto L107
    L58:
        if (r211.equals("git") == false) goto L105;
        r100 = 11;
        goto L107
    L62:
        if (r211.equals(GXTemplateKey.GAIAX_CSS) == false) goto L105;
        r100 = 10;
        goto L107
    L66:
        if (r211.equals("cpp") == false) goto L105;
        r100 = 9;
        goto L107
    L70:
        if (r211.equals("go") == false) goto L105;
        r100 = 8;
        goto L107
    L74:
        if (r211.equals("c") == false) goto L105;
        r100 = 7;
        goto L107
    L78:
        if (r211.equals("brainfuck") == false) goto L105;
        r100 = 6;
        goto L107
    L82:
        if (r211.equals("python") == false) goto L105;
        r100 = 5;
        goto L107
    L86:
        if (r211.equals("markup") == false) goto L105;
        r100 = 4;
        goto L107
    L90:
        if (r211.equals("css-extras") == false) goto L105;
        r100 = 3;
        goto L107
    L94:
        if (r211.equals("kotlin") == false) goto L105;
        r100 = 2;
        goto L107
    L98:
        if (r211.equals("groovy") == false) goto L105;
        r100 = 1;
        goto L107
    L102:
        if (r211.equals("csharp") == false) goto L105;
        r100 = 0;
        goto L107
    }

    @Override // gtc.d
    public final gtc.g.a a(gtc.g r100, String r101) {
        r101.getClass();
        switch(r101.hashCode()) {
            case -1325976652: goto L30;
            case -1081249113: goto L26;
            case 3401: goto L22;
            case 114276: goto L18;
            case 118807: goto L14;
            case 3213227: goto L10;
            case 101429384: goto L6;
            default: goto L33;
        };
    L33:
        byte r102 = -1;
    L35:
        switch(r102) {
            case 0: goto L40;
            case 1: goto L39;
            case 2: goto L38;
            case 3: goto L39;
            case 4: goto L39;
            case 5: goto L39;
            case 6: goto L37;
            default: goto L41;
        };
    L37:
        r101 = "json";
        goto L41
    L38:
        r101 = "javascript";
        goto L41
    L39:
        r101 = "markup";
        goto L41
    L40:
        r101 = "csharp";
    L41:
        gtc.g.a r103 = (gtc.g.a) ((HashMap) this.f473959a).get(r101);
        C5819a r104 = f473958b;
        if (r103 == null) goto L46;
        if (r104 != r103) goto L57;
        return null;
    L57:
        return r103;
    L46:
        gtc.c r105 = b(r100, r101);
        if (r105 != null) goto L49;
        ((HashMap) this.f473959a).put(r101, r104);
    L56:
        return r105;
    L49:
        ((HashMap) this.f473959a).put(r101, r105);
        if (r101.equals("markup") == false) goto L52;
        r100.b(GXTemplateKey.GAIAX_CSS);
        r100.b("javascript");
        goto L56
    L52:
        if (r101.equals(GXTemplateKey.GAIAX_CSS) == false) goto L56;
        r100.b("css-extras");
        goto L56
    L6:
        if (r101.equals("jsonp") == false) goto L33;
        r102 = 6;
        goto L35
    L10:
        if (r101.equals("html") == false) goto L33;
        r102 = 5;
        goto L35
    L14:
        if (r101.equals("xml") == false) goto L33;
        r102 = 4;
        goto L35
    L18:
        if (r101.equals("svg") == false) goto L33;
        r102 = 3;
        goto L35
    L22:
        if (r101.equals(GXTemplateKey.GAIAX_JS) == false) goto L33;
        r102 = 2;
        goto L35
    L26:
        if (r101.equals("mathml") == false) goto L33;
        r102 = 1;
        goto L35
    L30:
        if (r101.equals("dotnet") == false) goto L33;
        r102 = 0;
        goto L35
    }
}
