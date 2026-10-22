package com.larus.home.impl.main.side_bar.view.adapter;

import com.larus.platform.model.RecommendFrom;

/* JADX INFO: loaded from: classes29.dex */
public final class f0 {
    public static final String a(wh8.a r100) {
        String r101 = null;
        if (r100 == null) goto L7;
        RecommendFrom r102 = r100.f559713f;
        if (r102 == null) goto L7;
        String r103 = r102.f365482a;
    L9:
        if (com.larus.utils.o0.d(r103) == false) goto L16;
        if (r100 == null) goto L14;
        RecommendFrom r104 = r100.f559713f;
        if (r104 == null) goto L14;
        r101 = r104.f365482a;
    L14:
        if (r101 != null) goto L18;
        return "";
    L18:
        return r101;
    L16:
        return "chat_list";
    L7:
        r103 = null;
        goto L9
    }
}
