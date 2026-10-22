package com.bytedance.ee.bear.sheet.filter;

import android.view.View;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements UDCheckBox.c {
    public final /* synthetic */ FilterConditionAdapter.RangeViewHolder a;
    public final /* synthetic */ FilterConditionAdapter b;
    public final /* synthetic */ int c;

    public final void a(UDCheckBox r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "buttonView");
        View r5 = this.a.d;
        if (r4 == false) goto L5;
        int r0 = 0;
    L6:
        r5.setVisibility(r0);
        if (r4 == false) goto L13;
        FilterConditionAdapter r6 = this.b;
        int r7 = this.c;
        int r1 = r6.c;
        if (r1 == (-1)) goto L11;
        r6.notifyItemChanged(r1);
    L11:
        r6.c = r7;
        this.a.e.requestFocus();
        rcb.c.h(this.a.e, null);
        return;
    L13:
        return;
    L5:
        r0 = 8;
        goto L6
    }

    public c(FilterConditionAdapter.RangeViewHolder r1, FilterConditionAdapter r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
