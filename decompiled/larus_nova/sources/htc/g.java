package htc;

import com.bytedance.mt.protector.impl.PatternProtector;

/* JADX INFO: loaded from: classes41.dex */
public abstract class g {
    public static gtc.c a() {
        gtc.k r100 = gtc.g.i("entity", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("&#?[\\da-z]{1,8};", 2))});
        return gtc.g.a("markup", new gtc.g.f[]{gtc.g.i("comment", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("<!--[\\s\\S]*?-->"))}), gtc.g.i("prolog", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("<\\?[\\s\\S]+?\\?>"))}), gtc.g.i("doctype", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("<!DOCTYPE[\\s\\S]+?>", 2))}), gtc.g.i("cdata", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("<!\\[CDATA\\[[\\s\\S]*?]]>", 2))}), gtc.g.i("tag", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("<\\/?(?!\\d)[^\\s>\\/=$<%]+(?:\\s+[^\\s>\\/=]+(?:=(?:(\"|')(?:\\\\[\\s\\S]|(?!\\1)[^\\\\])*\\1|[^\\s'\">=]+))?)*\\s*\\/?>", 2), false, true, null, gtc.g.a("inside", new gtc.g.f[]{gtc.g.i("tag", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("^<\\/?[^\\s>\\/]+", 2), false, false, null, gtc.g.a("inside", new gtc.g.f[]{gtc.g.i("punctuation", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("^<\\/?"))}), gtc.g.i("namespace", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("^[^\\s>\\/:]+:"))})}))}), gtc.g.i("attr-value", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("=(?:(\"|')(?:\\\\[\\s\\S]|(?!\\1)[^\\\\])*\\1|[^\\s'\">=]+)", 2), false, false, null, gtc.g.a("inside", new gtc.g.f[]{gtc.g.i("punctuation", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("^=")), gtc.g.h(PatternProtector.compile("(^|[^\\\\])[\"']"))}), r100}))}), gtc.g.i("punctuation", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("\\/?>"))}), gtc.g.i("attr-name", new gtc.g.c[]{gtc.g.g(PatternProtector.compile("[^\\s>\\/]+"), false, false, null, gtc.g.a("inside", new gtc.g.f[]{gtc.g.i("namespace", new gtc.g.c[]{gtc.g.d(PatternProtector.compile("^[^\\s>\\/:]+:"))})}))})}))}), r100});
    }
}
