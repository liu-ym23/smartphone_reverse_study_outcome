package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.ee.bear.bitable.common.model.field.NativeCell;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.TextModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class q extends com.bytedance.ee.bear.bitable.uikit.fieldcell.b<TextModel> {
    public TextView e;

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public String getType() {
        return NativeCell.RICHTEXT.getValue();
    }

    public q(iv4.b r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void g(List<TextModel> r4) {
        TextView r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r4 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L14;
        r0.setText("");
        return;
    L14:
        h(r0, (TextModel) ListProtector.get(r4, 0));
        return;
    L7:
        if (r4.isEmpty() == true) goto L10;
        r2 = false;
        goto L11
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View b(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        View r4 = c(r2, r3);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.widget.TextView");
        this.e = (TextView) r4;
        return r4;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View c(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        int r3 = ht4.b.a;
        getType();
        TextView r4 = new TextView(r1);
        r4.setGravity(8388611);
        r4.setMaxLines(1);
        r4.setEllipsize(TextUtils.TruncateAt.END);
        int r5 = com.bytedance.ee.bear.bitable.c.a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.content.use_language_user_span_enable") == false) goto L5;
        r4.setSingleLine();
    L5:
        a(r4, false);
        return r4;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public /* bridge */ /* synthetic */ void f(View r1, h0 r2) {
        h(r1, (TextModel) r2);
    }

    public void h(View r3, TextModel r4) {
        Intrinsics.checkNotNullParameter(r3, "kitView");
        Intrinsics.checkNotNullParameter(r4, "model");
        if ((r3 instanceof TextView) == false) goto L9;
        TextView r5 = (TextView) r3;
        a(r5, false);
        db5.a r6 = com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.a.b(r4.getSegments());
        db5.g r7 = new db5.i(r5, null, null).c(r6);
        int r0 = com.bytedance.ee.bear.bitable.c.a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.content.use_language_user_span_enable") == false) goto L7;
        r5.setText(r7.a, TextView.BufferType.SPANNABLE);
        return;
    L7:
        r5.setText(r7.a);
        return;
    }
}
