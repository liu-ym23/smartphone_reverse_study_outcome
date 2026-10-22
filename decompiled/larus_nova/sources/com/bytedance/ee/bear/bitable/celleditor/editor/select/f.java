package com.bytedance.ee.bear.bitable.celleditor.editor.select;

import com.bytedance.ee.bear.bitable.card.view.cell.select.q;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f209468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SelectEditorModel f209469b;

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.q
    public final void J0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        BitableAnalytic r101 = this.f209468a.f209472d.f486862d;
        r101.getClass();
        r101.t(r100, new HashMap());
    }

    public f(h r100, SelectEditorModel r101) {
        this.f209468a = r100;
        this.f209469b = r101;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.q
    public final void y2(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "clickType");
        EFieldUIType.a r102 = EFieldUIType.Companion;
        String r103 = this.f209469b.getFieldUIType();
        r102.getClass();
        FieldCompositeType r104 = new FieldCompositeType(null, EFieldUIType.a.a(r103));
        this.f209468a.f209472d.f486862d.D(r100, r101, r104);
    }
}
