package com.larus.business.markdown.api.extplugin.latex;

import android.content.Context;
import iw8.d;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface a {
    void addOnParseErrorListener(b r100);

    Map<Class<? extends uvc.b>, String> getNodeReportMap();

    lsc.a getPlugin(Context r100, mw8.a r101, mw8.b r102, int r103, d r104, iw8.b r105, boolean r106);

    void init(Context r100, mw8.a r101);

    void modifyLatexMathBlockContent(uvc.b r100, String r101);
}
