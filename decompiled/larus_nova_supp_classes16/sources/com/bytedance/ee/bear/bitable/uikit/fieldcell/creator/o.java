package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.bitable.common.model.field.NativeCell;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.ProgressModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.progress.UDProgress;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class o extends com.bytedance.ee.bear.bitable.uikit.fieldcell.b<ProgressModel> {
    public UDProgress e;

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public String getType() {
        return NativeCell.PROGRESS.getValue();
    }

    public o(iv4.b r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public void g(List<ProgressModel> r4) {
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
        UDProgress r0 = this.e;
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

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public View b(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        UDProgress r5 = c(r3, r4);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larksuite.component.universe_design.progress.UDProgress");
        this.e = r5;
        Intrinsics.checkNotNullParameter(r5, "view");
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return r5;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public View c(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        int r4 = ht4.b.a;
        getType();
        UDProgress r5 = new UDProgress(r2);
        r5.setIndicatorCornerRadius(com.bytedance.ee.util.ui.n.d(4));
        r5.setThickness(com.bytedance.ee.util.ui.n.d(8));
        r5.setTrackColor(r2.getResources().getColor(2131100549));
        return r5;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public /* bridge */ /* synthetic */ void f(View r1, h0 r2) {
        h(r1, (ProgressModel) r2);
    }

    public void h(View r3, ProgressModel r4) {
        Intrinsics.checkNotNullParameter(r3, "kitView");
        Intrinsics.checkNotNullParameter(r4, "model");
        UDProgress r5 = this.e;
        if (r5 == null) goto L6;
        r5.setProgress((int) r4.getProgress());
        r5.setIndicatorColor(ColorUtils.h(r4.getColor()));
        return;
    }
}
