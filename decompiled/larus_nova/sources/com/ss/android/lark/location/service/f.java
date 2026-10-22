package com.ss.android.lark.location.service;

import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes36.dex */
public final /* synthetic */ class f {
    static {
        int r100 = g.f431202a;
    }

    public static g a() {
        ArrayList r100 = new ArrayList();
        Iterator r101 = ClaymoreServiceLoader.loadAll(g.class);
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.add((g) r101.next());
        goto L4
    L6:
        Collections.sort(r100, new e());
        return (g) ListProtector.get(r100, 0);
    }
}
