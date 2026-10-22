package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.ProgressModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.progress.UDProgress;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i extends o {
    public GridProgress f;

    public i(iv4.b r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.o, com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void g(List<ProgressModel> r4) {
        if (r4 == null) goto L7;
        boolean r2 = true;
        if (r4.isEmpty() != true) goto L7;
    L8:
        if (r2 == false) goto L10;
        return;
    L10:
        if (r4 == null) goto L17;
        ProgressModel r5 = (ProgressModel) ListProtector.get(r4, 0);
        if (r5 == null) goto L18;
        GridProgress r0 = this.f;
        if (r0 == null) goto L19;
        h(r0, r5);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.o, com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View b(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        View r5 = c(r3, r4);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.GridProgress");
        this.f = (GridProgress) r5;
        Intrinsics.checkNotNullParameter(r5, "view");
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return r5;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.o, com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View c(Context r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        int r6 = ht4.b.a;
        getType();
        return new GridProgress(r4, null, 6, 0);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.o, com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final /* bridge */ /* synthetic */ void f(View r1, h0 r2) {
        h(r1, (ProgressModel) r2);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.o
    public final void h(View r4, ProgressModel r5) {
        Intrinsics.checkNotNullParameter(r4, "kitView");
        Intrinsics.checkNotNullParameter(r5, "model");
        GridProgress r6 = this.f;
        if (r6 == null) goto L11;
        a(r6.getContentView(), false);
        if (r5 == null) goto L12;
        UDProgress r0 = r6.a;
        if (r0 == null) goto L9;
        r0.setProgress((int) r5.getProgress());
        r0.setIndicatorColor(ColorUtils.h(r5.getColor()));
    L9:
        r6.b.setText(r5.getText());
        return;
    L12:
        return;
    }
}
