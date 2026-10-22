package br5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiTreeModel;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.d3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.e3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.v2;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.w2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements v2.b {
    public b() {
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.v2.b
    public final d3 a(WikiTreeModel r4) {
        Intrinsics.checkNotNullParameter(r4, "treeModel");
        d3 r0 = new d3();
        e3 r1 = w2.a(r4);
        if (w2.c(r4) == false) goto L5;
        r0.a(r1.k(r1.a));
    L5:
        r0.a(r1.k(r1.b));
        if (w2.e(r4) == false) goto L8;
        r0.a(r1.k(r1.c));
    L8:
        r0.b();
        return r0;
    }
}
