package htc;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;

/* JADX INFO: loaded from: classes41.dex */
public final class e {
    public static gtc.c a() {
        return gtc.g.a("makefile", new gtc.g.f[]{gtc.g.i("comment", new gtc.g.c[]{gtc.g.h(PatternProtector.compile("(^|[^\\\\])#(?:\\\\(?:\\r\\n|[\\s\\S])|[^\\\\\\r\\n])*"))}), gtc.g.i("string", new gtc.g.c[]{gtc.g.e(PatternProtector.compile("([\"'])(?:\\\\(?:\\r\\n|[\\s\\S])|(?!\\1)[^\\\\\\r\\n])*\\1"), false)}), gtc.g.i("builtin", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\.[A-Z][^:#=\\s]+(?=\\s*:(?!=))"))}), gtc.g.i("symbol", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("^[^:=\\r\\n]+(?=\\s*:(?!=))", 8), false, false, null, gtc.g.a("inside", new gtc.g.f[]{gtc.g.i("variable", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\$+(?:[^(){}:#=\\s]+|(?=[({]))"))})}))}), gtc.g.i("variable", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\$+(?:[^(){}:#=\\s]+|\\([@*%<^+?][DF]\\)|(?=[({]))"))}), gtc.g.i("keyword", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("-include\\b|\\b(?:define|else|endef|endif|export|ifn?def|ifn?eq|include|override|private|sinclude|undefine|unexport|vpath)\\b")), gtc.g.h(PatternProtector.compile("(\\()(?:addsuffix|abspath|and|basename|call|dir|error|eval|file|filter(?:-out)?|findstring|firstword|flavor|foreach|guile|if|info|join|lastword|load|notdir|or|origin|patsubst|realpath|shell|sort|strip|subst|suffix|value|warning|wildcard|word(?:s|list)?)(?=[ \\t])"))}), gtc.g.i(OnekeyLoginConstants.CU_KEY_OPERATOR, new gtc.g.c[]{gtc.g.d(PatternProtector.compile("(?:::|[?:+!])?=|[|@]"))}), gtc.g.i("punctuation", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("[:;(){}]"))})});
    }
}
