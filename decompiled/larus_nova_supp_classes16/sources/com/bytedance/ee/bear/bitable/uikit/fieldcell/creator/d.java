package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.ee.bear.bitable.common.model.field.NativeCell;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.DateModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.IconTextUIKit;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends com.bytedance.ee.bear.bitable.uikit.fieldcell.b<DateModel> {
    public IconTextUIKit e;

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public String getType() {
        return NativeCell.DATE_TIME.getValue();
    }

    public d(iv4.b r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void g(List<DateModel> r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        IconTextUIKit r2 = this.e;
        if (r2 == null) goto L15;
        h(r2, (DateModel) ListProtector.get(r3, 0));
        return;
    L15:
        return;
    L5:
        if (r3.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View b(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        View r4 = c(r2, r3);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.uikit.fieldcell.IconTextUIKit");
        this.e = (IconTextUIKit) r4;
        return r4;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View c(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        int r3 = ht4.b.a;
        getType();
        return new IconTextUIKit(r1);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final /* bridge */ /* synthetic */ void f(View r1, h0 r2) {
        h(r1, (DateModel) r2);
    }

    public final void h(View r4, DateModel r5) {
        Intrinsics.checkNotNullParameter(r4, "kitView");
        Intrinsics.checkNotNullParameter(r5, "model");
        if ((r4 instanceof IconTextUIKit) == false) goto L12;
        IconTextUIKit r6 = (IconTextUIKit) r4;
        r6.setContent(r5.getText());
        a(r6.getContentTv(), false);
        if (r5.getRemind() == false) goto L10;
        r6.setContentColor(ResourcesCompat.getColor(r6.getContext().getResources(), 2131105548, r6.getContext().getTheme()));
        r6.setRightIconVisible(true);
        Integer r7 = 2131105548;
        if (r7 != null) goto L9;
        r6.b.setImageResource(2131253614);
        return;
    L9:
        r6.b.setImageDrawable(com.bytedance.ee.util.ui.l.a(r6.getContext(), 2131253614, r7.intValue()));
        return;
    L10:
        r6.setContentColor(ResourcesCompat.getColor(r6.getContext().getResources(), 2131109000, r6.getContext().getTheme()));
        r6.setRightIconVisible(false);
        return;
    }
}
