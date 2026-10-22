package com.bytedance.ee.bear.doc.structure.pad;

import android.view.View;
import com.bytedance.ee.bear.doc.structure.Structure;
import com.bytedance.ee.bear.widgets.t;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CatalogListAdapter f218222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Structure.Paragraph f218223d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Function2<? super View, ? super Structure.Paragraph, Unit> r101 = this.f218222c.f218208e;
        if (r101 == null) goto L6;
        r101.invoke(r100, this.f218223d);
        return;
    }

    public a(CatalogListAdapter r100, Structure.Paragraph r101) {
        this.f218222c = r100;
        this.f218223d = r101;
    }
}
