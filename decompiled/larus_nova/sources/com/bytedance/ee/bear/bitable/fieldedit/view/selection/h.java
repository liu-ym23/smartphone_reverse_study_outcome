package com.bytedance.ee.bear.bitable.fieldedit.view.selection;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes15.dex */
public final class h implements BitableFieldTypeSelectionFragment.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f211698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BitableFieldTypeSelectionFragment f211699b;

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.selection.BitableFieldTypeSelectionFragment.b
    public final void a() {
        this.f211698a.invoke();
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.selection.BitableFieldTypeSelectionFragment.b
    public final void b() {
        m r100 = this.f211699b.f211678m;
        if (r100 == null) goto L6;
        r100.setChecked(true);
        return;
    }

    public h(Function0<Unit> r100, BitableFieldTypeSelectionFragment r101) {
        this.f211698a = r100;
        this.f211699b = r101;
    }
}
