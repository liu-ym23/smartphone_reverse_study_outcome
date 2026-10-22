package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.bitable.common.model.field.NativeCell;
import com.bytedance.ee.bear.bitable.common.widgets.rating.BTRatingBar;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.RatingBarModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class p extends com.bytedance.ee.bear.bitable.uikit.fieldcell.b<RatingBarModel> {
    public final sr4.e e;
    public BTRatingBar f;

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public String getType() {
        return NativeCell.RATINGBAR.getValue();
    }

    public p(iv4.b r4) {
        super(r4);
        this.e = new sr4.e(16, 4, null);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void g(List<RatingBarModel> r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        BTRatingBar r2 = this.f;
        if (r2 == null) goto L15;
        h(r2, (RatingBarModel) ListProtector.get(r3, 0));
        return;
    L15:
        return;
    L5:
        if (r3.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public View b(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        BTRatingBar r4 = c(r2, r3);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.common.widgets.rating.BTRatingBar");
        this.f = r4;
        com.bytedance.ee.bear.bitable.m.f(r4, -1);
        return r4;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View c(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        int r3 = ht4.b.a;
        getType();
        return new CardRatingBar(r1);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final /* bridge */ /* synthetic */ void f(View r1, h0 r2) {
        h(r1, (RatingBarModel) r2);
    }

    public final void h(View r6, RatingBarModel r7) {
        Intrinsics.checkNotNullParameter(r6, "kitView");
        Intrinsics.checkNotNullParameter(r7, "model");
        if ((r6 instanceof BTRatingBar) == false) goto L24;
        Map r0 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.a;
        if (com.bytedance.ee.bear.bitable.common.widgets.rating.a.a.c(r7.getSymbol()) == false) goto L14;
        ArrayList r1 = new ArrayList();
        int r2 = r7.getMinRate();
        int r3 = r7.getMaxRate();
        if (r2 > r3) goto L13;
    L8:
        Map r4 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.a;
        com.bytedance.ee.bear.bitable.common.widgets.rating.a.c r5 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.a.b(String.valueOf(r2));
        if (r5 == null) goto L11;
        r1.add(r5);
    L11:
        if (r2 == r3) goto L13;
        r2 = r2 + 1;
    L13:
        BTRatingBar.a r8 = new BTRatingBar.a();
        r8.e = r7.getRate();
        r8.d = Integer.valueOf(r7.getMinRate());
        r8.c = Integer.valueOf(r7.getMaxRate());
        r8.i = true;
        Boolean r9 = Boolean.FALSE;
        r8.f = r9;
        r8.j = r1;
        r8.g = true;
        r8.k = r9;
        r8.h = this.e;
        ((BTRatingBar) r6).setRatingBarInfo(r8);
        return;
    L14:
        com.bytedance.ee.bear.bitable.common.widgets.rating.a.b r10 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.a.a(r7.getSymbol());
        BTRatingBar r11 = (BTRatingBar) r6;
        BTRatingBar.a r12 = new BTRatingBar.a();
        r12.e = r7.getRate();
        r12.c = Integer.valueOf(r7.getMaxRate());
        r12.d = Integer.valueOf(r7.getMinRate());
        Integer r13 = null;
        if (r10 == null) goto L17;
        Integer r14 = Integer.valueOf(r10.a);
    L18:
        r12.a = r14;
        if (r10 == null) goto L21;
        r13 = Integer.valueOf(r10.b);
    L21:
        r12.b = r13;
        r12.i = false;
        Boolean r16 = Boolean.FALSE;
        r12.f = r16;
        r12.g = true;
        r12.k = r16;
        r12.h = this.e;
        r11.setRatingBarInfo(r12);
        return;
    L17:
        r14 = null;
        goto L18
    }
}
