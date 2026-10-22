package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.SegmentModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.TextModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f extends q {
    public f(iv4.b r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.q, com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final /* bridge */ /* synthetic */ void f(View r1, h0 r2) {
        h(r1, (TextModel) r2);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.q
    public final void h(View r6, TextModel r7) {
        Intrinsics.checkNotNullParameter(r6, "kitView");
        Intrinsics.checkNotNullParameter(r7, "model");
        if ((r6 instanceof TextView) == false) goto L26;
        TextView r8 = (TextView) r6;
        boolean r0 = false;
        a(r8, false);
        db5.a r1 = com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.a.b(r7.getSegments());
        ArrayList<SegmentModel> r9 = r7.getSegments();
        if (r9 != null) goto L7;
        Boolean r10 = null;
    L19:
        if (Intrinsics.areEqual(r10, Boolean.TRUE) == false) goto L21;
        r8.setText(r1.a);
        return;
    L21:
        db5.g r11 = new db5.i(r8, new eq4.a(r8.getContext()), null).c(r1);
        r8.setMovementMethod(new LinkMovementMethod());
        r8.setSingleLine();
        r8.setText(r11.a);
        return;
    L7:
        if (r9.isEmpty() == true) goto L15;
        Iterator<T> r12 = r9.iterator();
    L11:
        if (r12.hasNext() == false) goto L15;
        if (TextUtils.equals("text", ((SegmentModel) r12.next()).type) == true) goto L11;
    L16:
        r10 = Boolean.valueOf(r0);
    L15:
        r0 = true;
        goto L16
    }
}
