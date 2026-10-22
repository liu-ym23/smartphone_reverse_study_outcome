package com.bytedance.ee.bear.sheet.filter;

import android.view.View;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements UDCheckBox.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilterConditionAdapter.RangeViewHolder f237840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FilterConditionAdapter f237841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f237842c;

    @Override // com.larksuite.component.universe_design.checkbox.UDCheckBox.c
    public final void a(UDCheckBox r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "buttonView");
        View r102 = this.f237840a.f237678d;
        if (r101 == false) goto L5;
        int r103 = 0;
    L6:
        r102.setVisibility(r103);
        if (r101 == false) goto L13;
        FilterConditionAdapter r104 = this.f237841b;
        int r105 = this.f237842c;
        int r106 = r104.f237673c;
        if (r106 == (-1)) goto L11;
        r104.notifyItemChanged(r106);
    L11:
        r104.f237673c = r105;
        this.f237840a.f237679e.requestFocus();
        rcb.c.h(this.f237840a.f237679e, null);
        return;
    L13:
        return;
    L5:
        r103 = 8;
        goto L6
    }

    public c(FilterConditionAdapter.RangeViewHolder r100, FilterConditionAdapter r101, int r102) {
        this.f237840a = r100;
        this.f237841b = r101;
        this.f237842c = r102;
    }
}
