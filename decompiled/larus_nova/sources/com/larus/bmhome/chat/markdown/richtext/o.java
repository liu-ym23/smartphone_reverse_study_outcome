package com.larus.bmhome.chat.markdown.richtext;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes25.dex */
public final class o {
    public static final boolean a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.f307200d != MessageMarkdownLinkSource.MARKDOWN_LINK) goto L7;
        Regex r101 = n.f307218a;
        if (n.h(r100.f307199c) == false) goto L7;
        return true;
    L7:
        return false;
    }
}
