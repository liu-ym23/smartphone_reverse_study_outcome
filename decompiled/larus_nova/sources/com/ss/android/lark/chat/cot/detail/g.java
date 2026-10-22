package com.ss.android.lark.chat.cot.detail;

import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.chat.cot.detail.blueprint.CotDetailBlueprintAdapter;

/* JADX INFO: loaded from: classes35.dex */
public final class g implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f414974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f414975b;

    public g(RecyclerView r100, c r101) {
        this.f414974a = r100;
        this.f414975b = r101;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean r100 = this.f414974a.canScrollVertically(1);
        if (this.f414975b.f414964r == false) goto L11;
        if (r100 == false) goto L12;
        StringBuilder r101 = new StringBuilder("global layout -> retry scroll, followBottom=");
        r101.append(this.f414975b.f414964r);
        r101.append(", canScrollDown=");
        r101.append(r100);
        r101.append(", itemCount=");
        CotDetailBlueprintAdapter r102 = this.f414975b.f414956j;
        if (r102 == null) goto L8;
        Integer r103 = Integer.valueOf(r102.getItemCount());
    L9:
        r101.append(r103);
        com.ss.android.lark.chat.cot.f.c("detail_autoscroll", r101.toString());
        c.a(this.f414975b, "globalLayout");
        return;
    L8:
        r103 = null;
        goto L9
    L12:
        return;
    }
}
