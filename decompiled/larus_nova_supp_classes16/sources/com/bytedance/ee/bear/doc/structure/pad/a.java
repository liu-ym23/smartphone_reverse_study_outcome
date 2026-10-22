package com.bytedance.ee.bear.doc.structure.pad;

import android.view.View;
import com.bytedance.ee.bear.doc.structure.Structure;
import com.bytedance.ee.bear.widgets.t;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends t {
    public final /* synthetic */ CatalogListAdapter c;
    public final /* synthetic */ Structure.Paragraph d;

    public final void a(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        Function2<? super View, ? super Structure.Paragraph, Unit> r0 = this.c.e;
        if (r0 == null) goto L6;
        r0.invoke(r3, this.d);
        return;
    }

    public a(CatalogListAdapter r1, Structure.Paragraph r2) {
        this.c = r1;
        this.d = r2;
    }
}
