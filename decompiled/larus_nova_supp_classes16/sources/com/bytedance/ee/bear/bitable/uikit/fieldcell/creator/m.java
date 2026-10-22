package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.ee.bear.bitable.common.model.field.NativeCell;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.LinkModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class m extends com.bytedance.ee.bear.bitable.uikit.fieldcell.b<LinkModel> {
    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public String getType() {
        return NativeCell.LINK.getValue();
    }

    public m(iv4.b r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public Drawable e(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return ResourcesCompat.getDrawable(r3.getResources(), 2131232246, r3.getTheme());
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public View c(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        int r5 = ht4.b.a;
        getType();
        TextView r6 = new TextView(r3);
        r6.setBackground(e(r3));
        r6.setGravity(17);
        r6.setIncludeFontPadding(false);
        r6.setEllipsize(TextUtils.TruncateAt.END);
        r6.setMaxLines(1);
        r6.setPadding(com.bytedance.ee.util.ui.n.d(8), 0, com.bytedance.ee.util.ui.n.d(8), 0);
        com.bytedance.ee.bear.bitable.m.e(r6, com.bytedance.ee.util.ui.n.d(24));
        return r6;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public /* bridge */ /* synthetic */ void f(View r1, h0 r2) {
        h(r1, (LinkModel) r2);
    }

    public void h(View r2, LinkModel r3) {
        Intrinsics.checkNotNullParameter(r2, "kitView");
        Intrinsics.checkNotNullParameter(r3, "model");
        if ((r2 instanceof TextView) == false) goto L6;
        TextView r4 = (TextView) r2;
        a(r4, true);
        r4.setText(r3.getText());
        return;
    }
}
