package com.bytedance.ee.bear.office.common.screenmenu;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonMenu f235196a;

    public a(CommonMenu r100) {
        this.f235196a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function0<Unit> r101 = this.f235196a.f235159h;
        if (r101 == null) goto L6;
        r101.invoke();
        return;
    }
}
