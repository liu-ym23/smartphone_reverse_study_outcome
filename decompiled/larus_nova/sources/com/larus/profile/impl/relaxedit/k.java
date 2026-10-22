package com.larus.profile.impl.relaxedit;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class k implements com.larus.ivykit.plugin.a {
    public k() {
    }

    @Override // com.larus.ivykit.plugin.a
    public final com.larus.ivykit.plugin.b a() {
        com.larus.ivykit.plugin.b r100 = new com.larus.ivykit.plugin.b();
        boolean r101 = v19.h.f552477a;
        List<String> r102 = null;
        r100.f351645a = v19.h.a(null);
        com.larus.settings.ivy.webView.b r103 = com.larus.settings.ivy.webView.c.a();
        r100.f351646b = r103.b();
        List<String> r104 = r103.a();
        if (r104 == null) goto L5;
        r102 = CollectionsKt.filterNotNull(r104);
    L5:
        r100.f351647c = r102;
        return r100;
    }
}
