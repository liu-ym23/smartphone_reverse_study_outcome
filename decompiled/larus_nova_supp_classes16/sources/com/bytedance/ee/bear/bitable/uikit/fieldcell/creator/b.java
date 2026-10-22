package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.ee.bear.bitable.common.model.field.NativeCell;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.ButtonModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.button.UDButton;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class b extends com.bytedance.ee.bear.bitable.uikit.fieldcell.b<ButtonModel> {
    public UDButton e;

    public void h(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public String getType() {
        return NativeCell.BUTTON.getValue();
    }

    public b(iv4.b r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void g(List<ButtonModel> r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        UDButton r2 = this.e;
        if (r2 == null) goto L15;
        i(r2, (ButtonModel) ListProtector.get(r3, 0));
        return;
    L15:
        return;
    L5:
        if (r3.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public static void i(View r1, ButtonModel r2) {
        Intrinsics.checkNotNullParameter(r1, "kitView");
        Intrinsics.checkNotNullParameter(r2, "model");
        UDButton r3 = (UDButton) r1;
        r3.setText(r2.getText());
        r3.setBackgroundColor(ColorUtils.h(r2.getBackground()));
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View b(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        UDButton r4 = c(r2, r3);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.larksuite.component.universe_design.button.UDButton");
        this.e = r4;
        h(r4);
        return r4;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View c(Context r7, ViewGroup r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        int r9 = ht4.b.a;
        getType();
        UDButton r10 = new UDButton(r7, null, 0, 6, null);
        com.bytedance.ee.bear.bitable.m.e(r10, com.bytedance.ee.util.ui.n.d(24));
        r10.setMinWidth(com.bytedance.ee.util.ui.n.d(68));
        r10.setPadding(com.bytedance.ee.util.ui.n.d(4), 0, com.bytedance.ee.util.ui.n.d(4), 0);
        r10.setGravity(17);
        r10.setCornerRadius(com.bytedance.ee.util.ui.n.d(6));
        r10.setTextSize(12.0f);
        r10.setTextColor(ResourcesCompat.getColor(r7.getResources(), 2131109391, r7.getTheme()));
        r10.setMaxLines(1);
        r10.setEllipsize(TextUtils.TruncateAt.END);
        return r10;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final /* bridge */ /* synthetic */ void f(View r1, h0 r2) {
        i(r1, (ButtonModel) r2);
    }
}
