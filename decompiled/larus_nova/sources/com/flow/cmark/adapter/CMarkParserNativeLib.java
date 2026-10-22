package com.flow.cmark.adapter;

import com.larus.utils.logger.FLogger;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u0086 J\t\u0010\u0005\u001a\u00020\u0004H\u0086 J3\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\nH\u0086 J\u0019\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0006H\u0086 J\u0011\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0006H\u0086 J\u0011\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0006H\u0086 J\t\u0010\u0015\u001a\u00020\u0004H\u0086 ¨\u0006\u0019"}, d2 = {"Lcom/flow/cmark/adapter/CMarkParserNativeLib;", "", "", "stringFromJNI", "", "cmarkGfmCoreExtensionsEnsureRegistered", "", "parserOptions", "", "extensionList", "", "config", "initCMarkParser", "content", "featureOptions", "Lcom/flow/cmark/adapter/CMarkNodeJava;", "parseMarkdown", "nodeType", "", "isBlockNodeType", "isInlineNodeType", "freeCMarkParser", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "cmarkparser_release"}, k = 1, mv = {1, 7, 1})
public final class CMarkParserNativeLib {

    public static final class a {
    }

    public CMarkParserNativeLib() {
    }

    public final native void cmarkGfmCoreExtensionsEnsureRegistered();

    public final native void freeCMarkParser();

    public final native void initCMarkParser(int r100, List<String> r101, Map<String, ? extends Object> r102);

    public final native boolean isBlockNodeType(int r100);

    public final native boolean isInlineNodeType(int r100);

    public final native CMarkNodeJava parseMarkdown(String r100, int r101);

    public final native String stringFromJNI();

    static {
        Intrinsics.checkNotNullParameter("jfmnativelib", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> jfmnativelib");
        com.bytedance.librarian.a.c("jfmnativelib");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> jfmnativelib");
    }
}
