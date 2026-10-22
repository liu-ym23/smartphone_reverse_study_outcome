package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.ee.bear.bitable.common.model.field.NativeCell;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class x extends com.bytedance.ee.bear.bitable.uikit.fieldcell.b<h0> {
    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void f(View r2, h0 r3) {
        Intrinsics.checkNotNullParameter(r2, "kitView");
        Intrinsics.checkNotNullParameter(r3, "model");
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public String getType() {
        return NativeCell.NOT_SUPPORT.getValue();
    }

    public x(iv4.b r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View b(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return c(r2, r3);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View c(Context r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        TextView r6 = new TextView(r4);
        r6.setLayoutParams(new LinearLayout.LayoutParams(com.bytedance.ee.util.ui.n.d(16), com.bytedance.ee.util.ui.n.d(4)));
        r6.setBackground(ResourcesCompat.getDrawable(r4.getResources(), 2131232245, r4.getTheme()));
        return r6;
    }
}
