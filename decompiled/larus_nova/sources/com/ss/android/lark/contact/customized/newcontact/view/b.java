package com.ss.android.lark.contact.customized.newcontact.view;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewContactDeleteDialogBuilder f419369a;

    public b(NewContactDeleteDialogBuilder r100) {
        this.f419369a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f419369a.f419347a.invoke();
        Function0<Unit> r101 = this.f419369a.f419351e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dismiss");
        r101 = null;
    L5:
        r101.invoke();
    }
}
