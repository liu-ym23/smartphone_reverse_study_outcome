package com.ss.android.lark.widget.timepicker;

import android.view.View;
import com.ss.android.lark.widget.timepicker.monthview.MonthViewContainer;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TimeSelectFragment f448995a;

    public f(TimeSelectFragment r100) {
        this.f448995a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        MonthViewContainer r101 = this.f448995a.f448974s;
        if (r101 == null) goto L5;
        r101.c();
    L5:
        this.f448995a.ca0();
    }
}
