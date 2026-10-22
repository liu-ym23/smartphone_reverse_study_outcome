package com.bytedance.ee.bear.bitable.msgcenter.view;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes15.dex */
public final class j implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FooterModel f214743a;

    public j(FooterModel r100) {
        this.f214743a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function0<Unit> r101 = this.f214743a.getOnOpenHistory();
        if (r101 == null) goto L6;
        r101.invoke();
        return;
    }
}
