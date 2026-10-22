package com.bytedance.ee.bear.office.common.screenmenu;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ CommonMenu a;

    public a(CommonMenu r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        Function0<Unit> r2 = this.a.h;
        if (r2 == null) goto L6;
        r2.invoke();
        return;
    }
}
