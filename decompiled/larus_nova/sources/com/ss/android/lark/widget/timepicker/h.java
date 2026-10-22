package com.ss.android.lark.widget.timepicker;

import android.view.View;
import android.widget.CheckBox;

/* JADX INFO: loaded from: classes38.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TimeSelectFragment f448997a;

    public h(TimeSelectFragment r100) {
        this.f448997a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        CheckBox r101 = this.f448997a.f448973r;
        if (r101 == null) goto L6;
        r101.toggle();
        return;
    }
}
