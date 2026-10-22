package com.bytedance.ee.bear.bitable.card.view.cell.select;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class n0 implements t.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SelectEditPanel f208151a;

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.t.a
    public final /* synthetic */ void c(int r100) {
    }

    public n0(SelectEditPanel r100) {
        this.f208151a = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.t.a
    public final void a(String r100) {
        if (r100 == null) goto L5;
        this.f208151a.l(r100, true);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.t.a
    public final com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "optionContent");
        return SelectEditPanel.x(this.f208151a, r100);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.t.a
    public final void d(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "optionContent");
        SelectEditPanel.w(this.f208151a, r100, r101, false);
    }
}
